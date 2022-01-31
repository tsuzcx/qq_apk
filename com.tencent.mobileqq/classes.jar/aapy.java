import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aapy
  implements DialogInterface.OnClickListener
{
  public aapy(aaqf paramaaqf, aaqe paramaaqe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aaqf.a) {
      axqw.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
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
 * Qualified Name:     aapy
 * JD-Core Version:    0.7.0.1
 */