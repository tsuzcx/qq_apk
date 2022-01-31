import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class ajrj
  implements GestureDetector.OnGestureListener
{
  ajrj(ajri paramajri) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    ajri.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      ajri.a(this.a).fling((int)ajri.a(this.a), 0, (int)-paramFloat1, 0, (int)ajri.b(this.a), (int)ajri.c(this.a), 0, 0);
      ajri.b(this.a);
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
        ajri.a(this.a, ajri.a(this.a) + paramFloat1);
        if (ajri.a(this.a) < ajri.b(this.a)) {
          ajri.a(this.a, ajri.b(this.a));
        }
        if (ajri.a(this.a) > ajri.c(this.a)) {
          ajri.a(this.a, ajri.c(this.a));
        }
        paramFloat1 = ajri.a(this.a);
        paramFloat2 = ajri.d(this.a);
        ajri.b(this.a, ajri.a(this.a));
        if (ajri.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      ajri.a(this.a);
      if (ajri.a(this.a) != null) {
        ajri.a(this.a).a(ajri.a(this.a), ajri.b(this.a));
      }
      if (ajri.a(this.a) != null) {
        ajri.a(this.a).invalidate();
      }
    } while (ajri.a(this.a) == null);
    ajri.a(this.a).a(ajri.a(this.a), -ajri.a(this.a), ajri.e(this.a) - ajri.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrj
 * JD-Core Version:    0.7.0.1
 */