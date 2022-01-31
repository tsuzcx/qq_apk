import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class aeat
  implements Animator.AnimatorListener
{
  public aeat(SixCombolEffectView paramSixCombolEffectView, aeaw paramaeaw) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!SixCombolEffectView.a) {
      return;
    }
    this.jdField_a_of_type_Aeaw.b.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeat
 * JD-Core Version:    0.7.0.1
 */