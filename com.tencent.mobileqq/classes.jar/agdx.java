import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class agdx
  implements Animator.AnimatorListener
{
  agdx(agdw paramagdw) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEggLottieAnimView", 2, "onAnimationEnd");
    }
    agdw.a(this.a).remove();
    if (agdw.a(this.a).isEmpty()) {
      this.a.a();
    }
    while (agdw.a(this.a)) {
      return;
    }
    agdw.a(this.a).clear();
    this.a.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdx
 * JD-Core Version:    0.7.0.1
 */