package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.ui.base.n.d;

final class SnsTimeLineUI$51
  implements n.d
{
  SnsTimeLineUI$51(SnsTimeLineUI paramSnsTimeLineUI, b paramb) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(155760);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(155760);
      return;
      long l = cb.abq();
      h.qsU.e(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.i.ls(l), Long.valueOf(l) });
      g.roZ.b(this.rYL);
      this.rYL.ake();
      SnsTimeLineUI.l(this.rYv).sbg = this.rYL;
      SnsTimeLineUI.l(this.rYv).Fd(1);
      SnsTimeLineUI.P(this.rYv).EZ(2);
      SnsTimeLineUI.b(SnsTimeLineUI.P(this.rYv));
      AppMethodBeat.o(155760);
      return;
      SnsTimeLineUI.P(this.rYv).EZ(1);
      SnsTimeLineUI.b(SnsTimeLineUI.P(this.rYv));
      SnsTimeLineUI.Q(this.rYv);
      AppMethodBeat.o(155760);
      return;
      SnsTimeLineUI.P(this.rYv).EZ(3);
      SnsTimeLineUI.b(SnsTimeLineUI.P(this.rYv));
      SnsTimeLineUI.R(this.rYv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.51
 * JD-Core Version:    0.7.0.1
 */