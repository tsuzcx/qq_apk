import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aexd
  implements CompoundButton.OnCheckedChangeListener
{
  public aexd(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == LoginInfoActivity.a(this.a).a())
    {
      localQQAppInterface = this.a.app;
      if (paramBoolean)
      {
        i = 1;
        bdll.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
        if (!paramBoolean) {
          break label142;
        }
        bdll.b(null, "dc00898", "", "", "0X800A721", "0X800A721", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "帐号安全页点击“允许手机、电脑同时在线”进行开启！0X800A721");
        }
        label96:
        SettingCloneUtil.writeValue(this.a, this.a.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
        this.a.app.q();
      }
    }
    label142:
    label219:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        i = 0;
        break;
        bdll.b(null, "dc00898", "", "", "0X800A722", "0X800A722", 0, 0, "", "", "", "");
        if (!QLog.isColorLevel()) {
          break label96;
        }
        QLog.d("DevRpt", 2, "帐号安全页点击“允许手机、电脑同时在线”进行关闭！0X800A722");
        break label96;
        if ((LoginInfoActivity.b(this.a) == null) || (paramCompoundButton != LoginInfoActivity.b(this.a).a())) {
          break label219;
        }
        LoginInfoActivity.a(this.a, paramBoolean);
      }
    } while (paramCompoundButton != LoginInfoActivity.c(this.a).a());
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Security_check", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, "security_scan_key", "qqsetting_security_scan_key", paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexd
 * JD-Core Version:    0.7.0.1
 */