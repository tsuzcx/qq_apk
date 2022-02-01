package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

final class f$43$1
  implements h.d
{
  f$43$1(f.43 param43) {}
  
  private void cG(int paramInt, String paramString)
  {
    AppMethodBeat.i(208294);
    f.c localc = f.b(this.EmJ.Ema, paramInt);
    if ((localc != null) && (localc.Ela != null) && (localc.DNO != null)) {
      f.a(this.EmJ.Ema, f.k(this.EmJ.Ema), f.j(this.EmJ.Ema), "openMapNavigateMenu:" + bt.bI(paramString, "fail"));
    }
    AppMethodBeat.o(208294);
  }
  
  public final void XL(int paramInt)
  {
    AppMethodBeat.i(208291);
    cG(paramInt, "cancel");
    AppMethodBeat.o(208291);
  }
  
  public final void XM(int paramInt)
  {
    AppMethodBeat.i(208295);
    f.c(this.EmJ.Ema, paramInt);
    AppMethodBeat.o(208295);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(208292);
    cG(paramInt, "fail");
    AppMethodBeat.o(208292);
  }
  
  public final void onSuccess(int paramInt)
  {
    AppMethodBeat.i(208293);
    cG(paramInt, "ok");
    AppMethodBeat.o(208293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.43.1
 * JD-Core Version:    0.7.0.1
 */