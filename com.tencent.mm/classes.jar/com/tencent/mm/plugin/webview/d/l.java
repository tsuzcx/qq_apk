package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/jsapi/JsLoaderSetting;", "", "()V", "value", "", "isVConsoleOpen", "()Z", "setVConsoleOpen", "(Z)V", "webview-sdk_release"})
public final class l
{
  public static final l ISd;
  
  static
  {
    AppMethodBeat.i(225109);
    ISd = new l();
    AppMethodBeat.o(225109);
  }
  
  public static final boolean gbo()
  {
    AppMethodBeat.i(225107);
    if (((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (((b)g.af(b.class)).a(b.a.siO, 0) == 1)) && (m.gbp().getBoolean("vconsole", false)))
    {
      AppMethodBeat.o(225107);
      return true;
    }
    AppMethodBeat.o(225107);
    return false;
  }
  
  public static final void za(boolean paramBoolean)
  {
    AppMethodBeat.i(225108);
    m.gbp().putBoolean("vconsole", paramBoolean);
    AppMethodBeat.o(225108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.l
 * JD-Core Version:    0.7.0.1
 */