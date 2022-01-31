import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class abzu
  implements CompoundButton.OnCheckedChangeListener
{
  public abzu(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    label43:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i = 1;
      bjxj.e(i);
      bjxj.a(paramBoolean);
      bjxj.a(true);
      if (!paramBoolean) {
        break label98;
      }
      QQToast.a(this.a.getBaseContext(), 2, 2131719039, 2000).a();
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
      nrt.a(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "", "", "", "", false);
      return;
      i = 0;
      break;
      QQToast.a(this.a.getBaseContext(), 2, 2131719037, 2000).a();
      break label43;
      paramCompoundButton = "0X8008235";
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzu
 * JD-Core Version:    0.7.0.1
 */