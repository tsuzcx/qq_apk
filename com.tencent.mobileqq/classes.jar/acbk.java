import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class acbk
  implements CompoundButton.OnCheckedChangeListener
{
  public acbk(AccountManageActivity paramAccountManageActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, this.a.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", paramBoolean);
    ((badd)this.a.app.getManager(61)).a(this.a.app);
    paramCompoundButton = this.a.app;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      azqs.b(paramCompoundButton, "dc00898", "", "", "0X800AC3A", "0X800AC3A", 0, 0, i + "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbk
 * JD-Core Version:    0.7.0.1
 */