import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aitx
  implements DialogInterface.OnClickListener
{
  aitx(aitt paramaitt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      aitt.a(this.a, aitt.a(this.a), Long.valueOf(aitt.a(this.a)).longValue());
      aitt.a(this.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitx
 * JD-Core Version:    0.7.0.1
 */