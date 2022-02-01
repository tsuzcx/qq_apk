import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.15.1;

public class ahiz
  implements Animation.AnimationListener
{
  ahiz(ahiu paramahiu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d = 5;
    ahiu.c(this.a).post(new PublicAccountChatPie.15.1(this));
    this.a.a.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahiz
 * JD-Core Version:    0.7.0.1
 */