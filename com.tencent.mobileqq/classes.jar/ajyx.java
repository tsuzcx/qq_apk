import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ajyx
  implements DialogInterface.OnClickListener
{
  ajyx(ajyt paramajyt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      ajyt.a(this.a, ajyt.a(this.a), Long.valueOf(ajyt.a(this.a)).longValue());
      ajyt.a(this.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyx
 * JD-Core Version:    0.7.0.1
 */