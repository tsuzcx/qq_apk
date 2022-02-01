import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView;

public class agxh
  implements Animator.AnimatorListener
{
  public agxh(IntimateScoreCardView paramIntimateScoreCardView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    IntimateScoreCardView.a(this.a).setAlpha(1.0F);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxh
 * JD-Core Version:    0.7.0.1
 */