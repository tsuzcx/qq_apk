import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.armap.ShopScanActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class aaww
  extends QQBroadcastReceiver
{
  public aaww(ShopScanActivity paramShopScanActivity) {}
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramAppRuntime = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ShopScanActivity", 2, new Object[] { "onReceive, action=", paramAppRuntime });
      }
    } while (!"com.tencent.mobileqq__alive".equals(paramAppRuntime));
    ShopScanActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaww
 * JD-Core Version:    0.7.0.1
 */