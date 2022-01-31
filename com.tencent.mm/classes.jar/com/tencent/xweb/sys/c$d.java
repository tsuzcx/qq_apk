package com.tencent.xweb.sys;

import android.webkit.JsResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

public final class c$d
  extends j
{
  public JsResult BHl;
  
  public c$d(JsResult paramJsResult)
  {
    this.BHl = paramJsResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(84657);
    if (this.BHl != null) {
      this.BHl.cancel();
    }
    AppMethodBeat.o(84657);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(84656);
    if (this.BHl != null) {
      this.BHl.confirm();
    }
    AppMethodBeat.o(84656);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.sys.c.d
 * JD-Core Version:    0.7.0.1
 */