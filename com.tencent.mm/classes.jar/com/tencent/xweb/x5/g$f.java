package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.xweb.j;

public final class g$f
  implements j
{
  HttpAuthHandler aagr;
  
  public g$f(HttpAuthHandler paramHttpAuthHandler)
  {
    this.aagr = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(206834);
    this.aagr.cancel();
    AppMethodBeat.o(206834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.f
 * JD-Core Version:    0.7.0.1
 */