package com.tencent.mm.plugin.scanner.box.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiReportKV;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b
{
  public static final e OOd;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(313784);
    OOd = new e();
    idA = "reportKV";
    AppMethodBeat.o(313784);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(313802);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.d("MicroMsg.JsApiReportKV", "ScanJsApi-Call:reportKV %s", new Object[] { paramp.params });
    try
    {
      paramh = new JSONObject(paramp.params);
      int i = paramh.optInt("logid", 0);
      paramh = paramh.optString("msg", "");
      s.s(paramh, "paramsObj.optString(\"msg\", \"\")");
      f.Ozc.kvStat(i, paramh);
      AppMethodBeat.o(313802);
      return true;
    }
    catch (Exception paramh)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiReportKV", (Throwable)paramh, "ScanJsApi-Call:reportKV exception", new Object[0]);
      }
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.e
 * JD-Core Version:    0.7.0.1
 */