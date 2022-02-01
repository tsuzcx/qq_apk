import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;

public class aekp
  implements DialogInterface.OnClickListener
{
  public aekp(NotifyPCActiveActivity paramNotifyPCActiveActivity, anri paramanri) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Anri.b(true);
    BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekp
 * JD-Core Version:    0.7.0.1
 */