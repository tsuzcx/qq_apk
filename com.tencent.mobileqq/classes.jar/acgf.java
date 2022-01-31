import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;

public class acgf
  implements CompoundButton.OnCheckedChangeListener
{
  public acgf(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == AuthDevActivity.a(this.a).a())
    {
      AuthDevActivity.a(this.a).setOnCheckedChangeListener(null);
      paramCompoundButton = AuthDevActivity.a(this.a);
      if (AuthDevActivity.a(this.a).a())
      {
        paramBoolean = false;
        paramCompoundButton.setChecked(paramBoolean);
        AuthDevActivity.a(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
        if (bdin.d(this.a)) {
          break label114;
        }
        QQToast.a(this.a, this.a.getString(2131692398), 0).b(this.a.getTitleBarHeight());
      }
    }
    label114:
    do
    {
      do
      {
        return;
        paramBoolean = true;
        break;
        paramCompoundButton = (amci)this.a.app.a(34);
      } while (paramCompoundButton == null);
      if (!AuthDevActivity.a(this.a).a()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCompoundButton.a(paramBoolean);
        return;
      }
      if (paramCompoundButton == AuthDevActivity.b(this.a).a())
      {
        if (AuthDevActivity.b(this.a).a())
        {
          paramCompoundButton = "0";
          azqs.b(null, "dc00898", "", "", "0X800AC54", "0X800AC54", 0, 0, paramCompoundButton, "", "", "");
          AuthDevActivity.b(this.a).setOnCheckedChangeListener(null);
          paramCompoundButton = AuthDevActivity.b(this.a);
          if (!AuthDevActivity.b(this.a).a()) {
            break label283;
          }
        }
        for (paramBoolean = false;; paramBoolean = true)
        {
          paramCompoundButton.setChecked(paramBoolean);
          AuthDevActivity.b(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
          AuthDevActivity.a(this.a);
          return;
          paramCompoundButton = "1";
          break;
        }
      }
    } while (paramCompoundButton != AuthDevActivity.c(this.a).a());
    label283:
    int i;
    if (AuthDevActivity.c(this.a).a())
    {
      paramCompoundButton = "1";
      azqs.b(null, "dc00898", "", "", "0X800AC53", "0X800AC53", 0, 0, paramCompoundButton, "", "", "");
      paramCompoundButton = this.a.app;
      if (!paramBoolean) {
        break label446;
      }
      i = 1;
      label355:
      azqs.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
      if (!paramBoolean) {
        break label451;
      }
      azqs.b(null, "dc00898", "", "", "0X800A721", "0X800A721", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      SettingCloneUtil.writeValue(this.a, this.a.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
      this.a.app.p();
      return;
      paramCompoundButton = "0";
      break;
      label446:
      i = 0;
      break label355;
      label451:
      azqs.b(null, "dc00898", "", "", "0X800A722", "0X800A722", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgf
 * JD-Core Version:    0.7.0.1
 */