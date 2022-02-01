package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.q.a;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class m
  extends a
{
  public m()
  {
    super(2);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78708);
    paramg.ePj().aGY("shareTimeline");
    paramg.chX.a(new d()
    {
      public final JSONObject BO()
      {
        return null;
      }
      
      public final String name()
      {
        return "menu:share:timeline";
      }
    });
    com.tencent.mm.plugin.report.service.g.yhR.dD(982, 10);
    AppMethodBeat.o(78708);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, l paraml)
  {
    AppMethodBeat.i(78707);
    if (paramg.HC(23)) {
      paraml.a(2, paramContext.getString(2131762164), 2131689817);
    }
    AppMethodBeat.o(78707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */