package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/JsLoaderSetting;", "", "()V", "value", "", "isVConsoleOpen", "()Z", "setVConsoleOpen", "(Z)V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n WEG;
  
  static
  {
    AppMethodBeat.i(295230);
    WEG = new n();
    AppMethodBeat.o(295230);
  }
  
  public static final void ID(boolean paramBoolean)
  {
    AppMethodBeat.i(295224);
    o.itQ().putBoolean("vconsole", paramBoolean);
    AppMethodBeat.o(295224);
  }
  
  public static final boolean itP()
  {
    AppMethodBeat.i(295219);
    if (((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (((c)h.ax(c.class)).a(c.a.zlr, 0) == 1)) && (o.itQ().getBoolean("vconsole", false)))
    {
      AppMethodBeat.o(295219);
      return true;
    }
    AppMethodBeat.o(295219);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.n
 * JD-Core Version:    0.7.0.1
 */