import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

class afdl
  implements View.OnClickListener
{
  afdl(afdk paramafdk) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(NearbyProfileDisplayPanel.a(this.a.jdField_a_of_type_Afdj.a).strGodJumpUrl)) {
      return;
    }
    paramView = new Intent(this.a.jdField_a_of_type_Afdj.a.a, QQBrowserActivity.class);
    Object localObject = new StringBuilder().append(NearbyProfileDisplayPanel.a(this.a.jdField_a_of_type_Afdj.a).strGodJumpUrl).append("&gender=");
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataCard == null)
    {
      i = 0;
      paramView.putExtra("url", i);
      this.a.jdField_a_of_type_Afdj.a.a.startActivity(paramView);
      localObject = this.a.jdField_a_of_type_Afdj.a.a.app;
      if (this.a.jdField_a_of_type_Afdj.a.a.e != 2) {
        break label202;
      }
    }
    label202:
    for (paramView = "1";; paramView = "2")
    {
      ReportController.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "rank_list", "clk_icon", 0, 0, paramView, "", "", "");
      return;
      i = this.a.jdField_a_of_type_ComTencentMobileqqDataCard.shGender + 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdl
 * JD-Core Version:    0.7.0.1
 */