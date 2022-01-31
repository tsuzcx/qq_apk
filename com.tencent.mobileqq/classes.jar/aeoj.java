import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView;

public class aeoj
  implements Animator.AnimatorListener
{
  public aeoj(IntimateTitleSwitchView paramIntimateTitleSwitchView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c.setAlpha(1.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoj
 * JD-Core Version:    0.7.0.1
 */