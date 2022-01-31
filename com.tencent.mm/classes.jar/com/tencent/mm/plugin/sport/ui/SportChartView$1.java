package com.tencent.mm.plugin.sport.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SportChartView$1
  extends GestureDetector.SimpleOnGestureListener
{
  private long squ;
  
  SportChartView$1(SportChartView paramSportChartView) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(65422);
    ab.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramFloat1) });
    if ((System.currentTimeMillis() - this.squ < 500L) || (!SportChartView.d(this.sqv)))
    {
      AppMethodBeat.o(65422);
      return false;
    }
    this.squ = System.currentTimeMillis();
    if (paramFloat1 > 0.0F)
    {
      SportChartView.e(this.sqv);
      if (SportChartView.f(this.sqv) > SportChartView.g(this.sqv)) {
        SportChartView.b(this.sqv, SportChartView.g(this.sqv));
      }
      SportChartView.h(this.sqv);
      this.sqv.invalidate();
      AppMethodBeat.o(65422);
      return true;
    }
    if (paramFloat1 < 0.0F)
    {
      SportChartView.i(this.sqv);
      if (SportChartView.f(this.sqv) <= 0) {
        SportChartView.b(this.sqv, 1);
      }
      SportChartView.h(this.sqv);
      this.sqv.invalidate();
      AppMethodBeat.o(65422);
      return true;
    }
    AppMethodBeat.o(65422);
    return false;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65421);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    SportChartView.a(this.sqv, SportChartView.a(this.sqv, f1));
    SportChartView.a(this.sqv);
    SportChartView.b(this.sqv);
    ab.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(this.sqv)) });
    this.sqv.invalidate();
    AppMethodBeat.o(65421);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView.1
 * JD-Core Version:    0.7.0.1
 */