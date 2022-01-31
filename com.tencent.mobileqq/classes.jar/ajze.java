import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ajze
  implements Animator.AnimatorListener
{
  ajze(ajzc paramajzc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ajzc.a(this.a, false);
    ajzc.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ajzc.a(this.a, false);
    ajzc.a(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ajzc.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajze
 * JD-Core Version:    0.7.0.1
 */