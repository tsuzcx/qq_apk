import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class aeai
  implements DialogInterface.OnCancelListener
{
  aeai(aeca paramaeca, aebz paramaebz) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aeca.a) {
      bdll.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Aebz != null) {
      this.jdField_a_of_type_Aebz.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeai
 * JD-Core Version:    0.7.0.1
 */