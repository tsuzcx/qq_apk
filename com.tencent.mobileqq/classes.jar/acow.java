import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;

public class acow
  implements DialogInterface.OnClickListener
{
  public acow(UpgradeDetailActivity paramUpgradeDetailActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      akuz.a().b(false);
      paramDialogInterface.dismiss();
      UpgradeDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeDetailActivity, this.jdField_a_of_type_Int, 3);
      return;
    }
    UpgradeDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeDetailActivity, this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeDetailActivity, this.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
    UpgradeDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityUpgradeDetailActivity, this.jdField_a_of_type_Int, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acow
 * JD-Core Version:    0.7.0.1
 */