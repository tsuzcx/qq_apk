package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;

final class SnsTimeLineUI$17
  implements Runnable
{
  SnsTimeLineUI$17(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39469);
    if (SnsTimeLineUI.a(this.rYv) == null)
    {
      AppMethodBeat.o(39469);
      return;
    }
    if (SnsTimeLineUI.u(this.rYv)) {
      ag.cpc().pause();
    }
    AppMethodBeat.o(39469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.17
 * JD-Core Version:    0.7.0.1
 */