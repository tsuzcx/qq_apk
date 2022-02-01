package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetUserConfig;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "changeListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "getChangeListener", "()Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "setChangeListener", "(Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;)V", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class m
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int IIl = 413;
  public static final m Qvf;
  private static final String fXz = "getUserConfig";
  
  static
  {
    AppMethodBeat.i(251991);
    Qvf = new m();
    IIl = 413;
    fXz = "getUserConfig";
    AppMethodBeat.o(251991);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(251986);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Map localMap = (Map)new HashMap();
    Object localObject = com.tencent.mm.ui.a.a.hJc();
    p.j(localObject, "AccessibilityHelper.getInstance()");
    localMap.put("isAccessibilityMode", Boolean.valueOf(((com.tencent.mm.ui.a.a)localObject).hJe()));
    Log.i("MicroMsg.JsApiGetUserConfig", "isAccessibilityMode:" + localMap.get("isAccessibilityMode"));
    localObject = fXz + ":ok";
    paramf.PNo.h(paramn.POu, (String)localObject, localMap);
    AppMethodBeat.o(251986);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.m
 * JD-Core Version:    0.7.0.1
 */