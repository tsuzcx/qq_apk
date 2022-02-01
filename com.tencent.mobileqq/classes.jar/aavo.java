import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class aavo
  implements Animator.AnimatorListener
{
  aavo(aavn paramaavn) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (aavn.a(this.a) != null) {
      aavn.a(this.a).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aavo
 * JD-Core Version:    0.7.0.1
 */