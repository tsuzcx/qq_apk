import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class afek
  implements Animator.AnimatorListener
{
  afek(afej paramafej) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "onAnimationEnd");
    }
    afej.a(this.a).remove();
    if (afej.a(this.a).isEmpty()) {
      this.a.c();
    }
    while (afej.a(this.a)) {
      return;
    }
    afej.a(this.a).clear();
    this.a.c();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afek
 * JD-Core Version:    0.7.0.1
 */