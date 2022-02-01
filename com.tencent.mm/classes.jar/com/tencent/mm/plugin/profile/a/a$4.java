package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.preference.Preference.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class a$4
  implements Preference.b
{
  public a$4(b.b paramb, an paraman, b.a parama, Context paramContext) {}
  
  public final boolean dDy()
  {
    AppMethodBeat.i(26869);
    localObject1 = "";
    try
    {
      localObject2 = new JSONObject(this.xfe.iKs).optString("mailto");
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        localObject1 = this.val$context;
        Object localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/OpenIMProfileLogic$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(26869);
        return true;
        localJSONException = localJSONException;
        ae.printErrStackTrace("MicroMsg.Profile.OpenIMProfileLogic", localJSONException, "loadProfile", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.Profile.OpenIMProfileLogic", "onPreferenceClick OPENIM_ACTION_OPEN_MAIL_BOX Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        }
      }
    }
    g.yxI.f(15319, new Object[] { this.fVb.field_openImAppid, Integer.valueOf(this.xfe.action), this.xff.title });
    localObject2 = new Intent("android.intent.action.SENDTO");
    ((Intent)localObject2).setData(Uri.parse("mailto:".concat(String.valueOf(localObject1))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.4
 * JD-Core Version:    0.7.0.1
 */