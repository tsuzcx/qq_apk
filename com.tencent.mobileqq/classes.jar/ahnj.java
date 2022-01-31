import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class ahnj
  implements GestureDetector.OnGestureListener
{
  ahnj(ahni paramahni) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    ahni.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      ahni.a(this.a).fling((int)ahni.a(this.a), 0, (int)-paramFloat1, 0, (int)ahni.b(this.a), (int)ahni.c(this.a), 0, 0);
      ahni.b(this.a);
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
        ahni.a(this.a, ahni.a(this.a) + paramFloat1);
        if (ahni.a(this.a) < ahni.b(this.a)) {
          ahni.a(this.a, ahni.b(this.a));
        }
        if (ahni.a(this.a) > ahni.c(this.a)) {
          ahni.a(this.a, ahni.c(this.a));
        }
        paramFloat1 = ahni.a(this.a);
        paramFloat2 = ahni.d(this.a);
        ahni.b(this.a, ahni.a(this.a));
        if (ahni.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      ahni.a(this.a);
      if (ahni.a(this.a) != null) {
        ahni.a(this.a).a(ahni.a(this.a), ahni.b(this.a));
      }
      if (ahni.a(this.a) != null) {
        ahni.a(this.a).invalidate();
      }
    } while (ahni.a(this.a) == null);
    ahni.a(this.a).a(ahni.a(this.a), -ahni.a(this.a), ahni.e(this.a) - ahni.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahnj
 * JD-Core Version:    0.7.0.1
 */