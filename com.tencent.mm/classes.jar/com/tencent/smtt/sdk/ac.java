package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ac
  implements ValueCallback<Uri[]>
{
  ac(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(Uri[] paramArrayOfUri)
  {
    AppMethodBeat.i(139130);
    this.a.onReceiveValue(paramArrayOfUri);
    AppMethodBeat.o(139130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.ac
 * JD-Core Version:    0.7.0.1
 */