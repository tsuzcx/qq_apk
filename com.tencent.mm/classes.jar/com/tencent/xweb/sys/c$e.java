package com.tencent.xweb.sys;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$e
  extends com.tencent.xweb.JsResult
{
  public android.webkit.JsResult KDs;
  
  public c$e(android.webkit.JsResult paramJsResult)
  {
    this.KDs = paramJsResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153665);
    if (this.KDs != null) {
      this.KDs.cancel();
    }
    AppMethodBeat.o(153665);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153664);
    if (this.KDs != null) {
      this.KDs.confirm();
    }
    AppMethodBeat.o(153664);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.e
 * JD-Core Version:    0.7.0.1
 */