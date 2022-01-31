import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.qphone.base.util.QLog;

public class agwc
  extends GestureDetector.SimpleOnGestureListener
{
  public agwc(ProfileTagView paramProfileTagView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll invoked");
    }
    this.a.f = true;
    paramFloat1 = paramFloat2;
    if (paramMotionEvent1 != null)
    {
      paramFloat1 = paramFloat2;
      if (paramMotionEvent2 != null) {
        paramFloat1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll distance = " + paramFloat1);
    }
    if (Math.abs(paramFloat1) > ProfileTagView.a(this.a))
    {
      if ((paramFloat1 > 0.0F) && (this.a.c)) {
        if (this.a.a())
        {
          this.a.f();
          this.a.a.b(null);
        }
      }
      while ((paramFloat1 >= 0.0F) || (this.a.c)) {
        return true;
      }
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agwc
 * JD-Core Version:    0.7.0.1
 */