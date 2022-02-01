import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aelo
  implements View.OnClickListener
{
  public aelo(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, SpecailCareListActivity.class);
    this.a.startActivity(localIntent);
    bdla.b(this.a.app, "CliOper", "", "", "0X80050E3", "0X80050E3", 0, 0, "1", "", "", "");
    bdla.b(this.a.app, "CliOper", "", "", "Special_remind", "Clk_special_remind", 80, 0, "", "", "", "");
    if (this.a.app != null)
    {
      this.a.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).edit().putBoolean("spcial_care_qq_setting", false).commit();
      NotifyPushSettingActivity.b(this.a).setRightIcon(null);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare(onClick)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelo
 * JD-Core Version:    0.7.0.1
 */