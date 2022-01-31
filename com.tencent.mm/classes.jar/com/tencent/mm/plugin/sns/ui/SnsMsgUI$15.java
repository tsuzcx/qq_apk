package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.p.a;

final class SnsMsgUI$15
  implements p.a
{
  SnsMsgUI$15(SnsMsgUI paramSnsMsgUI) {}
  
  public final void apT()
  {
    AppMethodBeat.i(39081);
    ab.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.e(this.rSU).eke + " unread:" + ag.cpk().bbZ() + "  showcount:" + SnsMsgUI.e(this.rSU).kxm);
    if (SnsMsgUI.e(this.rSU).getCount() == 0)
    {
      SnsMsgUI.c(this.rSU).setVisibility(8);
      SnsMsgUI.d(this.rSU).setVisibility(0);
      this.rSU.enableOptionMenu(false);
    }
    for (;;)
    {
      if (((SnsMsgUI.e(this.rSU).bem()) && (ag.cpk().bbZ() == 0)) || (ag.cpk().bbZ() == ag.cpk().cst())) {
        SnsMsgUI.f(this.rSU).setVisibility(8);
      }
      AppMethodBeat.o(39081);
      return;
      SnsMsgUI.c(this.rSU).setVisibility(0);
      SnsMsgUI.d(this.rSU).setVisibility(8);
      this.rSU.enableOptionMenu(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.15
 * JD-Core Version:    0.7.0.1
 */