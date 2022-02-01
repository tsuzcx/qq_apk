import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class adrh
  implements DialogInterface.OnCancelListener
{
  adrh(adsy paramadsy, adsx paramadsx) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Adsy.a) {
      bcst.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Adsx != null) {
      this.jdField_a_of_type_Adsx.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrh
 * JD-Core Version:    0.7.0.1
 */