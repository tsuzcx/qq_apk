import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aajb
  implements CompoundButton.OnCheckedChangeListener
{
  public aajb(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!bbfj.d(this.a.getActivity()))
    {
      AssistantSettingActivity.a(this.a, 2131694673, 1);
      paramCompoundButton = this.a;
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        AssistantSettingActivity.a(paramCompoundButton, paramBoolean, this);
        return;
      }
    }
    ((ajti)this.a.app.a(2)).q(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aajb
 * JD-Core Version:    0.7.0.1
 */