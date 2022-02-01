import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adqj
  extends aqlq
{
  public adqj(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
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
    ChatSettingActivity.a(this.a, 2131690682, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqj
 * JD-Core Version:    0.7.0.1
 */