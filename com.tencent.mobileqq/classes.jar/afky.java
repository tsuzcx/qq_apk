import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class afky
  implements Animation.AnimationListener
{
  public afky(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayTribePanel.b(this.a))
    {
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(8);
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(4);
      NearbyProfileDisplayTribePanel.a(this.a).clearAnimation();
      NearbyProfileDisplayTribePanel.a(this.a).clearAnimation();
      NearbyProfileDisplayTribePanel.a(this.a).setBackgroundResource(2130845349);
      NearbyProfileDisplayTribePanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131494194));
      NearbyProfileDisplayTribePanel.b(this.a).setTextColor(this.a.a.getResources().getColor(2131494194));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayTribePanel.a(this.a))
    {
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayTribePanel.a(this.a).setBackgroundResource(2130846346);
      NearbyProfileDisplayTribePanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131494216));
      NearbyProfileDisplayTribePanel.b(this.a).setTextColor(this.a.a.getResources().getColor(2131494216));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afky
 * JD-Core Version:    0.7.0.1
 */