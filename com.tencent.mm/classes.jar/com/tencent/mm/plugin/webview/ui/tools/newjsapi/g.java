package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiDoAuthCurrentUrl;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "lastCallBackID", "getLastCallBackID", "setLastCallBackID", "(Ljava/lang/String;)V", "doCallBack", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "errMsg", "doFailCallBack", "doSuccessCallBack", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  public static final g XmS;
  private static String XmT;
  
  static
  {
    AppMethodBeat.i(297888);
    XmS = new g();
    AppMethodBeat.o(297888);
  }
  
  public static void b(j paramj, String paramString)
  {
    AppMethodBeat.i(297869);
    s.u(paramj, "jsApiHandler");
    c(paramj, "doAuthCurrentUrl:fail ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(297869);
  }
  
  public static void bmI(String paramString)
  {
    XmT = paramString;
  }
  
  public static void c(j paramj, final String paramString)
  {
    AppMethodBeat.i(297879);
    s.u(paramj, "jsApiHandler");
    CharSequence localCharSequence = (CharSequence)XmT;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.JsApiDoAuthCurrentUrl", "lastCallBackID is null");
      AppMethodBeat.o(297879);
      return;
    }
    d.uiThread((kotlin.g.a.a)new a(paramj, paramString));
    AppMethodBeat.o(297879);
  }
  
  public static String iBK()
  {
    return XmT;
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297896);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject = paramh.context;
    if ((localObject instanceof WebViewUI))
    {
      localObject = (WebViewUI)localObject;
      if (((WebViewUI)localObject).Wzl != null)
      {
        localObject = ((Iterable)((WebViewUI)localObject).Wzl.WmV).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((m)((Iterator)localObject).next()).isL();
        }
      }
    }
    XmT = paramp.WEH;
    Log.i("MicroMsg.JsApiDoAuthCurrentUrl", "SPA-Trace, JsApiDoAuthCurrentUrl call");
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
    AppMethodBeat.o(297896);
    return true;
  }
  
  public final String gPX()
  {
    return "doAuthCurrentUrl";
  }
  
  public final int gPZ()
  {
    return 397;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(j paramj, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.g
 * JD-Core Version:    0.7.0.1
 */