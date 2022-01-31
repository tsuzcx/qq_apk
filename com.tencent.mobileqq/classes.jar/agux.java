import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbTranslucentBrowserActivity;

public class agux
  implements Animation.AnimationListener
{
  public agux(SpringHbTranslucentBrowserActivity paramSpringHbTranslucentBrowserActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (SpringHbTranslucentBrowserActivity.a(this.a) != null) {
      SpringHbTranslucentBrowserActivity.a(this.a).setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agux
 * JD-Core Version:    0.7.0.1
 */