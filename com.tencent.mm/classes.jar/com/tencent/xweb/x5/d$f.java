package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.xweb.l;

public final class d$f
  implements l
{
  HttpAuthHandler aine;
  
  public d$f(HttpAuthHandler paramHttpAuthHandler)
  {
    this.aine = paramHttpAuthHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(213230);
    this.aine.cancel();
    AppMethodBeat.o(213230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.d.f
 * JD-Core Version:    0.7.0.1
 */