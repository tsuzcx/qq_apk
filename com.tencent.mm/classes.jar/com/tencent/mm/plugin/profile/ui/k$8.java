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

final class k$8
  implements Preference.b
{
  k$8(k paramk, c.b paramb, c.a parama) {}
  
  public final boolean bsE()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject(this.mXH.ePO).optString("mailto");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        y.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
      }
    }
    h.nFQ.f(15319, new Object[] { this.mXC.dnp.field_openImAppid, Integer.valueOf(this.mXH.action), this.mXI.title });
    localObject2 = new Intent("android.intent.action.SENDTO");
    ((Intent)localObject2).setData(Uri.parse("mailto:" + (String)localObject1));
    this.mXC.bMV.startActivity((Intent)localObject2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.8
 * JD-Core Version:    0.7.0.1
 */