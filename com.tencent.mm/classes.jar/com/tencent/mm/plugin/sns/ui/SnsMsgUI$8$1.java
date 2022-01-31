package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsMsgUI$8$1
  implements Runnable
{
  SnsMsgUI$8$1(SnsMsgUI.8 param8) {}
  
  public final void run()
  {
    AppMethodBeat.i(39072);
    synchronized (SnsMsgUI.e(this.rSW.rSU))
    {
      ab.v("MicroMsg.SnsMsgUI", "comment notify");
      SnsMsgUI.o(this.rSW.rSU);
      SnsMsgUI.e(this.rSW.rSU).a(null, null);
      AppMethodBeat.o(39072);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.8.1
 * JD-Core Version:    0.7.0.1
 */