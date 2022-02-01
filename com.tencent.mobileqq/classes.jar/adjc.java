import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adjc
  implements CompoundButton.OnCheckedChangeListener
{
  public adjc(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AssistantSettingActivity.a(this.a))
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.a(BaseApplication.getContext(), 1, 2131694306, 0).b(this.a.getTitleBarHeight());
      localObject = this.a.e;
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        ((FormMultiLineSwitchItem)localObject).setChecked(bool);
        break;
      }
    }
    Object localObject = arjw.c();
    label131:
    label214:
    label235:
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (((arjv)localObject).a <= 1))
    {
      if (!bhzf.a(this.a.app, "have_show_ptt_tip", false))
      {
        QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box and tip to user");
        AssistantSettingActivity.b(this.a);
      }
      if ((!paramBoolean) && (((arjv)localObject).a <= 1)) {
        bhzf.b(this.a.app, "have_add_ptt_gray_msg", false);
      }
      AssistantSettingActivity.a(this.a, paramBoolean);
      ((anri)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).p(paramBoolean);
      if (!paramBoolean) {
        break label324;
      }
      bdla.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 1, 0, "", "", "", "");
      localObject = "normal";
      if (!VipUtils.c(this.a.app)) {
        break label351;
      }
      localObject = "vip";
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label371;
      }
    }
    label324:
    label351:
    label371:
    for (int i = 1;; i = 2)
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "", "0X800A415", i, 0, "", "", "", (String)localObject);
      break;
      if ((!paramBoolean) || (VipUtils.b(this.a.app))) {
        break label131;
      }
      QLog.e("vip_ptt.AssistantSettingActivity", 1, "open the ptt check box but u r not svip");
      AssistantSettingActivity.c(this.a);
      this.a.e.setChecked(false);
      break;
      bdla.b(null, "dc00898", "", "", "0X8009DF4", "0X8009DF4", 2, 0, "", "", "", "");
      break label214;
      if (!VipUtils.b(this.a.app)) {
        break label235;
      }
      localObject = "svip";
      break label235;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjc
 * JD-Core Version:    0.7.0.1
 */