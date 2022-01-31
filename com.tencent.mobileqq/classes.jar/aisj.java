import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aisj
  extends BroadcastReceiver
{
  aisj(airz paramairz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.e("ApolloManager", 1, "[onReceive] intent null");
    }
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "[onReceive] action=", paramContext });
      }
    } while (!"com.tencent.mobileqq.action.ACTION_APOLLO_STORE_CRASH_EVENT".equals(paramContext));
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).getString("apollo_store_watch_current_url", "");
    ((bbqp)this.a.a.a(71)).a(null, paramContext, -1003, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisj
 * JD-Core Version:    0.7.0.1
 */