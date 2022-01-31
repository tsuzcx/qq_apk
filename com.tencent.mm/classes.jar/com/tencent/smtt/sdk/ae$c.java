package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ae$c
  implements com.tencent.smtt.export.external.interfaces.SslErrorHandler
{
  android.webkit.SslErrorHandler a;
  
  ae$c(android.webkit.SslErrorHandler paramSslErrorHandler)
  {
    this.a = paramSslErrorHandler;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(139152);
    this.a.cancel();
    AppMethodBeat.o(139152);
  }
  
  public void proceed()
  {
    AppMethodBeat.i(139151);
    this.a.proceed();
    AppMethodBeat.o(139151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ae.c
 * JD-Core Version:    0.7.0.1
 */