package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.q.a;
import org.json.JSONObject;

public final class m
  extends a
{
  public m()
  {
    super(2);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78708);
    paramg.gbG().aYu("shareTimeline");
    paramg.ctS.a(new d()
    {
      public final JSONObject Ld()
      {
        return null;
      }
      
      public final String name()
      {
        return "menu:share:timeline";
      }
    });
    h.CyF.dN(982, 10);
    AppMethodBeat.o(78708);
  }
  
  public final void a(Context paramContext, g paramg, com.tencent.mm.ui.base.m paramm)
  {
    AppMethodBeat.i(78707);
    if (paramg.Oc(23)) {
      paramm.b(2, paramContext.getString(2131764185), 2131689830);
    }
    AppMethodBeat.o(78707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */