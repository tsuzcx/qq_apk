import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class aaiw
  implements DialogInterface.OnClickListener
{
  aaiw(aaiu paramaaiu, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ArkAppCenter.a().post(new aaix(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label38:
      ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_Aaiu.a, "ark_authority_api_login", this.jdField_a_of_type_Aaiu.c, 2);
      paramDialogInterface = DialogUtil.a(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getString(2131438801), 2131435252, 2131435252, new DialogUtil.DialogOnClickAdapter(), null);
      try
      {
        paramDialogInterface.show();
        return;
      }
      catch (Exception paramDialogInterface) {}
    }
    catch (Exception paramDialogInterface)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaiw
 * JD-Core Version:    0.7.0.1
 */