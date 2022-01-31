import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aclh
  implements DialogInterface.OnClickListener
{
  public aclh(aclo paramaclo, acln paramacln) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aclo.a) {
      azqs.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
    }
    if (this.jdField_a_of_type_Acln != null) {
      this.jdField_a_of_type_Acln.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclh
 * JD-Core Version:    0.7.0.1
 */