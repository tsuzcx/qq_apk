import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class acjv
  implements DialogInterface.OnCancelListener
{
  public acjv(aclo paramaclo, acln paramacln) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aclo.a) {
      azqs.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "3", "", "", "");
    }
    if (this.jdField_a_of_type_Acln != null) {
      this.jdField_a_of_type_Acln.a();
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjv
 * JD-Core Version:    0.7.0.1
 */