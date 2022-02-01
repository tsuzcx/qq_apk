package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$5
  implements Preference.b
{
  public a$5(b.b paramb, an paraman, b.a parama) {}
  
  public final boolean dDy()
  {
    AppMethodBeat.i(26870);
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(ak.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject(this.xfe.iKs).optString("url");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        ae.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
    }
    g.yxI.f(15319, new Object[] { this.fVb.field_openImAppid, Integer.valueOf(this.xfe.action), this.xff.title });
    localIntent.putExtra("geta8key_scene", 58);
    localIntent.putExtra("rawUrl", (String)localObject1);
    localObject1 = ak.getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26870);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.5
 * JD-Core Version:    0.7.0.1
 */