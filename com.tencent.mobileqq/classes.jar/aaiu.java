import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aaiu
  implements CompoundButton.OnCheckedChangeListener
{
  public aaiu(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    label43:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i = 1;
      bhvy.e(i);
      bhvy.a(paramBoolean);
      bhvy.a(true);
      if (!paramBoolean) {
        break label98;
      }
      bcql.a(this.a.getBaseContext(), 2, 2131718582, 2000).a();
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label121;
      }
      paramCompoundButton = "0X8008236";
      label59:
      if (!paramBoolean) {
        break label127;
      }
    }
    label98:
    label121:
    label127:
    for (String str = "0X8008236";; str = "0X8008235")
    {
      nol.a(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "", "", "", "", false);
      return;
      i = 0;
      break;
      bcql.a(this.a.getBaseContext(), 2, 2131718580, 2000).a();
      break label43;
      paramCompoundButton = "0X8008235";
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaiu
 * JD-Core Version:    0.7.0.1
 */