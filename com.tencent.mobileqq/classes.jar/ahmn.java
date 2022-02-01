import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;

public class ahmn
  implements Animator.AnimatorListener
{
  private ahmn(UnlimitedBladeWorks paramUnlimitedBladeWorks) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (UnlimitedBladeWorks.a(this.a).a)
    {
      if (UnlimitedBladeWorks.a(this.a) != 2.0D) {
        break label55;
      }
      UnlimitedBladeWorks.a(this.a);
      UnlimitedBladeWorks.a(this.a, 5);
    }
    for (;;)
    {
      UnlimitedBladeWorks.a(this.a).setImageDrawable(null);
      return;
      label55:
      UnlimitedBladeWorks.b(this.a).setImageDrawable(UnlimitedBladeWorks.a(this.a));
      UnlimitedBladeWorks.a(this.a).a(UnlimitedBladeWorks.a(this.a));
      UnlimitedBladeWorks.a(this.a).a(new ahmo(this));
      UnlimitedBladeWorks.a(this.a).c();
      UnlimitedBladeWorks.a(this.a, 1);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (UnlimitedBladeWorks.a(this.a))
    {
      UnlimitedBladeWorks.a(this.a).setImageDrawable(UnlimitedBladeWorks.a(this.a));
      return;
    }
    UnlimitedBladeWorks.a(this.a).setImageBitmap(UnlimitedBladeWorks.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmn
 * JD-Core Version:    0.7.0.1
 */