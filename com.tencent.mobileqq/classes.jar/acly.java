import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView.VerifyPswEvent;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class acly
  implements VerifyPwdView.VerifyPswEvent
{
  public acly(FMActivity paramFMActivity, int paramInt) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(16, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131428302));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(15, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131428303));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(17, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131428306));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(18, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131428305));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(19, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131428307));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.d >= 15) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.d <= 19)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.d);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acly
 * JD-Core Version:    0.7.0.1
 */