import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView.4;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

public class ajji
  implements Animation.AnimationListener
{
  public ajji(LoginView.4 param4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.this$0.c.setVisibility(0);
    this.a.this$0.c.clearAnimation();
    this.a.this$0.c.setAnimation(null);
    this.a.this$0.a.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajji
 * JD-Core Version:    0.7.0.1
 */