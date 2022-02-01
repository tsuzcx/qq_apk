package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebChromeClient$4
  implements ValueCallback<Uri[]>
{
  SystemWebChromeClient$4(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(Uri[] paramArrayOfUri)
  {
    AppMethodBeat.i(54940);
    this.a.onReceiveValue(paramArrayOfUri);
    AppMethodBeat.o(54940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.4
 * JD-Core Version:    0.7.0.1
 */