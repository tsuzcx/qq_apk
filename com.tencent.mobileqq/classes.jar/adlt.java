import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class adlt
  implements DialogInterface.OnCancelListener
{
  adlt(adnn paramadnn, int paramInt, adnm paramadnm) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Adnn.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      bdla.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adnm != null) {
        this.jdField_a_of_type_Adnm.onCancel();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        bdla.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "3", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlt
 * JD-Core Version:    0.7.0.1
 */