import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMManager;

public class aaes
  implements View.OnClickListener
{
  public aaes(AboutActivity paramAboutActivity, asfc paramasfc) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Asfc.d))
    {
      ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app.getManager(256)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, this.jdField_a_of_type_Asfc.d);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X800865C", "0X800865C", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Asfc.a();
    AboutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaes
 * JD-Core Version:    0.7.0.1
 */