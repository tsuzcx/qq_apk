package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.a.b.b;
import com.tencent.mm.plugin.sns.ui.a.c;

final class SnsTimeLineUI$59
  implements Runnable
{
  SnsTimeLineUI$59(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(145619);
    if (SnsTimeLineUI.a(this.rYv) != null) {
      SnsTimeLineUI.a(this.rYv).sds.notifyVendingDataChange();
    }
    SnsTimeLineUI.W(this.rYv);
    AppMethodBeat.o(145619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.59
 * JD-Core Version:    0.7.0.1
 */