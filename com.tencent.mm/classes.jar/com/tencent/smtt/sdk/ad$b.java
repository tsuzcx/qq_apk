package com.tencent.smtt.sdk;

class ad$b
  implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler
{
  private android.webkit.HttpAuthHandler a;
  
  ad$b(android.webkit.HttpAuthHandler paramHttpAuthHandler)
  {
    this.a = paramHttpAuthHandler;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void proceed(String paramString1, String paramString2)
  {
    this.a.proceed(paramString1, paramString2);
  }
  
  public boolean useHttpAuthUsernamePassword()
  {
    return this.a.useHttpAuthUsernamePassword();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ad.b
 * JD-Core Version:    0.7.0.1
 */