package com.tencent.xweb.xwalk.a;

import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

final class f$d
{
  private static TrustManager xnA = new f.d.1();
  public static final HostnameVerifier xnB = new f.d.2();
  
  public static SSLContext cTX()
  {
    Object localObject = null;
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localObject = localSSLContext;
      TrustManager localTrustManager = xnA;
      localObject = localSSLContext;
      SecureRandom localSecureRandom = new SecureRandom();
      localObject = localSSLContext;
      localSSLContext.init(null, new TrustManager[] { localTrustManager }, localSecureRandom);
      return localSSLContext;
    }
    catch (Exception localException) {}
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.f.d
 * JD-Core Version:    0.7.0.1
 */