package com.tencent.xweb.sys;

import android.webkit.JsPromptResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.q;

public final class c$d
  extends q
{
  public JsPromptResult aimd;
  
  public c$d(JsPromptResult paramJsPromptResult)
  {
    this.aimd = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153663);
    if (this.aimd != null) {
      this.aimd.cancel();
    }
    AppMethodBeat.o(153663);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153662);
    if (this.aimd != null) {
      this.aimd.confirm();
    }
    AppMethodBeat.o(153662);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.c.d
 * JD-Core Version:    0.7.0.1
 */