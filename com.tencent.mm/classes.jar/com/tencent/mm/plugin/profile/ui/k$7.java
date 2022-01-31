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

final class k$7
  implements Preference.b
{
  k$7(k paramk, c.b paramb, c.a parama) {}
  
  public final boolean cbH()
  {
    AppMethodBeat.i(23571);
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject(this.pxG.gfJ).optString("mailto");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
      }
    }
    h.qsU.e(15319, new Object[] { this.pAx.contact.field_openImAppid, Integer.valueOf(this.pxG.action), this.pxH.title });
    localObject2 = new Intent("android.intent.action.SENDTO");
    ((Intent)localObject2).setData(Uri.parse("mailto:".concat(String.valueOf(localObject1))));
    this.pAx.cmc.startActivity((Intent)localObject2);
    AppMethodBeat.o(23571);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.7
 * JD-Core Version:    0.7.0.1
 */