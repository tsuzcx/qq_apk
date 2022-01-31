import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class aaom
  implements DialogInterface.OnCancelListener
{
  public aaom(aaqf paramaaqf, aaqe paramaaqe) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aaqf.a) {
      axqw.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Aaqe != null) {
      this.jdField_a_of_type_Aaqe.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaom
 * JD-Core Version:    0.7.0.1
 */