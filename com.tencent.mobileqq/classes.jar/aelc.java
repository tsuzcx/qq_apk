import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class aelc
  implements CompoundButton.OnCheckedChangeListener
{
  public aelc(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131717979), "qqsetting_lock_screen_whenexit_key", paramBoolean);
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      bdla.b(localQQAppInterface, "CliOper", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject, "", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.i("qqls", 4, "collectPerformance qqls setting isChecked=" + paramBoolean);
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ls_setting", paramBoolean + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.app.getCurrentAccountUin(), "qqlsSettingReprotTag", true, 0L, 0L, (HashMap)localObject, "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelc
 * JD-Core Version:    0.7.0.1
 */