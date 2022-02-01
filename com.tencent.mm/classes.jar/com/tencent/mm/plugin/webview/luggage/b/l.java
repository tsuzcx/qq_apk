package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.plugin.webview.luggage.q.a;
import com.tencent.mm.ui.base.m;
import org.json.JSONObject;

public final class l
  extends a
{
  public l()
  {
    super(1);
  }
  
  public final void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(78706);
    bb.afY(0);
    paramg.gbG().aYu("sendAppMessage");
    paramg.ctS.a(new d()
    {
      public final JSONObject Ld()
      {
        return null;
      }
      
      public final String name()
      {
        return "menu:share:appmessage";
      }
    });
    h.CyF.dN(982, 9);
    AppMethodBeat.o(78706);
  }
  
  public final void a(Context paramContext, g paramg, m paramm)
  {
    AppMethodBeat.i(78705);
    if (paramg.Oc(21)) {
      paramm.b(this.id, paramContext.getString(2131764184), 2131689844);
    }
    AppMethodBeat.o(78705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */