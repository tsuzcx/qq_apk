import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class aaqs
  implements DialogInterface.OnClickListener
{
  aaqs(aaqr paramaaqr, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_Aaqr.a));
    BaseActivity.sTopActivity.startActivity(paramDialogInterface);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqs
 * JD-Core Version:    0.7.0.1
 */