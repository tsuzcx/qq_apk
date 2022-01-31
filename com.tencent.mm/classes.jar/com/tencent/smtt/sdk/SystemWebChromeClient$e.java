package com.tencent.smtt.sdk;

class SystemWebChromeClient$e
  implements com.tencent.smtt.export.external.interfaces.JsResult
{
  android.webkit.JsResult a;
  
  SystemWebChromeClient$e(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.JsResult paramJsResult)
  {
    this.a = paramJsResult;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void confirm()
  {
    this.a.confirm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.e
 * JD-Core Version:    0.7.0.1
 */