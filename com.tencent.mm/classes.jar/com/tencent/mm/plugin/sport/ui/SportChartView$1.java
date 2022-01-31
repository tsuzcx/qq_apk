package com.tencent.mm.plugin.sport.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.y;

final class SportChartView$1
  extends GestureDetector.SimpleOnGestureListener
{
  private long pue;
  
  SportChartView$1(SportChartView paramSportChartView) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    y.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramFloat1) });
    if ((System.currentTimeMillis() - this.pue < 500L) || (!SportChartView.d(this.puf))) {
      return false;
    }
    this.pue = System.currentTimeMillis();
    if (paramFloat1 > 0.0F)
    {
      SportChartView.e(this.puf);
      if (SportChartView.f(this.puf) > SportChartView.g(this.puf)) {
        SportChartView.b(this.puf, SportChartView.g(this.puf));
      }
      SportChartView.h(this.puf);
      this.puf.invalidate();
      return true;
    }
    if (paramFloat1 < 0.0F)
    {
      SportChartView.i(this.puf);
      if (SportChartView.f(this.puf) <= 0) {
        SportChartView.b(this.puf, 1);
      }
      SportChartView.h(this.puf);
      this.puf.invalidate();
      return true;
    }
    return false;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    SportChartView.a(this.puf, SportChartView.a(this.puf, f1));
    SportChartView.a(this.puf);
    SportChartView.b(this.puf);
    y.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(this.puf)) });
    this.puf.invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView.1
 * JD-Core Version:    0.7.0.1
 */