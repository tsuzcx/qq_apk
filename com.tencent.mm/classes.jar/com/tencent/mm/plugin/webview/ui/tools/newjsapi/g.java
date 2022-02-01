package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiDoAuthCurrentUrl;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "lastCallBackID", "getLastCallBackID", "setLastCallBackID", "(Ljava/lang/String;)V", "doCallBack", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "errMsg", "doFailCallBack", "doSuccessCallBack", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class g
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static String QuV;
  public static final g QuW;
  
  static
  {
    AppMethodBeat.i(266012);
    QuW = new g();
    AppMethodBeat.o(266012);
  }
  
  public static void b(h paramh, String paramString)
  {
    AppMethodBeat.i(266010);
    p.k(paramh, "jsApiHandler");
    c(paramh, "doAuthCurrentUrl:fail ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(266010);
  }
  
  public static void bnd(String paramString)
  {
    QuV = paramString;
  }
  
  public static void c(h paramh, final String paramString)
  {
    AppMethodBeat.i(266011);
    p.k(paramh, "jsApiHandler");
    CharSequence localCharSequence = (CharSequence)QuV;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.JsApiDoAuthCurrentUrl", "lastCallBackID is null");
      AppMethodBeat.o(266011);
      return;
    }
    d.uiThread((kotlin.g.a.a)new a(paramh, paramString));
    AppMethodBeat.o(266011);
  }
  
  public static String hby()
  {
    return QuV;
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(266009);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Context localContext = paramf.context;
    if ((localContext instanceof WebViewUI)) {
      ((WebViewUI)localContext).gZi();
    }
    QuV = paramn.POu;
    Log.i("MicroMsg.JsApiDoAuthCurrentUrl", "SPA-Trace, JsApiDoAuthCurrentUrl call");
    paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
    AppMethodBeat.o(266009);
    return true;
  }
  
  public final String fCm()
  {
    return "doAuthCurrentUrl";
  }
  
  public final int fCn()
  {
    return 397;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(h paramh, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.g
 * JD-Core Version:    0.7.0.1
 */