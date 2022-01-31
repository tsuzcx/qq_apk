import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aagg
  implements DialogInterface.OnClickListener
{
  public aagg(aagn paramaagn, aagm paramaagm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aagn.a) {
      awqx.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
    }
    if (this.jdField_a_of_type_Aagm != null) {
      this.jdField_a_of_type_Aagm.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagg
 * JD-Core Version:    0.7.0.1
 */