import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.nearby.profilecard.OnTagClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class afes
  implements OnTagClickListener
{
  public afes(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayTribePanel", 2, "click troops item  tuin:" + paramInterestTagInfo.tagJumpUrl);
    }
    if (paramInterestTagInfo.tagJumpUrl.equals("icon_more_url"))
    {
      paramView = new Intent(this.a.a, QQBrowserActivity.class);
      paramView.putExtra("url", this.a.e);
      this.a.a.startActivity(paramView);
      paramInterestTagInfo = this.a.a.app;
      if (this.a.a.e == 2) {}
      for (paramView = "1";; paramView = "2")
      {
        ReportController.b(paramInterestTagInfo, "dc00899", "grp_lbs", "", "data_card", "clk_more_grp", 0, 0, paramView, "", "", "");
        return;
      }
    }
    paramView = TroopInfoActivity.a(paramInterestTagInfo.tagJumpUrl, 33);
    ChatSettingForTroop.a(this.a.a, paramView, -1);
    paramInterestTagInfo = this.a.a.app;
    if (this.a.a.e == 2) {}
    for (paramView = "1";; paramView = "2")
    {
      ReportController.b(paramInterestTagInfo, "dc00899", "grp_lbs", "", "data_card", "clk_grp", 0, 0, paramView, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afes
 * JD-Core Version:    0.7.0.1
 */