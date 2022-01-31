import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class aiab
  implements GestureDetector.OnGestureListener
{
  aiab(aiaa paramaiaa) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    aiaa.a(this.a).forceFinished(true);
    return true;
  }
  
  public boolean onFling(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      aiaa.a(this.a).fling((int)aiaa.a(this.a), 0, (int)-paramFloat1, 0, (int)aiaa.b(this.a), (int)aiaa.c(this.a), 0, 0);
      aiaa.b(this.a);
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
        aiaa.a(this.a, aiaa.a(this.a) + paramFloat1);
        if (aiaa.a(this.a) < aiaa.b(this.a)) {
          aiaa.a(this.a, aiaa.b(this.a));
        }
        if (aiaa.a(this.a) > aiaa.c(this.a)) {
          aiaa.a(this.a, aiaa.c(this.a));
        }
        paramFloat1 = aiaa.a(this.a);
        paramFloat2 = aiaa.d(this.a);
        aiaa.b(this.a, aiaa.a(this.a));
        if (aiaa.a(this.a, paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      aiaa.a(this.a);
      if (aiaa.a(this.a) != null) {
        aiaa.a(this.a).a(aiaa.a(this.a), aiaa.b(this.a));
      }
      if (aiaa.a(this.a) != null) {
        aiaa.a(this.a).invalidate();
      }
    } while (aiaa.a(this.a) == null);
    aiaa.a(this.a).a(aiaa.a(this.a), -aiaa.a(this.a), aiaa.e(this.a) - aiaa.a(this.a));
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aiab
 * JD-Core Version:    0.7.0.1
 */