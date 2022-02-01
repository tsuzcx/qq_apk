package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$3
  implements Preference.b
{
  public a$3(c.b paramb, ai paramai, c.a parama, Context paramContext) {}
  
  public final boolean dpE()
  {
    AppMethodBeat.i(26868);
    Object localObject1 = this.vIj.ioc;
    try
    {
      localObject2 = new JSONObject(this.vIj.ioc).optString("tel");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2;
        ac.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
      }
    }
    h.wUl.f(15319, new Object[] { this.fzF.field_openImAppid, Integer.valueOf(this.vIj.action), this.vIk.title });
    localObject2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(localObject1))));
    ((Intent)localObject2).setFlags(268435456);
    localObject1 = this.val$context;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$3", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$3", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26868);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.3
 * JD-Core Version:    0.7.0.1
 */