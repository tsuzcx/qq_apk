import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.Queue;

class aesw
  implements Animator.AnimatorListener
{
  aesw(aesv paramaesv) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aesv.a(this.a).remove();
    if (aesv.a(this.a).isEmpty()) {
      this.a.a();
    }
    while (aesv.a(this.a)) {
      return;
    }
    aesv.a(this.a).clear();
    this.a.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesw
 * JD-Core Version:    0.7.0.1
 */