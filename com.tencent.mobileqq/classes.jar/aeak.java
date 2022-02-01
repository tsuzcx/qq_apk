import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aeak
  implements DialogInterface.OnClickListener
{
  aeak(aeca paramaeca, aebz paramaebz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aeca.a) {
      bdll.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "2", "", "", "");
    }
    if (this.jdField_a_of_type_Aebz != null) {
      this.jdField_a_of_type_Aebz.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeak
 * JD-Core Version:    0.7.0.1
 */