package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

final class k$8
  implements Preference.b
{
  k$8(k paramk, c.b paramb, c.a parama) {}
  
  public final boolean cbH()
  {
    AppMethodBeat.i(23572);
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    Object localObject = "";
    try
    {
      String str = new JSONObject(this.pxG.gfJ).optString("url");
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
      }
    }
    h.qsU.e(15319, new Object[] { this.pAx.contact.field_openImAppid, Integer.valueOf(this.pxG.action), this.pxH.title });
    localIntent.putExtra("geta8key_scene", 58);
    localIntent.putExtra("rawUrl", (String)localObject);
    ah.getContext().startActivity(localIntent);
    AppMethodBeat.o(23572);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.8
 * JD-Core Version:    0.7.0.1
 */