import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.qphone.base.util.QLog;

public class ahhm
  extends AnimatorListenerAdapter
{
  public ahhm(SixCombolEffectView paramSixCombolEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (!SixCombolEffectView.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        SixCombolEffectView.jdField_a_of_type_Int = 4;
        if (QLog.isColorLevel()) {
          QLog.w("SixCombolEffectView", 2, "Animation 4 ,mAnimationState = " + SixCombolEffectView.jdField_a_of_type_Int);
        }
      } while (SixCombolEffectView.a(this.a) == null);
      paramAnimator = SixCombolEffectView.a(this.a);
    } while (paramAnimator == null);
    SixCombolEffectView.a(this.a).a(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (SixCombolEffectView.a(this.a)) {}
    do
    {
      return;
      SixCombolEffectView.jdField_a_of_type_Int = 3;
    } while (!QLog.isColorLevel());
    QLog.w("SixCombolEffectView", 2, "Animation 3 ,mAnimationState = " + SixCombolEffectView.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhm
 * JD-Core Version:    0.7.0.1
 */