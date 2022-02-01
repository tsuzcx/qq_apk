package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.xweb.j;

public final class g$f
  implements j
{
  HttpAuthHandler SFg;
  
  public g$f(HttpAuthHandler paramHttpAuthHandler)
  {
    this.SFg = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(207189);
    this.SFg.cancel();
    AppMethodBeat.o(207189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.g.f
 * JD-Core Version:    0.7.0.1
 */