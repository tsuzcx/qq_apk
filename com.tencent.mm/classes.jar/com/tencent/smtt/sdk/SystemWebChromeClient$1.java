package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebChromeClient$1
  implements ValueCallback<String[]>
{
  SystemWebChromeClient$1(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(54566);
    this.a.onReceiveValue(paramArrayOfString);
    AppMethodBeat.o(54566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.1
 * JD-Core Version:    0.7.0.1
 */