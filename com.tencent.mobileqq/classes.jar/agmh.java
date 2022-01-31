import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.portal.FormalView;

public class agmh
  implements Animator.AnimatorListener
{
  public agmh(FormalView paramFormalView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.f();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.f();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FormalView.a(this.a).setVisibility(0);
    if (this.a.a == 1)
    {
      FormalView.b(this.a).setVisibility(0);
      return;
    }
    FormalView.b(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmh
 * JD-Core Version:    0.7.0.1
 */