package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Queue;

public class QQBroadcastReceiver
  extends BroadcastReceiver
{
  public String getModuleId()
  {
    return null;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject6 = MobileQQ.sMobileQQ;
    long l = System.currentTimeMillis();
    if (paramIntent == null) {
      localObject1 = "";
    } else {
      localObject1 = paramIntent.toString();
    }
    Object localObject1 = Pair.create(Long.valueOf(l), localObject1);
    if ((localObject6 != null) && (((MobileQQ)localObject6).broadcastInfoQueue != null)) {
      if (((MobileQQ)localObject6).broadcastInfoQueue.size() < 5)
      {
        ((MobileQQ)localObject6).broadcastInfoQueue.offer(localObject1);
      }
      else
      {
        ((MobileQQ)localObject6).broadcastInfoQueue.poll();
        ((MobileQQ)localObject6).broadcastInfoQueue.offer(localObject1);
      }
    }
    ((MobileQQ)localObject6).onActivityCreate(this, paramIntent);
    if (!"Success".equals(MobileQQ.sInjectResult)) {
      return;
    }
    Object localObject5 = null;
    localObject1 = ((MobileQQ)localObject6).waitAppRuntime(null);
    if (localObject1 == null) {
      return;
    }
    Object localObject3 = getModuleId();
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = ((AppRuntime)localObject1).getAppRuntime((String)localObject3);
      localObject2 = localObject1;
      if (localObject3 != null) {
        localObject2 = localObject3;
      }
    }
    if (paramIntent != null)
    {
      int i = -1;
      try
      {
        localObject1 = paramIntent.getStringExtra("k_pcactive_uin");
        try
        {
          int j = paramIntent.getIntExtra("k_pcactive_retryIndex", -1);
          i = j;
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2)
      {
        localObject1 = null;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"0".equals(localObject1)))
      {
        QLog.d("QQBroadcastReceiver", 1, "PCActive:active qq process");
        ((MobileQQ)localObject6).isPCActive = true;
        ((MobileQQ)localObject6).reportPCActive((String)localObject1, i);
        if (!SettingCloneUtil.readValue((Context)localObject6, localObject2.getAccount(), null, "pcactive_has_notice", false)) {
          SettingCloneUtil.writeValue((Context)localObject6, localObject2.getAccount(), null, "pcactive_notice_key", true);
        }
        if (!localObject2.isLogin())
        {
          QLog.d("QQBroadcastReceiver", 1, "PCActive:Account is not login");
          localObject6 = localObject2.getApplication().getAllAccounts();
          Object localObject4 = localObject5;
          if (localObject6 != null) {
            localObject4 = (SimpleAccount)((List)localObject6).get(0);
          }
          if ((localObject4 != null) && (((String)localObject1).equals(((SimpleAccount)localObject4).getUin())) && (((SimpleAccount)localObject4).isLogined()))
          {
            QLog.d("QQBroadcastReceiver", 1, "PCActive:Show Notification");
            localObject2.login((SimpleAccount)localObject4);
            localObject4 = new Intent("com.tencent.mobileqq.closeNotification");
            ((Intent)localObject4).putExtra("uin", (String)localObject1);
            paramContext.sendBroadcast((Intent)localObject4);
          }
        }
      }
    }
    onReceive(localObject2, paramContext, paramIntent);
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.QQBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */