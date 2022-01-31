package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import java.util.TimerTask;

final class k$5
  extends TimerTask
{
  k$5(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(4395);
    k localk = this.tvC;
    localk.tvz += 1;
    if ((this.tvC.tvj.tBB != 0) || (this.tvC.tvz > 10))
    {
      this.tvC.cMi();
      if (this.tvC.tvy != null)
      {
        this.tvC.tvy.cancel();
        this.tvC.tvy = null;
      }
      AppMethodBeat.o(4395);
      return;
    }
    AppMethodBeat.o(4395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.k.5
 * JD-Core Version:    0.7.0.1
 */