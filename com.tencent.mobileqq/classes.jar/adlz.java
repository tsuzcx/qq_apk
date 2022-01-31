import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class adlz
  implements CompoundButton.OnCheckedChangeListener
{
  public adlz(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, new Object[] { "avCallOnCheckedChangeListener::onCheckedChanged: invoked. ", " isChecked: ", Boolean.valueOf(paramBoolean) });
    }
    if (!NotifyPushSettingActivity.a(this.a).b())
    {
      NotifyPushSettingActivity.a(this.a).a(this.a);
      NotifyPushSettingActivity.a(this.a).setOnCheckedChangeListener(null);
      paramCompoundButton = NotifyPushSettingActivity.a(this.a);
      paramBoolean = bool;
      if (!NotifyPushSettingActivity.a(this.a).a()) {
        paramBoolean = true;
      }
      paramCompoundButton.setChecked(paramBoolean);
      NotifyPushSettingActivity.a(this.a).setOnCheckedChangeListener(this.a.a);
    }
    do
    {
      return;
      mti.a(this.a.app.getCurrentAccountUin(), paramBoolean);
      if (!paramBoolean) {
        azqs.b(this.a.app, "dc00898", "", "", "0X800A33D", "0X800A33D", 0, 0, "", "", "", "");
      }
    } while (!QLog.isColorLevel());
    QLog.d("IphoneTitleBarActivity", 2, "isChecked[" + paramBoolean + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlz
 * JD-Core Version:    0.7.0.1
 */