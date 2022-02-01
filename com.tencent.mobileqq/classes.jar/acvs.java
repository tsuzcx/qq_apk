import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class acvs
  implements DialogInterface.OnClickListener
{
  acvs(acxb paramacxb, acxa paramacxa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Acxb.a) {
      bcef.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
    }
    if (this.jdField_a_of_type_Acxa != null) {
      this.jdField_a_of_type_Acxa.onCancel();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvs
 * JD-Core Version:    0.7.0.1
 */