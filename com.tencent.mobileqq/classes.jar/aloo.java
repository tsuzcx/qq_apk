import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class aloo
  implements GestureDetector.OnGestureListener
{
  aloo(alon paramalon) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    alon.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      alon.a(this.a).fling((int)alon.a(this.a), 0, (int)-paramFloat1, 0, (int)alon.b(this.a), (int)alon.c(this.a), 0, 0);
      alon.b(this.a);
      return true;
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    do
    {
      synchronized (this.a)
      {
        alon.a(this.a, alon.a(this.a) + paramFloat1);
        if (alon.a(this.a) < alon.b(this.a)) {
          alon.a(this.a, alon.b(this.a));
        }
        if (alon.a(this.a) > alon.c(this.a)) {
          alon.a(this.a, alon.c(this.a));
        }
        paramFloat1 = alon.a(this.a);
        paramFloat2 = alon.d(this.a);
        alon.b(this.a, alon.a(this.a));
        if (alon.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      alon.a(this.a);
      if (alon.a(this.a) != null) {
        alon.a(this.a).a(alon.a(this.a), alon.b(this.a));
      }
      if (alon.a(this.a) != null) {
        alon.a(this.a).invalidate();
      }
    } while (alon.a(this.a) == null);
    alon.a(this.a).a(alon.a(this.a), -alon.a(this.a), alon.e(this.a) - alon.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloo
 * JD-Core Version:    0.7.0.1
 */