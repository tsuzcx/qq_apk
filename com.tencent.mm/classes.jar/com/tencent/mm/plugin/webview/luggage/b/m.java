package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.p.a;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class m
  extends a
{
  public m()
  {
    super(2);
  }
  
  public final void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(78708);
    paramf.ekX().awi("shareTimeline");
    paramf.caI.a(new c()
    {
      public final JSONObject AM()
      {
        return null;
      }
      
      public final String name()
      {
        return "menu:share:timeline";
      }
    });
    h.vKh.dB(982, 10);
    AppMethodBeat.o(78708);
  }
  
  public final void a(Context paramContext, f paramf, l paraml)
  {
    AppMethodBeat.i(78707);
    if (paramf.Em(23)) {
      paraml.a(2, paramContext.getString(2131762164), 2131689817);
    }
    AppMethodBeat.o(78707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */