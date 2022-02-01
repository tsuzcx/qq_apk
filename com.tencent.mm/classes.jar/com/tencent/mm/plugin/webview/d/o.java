package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/jsapi/ScanWebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "TAG", "", "jsApis", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "initJsApis", "", "jsApiList", "", "support", "webview-sdk_release"})
public final class o
  implements e
{
  private static Map<String, a> ISh;
  public static final o ISi;
  
  static
  {
    AppMethodBeat.i(225114);
    ISi = new o();
    ISh = (Map)new HashMap();
    AppMethodBeat.o(225114);
  }
  
  public static void bM(Map<String, ? extends a> paramMap)
  {
    AppMethodBeat.i(225111);
    p.h(paramMap, "jsApiList");
    ISh.clear();
    ISh.putAll(paramMap);
    AppMethodBeat.o(225111);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(225113);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    if (ISh.containsKey(paramn.mhO))
    {
      Object localObject = ISh.get(paramn.mhO);
      if (localObject == null) {
        p.hyc();
      }
      localObject = (a)localObject;
      if (((a)localObject).ePA() == 10007) {
        ((a)localObject).a(paramf, paramn);
      }
      for (;;)
      {
        AppMethodBeat.o(225113);
        return true;
        Log.e("MicroMsg.ScanWebViewJsApiPool", "handleMsg access denied func: " + paramn.mhO);
        paramf.IQZ.h(paramn.ISe, "system:access_denied", null);
      }
    }
    AppMethodBeat.o(225113);
    return true;
  }
  
  public final boolean b(f paramf, n paramn)
  {
    AppMethodBeat.i(225112);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    if (!ISh.isEmpty()) {}
    for (int i = 1; (i != 0) && (p.j(paramf.IQZ.IKO, (o)this)); i = 0)
    {
      AppMethodBeat.o(225112);
      return true;
    }
    AppMethodBeat.o(225112);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.o
 * JD-Core Version:    0.7.0.1
 */