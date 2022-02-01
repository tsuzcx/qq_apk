import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class acfc
  implements DialogInterface.OnClickListener
{
  acfc(acey paramacey) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("GdtMvViewController", 1, " DialogInterface onClick confirm");
    acey.a(this.a, false);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfc
 * JD-Core Version:    0.7.0.1
 */