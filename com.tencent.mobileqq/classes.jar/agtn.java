import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.bubble.ChatXListView;

class agtn
  implements Animator.AnimatorListener
{
  agtn(agti paramagti) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.removeHeaderView(agti.a(this.a));
    agti.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtn
 * JD-Core Version:    0.7.0.1
 */