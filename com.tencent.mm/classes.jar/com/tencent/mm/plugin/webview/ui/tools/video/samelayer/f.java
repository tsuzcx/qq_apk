package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.webview.d.h;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;)V", "getEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getMsg", "()Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "addLifecycleListener", "", "listener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "callbackResult", "", "result", "map", "", "", "getAppId", "getAsyncHandler", "Landroid/os/Handler;", "getComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContext", "Landroid/content/Context;", "getCurrentUrl", "getInvokeData", "Lorg/json/JSONObject;", "getInvokeName", "getJsApi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getWebComptName", "isCreatePluginInvoke", "", "isSyncInvoke", "removeLifecycleListener", "Companion", "plugin-webview_release"})
public final class f
  implements a
{
  public static final a QvX;
  private final com.tencent.mm.plugin.webview.d.n Qqe;
  final com.tencent.mm.plugin.webview.d.f QvF;
  
  static
  {
    AppMethodBeat.i(231976);
    QvX = new a((byte)0);
    AppMethodBeat.o(231976);
  }
  
  public f(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn)
  {
    AppMethodBeat.i(231975);
    this.QvF = paramf;
    this.Qqe = paramn;
    AppMethodBeat.o(231975);
  }
  
  public final e QK()
  {
    return null;
  }
  
  public final boolean SQ()
  {
    return false;
  }
  
  public final JSONObject SR()
  {
    AppMethodBeat.i(231964);
    JSONObject localJSONObject = this.Qqe.POv;
    p.j(localJSONObject, "msg.rawParams");
    AppMethodBeat.o(231964);
    return localJSONObject;
  }
  
  public final String SS()
  {
    AppMethodBeat.i(231966);
    String str = this.Qqe.function;
    p.j(str, "msg.function");
    AppMethodBeat.o(231966);
    return str;
  }
  
  public final void ST() {}
  
  public final boolean SU()
  {
    AppMethodBeat.i(231974);
    Object localObject = SR();
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("action", "");
      if (localObject != null)
      {
        boolean bool = kotlin.n.n.M((String)localObject, "insert", false);
        AppMethodBeat.o(231974);
        return bool;
      }
    }
    AppMethodBeat.o(231974);
    return false;
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(231970);
    if ((this.QvF.context instanceof d))
    {
      Context localContext = this.QvF.context;
      if (localContext == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(231970);
        throw parama;
      }
      ((d)localContext).c(parama);
    }
    AppMethodBeat.o(231970);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(231972);
    if (((this.QvF.context instanceof d)) && (parama != null))
    {
      Context localContext = this.QvF.context;
      if (localContext == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUILifeCycle");
        AppMethodBeat.o(231972);
        throw parama;
      }
      ((d)localContext).d(parama);
    }
    AppMethodBeat.o(231972);
  }
  
  public final String e(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(231969);
    this.QvF.PNo.h(this.Qqe.POu, this.Qqe.function + ':' + paramString, paramMap);
    AppMethodBeat.o(231969);
    return null;
  }
  
  public final String er(String paramString)
  {
    AppMethodBeat.i(231967);
    this.QvF.PNo.h(this.Qqe.POu, this.Qqe.function + ':' + paramString, null);
    AppMethodBeat.o(231967);
    return null;
  }
  
  public final String getAppId()
  {
    return "";
  }
  
  public final Context getContext()
  {
    return this.QvF.context;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(231960);
    String str = (String)this.Qqe.params.get("url");
    AppMethodBeat.o(231960);
    return str;
  }
  
  public final String hbC()
  {
    AppMethodBeat.i(231958);
    if ((this.Qqe.PNI != null) && (this.Qqe.PNI.containsKey("name")))
    {
      String str = (String)this.Qqe.PNI.get("name");
      AppMethodBeat.o(231958);
      return str;
    }
    AppMethodBeat.o(231958);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f
 * JD-Core Version:    0.7.0.1
 */