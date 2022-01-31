import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;

public class acom
  implements DialogInterface.OnClickListener
{
  public acom(UpgradeActivity paramUpgradeActivity, bbfk parambbfk, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bbfk.d();
    bbjm.c(true);
    bbjm.c(this.jdField_a_of_type_Int);
    UpgradeDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeActivity, akuz.a().a(), false, true, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acom
 * JD-Core Version:    0.7.0.1
 */