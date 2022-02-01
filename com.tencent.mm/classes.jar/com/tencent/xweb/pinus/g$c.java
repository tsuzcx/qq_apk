package com.tencent.xweb.pinus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.pinus.sdk.JsResultInterface;
import com.tencent.xweb.q;

public final class g$c
  extends q
{
  public JsResultInterface aikx;
  
  public g$c(JsResultInterface paramJsResultInterface)
  {
    this.aikx = paramJsResultInterface;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(213279);
    if (this.aikx != null) {
      this.aikx.cancel();
    }
    AppMethodBeat.o(213279);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(213271);
    if (this.aikx != null) {
      this.aikx.confirm();
    }
    AppMethodBeat.o(213271);
  }
  
  public final void confirmWithResult(String paramString)
  {
    AppMethodBeat.i(213264);
    if (this.aikx != null) {
      this.aikx.confirm(paramString);
    }
    AppMethodBeat.o(213264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.g.c
 * JD-Core Version:    0.7.0.1
 */