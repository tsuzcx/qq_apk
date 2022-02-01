import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adns
  implements CompoundButton.OnCheckedChangeListener
{
  public adns(AuthDevActivity paramAuthDevActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    boolean bool;
    if (paramCompoundButton == AuthDevActivity.a(this.a).a())
    {
      AuthDevActivity.a(this.a).setOnCheckedChangeListener(null);
      localObject = AuthDevActivity.a(this.a);
      if (AuthDevActivity.a(this.a).a())
      {
        bool = false;
        ((FormSwitchItem)localObject).setChecked(bool);
        AuthDevActivity.a(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
        if (bgnt.d(this.a)) {
          break label127;
        }
        QQToast.a(this.a, this.a.getString(2131691985), 0).b(this.a.getTitleBarHeight());
      }
    }
    label127:
    do
    {
      do
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = true;
        break;
        localObject = (anus)this.a.app.a(34);
      } while (localObject == null);
      if (!AuthDevActivity.a(this.a).a()) {}
      for (bool = true;; bool = false)
      {
        ((anus)localObject).a(bool);
        break;
      }
      if (paramCompoundButton == AuthDevActivity.b(this.a).a())
      {
        if (AuthDevActivity.b(this.a).a())
        {
          localObject = "0";
          bcst.b(null, "dc00898", "", "", "0X800AC54", "0X800AC54", 0, 0, (String)localObject, "", "", "");
          AuthDevActivity.b(this.a).setOnCheckedChangeListener(null);
          localObject = AuthDevActivity.b(this.a);
          if (!AuthDevActivity.b(this.a).a()) {
            break label313;
          }
        }
        for (bool = false;; bool = true)
        {
          ((FormSwitchItem)localObject).setChecked(bool);
          AuthDevActivity.b(this.a).setOnCheckedChangeListener(AuthDevActivity.a(this.a));
          AuthDevActivity.a(this.a);
          break;
          localObject = "1";
          break label212;
        }
      }
    } while (paramCompoundButton != AuthDevActivity.c(this.a).a());
    label212:
    label350:
    int i;
    label313:
    if (AuthDevActivity.c(this.a).a())
    {
      localObject = "1";
      bcst.b(null, "dc00898", "", "", "0X800AC53", "0X800AC53", 0, 0, (String)localObject, "", "", "");
      localObject = this.a.app;
      if (!paramBoolean) {
        break label484;
      }
      i = 1;
      bcst.b((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
      if (!paramBoolean) {
        break label489;
      }
      bcst.b(null, "dc00898", "", "", "0X800A721", "0X800A721", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      label389:
      SettingCloneUtil.writeValue(this.a, this.a.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
      this.a.app.q();
      break;
      localObject = "0";
      break label350;
      label484:
      i = 0;
      break label389;
      label489:
      bcst.b(null, "dc00898", "", "", "0X800A722", "0X800A722", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adns
 * JD-Core Version:    0.7.0.1
 */