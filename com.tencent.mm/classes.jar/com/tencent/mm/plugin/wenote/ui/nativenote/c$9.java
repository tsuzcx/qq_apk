package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class c$9
  implements View.OnClickListener
{
  c$9(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27123);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().aw(-1, false);
    if (com.tencent.mm.au.b.tM((String)g.RL().Ru().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.RL().Ru().get(ac.a.yKH, Boolean.FALSE)).booleanValue())
        {
          a.b((Activity)this.val$context, this.val$context.getResources().getString(2131306183, new Object[] { aa.dsG() }), 30764, true);
          AppMethodBeat.o(27123);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64);
        AppMethodBeat.o(27123);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ab.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(27123);
        return;
      }
    }
    paramView = new Intent();
    paramView.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
    paramView.putExtra("map_view_type", 3);
    d.b(this.val$context, "location", ".ui.RedirectUI", paramView, 4098);
    AppMethodBeat.o(27123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.9
 * JD-Core Version:    0.7.0.1
 */