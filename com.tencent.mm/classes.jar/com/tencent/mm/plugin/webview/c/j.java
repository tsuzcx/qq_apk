package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/jsapi/JsLoaderSetting;", "", "()V", "value", "", "isVConsoleOpen", "()Z", "setVConsoleOpen", "(Z)V", "webview-sdk_release"})
public final class j
{
  public static final j ASf;
  
  static
  {
    AppMethodBeat.i(189400);
    ASf = new j();
    AppMethodBeat.o(189400);
  }
  
  public static final boolean ekH()
  {
    AppMethodBeat.i(189398);
    if (((h.IS_FLAVOR_RED) || (h.DEBUG) || (((b)g.ab(b.class)).a(b.a.pvn, 0) == 1)) && (k.ekI().getBoolean("vconsole", false)))
    {
      AppMethodBeat.o(189398);
      return true;
    }
    AppMethodBeat.o(189398);
    return false;
  }
  
  public static final void tk(boolean paramBoolean)
  {
    AppMethodBeat.i(189399);
    k.ekI().putBoolean("vconsole", paramBoolean);
    AppMethodBeat.o(189399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.j
 * JD-Core Version:    0.7.0.1
 */