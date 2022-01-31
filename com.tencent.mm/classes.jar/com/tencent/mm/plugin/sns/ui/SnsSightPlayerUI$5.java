package com.tencent.mm.plugin.sns.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsSightPlayerUI$5
  implements View.OnCreateContextMenuListener
{
  SnsSightPlayerUI$5(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(39253);
    if (bo.apV(g.Nq().getValue("SIGHTCannotTransmitForFav")) == 0)
    {
      boolean bool1 = com.tencent.mm.vfs.e.cN(SnsSightPlayerUI.e(this.rVT));
      boolean bool2 = com.tencent.mm.vfs.e.cN(SnsSightPlayerUI.u(this.rVT));
      ab.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        paramContextMenu.add(0, 3, 0, this.rVT.getString(2131303767));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (d.ahR("favorite")) {
        paramContextMenu.add(0, 2, 0, this.rVT.getString(2131302102));
      }
      if (i != 0)
      {
        paramView = new dr();
        paramView.crt.crk = SnsSightPlayerUI.f(this.rVT);
        a.ymk.l(paramView);
        if (paramView.cru.cqS) {
          paramContextMenu.add(0, 4, 0, this.rVT.getString(2131297019));
        }
      }
      if (!SnsSightPlayerUI.j(this.rVT)) {
        paramContextMenu.add(0, 1, 0, this.rVT.getContext().getString(2131304005));
      }
      AppMethodBeat.o(39253);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.5
 * JD-Core Version:    0.7.0.1
 */