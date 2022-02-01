import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advn
  implements CompoundButton.OnCheckedChangeListener
{
  public advn(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AssistantSettingActivity.a(this.a))
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (!bhnv.g(this.a))
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131694009, 0).b(this.a.getTitleBarHeight());
      localObject = this.a.e;
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        ((FormMultiLineSwitchItem)localObject).setChecked(bool);
        break;
      }
    }
    Object localObject = arms.c();
    label131:
    label212:
    label233:
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (((armr)localObject).a <= 1))
    {
      if (!biik.a(this.a.app, "have_show_ptt_tip", false))
      {
        QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box and tip to user");
        AssistantSettingActivity.a(this.a);
      }
      if ((!paramBoolean) && (((armr)localObject).a <= 1)) {
        biik.b(this.a.app, "have_add_ptt_gray_msg", false);
      }
      AssistantSettingActivity.a(this.a, paramBoolean);
      ((anum)this.a.app.a(2)).p(paramBoolean);
      if (!paramBoolean) {
        break label322;
      }
      bdll.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 1, 0, "", "", "", "");
      localObject = "normal";
      if (!VipUtils.c(this.a.app)) {
        break label349;
      }
      localObject = "vip";
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label369;
      }
    }
    label322:
    label349:
    label369:
    for (int i = 1;; i = 2)
    {
      bdll.b(localQQAppInterface, "dc00898", "", "", "", "0X800A415", i, 0, "", "", "", (String)localObject);
      break;
      if ((!paramBoolean) || (VipUtils.b(this.a.app))) {
        break label131;
      }
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box but u r not svip");
      AssistantSettingActivity.b(this.a);
      this.a.e.setChecked(false);
      break;
      bdll.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 2, 0, "", "", "", "");
      break label212;
      if (!VipUtils.b(this.a.app)) {
        break label233;
      }
      localObject = "svip";
      break label233;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advn
 * JD-Core Version:    0.7.0.1
 */