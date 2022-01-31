import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import protocol.KQQConfig.UpgradeInfo;

public class aaet
  implements View.OnClickListener
{
  public aaet(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (bdlr.a().b())
    {
      if (bbjm.a()) {
        i = 1;
      }
      axqy.b(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
      paramView = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      paramView.putExtra("StrTitle", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
      paramView.putExtra("StrUpgradeDesc", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
      paramView.putExtra("iUpgradeType", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      paramView.putExtra("activity_type", 4096);
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(paramView);
      }
    }
    do
    {
      do
      {
        return;
        if ((AboutActivity.a(this.a).jdField_a_of_type_Akve == null) || (!bbjm.a(AboutActivity.a(this.a).jdField_a_of_type_Akve.a))) {
          break;
        }
        if (bbjm.a()) {
          i = 1;
        }
        axqy.b(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
        paramView = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
        paramView.putExtra("StrTitle", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
        paramView.putExtra("StrUpgradeDesc", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
        paramView.putExtra("iUpgradeType", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
        paramView.putExtra("activity_type", 4096);
      } while (BaseActivity.sTopActivity == null);
      BaseActivity.sTopActivity.startActivity(paramView);
      return;
    } while ((AboutActivity.a(this.a) == null) || (AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo == null));
    axqy.b(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", akuz.a(), "");
    UpgradeDetailActivity.a(this.a, akuz.a().a(), false, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaet
 * JD-Core Version:    0.7.0.1
 */