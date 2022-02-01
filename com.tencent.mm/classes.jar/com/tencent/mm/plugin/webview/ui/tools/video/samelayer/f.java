package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;)V", "getEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getMsg", "()Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "addLifecycleListener", "", "listener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "callbackResult", "", "result", "map", "", "", "getAppId", "getAsyncHandler", "Landroid/os/Handler;", "getComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContext", "Landroid/content/Context;", "getCurrentUrl", "getInvokeData", "Lorg/json/JSONObject;", "getInvokeName", "getJsApi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getWebComptName", "isSyncInvoke", "", "removeLifecycleListener", "Companion", "plugin-webview_release"})
public final class f
  implements a
{
  public static final a JxS;
  private final n JsF;
  final com.tencent.mm.plugin.webview.d.f JxI;
  
  static
  {
    AppMethodBeat.i(210684);
    JxS = new a((byte)0);
    AppMethodBeat.o(210684);
  }
  
  public f(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(210683);
    this.JxI = paramf;
    this.JsF = paramn;
    AppMethodBeat.o(210683);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.f NN()
  {
    return null;
  }
  
  public final boolean Pr()
  {
    return false;
  }
  
  public final JSONObject Ps()
  {
    AppMethodBeat.i(210677);
    JSONObject localJSONObject = this.JsF.ISf;
    p.g(localJSONObject, "msg.rawParams");
    AppMethodBeat.o(210677);
    return localJSONObject;
  }
  
  public final String Pt()
  {
    AppMethodBeat.i(210678);
    String str = this.JsF.mhO;
    p.g(str, "msg.function");
    AppMethodBeat.o(210678);
    return str;
  }
  
  public final void Pu() {}
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(210681);
    if ((this.JxI.context instanceof d))
    {
      Context localContext = this.JxI.context;
      if (localContext == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(210681);
        throw parama;
      }
      ((d)localContext).c(parama);
    }
    AppMethodBeat.o(210681);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(210682);
    if (((this.JxI.context instanceof d)) && (parama != null))
    {
      Context localContext = this.JxI.context;
      if (localContext == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(210682);
        throw parama;
      }
      ((d)localContext).d(parama);
    }
    AppMethodBeat.o(210682);
  }
  
  public final String dP(String paramString)
  {
    AppMethodBeat.i(210679);
    this.JxI.IQZ.h(this.JsF.ISe, this.JsF.mhO + ':' + paramString, null);
    AppMethodBeat.o(210679);
    return null;
  }
  
  public final String f(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(210680);
    this.JxI.IQZ.h(this.JsF.ISe, this.JsF.mhO + ':' + paramString, paramMap);
    AppMethodBeat.o(210680);
    return null;
  }
  
  public final String getAppId()
  {
    return "";
  }
  
  public final Context getContext()
  {
    return this.JxI.context;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(210676);
    String str = (String)this.JsF.params.get("url");
    AppMethodBeat.o(210676);
    return str;
  }
  
  public final String gid()
  {
    AppMethodBeat.i(210675);
    if ((this.JsF.IRs != null) && (this.JsF.IRs.containsKey("name")))
    {
      String str = (String)this.JsF.IRs.get("name");
      AppMethodBeat.o(210675);
      return str;
    }
    AppMethodBeat.o(210675);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f
 * JD-Core Version:    0.7.0.1
 */