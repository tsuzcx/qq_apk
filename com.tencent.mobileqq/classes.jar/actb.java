import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class actb
  implements DialogInterface.OnClickListener
{
  actb(acsz paramacsz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("GdtMvViewController", 1, " DialogInterface onClick confirm");
    acsz.a(this.a, false);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actb
 * JD-Core Version:    0.7.0.1
 */