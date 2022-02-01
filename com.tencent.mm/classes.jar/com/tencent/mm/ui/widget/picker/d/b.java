package com.tencent.mm.ui.widget.picker.d;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.e.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class b
  extends GestureDetector.SimpleOnGestureListener
{
  private final WheelView JkP;
  
  public b(WheelView paramWheelView)
  {
    this.JkP = paramWheelView;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199840);
    paramMotionEvent1 = this.JkP;
    paramMotionEvent1.aMF();
    paramMotionEvent1.irF = paramMotionEvent1.irE.scheduleWithFixedDelay(new a(paramMotionEvent1, paramFloat2), 0L, 5L, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(199840);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d.b
 * JD-Core Version:    0.7.0.1
 */