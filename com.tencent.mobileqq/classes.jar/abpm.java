import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.MultiImageTextView;
import java.util.concurrent.atomic.AtomicBoolean;

public class abpm
  implements CompoundButton.OnCheckedChangeListener
{
  public abpm(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int j = nam.a();
    int i = j;
    if (j == -1) {
      i = 2;
    }
    if (i == 0)
    {
      bcpw.a(this.a.getActivity(), 1, 2131696413, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
      paramCompoundButton = this.a;
      if (!paramBoolean) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        NotifyPushSettingActivity.a(paramCompoundButton, paramBoolean);
        return;
      }
    }
    if (NotifyPushSettingActivity.a(this.a).compareAndSet(true, true))
    {
      bcpw.a(this.a.getActivity(), 1, 2131698339, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
      paramCompoundButton = this.a;
      if (!paramBoolean) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        NotifyPushSettingActivity.a(paramCompoundButton, paramBoolean);
        return;
      }
    }
    NotifyPushSettingActivity.a(this.a, paramBoolean);
    if (paramBoolean)
    {
      paramCompoundButton = ajyc.a(2131707642) + abqi.a(3600000L);
      NotifyPushSettingActivity.a(this.a).setRightText(paramCompoundButton);
      NotifyPushSettingActivity.a(this.a).set(true);
      long l = NetConnInfoCenter.getServerTime();
      ((ajtk)this.a.app.a(2)).b((int)(3600L + l), "", "not_disturb_from_notify_push_setting_activity");
      axqw.b(this.a.app, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, 60L + "", "0", "", "");
      return;
    }
    paramCompoundButton = NotifyPushSettingActivity.a(this.a).a().getText().toString();
    NotifyPushSettingActivity.a(this.a).a().setText("");
    NotifyPushSettingActivity.a(this.a).set(true);
    ((ajtk)this.a.app.a(2)).b(0, paramCompoundButton, "not_disturb_from_notify_push_setting_activity");
    axqw.b(this.a.app, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 2, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpm
 * JD-Core Version:    0.7.0.1
 */