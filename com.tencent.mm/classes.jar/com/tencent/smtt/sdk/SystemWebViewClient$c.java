package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebViewClient$c
  implements com.tencent.smtt.export.external.interfaces.SslErrorHandler
{
  android.webkit.SslErrorHandler a;
  
  SystemWebViewClient$c(android.webkit.SslErrorHandler paramSslErrorHandler)
  {
    this.a = paramSslErrorHandler;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(55029);
    this.a.cancel();
    AppMethodBeat.o(55029);
  }
  
  public void proceed()
  {
    AppMethodBeat.i(55028);
    this.a.proceed();
    AppMethodBeat.o(55028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.c
 * JD-Core Version:    0.7.0.1
 */