package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$6
  implements Preference.b
{
  public a$6(b.b paramb, as paramas, b.a parama) {}
  
  public final boolean a(Preference paramPreference)
  {
    AppMethodBeat.i(231803);
    try
    {
      Object localObject = new JSONObject(this.BcI.jGY);
      paramPreference = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      wq localwq = new wq();
      localwq.ecI.userName = paramPreference;
      localwq.ecI.ecK = Util.nullAs((String)localObject, "");
      EventCenter.instance.publish(localwq);
      h.CyF.a(15319, new Object[] { this.gAi.field_openImAppid, Integer.valueOf(this.BcI.action), this.BcJ.title });
      AppMethodBeat.o(231803);
      return true;
    }
    catch (JSONException paramPreference)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", paramPreference, "loadProfile", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.6
 * JD-Core Version:    0.7.0.1
 */