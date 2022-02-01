package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.xweb.o;

public final class g$h
  extends o
{
  public JsPromptResult KEy;
  
  public g$h(JsPromptResult paramJsPromptResult)
  {
    this.KEy = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153857);
    this.KEy.cancel();
    AppMethodBeat.o(153857);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(153856);
    this.KEy.confirm();
    AppMethodBeat.o(153856);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.h
 * JD-Core Version:    0.7.0.1
 */