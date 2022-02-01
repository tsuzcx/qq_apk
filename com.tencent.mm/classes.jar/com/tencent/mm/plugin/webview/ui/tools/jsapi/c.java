package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPhoneBindCardVerifySmsWeb;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  private static final int ECX = 370;
  public static final c ECZ;
  private static final String TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
  private static final String dLB = "phoneBindCardVerifySms";
  
  static
  {
    AppMethodBeat.i(199358);
    ECZ = new c();
    TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
    ECX = 370;
    dLB = "phoneBindCardVerifySms";
    AppMethodBeat.o(199358);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199357);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    ae.i(TAG, "get data");
    Bundle localBundle = new Bundle();
    localBundle.putString("app_id", (String)paraml.xqN.get("appid"));
    localBundle.putString("nonce_str", (String)paraml.xqN.get("noncestr"));
    localBundle.putString("timeStamp", (String)paraml.xqN.get("timestamp"));
    localBundle.putString("package", (String)paraml.xqN.get("package"));
    localBundle.putString("signType", (String)paraml.xqN.get("signtype"));
    localBundle.putString("paySign", (String)paraml.xqN.get("paysign"));
    localBundle.putString("sessionid", (String)paraml.xqN.get("sessionid"));
    localBundle.putString("jsapiName", "phoneBindCardVerifySms");
    localBundle.putInt("jsapi_type", 0);
    paramd = (com.tencent.mm.ipcinvoker.d)new a(paramd, paraml);
    h.a("com.tencent.mm", (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramd);
    AppMethodBeat.o(199357);
    return true;
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
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