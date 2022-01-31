import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class abst
  implements Runnable
{
  public abst(ConfigServlet paramConfigServlet, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    int n = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqConfigSplashlogoConfigServlet.getAppRuntime();
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)localQQAppInterface.getManager(124);
    HashSet localHashSet = new HashSet();
    int j = SharedPreUtils.Q(localQQAppInterface.getApp(), ConfigServlet.a);
    int i = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get();
    if (i != j) {
      if (i == j) {
        break label504;
      }
    }
    for (;;)
    {
      int m;
      if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.size() > 0))
      {
        int i1 = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.size();
        int k = 0;
        m = i;
        if (k < i1)
        {
          Object localObject1 = (String)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.content_list.get(k);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 56,content: " + (String)localObject1 + ",version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
          for (;;)
          {
            k += 1;
            break;
            try
            {
              localObject1 = new JSONObject((String)localObject1);
              Iterator localIterator = ((JSONObject)localObject1).keys();
              while (localIterator.hasNext())
              {
                Object localObject2 = (String)localIterator.next();
                if ("passwordPlaceholder".equals(localObject2))
                {
                  localObject2 = ((JSONObject)localObject1).optJSONArray((String)localObject2);
                  if (localObject2 != null)
                  {
                    int i2 = ((JSONArray)localObject2).length();
                    m = 0;
                    while (m < i2)
                    {
                      String str = ((JSONArray)localObject2).optString(m);
                      if ((!TextUtils.isEmpty(str)) && (!localHashSet.contains(str))) {
                        localHashSet.add(str);
                      }
                      m += 1;
                    }
                  }
                }
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (Exception localException2) {}
            QLog.e("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG error", localException2);
          }
        }
      }
      else
      {
        m = i;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 56,content_list is empty ,version: " + this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get());
          m = i;
        }
      }
      if (m != j) {}
      for (;;)
      {
        try
        {
          SharedPreUtils.s(localQQAppInterface.getApp(), ConfigServlet.a, m);
          localPasswdRedBagManager.a(localHashSet);
          i = 1;
        }
        catch (Exception localException1)
        {
          i = n;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG error", localException1);
          i = n;
          continue;
        }
        if (i == 0) {
          localPasswdRedBagManager.f();
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG remote version: " + i + " | localVersion: " + j);
        }
        m = j;
        break;
        i = 0;
      }
      label504:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abst
 * JD-Core Version:    0.7.0.1
 */