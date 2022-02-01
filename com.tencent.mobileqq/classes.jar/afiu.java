import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class afiu
  implements DialogInterface.OnClickListener
{
  afiu(afit paramafit, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.b(this.jdField_a_of_type_Afit.a.app, "P_CliOper", "Grp_manage", "", "turn_grp", "Clk_more", 0, 0, this.jdField_a_of_type_Afit.a.a, "", "", "");
    paramDialogInterface = new Intent(this.jdField_a_of_type_Afit.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://kf.qq.com/touch/apifaq/120307IVnEni140626N3EZzq.html?platform=15&ADTAG=veda.mobileqq.app&_wv=1027");
    paramDialogInterface.putExtra("webStyle", "noBottomBar");
    this.jdField_a_of_type_Afit.a.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afiu
 * JD-Core Version:    0.7.0.1
 */