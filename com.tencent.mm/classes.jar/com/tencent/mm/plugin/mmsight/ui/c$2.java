package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(55177);
    c.a(this.oPh);
    if (this.oPh.isStart)
    {
      if (this.oPh.oPe < this.oPh.end)
      {
        this.oPh.fJH.post(this);
        AppMethodBeat.o(55177);
        return;
      }
      this.oPh.isStart = false;
      ab.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", new Object[] { Float.valueOf(this.oPh.oPe), Float.valueOf(this.oPh.end) });
      if (this.oPh.oPf != null)
      {
        this.oPh.oPf.onAnimationEnd();
        AppMethodBeat.o(55177);
      }
    }
    else
    {
      ab.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
    }
    AppMethodBeat.o(55177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c.2
 * JD-Core Version:    0.7.0.1
 */