package com.tencent.xweb.sys;

import android.webkit.JsPromptResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.o;

public final class c$d
  extends o
{
  public JsPromptResult MtR;
  
  public c$d(JsPromptResult paramJsPromptResult)
  {
    this.MtR = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153663);
    if (this.MtR != null) {
      this.MtR.cancel();
    }
    AppMethodBeat.o(153663);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153662);
    if (this.MtR != null) {
      this.MtR.confirm();
    }
    AppMethodBeat.o(153662);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.d
 * JD-Core Version:    0.7.0.1
 */