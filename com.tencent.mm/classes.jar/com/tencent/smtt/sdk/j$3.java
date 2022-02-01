package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class j$3
  implements ValueCallback<Uri[]>
{
  j$3(j paramj, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(Uri[] paramArrayOfUri)
  {
    AppMethodBeat.i(188303);
    this.a.onReceiveValue(paramArrayOfUri);
    AppMethodBeat.o(188303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.j.3
 * JD-Core Version:    0.7.0.1
 */