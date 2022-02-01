package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ay;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/jsapi/JsLoaderSetting;", "", "()V", "value", "", "isVConsoleOpen", "()Z", "setVConsoleOpen", "(Z)V", "webview-sdk_release"})
public final class j
{
  public static final j Efx;
  
  static
  {
    AppMethodBeat.i(214162);
    Efx = new j();
    AppMethodBeat.o(214162);
  }
  
  public static final boolean eSC()
  {
    AppMethodBeat.i(214160);
    if (((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.DEBUG) || (((b)g.ab(b.class)).a(b.a.qMu, 0) == 1)) && (k.eSD().getBoolean("vconsole", false)))
    {
      AppMethodBeat.o(214160);
      return true;
    }
    AppMethodBeat.o(214160);
    return false;
  }
  
  public static final void vi(boolean paramBoolean)
  {
    AppMethodBeat.i(214161);
    k.eSD().putBoolean("vconsole", paramBoolean);
    AppMethodBeat.o(214161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.j
 * JD-Core Version:    0.7.0.1
 */