import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.leba.view.LebaFeedsDislikeMaskView;

public class aebh
  implements Animator.AnimatorListener
{
  public aebh(LebaFeedsDislikeMaskView paramLebaFeedsDislikeMaskView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LebaFeedsDislikeMaskView.a(this.a).setAlpha(1.0F);
    LebaFeedsDislikeMaskView.a(this.a).setScaleX(1.0F);
    LebaFeedsDislikeMaskView.a(this.a).setScaleY(1.0F);
    LebaFeedsDislikeMaskView.a(this.a, LebaFeedsDislikeMaskView.a(this.a));
    this.a.invalidate();
    LebaFeedsDislikeMaskView.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    LebaFeedsDislikeMaskView.a(this.a).setAlpha(0.0F);
    LebaFeedsDislikeMaskView.a(this.a).setScaleX(0.0F);
    LebaFeedsDislikeMaskView.a(this.a).setScaleY(0.0F);
    LebaFeedsDislikeMaskView.a(this.a, 0);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebh
 * JD-Core Version:    0.7.0.1
 */