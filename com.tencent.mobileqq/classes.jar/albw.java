import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1;

public class albw
  implements DialogInterface.OnClickListener
{
  public albw(ArkAppSchemeCenter.TelSchemeHandler.1 param1, bafb parambafb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bafb.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     albw
 * JD-Core Version:    0.7.0.1
 */