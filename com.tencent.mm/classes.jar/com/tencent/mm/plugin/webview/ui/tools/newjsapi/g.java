package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiDoAuthCurrentUrl;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class g
  extends a
{
  public static final g Jxg;
  
  static
  {
    AppMethodBeat.i(210588);
    Jxg = new g();
    AppMethodBeat.o(210588);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210587);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Context localContext = paramf.context;
    if ((localContext instanceof WebViewUI)) {
      ((WebViewUI)localContext).gfX();
    }
    Log.i("MicroMsg.JsApiDoAuthCurrentUrl", "SPA-Trace, JsApiDoAuthCurrentUrl call");
    paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
    AppMethodBeat.o(210587);
    return true;
  }
  
  public final int ePA()
  {
    return 397;
  }
  
  public final String ePz()
  {
    return "doAuthCurrentUrl";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.g
 * JD-Core Version:    0.7.0.1
 */