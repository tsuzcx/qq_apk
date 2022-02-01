package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bf;
import com.tencent.mm.plugin.webview.luggage.r.a;
import org.json.JSONException;
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
    bf.atG(0);
    paramg.iuk().bjZ("sendAppMessage");
    paramg.ejR.a(new d()
    {
      public final JSONObject aoe()
      {
        AppMethodBeat.i(296075);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("scene", "friend");
          label22:
          AppMethodBeat.o(296075);
          return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
          break label22;
        }
      }
      
      public final String name()
      {
        return "menu:share:appmessage";
      }
    });
    h.OAn.kJ(982, 9);
    AppMethodBeat.o(78706);
  }
  
  public final void a(Context paramContext, g paramg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(78705);
    if (paramg.Xp(21)) {
      params.a(this.id, paramContext.getString(c.i.readerapp_alert_retransmit), c.h.icons_filled_share, paramContext.getResources().getColor(c.c.Brand));
    }
    AppMethodBeat.o(78705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */