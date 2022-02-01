package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import org.json.JSONObject;

public class ag
  extends bv
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78570);
    int i = parama.eiZ.eif.optInt("id");
    if (i <= 0) {
      parama.a("fail", null);
    }
    String str = parama.eiZ.eif.optString("value");
    boolean bool1;
    if (parama.eiZ.eif.optInt("is_important") > 0)
    {
      bool1 = true;
      if (parama.eiZ.eif.optInt("is_report_now") <= 0) {
        break label108;
      }
    }
    for (;;)
    {
      h.OAn.b(i, str, bool2, bool1);
      parama.a("", null);
      AppMethodBeat.o(78570);
      return;
      bool1 = false;
      break;
      label108:
      bool2 = false;
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "kvReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ag
 * JD-Core Version:    0.7.0.1
 */