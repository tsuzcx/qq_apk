import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.leba.view.LebaFeedsDislikeMaskView;
import com.tencent.mobileqq.leba.view.LebaFeedsDislikeMaskView.Listener;

public class aejt
  implements Animator.AnimatorListener
{
  public aejt(LebaFeedsDislikeMaskView paramLebaFeedsDislikeMaskView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LebaFeedsDislikeMaskView.a(this.a).setAlpha(0.0F);
    LebaFeedsDislikeMaskView.a(this.a, 0);
    this.a.invalidate();
    LebaFeedsDislikeMaskView.a(this.a, false);
    if (LebaFeedsDislikeMaskView.a(this.a) != null) {
      LebaFeedsDislikeMaskView.a(this.a).f();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    LebaFeedsDislikeMaskView.a(this.a).setAlpha(1.0F);
    LebaFeedsDislikeMaskView.a(this.a).setScaleX(1.0F);
    LebaFeedsDislikeMaskView.a(this.a).setScaleY(1.0F);
    if (LebaFeedsDislikeMaskView.a(this.a) <= 0)
    {
      int i = this.a.getWidth();
      int j = this.a.getHeight();
      LebaFeedsDislikeMaskView.b(this.a, (int)Math.sqrt(i * i + j * j));
    }
    LebaFeedsDislikeMaskView.a(this.a, LebaFeedsDislikeMaskView.a(this.a));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejt
 * JD-Core Version:    0.7.0.1
 */