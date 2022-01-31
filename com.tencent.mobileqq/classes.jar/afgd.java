import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearby.now.view.widget.StoryNewGuideDialog;

public class afgd
  implements Animation.AnimationListener
{
  public afgd(StoryNewGuideDialog paramStoryNewGuideDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgd
 * JD-Core Version:    0.7.0.1
 */