package com.tencent.xweb.sys;

import android.webkit.HttpAuthHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

public final class c$b
  implements j
{
  HttpAuthHandler MtP;
  
  public c$b(HttpAuthHandler paramHttpAuthHandler)
  {
    this.MtP = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(195506);
    this.MtP.cancel();
    AppMethodBeat.o(195506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.b
 * JD-Core Version:    0.7.0.1
 */