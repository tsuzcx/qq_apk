package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.c.av;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$6
  implements Preference.b
{
  public a$6(c.b paramb, ai paramai, c.a parama) {}
  
  public final boolean dpE()
  {
    AppMethodBeat.i(26871);
    try
    {
      Object localObject = new JSONObject(this.vIj.ioc);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      ut localut = new ut();
      localut.dxt.userName = str;
      localut.dxt.dxv = bs.bG((String)localObject, "");
      a.GpY.l(localut);
      h.wUl.f(15319, new Object[] { this.fzF.field_openImAppid, Integer.valueOf(this.vIj.action), this.vIk.title });
      AppMethodBeat.o(26871);
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.6
 * JD-Core Version:    0.7.0.1
 */