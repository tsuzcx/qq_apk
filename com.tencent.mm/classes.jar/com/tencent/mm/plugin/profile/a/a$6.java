package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$6
  implements Preference.b
{
  public a$6(b.b paramb, an paraman, b.a parama) {}
  
  public final boolean dDy()
  {
    AppMethodBeat.i(26871);
    try
    {
      Object localObject = new JSONObject(this.xfe.iKs);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      vq localvq = new vq();
      localvq.dKT.userName = str;
      localvq.dKT.dKV = bu.bI((String)localObject, "");
      a.IvT.l(localvq);
      g.yxI.f(15319, new Object[] { this.fVb.field_openImAppid, Integer.valueOf(this.xfe.action), this.xff.title });
      AppMethodBeat.o(26871);
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.6
 * JD-Core Version:    0.7.0.1
 */