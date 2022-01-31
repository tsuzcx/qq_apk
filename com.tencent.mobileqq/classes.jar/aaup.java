import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppEnvConfig;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.qphone.base.util.BaseApplication;

public class aaup
  implements Runnable
{
  public aaup(ArkLocalAppMgr paramArkLocalAppMgr, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("ArkLocalAppUpdateTime", 0);
    long l1 = ((SharedPreferences)localObject).getLong("PredownloadAppUpdateTime", 0L);
    long l2 = (System.currentTimeMillis() - l1) / 1000L / 60L;
    if ((l2 < 1020L) && (!ArkLocalAppMgr.a())) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("PredownloadAppUpdateTime", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).commit();
    ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("updatePredownloadAppList, delta=%d, lastUpdateTime=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
    if (1 != ArkAppEnvConfig.a().a()) {}
    for (localObject = "http://cdn.ark.qq.com/arkapp/app_config.json";; localObject = "http://test.ark.qq.com/arkapp/app_config.json")
    {
      ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120);
      localArkAppCenter.a().a((String)localObject, null, new aauq(this));
      localArkAppCenter.a().a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaup
 * JD-Core Version:    0.7.0.1
 */