package com.tencent.smtt.sdk;

class ad$c
  implements com.tencent.smtt.export.external.interfaces.SslErrorHandler
{
  android.webkit.SslErrorHandler a;
  
  ad$c(android.webkit.SslErrorHandler paramSslErrorHandler)
  {
    this.a = paramSslErrorHandler;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void proceed()
  {
    this.a.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ad.c
 * JD-Core Version:    0.7.0.1
 */