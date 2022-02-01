import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ajyw
  implements DialogInterface.OnClickListener
{
  ajyw(ajyt paramajyt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "showAccountConfirm which=", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      ajyt.c(this.a);
    }
    while (paramInt != 0) {
      return;
    }
    ajyt.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyw
 * JD-Core Version:    0.7.0.1
 */