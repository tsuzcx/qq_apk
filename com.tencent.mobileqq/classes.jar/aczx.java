import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class aczx
  extends apim
{
  public aczx(ChatSettingActivity paramChatSettingActivity) {}
  
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
    ChatSettingActivity.a(this.a, 2131690605, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczx
 * JD-Core Version:    0.7.0.1
 */