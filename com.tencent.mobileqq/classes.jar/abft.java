import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class abft
  implements CompoundButton.OnCheckedChangeListener
{
  public abft(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131652800), "qqsetting_lock_screen_whenexit_key", paramBoolean);
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      awqx.b(localQQAppInterface, "CliOper", "", "", "0X80040D9", "0X80040D9", 0, 0, paramCompoundButton, "", "", "");
      if (QLog.isDevelopLevel()) {
        QLog.i("qqls", 4, "collectPerformance qqls setting isChecked=" + paramBoolean);
      }
      paramCompoundButton = new HashMap();
      paramCompoundButton.put("param_ls_setting", paramBoolean + "");
      awrn.a(BaseApplication.getContext()).a(this.a.app.getCurrentAccountUin(), "qqlsSettingReprotTag", true, 0L, 0L, paramCompoundButton, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abft
 * JD-Core Version:    0.7.0.1
 */