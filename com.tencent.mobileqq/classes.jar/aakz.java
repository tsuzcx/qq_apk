import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.content.Intent;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import java.util.List;

public class aakz
  implements bfoq
{
  public aakz(AuthDevActivity paramAuthDevActivity, String paramString1, long paramLong, String paramString2, int paramInt, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
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
      paramView.putExtra(AuthDevRenameActivity.g, ((SvcDevLoginInfo)AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).get(this.jdField_a_of_type_Int)).strDeviceTypeInfo);
      paramView.putExtra(AuthDevRenameActivity.h, ((SvcDevLoginInfo)AuthDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity).get(this.jdField_a_of_type_Int)).stDeviceItemDes.vecItemDes);
      paramView.putExtra(AuthDevRenameActivity.i, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity.startActivity(paramView);
      continue;
      try
      {
        AuthDevActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Long);
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aakz
 * JD-Core Version:    0.7.0.1
 */