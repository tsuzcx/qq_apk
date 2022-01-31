import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class abfx
  implements View.OnClickListener
{
  public abfx(BusinessCardEditActivity paramBusinessCardEditActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a = null;
    }
    BusinessCardServlet.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.b("删除名片...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfx
 * JD-Core Version:    0.7.0.1
 */