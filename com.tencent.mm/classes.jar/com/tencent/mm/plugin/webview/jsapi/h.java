package com.tencent.mm.plugin.webview.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.c;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "", "context", "Landroid/content/Context;", "jsPerm", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IJsApiHandlerWrapper;", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/JsapiPermissionWrapper;Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;Lcom/tencent/mm/plugin/webview/jsapi/IJsApiHandlerWrapper;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IJsApiHandlerWrapper;", "getJsPerm", "()Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "getWv", "()Lcom/tencent/mm/ui/widget/MMWebView;", "getWebViewController", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getWebViewStubCallback", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_Callback_AIDL;", "hasPermission", "", "controlByte", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public final e WDy;
  public final MMWebView WDz;
  private final JsapiPermissionWrapper WlV;
  public Context context;
  public final com.tencent.mm.plugin.webview.stub.e sLC;
  
  public h(Context paramContext, JsapiPermissionWrapper paramJsapiPermissionWrapper, com.tencent.mm.plugin.webview.stub.e parame, e parame1, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(295245);
    this.context = paramContext;
    this.WlV = paramJsapiPermissionWrapper;
    this.WDy = parame1;
    this.sLC = parame;
    this.WDz = paramMMWebView;
    AppMethodBeat.o(295245);
  }
  
  public final f isi()
  {
    AppMethodBeat.i(295263);
    Object localObject = this.context;
    if ((localObject instanceof c))
    {
      localObject = (c)localObject;
      if (localObject != null) {
        break label65;
      }
      localObject = null;
      label28:
      if (localObject != null) {
        break label92;
      }
      localObject = this.WDy;
      if (!(localObject instanceof j)) {
        break label75;
      }
    }
    label65:
    label75:
    for (localObject = (j)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label80;
      }
      AppMethodBeat.o(295263);
      return null;
      localObject = null;
      break;
      localObject = ((c)localObject).isi();
      break label28;
    }
    label80:
    localObject = ((j)localObject).WDH;
    AppMethodBeat.o(295263);
    return localObject;
    label92:
    AppMethodBeat.o(295263);
    return localObject;
  }
  
  public final BaseWebViewController isj()
  {
    AppMethodBeat.i(295271);
    Object localObject = this.context;
    if ((localObject instanceof c))
    {
      localObject = (c)localObject;
      if (localObject != null) {
        break label65;
      }
      localObject = null;
      label28:
      if (localObject != null) {
        break label92;
      }
      localObject = this.WDy;
      if (!(localObject instanceof j)) {
        break label75;
      }
    }
    label65:
    label75:
    for (localObject = (j)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label80;
      }
      AppMethodBeat.o(295271);
      return null;
      localObject = null;
      break;
      localObject = ((c)localObject).isj();
      break label28;
    }
    label80:
    localObject = ((j)localObject).GXZ;
    AppMethodBeat.o(295271);
    return localObject;
    label92:
    AppMethodBeat.o(295271);
    return localObject;
  }
  
  public final void setContext(Context paramContext)
  {
    AppMethodBeat.i(295254);
    s.u(paramContext, "<set-?>");
    this.context = paramContext;
    AppMethodBeat.o(295254);
  }
  
  public final boolean sk(int paramInt)
  {
    AppMethodBeat.i(295257);
    JsapiPermissionWrapper localJsapiPermissionWrapper = this.WlV;
    if (localJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(295257);
      return false;
    }
    boolean bool = localJsapiPermissionWrapper.sk(paramInt);
    AppMethodBeat.o(295257);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.h
 * JD-Core Version:    0.7.0.1
 */