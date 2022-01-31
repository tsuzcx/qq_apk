import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acao
  implements CompoundButton.OnCheckedChangeListener
{
  public acao(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    if (!paramCompoundButton.isPressed()) {
      return;
    }
    if (paramBoolean)
    {
      paramCompoundButton = "open_storyset";
      wta.a("dynamic_more", paramCompoundButton, 0, 0, new String[0]);
      paramCompoundButton = new Integer[5];
      paramCompoundButton[0] = Integer.valueOf(1);
      if (!paramBoolean) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      paramCompoundButton[3] = Integer.valueOf(i);
      this.a.app.a().a(paramCompoundButton);
      paramCompoundButton = (uhk)this.a.app.a(98);
      i = j;
      if (paramBoolean) {
        i = 2;
      }
      paramCompoundButton.a(i);
      return;
      paramCompoundButton = "close_storyset";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acao
 * JD-Core Version:    0.7.0.1
 */