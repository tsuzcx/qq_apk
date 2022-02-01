package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetContext;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
{
  private static final int OOk;
  public static final k Xnb;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297769);
    Xnb = new k();
    OOk = 441;
    idA = "privateGetContext";
    AppMethodBeat.o(297769);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    int i = 0;
    AppMethodBeat.i(297784);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Map localMap = (Map)new HashMap();
    Object localObject = paramh.isj();
    if (localObject == null) {}
    for (;;)
    {
      localMap.put("currentRequestId", Integer.valueOf(i));
      if ((paramh.context instanceof com.tencent.mm.plugin.webview.core.c))
      {
        i = ((com.tencent.mm.plugin.webview.core.c)paramh.context).isk();
        if (i != 0) {
          localMap.put("lastRequestId", Integer.valueOf(i));
        }
      }
      new StringBuilder("privateGetContext currentRequestId=").append(localMap.get("currentRequestId")).append(", lastRequestId=").append(localMap.get("lastRequestId"));
      com.tencent.e.f.h.jXD();
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), localMap);
      AppMethodBeat.o(297784);
      return true;
      localObject = ((BaseWebViewController)localObject).irI();
      if (localObject != null) {
        i = ((com.tencent.mm.plugin.webview.e.c)localObject).WOQ;
      }
    }
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.k
 * JD-Core Version:    0.7.0.1
 */