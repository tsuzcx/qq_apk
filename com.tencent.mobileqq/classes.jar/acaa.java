import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;

public class acaa
  implements CompoundButton.OnCheckedChangeListener
{
  public acaa(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    arsh.a(this.a.app).a(paramBoolean, this.a.app);
    if (paramBoolean)
    {
      azmj.b(this.a.app, "CliOper", "", "", "0X8008C75", "0X8008C75", 0, 0, "", "", "", "");
      return;
    }
    azmj.b(this.a.app, "CliOper", "", "", "0X8008C74", "0X8008C74", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acaa
 * JD-Core Version:    0.7.0.1
 */