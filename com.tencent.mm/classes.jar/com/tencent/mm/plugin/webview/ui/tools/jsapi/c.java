package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetPhoneBindCardVerifySmsWeb;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  private static final int CHh = 370;
  public static final c CHj;
  private static final String TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
  private static final String dxZ = "getPhoneBindCardVerifySms";
  
  static
  {
    AppMethodBeat.i(189467);
    CHj = new c();
    TAG = "MicroMsg.JsApiGetPhoneBindCardVerifySmsWeb";
    CHh = 370;
    dxZ = "getPhoneBindCardVerifySms";
    AppMethodBeat.o(189467);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189466);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    ac.i(TAG, "get data");
    Bundle localBundle = new Bundle();
    localBundle.putString("app_id", (String)paraml.vUl.get("appid"));
    localBundle.putString("nonce_str", (String)paraml.vUl.get("noncestr"));
    localBundle.putString("timeStamp", (String)paraml.vUl.get("timestamp"));
    localBundle.putString("package", (String)paraml.vUl.get("package"));
    localBundle.putString("signType", (String)paraml.vUl.get("signtype"));
    localBundle.putString("paySign", (String)paraml.vUl.get("paysign"));
    localBundle.putString("sessionid", (String)paraml.vUl.get("sessionid"));
    localBundle.putInt("jsapi_type", 0);
    paramd = (com.tencent.mm.ipcinvoker.d)new a(paramd, paraml);
    h.a("com.tencent.mm", (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramd);
    AppMethodBeat.o(189466);
    return true;
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
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