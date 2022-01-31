package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class p$1
  implements Runnable
{
  p$1(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(105984);
    if (p.a(this.zav) != 0)
    {
      ab.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(p.a(this.zav)), Integer.valueOf(p.b(this.zav)) });
      p.d(this.zav).removeCallbacks(p.c(this.zav));
      if (20 > p.e(this.zav))
      {
        p.d(this.zav).postDelayed(p.c(this.zav), 100L);
        AppMethodBeat.o(105984);
        return;
      }
      ab.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(p.a(this.zav)), Integer.valueOf(p.e(this.zav)) });
    }
    ab.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
    p.f(this.zav);
    p.g(this.zav);
    AppMethodBeat.o(105984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.p.1
 * JD-Core Version:    0.7.0.1
 */