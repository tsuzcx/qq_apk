import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class aagh
  implements DialogInterface.OnCancelListener
{
  public aagh(aagn paramaagn, aagm paramaagm) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aagn.a) {
      awqx.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Aagm != null) {
      this.jdField_a_of_type_Aagm.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagh
 * JD-Core Version:    0.7.0.1
 */