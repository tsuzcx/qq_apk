import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class afko
  implements View.OnClickListener
{
  public afko(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    if (!NearbyVideoUtils.a(this.a.a, this.a.a.app))
    {
      boolean bool = SharedPreUtils.a(this.a.a);
      NearbyVideoUtils.a(this.a.a, NearbyProfileDisplayTribePanel.a(this.a), NearbyProfileDisplayTribePanel.a(this.a).videoInfo.d, NearbyProfileDisplayTribePanel.a(this.a).videoInfo.a, NearbyProfileDisplayTribePanel.a(this.a).uin, this.a.a.e, bool);
    }
    paramView = NearbyProfileDisplayTribePanel.a(this.a).uin;
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (this.a.a.e == 2) {}
    for (int i = 1;; i = 2)
    {
      NearbyVideoUtils.a("clk_video_entry", new String[] { "1", paramView, i });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afko
 * JD-Core Version:    0.7.0.1
 */