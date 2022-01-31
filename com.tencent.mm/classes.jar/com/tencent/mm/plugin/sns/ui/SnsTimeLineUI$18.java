package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsTimeLineUI$18
  implements Runnable
{
  SnsTimeLineUI$18(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39470);
    if (SnsTimeLineUI.a(this.rYv) == null)
    {
      AppMethodBeat.o(39470);
      return;
    }
    if (!SnsTimeLineUI.u(this.rYv))
    {
      ab.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[] { Integer.valueOf(SnsTimeLineUI.l(this.rYv).list.getFirstVisiblePosition() - SnsTimeLineUI.l(this.rYv).list.getHeaderViewsCount()) });
      ag.cpc().start();
      SnsTimeLineUI.a(this.rYv).sdr.cvX();
    }
    AppMethodBeat.o(39470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.18
 * JD-Core Version:    0.7.0.1
 */