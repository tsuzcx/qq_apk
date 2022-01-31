package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.y;

final class SnsAdNativeLandingPagesScrollView$1
  implements Runnable
{
  SnsAdNativeLandingPagesScrollView$1(SnsAdNativeLandingPagesScrollView paramSnsAdNativeLandingPagesScrollView) {}
  
  public final void run()
  {
    int i = this.oUa.getScrollY();
    y.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(this.oUa)), Integer.valueOf(i) });
    if (i != SnsAdNativeLandingPagesScrollView.a(this.oUa))
    {
      if (SnsAdNativeLandingPagesScrollView.b(this.oUa) != null)
      {
        SnsAdNativeLandingPagesScrollView.b(this.oUa);
        SnsAdNativeLandingPagesScrollView.c(this.oUa);
      }
      SnsAdNativeLandingPagesScrollView.a(this.oUa, System.currentTimeMillis());
    }
    if (SnsAdNativeLandingPagesScrollView.a(this.oUa) - i == 0)
    {
      if (SnsAdNativeLandingPagesScrollView.b(this.oUa) != null)
      {
        SnsAdNativeLandingPagesScrollView.b(this.oUa);
        SnsAdNativeLandingPagesScrollView.a(this.oUa);
        SnsAdNativeLandingPagesScrollView.c(this.oUa);
      }
      SnsAdNativeLandingPagesScrollView.a(this.oUa, SnsAdNativeLandingPagesScrollView.a(this.oUa));
    }
    SnsAdNativeLandingPagesScrollView.b(this.oUa, this.oUa.getScrollY());
    y.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(this.oUa)), Integer.valueOf(i) });
    this.oUa.postDelayed(SnsAdNativeLandingPagesScrollView.d(this.oUa), SnsAdNativeLandingPagesScrollView.e(this.oUa));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesScrollView.1
 * JD-Core Version:    0.7.0.1
 */