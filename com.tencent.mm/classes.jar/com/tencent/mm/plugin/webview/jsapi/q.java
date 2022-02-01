package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/ScanWebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initJsApis", "", "jsApiList", "", "support", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements g
{
  public static final q WEK;
  private static Map<String, a> WEL;
  
  static
  {
    AppMethodBeat.i(295234);
    WEK = new q();
    WEL = (Map)new HashMap();
    AppMethodBeat.o(295234);
  }
  
  public static void ck(Map<String, ? extends a> paramMap)
  {
    AppMethodBeat.i(295231);
    s.u(paramMap, "jsApiList");
    WEL.clear();
    WEL.putAll(paramMap);
    AppMethodBeat.o(295231);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(295247);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    if (WEL.containsKey(paramp.function))
    {
      Object localObject = WEL.get(paramp.function);
      s.checkNotNull(localObject);
      localObject = (a)localObject;
      if (((a)localObject).gPZ() == 10007) {
        ((a)localObject).a(paramh, paramp);
      }
      for (;;)
      {
        AppMethodBeat.o(295247);
        return true;
        Log.e("MicroMsg.ScanWebViewJsApiPool", s.X("handleMsg access denied func: ", paramp.function));
        paramh.WDy.doCallback(paramp.WEH, "system:access_denied", null);
      }
    }
    AppMethodBeat.o(295247);
    return true;
  }
  
  public final boolean b(h paramh, p paramp)
  {
    AppMethodBeat.i(295240);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    if (!WEL.isEmpty()) {}
    for (int i = 1; (i != 0) && (s.p(paramh.WDy.itt(), this)); i = 0)
    {
      AppMethodBeat.o(295240);
      return true;
    }
    AppMethodBeat.o(295240);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.q
 * JD-Core Version:    0.7.0.1
 */