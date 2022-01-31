import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopDisbandActivity;

class acgw
  implements DialogInterface.OnClickListener
{
  acgw(acgv paramacgv, bbgg parambbgg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axqw.b(this.jdField_a_of_type_Acgv.a.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_more", 0, 0, this.jdField_a_of_type_Acgv.a.a, "", "", "");
    paramDialogInterface = new Intent(this.jdField_a_of_type_Acgv.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "http://kf.qq.com/touch/apifaq/120307IVnEni140626N3EZzq.html?platform=15&ADTAG=veda.mobileqq.app&_wv=1027");
    paramDialogInterface.putExtra("webStyle", "noBottomBar");
    this.jdField_a_of_type_Acgv.a.startActivity(paramDialogInterface);
    this.jdField_a_of_type_Bbgg.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acgw
 * JD-Core Version:    0.7.0.1
 */