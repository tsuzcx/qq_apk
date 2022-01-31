import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class adcv
  implements CompoundButton.OnCheckedChangeListener
{
  public adcv(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == LoginInfoActivity.a(this.a).a())
    {
      paramCompoundButton = this.a.app;
      if (paramBoolean)
      {
        i = 1;
        azmj.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
        if (!paramBoolean) {
          break label132;
        }
        azmj.b(null, "dc00898", "", "", "0X800A721", "0X800A721", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "帐号安全页点击“允许手机、电脑同时在线”进行开启！0X800A721");
        }
        label94:
        SettingCloneUtil.writeValue(this.a, this.a.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
        this.a.app.p();
      }
    }
    label132:
    do
    {
      return;
      i = 0;
      break;
      azmj.b(null, "dc00898", "", "", "0X800A722", "0X800A722", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break label94;
      }
      QLog.d("DevRpt", 2, "帐号安全页点击“允许手机、电脑同时在线”进行关闭！0X800A722");
      break label94;
      if ((LoginInfoActivity.b(this.a) != null) && (paramCompoundButton == LoginInfoActivity.b(this.a).a()))
      {
        LoginInfoActivity.a(this.a, paramBoolean);
        return;
      }
    } while (paramCompoundButton != LoginInfoActivity.c(this.a).a());
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      azmj.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Security_check", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, "security_scan_key", "qqsetting_security_scan_key", paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcv
 * JD-Core Version:    0.7.0.1
 */