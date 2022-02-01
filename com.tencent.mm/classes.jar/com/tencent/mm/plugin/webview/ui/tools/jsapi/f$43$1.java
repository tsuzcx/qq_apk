package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

final class f$43$1
  implements h.d
{
  f$43$1(f.43 param43) {}
  
  private void cG(int paramInt, String paramString)
  {
    AppMethodBeat.i(198476);
    f.c localc = f.b(this.EEN.EEe, paramInt);
    if ((localc != null) && (localc.EDe != null) && (localc.EfN != null)) {
      f.a(this.EEN.EEe, f.k(this.EEN.EEe), f.j(this.EEN.EEe), "openMapNavigateMenu:" + bu.bI(paramString, "fail"));
    }
    AppMethodBeat.o(198476);
  }
  
  public final void Yr(int paramInt)
  {
    AppMethodBeat.i(198473);
    cG(paramInt, "cancel");
    AppMethodBeat.o(198473);
  }
  
  public final void Ys(int paramInt)
  {
    AppMethodBeat.i(198477);
    f.c(this.EEN.EEe, paramInt);
    AppMethodBeat.o(198477);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(198474);
    cG(paramInt, "fail");
    AppMethodBeat.o(198474);
  }
  
  public final void onSuccess(int paramInt)
  {
    AppMethodBeat.i(198475);
    cG(paramInt, "ok");
    AppMethodBeat.o(198475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.43.1
 * JD-Core Version:    0.7.0.1
 */