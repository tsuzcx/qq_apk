import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;

public class afwi
  implements DialogInterface.OnClickListener
{
  public afwi(PhoneNumLoginImpl paramPhoneNumLoginImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afwi
 * JD-Core Version:    0.7.0.1
 */