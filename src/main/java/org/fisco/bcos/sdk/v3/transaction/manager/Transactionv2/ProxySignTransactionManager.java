package org.fisco.bcos.sdk.v3.transaction.manager.Transactionv2;

import java.math.BigInteger;
import org.fisco.bcos.sdk.v3.client.Client;
import org.fisco.bcos.sdk.v3.client.protocol.response.Call;
import org.fisco.bcos.sdk.v3.crypto.CryptoSuite;
import org.fisco.bcos.sdk.v3.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.v3.model.TransactionReceipt;
import org.fisco.bcos.sdk.v3.model.callback.InjectFetcher;
import org.fisco.bcos.sdk.v3.model.callback.RespCallback;
import org.fisco.bcos.sdk.v3.model.callback.TransactionCallback;
import org.fisco.bcos.sdk.v3.transaction.signer.AsyncTransactionSignercInterface;
import org.fisco.bcos.sdk.v3.transaction.signer.TransactionJniSignerService;
import org.fisco.bcos.sdk.v3.transaction.signer.TransactionSignerInterface;

/**
 * ProxySignTransactionManager: customizable signer method, default use JNI signer. customizable key
 * pair to sign, default use client key pair.
 */
public class ProxySignTransactionManager extends TransactionManager {

    private TransactionSignerInterface txSigner = null;

    private AsyncTransactionSignercInterface asyncTxSigner = null;
    private InjectFetcher<CryptoKeyPair> keyPairFetcher;

    public ProxySignTransactionManager(Client client) {
        super(client);
        txSigner = new TransactionJniSignerService();
    }

    public ProxySignTransactionManager(Client client, TransactionSignerInterface txSigner) {
        super(client);
        this.txSigner = txSigner;
    }

    public ProxySignTransactionManager(
            Client client, AsyncTransactionSignercInterface asyncTxSigner) {
        super(client);
        this.asyncTxSigner = asyncTxSigner;
    }

    public void setTransactionSigner(TransactionSignerInterface signerInterface) {
        this.txSigner = signerInterface;
    }

    /**
     * Send tx with abi field
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     *     contract
     * @param constructor if you deploy contract, should set to be true
     * @return receipt
     */
    @Override
    protected TransactionReceipt sendTransaction(
            String to, String data, BigInteger value, String abi, boolean constructor) {
        return sendTransaction(this.client.getCryptoSuite(), to, data, value, abi, constructor);
    }

    public TransactionReceipt sendTransaction(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            String abi,
            boolean constructor) {
        return sendTransaction(
                cryptoSuite,
                to,
                data,
                value,
                BigInteger.ONE,
                TransferTransactionService.GAS_LIMIT,
                abi,
                constructor);
    }

    /**
     * Send tx with gasPrice and gasLimit fields
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param gasPrice price of gas
     * @param gasLimit use limit of gas
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     *     contract
     * @param constructor if you deploy contract, should set to be true
     * @return receipt
     */
    @Override
    protected TransactionReceipt sendTransaction(
            String to,
            String data,
            BigInteger value,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String abi,
            boolean constructor) {
        return sendTransaction(
                this.client.getCryptoSuite(),
                to,
                data,
                value,
                gasPrice,
                gasLimit,
                abi,
                constructor);
    }

    public TransactionReceipt sendTransaction(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String abi,
            boolean constructor) {
        return null;
    }

    /**
     * Send tx with gasPrice and gasLimit fields
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param gasPrice price of gas
     * @param gasLimit use limit of gas
     * @param blockLimit block limit
     * @param nonce tx nonce, for avoiding tx replay attack
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     *     contract
     * @param constructor if you deploy contract, should set to be true
     * @return receipt
     */
    @Override
    protected TransactionReceipt sendTransaction(
            String to,
            String data,
            BigInteger value,
            BigInteger gasPrice,
            BigInteger gasLimit,
            BigInteger blockLimit,
            BigInteger nonce,
            String abi,
            boolean constructor) {
        return sendTransaction(
                this.client.getCryptoSuite(),
                to,
                data,
                value,
                gasPrice,
                gasLimit,
                blockLimit,
                nonce,
                abi,
                constructor);
    }

    protected TransactionReceipt sendTransaction(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            BigInteger gasPrice,
            BigInteger gasLimit,
            BigInteger blockLimit,
            BigInteger nonce,
            String abi,
            boolean constructor) {
        return null;
    }

    /**
     * Send tx with abi field asynchronously
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     *     contract
     * @param constructor if you deploy contract, should set to be true
     * @param callback callback function
     * @return receipt
     */
    @Override
    protected String asyncSendTransaction(
            String to,
            String data,
            BigInteger value,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return asyncSendTransaction(
                this.client.getCryptoSuite(), to, data, value, abi, constructor, callback);
    }

    public String asyncSendTransaction(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return null;
    }

    /**
     * Send tx with gasPrice and gasLimit fields asynchronously
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param gasPrice price of gas
     * @param gasLimit use limit of gas
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     *     contract
     * @param constructor if you deploy contract, should set to be true
     * @param callback callback function
     * @return receipt
     */
    @Override
    protected String asyncSendTransaction(
            String to,
            String data,
            BigInteger value,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return asyncSendTransaction(
                this.client.getCryptoSuite(),
                to,
                data,
                value,
                gasPrice,
                gasLimit,
                abi,
                constructor,
                callback);
    }

    public String asyncSendTransaction(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            BigInteger gasPrice,
            BigInteger gasLimit,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return null;
    }

    /**
     * Send tx with blockLimit and nonce fields asynchronously
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param blockLimit block limit
     * @param nonce tx nonce, for avoiding tx replay attack
     * @param callback callback function
     * @return receipt
     */
    @Override
    protected String asyncSendTransaction(
            String to,
            String data,
            BigInteger value,
            BigInteger blockLimit,
            BigInteger nonce,
            TransactionCallback callback) {
        return null;
    }

    public String asyncSendTransaction(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            BigInteger blockLimit,
            BigInteger nonce,
            TransactionCallback callback) {
        return null;
    }

    /**
     * Send tx with gasPrice and gasLimit fields asynchronously
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param gasPrice price of gas
     * @param gasLimit use limit of gas
     * @param blockLimit block limit
     * @param nonce tx nonce, for avoiding tx replay attack
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     *     contract
     * @param constructor if you deploy contract, should set to be true
     * @param callback callback function
     * @return receipt
     */
    @Override
    protected String asyncSendTransaction(
            String to,
            String data,
            BigInteger value,
            BigInteger gasPrice,
            BigInteger gasLimit,
            BigInteger blockLimit,
            BigInteger nonce,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return null;
    }

    public String asyncSendTransaction(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            BigInteger gasPrice,
            BigInteger gasLimit,
            BigInteger blockLimit,
            BigInteger nonce,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return null;
    }

    /**
     * Send tx with EIP1559
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param eip1559Struct EIP1559 transaction payload
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     *     contract
     * @param constructor if you deploy contract, should set to be true
     * @return receipt
     */
    @Override
    protected TransactionReceipt sendTransactionEIP1559(
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            String abi,
            boolean constructor) {
        return null;
    }

    public TransactionReceipt sendTransactionEIP1559(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            String abi,
            boolean constructor) {
        return null;
    }

    /**
     * Send tx with EIP1559
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param eip1559Struct EIP1559 transaction payload
     * @param blockLimit block limit
     * @param nonce tx nonce, for avoiding tx replay attack
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     * @param constructor if you deploy contract, should set to be true
     * @return receipt
     */
    @Override
    protected TransactionReceipt sendTransactionEIP1559(
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            BigInteger blockLimit,
            BigInteger nonce,
            String abi,
            boolean constructor) {
        return null;
    }

    public TransactionReceipt sendTransactionEIP1559(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            BigInteger blockLimit,
            BigInteger nonce,
            String abi,
            boolean constructor) {
        return null;
    }

    /**
     * Send tx with EIP1559 asynchronously
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param eip1559Struct EIP1559 transaction payload
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     *     contract
     * @param constructor if you deploy contract, should set to be true
     * @param callback callback function
     * @return receipt
     */
    @Override
    protected String asyncSendTransactionEIP1559(
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return null;
    }

    public String asyncSendTransactionEIP1559(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return null;
    }

    /**
     * Send tx with EIP1559 asynchronously
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param eip1559Struct EIP1559 transaction payload
     * @param blockLimit block limit
     * @param nonce tx nonce, for avoiding tx replay attack
     * @param callback callback function
     * @return receipt
     */
    @Override
    protected String asyncSendTransactionEIP1559(
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            BigInteger blockLimit,
            BigInteger nonce,
            TransactionCallback callback) {
        return null;
    }

    public String asyncSendTransactionEIP1559(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            BigInteger blockLimit,
            BigInteger nonce,
            TransactionCallback callback) {
        return null;
    }

    /**
     * Send tx with EIP1559 asynchronously
     *
     * @param to to address
     * @param data input data
     * @param value transfer value
     * @param eip1559Struct EIP1559 transaction payload
     * @param blockLimit block limit
     * @param nonce tx nonce, for avoiding tx replay attack
     * @param abi ABI JSON string, generated by compile contract, should fill in when you deploy
     * @param constructor if you deploy contract, should set to be true
     * @param callback callback function
     * @return receipt
     */
    @Override
    protected String asyncSendTransactionEIP1559(
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            BigInteger blockLimit,
            BigInteger nonce,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return null;
    }

    public String asyncSendTransactionEIP1559(
            CryptoSuite cryptoSuite,
            String to,
            String data,
            BigInteger value,
            EIP1559Struct eip1559Struct,
            BigInteger blockLimit,
            BigInteger nonce,
            String abi,
            boolean constructor,
            TransactionCallback callback) {
        return null;
    }

    /**
     * Send call
     *
     * @param to to address
     * @param data input data
     * @return call result
     */
    @Override
    protected Call sendCall(String to, String data) {
        return null;
    }

    /**
     * Send call with signature of call data
     *
     * @param to to address
     * @param data input data
     * @param signature signature of call data
     */
    @Override
    protected Call sendCall(String to, String data, String signature) {
        return null;
    }

    /**
     * Send call asynchronously
     *
     * @param to to address
     * @param data input data
     * @param callback callback function
     */
    @Override
    protected void asyncSendCall(String to, String data, RespCallback<Call> callback) {}

    /**
     * Send call asynchronously with signature of call data
     *
     * @param to to address
     * @param data input data
     * @param signature signature of call data
     * @param callback callback function
     */
    @Override
    protected void asyncSendCall(
            String to, String data, String signature, RespCallback<Call> callback) {}
}