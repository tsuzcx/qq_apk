package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(64168);
    this.a.cancel();
    AppMethodBeat.o(64168);
  }
  
  public void confirm()
  {
    AppMethodBeat.i(64169);
    this.a.confirm();
    AppMethodBeat.o(64169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.e
 * JD-Core Version:    0.7.0.1
 */