package com.tencent.mm.plugin.profile.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$6
  implements Preference.b
{
  public a$6(b.b paramb, as paramas, b.a parama) {}
  
  public final boolean fpI()
  {
    AppMethodBeat.i(26871);
    try
    {
      Object localObject = new JSONObject(this.GWI.myc);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("pagepath");
      xw localxw = new xw();
      localxw.fWN.userName = str;
      localxw.fWN.fWP = Util.nullAs((String)localObject, "");
      EventCenter.instance.publish(localxw);
      h.IzE.a(15319, new Object[] { this.jkl.field_openImAppid, Integer.valueOf(this.GWI.action), this.GWJ.title });
      AppMethodBeat.o(26871);
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
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.6
 * JD-Core Version:    0.7.0.1
 */