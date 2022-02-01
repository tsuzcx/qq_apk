import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ajnn
  implements DialogInterface.OnClickListener
{
  ajnn(ajnk paramajnk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "showAccountConfirm which=", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      ajnk.c(this.a);
    }
    while (paramInt != 0) {
      return;
    }
    ajnk.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnn
 * JD-Core Version:    0.7.0.1
 */