package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$5
  implements Preference.b
{
  public a$5(b.b paramb, as paramas, b.a parama) {}
  
  public final boolean a(Preference paramPreference)
  {
    AppMethodBeat.i(231802);
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    paramPreference = "";
    try
    {
      localObject = new JSONObject(this.BcI.jGY).optString("url");
      paramPreference = (Preference)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
    h.CyF.a(15319, new Object[] { this.gAi.field_openImAppid, Integer.valueOf(this.BcI.action), this.BcJ.title });
    localIntent.putExtra("geta8key_scene", 58);
    localIntent.putExtra("rawUrl", paramPreference);
    paramPreference = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramPreference, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramPreference.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramPreference, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(231802);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.5
 * JD-Core Version:    0.7.0.1
 */