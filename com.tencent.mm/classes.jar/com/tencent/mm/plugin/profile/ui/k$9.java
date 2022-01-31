package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

final class k$9
  implements Preference.b
{
  k$9(k paramk, c.b paramb, c.a parama) {}
  
  public final boolean bsE()
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(ae.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    Object localObject = "";
    try
    {
      String str = new JSONObject(this.mXH.ePO).optString("url");
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
      }
    }
    h.nFQ.f(15319, new Object[] { this.mXC.dnp.field_openImAppid, Integer.valueOf(this.mXH.action), this.mXI.title });
    localIntent.putExtra("geta8key_scene", 58);
    localIntent.putExtra("rawUrl", (String)localObject);
    ae.getContext().startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.9
 * JD-Core Version:    0.7.0.1
 */