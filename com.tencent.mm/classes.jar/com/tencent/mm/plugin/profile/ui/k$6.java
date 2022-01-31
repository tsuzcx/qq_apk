package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

final class k$6
  implements Preference.b
{
  k$6(k paramk, c.b paramb, c.a parama) {}
  
  public final boolean cbH()
  {
    AppMethodBeat.i(23570);
    Object localObject = this.pxG.gfJ;
    try
    {
      String str = new JSONObject(this.pxG.gfJ).optString("tel");
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
      }
    }
    h.qsU.e(15319, new Object[] { this.pAx.contact.field_openImAppid, Integer.valueOf(this.pxG.action), this.pxH.title });
    localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(localObject))));
    ((Intent)localObject).setFlags(268435456);
    this.pAx.cmc.startActivity((Intent)localObject);
    AppMethodBeat.o(23570);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.6
 * JD-Core Version:    0.7.0.1
 */