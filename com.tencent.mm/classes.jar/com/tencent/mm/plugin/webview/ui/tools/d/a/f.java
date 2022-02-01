package com.tencent.mm.plugin.webview.ui.tools.d.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.k.a.a;
import com.tencent.luggage.k.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import d.g.b.k;
import d.v;
import java.util.Map;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;)V", "getEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getMsg", "()Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "addLifecycleListener", "", "listener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "callbackResult", "", "result", "map", "", "", "getAppId", "getAsyncHandler", "Landroid/os/Handler;", "getComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContext", "Landroid/content/Context;", "getCurrentUrl", "getInvokeData", "Lorg/json/JSONObject;", "getInvokeName", "getJsApi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getWebComptName", "isSyncInvoke", "", "removeLifecycleListener", "Companion", "plugin-webview_release"})
public final class f
  implements a
{
  public static final a BtF;
  private final com.tencent.mm.plugin.webview.c.l Bph;
  final com.tencent.mm.plugin.webview.c.d BtE;
  
  static
  {
    AppMethodBeat.i(188949);
    BtF = new a((byte)0);
    AppMethodBeat.o(188949);
  }
  
  public f(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188948);
    this.BtE = paramd;
    this.Bph = paraml;
    AppMethodBeat.o(188948);
  }
  
  public final c Dj()
  {
    return null;
  }
  
  public final boolean EA()
  {
    return false;
  }
  
  public final JSONObject EB()
  {
    AppMethodBeat.i(188942);
    JSONObject localJSONObject = this.Bph.ASh;
    k.g(localJSONObject, "msg.rawParams");
    AppMethodBeat.o(188942);
    return localJSONObject;
  }
  
  public final String EC()
  {
    AppMethodBeat.i(188943);
    String str = this.Bph.kbU;
    k.g(str, "msg.function");
    AppMethodBeat.o(188943);
    return str;
  }
  
  public final void ED() {}
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(188946);
    if ((this.BtE.context instanceof d))
    {
      Context localContext = this.BtE.context;
      if (localContext == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(188946);
        throw parama;
      }
      ((d)localContext).c(parama);
    }
    AppMethodBeat.o(188946);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(188947);
    if (((this.BtE.context instanceof d)) && (parama != null))
    {
      Context localContext = this.BtE.context;
      if (localContext == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(188947);
        throw parama;
      }
      ((d)localContext).d(parama);
    }
    AppMethodBeat.o(188947);
  }
  
  public final String cD(String paramString)
  {
    AppMethodBeat.i(188944);
    this.BtE.ARd.h(this.Bph.ASg, this.Bph.kbU + ':' + paramString, null);
    AppMethodBeat.o(188944);
    return null;
  }
  
  public final String d(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(188945);
    this.BtE.ARd.h(this.Bph.ASg, this.Bph.kbU + ':' + paramString, paramMap);
    AppMethodBeat.o(188945);
    return null;
  }
  
  public final String eqQ()
  {
    AppMethodBeat.i(188940);
    if ((this.Bph.ASi != null) && (this.Bph.ASi.containsKey("name")))
    {
      String str = (String)this.Bph.ASi.get("name");
      AppMethodBeat.o(188940);
      return str;
    }
    AppMethodBeat.o(188940);
    return null;
  }
  
  public final String getAppId()
  {
    return "";
  }
  
  public final Context getContext()
  {
    return this.BtE.context;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(188941);
    String str = (String)this.Bph.uLu.get("url");
    AppMethodBeat.o(188941);
    return str;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.a.f
 * JD-Core Version:    0.7.0.1
 */