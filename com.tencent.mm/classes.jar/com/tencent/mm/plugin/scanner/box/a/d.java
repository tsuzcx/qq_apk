package com.tencent.mm.plugin.scanner.box.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiOpenFinderView;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"})
public final class d
  extends b
{
  public static final d IId;
  private static final String fXz = "openFinderView";
  
  static
  {
    AppMethodBeat.i(219559);
    IId = new d();
    fXz = "openFinderView";
    AppMethodBeat.o(219559);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(219558);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Log.i("MicroMsg.JsApiOpenFinderView", "openFinderView");
    String str = (String)paramn.params.get("extInfo");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("extInfo", new JSONObject(str));
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderUI(MMApplicationContext.getContext(), localJSONObject.toString());
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiOpenFinderView", (Throwable)localException, "openFinderView exception", new Object[0]);
        paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(219558);
    return bool;
  }
  
  public final String fCm()
  {
    return fXz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.d
 * JD-Core Version:    0.7.0.1
 */