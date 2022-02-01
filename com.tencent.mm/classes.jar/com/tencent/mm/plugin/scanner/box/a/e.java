package com.tencent.mm.plugin.scanner.box.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiReportKV;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-scan_release"})
public final class e
  extends b
{
  public static final e IIe;
  private static final String fXz = "reportKV";
  
  static
  {
    AppMethodBeat.i(217273);
    IIe = new e();
    fXz = "reportKV";
    AppMethodBeat.o(217273);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(217272);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Log.d("MicroMsg.JsApiReportKV", "ScanJsApi-Call:reportKV %s", new Object[] { paramn.params });
    try
    {
      paramf = new JSONObject(paramn.params);
      int i = paramf.optInt("logid", 0);
      paramf = paramf.optString("msg", "");
      p.j(paramf, "paramsObj.optString(\"msg\", \"\")");
      com.tencent.mm.plugin.report.f.Iyx.kvStat(i, paramf);
      AppMethodBeat.o(217272);
      return true;
    }
    catch (Exception paramf)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiReportKV", (Throwable)paramf, "ScanJsApi-Call:reportKV exception", new Object[0]);
      }
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.e
 * JD-Core Version:    0.7.0.1
 */