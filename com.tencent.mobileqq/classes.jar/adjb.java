import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adjb
  extends aqlq
{
  public adjb(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.a.f != null) && (paramBoolean2 != this.a.f.a()))
      {
        this.a.f.setOnCheckedChangeListener(null);
        this.a.f.setChecked(paramBoolean2);
        this.a.f.setOnCheckedChangeListener(this.a);
      }
      return;
    }
    AssistantSettingActivity.a(this.a, 2131690682, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjb
 * JD-Core Version:    0.7.0.1
 */