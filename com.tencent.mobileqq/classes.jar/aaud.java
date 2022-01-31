import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.qphone.base.util.QLog;

public class aaud
  implements ValueAnimator.AnimatorUpdateListener
{
  public aaud(ARMapActivity paramARMapActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    if (ARMapActivity.b(this.a) != paramValueAnimator.intValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, String.format("updateProgress mCurProgress=%s", new Object[] { Integer.valueOf(ARMapActivity.b(this.a)) }));
      }
      ARMapActivity.b(this.a, paramValueAnimator.intValue());
      if (ARMapActivity.a(this.a) != null) {
        ARMapActivity.a(this.a).setProgress(ARMapActivity.b(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaud
 * JD-Core Version:    0.7.0.1
 */