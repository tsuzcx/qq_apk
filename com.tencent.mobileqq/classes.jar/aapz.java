import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class aapz
  implements DialogInterface.OnCancelListener
{
  public aapz(aaqf paramaaqf, aaqe paramaaqe) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aaqf.a) {
      axqw.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Aaqe != null) {
      this.jdField_a_of_type_Aaqe.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapz
 * JD-Core Version:    0.7.0.1
 */