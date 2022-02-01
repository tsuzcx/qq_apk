package com.tencent.xweb.sys;

import android.webkit.JsPromptResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.n;

public final class c$c
  extends n
{
  public JsPromptResult IQV;
  
  public c$c(JsPromptResult paramJsPromptResult)
  {
    this.IQV = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153663);
    if (this.IQV != null) {
      this.IQV.cancel();
    }
    AppMethodBeat.o(153663);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153662);
    if (this.IQV != null) {
      this.IQV.confirm();
    }
    AppMethodBeat.o(153662);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.c
 * JD-Core Version:    0.7.0.1
 */