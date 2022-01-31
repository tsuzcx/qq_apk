import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;

public class agpb
  implements DialogInterface.OnDismissListener
{
  public agpb(ShareHelper paramShareHelper, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpb
 * JD-Core Version:    0.7.0.1
 */