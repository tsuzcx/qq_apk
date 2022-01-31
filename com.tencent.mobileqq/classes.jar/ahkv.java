import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;

public class ahkv
  implements berl
{
  public ahkv(TroopActivity paramTroopActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.b();
    }
    if (this.a.b != 2)
    {
      switch (paramInt2)
      {
      default: 
        azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        azmj.b(this.a.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        this.a.a(this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_Bhoe.sendEmptyMessage(1234);
        TroopActivity.a(this.a, paramInt2);
        return;
        azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
        azmj.b(this.a.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 0;
        continue;
        azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "discuss", "contact_discuss_tab", 0, 0, "", "", "", "");
        azmj.b(this.a.app, "CliOper", "", "", "0X8006621", "0X8006621", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 1;
      }
    }
    switch (paramInt2)
    {
    default: 
      if (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a()) {
        break;
      }
    }
    for (String str = "0";; str = "1")
    {
      azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", str, "", "");
      azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_Int = 1;
      break;
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a()) {}
      for (str = "0";; str = "1")
      {
        azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grpnotice", 0, 0, "", str, "", "");
        azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 1;
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a()) {}
      for (str = "0";; str = "1")
      {
        azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_grprecom", 0, 0, "", str, "", "");
        azmj.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
        this.a.jdField_a_of_type_Int = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkv
 * JD-Core Version:    0.7.0.1
 */