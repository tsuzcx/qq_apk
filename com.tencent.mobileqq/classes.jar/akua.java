import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_ICON.lighting_sweet_key_rsp;
import SWEET_NEW_ICON.sweet_upgrade_key_notify_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class akua
  implements BusinessObserver
{
  private static volatile akua jdField_a_of_type_Akua;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public static akua a()
  {
    if (jdField_a_of_type_Akua == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Akua == null) {
        jdField_a_of_type_Akua = new akua();
      }
      return jdField_a_of_type_Akua;
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (sweet_upgrade_key_notify_rsp)paramBundle.getSerializable("rsp_data");
    if ((paramBundle == null) || (!paramBoolean) || (paramBundle.req_comm == null))
    {
      QLog.i("QzoneLoverService", 1, "onGetLoverCheckData succed(false)");
      c();
    }
    Object localObject;
    long l;
    do
    {
      do
      {
        return;
        if ((paramBundle.rsp_comm == null) || (paramBundle.rsp_comm.retcode != 0))
        {
          localObject = new StringBuilder().append("onGetLoverCheckData succed(false), ret code: ");
          if (paramBundle.rsp_comm == null) {}
          for (paramBundle = "null";; paramBundle = String.valueOf(paramBundle.rsp_comm.retcode))
          {
            QLog.i("QzoneLoverService", 1, paramBundle);
            c();
            return;
          }
        }
        if (paramBundle.req_comm.uin != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())
        {
          QLog.i("QzoneLoverService", 1, "onGetLoverCheckData succed(" + paramBoolean + "), uin: " + paramBundle.req_comm.uin + ", loginUin: " + BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
          return;
        }
        b();
        l = paramBundle.req_comm.loveuin;
      } while (l <= 10000L);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    ((FriendListHandler)((QQAppInterface)localObject).a(1)).a(String.valueOf(l));
    QLog.i("QzoneLoverService", 1, "onGetLoverCheckData succed(" + paramBoolean + "), uin:" + paramBundle.req_comm.uin);
  }
  
  private void b()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).edit().putBoolean("checkQzoneLoverSend2", true).apply();
  }
  
  private void b(boolean paramBoolean, Bundle paramBundle)
  {
    this.b = false;
    paramBundle = (lighting_sweet_key_rsp)paramBundle.getSerializable("rsp_data");
    if ((paramBundle == null) || (!paramBoolean))
    {
      QLog.i("QzoneLoverService", 1, "onGetLoverLightingData succed(false)");
      e();
      return;
    }
    if ((paramBundle.rsp_comm == null) || (paramBundle.rsp_comm.retcode != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetLoverLightingData succed(false), ret code: ");
      if (paramBundle.rsp_comm == null) {}
      for (paramBundle = "null";; paramBundle = String.valueOf(paramBundle.rsp_comm.retcode))
      {
        QLog.i("QzoneLoverService", 1, paramBundle);
        e();
        return;
      }
    }
    d();
    QLog.i("QzoneLoverService", 1, "onGetLoverLightingData succed(" + paramBoolean + ")");
  }
  
  private boolean b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    if (System.currentTimeMillis() / 1000L / 3600L / 24L != localSharedPreferences.getLong("lightingQzoneLoverLastFailTime", 0L)) {}
    while (localSharedPreferences.getInt("lightingQzoneLoverFailCount", 0) < QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLoverMaxFailCount", 10)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (l != localSharedPreferences.getLong("checkQzoneLoverLastFailTime", 0L)) {
      localSharedPreferences.edit().putInt("checkQzoneLoverFailCount", 1);
    }
    for (;;)
    {
      localSharedPreferences.edit().putLong("checkQzoneLoverLastFailTime", l);
      localSharedPreferences.edit().apply();
      return;
      int i = localSharedPreferences.getInt("checkQzoneLoverFailCount", 0);
      localSharedPreferences.edit().putInt("checkQzoneLoverFailCount", i + 1);
    }
  }
  
  private void d()
  {
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).edit().putLong("lightingQzoneLoverTime", l).apply();
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    long l = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (l != localSharedPreferences.getLong("lightingQzoneLoverLastFailTime", 0L)) {
      localSharedPreferences.edit().putInt("lightingQzoneLoverFailCount", 1);
    }
    for (;;)
    {
      localSharedPreferences.edit().putLong("lightingQzoneLoverLastFailTime", l);
      localSharedPreferences.edit().apply();
      return;
      int i = localSharedPreferences.getInt("lightingQzoneLoverFailCount", 0);
      localSharedPreferences.edit().putInt("lightingQzoneLoverFailCount", i + 1);
    }
  }
  
  public void a()
  {
    if (this.b) {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest sending...");
      }
    }
    do
    {
      do
      {
        return;
        if (a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest false");
      return;
      if (!b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest fail count hit max count!!!");
    return;
    this.b = true;
    QLog.i("QzoneLoverService", 1, "startQzoneLoverLightingRequest true");
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), aktz.class);
    aktz.a(localNewIntent, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    if (!this.jdField_a_of_type_Boolean)
    {
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
      this.jdField_a_of_type_Boolean = true;
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public boolean a()
  {
    boolean bool = false;
    long l1 = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0).getLong("lightingQzoneLoverTime", 0L);
    long l2 = System.currentTimeMillis() / 1000L / 3600L / 24L;
    if (QLog.isColorLevel()) {
      QLog.i("QzoneLoverService", 2, "startQzoneLoverLightingRequest curDay(" + l2 + "), lastDay(" + l1 + ")");
    }
    if (l2 != l1) {
      bool = true;
    }
    return bool;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {
      a(paramBoolean, paramBundle);
    }
    while (paramInt != 291) {
      return;
    }
    b(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akua
 * JD-Core Version:    0.7.0.1
 */