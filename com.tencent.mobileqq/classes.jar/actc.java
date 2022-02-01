import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class actc
  implements DialogInterface.OnClickListener
{
  actc(acsz paramacsz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("GdtMvViewController", 1, " DialogInterface onClick onCancel");
    acsz.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actc
 * JD-Core Version:    0.7.0.1
 */