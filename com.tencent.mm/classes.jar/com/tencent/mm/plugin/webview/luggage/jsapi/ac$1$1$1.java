package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.aj.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ac$1$1$1
  implements aj.a
{
  ac$1$1$1(ac.1.1 param1) {}
  
  public final void r(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(6326);
    ab.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      this.uTH.uTG.lax.c(null, null);
      AppMethodBeat.o(6326);
      return;
    }
    this.uTH.uTG.lax.c("fail", null);
    AppMethodBeat.o(6326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ac.1.1.1
 * JD-Core Version:    0.7.0.1
 */