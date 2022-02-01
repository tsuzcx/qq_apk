package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPhoneBindCardVerifySmsWeb;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  private static final int EkT = 370;
  public static final c EkV;
  private static final String TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
  private static final String dKm = "phoneBindCardVerifySms";
  
  static
  {
    AppMethodBeat.i(207602);
    EkV = new c();
    TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
    EkT = 370;
    dKm = "phoneBindCardVerifySms";
    AppMethodBeat.o(207602);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207601);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    ad.i(TAG, "get data");
    Bundle localBundle = new Bundle();
    localBundle.putString("app_id", (String)paraml.xaW.get("appid"));
    localBundle.putString("nonce_str", (String)paraml.xaW.get("noncestr"));
    localBundle.putString("timeStamp", (String)paraml.xaW.get("timestamp"));
    localBundle.putString("package", (String)paraml.xaW.get("package"));
    localBundle.putString("signType", (String)paraml.xaW.get("signtype"));
    localBundle.putString("paySign", (String)paraml.xaW.get("paysign"));
    localBundle.putString("sessionid", (String)paraml.xaW.get("sessionid"));
    localBundle.putString("jsapiName", "phoneBindCardVerifySms");
    localBundle.putInt("jsapi_type", 0);
    paramd = (com.tencent.mm.ipcinvoker.d)new a(paramd, paraml);
    h.a("com.tencent.mm", (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramd);
    AppMethodBeat.o(207601);
    return true;
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c
 * JD-Core Version:    0.7.0.1
 */