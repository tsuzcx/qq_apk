package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPhoneBindCardVerifySmsWeb;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  private static final int CDJ = 370;
  public static final c JsB;
  private static final String TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
  private static final String edq = "phoneBindCardVerifySms";
  
  static
  {
    AppMethodBeat.i(210550);
    JsB = new c();
    TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
    CDJ = 370;
    edq = "phoneBindCardVerifySms";
    AppMethodBeat.o(210550);
  }
  
  public final boolean a(f paramf, final n paramn)
  {
    AppMethodBeat.i(210549);
    p.h(paramf, "env");
    p.h(paramn, "msg");
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
    paramf = (d)new a(paramf, paramn);
    h.a(MainProcessIPCService.dkO, (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramf);
    AppMethodBeat.o(210549);
    return true;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements d<Bundle>
  {
    a(f paramf, n paramn) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c
 * JD-Core Version:    0.7.0.1
 */