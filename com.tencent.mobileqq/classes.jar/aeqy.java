import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.AlertReport.ButtonAction;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class aeqy
  implements DialogInterface.OnClickListener
{
  public aeqy(NotificationActivity paramNotificationActivity, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new AlertReport.ButtonAction();
      paramDialogInterface.uint32_cmd.set(1);
      paramDialogInterface.uint32_button_id.set(this.jdField_a_of_type_Int);
      paramDialogInterface.str_package_name.set(bkab.c());
      paramDialogInterface.uint32_app_id.set(AppSetting.a());
      nir.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app, paramDialogInterface.toByteArray(), 34, "SecuritySvc.AlertReport");
      bcst.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007535", "0X8007535", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeqy
 * JD-Core Version:    0.7.0.1
 */