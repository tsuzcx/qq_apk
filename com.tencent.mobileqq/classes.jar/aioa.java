import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.30.1;

public class aioa
  implements Animation.AnimationListener
{
  aioa(ainh paramainh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ainh.d(this.a).post(new PublicAccountChatPie.30.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioa
 * JD-Core Version:    0.7.0.1
 */