import Wallet.ReqWalletConfig;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ajyg
  implements Manager
{
  private int jdField_a_of_type_Int = -1;
  private volatile long jdField_a_of_type_Long = -1L;
  private final QWalletConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ajyg(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "QWalletConfigManager init");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig = QWalletConfig.readConfig(paramQQAppInterface);
  }
  
  private void a(long paramLong, ajyj paramajyj, String paramString, Map<String, String> paramMap)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.seriesNo = 0L;
      QLog.i("QWalletConfigManager", 2, "replace install:" + AppSetting.a());
    }
    long l1;
    if (paramLong == 0L)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.seriesNo;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label191;
      }
    }
    label191:
    for (long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();; l2 = 0L)
    {
      ReqWalletConfig localReqWalletConfig = ReqWalletConfig.createReq(paramLong, l2, l1, paramString, paramMap);
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "realGetConfig:" + paramLong + "|" + paramajyj + "|" + paramString + "|" + paramMap + "|" + localReqWalletConfig);
      }
      ajvh.a(localReqWalletConfig, new ajyh(this, paramLong, paramajyj, new WeakReference(this)), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void a(String paramString, ajyk paramajyk)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((ajyg)localAppRuntime.getManager(245)).c(paramString, paramajyk);
      return;
    }
    akfu.a(paramString, paramajyk);
  }
  
  public static void b(String paramString, ajyk paramajyk)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((ajyg)localAppRuntime.getManager(245)).d(paramString, paramajyk);
      return;
    }
    akfu.b(paramString, paramajyk);
  }
  
  public int a(String paramString, int paramInt, String... paramVarArgs)
  {
    return ajyd.a(a(paramString), paramInt, paramVarArgs);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.lastReqTime;
  }
  
  public ajye a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.getConfigInfo(paramString);
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.getConfig(paramString);
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = a(paramString1);
    paramString1 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      paramString1 = localObject1;
      if (localObject2 != null)
      {
        paramString1 = localObject1;
        if (((JSONObject)localObject2).has(paramString2)) {
          paramString1 = ((JSONObject)localObject2).optString(paramString2);
        }
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2, String... paramVarArgs)
  {
    return ajyd.a(a(paramString1), paramString2, paramVarArgs);
  }
  
  public JSONArray a(String paramString, String... paramVarArgs)
  {
    return ajyd.a(a(paramString), paramVarArgs);
  }
  
  public JSONObject a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.getParsedConfig(paramString);
    if ((paramString instanceof JSONObject)) {
      return (JSONObject)paramString;
    }
    return null;
  }
  
  public JSONObject a(String paramString, String... paramVarArgs)
  {
    return ajyd.a(a(paramString), paramVarArgs);
  }
  
  public void a()
  {
    ThreadManager.executeOnSubThread(new QWalletConfigManager.1(this, new WeakReference(this)));
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.getValidReqOcca(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "tryGetConfig:" + paramInt + "|" + i + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig);
    }
    if (i != -1)
    {
      if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) <= 60000L) {
        break label90;
      }
      b(i);
    }
    label90:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QWalletConfigManager", 2, "tryGetConfig too frequently to req");
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "setConfig params is null");
      }
    }
    do
    {
      return;
      paramMap = ReqWalletConfig.createReq(0L, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.seriesNo, null, paramMap);
      ajvh.a(paramMap, 1, new ajyi(this));
    } while (!QLog.isColorLevel());
    QLog.d("QWalletConfigManager", 2, "setConfig:" + paramMap);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.isVersionUpdate();
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = a("pub_acc", "pay_puin_list");
      bool1 = bool2;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      bool1 = bool2;
      int i;
      if (localObject != null) {
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < ((JSONArray)localObject).length())
        {
          bool1 = paramString.equals("" + ((JSONArray)localObject).get(i));
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_when", paramInt + "");
    try
    {
      String str = ((akcq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(273)).a();
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put("redPoint", str);
      }
      a(0L, null, null, localHashMap);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void c(String paramString, ajyk paramajyk)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.addUpdateListener(paramString, paramajyk);
  }
  
  public void d(String paramString, ajyk paramajyk)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.removeUpdateListener(paramString, paramajyk);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyg
 * JD-Core Version:    0.7.0.1
 */