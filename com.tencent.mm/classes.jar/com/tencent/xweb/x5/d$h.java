package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.xweb.q;

public final class d$h
  extends q
{
  public JsPromptResult aing;
  
  public d$h(JsPromptResult paramJsPromptResult)
  {
    this.aing = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153857);
    this.aing.cancel();
    AppMethodBeat.o(153857);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153856);
    this.aing.confirm();
    AppMethodBeat.o(153856);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.d.h
 * JD-Core Version:    0.7.0.1
 */