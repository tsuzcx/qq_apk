package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiInvokeMiniProgramAPI;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "binderID", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "getBinderID", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;)I", "handleMsg", "", "env", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  private static final int OOk;
  public static final f Xip;
  static final String idA;
  
  static
  {
    AppMethodBeat.i(175672);
    Xip = new f();
    OOk = 295;
    idA = "invokeMiniProgramAPI";
    AppMethodBeat.o(175672);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297481);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject1 = (k)com.tencent.mm.kernel.h.ax(k.class);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null) {
        Log.e("MicroMsg.WebView.JsApiInvokeMiniProgramAPI", "invoke but get NULL IAppBrandServiceForWebView");
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(idA, ":ok"), null);
      AppMethodBeat.o(297481);
      return true;
      String str = paramp.WEI.optString("name");
      Object localObject2 = paramp.WEI.opt("arg");
      ((k)localObject1).a(paramh.WDy.getBinderID(), str, localObject2);
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f
 * JD-Core Version:    0.7.0.1
 */