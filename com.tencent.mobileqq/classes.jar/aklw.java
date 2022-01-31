import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;

class aklw
  implements DialogInterface.OnClickListener
{
  aklw(aklv paramaklv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.cancel();
      this.a.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.finish();
      return;
    }
    try
    {
      ForwardSdkShareOption.a(this.a.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity, true, "action_game_bind_group", Long.valueOf(this.a.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.c).longValue(), -1, this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity.a.cancel();
      BindGroupConfirmActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity, -1);
      BindGroupConfirmActivity.a(this.a.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("BindGroupConfirmActivity", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aklw
 * JD-Core Version:    0.7.0.1
 */