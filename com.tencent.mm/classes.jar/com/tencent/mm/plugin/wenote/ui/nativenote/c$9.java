package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

final class c$9
  implements View.OnClickListener
{
  c$9(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30820);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().X(-1, false);
    if (com.tencent.mm.ax.b.yL((String)g.afB().afk().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.afB().afk().get(ae.a.FtT, Boolean.FALSE)).booleanValue())
        {
          a.b((Activity)this.val$context, this.val$context.getResources().getString(2131760740, new Object[] { ac.eFu() }), 30764, true);
          AppMethodBeat.o(30820);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64);
        AppMethodBeat.o(30820);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ad.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(30820);
        return;
      }
    }
    paramView = new Intent();
    paramView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
    paramView.putExtra("map_view_type", 3);
    d.b(this.val$context, "location", ".ui.RedirectUI", paramView, 4098);
    AppMethodBeat.o(30820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.9
 * JD-Core Version:    0.7.0.1
 */