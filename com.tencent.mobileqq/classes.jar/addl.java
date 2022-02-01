import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class addl
  implements View.OnClickListener
{
  public addl(AboutActivity paramAboutActivity, awty paramawty) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Awty.d))
    {
      ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, this.jdField_a_of_type_Awty.d);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity.app, "CliOper", "", "", "0X800865C", "0X800865C", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Awty.a();
    AboutActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAboutActivity, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addl
 * JD-Core Version:    0.7.0.1
 */