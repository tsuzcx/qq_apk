import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advd
  implements CompoundButton.OnCheckedChangeListener
{
  public advd(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!bhnv.d(BaseApplication.getContext()))
    {
      AssistantSettingActivity.a(this.a, 2131691989, 1);
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
      ((aqpc)this.a.app.getManager(380)).a(paramBoolean);
      bdll.b(this.a.app, "dc00898", "", "", "0X800B333", "0X800B333", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advd
 * JD-Core Version:    0.7.0.1
 */