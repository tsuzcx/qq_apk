import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adqk
  implements View.OnClickListener
{
  public adqk(AboutActivity paramAboutActivity, axam paramaxam) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Axam.d))
    {
      ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app.getManager(256)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, this.jdField_a_of_type_Axam.d);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X800865C", "0X800865C", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Axam.a();
    AboutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqk
 * JD-Core Version:    0.7.0.1
 */