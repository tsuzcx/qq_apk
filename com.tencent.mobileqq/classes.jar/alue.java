import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class alue
  implements GestureDetector.OnGestureListener
{
  alue(alud paramalud) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    alud.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      alud.a(this.a).fling((int)alud.a(this.a), 0, (int)-paramFloat1, 0, (int)alud.b(this.a), (int)alud.c(this.a), 0, 0);
      alud.b(this.a);
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
        alud.a(this.a, alud.a(this.a) + paramFloat1);
        if (alud.a(this.a) < alud.b(this.a)) {
          alud.a(this.a, alud.b(this.a));
        }
        if (alud.a(this.a) > alud.c(this.a)) {
          alud.a(this.a, alud.c(this.a));
        }
        paramFloat1 = alud.a(this.a);
        paramFloat2 = alud.d(this.a);
        alud.b(this.a, alud.a(this.a));
        if (alud.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      alud.a(this.a);
      if (alud.a(this.a) != null) {
        alud.a(this.a).a(alud.a(this.a), alud.b(this.a));
      }
      if (alud.a(this.a) != null) {
        alud.a(this.a).invalidate();
      }
    } while (alud.a(this.a) == null);
    alud.a(this.a).a(alud.a(this.a), -alud.a(this.a), alud.e(this.a) - alud.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alue
 * JD-Core Version:    0.7.0.1
 */