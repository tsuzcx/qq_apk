package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class z
  implements ValueCallback<String[]>
{
  z(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(139126);
    this.a.onReceiveValue(paramArrayOfString);
    AppMethodBeat.o(139126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.z
 * JD-Core Version:    0.7.0.1
 */