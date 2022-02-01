import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adiq
  implements CompoundButton.OnCheckedChangeListener
{
  public adiq(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!NetworkUtil.isNetSupport(this.a))
    {
      AssistantSettingActivity.a(this.a, 2131694302, 1);
      localObject = this.a;
      if (!paramBoolean) {
        bool = true;
      }
      AssistantSettingActivity.b((AssistantSettingActivity)localObject, bool);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X800A5D5", "0X800A5D5", 0, 0, (String)localObject, "", "", "");
      this.a.a.b(paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adiq
 * JD-Core Version:    0.7.0.1
 */