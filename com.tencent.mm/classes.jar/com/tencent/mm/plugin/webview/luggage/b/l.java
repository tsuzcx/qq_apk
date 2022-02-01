package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.ba;
import com.tencent.mm.plugin.webview.luggage.q.a;
import org.json.JSONObject;

public final class l
  extends a
{
  public l()
  {
    super(1);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78706);
    ba.Xq(0);
    paramg.eSV().aIs("sendAppMessage");
    paramg.chX.a(new d()
    {
      public final JSONObject BP()
      {
        return null;
      }
      
      public final String name()
      {
        return "menu:share:appmessage";
      }
    });
    com.tencent.mm.plugin.report.service.g.yxI.dD(982, 9);
    AppMethodBeat.o(78706);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(78705);
    if (paramg.HZ(21)) {
      paraml.a(this.id, paramContext.getString(2131762163), 2131689831);
    }
    AppMethodBeat.o(78705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */