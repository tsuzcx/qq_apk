import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ahsl
  implements DialogInterface.OnClickListener
{
  ahsl(ahsh paramahsh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      ahsh.a(this.a, ahsh.a(this.a), Long.valueOf(ahsh.a(this.a)).longValue());
      ahsh.a(this.a);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("SDKEmotionSettingManager", 1, "setNegativeButton cancel error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsl
 * JD-Core Version:    0.7.0.1
 */