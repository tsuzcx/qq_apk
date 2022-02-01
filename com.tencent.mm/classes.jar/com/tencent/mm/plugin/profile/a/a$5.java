package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$5
  implements Preference.b
{
  public a$5(c.b paramb, af paramaf, c.a parama) {}
  
  public final boolean dbW()
  {
    AppMethodBeat.i(26870);
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(aj.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject(this.uzq.hNG).optString("url");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        ad.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
    h.vKh.f(15319, new Object[] { this.fvY.field_openImAppid, Integer.valueOf(this.uzq.action), this.uzr.title });
    localIntent.putExtra("geta8key_scene", 58);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localObject1 = aj.getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26870);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.5
 * JD-Core Version:    0.7.0.1
 */