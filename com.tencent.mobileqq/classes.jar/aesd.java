import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aesd
  implements CompoundButton.OnCheckedChangeListener
{
  public aesd(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Enter_sendmsg", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131694428), "qqsetting_enter_sendmsg_key", paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesd
 * JD-Core Version:    0.7.0.1
 */