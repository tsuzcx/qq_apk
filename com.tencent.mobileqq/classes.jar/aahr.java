import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

class aahr
  extends GestureDetector.SimpleOnGestureListener
{
  private aahr(aahk paramaahk) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramMotionEvent2.getY() - aahk.a(this.a);
    if (aahk.b(this.a) < aahk.c(this.a)) {
      return false;
    }
    if ((f1 > 0.0F) && (aahk.d(this.a) < aahk.e(this.a)))
    {
      f2 = aahk.d(this.a);
      f1 = Math.abs(f1) + f2;
      localaahk = this.a;
      if (f1 > aahk.e(this.a))
      {
        i = aahk.e(this.a);
        aahk.b(localaahk, i);
      }
    }
    while ((f1 >= 0.0F) || (aahk.d(this.a) <= aahk.f(this.a))) {
      for (;;)
      {
        float f2;
        if (aahk.a(this.a) != null)
        {
          aahk.a(this.a).getLayoutParams().height = aahk.d(this.a);
          aahk.a(this.a).requestLayout();
        }
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        i = (int)f1;
      }
    }
    f1 = aahk.d(this.a) - Math.abs(f1);
    aahk localaahk = this.a;
    if (f1 < aahk.f(this.a)) {}
    for (int i = aahk.f(this.a);; i = (int)f1)
    {
      aahk.b(localaahk, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahr
 * JD-Core Version:    0.7.0.1
 */