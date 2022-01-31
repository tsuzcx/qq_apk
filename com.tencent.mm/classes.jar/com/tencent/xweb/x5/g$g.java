package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.xweb.i;

public final class g$g
  extends i
{
  public JsPromptResult BIc;
  
  public g$g(JsPromptResult paramJsPromptResult)
  {
    this.BIc = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(84833);
    this.BIc.cancel();
    AppMethodBeat.o(84833);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(84832);
    this.BIc.confirm();
    AppMethodBeat.o(84832);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.g.g
 * JD-Core Version:    0.7.0.1
 */