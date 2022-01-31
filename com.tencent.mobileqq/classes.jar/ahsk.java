import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ahsk
  implements DialogInterface.OnClickListener
{
  ahsk(ahsh paramahsh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "showAccountConfirm which=", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      ahsh.c(this.a);
    }
    while (paramInt != 0) {
      return;
    }
    ahsh.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsk
 * JD-Core Version:    0.7.0.1
 */