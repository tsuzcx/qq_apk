import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2.2.1;

public class ahra
  implements Animator.AnimatorListener
{
  public ahra(CareNotificationBar.2 param2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.post(new CareNotificationBar.2.2.1(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahra
 * JD-Core Version:    0.7.0.1
 */