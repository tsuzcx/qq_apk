package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.xweb.j;

public final class g$f
  extends j
{
  public JsResult BIb;
  
  public g$f(JsResult paramJsResult)
  {
    this.BIb = paramJsResult;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(84831);
    this.BIb.cancel();
    AppMethodBeat.o(84831);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(84830);
    this.BIb.confirm();
    AppMethodBeat.o(84830);
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.g.f
 * JD-Core Version:    0.7.0.1
 */