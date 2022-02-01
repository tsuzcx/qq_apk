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

public final class a$4
  implements Preference.b
{
  public a$4(c.b paramb, ai paramai, c.a parama, Context paramContext) {}
  
  public final boolean dpE()
  {
    AppMethodBeat.i(26869);
    localObject1 = "";
    try
    {
      localObject2 = new JSONObject(this.vIj.ioc).optString("mailto");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        localObject1 = this.val$context;
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26869);
        return true;
        localJSONException = localJSONException;
        ac.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.Profile.OpenIMProfileLogic", "onPreferenceClick OPENIM_ACTION_OPEN_MAIL_BOX Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        }
      }
    }
    h.wUl.f(15319, new Object[] { this.fzF.field_openImAppid, Integer.valueOf(this.vIj.action), this.vIk.title });
    localObject2 = new Intent("android.intent.action.SENDTO");
    ((Intent)localObject2).setData(Uri.parse("mailto:".concat(String.valueOf(localObject1))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.4
 * JD-Core Version:    0.7.0.1
 */