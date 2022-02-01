import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ajpl
  implements DialogInterface.OnClickListener
{
  ajpl(ajpi paramajpi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "showAccountConfirm which=", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      ajpi.c(this.a);
    }
    while (paramInt != 0) {
      return;
    }
    ajpi.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpl
 * JD-Core Version:    0.7.0.1
 */