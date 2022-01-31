import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;

public class afkw
  implements View.OnClickListener
{
  public afkw(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (((this.a.a.e == 2) || (this.a.a.e == 4)) && (!NearbyVideoUtils.a(this.a.a, this.a.a.app))) {
      NearbyVideoUtils.a(this.a.a, this.a.a.app, 1);
    }
    paramView = NearbyProfileDisplayTribePanel.a(this.a).uin;
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (this.a.a.e == 2) {}
    for (;;)
    {
      NearbyVideoUtils.a("clk_video_entry", new String[] { "2", paramView, i });
      return;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afkw
 * JD-Core Version:    0.7.0.1
 */