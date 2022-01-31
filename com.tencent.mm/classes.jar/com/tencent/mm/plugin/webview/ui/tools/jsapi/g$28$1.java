package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class g$28$1
  implements j.d
{
  g$28$1(g.28 param28) {}
  
  private void bH(int paramInt, String paramString)
  {
    AppMethodBeat.i(154949);
    g.c localc = g.b(this.vqM.vqm, paramInt);
    if ((localc != null) && (localc.vpn != null) && (localc.uWu != null)) {
      g.a(this.vqM.vqm, g.l(this.vqM.vqm), g.k(this.vqM.vqm), "openMapNavigateMenu:" + bo.bf(paramString, "fail"));
    }
    AppMethodBeat.o(154949);
  }
  
  public final void Cp(int paramInt)
  {
    AppMethodBeat.i(154946);
    bH(paramInt, "cancel");
    AppMethodBeat.o(154946);
  }
  
  public final void KV(int paramInt)
  {
    AppMethodBeat.i(154950);
    g.c(this.vqM.vqm, paramInt);
    AppMethodBeat.o(154950);
  }
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(154947);
    bH(paramInt, "fail");
    AppMethodBeat.o(154947);
  }
  
  public final void onSuccess(int paramInt)
  {
    AppMethodBeat.i(154948);
    bH(paramInt, "ok");
    AppMethodBeat.o(154948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.28.1
 * JD-Core Version:    0.7.0.1
 */