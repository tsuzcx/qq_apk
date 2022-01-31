import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class afeq
  implements View.OnClickListener
{
  public afeq(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString + "&type" + NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel).gender);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.e != 2) {
      if (NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel).gender == 0)
      {
        paramView = "他";
        ((Intent)localObject).putExtra("title", paramView + "的更新");
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.startActivity((Intent)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.e != 2) {
          break label254;
        }
      }
    }
    label254:
    for (paramView = "1";; paramView = "2")
    {
      ReportController.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "clk_pub", 0, 0, paramView, "", "", "");
      return;
      paramView = "她";
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app == null)
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "mActivity.app == null is true!");
        return;
      }
      ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app.getManager(105)).d.put(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel.a.app.getCurrentAccountUin(), Integer.valueOf(1));
      paramView = "我";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afeq
 * JD-Core Version:    0.7.0.1
 */