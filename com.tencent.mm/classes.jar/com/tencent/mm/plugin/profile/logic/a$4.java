package com.tencent.mm.plugin.profile.logic;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.openim.api.g.a;
import com.tencent.mm.openim.api.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$4
  implements Preference.b
{
  public a$4(Context paramContext, g.b paramb, au paramau, g.a parama) {}
  
  public final boolean gAW()
  {
    AppMethodBeat.i(26869);
    Intent localIntent = new Intent();
    localIntent.setClassName(this.val$context, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject(this.MUB.prg).optString("url");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        Log.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
    h.OAn.b(15319, new Object[] { this.lMP.field_openImAppid, Integer.valueOf(this.MUB.action), this.MUC.title });
    localIntent.putExtra("geta8key_scene", 58);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localObject1 = this.val$context;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26869);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.logic.a.4
 * JD-Core Version:    0.7.0.1
 */