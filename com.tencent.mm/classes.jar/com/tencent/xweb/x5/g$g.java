package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.xweb.n;

public final class g$g
  extends n
{
  public JsPromptResult ISb;
  
  public g$g(JsPromptResult paramJsPromptResult)
  {
    this.ISb = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153857);
    this.ISb.cancel();
    AppMethodBeat.o(153857);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153856);
    this.ISb.confirm();
    AppMethodBeat.o(153856);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.g
 * JD-Core Version:    0.7.0.1
 */