import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ahxa
  implements DialogInterface.OnClickListener
{
  ahxa(ahww paramahww) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      ahww.a(this.a, ahww.a(this.a), Long.valueOf(ahww.a(this.a)).longValue());
      ahww.a(this.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxa
 * JD-Core Version:    0.7.0.1
 */