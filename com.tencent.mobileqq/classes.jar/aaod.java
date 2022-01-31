import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class aaod
  implements DialogInterface.OnClickListener
{
  aaod(aanz paramaanz, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ArkAppCenter.a().post(new aaoe(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label38:
      ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_Aanz.a, "ark_authority_api_location", this.jdField_a_of_type_Aanz.c, 1);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaod
 * JD-Core Version:    0.7.0.1
 */