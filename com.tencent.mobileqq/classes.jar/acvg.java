import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class acvg
  implements DialogInterface.OnClickListener
{
  acvg(acxb paramacxb, int paramInt, acxa paramacxa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Acxb.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      bcef.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "2", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acxa != null) {
        this.jdField_a_of_type_Acxa.onCancel();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        bcef.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "2", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvg
 * JD-Core Version:    0.7.0.1
 */