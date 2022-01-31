import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.widget.PublishItemBar;

public class aitm
  implements Animation.AnimationListener
{
  public aitm(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitm
 * JD-Core Version:    0.7.0.1
 */