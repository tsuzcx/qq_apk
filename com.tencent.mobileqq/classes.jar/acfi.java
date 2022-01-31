import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class acfi
  implements DialogInterface.OnClickListener
{
  public acfi(acgz paramacgz, int paramInt, acgy paramacgy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Acgz.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label59;
      }
      azmj.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "2", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Acgy != null) {
        this.jdField_a_of_type_Acgy.a();
      }
      return;
      label59:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        azmj.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "2", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfi
 * JD-Core Version:    0.7.0.1
 */