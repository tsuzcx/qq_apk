import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class aaig
  implements Animator.AnimatorListener
{
  aaig(aaid paramaaid) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    aaid.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (aaid.a(this.a) != null) {
      aaid.a(this.a).a(3);
    }
    if (aaid.a(this.a) != null)
    {
      aaid.a(this.a).setAlpha(0.0F);
      aaid.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaig
 * JD-Core Version:    0.7.0.1
 */