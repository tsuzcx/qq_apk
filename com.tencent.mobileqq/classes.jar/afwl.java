import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class afwl
  implements Animator.AnimatorListener
{
  afwl(afwk paramafwk) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!BusinessEggsAnimation.a(this.a.a).isEmpty())
    {
      paramAnimator = (afwm)BusinessEggsAnimation.a(this.a.a).remove();
      BusinessEggsAnimation.b(this.a.a).add(paramAnimator);
      paramAnimator.b();
      if (QLog.isColorLevel()) {
        QLog.i("BusinessEggsAnimation", 2, "[onAnimationEnd]");
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwl
 * JD-Core Version:    0.7.0.1
 */