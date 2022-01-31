import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aajf
  implements CompoundButton.OnCheckedChangeListener
{
  public aajf(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AssistantSettingActivity.a(this.a)) {
      return;
    }
    if (!bbfj.g(this.a))
    {
      bcql.a(BaseApplication.getContext(), 1, 2131694674, 0).b(this.a.getTitleBarHeight());
      paramCompoundButton = this.a.e;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        return;
      }
    }
    paramCompoundButton = amzc.c();
    label194:
    label213:
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (paramCompoundButton.a <= 1))
    {
      if (!bbxj.a(this.a.app, "have_show_ptt_tip", false))
      {
        QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box and tip to user");
        AssistantSettingActivity.a(this.a);
      }
      if ((!paramBoolean) && (paramCompoundButton.a <= 1)) {
        bbxj.b(this.a.app, "have_add_ptt_gray_msg", false);
      }
      AssistantSettingActivity.a(this.a, paramBoolean);
      ((ajti)this.a.app.a(2)).p(paramBoolean);
      if (!paramBoolean) {
        break label297;
      }
      axqy.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 1, 0, "", "", "", "");
      paramCompoundButton = "normal";
      if (!VipUtils.c(this.a.app)) {
        break label324;
      }
      paramCompoundButton = "vip";
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label343;
      }
    }
    label297:
    label324:
    label343:
    for (int i = 1;; i = 2)
    {
      axqy.b(localQQAppInterface, "dc00898", "", "", "", "0X800A415", i, 0, "", "", "", paramCompoundButton);
      return;
      if ((!paramBoolean) || (VipUtils.b(this.a.app))) {
        break;
      }
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box but u r not svip");
      AssistantSettingActivity.b(this.a);
      this.a.e.setChecked(false);
      return;
      axqy.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 2, 0, "", "", "", "");
      break label194;
      if (!VipUtils.b(this.a.app)) {
        break label213;
      }
      paramCompoundButton = "svip";
      break label213;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aajf
 * JD-Core Version:    0.7.0.1
 */