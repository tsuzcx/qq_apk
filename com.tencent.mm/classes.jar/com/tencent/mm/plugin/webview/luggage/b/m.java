package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.r.a;
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
    paramg.iuk().bjZ("shareTimeline");
    paramg.ejR.a(new d()
    {
      public final JSONObject aoe()
      {
        return null;
      }
      
      public final String name()
      {
        return "menu:share:timeline";
      }
    });
    h.OAn.kJ(982, 10);
    AppMethodBeat.o(78708);
  }
  
  public final void a(Context paramContext, g paramg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(78707);
    if (paramg.Xp(23)) {
      params.a(2, paramContext.getString(c.i.readerapp_alert_share_to_timeline), c.h.bottomsheet_icon_moment, 0);
    }
    AppMethodBeat.o(78707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */