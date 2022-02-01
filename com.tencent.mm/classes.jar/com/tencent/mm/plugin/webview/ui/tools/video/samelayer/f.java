package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import d.g.b.p;
import d.v;
import java.util.Map;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;)V", "getEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getMsg", "()Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "addLifecycleListener", "", "listener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "callbackResult", "", "result", "map", "", "", "getAppId", "getAsyncHandler", "Landroid/os/Handler;", "getComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContext", "Landroid/content/Context;", "getCurrentUrl", "getInvokeData", "Lorg/json/JSONObject;", "getInvokeName", "getJsApi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getWebComptName", "isSyncInvoke", "", "removeLifecycleListener", "Companion", "plugin-webview_release"})
public final class f
  implements a
{
  public static final a EId;
  private final com.tencent.mm.plugin.webview.c.l EDe;
  final com.tencent.mm.plugin.webview.c.d EIc;
  
  static
  {
    AppMethodBeat.i(199461);
    EId = new a((byte)0);
    AppMethodBeat.o(199461);
  }
  
  public f(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199460);
    this.EIc = paramd;
    this.EDe = paraml;
    AppMethodBeat.o(199460);
  }
  
  public final c Eo()
  {
    return null;
  }
  
  public final boolean FI()
  {
    return false;
  }
  
  public final JSONObject FJ()
  {
    AppMethodBeat.i(199454);
    JSONObject localJSONObject = this.EDe.Efz;
    p.g(localJSONObject, "msg.rawParams");
    AppMethodBeat.o(199454);
    return localJSONObject;
  }
  
  public final String FK()
  {
    AppMethodBeat.i(199455);
    String str = this.EDe.lcx;
    p.g(str, "msg.function");
    AppMethodBeat.o(199455);
    return str;
  }
  
  public final void FL() {}
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(199458);
    if ((this.EIc.context instanceof d))
    {
      Context localContext = this.EIc.context;
      if (localContext == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(199458);
        throw parama;
      }
      ((d)localContext).c(parama);
    }
    AppMethodBeat.o(199458);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(199459);
    if (((this.EIc.context instanceof d)) && (parama != null))
    {
      Context localContext = this.EIc.context;
      if (localContext == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(199459);
        throw parama;
      }
      ((d)localContext).d(parama);
    }
    AppMethodBeat.o(199459);
  }
  
  public final String dw(String paramString)
  {
    AppMethodBeat.i(199456);
    this.EIc.DQe.i(this.EDe.Efy, this.EDe.lcx + ':' + paramString, null);
    AppMethodBeat.o(199456);
    return null;
  }
  
  public final String eYV()
  {
    AppMethodBeat.i(199452);
    if ((this.EDe.EeL != null) && (this.EDe.EeL.containsKey("name")))
    {
      String str = (String)this.EDe.EeL.get("name");
      AppMethodBeat.o(199452);
      return str;
    }
    AppMethodBeat.o(199452);
    return null;
  }
  
  public final String f(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(199457);
    this.EIc.DQe.i(this.EDe.Efy, this.EDe.lcx + ':' + paramString, paramMap);
    AppMethodBeat.o(199457);
    return null;
  }
  
  public final String getAppId()
  {
    return "";
  }
  
  public final Context getContext()
  {
    return this.EIc.context;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(199453);
    String str = (String)this.EDe.xqN.get("url");
    AppMethodBeat.o(199453);
    return str;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f
 * JD-Core Version:    0.7.0.1
 */