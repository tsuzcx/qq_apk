package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

final class k$7
  implements Preference.b
{
  k$7(k paramk, c.b paramb, c.a parama) {}
  
  public final boolean bsE()
  {
    Object localObject = this.mXH.ePO;
    try
    {
      String str = new JSONObject(this.mXH.ePO).optString("tel");
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
      }
    }
    h.nFQ.f(15319, new Object[] { this.mXC.dnp.field_openImAppid, Integer.valueOf(this.mXH.action), this.mXI.title });
    localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + (String)localObject));
    ((Intent)localObject).setFlags(268435456);
    this.mXC.bMV.startActivity((Intent)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.7
 * JD-Core Version:    0.7.0.1
 */