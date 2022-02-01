package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "", "context", "Landroid/content/Context;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getWv", "()Lcom/tencent/mm/ui/widget/MMWebView;", "hasPermission", "", "controlByte", "", "webview-sdk_release"})
public final class f
{
  public final h PNo;
  public final MMWebView PNp;
  private final JsapiPermissionWrapper PvI;
  public Context context;
  public final e pGC;
  
  public f(Context paramContext, JsapiPermissionWrapper paramJsapiPermissionWrapper, e parame, h paramh, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(206243);
    this.context = paramContext;
    this.PvI = paramJsapiPermissionWrapper;
    this.pGC = parame;
    this.PNo = paramh;
    this.PNp = paramMMWebView;
    AppMethodBeat.o(206243);
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(206242);
    p.k(paramContext, "<set-?>");
    this.context = paramContext;
    AppMethodBeat.o(206242);
  }
  
  public final boolean so(int paramInt)
  {
    AppMethodBeat.i(206241);
    boolean bool = this.PvI.so(paramInt);
    AppMethodBeat.o(206241);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.f
 * JD-Core Version:    0.7.0.1
 */