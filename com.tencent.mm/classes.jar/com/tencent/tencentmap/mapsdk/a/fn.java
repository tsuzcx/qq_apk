package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class fn
  implements HostnameVerifier
{
  private String a;
  
  public fn(String paramString)
  {
    this.a = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((TextUtils.isEmpty(this.a)) || (!(paramObject instanceof fn))) {}
    do
    {
      return false;
      paramObject = ((fn)paramObject).a;
    } while (TextUtils.isEmpty(paramObject));
    return this.a.equals(paramObject);
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fn
 * JD-Core Version:    0.7.0.1
 */