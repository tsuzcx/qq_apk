package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class u
  implements ValueCallback<Uri[]>
{
  u(r paramr, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(Uri[] paramArrayOfUri)
  {
    AppMethodBeat.i(139060);
    this.a.onReceiveValue(paramArrayOfUri);
    AppMethodBeat.o(139060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.u
 * JD-Core Version:    0.7.0.1
 */