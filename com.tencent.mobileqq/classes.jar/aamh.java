import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class aamh
  implements Animator.AnimatorListener
{
  aamh(aame paramaame) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    aame.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (aame.a(this.a) != null) {
      aame.a(this.a).a(3);
    }
    if (aame.a(this.a) != null)
    {
      aame.a(this.a).setAlpha(0.0F);
      aame.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamh
 * JD-Core Version:    0.7.0.1
 */