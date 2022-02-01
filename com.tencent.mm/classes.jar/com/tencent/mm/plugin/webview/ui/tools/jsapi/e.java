package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiH5ReuqestQueryCashier;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final e Xio;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297392);
    Xio = new e();
    TAG = "MicroMsg.JsApiH5ReuqestQueryCashier";
    OOk = 374;
    idA = "requestQueryCashier";
    AppMethodBeat.o(297392);
  }
  
  private static final void a(h paramh, p paramp, Bundle paramBundle)
  {
    AppMethodBeat.i(297381);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    String str = paramBundle.getString("ret", "fail");
    paramh.WDy.doCallback(paramp.WEH, paramp.function + ':' + str, null);
    if ((paramBundle.getInt("closeWindow", 0) == 1) && ((paramh.context instanceof WebViewUI))) {
      ((WebViewUI)paramh.context).finish();
    }
    AppMethodBeat.o(297381);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297430);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i(TAG, "get data");
    Log.i(TAG, "data: %s", new Object[] { paramp.params.toString() });
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", (String)paramp.params.get("appId"));
    localBundle.putString("nonceStr", (String)paramp.params.get("nonceStr"));
    localBundle.putString("timeStamp", (String)paramp.params.get("timeStamp"));
    localBundle.putString("package", (String)paramp.params.get("package"));
    localBundle.putString("paySign", (String)paramp.params.get("paySign"));
    localBundle.putString("signType", (String)paramp.params.get("signType"));
    localBundle.putString("jsapiName", "requestQueryCashier");
    localBundle.putString("notifyType", "requestQueryCashier");
    localBundle.putInt("jsapi_type", 0);
    paramh = new e..ExternalSyntheticLambda0(paramh, paramp);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramh);
    AppMethodBeat.o(297430);
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.e
 * JD-Core Version:    0.7.0.1
 */