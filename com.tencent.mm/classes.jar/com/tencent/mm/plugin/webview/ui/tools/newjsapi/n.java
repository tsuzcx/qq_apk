package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.a.a.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetUserConfig;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "changeListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "getChangeListener", "()Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "setChangeListener", "(Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;)V", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "GetUserConfigTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final n Xnf;
  public static final String idA;
  
  static
  {
    AppMethodBeat.i(297796);
    Xnf = new n();
    OOk = 413;
    idA = "getUserConfig";
    AppMethodBeat.o(297796);
  }
  
  private static final void a(Map paramMap, h paramh, p paramp, IPCBoolean paramIPCBoolean)
  {
    AppMethodBeat.i(297791);
    s.u(paramMap, "$params");
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    paramMap.put("isAccessibilityMode", Boolean.valueOf(a.a.jlv().jls()));
    paramMap.put("isCareMode", Boolean.valueOf(paramIPCBoolean.value));
    Log.i("MicroMsg.JsApiGetUserConfig", "isAccessibilityMode:" + paramMap.get("isAccessibilityMode") + ", isCareMode:" + paramMap.get("isCareMode"));
    paramIPCBoolean = s.X(idA, ":ok");
    paramh.WDy.doCallback(paramp.WEH, paramIPCBoolean, paramMap);
    AppMethodBeat.o(297791);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297818);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Map localMap = (Map)new HashMap();
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, a.class, new n..ExternalSyntheticLambda0(localMap, paramh, paramp));
    AppMethodBeat.o(297818);
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
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetUserConfig$GetUserConfigTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<IPCVoid, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.n
 * JD-Core Version:    0.7.0.1
 */