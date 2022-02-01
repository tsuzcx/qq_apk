import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advi
  implements CompoundButton.OnCheckedChangeListener
{
  public advi(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!bhnv.d(this.a))
    {
      AssistantSettingActivity.a(this.a, 2131694005, 1);
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
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X800A5D5", "0X800A5D5", 0, 0, (String)localObject, "", "", "");
      this.a.a.b(paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advi
 * JD-Core Version:    0.7.0.1
 */