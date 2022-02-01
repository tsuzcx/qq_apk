import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class aefl
  implements DialogInterface.OnDismissListener
{
  public aefl(LbsBaseActivity paramLbsBaseActivity, Runnable paramRunnable) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.a();
      return;
    }
    LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity, this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefl
 * JD-Core Version:    0.7.0.1
 */