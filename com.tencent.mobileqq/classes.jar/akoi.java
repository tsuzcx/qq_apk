import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;

public class akoi
  implements Animation.AnimationListener
{
  public akoi(CmGameDebugView paramCmGameDebugView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CmGameDebugView.a(this.a).setVisibility(8);
    CmGameDebugView.b(this.a).setVisibility(8);
    CmGameDebugView.a(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoi
 * JD-Core Version:    0.7.0.1
 */