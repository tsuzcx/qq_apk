import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;

public class agbo
  implements bliz
{
  public agbo(ActivateFriendActivity paramActivateFriendActivity, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      if (ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity) == null) {
        ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, (aold)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app.getManager(85));
      }
      if (bhnv.d(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity))
      {
        paramView = ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity);
        boolean bool;
        if (!ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity))
        {
          bool = true;
          label91:
          paramView.a(bool, true);
          if (!ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {
            break label219;
          }
          paramInt = 2;
          label109:
          LpReportInfo_dc00518.report(100, paramInt, paramInt);
          if (!ActivateFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity)) {
            break label224;
          }
        }
        label219:
        label224:
        for (paramView = "QQnotice.aio.detail.seton";; paramView = "QQnotice.aio.detail.setoff")
        {
          if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "do report: " + paramView);
          }
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app, "P_CliOper", "QQnotice", "", "", paramView, 0, 0, "", "", "", "");
          agci.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.app, "remindpage_click", null, null, String.valueOf(1), String.valueOf(paramInt));
          break;
          bool = false;
          break label91;
          paramInt = 1;
          break label109;
        }
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity != null)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.getResources().getString(2131693965), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbo
 * JD-Core Version:    0.7.0.1
 */