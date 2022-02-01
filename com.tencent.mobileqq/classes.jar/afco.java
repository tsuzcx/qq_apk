import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.qphone.base.util.QLog;

public class afco
  extends BroadcastReceiver
{
  public afco(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("PhoneUnityBindInfoActivity", 1, "bindMiBaoReceiver onReceive");
    if (PhoneUnityBindInfoActivity.a(this.a) == 1) {
      bdll.b(this.a.app, "dc00898", "", "", "0X800B316", "0X800B316", 0, 0, "", "", "", "");
    }
    while (PhoneUnityBindInfoActivity.a(this.a) != 2) {
      return;
    }
    bdll.b(this.a.app, "dc00898", "", "", "0X800B326", "0X800B326", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afco
 * JD-Core Version:    0.7.0.1
 */