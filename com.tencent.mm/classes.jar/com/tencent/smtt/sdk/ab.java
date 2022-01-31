package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ab
  implements ValueCallback<Uri>
{
  ab(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(Uri paramUri)
  {
    AppMethodBeat.i(139129);
    this.a.onReceiveValue(paramUri);
    AppMethodBeat.o(139129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ab
 * JD-Core Version:    0.7.0.1
 */