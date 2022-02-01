package com.tencent.xweb.sys;

import android.webkit.HttpAuthHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

public final class c$b
  implements j
{
  HttpAuthHandler aafi;
  
  public c$b(HttpAuthHandler paramHttpAuthHandler)
  {
    this.aafi = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(204948);
    this.aafi.cancel();
    AppMethodBeat.o(204948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.b
 * JD-Core Version:    0.7.0.1
 */