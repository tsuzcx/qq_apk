import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopDisbandActivity;

class afsg
  implements DialogInterface.OnClickListener
{
  afsg(afsf paramafsf, bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(this.jdField_a_of_type_Afsf.a.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_more", 0, 0, this.jdField_a_of_type_Afsf.a.a, "", "", "");
    paramDialogInterface = new Intent(this.jdField_a_of_type_Afsf.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://kf.qq.com/touch/apifaq/120307IVnEni140626N3EZzq.html?platform=15&ADTAG=veda.mobileqq.app&_wv=1027");
    paramDialogInterface.putExtra("webStyle", "noBottomBar");
    this.jdField_a_of_type_Afsf.a.startActivity(paramDialogInterface);
    this.jdField_a_of_type_Bhpc.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsg
 * JD-Core Version:    0.7.0.1
 */