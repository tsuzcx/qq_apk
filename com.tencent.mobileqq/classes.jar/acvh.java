import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class acvh
  implements DialogInterface.OnCancelListener
{
  acvh(acxb paramacxb, int paramInt, acxa paramacxa) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Acxb.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      bcef.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acxa != null) {
        this.jdField_a_of_type_Acxa.onCancel();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        bcef.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvh
 * JD-Core Version:    0.7.0.1
 */