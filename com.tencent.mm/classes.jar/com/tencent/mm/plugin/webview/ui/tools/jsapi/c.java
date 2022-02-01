package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPhoneBindCardVerifySmsWeb;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  private static final int Bpa = 370;
  public static final c Bpc;
  private static final String TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
  private static final String dAn = "getPhoneBindCardVerifySms";
  
  static
  {
    AppMethodBeat.i(188898);
    Bpc = new c();
    TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
    Bpa = 370;
    dAn = "getPhoneBindCardVerifySms";
    AppMethodBeat.o(188898);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188897);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    ad.i(TAG, "get data");
    Bundle localBundle = new Bundle();
    localBundle.putString("app_id", (String)paraml.uLu.get("appid"));
    localBundle.putString("nonce_str", (String)paraml.uLu.get("noncestr"));
    localBundle.putString("timeStamp", (String)paraml.uLu.get("timestamp"));
    localBundle.putString("package", (String)paraml.uLu.get("package"));
    localBundle.putString("signType", (String)paraml.uLu.get("signtype"));
    localBundle.putString("paySign", (String)paraml.uLu.get("paysign"));
    localBundle.putString("sessionid", (String)paraml.uLu.get("sessionid"));
    localBundle.putInt("jsapi_type", 0);
    paramd = (com.tencent.mm.ipcinvoker.d)new a(paramd, paraml);
    h.a("com.tencent.mm", (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramd);
    AppMethodBeat.o(188897);
    return true;
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
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