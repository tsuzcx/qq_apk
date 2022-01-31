import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;

public class abpf
  implements DialogInterface.OnClickListener
{
  public abpf(NotifyPCActiveActivity paramNotifyPCActiveActivity, ajti paramajti) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Ajti.b(true);
    BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpf
 * JD-Core Version:    0.7.0.1
 */