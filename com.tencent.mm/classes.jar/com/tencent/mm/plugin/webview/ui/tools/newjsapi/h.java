package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiFastBindCardGetResult;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final h XmV;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297863);
    XmV = new h();
    TAG = "MicroMsg.JsApiFastBindCardGetResult";
    OOk = 402;
    idA = "fastBindCardGetResult";
    AppMethodBeat.o(297863);
  }
  
  private static final void a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp, Bundle paramBundle)
  {
    AppMethodBeat.i(297858);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    String str = paramBundle.getString("ret", "fail");
    paramh.WDy.doCallback(paramp.WEH, paramp.function + ':' + str, null);
    if ((paramBundle.getInt("closeWindow", 0) == 1) && ((paramh.context instanceof WebViewUI))) {
      ((WebViewUI)paramh.context).finish();
    }
    AppMethodBeat.o(297858);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297880);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i(TAG, "get data");
    Bundle localBundle = new Bundle();
    localBundle.putString("app_id", (String)paramp.params.get("appid"));
    localBundle.putString("nonce_str", (String)paramp.params.get("noncestr"));
    localBundle.putString("timeStamp", (String)paramp.params.get("timestamp"));
    localBundle.putString("package", (String)paramp.params.get("package"));
    localBundle.putString("signType", (String)paramp.params.get("signtype"));
    localBundle.putString("paySign", (String)paramp.params.get("paysign"));
    localBundle.putString("sessionid", (String)paramp.params.get("sessionid"));
    localBundle.putString("jsapiName", idA);
    localBundle.putInt("jsapi_type", 0);
    paramh = new h..ExternalSyntheticLambda0(paramh, paramp);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramh);
    AppMethodBeat.o(297880);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.h
 * JD-Core Version:    0.7.0.1
 */