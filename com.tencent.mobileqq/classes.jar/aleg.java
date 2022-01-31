import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aleg
  implements DialogInterface.OnDismissListener
{
  private WeakReference a;
  
  public aleg(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.a = new WeakReference(paramOnDismissListener);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a == null) {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneProgressDialog", 2, "CustomDismissListener mDismissLis, lis is null");
      }
    }
    do
    {
      return;
      DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.a.get();
      if (localOnDismissListener != null)
      {
        localOnDismissListener.onDismiss(paramDialogInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QzoneProgressDialog", 2, "CustomDismissListener, lis is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aleg
 * JD-Core Version:    0.7.0.1
 */