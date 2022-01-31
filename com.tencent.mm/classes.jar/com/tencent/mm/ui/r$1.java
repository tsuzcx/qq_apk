package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class r$1
  implements Runnable
{
  r$1(r paramr) {}
  
  public final void run()
  {
    if (r.a(this.uMn) != 0)
    {
      y.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(r.a(this.uMn)), Integer.valueOf(r.b(this.uMn)) });
      r.d(this.uMn).removeCallbacks(r.c(this.uMn));
      if (20 > r.e(this.uMn))
      {
        r.d(this.uMn).postDelayed(r.c(this.uMn), 100L);
        return;
      }
      y.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[] { Integer.valueOf(r.a(this.uMn)), Integer.valueOf(r.e(this.uMn)) });
    }
    y.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
    r.f(this.uMn);
    r.g(this.uMn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.r.1
 * JD-Core Version:    0.7.0.1
 */