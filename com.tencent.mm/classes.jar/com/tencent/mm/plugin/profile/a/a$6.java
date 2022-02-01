package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.au;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$6
  implements Preference.b
{
  public a$6(c.b paramb, af paramaf, c.a parama) {}
  
  public final boolean dbW()
  {
    AppMethodBeat.i(26871);
    try
    {
      Object localObject = new JSONObject(this.uzq.hNG);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      uj localuj = new uj();
      localuj.dzH.userName = str;
      localuj.dzH.dzJ = bt.by((String)localObject, "");
      a.ESL.l(localuj);
      h.vKh.f(15319, new Object[] { this.fvY.field_openImAppid, Integer.valueOf(this.uzq.action), this.uzr.title });
      AppMethodBeat.o(26871);
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.6
 * JD-Core Version:    0.7.0.1
 */