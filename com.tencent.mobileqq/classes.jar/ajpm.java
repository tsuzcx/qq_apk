import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ajpm
  implements DialogInterface.OnClickListener
{
  ajpm(ajpi paramajpi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      ajpi.a(this.a, ajpi.a(this.a), Long.valueOf(ajpi.a(this.a)).longValue());
      ajpi.a(this.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpm
 * JD-Core Version:    0.7.0.1
 */