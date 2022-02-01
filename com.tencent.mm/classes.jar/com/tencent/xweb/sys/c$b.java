package com.tencent.xweb.sys;

import android.webkit.HttpAuthHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

public final class c$b
  implements j
{
  HttpAuthHandler SDX;
  
  public c$b(HttpAuthHandler paramHttpAuthHandler)
  {
    this.SDX = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(207179);
    this.SDX.cancel();
    AppMethodBeat.o(207179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.c.b
 * JD-Core Version:    0.7.0.1
 */