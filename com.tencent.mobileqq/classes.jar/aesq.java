import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class aesq
  extends BroadcastReceiver
{
  public aesq(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSetting2Activity", 1, "bindMiBaoReceiver onReceive mIsBindMb：" + QQSettingSettingActivity.a(this.a));
    }
    if (QQSettingSettingActivity.a(this.a)) {
      bdla.b(this.a.app, "dc00898", "", "", "0X800B312", "0X800B312", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesq
 * JD-Core Version:    0.7.0.1
 */