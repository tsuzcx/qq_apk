package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.k.a.c.c;
import com.tencent.mm.plugin.webview.c.d;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getPluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getPluginType", "handleJsApi", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public abstract class a
  extends com.tencent.mm.plugin.webview.c.c.a
{
  final String TAG = "MicroMsg.BasePluginJsApi";
  
  public static c a(d paramd)
  {
    k.h(paramd, "env");
    if ((paramd.context instanceof com.tencent.mm.plugin.webview.ui.tools.c.a.a))
    {
      paramd = paramd.context;
      if (paramd == null) {
        throw new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewExtendPluginClientProxy");
      }
      return ((com.tencent.mm.plugin.webview.ui.tools.c.a.a)paramd).getWebViewPluginClientProxy();
    }
    return null;
  }
  
  public abstract String bcT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.a
 * JD-Core Version:    0.7.0.1
 */