package com.tencent.xweb.sys;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$e
  extends com.tencent.xweb.JsResult
{
  public android.webkit.JsResult SEa;
  
  public c$e(android.webkit.JsResult paramJsResult)
  {
    this.SEa = paramJsResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153665);
    if (this.SEa != null) {
      this.SEa.cancel();
    }
    AppMethodBeat.o(153665);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153664);
    if (this.SEa != null) {
      this.SEa.confirm();
    }
    AppMethodBeat.o(153664);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.c.e
 * JD-Core Version:    0.7.0.1
 */