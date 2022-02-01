package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$c
  implements com.tencent.smtt.export.external.interfaces.JsResult
{
  public com.tencent.xweb.JsResult MRO;
  
  public a$c(com.tencent.xweb.JsResult paramJsResult)
  {
    this.MRO = paramJsResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153815);
    this.MRO.cancel();
    AppMethodBeat.o(153815);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153814);
    this.MRO.confirm();
    AppMethodBeat.o(153814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.a.c
 * JD-Core Version:    0.7.0.1
 */