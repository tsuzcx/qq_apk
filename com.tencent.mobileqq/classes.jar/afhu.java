import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class afhu
  implements Animator.AnimatorListener
{
  afhu(afht paramafht) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "onAnimationCancel() called with: animation = [" + paramAnimator + "]");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "onAnimationEnd() called with: animation = [" + paramAnimator + "]");
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "onAnimationRepeat() called with: animation = [" + paramAnimator + "]");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "onAnimationStart() called with: animation = [" + paramAnimator + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhu
 * JD-Core Version:    0.7.0.1
 */