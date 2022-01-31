import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class ajvy
  implements GestureDetector.OnGestureListener
{
  ajvy(ajvx paramajvx) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    ajvx.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      ajvx.a(this.a).fling((int)ajvx.a(this.a), 0, (int)-paramFloat1, 0, (int)ajvx.b(this.a), (int)ajvx.c(this.a), 0, 0);
      ajvx.b(this.a);
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
        ajvx.a(this.a, ajvx.a(this.a) + paramFloat1);
        if (ajvx.a(this.a) < ajvx.b(this.a)) {
          ajvx.a(this.a, ajvx.b(this.a));
        }
        if (ajvx.a(this.a) > ajvx.c(this.a)) {
          ajvx.a(this.a, ajvx.c(this.a));
        }
        paramFloat1 = ajvx.a(this.a);
        paramFloat2 = ajvx.d(this.a);
        ajvx.b(this.a, ajvx.a(this.a));
        if (ajvx.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      ajvx.a(this.a);
      if (ajvx.a(this.a) != null) {
        ajvx.a(this.a).a(ajvx.a(this.a), ajvx.b(this.a));
      }
      if (ajvx.a(this.a) != null) {
        ajvx.a(this.a).invalidate();
      }
    } while (ajvx.a(this.a) == null);
    ajvx.a(this.a).a(ajvx.a(this.a), -ajvx.a(this.a), ajvx.e(this.a) - ajvx.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvy
 * JD-Core Version:    0.7.0.1
 */