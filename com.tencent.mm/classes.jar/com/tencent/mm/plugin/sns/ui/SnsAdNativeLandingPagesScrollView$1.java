package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsAdNativeLandingPagesScrollView$1
  implements Runnable
{
  SnsAdNativeLandingPagesScrollView$1(SnsAdNativeLandingPagesScrollView paramSnsAdNativeLandingPagesScrollView) {}
  
  public final void run()
  {
    AppMethodBeat.i(38613);
    int i = this.rLX.getScrollY();
    ab.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(this.rLX)), Integer.valueOf(i) });
    if (i != SnsAdNativeLandingPagesScrollView.a(this.rLX))
    {
      if (SnsAdNativeLandingPagesScrollView.b(this.rLX) != null)
      {
        SnsAdNativeLandingPagesScrollView.b(this.rLX);
        SnsAdNativeLandingPagesScrollView.c(this.rLX);
      }
      SnsAdNativeLandingPagesScrollView.a(this.rLX, System.currentTimeMillis());
    }
    if (SnsAdNativeLandingPagesScrollView.a(this.rLX) - i == 0)
    {
      if (SnsAdNativeLandingPagesScrollView.b(this.rLX) != null)
      {
        SnsAdNativeLandingPagesScrollView.b(this.rLX);
        SnsAdNativeLandingPagesScrollView.a(this.rLX);
        SnsAdNativeLandingPagesScrollView.c(this.rLX);
      }
      SnsAdNativeLandingPagesScrollView.a(this.rLX, SnsAdNativeLandingPagesScrollView.a(this.rLX));
    }
    SnsAdNativeLandingPagesScrollView.b(this.rLX, this.rLX.getScrollY());
    ab.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(this.rLX)), Integer.valueOf(i) });
    this.rLX.postDelayed(SnsAdNativeLandingPagesScrollView.d(this.rLX), SnsAdNativeLandingPagesScrollView.e(this.rLX));
    AppMethodBeat.o(38613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesScrollView.1
 * JD-Core Version:    0.7.0.1
 */