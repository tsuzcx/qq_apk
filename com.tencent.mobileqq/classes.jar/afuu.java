import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class afuu
  implements DialogInterface.OnClickListener
{
  afuu(afur paramafur) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      afur.a(this.a, afur.a(this.a), Long.valueOf(afur.a(this.a)).longValue());
      afur.a(this.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SDKEmotionSettingManager", 2, "setNegativeButton cancel error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuu
 * JD-Core Version:    0.7.0.1
 */