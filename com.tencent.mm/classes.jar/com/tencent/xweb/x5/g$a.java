package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.xweb.q;

public final class g$a
  implements q
{
  SslErrorHandler IRW;
  
  public g$a(SslErrorHandler paramSslErrorHandler)
  {
    this.IRW = paramSslErrorHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153847);
    this.IRW.cancel();
    AppMethodBeat.o(153847);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(153846);
    this.IRW.proceed();
    AppMethodBeat.o(153846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.a
 * JD-Core Version:    0.7.0.1
 */