package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsMsgUI$9
  implements Runnable
{
  SnsMsgUI$9(SnsMsgUI paramSnsMsgUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39074);
    if (SnsMsgUI.e(this.rSU) == null)
    {
      AppMethodBeat.o(39074);
      return;
    }
    synchronized (SnsMsgUI.e(this.rSU))
    {
      SnsMsgUI.e(this.rSU).a(null, null);
      SnsMsgUI.v(this.rSU);
      AppMethodBeat.o(39074);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.9
 * JD-Core Version:    0.7.0.1
 */