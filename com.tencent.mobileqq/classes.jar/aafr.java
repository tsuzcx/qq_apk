import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

class aafr
  extends GestureDetector.SimpleOnGestureListener
{
  aafr(aafq paramaafq) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    try
    {
      int i = (int)paramMotionEvent1.getX();
      int j = (int)paramMotionEvent2.getX();
      if ((int)paramMotionEvent1.getY() < ScreenUtil.b - ScreenUtil.a(100.0F))
      {
        if ((ARGreetingCardListManager.a(this.a.a.a)) && (i - j > 120) && (Math.abs(paramFloat1) > 200.0F))
        {
          ARGreetingCardListManager.a(this.a.a.a);
          return true;
        }
        if ((ARGreetingCardListManager.a(this.a.a.a)) && (j - i > 120) && (Math.abs(paramFloat1) > 200.0F))
        {
          ARGreetingCardListManager.b(this.a.a.a);
          return true;
        }
      }
    }
    catch (Exception paramMotionEvent1)
    {
      QLog.e("ARGreetingCardListManager", 1, "GestureDetector onFling fail.", paramMotionEvent1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafr
 * JD-Core Version:    0.7.0.1
 */