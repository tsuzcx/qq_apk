import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3.2.1;

public class alrg
  implements Animator.AnimatorListener
{
  public alrg(CareNotificationBar.3 param3) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.post(new CareNotificationBar.3.2.1(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alrg
 * JD-Core Version:    0.7.0.1
 */