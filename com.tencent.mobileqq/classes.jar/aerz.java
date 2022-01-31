import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.bubble.ChatXListView;

class aerz
  implements Animator.AnimatorListener
{
  aerz(aerv paramaerv) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.removeHeaderView(aerv.a(this.a));
    aerv.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aerz
 * JD-Core Version:    0.7.0.1
 */