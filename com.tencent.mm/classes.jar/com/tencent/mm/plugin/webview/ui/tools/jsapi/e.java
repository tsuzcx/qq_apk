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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiH5ReuqestQueryCashier;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class e
  extends a
{
  private static final int IIl = 374;
  public static final e Qqa;
  private static final String TAG = "MicroMsg.JsApiH5ReuqestQueryCashier";
  private static final String fXz = "requestQueryCashier";
  
  static
  {
    AppMethodBeat.i(214626);
    Qqa = new e();
    TAG = "MicroMsg.JsApiH5ReuqestQueryCashier";
    IIl = 374;
    fXz = "requestQueryCashier";
    AppMethodBeat.o(214626);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, final n paramn)
  {
    AppMethodBeat.i(214624);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Log.i(TAG, "get data");
    Log.i(TAG, "data: %s", new Object[] { paramn.params.toString() });
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", (String)paramn.params.get("appId"));
    localBundle.putString("nonceStr", (String)paramn.params.get("nonceStr"));
    localBundle.putString("timeStamp", (String)paramn.params.get("timeStamp"));
    localBundle.putString("package", (String)paramn.params.get("package"));
    localBundle.putString("paySign", (String)paramn.params.get("paySign"));
    localBundle.putString("signType", (String)paramn.params.get("signType"));
    localBundle.putString("jsapiName", "requestQueryCashier");
    localBundle.putString("notifyType", "requestQueryCashier");
    localBundle.putInt("jsapi_type", 0);
    paramf = (com.tencent.mm.ipcinvoker.f)new a(paramf, paramn);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, IPCInvoke_KindaJSInvoke.class, paramf);
    AppMethodBeat.o(214624);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.e
 * JD-Core Version:    0.7.0.1
 */