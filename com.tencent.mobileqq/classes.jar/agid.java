import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;

public class agid
  implements Animator.AnimatorListener
{
  public agid(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.e = AvatarPendantActivity.c;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.e = AvatarPendantActivity.a;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.e = AvatarPendantActivity.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agid
 * JD-Core Version:    0.7.0.1
 */