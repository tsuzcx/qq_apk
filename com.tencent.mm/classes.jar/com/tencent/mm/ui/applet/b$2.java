package com.tencent.mm.ui.applet;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

final class b$2
  implements GestureDetector.OnGestureListener
{
  b$2(b paramb) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent1 = this.zgD;
    if (paramFloat2 >= 0.0F) {}
    for (int i = 0;; i = 1)
    {
      paramMotionEvent1.direction = i;
      return false;
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b.2
 * JD-Core Version:    0.7.0.1
 */