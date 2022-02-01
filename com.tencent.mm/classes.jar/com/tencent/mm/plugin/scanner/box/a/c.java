package com.tencent.mm.plugin.scanner.box.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.scanner.f.a;
import com.tencent.mm.plugin.scanner.f.a.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiGetImageTransData;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"})
public final class c
  extends b
{
  public static final c IIc;
  private static final String fXz = "getImageTransData";
  
  static
  {
    AppMethodBeat.i(221816);
    IIc = new c();
    fXz = "getImageTransData";
    AppMethodBeat.o(221816);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(221811);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    String str1 = (String)paramn.params.get("requestId");
    if (str1 == null) {
      str1 = "";
    }
    for (;;)
    {
      Object localObject2 = (String)paramn.params.get("sessionId");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = a.INg;
      localObject2 = a.aXm((String)localObject1);
      if (localObject2 != null)
      {
        String str2 = ((a.a)localObject2).result;
        localObject2 = str2;
        if (str2 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      Log.i("MicroMsg.JsApiGetImageTransData", "ScanJsApi-Call:getImageTransData sessionId: %s, requestId: %s, result: %s", new Object[] { localObject1, str1, localObject2 });
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("requestId", str1);
      ((HashMap)localObject1).put("json", localObject2);
      paramf.PNo.h(paramn.POu, paramn.function + ":ok", (Map)localObject1);
      AppMethodBeat.o(221811);
      return true;
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.c
 * JD-Core Version:    0.7.0.1
 */