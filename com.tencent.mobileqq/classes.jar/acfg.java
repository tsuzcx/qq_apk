import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class acfg
  implements DialogInterface.OnCancelListener
{
  public acfg(acgz paramacgz, acgy paramacgy) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Acgz.a) {
      azmj.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Acgy != null) {
      this.jdField_a_of_type_Acgy.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfg
 * JD-Core Version:    0.7.0.1
 */