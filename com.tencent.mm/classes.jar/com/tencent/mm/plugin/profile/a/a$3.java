package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$3
  implements Preference.b
{
  public a$3(c.b paramb, ad paramad, c.a parama, Context paramContext) {}
  
  public final boolean cbH()
  {
    AppMethodBeat.i(23252);
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
        ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
      }
    }
    h.qsU.e(15319, new Object[] { this.ejm.field_openImAppid, Integer.valueOf(this.pxG.action), this.pxH.title });
    localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(localObject))));
    ((Intent)localObject).setFlags(268435456);
    this.val$context.startActivity((Intent)localObject);
    AppMethodBeat.o(23252);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.3
 * JD-Core Version:    0.7.0.1
 */