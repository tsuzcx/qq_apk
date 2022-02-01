package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.plugin.webview.luggage.p.a;
import org.json.JSONObject;

public final class l
  extends a
{
  public l()
  {
    super(1);
  }
  
  public final void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(78706);
    ax.SL(0);
    paramf.ekX().awi("sendAppMessage");
    paramf.caI.a(new c()
    {
      public final JSONObject AM()
      {
        return null;
      }
      
      public final String name()
      {
        return "menu:share:appmessage";
      }
    });
    h.vKh.dB(982, 9);
    AppMethodBeat.o(78706);
  }
  
  public final void a(Context paramContext, f paramf, com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(78705);
    if (paramf.Em(21)) {
      paraml.a(this.id, paramContext.getString(2131762163), 2131689831);
    }
    AppMethodBeat.o(78705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */