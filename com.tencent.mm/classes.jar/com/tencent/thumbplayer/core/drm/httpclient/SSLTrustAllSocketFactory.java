package com.tencent.thumbplayer.core.drm.httpclient;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSLTrustAllSocketFactory
  extends SSLSocketFactory
{
  private static final String TAG = "SSLTrustAllSocketFactory";
  private SSLContext mCtx;
  
  public SSLTrustAllSocketFactory()
  {
    AppMethodBeat.i(193874);
    try
    {
      this.mCtx = SSLContext.getInstance("TLS");
      this.mCtx.init(null, new TrustManager[] { new SSLTrustAllManager() }, null);
      AppMethodBeat.o(193874);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(193874);
    }
  }
  
  public Socket createSocket()
  {
    AppMethodBeat.i(193875);
    Socket localSocket = this.mCtx.getSocketFactory().createSocket();
    AppMethodBeat.o(193875);
    return localSocket;
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return null;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(193876);
    paramSocket = this.mCtx.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    AppMethodBeat.o(193876);
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return null;
  }
  
  public String[] getSupportedCipherSuites()
  {
    return null;
  }
  
  public class SSLTrustAllManager
    implements X509TrustManager
  {
    public SSLTrustAllManager() {}
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.SSLTrustAllSocketFactory
 * JD-Core Version:    0.7.0.1
 */