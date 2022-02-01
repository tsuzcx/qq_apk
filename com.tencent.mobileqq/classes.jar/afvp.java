import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class afvp
  implements Animator.AnimatorListener
{
  afvp(afvo paramafvo) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "onAnimationEnd");
    }
    afvo.a(this.a).remove();
    if (afvo.a(this.a).isEmpty()) {
      this.a.c();
    }
    while (afvo.a(this.a)) {
      return;
    }
    afvo.a(this.a).clear();
    this.a.c();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvp
 * JD-Core Version:    0.7.0.1
 */