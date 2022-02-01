package com.tencent.mm.plugin.webview.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.widget.MMWebView;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "", "context", "Landroid/content/Context;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getContext", "()Landroid/content/Context;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getWv", "()Lcom/tencent/mm/ui/widget/MMWebView;", "hasPermission", "", "controlByte", "", "webview-sdk_release"})
public final class d
{
  final JsapiPermissionWrapper ARc;
  public final f ARd;
  public final MMWebView ARe;
  public final Context context;
  private final e kxf;
  
  public d(Context paramContext, JsapiPermissionWrapper paramJsapiPermissionWrapper, e parame, f paramf, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(189393);
    this.context = paramContext;
    this.ARc = paramJsapiPermissionWrapper;
    this.kxf = parame;
    this.ARd = paramf;
    this.ARe = paramMMWebView;
    AppMethodBeat.o(189393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.d
 * JD-Core Version:    0.7.0.1
 */