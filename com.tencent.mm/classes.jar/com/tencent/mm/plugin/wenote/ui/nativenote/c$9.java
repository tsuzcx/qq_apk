package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class c$9
  implements View.OnClickListener
{
  c$9(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30820);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().Z(-1, false);
    if (com.tencent.mm.aw.b.Gw((String)g.ajR().ajA().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue()) {
          com.tencent.mm.plugin.account.a.b.a.b((Activity)this.val$context, this.val$context.getResources().getString(2131760740, new Object[] { ad.fom() }), 30764, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30820);
          return;
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64);
        }
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ae.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30820);
        return;
      }
    }
    paramView = new Intent();
    paramView.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
    paramView.putExtra("map_view_type", 3);
    d.b(this.val$context, "location", ".ui.RedirectUI", paramView, 4098);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.9
 * JD-Core Version:    0.7.0.1
 */