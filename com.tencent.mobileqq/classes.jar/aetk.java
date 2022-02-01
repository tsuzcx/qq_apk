import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aetk
  extends BroadcastReceiver
{
  public aetk(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        localObject = paramIntent.getAction();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.equals((CharSequence)localObject, "mqq.intent.action.DEVLOCK_ROAM")));
      if (paramContext != null) {
        paramContext.unregisterReceiver(this);
      }
      Object localObject = asfl.a();
      if (paramIntent.getIntExtra("guardphone_state", asfl.d) == asfl.c)
      {
        paramIntent = paramIntent.getStringExtra("guardphone_mask");
        paramContext = paramIntent;
        if (paramIntent == null) {
          paramContext = "";
        }
        QLog.i("IphoneTitleBarActivity", 1, "mDevlockBroadcastReceiver, showAlertDialog");
        ((asfl)localObject).a(this.a, paramContext);
        return;
      }
      this.a.jdField_a_of_type_Ajby.a = true;
      QLog.i("IphoneTitleBarActivity", 1, "mDevlockBroadcastReceiver, refreshServerData");
    } while ((anus)this.a.app.a(34) == null);
    this.a.app.addObserver(this.a.jdField_a_of_type_Anut);
    this.a.a(4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetk
 * JD-Core Version:    0.7.0.1
 */