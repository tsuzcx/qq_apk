import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class aaew
  implements DialogInterface.OnClickListener
{
  public aaew(aagn paramaagn, int paramInt, aagm paramaagm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aagn.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      awqx.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "2", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aagm != null) {
        this.jdField_a_of_type_Aagm.a();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        awqx.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "2", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaew
 * JD-Core Version:    0.7.0.1
 */