import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class akyc
  implements Animator.AnimatorListener
{
  akyc(akyb paramakyb) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (akyb.a(this.a) != null) {
      akyb.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akyc
 * JD-Core Version:    0.7.0.1
 */