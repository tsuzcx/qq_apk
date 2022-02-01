package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/jsapi/JsLoaderSetting;", "", "()V", "value", "", "isVConsoleOpen", "()Z", "setVConsoleOpen", "(Z)V", "webview-sdk_release"})
public final class j
{
  public static final j DNy;
  
  static
  {
    AppMethodBeat.i(214321);
    DNy = new j();
    AppMethodBeat.o(214321);
  }
  
  public static final boolean eOR()
  {
    AppMethodBeat.i(214319);
    if (((i.IS_FLAVOR_RED) || (i.DEBUG) || (((b)g.ab(b.class)).a(b.a.qEO, 0) == 1)) && (k.eOS().getBoolean("vconsole", false)))
    {
      AppMethodBeat.o(214319);
      return true;
    }
    AppMethodBeat.o(214319);
    return false;
  }
  
  public static final void va(boolean paramBoolean)
  {
    AppMethodBeat.i(214320);
    k.eOS().putBoolean("vconsole", paramBoolean);
    AppMethodBeat.o(214320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.j
 * JD-Core Version:    0.7.0.1
 */