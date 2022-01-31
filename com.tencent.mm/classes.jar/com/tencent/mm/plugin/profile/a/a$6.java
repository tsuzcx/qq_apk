package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$6
  implements Preference.b
{
  public a$6(c.b paramb, ad paramad, c.a parama) {}
  
  public final boolean cbH()
  {
    AppMethodBeat.i(23255);
    try
    {
      Object localObject = new JSONObject(this.pxG.gfJ);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      so localso = new so();
      localso.cIQ.userName = str;
      localso.cIQ.cIS = bo.bf((String)localObject, "");
      a.ymk.l(localso);
      h.qsU.e(15319, new Object[] { this.ejm.field_openImAppid, Integer.valueOf(this.pxG.action), this.pxH.title });
      AppMethodBeat.o(23255);
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.6
 * JD-Core Version:    0.7.0.1
 */