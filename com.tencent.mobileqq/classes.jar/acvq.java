import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class acvq
  implements DialogInterface.OnCancelListener
{
  acvq(acxb paramacxb, acxa paramacxa) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Acxb.a) {
      bcef.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Acxa != null) {
      this.jdField_a_of_type_Acxa.onCancel();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvq
 * JD-Core Version:    0.7.0.1
 */