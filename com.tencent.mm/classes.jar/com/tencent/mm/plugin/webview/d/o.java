package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/ScanWebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initJsApis", "", "jsApiList", "", "support", "webview-sdk_release"})
public final class o
  implements e
{
  private static Map<String, a> POx;
  public static final o POy;
  
  static
  {
    AppMethodBeat.i(205398);
    POy = new o();
    POx = (Map)new HashMap();
    AppMethodBeat.o(205398);
  }
  
  public static void bR(Map<String, ? extends a> paramMap)
  {
    AppMethodBeat.i(205390);
    p.k(paramMap, "jsApiList");
    POx.clear();
    POx.putAll(paramMap);
    AppMethodBeat.o(205390);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(205396);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    if (POx.containsKey(paramn.function))
    {
      Object localObject = POx.get(paramn.function);
      if (localObject == null) {
        p.iCn();
      }
      localObject = (a)localObject;
      if (((a)localObject).fCn() == 10007) {
        ((a)localObject).a(paramf, paramn);
      }
      for (;;)
      {
        AppMethodBeat.o(205396);
        return true;
        Log.e("MicroMsg.ScanWebViewJsApiPool", "handleMsg access denied func: " + paramn.function);
        paramf.PNo.h(paramn.POu, "system:access_denied", null);
      }
    }
    AppMethodBeat.o(205396);
    return true;
  }
  
  public final boolean b(f paramf, n paramn)
  {
    AppMethodBeat.i(205392);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    if (!POx.isEmpty()) {}
    for (int i = 1; (i != 0) && (p.h(paramf.PNo.PGM, (o)this)); i = 0)
    {
      AppMethodBeat.o(205392);
      return true;
    }
    AppMethodBeat.o(205392);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.o
 * JD-Core Version:    0.7.0.1
 */