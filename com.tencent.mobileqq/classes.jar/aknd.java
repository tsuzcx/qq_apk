import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aknd
  implements DialogInterface.OnClickListener
{
  aknd(aknb paramaknb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(aknb.a(this.a), 4, "right button is clicked! ");
    }
    aknb.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aknd
 * JD-Core Version:    0.7.0.1
 */