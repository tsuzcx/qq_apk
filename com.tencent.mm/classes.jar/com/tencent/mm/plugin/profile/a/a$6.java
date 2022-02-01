package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$6
  implements Preference.b
{
  public a$6(c.b paramb, am paramam, c.a parama) {}
  
  public final boolean dAh()
  {
    AppMethodBeat.i(26871);
    try
    {
      Object localObject = new JSONObject(this.wPq.iHz);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      vm localvm = new vm();
      localvm.dJF.userName = str;
      localvm.dJF.dJH = bt.bI((String)localObject, "");
      a.IbL.l(localvm);
      g.yhR.f(15319, new Object[] { this.fSV.field_openImAppid, Integer.valueOf(this.wPq.action), this.wPr.title });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.6
 * JD-Core Version:    0.7.0.1
 */