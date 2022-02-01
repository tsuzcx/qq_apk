import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.bubble.ChatXListView;

class aids
  implements Animator.AnimatorListener
{
  aids(aido paramaido) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.listView.removeHeaderView(aido.a(this.a));
    aido.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aids
 * JD-Core Version:    0.7.0.1
 */