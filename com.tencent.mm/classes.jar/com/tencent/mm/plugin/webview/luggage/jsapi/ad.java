package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import org.json.JSONObject;

public class ad
  extends bn
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(78570);
    int i = parama.bWS.bVY.optInt("id");
    if (i <= 0) {
      parama.a("fail", null);
    }
    String str = parama.bWS.bVY.optString("value");
    boolean bool1;
    if (parama.bWS.bVY.optInt("is_important") > 0)
    {
      bool1 = true;
      if (parama.bWS.bVY.optInt("is_report_now") <= 0) {
        break label108;
      }
    }
    for (;;)
    {
      h.wUl.a(i, str, bool2, bool1);
      parama.a("", null);
      AppMethodBeat.o(78570);
      return;
      bool1 = false;
      break;
      label108:
      bool2 = false;
    }
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "kvReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ad
 * JD-Core Version:    0.7.0.1
 */