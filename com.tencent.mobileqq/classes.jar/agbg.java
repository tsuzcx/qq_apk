import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class agbg
  implements Animation.AnimationListener
{
  public agbg(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.afRoot.setBackgroundResource(2130843707);
    this.a.mCustomTitleView.setBackgroundResource(2130843713);
    this.a.c.setVisibility(8);
    this.a.d.setVisibility(8);
    this.a.a.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.c.setVisibility(0);
    this.a.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbg
 * JD-Core Version:    0.7.0.1
 */