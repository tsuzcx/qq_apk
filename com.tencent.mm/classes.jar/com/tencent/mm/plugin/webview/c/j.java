package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/jsapi/JsLoaderSetting;", "", "()V", "value", "", "isVConsoleOpen", "()Z", "setVConsoleOpen", "(Z)V", "webview-sdk_release"})
public final class j
{
  public static final j Cks;
  
  static
  {
    AppMethodBeat.i(205532);
    Cks = new j();
    AppMethodBeat.o(205532);
  }
  
  public static final boolean eAd()
  {
    AppMethodBeat.i(205530);
    if (((h.IS_FLAVOR_RED) || (h.DEBUG) || (((b)g.ab(b.class)).a(b.a.pZB, 0) == 1)) && (k.eAe().getBoolean("vconsole", false)))
    {
      AppMethodBeat.o(205530);
      return true;
    }
    AppMethodBeat.o(205530);
    return false;
  }
  
  public static final void um(boolean paramBoolean)
  {
    AppMethodBeat.i(205531);
    k.eAe().putBoolean("vconsole", paramBoolean);
    AppMethodBeat.o(205531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.j
 * JD-Core Version:    0.7.0.1
 */