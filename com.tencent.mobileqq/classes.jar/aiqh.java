import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class aiqh
  implements Animation.AnimationListener
{
  public aiqh(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d.setBackgroundResource(2130843607);
    this.a.a.setBackgroundResource(2130843613);
    this.a.p.setVisibility(8);
    this.a.q.setVisibility(8);
    this.a.n.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.p.setVisibility(0);
    this.a.q.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqh
 * JD-Core Version:    0.7.0.1
 */