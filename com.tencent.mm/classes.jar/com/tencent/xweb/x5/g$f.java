package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.xweb.j;

public final class g$f
  implements j
{
  HttpAuthHandler KEw;
  
  public g$f(HttpAuthHandler paramHttpAuthHandler)
  {
    this.KEw = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(208884);
    this.KEw.cancel();
    AppMethodBeat.o(208884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.f
 * JD-Core Version:    0.7.0.1
 */