import Wallet.ReqWalletConfig;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class aktz
  implements Manager
{
  private int jdField_a_of_type_Int = -1;
  private volatile long jdField_a_of_type_Long = -1L;
  private final QWalletConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aktz(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "QWalletConfigManager init");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig = QWalletConfig.readConfig(paramQQAppInterface);
  }
  
  private void a(long paramLong, akuc paramakuc, String paramString, Map<String, String> paramMap)
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
        QLog.d("QWalletConfigManager", 2, "realGetConfig:" + paramLong + "|" + paramakuc + "|" + paramString + "|" + paramMap + "|" + localReqWalletConfig);
      }
      akra.a(localReqWalletConfig, new akua(this, paramLong, paramakuc, new WeakReference(this)), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public static void a(String paramString, akud paramakud)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((aktz)localAppRuntime.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER)).c(paramString, paramakud);
      return;
    }
    albn.a(paramString, paramakud);
  }
  
  public static void b(String paramString, akud paramakud)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((aktz)localAppRuntime.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER)).d(paramString, paramakud);
      return;
    }
    albn.b(paramString, paramakud);
  }
  
  public int a(String paramString, int paramInt, String... paramVarArgs)
  {
    return aktw.a(a(paramString), paramInt, paramVarArgs);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.lastReqTime;
  }
  
  public aktx a(String paramString)
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
    return aktw.a(a(paramString1), paramString2, paramVarArgs);
  }
  
  public JSONArray a(String paramString, String... paramVarArgs)
  {
    return aktw.a(a(paramString), paramVarArgs);
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
    return aktw.a(a(paramString), paramVarArgs);
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
      akra.a(paramMap, 1, new akub(this));
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
      String str = ((akyj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_RED_MANAGER)).a();
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
  
  public void c(String paramString, akud paramakud)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.addUpdateListener(paramString, paramakud);
  }
  
  public void d(String paramString, akud paramakud)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.removeUpdateListener(paramString, paramakud);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfig.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktz
 * JD-Core Version:    0.7.0.1
 */