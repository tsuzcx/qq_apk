package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.g;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initJsApis", "", "jsApiList", "", "isLog", "support", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements g
{
  private static Map<String, a> WEL;
  public static final d WPX;
  
  static
  {
    AppMethodBeat.i(294618);
    WPX = new d();
    WEL = (Map)new HashMap();
    AppMethodBeat.o(294618);
  }
  
  public static void ck(Map<String, ? extends a> paramMap)
  {
    AppMethodBeat.i(294607);
    s.u(paramMap, "jsApiList");
    WEL.clear();
    WEL.putAll(paramMap);
    AppMethodBeat.o(294607);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(294637);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    if (WEL.containsKey(paramp.function))
    {
      Object localObject = WEL.get(paramp.function);
      s.checkNotNull(localObject);
      localObject = (a)localObject;
      if (paramh.sk(((a)localObject).gPZ())) {
        ((a)localObject).a(paramh, paramp);
      }
      for (;;)
      {
        AppMethodBeat.o(294637);
        return true;
        Log.e("MicroMsg.WebPrefetcherJsApiPool", s.X("handleMsg access denied func: ", paramp.function));
        if (!s.p(paramp.function, "log")) {
          paramh.WDy.doCallback(paramp.WEH, "system:access_denied", null);
        }
      }
    }
    paramh.WDy.doCallback(paramp.WEH, "system:function_not_exist", null);
    AppMethodBeat.o(294637);
    return false;
  }
  
  public final boolean b(h paramh, p paramp)
  {
    AppMethodBeat.i(294629);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    if (!WEL.isEmpty()) {}
    for (int i = 1; (i != 0) && (s.p(paramh.WDy.itt(), this)); i = 0)
    {
      AppMethodBeat.o(294629);
      return true;
    }
    AppMethodBeat.o(294629);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.d
 * JD-Core Version:    0.7.0.1
 */