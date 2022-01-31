import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;

public class abmw
  implements View.OnClickListener
{
  public abmw(BusinessCardEditActivity paramBusinessCardEditActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setEllipsisText(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abmw
 * JD-Core Version:    0.7.0.1
 */