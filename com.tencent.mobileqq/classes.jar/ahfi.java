import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView.3;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

public class ahfi
  implements Animation.AnimationListener
{
  public ahfi(LoginView.3 param3) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahfi
 * JD-Core Version:    0.7.0.1
 */