import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.14.1;

public class agoz
  implements Animation.AnimationListener
{
  agoz(agot paramagot) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.t = 5;
    agot.e(this.a).post(new PublicAccountChatPie.14.1(this));
    this.a.a.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoz
 * JD-Core Version:    0.7.0.1
 */