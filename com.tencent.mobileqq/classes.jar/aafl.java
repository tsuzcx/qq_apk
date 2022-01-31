import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.arcard.ARCardShareHelper;

public class aafl
  implements DialogInterface.OnDismissListener
{
  public aafl(ARCardShareHelper paramARCardShareHelper, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aafl
 * JD-Core Version:    0.7.0.1
 */