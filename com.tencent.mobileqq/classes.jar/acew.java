import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acew
  implements CompoundButton.OnCheckedChangeListener
{
  public acew(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (!bdin.d(this.a))
    {
      AssistantSettingActivity.a(this.a, 2131694829, 1);
      paramCompoundButton = this.a;
      if (!paramBoolean) {
        bool = true;
      }
      AssistantSettingActivity.b(paramCompoundButton, bool);
      return;
    }
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (paramCompoundButton = "1";; paramCompoundButton = "2")
    {
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X800A5D5", "0X800A5D5", 0, 0, paramCompoundButton, "", "", "");
      this.a.a.b(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acew
 * JD-Core Version:    0.7.0.1
 */