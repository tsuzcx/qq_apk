import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity;

class aeeq
  implements DialogInterface.OnClickListener
{
  aeeq(aeep paramaeep, bdfq parambdfq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azmj.b(this.jdField_a_of_type_Aeep.a.app, "P_CliOper", "Grp_manage", "", "turn_grp", "Clk_more", 0, 0, this.jdField_a_of_type_Aeep.a.a, "", "", "");
    paramDialogInterface = new Intent(this.jdField_a_of_type_Aeep.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "http://kf.qq.com/touch/apifaq/120307IVnEni140626N3EZzq.html?platform=15&ADTAG=veda.mobileqq.app&_wv=1027");
    paramDialogInterface.putExtra("webStyle", "noBottomBar");
    this.jdField_a_of_type_Aeep.a.startActivity(paramDialogInterface);
    this.jdField_a_of_type_Bdfq.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeeq
 * JD-Core Version:    0.7.0.1
 */