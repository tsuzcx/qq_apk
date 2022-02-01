package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import org.json.JSONObject;

public class ae
  extends bq
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78570);
    int i = parama.chh.cgn.optInt("id");
    if (i <= 0) {
      parama.a("fail", null);
    }
    String str = parama.chh.cgn.optString("value");
    boolean bool1;
    if (parama.chh.cgn.optInt("is_important") > 0)
    {
      bool1 = true;
      if (parama.chh.cgn.optInt("is_report_now") <= 0) {
        break label108;
      }
    }
    for (;;)
    {
      g.yxI.a(i, str, bool2, bool1);
      parama.a("", null);
      AppMethodBeat.o(78570);
      return;
      bool1 = false;
      break;
      label108:
      bool2 = false;
    }
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "kvReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ae
 * JD-Core Version:    0.7.0.1
 */