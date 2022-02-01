package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.mm.plugin.webview.d.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getPluginType", "handleJsApi", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public abstract class a
  extends com.tencent.mm.plugin.webview.d.c.a
{
  final String TAG = "MicroMsg.BasePluginJsApi";
  
  public static c c(f paramf)
  {
    p.h(paramf, "env");
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
  
  public abstract String bCy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.a
 * JD-Core Version:    0.7.0.1
 */