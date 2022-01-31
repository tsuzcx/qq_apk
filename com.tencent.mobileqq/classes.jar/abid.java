import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.qphone.base.util.QLog;

public class abid
  implements ValueAnimator.AnimatorUpdateListener
{
  public abid(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    if (ARMapLoadingActivity.a(this.a) != paramValueAnimator.intValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapLoadingActivity", 2, String.format("onAnimationUpdate mCurProgress=%s", new Object[] { Integer.valueOf(ARMapLoadingActivity.a(this.a)) }));
      }
      ARMapLoadingActivity.a(this.a, paramValueAnimator.intValue());
      if (ARMapLoadingActivity.a(this.a) != null) {
        ARMapLoadingActivity.a(this.a).setProgress(ARMapLoadingActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abid
 * JD-Core Version:    0.7.0.1
 */