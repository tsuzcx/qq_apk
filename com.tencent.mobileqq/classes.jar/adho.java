import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginInfoActivity;

public class adho
  implements Animation.AnimationListener
{
  public adho(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginInfoActivity.a(this.a).setVisibility(4);
    LoginInfoActivity.a(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adho
 * JD-Core Version:    0.7.0.1
 */