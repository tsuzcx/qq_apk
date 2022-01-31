import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Handler;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;

public class ajxf
  implements Animator.AnimatorListener
{
  public ajxf(ShakePicView paramShakePicView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.postDelayed(new ajxg(this), 160L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxf
 * JD-Core Version:    0.7.0.1
 */