package com.tencent.mm.plugin.scanner.box.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiOpenFinderView;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  public static final d OOc;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(313797);
    OOc = new d();
    idA = "openFinderView";
    AppMethodBeat.o(313797);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(313813);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiOpenFinderView", "openFinderView");
    String str = (String)paramp.params.get("extInfo");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("extInfo", new JSONObject(str));
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderUI(MMApplicationContext.getContext(), localJSONObject.toString());
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiOpenFinderView", (Throwable)localException, "openFinderView exception", new Object[0]);
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(313813);
    return bool;
  }
  
  public final String gPX()
  {
    return idA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.d
 * JD-Core Version:    0.7.0.1
 */