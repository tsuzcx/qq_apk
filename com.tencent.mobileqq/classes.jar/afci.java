import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class afci
  implements DialogInterface.OnClickListener
{
  afci(afcg paramafcg, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.b(this.jdField_a_of_type_Afcg.a.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_know", 0, 0, this.jdField_a_of_type_Afcg.a.a, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afci
 * JD-Core Version:    0.7.0.1
 */