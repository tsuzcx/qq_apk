import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acsa
  implements CompoundButton.OnCheckedChangeListener
{
  public acsa(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      AssistantSettingActivity.a(this.a, 2131692035, 1);
      this.a.f.setOnCheckedChangeListener(null);
      FormSwitchItem localFormSwitchItem = this.a.f;
      if (!paramCompoundButton.isChecked()) {
        bool = true;
      }
      localFormSwitchItem.setChecked(bool);
      this.a.f.setOnCheckedChangeListener(this);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ((apil)this.a.app.getManager(380)).a(paramBoolean);
      bcef.b(this.a.app, "dc00898", "", "", "0X800B333", "0X800B333", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsa
 * JD-Core Version:    0.7.0.1
 */