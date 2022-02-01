package com.tencent.xweb.sys;

import android.webkit.HttpAuthHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

public final class c$b
  implements j
{
  HttpAuthHandler KDp;
  
  public c$b(HttpAuthHandler paramHttpAuthHandler)
  {
    this.KDp = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(208875);
    this.KDp.cancel();
    AppMethodBeat.o(208875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.b
 * JD-Core Version:    0.7.0.1
 */