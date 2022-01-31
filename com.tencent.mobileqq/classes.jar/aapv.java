import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class aapv
  implements DialogInterface.OnCancelListener
{
  public aapv(aaqb paramaaqb, aaqa paramaaqa) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aaqb.a) {
      axqy.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Aaqa != null) {
      this.jdField_a_of_type_Aaqa.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapv
 * JD-Core Version:    0.7.0.1
 */