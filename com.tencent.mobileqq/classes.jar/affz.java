import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class affz
  implements Animation.AnimationListener
{
  public affz(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayTribePanel.b(this.a))
    {
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(8);
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(4);
      NearbyProfileDisplayTribePanel.a(this.a).clearAnimation();
      NearbyProfileDisplayTribePanel.a(this.a).clearAnimation();
      NearbyProfileDisplayTribePanel.a(this.a).setBackgroundResource(2130845274);
      NearbyProfileDisplayTribePanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131494188));
      NearbyProfileDisplayTribePanel.b(this.a).setTextColor(this.a.a.getResources().getColor(2131494188));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayTribePanel.a(this.a))
    {
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayTribePanel.a(this.a).setBackgroundResource(2130846264);
      NearbyProfileDisplayTribePanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131494210));
      NearbyProfileDisplayTribePanel.b(this.a).setTextColor(this.a.a.getResources().getColor(2131494210));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     affz
 * JD-Core Version:    0.7.0.1
 */