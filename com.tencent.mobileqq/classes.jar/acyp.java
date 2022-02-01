import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.gdtad.views.videoimax.TransitionContext;

public class acyp
  extends AnimatorListenerAdapter
{
  public acyp(TransitionContext paramTransitionContext) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.a.a();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyp
 * JD-Core Version:    0.7.0.1
 */