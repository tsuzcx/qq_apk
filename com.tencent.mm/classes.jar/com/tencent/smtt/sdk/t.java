package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class t
  implements ValueCallback<Uri>
{
  t(r paramr, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(Uri paramUri)
  {
    AppMethodBeat.i(139059);
    this.a.onReceiveValue(new Uri[] { paramUri });
    AppMethodBeat.o(139059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.t
 * JD-Core Version:    0.7.0.1
 */