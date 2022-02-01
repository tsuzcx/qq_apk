package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.xweb.r;

public final class g$a
  implements r
{
  SslErrorHandler MuS;
  
  public g$a(SslErrorHandler paramSslErrorHandler)
  {
    this.MuS = paramSslErrorHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153847);
    this.MuS.cancel();
    AppMethodBeat.o(153847);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(153846);
    this.MuS.proceed();
    AppMethodBeat.o(153846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.a
 * JD-Core Version:    0.7.0.1
 */