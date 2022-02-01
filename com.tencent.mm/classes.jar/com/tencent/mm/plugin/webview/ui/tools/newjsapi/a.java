package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getPluginType", "handleJsApi", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public abstract class a
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private final String TAG = "MicroMsg.BasePluginJsApi";
  
  public static c c(com.tencent.mm.plugin.webview.d.f paramf)
  {
    p.k(paramf, "env");
    if ((paramf.context instanceof com.tencent.mm.plugin.webview.ui.tools.video.samelayer.a))
    {
      paramf = paramf.context;
      if (paramf == null) {
        throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewExtendPluginClientProxy");
      }
      return ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.a)paramf).getWebViewPluginClientProxy();
    }
    return null;
  }
  
  public abstract String bNT();
  
  public final boolean d(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    p.k(paramf, "env");
    p.k(paramn, "msg");
    JSONObject localJSONObject = paramn.POv;
    if ((localJSONObject == null) || (!localJSONObject.has("viewId")))
    {
      Log.w(this.TAG, "no viewId in data");
      paramf.PNo.h(paramn.POu, paramn.function + "fail:no viewId in data", null);
      return false;
    }
    c localc = c(paramf);
    if (localc == null)
    {
      Log.w(this.TAG, "webview has no plugin client");
      paramf.PNo.h(paramn.POu, paramn.function + "fail:webview has no plugin client", null);
      return false;
    }
    int i = localJSONObject.optInt("viewId");
    paramf = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f(paramf, paramn);
    localc.a(bNT(), i, (com.tencent.luggage.xweb_ext.extendplugin.a)paramf);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.a
 * JD-Core Version:    0.7.0.1
 */