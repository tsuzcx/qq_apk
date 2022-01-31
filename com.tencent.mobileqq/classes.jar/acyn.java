import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class acyn
  implements CompoundButton.OnCheckedChangeListener
{
  public acyn(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      azmj.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Enter_sendmsg", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131695435), "qqsetting_enter_sendmsg_key", paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyn
 * JD-Core Version:    0.7.0.1
 */