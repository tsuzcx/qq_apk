package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$4
  implements Preference.b
{
  public a$4(b.b paramb, as paramas, b.a parama, Context paramContext) {}
  
  public final boolean a(Preference paramPreference)
  {
    AppMethodBeat.i(231801);
    paramPreference = "";
    try
    {
      localObject = new JSONObject(this.BcI.jGY).optString("mailto");
      paramPreference = (Preference)localObject;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        paramPreference = this.val$context;
        Object localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramPreference, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramPreference.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramPreference, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(231801);
        return true;
        localJSONException = localJSONException;
        Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
      catch (Exception paramPreference)
      {
        for (;;)
        {
          Log.e("MicroMsg.Profile.OpenIMProfileLogic", "onPreferenceClick OPENIM_ACTION_OPEN_MAIL_BOX Exception:%s %s", new Object[] { paramPreference.getClass().getSimpleName(), paramPreference.getMessage() });
        }
      }
    }
    h.CyF.a(15319, new Object[] { this.gAi.field_openImAppid, Integer.valueOf(this.BcI.action), this.BcJ.title });
    localObject = new Intent("android.intent.action.SENDTO");
    ((Intent)localObject).setData(Uri.parse("mailto:".concat(String.valueOf(paramPreference))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.4
 * JD-Core Version:    0.7.0.1
 */