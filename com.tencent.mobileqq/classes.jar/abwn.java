import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.campuscircle.CampusCirclePublishActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class abwn
  implements Animator.AnimatorListener
{
  public abwn(CampusCirclePublishActivity paramCampusCirclePublishActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    CampusCirclePublishActivity.a(this.a);
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onAnimationCancel %s", new Object[] { paramAnimator }));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    CampusCirclePublishActivity.a(this.a);
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onAnimationEnd %s", new Object[] { paramAnimator }));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c.setVisibility(0);
    this.a.b.setVisibility(0);
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircle", 4, String.format(Locale.getDefault(), "onAnimationStart %s", new Object[] { paramAnimator }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwn
 * JD-Core Version:    0.7.0.1
 */