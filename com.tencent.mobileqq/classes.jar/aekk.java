import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;

public class aekk
  implements Animator.AnimatorListener
{
  public aekk(LightReplyMenuManager paramLightReplyMenuManager) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.b = false;
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a != null)
    {
      this.a.a.setVisibility(8);
      LightReplyMenuManager.a(this.a, null);
      this.a.a = null;
      LightReplyMenuManager.a(this.a, false);
    }
    this.a.b = false;
    this.a.c = false;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekk
 * JD-Core Version:    0.7.0.1
 */