import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class aglr
  implements Animator.AnimatorListener
{
  aglr(aglq paramaglq) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimation", 2, "onAnimationEnd");
    }
    aglq.a(this.a).remove();
    if (aglq.a(this.a).isEmpty()) {
      this.a.c();
    }
    while (aglq.a(this.a)) {
      return;
    }
    aglq.a(this.a).clear();
    this.a.c();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglr
 * JD-Core Version:    0.7.0.1
 */