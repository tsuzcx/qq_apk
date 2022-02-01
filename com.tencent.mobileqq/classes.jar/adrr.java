import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adrr
  implements CompoundButton.OnCheckedChangeListener
{
  public adrr(AccountManageActivity paramAccountManageActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, this.a.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", paramBoolean);
    ((bdxc)this.a.app.getManager(61)).a(this.a.app);
    QQAppInterface localQQAppInterface = this.a.app;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X800AC3A", "0X800AC3A", 0, 0, i + "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrr
 * JD-Core Version:    0.7.0.1
 */