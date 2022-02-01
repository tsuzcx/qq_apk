package com.tencent.xweb.sys;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$d
  extends com.tencent.xweb.JsResult
{
  public android.webkit.JsResult IQW;
  
  public c$d(android.webkit.JsResult paramJsResult)
  {
    this.IQW = paramJsResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153665);
    if (this.IQW != null) {
      this.IQW.cancel();
    }
    AppMethodBeat.o(153665);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153664);
    if (this.IQW != null) {
      this.IQW.confirm();
    }
    AppMethodBeat.o(153664);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.d
 * JD-Core Version:    0.7.0.1
 */