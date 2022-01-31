import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class airf
  implements DialogInterface.OnClickListener
{
  airf(aird paramaird) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(aird.a(this.a), 4, "right button is clicked! ");
    }
    aird.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airf
 * JD-Core Version:    0.7.0.1
 */