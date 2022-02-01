import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class aalr
  implements Animator.AnimatorListener
{
  aalr(aalp paramaalp) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (aalp.a(this.a) != null) {
      aalp.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (aalp.a(this.a) != null) {
      aalp.a(this.a).a();
    }
    if (aalp.a(this.a) != null)
    {
      aalp.a(aalp.a(this.a), null);
      aalp.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (aalp.a(this.a) != null) {
      aalp.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalr
 * JD-Core Version:    0.7.0.1
 */