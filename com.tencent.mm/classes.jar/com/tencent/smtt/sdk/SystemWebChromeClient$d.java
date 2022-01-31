package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebChromeClient$d
  implements com.tencent.smtt.export.external.interfaces.JsPromptResult
{
  android.webkit.JsPromptResult a;
  
  SystemWebChromeClient$d(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.JsPromptResult paramJsPromptResult)
  {
    this.a = paramJsPromptResult;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(64165);
    this.a.cancel();
    AppMethodBeat.o(64165);
  }
  
  public void confirm()
  {
    AppMethodBeat.i(64166);
    this.a.confirm();
    AppMethodBeat.o(64166);
  }
  
  public void confirm(String paramString)
  {
    AppMethodBeat.i(64167);
    this.a.confirm(paramString);
    AppMethodBeat.o(64167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.d
 * JD-Core Version:    0.7.0.1
 */