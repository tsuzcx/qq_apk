import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;

public class aaja
  implements CompoundButton.OnCheckedChangeListener
{
  public aaja(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    apzf.a(this.a.app).a(paramBoolean, this.a.app);
    if (paramBoolean)
    {
      axqy.b(this.a.app, "CliOper", "", "", "0X8008C75", "0X8008C75", 0, 0, "", "", "", "");
      return;
    }
    axqy.b(this.a.app, "CliOper", "", "", "0X8008C74", "0X8008C74", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaja
 * JD-Core Version:    0.7.0.1
 */