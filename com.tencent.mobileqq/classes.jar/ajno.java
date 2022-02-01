import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ajno
  implements DialogInterface.OnClickListener
{
  ajno(ajnk paramajnk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      ajnk.a(this.a, ajnk.a(this.a), Long.valueOf(ajnk.a(this.a)).longValue());
      ajnk.a(this.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajno
 * JD-Core Version:    0.7.0.1
 */