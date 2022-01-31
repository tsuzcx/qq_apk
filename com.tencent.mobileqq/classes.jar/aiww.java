import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;

public class aiww
  implements Animation.AnimationListener
{
  public aiww(CmGameDebugView paramCmGameDebugView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CmGameDebugView.a(this.a).setVisibility(8);
    CmGameDebugView.b(this.a).setVisibility(8);
    CmGameDebugView.a(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiww
 * JD-Core Version:    0.7.0.1
 */