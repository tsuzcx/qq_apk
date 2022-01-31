import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;

public class aeik
  implements bhqd
{
  public aeik(ActivateFriendActivity paramActivateFriendActivity, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity) == null) {
        ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, (ambl)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app.getManager(85));
      }
      if (bdee.d(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity))
      {
        paramView = ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity);
        boolean bool;
        if (!ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity))
        {
          bool = true;
          label92:
          paramView.a(bool, true);
          paramInt = i;
          if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {
            paramInt = 2;
          }
          LpReportInfo_dc00518.report(100, paramInt, paramInt);
          if (!ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {
            break label202;
          }
        }
        label202:
        for (paramView = "QQnotice.aio.detail.seton";; paramView = "QQnotice.aio.detail.setoff")
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "do report: " + paramView);
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app, "P_CliOper", "QQnotice", "", "", paramView, 0, 0, "", "", "", "");
          break;
          bool = false;
          break label92;
        }
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity != null)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.getResources().getString(2131694766), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeik
 * JD-Core Version:    0.7.0.1
 */