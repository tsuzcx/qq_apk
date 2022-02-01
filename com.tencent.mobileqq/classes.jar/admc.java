import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class admc
  implements DialogInterface.OnCancelListener
{
  admc(adnn paramadnn, adnm paramadnm) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Adnn.a) {
      bdla.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Adnm != null) {
      this.jdField_a_of_type_Adnm.onCancel();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admc
 * JD-Core Version:    0.7.0.1
 */