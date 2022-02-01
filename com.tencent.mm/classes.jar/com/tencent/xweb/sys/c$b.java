package com.tencent.xweb.sys;

import android.webkit.HttpAuthHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.l;

public final class c$b
  implements l
{
  HttpAuthHandler aimc;
  
  public c$b(HttpAuthHandler paramHttpAuthHandler)
  {
    this.aimc = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(212661);
    this.aimc.cancel();
    AppMethodBeat.o(212661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.c.b
 * JD-Core Version:    0.7.0.1
 */