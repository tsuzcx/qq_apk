import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class admb
  implements CompoundButton.OnCheckedChangeListener
{
  public admb(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!bgnt.d(this.a.getActivity()))
    {
      AssistantSettingActivity.a(this.a, 2131693991, 1);
      AssistantSettingActivity localAssistantSettingActivity = this.a;
      if (!paramBoolean) {
        AssistantSettingActivity.a(localAssistantSettingActivity, bool, this);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((anip)this.a.app.a(2)).q(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admb
 * JD-Core Version:    0.7.0.1
 */