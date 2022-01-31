package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;
import org.xwalk.core.XWalkJavascriptResult;

public final class f$c
  extends j
{
  public XWalkJavascriptResult BJA;
  
  public f$c(XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    this.BJA = paramXWalkJavascriptResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(85221);
    this.BJA.cancel();
    AppMethodBeat.o(85221);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(85220);
    this.BJA.confirm();
    AppMethodBeat.o(85220);
  }
  
  public final void confirmWithResult(String paramString)
  {
    AppMethodBeat.i(85219);
    this.BJA.confirmWithResult(paramString);
    AppMethodBeat.o(85219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f.c
 * JD-Core Version:    0.7.0.1
 */