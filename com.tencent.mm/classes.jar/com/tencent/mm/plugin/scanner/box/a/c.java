package com.tencent.mm.plugin.scanner.box.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.scanner.f.a;
import com.tencent.mm.plugin.scanner.f.a.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiGetImageTransData;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  public static final c OOb;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(313795);
    OOb = new c();
    idA = "getImageTransData";
    AppMethodBeat.o(313795);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(313812);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    String str1 = (String)paramp.params.get("requestId");
    Object localObject1;
    Object localObject2;
    if (str1 == null)
    {
      str1 = "";
      localObject1 = (String)paramp.params.get("sessionId");
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = a.OUi;
      localObject1 = a.aUR((String)localObject2);
      if (localObject1 != null) {
        break label175;
      }
      localObject1 = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiGetImageTransData", "ScanJsApi-Call:getImageTransData sessionId: %s, requestId: %s, result: %s", new Object[] { localObject2, str1, localObject1 });
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("requestId", str1);
      ((HashMap)localObject2).put("json", localObject1);
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject2);
      AppMethodBeat.o(313812);
      return true;
      break;
      label175:
      String str2 = ((a.a)localObject1).result;
      localObject1 = str2;
      if (str2 == null) {
        localObject1 = "";
      }
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.c
 * JD-Core Version:    0.7.0.1
 */