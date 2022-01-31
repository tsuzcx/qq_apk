import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.qphone.base.util.QLog;

public class adps
  extends AnimatorListenerAdapter
{
  public adps(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!SixCombolEffectView.jdField_a_of_type_Boolean) {
      return;
    }
    SixCombolEffectView.b(this.a).start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (SixCombolEffectView.a(this.a)) {}
    do
    {
      return;
      SixCombolEffectView.jdField_a_of_type_Int = 2;
    } while (!QLog.isColorLevel());
    QLog.w("SixCombolEffectView", 2, "Animation 2 ,mAnimationState = " + SixCombolEffectView.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adps
 * JD-Core Version:    0.7.0.1
 */