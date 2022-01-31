package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.a.b.b;
import com.tencent.mm.plugin.sns.ui.a.c;

final class SnsTimeLineUI$1
  implements Runnable
{
  SnsTimeLineUI$1(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39442);
    c localc = SnsTimeLineUI.a(this.rYv);
    if (localc != null)
    {
      localc.sds.cvL();
      localc.sds.notifyVendingDataChange();
    }
    AppMethodBeat.o(39442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.1
 * JD-Core Version:    0.7.0.1
 */