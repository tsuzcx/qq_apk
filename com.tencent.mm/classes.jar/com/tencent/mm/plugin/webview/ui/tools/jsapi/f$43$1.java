package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class f$43$1
  implements h.d
{
  f$43$1(f.43 param43) {}
  
  private void cZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(211387);
    f.c localc = f.b(this.Juu.JtL, paramInt);
    if ((localc != null) && (localc.JsF != null) && (localc.ISw != null)) {
      f.a(this.Juu.JtL, f.k(this.Juu.JtL), f.j(this.Juu.JtL), "openMapNavigateMenu:" + Util.nullAs(paramString, "fail"));
    }
    AppMethodBeat.o(211387);
  }
  
  public final void ahb(int paramInt)
  {
    AppMethodBeat.i(211384);
    cZ(paramInt, "cancel");
    AppMethodBeat.o(211384);
  }
  
  public final void ahc(int paramInt)
  {
    AppMethodBeat.i(211388);
    f.c(this.Juu.JtL, paramInt);
    AppMethodBeat.o(211388);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(211385);
    cZ(paramInt, "fail");
    AppMethodBeat.o(211385);
  }
  
  public final void onSuccess(int paramInt)
  {
    AppMethodBeat.i(211386);
    cZ(paramInt, "ok");
    AppMethodBeat.o(211386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.43.1
 * JD-Core Version:    0.7.0.1
 */