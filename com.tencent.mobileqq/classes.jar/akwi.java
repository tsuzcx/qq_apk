import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class akwi
  implements GestureDetector.OnGestureListener
{
  akwi(akwh paramakwh) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    akwh.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      akwh.a(this.a).fling((int)akwh.a(this.a), 0, (int)-paramFloat1, 0, (int)akwh.b(this.a), (int)akwh.c(this.a), 0, 0);
      akwh.b(this.a);
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
        akwh.a(this.a, akwh.a(this.a) + paramFloat1);
        if (akwh.a(this.a) < akwh.b(this.a)) {
          akwh.a(this.a, akwh.b(this.a));
        }
        if (akwh.a(this.a) > akwh.c(this.a)) {
          akwh.a(this.a, akwh.c(this.a));
        }
        paramFloat1 = akwh.a(this.a);
        paramFloat2 = akwh.d(this.a);
        akwh.b(this.a, akwh.a(this.a));
        if (akwh.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      akwh.a(this.a);
      if (akwh.a(this.a) != null) {
        akwh.a(this.a).a(akwh.a(this.a), akwh.b(this.a));
      }
      if (akwh.a(this.a) != null) {
        akwh.a(this.a).invalidate();
      }
    } while (akwh.a(this.a) == null);
    akwh.a(this.a).a(akwh.a(this.a), -akwh.a(this.a), akwh.e(this.a) - akwh.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwi
 * JD-Core Version:    0.7.0.1
 */