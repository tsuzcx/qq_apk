import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class ahzz
  implements GestureDetector.OnGestureListener
{
  ahzz(ahzy paramahzy) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    ahzy.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      ahzy.a(this.a).fling((int)ahzy.a(this.a), 0, (int)-paramFloat1, 0, (int)ahzy.b(this.a), (int)ahzy.c(this.a), 0, 0);
      ahzy.b(this.a);
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
        ahzy.a(this.a, ahzy.a(this.a) + paramFloat1);
        if (ahzy.a(this.a) < ahzy.b(this.a)) {
          ahzy.a(this.a, ahzy.b(this.a));
        }
        if (ahzy.a(this.a) > ahzy.c(this.a)) {
          ahzy.a(this.a, ahzy.c(this.a));
        }
        paramFloat1 = ahzy.a(this.a);
        paramFloat2 = ahzy.d(this.a);
        ahzy.b(this.a, ahzy.a(this.a));
        if (ahzy.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      ahzy.a(this.a);
      if (ahzy.a(this.a) != null) {
        ahzy.a(this.a).a(ahzy.a(this.a), ahzy.b(this.a));
      }
      if (ahzy.a(this.a) != null) {
        ahzy.a(this.a).invalidate();
      }
    } while (ahzy.a(this.a) == null);
    ahzy.a(this.a).a(ahzy.a(this.a), -ahzy.a(this.a), ahzy.e(this.a) - ahzy.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahzz
 * JD-Core Version:    0.7.0.1
 */