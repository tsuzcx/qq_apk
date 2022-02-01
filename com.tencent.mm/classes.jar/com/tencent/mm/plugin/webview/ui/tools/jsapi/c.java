package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPhoneBindCardVerifySmsWeb;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  private static final int IIl = 370;
  public static final c QpY;
  private static final String TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
  private static final String fXz = "phoneBindCardVerifySms";
  
  static
  {
    AppMethodBeat.i(247232);
    QpY = new c();
    TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
    IIl = 370;
    fXz = "phoneBindCardVerifySms";
    AppMethodBeat.o(247232);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, final n paramn)
  {
    AppMethodBeat.i(247230);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Log.i(TAG, "get data");
    Bundle localBundle = new Bundle();
    localBundle.putString("app_id", (String)paramn.params.get("appid"));
    localBundle.putString("nonce_str", (String)paramn.params.get("noncestr"));
    localBundle.putString("timeStamp", (String)paramn.params.get("timestamp"));
    localBundle.putString("package", (String)paramn.params.get("package"));
    localBundle.putString("signType", (String)paramn.params.get("signtype"));
    localBundle.putString("paySign", (String)paramn.params.get("paysign"));
    localBundle.putString("sessionid", (String)paramn.params.get("sessionid"));
    localBundle.putString("jsapiName", "phoneBindCardVerifySms");
    localBundle.putInt("jsapi_type", 0);
    paramf = (com.tencent.mm.ipcinvoker.f)new a(paramf, paramn);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramf);
    AppMethodBeat.o(247230);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements com.tencent.mm.ipcinvoker.f<Bundle>
  {
    a(com.tencent.mm.plugin.webview.d.f paramf, n paramn) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c
 * JD-Core Version:    0.7.0.1
 */