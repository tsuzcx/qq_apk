import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class acjx
  implements DialogInterface.OnClickListener
{
  public acjx(aclo paramaclo, int paramInt, acln paramacln) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Aclo.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      azqs.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "2", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acln != null) {
        this.jdField_a_of_type_Acln.a();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        azqs.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "2", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjx
 * JD-Core Version:    0.7.0.1
 */