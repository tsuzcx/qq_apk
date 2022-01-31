package com.tencent.mm.plugin.sns.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsSightPlayerUI$5
  implements View.OnCreateContextMenuListener
{
  SnsSightPlayerUI$5(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (bk.ZR(g.AA().getValue("SIGHTCannotTransmitForFav")) == 0)
    {
      boolean bool1 = com.tencent.mm.vfs.e.bK(SnsSightPlayerUI.e(this.pdk));
      boolean bool2 = com.tencent.mm.vfs.e.bK(SnsSightPlayerUI.u(this.pdk));
      y.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        paramContextMenu.add(0, 3, 0, this.pdk.getString(i.j.sns_ad_video_right_menu_send_friend));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (d.SP("favorite")) {
        paramContextMenu.add(0, 2, 0, this.pdk.getString(i.j.plugin_favorite_opt));
      }
      if (i != 0)
      {
        paramView = new do();
        paramView.bJZ.bJQ = SnsSightPlayerUI.f(this.pdk);
        a.udP.m(paramView);
        if (paramView.bKa.bJy) {
          paramContextMenu.add(0, 4, 0, this.pdk.getString(i.j.app_open));
        }
      }
      if (!SnsSightPlayerUI.j(this.pdk)) {
        paramContextMenu.add(0, 1, 0, this.pdk.mController.uMN.getString(i.j.sns_timeline_expose));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.5
 * JD-Core Version:    0.7.0.1
 */