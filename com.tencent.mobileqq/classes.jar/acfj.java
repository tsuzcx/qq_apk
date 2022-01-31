import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class acfj
  implements DialogInterface.OnCancelListener
{
  public acfj(acgz paramacgz, int paramInt, acgy paramacgy) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Acgz.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      azmj.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acgy != null) {
        this.jdField_a_of_type_Acgy.a();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        azmj.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfj
 * JD-Core Version:    0.7.0.1
 */