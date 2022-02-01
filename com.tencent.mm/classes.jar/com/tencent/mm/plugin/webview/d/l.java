package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/JsLoaderSetting;", "", "()V", "value", "", "isVConsoleOpen", "()Z", "setVConsoleOpen", "(Z)V", "webview-sdk_release"})
public final class l
{
  public static final l POt;
  
  static
  {
    AppMethodBeat.i(205304);
    POt = new l();
    AppMethodBeat.o(205304);
  }
  
  public static final void CV(boolean paramBoolean)
  {
    AppMethodBeat.i(205303);
    m.gUj().putBoolean("vconsole", paramBoolean);
    AppMethodBeat.o(205303);
  }
  
  public static final boolean gUi()
  {
    AppMethodBeat.i(205302);
    if (((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (((b)h.ae(b.class)).a(b.a.vSN, 0) == 1)) && (m.gUj().getBoolean("vconsole", false)))
    {
      AppMethodBeat.o(205302);
      return true;
    }
    AppMethodBeat.o(205302);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.l
 * JD-Core Version:    0.7.0.1
 */