import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;

public class abkg
  extends AnimatorListenerAdapter
{
  public abkg(SelectCoverActivity paramSelectCoverActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.a = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkg
 * JD-Core Version:    0.7.0.1
 */