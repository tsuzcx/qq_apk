package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebChromeClient$3
  implements ValueCallback<Uri>
{
  SystemWebChromeClient$3(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(Uri paramUri)
  {
    AppMethodBeat.i(54333);
    this.a.onReceiveValue(paramUri);
    AppMethodBeat.o(54333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.3
 * JD-Core Version:    0.7.0.1
 */