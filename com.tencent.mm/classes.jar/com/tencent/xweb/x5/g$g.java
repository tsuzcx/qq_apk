package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g$g
  extends com.tencent.xweb.JsResult
{
  public com.tencent.smtt.export.external.interfaces.JsResult KEx;
  
  public g$g(com.tencent.smtt.export.external.interfaces.JsResult paramJsResult)
  {
    this.KEx = paramJsResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153855);
    this.KEx.cancel();
    AppMethodBeat.o(153855);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153854);
    this.KEx.confirm();
    AppMethodBeat.o(153854);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.g
 * JD-Core Version:    0.7.0.1
 */