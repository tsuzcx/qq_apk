package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;)V", "getEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getMsg", "()Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "addLifecycleListener", "", "listener", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext$LifecycleListener;", "callbackResult", "", "result", "map", "", "", "getAppId", "getAsyncHandler", "Landroid/os/Handler;", "getComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getContext", "Landroid/content/Context;", "getCurrentUrl", "getInvokeData", "Lorg/json/JSONObject;", "getInvokeName", "getJsApi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getWebComptName", "isCreatePluginInvoke", "", "isSyncInvoke", "removeLifecycleListener", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements a
{
  public static final a Xor;
  private final p Xit;
  final h Xnu;
  
  static
  {
    AppMethodBeat.i(297118);
    Xor = new a((byte)0);
    AppMethodBeat.o(297118);
  }
  
  public f(h paramh, p paramp)
  {
    AppMethodBeat.i(297115);
    this.Xnu = paramh;
    this.Xit = paramp;
    AppMethodBeat.o(297115);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(297162);
    if ((this.Xnu.context instanceof d)) {
      ((d)this.Xnu.context).c(parama);
    }
    AppMethodBeat.o(297162);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.f aqX()
  {
    return null;
  }
  
  public final boolean atv()
  {
    return false;
  }
  
  public final JSONObject atw()
  {
    AppMethodBeat.i(297136);
    JSONObject localJSONObject = this.Xit.WEI;
    s.s(localJSONObject, "msg.rawParams");
    AppMethodBeat.o(297136);
    return localJSONObject;
  }
  
  public final String atx()
  {
    AppMethodBeat.i(297141);
    String str = this.Xit.function;
    s.s(str, "msg.function");
    AppMethodBeat.o(297141);
    return str;
  }
  
  public final void aty() {}
  
  public final boolean atz()
  {
    AppMethodBeat.i(297182);
    Object localObject = atw();
    if (localObject == null)
    {
      AppMethodBeat.o(297182);
      return false;
    }
    localObject = ((JSONObject)localObject).optString("action", "");
    if (localObject == null)
    {
      AppMethodBeat.o(297182);
      return false;
    }
    boolean bool = n.U((String)localObject, "insert", false);
    AppMethodBeat.o(297182);
    return bool;
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(297171);
    if (((this.Xnu.context instanceof d)) && (parama != null)) {
      ((d)this.Xnu.context).d(parama);
    }
    AppMethodBeat.o(297171);
  }
  
  public final String e(String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(297155);
    this.Xnu.WDy.doCallback(this.Xit.WEH, this.Xit.function + ':' + paramString, paramMap);
    AppMethodBeat.o(297155);
    return null;
  }
  
  public final String fO(String paramString)
  {
    AppMethodBeat.i(297146);
    this.Xnu.WDy.doCallback(this.Xit.WEH, this.Xit.function + ':' + paramString, null);
    AppMethodBeat.o(297146);
    return null;
  }
  
  public final String getAppId()
  {
    return "";
  }
  
  public final Context getContext()
  {
    return this.Xnu.context;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(297129);
    String str = (String)this.Xit.params.get("url");
    AppMethodBeat.o(297129);
    return str;
  }
  
  public final String iBP()
  {
    AppMethodBeat.i(297125);
    if ((this.Xit.WDU != null) && (this.Xit.WDU.containsKey("name")))
    {
      String str = (String)this.Xit.WDU.get("name");
      AppMethodBeat.o(297125);
      return str;
    }
    AppMethodBeat.o(297125);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f
 * JD-Core Version:    0.7.0.1
 */