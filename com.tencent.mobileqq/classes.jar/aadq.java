import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class aadq
  extends GestureDetector.SimpleOnGestureListener
{
  private aadq(aadj paramaadj) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - aadj.a(this.a);
    if (aadj.b(this.a) < aadj.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (aadj.d(this.a) < aadj.e(this.a)))
    {
      f2 = aadj.d(this.a);
      f1 = Math.abs(f1) + f2;
      localaadj = this.a;
      if (f1 > aadj.e(this.a))
      {
        i = aadj.e(this.a);
        aadj.b(localaadj, i);
      }
    }
    while ((f1 >= 0.0F) || (aadj.d(this.a) <= aadj.f(this.a))) {
      for (;;)
      {
        float f2;
        if (aadj.a(this.a) != null)
        {
          aadj.a(this.a).getLayoutParams().height = aadj.d(this.a);
          aadj.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = aadj.d(this.a) - Math.abs(f1);
    aadj localaadj = this.a;
    if (f1 < aadj.f(this.a)) {}
    for (int i = aadj.f(this.a);; i = (int)f1)
    {
      aadj.b(localaadj, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadq
 * JD-Core Version:    0.7.0.1
 */