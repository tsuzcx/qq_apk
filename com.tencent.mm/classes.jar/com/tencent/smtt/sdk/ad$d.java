package com.tencent.smtt.sdk;

import android.net.http.SslCertificate;

class ad$d
  implements com.tencent.smtt.export.external.interfaces.SslError
{
  android.net.http.SslError a;
  
  ad$d(android.net.http.SslError paramSslError)
  {
    this.a = paramSslError;
  }
  
  public boolean addError(int paramInt)
  {
    return this.a.addError(paramInt);
  }
  
  public SslCertificate getCertificate()
  {
    return this.a.getCertificate();
  }
  
  public int getPrimaryError()
  {
    return this.a.getPrimaryError();
  }
  
  public boolean hasError(int paramInt)
  {
    return this.a.hasError(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ad.d
 * JD-Core Version:    0.7.0.1
 */