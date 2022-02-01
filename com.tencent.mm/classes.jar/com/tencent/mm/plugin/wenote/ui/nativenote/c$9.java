package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class c$9
  implements View.OnClickListener
{
  c$9(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30820);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramView.getContext()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30820);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().aw(-1, false);
    if (com.tencent.mm.au.b.OE((String)h.baE().ban().d(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.s((Activity)this.val$context, "android.permission.ACCESS_FINE_LOCATION"))
      {
        if (!((Boolean)h.baE().ban().get(at.a.acXn, Boolean.FALSE)).booleanValue()) {
          com.tencent.mm.plugin.account.sdk.c.a.b((Activity)this.val$context, this.val$context.getResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(30820);
          return;
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this.val$context, "android.permission.ACCESS_FINE_LOCATION", 64);
        }
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.val$context, "android.permission.ACCESS_FINE_LOCATION", 64, null);
      Log.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30820);
        return;
      }
    }
    paramView = new Intent();
    paramView.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
    paramView.putExtra("map_view_type", 3);
    com.tencent.mm.br.c.b(this.val$context, "location", ".ui.RedirectUI", paramView, 4098);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.9
 * JD-Core Version:    0.7.0.1
 */