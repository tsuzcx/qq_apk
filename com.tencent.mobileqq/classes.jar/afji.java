import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;

public class afji
  implements Animation.AnimationListener
{
  public afji(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayPanel.b(this.a))
    {
      NearbyProfileDisplayPanel.a(this.a).setVisibility(8);
      NearbyProfileDisplayPanel.a(this.a).clearAnimation();
      NearbyProfileDisplayPanel.a(this.a).setBackgroundResource(2130845349);
      NearbyProfileDisplayPanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131494194));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayPanel.a(this.a))
    {
      NearbyProfileDisplayPanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayPanel.a(this.a).setBackgroundResource(2130846346);
      NearbyProfileDisplayPanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131494216));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afji
 * JD-Core Version:    0.7.0.1
 */