import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class almx
  implements DialogInterface.OnClickListener
{
  almx(almv paramalmv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(almv.a(this.a), 4, "right button is clicked! ");
    }
    almv.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almx
 * JD-Core Version:    0.7.0.1
 */