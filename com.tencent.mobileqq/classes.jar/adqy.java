import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class adqy
  implements DialogInterface.OnCancelListener
{
  adqy(adsy paramadsy, int paramInt, adsx paramadsx) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Adsy.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      bcst.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adsx != null) {
        this.jdField_a_of_type_Adsx.a();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        bcst.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqy
 * JD-Core Version:    0.7.0.1
 */