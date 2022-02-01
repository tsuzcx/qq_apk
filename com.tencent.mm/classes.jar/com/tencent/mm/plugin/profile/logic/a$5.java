package com.tencent.mm.plugin.profile.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.openim.api.g.a;
import com.tencent.mm.openim.api.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$5
  implements Preference.b
{
  public a$5(g.b paramb, au paramau, g.a parama) {}
  
  public final boolean gAW()
  {
    AppMethodBeat.i(26870);
    try
    {
      Object localObject = new JSONObject(this.MUB.prg);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      zp localzp = new zp();
      localzp.icM.userName = str;
      localzp.icM.icO = Util.nullAs((String)localObject, "");
      localzp.publish();
      h.OAn.b(15319, new Object[] { this.lMP.field_openImAppid, Integer.valueOf(this.MUB.action), this.MUC.title });
      AppMethodBeat.o(26870);
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.logic.a.5
 * JD-Core Version:    0.7.0.1
 */