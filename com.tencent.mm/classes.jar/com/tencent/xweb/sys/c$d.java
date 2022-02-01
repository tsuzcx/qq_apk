package com.tencent.xweb.sys;

import android.webkit.JsPromptResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.o;

public final class c$d
  extends o
{
  public JsPromptResult SDZ;
  
  public c$d(JsPromptResult paramJsPromptResult)
  {
    this.SDZ = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153663);
    if (this.SDZ != null) {
      this.SDZ.cancel();
    }
    AppMethodBeat.o(153663);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153662);
    if (this.SDZ != null) {
      this.SDZ.confirm();
    }
    AppMethodBeat.o(153662);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.c.d
 * JD-Core Version:    0.7.0.1
 */