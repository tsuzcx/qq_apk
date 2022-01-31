package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import org.json.JSONObject;

public class aa
  extends bh
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(6322);
    int i = parama.byF.bxK.optInt("id");
    if (i <= 0) {
      parama.a("fail", null);
    }
    String str = parama.byF.bxK.optString("value");
    boolean bool1;
    if (parama.byF.bxK.optInt("is_important") > 0)
    {
      bool1 = true;
      if (parama.byF.bxK.optInt("is_report_now") <= 0) {
        break label110;
      }
    }
    for (;;)
    {
      h.qsU.a(i, str, bool2, bool1);
      parama.a("", null);
      AppMethodBeat.o(6322);
      return;
      bool1 = false;
      break;
      label110:
      bool2 = false;
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "kvReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aa
 * JD-Core Version:    0.7.0.1
 */