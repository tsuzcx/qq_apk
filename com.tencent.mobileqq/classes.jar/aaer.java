import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.TMG.utils.QLog;

class aaer
  implements DialogInterface.OnCancelListener
{
  aaer(aaeo paramaaeo, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener == null)
    {
      QLog.e("SdkAuthDialog", 1, "cancelListener is null");
      return;
    }
    this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener.onCancel(paramDialogInterface);
    axqw.b(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaer
 * JD-Core Version:    0.7.0.1
 */