import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class afxh
  implements Animator.AnimatorListener
{
  public afxh(SixCombolEffectView paramSixCombolEffectView, afxk paramafxk) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!SixCombolEffectView.a) {
      return;
    }
    this.jdField_a_of_type_Afxk.b.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxh
 * JD-Core Version:    0.7.0.1
 */