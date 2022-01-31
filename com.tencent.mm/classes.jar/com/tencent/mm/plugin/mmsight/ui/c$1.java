package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$1
  implements ap.a
{
  c$1(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(55176);
    c.a(this.oPh);
    if (this.oPh.isStart)
    {
      if (this.oPh.oPe < this.oPh.end)
      {
        AppMethodBeat.o(55176);
        return true;
      }
      this.oPh.isStart = false;
      ab.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(this.oPh.oPe), Float.valueOf(this.oPh.end), this.oPh.oPf });
      if (this.oPh.oPf != null) {
        this.oPh.oPf.onAnimationEnd();
      }
      AppMethodBeat.o(55176);
      return false;
    }
    ab.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
    AppMethodBeat.o(55176);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c.1
 * JD-Core Version:    0.7.0.1
 */