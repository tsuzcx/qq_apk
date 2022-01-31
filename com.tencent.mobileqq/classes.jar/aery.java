import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class aery
  implements ActionSheet.OnButtonClickListener
{
  aery(aerx paramaerx, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Aerx.a.f = true;
    Object localObject1 = this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;
    paramView = (View)localObject1;
    if (StringUtil.a((String)localObject1))
    {
      paramView = (View)localObject1;
      if (NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_Aerx.a) != null) {
        paramView = NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_Aerx.a).uin;
      }
    }
    if (StringUtil.a(paramView)) {
      paramView = "0";
    }
    for (;;)
    {
      long l;
      if (this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_Long == 0L) {
        if (NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_Aerx.a) != null)
        {
          l = NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_Aerx.a).tinyId;
          label160:
          if ((!"0".equals(paramView)) || (l != 0L))
          {
            Object localObject2 = null;
            paramInt = 10028;
            localObject1 = null;
            if (this.jdField_a_of_type_Aerx.a.a.app != null) {
              localObject1 = this.jdField_a_of_type_Aerx.a.a.app.a(false);
            }
            if (((localObject1 == null) || (!((HotChatManager)localObject1).b(this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d))) && (this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 33) && (this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 4))
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 31) {}
            }
            else
            {
              paramInt = 10000;
              localObject1 = this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
            }
            ProfileCardUtil.a(this.jdField_a_of_type_Aerx.a.a, this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_Long, paramView, (String)localObject1, paramInt);
          }
          ReportController.b(this.jdField_a_of_type_Aerx.a.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
          if ((NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_Aerx.a) != null) && (NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_Aerx.a).iIsGodFlag == 1))
          {
            if (NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_Aerx.a).gender != 0) {
              break label604;
            }
            ReportController.b(this.jdField_a_of_type_Aerx.a.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_Aerx.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_report", 0, 0, "", "", "", "");
        if (!ProfileActivity.c(this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_Aerx.a.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
        break;
        l = 0L;
        break label160;
        l = this.jdField_a_of_type_Aerx.a.a.jdField_a_of_type_Long;
        break label160;
        label604:
        if (NearbyProfileDisplayTribePanel.a(this.jdField_a_of_type_Aerx.a).gender == 1) {
          ReportController.b(this.jdField_a_of_type_Aerx.a.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aery
 * JD-Core Version:    0.7.0.1
 */