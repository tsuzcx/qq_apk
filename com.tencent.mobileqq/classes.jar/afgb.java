import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.statistics.ReportController;

public class afgb
  implements View.OnClickListener
{
  public afgb(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("&from=");
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a;
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.j)) {}
    for (paramView = "1";; paramView = "2")
    {
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_fans", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgb
 * JD-Core Version:    0.7.0.1
 */