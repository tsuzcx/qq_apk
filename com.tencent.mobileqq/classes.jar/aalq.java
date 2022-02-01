import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class aalq
  implements Animator.AnimatorListener
{
  aalq(aalp paramaalp) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (aalp.a(this.a) != null) {
      aalp.a(this.a).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalq
 * JD-Core Version:    0.7.0.1
 */