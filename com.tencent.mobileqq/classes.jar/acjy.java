import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class acjy
  implements DialogInterface.OnCancelListener
{
  public acjy(aclo paramaclo, int paramInt, acln paramacln) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aclo.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      azqs.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acln != null) {
        this.jdField_a_of_type_Acln.a();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        azqs.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjy
 * JD-Core Version:    0.7.0.1
 */