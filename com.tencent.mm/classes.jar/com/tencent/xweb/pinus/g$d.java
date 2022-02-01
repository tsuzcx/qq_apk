package com.tencent.xweb.pinus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.pinus.sdk.JsResultInterface;

public final class g$d
  extends JsResult
{
  public JsResultInterface aikx;
  
  public g$d(JsResultInterface paramJsResultInterface)
  {
    this.aikx = paramJsResultInterface;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(213295);
    if (this.aikx != null) {
      this.aikx.cancel();
    }
    AppMethodBeat.o(213295);
  }
  
  public final void confirm()
  {
    AppMethodBeat.i(213283);
    if (this.aikx != null) {
      this.aikx.confirm();
    }
    AppMethodBeat.o(213283);
  }
  
  public final void confirmWithResult(String paramString)
  {
    AppMethodBeat.i(213273);
    this.aikx.confirm(paramString);
    AppMethodBeat.o(213273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.g.d
 * JD-Core Version:    0.7.0.1
 */