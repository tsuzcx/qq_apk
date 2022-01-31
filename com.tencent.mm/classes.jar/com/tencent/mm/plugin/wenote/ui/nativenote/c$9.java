package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.at.b;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class c$9
  implements View.OnClickListener
{
  c$9(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().ah(-1, false);
    if (b.mC((String)g.DP().Dz().get(274436, null)))
    {
      if (com.tencent.mm.pluginsdk.permission.a.j((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION")) {
        break label161;
      }
      if (!((Boolean)g.DP().Dz().get(ac.a.uzP, Boolean.valueOf(false))).booleanValue()) {
        com.tencent.mm.plugin.account.a.b.a.b((Activity)this.val$context, this.val$context.getResources().getString(R.l.location_use_scene_gdpr_url, new Object[] { x.cqJ() }), 30764, true);
      }
    }
    boolean bool;
    do
    {
      return;
      com.tencent.mm.pluginsdk.permission.a.b((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64);
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      y.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    } while (!bool);
    label161:
    paramView = new Intent();
    paramView.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
    paramView.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
    paramView.putExtra("map_view_type", 3);
    d.b(this.val$context, "location", ".ui.RedirectUI", paramView, 4098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.9
 * JD-Core Version:    0.7.0.1
 */