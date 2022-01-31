import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.Queue;

class aexl
  implements Animator.AnimatorListener
{
  aexl(aexk paramaexk) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aexk.a(this.a).remove();
    if (aexk.a(this.a).isEmpty()) {
      this.a.a();
    }
    while (aexk.a(this.a)) {
      return;
    }
    aexk.a(this.a).clear();
    this.a.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexl
 * JD-Core Version:    0.7.0.1
 */