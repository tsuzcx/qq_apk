package com.tencent.mm.plugin.webview.ui.tools.c.a;

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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;)V", "getEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getMsg", "()Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "addLifecycleListener", "", "listener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "callbackResult", "", "result", "map", "", "", "getAppId", "getAsyncHandler", "Landroid/os/Handler;", "getComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContext", "Landroid/content/Context;", "getCurrentUrl", "getInvokeData", "Lorg/json/JSONObject;", "getInvokeName", "getJsApi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getWebComptName", "isSyncInvoke", "", "removeLifecycleListener", "Companion", "plugin-webview_release"})
public final class f
  implements a
{
  public static final a CLO;
  private final com.tencent.mm.plugin.webview.c.l CHo;
  final com.tencent.mm.plugin.webview.c.d CLN;
  
  static
  {
    AppMethodBeat.i(189532);
    CLO = new a((byte)0);
    AppMethodBeat.o(189532);
  }
  
  public f(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189531);
    this.CLN = paramd;
    this.CHo = paraml;
    AppMethodBeat.o(189531);
  }
  
  public final c CM()
  {
    return null;
  }
  
  public final boolean Ed()
  {
    return false;
  }
  
  public final JSONObject Ee()
  {
    AppMethodBeat.i(189525);
    JSONObject localJSONObject = this.CHo.Cku;
    k.g(localJSONObject, "msg.rawParams");
    AppMethodBeat.o(189525);
    return localJSONObject;
  }
  
  public final String Ef()
  {
    AppMethodBeat.i(189526);
    String str = this.CHo.kCH;
    k.g(str, "msg.function");
    AppMethodBeat.o(189526);
    return str;
  }
  
  public final void Eg() {}
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(189529);
    if ((this.CLN.context instanceof d))
    {
      Context localContext = this.CLN.context;
      if (localContext == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(189529);
        throw parama;
      }
      ((d)localContext).c(parama);
    }
    AppMethodBeat.o(189529);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(189530);
    if (((this.CLN.context instanceof d)) && (parama != null))
    {
      Context localContext = this.CLN.context;
      if (localContext == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(189530);
        throw parama;
      }
      ((d)localContext).d(parama);
    }
    AppMethodBeat.o(189530);
  }
  
  public final String cs(String paramString)
  {
    AppMethodBeat.i(189527);
    this.CLN.Cjq.j(this.CHo.Ckt, this.CHo.kCH + ':' + paramString, null);
    AppMethodBeat.o(189527);
    return null;
  }
  
  public final String d(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(189528);
    this.CLN.Cjq.j(this.CHo.Ckt, this.CHo.kCH + ':' + paramString, paramMap);
    AppMethodBeat.o(189528);
    return null;
  }
  
  public final String eGk()
  {
    AppMethodBeat.i(189523);
    if ((this.CHo.Ckv != null) && (this.CHo.Ckv.containsKey("name")))
    {
      String str = (String)this.CHo.Ckv.get("name");
      AppMethodBeat.o(189523);
      return str;
    }
    AppMethodBeat.o(189523);
    return null;
  }
  
  public final String getAppId()
  {
    return "";
  }
  
  public final Context getContext()
  {
    return this.CLN.context;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(189524);
    String str = (String)this.CHo.vUl.get("url");
    AppMethodBeat.o(189524);
    return str;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.a.f
 * JD-Core Version:    0.7.0.1
 */