import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.content.Intent;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class acbt
  implements bhqd
{
  public acbt(AuthDevActivity paramAuthDevActivity, String paramString1, long paramLong, String paramString2, int paramInt, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity) != null) && (AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.isFinishing()))
      {
        AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).dismiss();
        AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).cancel();
        AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, null);
      }
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, AuthDevRenameActivity.class);
      paramView.putExtra(AuthDevRenameActivity.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      paramView.putExtra(AuthDevRenameActivity.c, this.jdField_a_of_type_Long);
      paramView.putExtra(AuthDevRenameActivity.d, AppSetting.a());
      paramView.putExtra(AuthDevRenameActivity.e, NetConnInfoCenter.GUID);
      paramView.putExtra(AuthDevRenameActivity.f, this.jdField_b_of_type_JavaLangString);
      paramView.putExtra(AuthDevRenameActivity.g, ((SvcDevLoginInfo)AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).get(this.jdField_a_of_type_Int)).strDeviceTypeInfo);
      paramView.putExtra(AuthDevRenameActivity.h, ((SvcDevLoginInfo)AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).get(this.jdField_a_of_type_Int)).stDeviceItemDes.vecItemDes);
      paramView.putExtra(AuthDevRenameActivity.i, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.startActivity(paramView);
      continue;
      if (AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity)) {
        for (;;)
        {
          try
          {
            if (!this.jdField_a_of_type_Boolean) {
              break label352;
            }
            paramView = "0X800AC56";
            azmj.b(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
            AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.c, this.jdField_a_of_type_Long);
          }
          catch (Throwable paramView)
          {
            QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "showDelDevActionSheet error : ", paramView.getMessage() });
          }
          break;
          label352:
          paramView = "0X800AC58";
        }
      }
      if (!bdee.d(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getString(2131692397), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.getTitleBarHeight());
      }
      else
      {
        QLog.d("Q.devlock.AuthDevActivity", 1, "OnClick.begin to del recent dev");
        if (apwu.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int)) {
          AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
        } else {
          QLog.d("Q.devlock.AuthDevActivity", 1, "OnClick del recent dev fail");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbt
 * JD-Core Version:    0.7.0.1
 */