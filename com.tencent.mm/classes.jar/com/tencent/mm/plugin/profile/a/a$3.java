package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$3
  implements Preference.b
{
  public a$3(c.b paramb, am paramam, c.a parama, Context paramContext) {}
  
  public final boolean dAh()
  {
    AppMethodBeat.i(26868);
    Object localObject1 = this.wPq.iHz;
    try
    {
      localObject2 = new JSONObject(this.wPq.iHz).optString("tel");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        ad.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
      }
    }
    g.yhR.f(15319, new Object[] { this.fSV.field_openImAppid, Integer.valueOf(this.wPq.action), this.wPr.title });
    localObject2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(localObject1))));
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.val$context;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$3", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$3", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26868);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.3
 * JD-Core Version:    0.7.0.1
 */