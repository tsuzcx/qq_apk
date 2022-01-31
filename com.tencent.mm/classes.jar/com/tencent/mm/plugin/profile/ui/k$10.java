package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

final class k$10
  implements Preference.b
{
  k$10(k paramk, c.b paramb, c.a parama) {}
  
  public final boolean bsE()
  {
    try
    {
      Object localObject = new JSONObject(this.mXH.ePO);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      rc localrc = new rc();
      localrc.caq.userName = str;
      localrc.caq.cas = bk.aM((String)localObject, "");
      a.udP.m(localrc);
      h.nFQ.f(15319, new Object[] { this.mXC.dnp.field_openImAppid, Integer.valueOf(this.mXH.action), this.mXI.title });
      return true;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.10
 * JD-Core Version:    0.7.0.1
 */