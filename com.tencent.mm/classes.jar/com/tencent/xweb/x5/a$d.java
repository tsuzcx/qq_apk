package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$d<T>
  implements com.tencent.smtt.sdk.ValueCallback<T>
{
  android.webkit.ValueCallback<T> aimT;
  
  public a$d(android.webkit.ValueCallback<T> paramValueCallback)
  {
    this.aimT = paramValueCallback;
  }
  
  public final void onReceiveValue(T paramT)
  {
    AppMethodBeat.i(153816);
    if (this.aimT != null) {
      this.aimT.onReceiveValue(paramT);
    }
    AppMethodBeat.o(153816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.a.d
 * JD-Core Version:    0.7.0.1
 */