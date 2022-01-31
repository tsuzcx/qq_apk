import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class afix
  implements DialogInterface.OnClickListener
{
  afix(afiu paramafiu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      afiu.a(this.a, afiu.a(this.a), Long.valueOf(afiu.a(this.a)).longValue());
      afiu.a(this.a);
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
 * Qualified Name:     afix
 * JD-Core Version:    0.7.0.1
 */