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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;)V", "getEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getMsg", "()Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "addLifecycleListener", "", "listener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "callbackResult", "", "result", "map", "", "", "getAppId", "getAsyncHandler", "Landroid/os/Handler;", "getComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContext", "Landroid/content/Context;", "getCurrentUrl", "getInvokeData", "Lorg/json/JSONObject;", "getInvokeName", "getJsApi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getWebComptName", "isSyncInvoke", "", "removeLifecycleListener", "Companion", "plugin-webview_release"})
public final class f
  implements a
{
  public static final a EpN;
  private final com.tencent.mm.plugin.webview.c.l Ela;
  final com.tencent.mm.plugin.webview.c.d EpM;
  
  static
  {
    AppMethodBeat.i(207687);
    EpN = new a((byte)0);
    AppMethodBeat.o(207687);
  }
  
  public f(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207686);
    this.EpM = paramd;
    this.Ela = paraml;
    AppMethodBeat.o(207686);
  }
  
  public final c El()
  {
    return null;
  }
  
  public final boolean FC()
  {
    return false;
  }
  
  public final JSONObject FD()
  {
    AppMethodBeat.i(207680);
    JSONObject localJSONObject = this.Ela.DNA;
    p.g(localJSONObject, "msg.rawParams");
    AppMethodBeat.o(207680);
    return localJSONObject;
  }
  
  public final String FE()
  {
    AppMethodBeat.i(207681);
    String str = this.Ela.kYO;
    p.g(str, "msg.function");
    AppMethodBeat.o(207681);
    return str;
  }
  
  public final void FF() {}
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(207684);
    if ((this.EpM.context instanceof d))
    {
      Context localContext = this.EpM.context;
      if (localContext == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(207684);
        throw parama;
      }
      ((d)localContext).c(parama);
    }
    AppMethodBeat.o(207684);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(207685);
    if (((this.EpM.context instanceof d)) && (parama != null))
    {
      Context localContext = this.EpM.context;
      if (localContext == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(207685);
        throw parama;
      }
      ((d)localContext).d(parama);
    }
    AppMethodBeat.o(207685);
  }
  
  public final String du(String paramString)
  {
    AppMethodBeat.i(207682);
    this.EpM.Dyx.i(this.Ela.DNz, this.Ela.kYO + ':' + paramString, null);
    AppMethodBeat.o(207682);
    return null;
  }
  
  public final String e(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(207683);
    this.EpM.Dyx.i(this.Ela.DNz, this.Ela.kYO + ':' + paramString, paramMap);
    AppMethodBeat.o(207683);
    return null;
  }
  
  public final String eVi()
  {
    AppMethodBeat.i(207678);
    if ((this.Ela.DMM != null) && (this.Ela.DMM.containsKey("name")))
    {
      String str = (String)this.Ela.DMM.get("name");
      AppMethodBeat.o(207678);
      return str;
    }
    AppMethodBeat.o(207678);
    return null;
  }
  
  public final String getAppId()
  {
    return "";
  }
  
  public final Context getContext()
  {
    return this.EpM.context;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(207679);
    String str = (String)this.Ela.xaW.get("url");
    AppMethodBeat.o(207679);
    return str;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f
 * JD-Core Version:    0.7.0.1
 */