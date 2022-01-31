import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.statistics.ReportController;

public class afet
  implements View.OnClickListener
{
  public afet(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, NearbyVisitorListActivity.class);
    paramView.putExtra("charmlevel", NearbyProfileDisplayTribePanel.a(this.a).charmLevel);
    paramView.putExtra("download_tribe_app_url", NearbyProfileDisplayTribePanel.a(this.a).tribeAppDownloadPageUrl);
    paramView.putExtra("is_show_tribeapp_download_layout", NearbyProfileDisplayTribePanel.a(this.a).isAddPicBtnDownloadAppOpen());
    this.a.a.startActivity(paramView);
    NearbyProfileDisplayTribePanel.a(this.a, null);
    ThreadManager.post(new afeu(this), 5, null, false);
    ReportController.b(this.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_visit", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afet
 * JD-Core Version:    0.7.0.1
 */