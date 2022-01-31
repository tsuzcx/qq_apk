import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class aaol
  implements DialogInterface.OnCancelListener
{
  public aaol(aaqb paramaaqb, int paramInt, aaqa paramaaqa) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aaqb.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      axqy.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aaqa != null) {
        this.jdField_a_of_type_Aaqa.a();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        axqy.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaol
 * JD-Core Version:    0.7.0.1
 */