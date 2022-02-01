import Wallet.AcsMsg;
import android.app.AlarmManager;
import android.app.AlarmManager.AlarmClockInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderAlarmReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class agdg
  implements Manager
{
  private AlarmManager jdField_a_of_type_AndroidAppAlarmManager;
  private Context jdField_a_of_type_AndroidContentContext;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ReminderAlarmReceiver jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CopyOnWriteArraySet<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet;
  
  public agdg(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "ActivateFriends.Manager--onCreate---");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("pref_act_frd" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    this.jdField_a_of_type_AndroidAppAlarmManager = ((AlarmManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("alarm"));
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver = new ReminderAlarmReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("notification_alram_action");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver, localIntentFilter);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver != null) {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizReminderAlarmReceiver);
    }
  }
  
  public void a()
  {
    try
    {
      if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getStringSet("sp_key_alarmids" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new HashSet()).isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
        while (localIterator.hasNext()) {
          a(Integer.parseInt((String)localIterator.next()));
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet == null) {
        break label136;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ActivateFriends.Manager", 2, "clearAllAlarm throw an exception: " + localException);
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
    }
    label136:
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("sp_key_alarmids" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).apply();
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "cancelAlarmById alarmId: " + paramInt);
      }
      Object localObject = String.valueOf(paramInt);
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(localObject)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localObject);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putStringSet("sp_key_alarmids" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).apply();
      localObject = new Intent();
      ((Intent)localObject).setAction("notification_alram_action");
      localObject = PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidContentContext, paramInt, (Intent)localObject, 0);
      this.jdField_a_of_type_AndroidAppAlarmManager.cancel((PendingIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ActivateFriends.Manager", 2, "cancelAlarmById throw an exceptio: " + localThrowable);
    }
  }
  
  public void a(AcsMsg paramAcsMsg)
  {
    if ((paramAcsMsg == null) || (paramAcsMsg.type == 1)) {}
    long l;
    label292:
    label352:
    do
    {
      Object localObject1;
      do
      {
        for (;;)
        {
          return;
          try
          {
            l = paramAcsMsg.notice_time * 1000L;
            int i = paramAcsMsg.msg_id.hashCode();
            localObject1 = paramAcsMsg.title;
            if (l <= NetConnInfoCenter.getServerTimeMillis()) {
              break label352;
            }
            Object localObject2 = String.valueOf(i);
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.Manager", 2, "setAlarmTimer at " + agce.a(l, "yyyyMMdd HH:mm:ss") + " msg: " + (String)localObject1 + " alarmId: " + i);
            }
            if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(localObject2))
            {
              this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localObject2);
              this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putStringSet("sp_key_alarmids" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).apply();
            }
            localObject2 = new Intent();
            ((Intent)localObject2).setAction("notification_alram_action");
            ((Intent)localObject2).putExtra("msg", (String)localObject1);
            ((Intent)localObject2).putExtra("msg_id", agci.a(paramAcsMsg));
            paramAcsMsg = PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidContentContext, i, (Intent)localObject2, 0);
            if (this.jdField_a_of_type_AndroidAppAlarmManager != null)
            {
              if (Build.VERSION.SDK_INT < 23) {
                break label292;
              }
              this.jdField_a_of_type_AndroidAppAlarmManager.setExactAndAllowWhileIdle(0, l, paramAcsMsg);
              return;
            }
          }
          catch (Throwable paramAcsMsg) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("ActivateFriends.Manager", 2, "setAlarmTimer throw an exceptio: " + paramAcsMsg);
      return;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject1 = new AlarmManager.AlarmClockInfo(l, paramAcsMsg);
        this.jdField_a_of_type_AndroidAppAlarmManager.setAlarmClock((AlarmManager.AlarmClockInfo)localObject1, paramAcsMsg);
        return;
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.jdField_a_of_type_AndroidAppAlarmManager.setExact(0, l, paramAcsMsg);
        return;
      }
      this.jdField_a_of_type_AndroidAppAlarmManager.set(0, l, paramAcsMsg);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ActivateFriends.Manager", 2, "has already setAlarmTimer at " + agce.a(l, "yyyyMMdd HH:mm:ss"));
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "ActivateFriends.Manager--onDestroy---");
    }
    c();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdg
 * JD-Core Version:    0.7.0.1
 */