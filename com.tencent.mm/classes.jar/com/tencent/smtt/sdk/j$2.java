package com.tencent.smtt.sdk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

class j$2
  implements ValueCallback<Uri>
{
  j$2(j paramj, android.webkit.ValueCallback paramValueCallback) {}
  
  public void a(Uri paramUri)
  {
    AppMethodBeat.i(188183);
    this.a.onReceiveValue(new Uri[] { paramUri });
    AppMethodBeat.o(188183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.j.2
 * JD-Core Version:    0.7.0.1
 */