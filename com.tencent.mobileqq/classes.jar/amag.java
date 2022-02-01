import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class amag
  implements GestureDetector.OnGestureListener
{
  amag(amaf paramamaf) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    amaf.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      amaf.a(this.a).fling((int)amaf.a(this.a), 0, (int)-paramFloat1, 0, (int)amaf.b(this.a), (int)amaf.c(this.a), 0, 0);
      amaf.b(this.a);
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
        amaf.a(this.a, amaf.a(this.a) + paramFloat1);
        if (amaf.a(this.a) < amaf.b(this.a)) {
          amaf.a(this.a, amaf.b(this.a));
        }
        if (amaf.a(this.a) > amaf.c(this.a)) {
          amaf.a(this.a, amaf.c(this.a));
        }
        paramFloat1 = amaf.a(this.a);
        paramFloat2 = amaf.d(this.a);
        amaf.b(this.a, amaf.a(this.a));
        if (amaf.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      amaf.a(this.a);
      if (amaf.a(this.a) != null) {
        amaf.a(this.a).a(amaf.a(this.a), amaf.b(this.a));
      }
      if (amaf.a(this.a) != null) {
        amaf.a(this.a).invalidate();
      }
    } while (amaf.a(this.a) == null);
    amaf.a(this.a).a(amaf.a(this.a), -amaf.a(this.a), amaf.e(this.a) - amaf.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amag
 * JD-Core Version:    0.7.0.1
 */