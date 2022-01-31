import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class afus
  implements DialogInterface.OnClickListener
{
  afus(afup paramafup) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      afup.a(this.a, afup.a(this.a), Long.valueOf(afup.a(this.a)).longValue());
      afup.a(this.a);
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
 * Qualified Name:     afus
 * JD-Core Version:    0.7.0.1
 */