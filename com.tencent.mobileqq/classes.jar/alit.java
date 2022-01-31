import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils.1;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils.2;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class alit
{
  public static int a;
  public static long a;
  public static String a;
  public static ArrayList<Integer> a;
  public static JSONArray a;
  public static JSONObject a;
  public static boolean a;
  public static int b;
  public static ArrayList<Integer> b;
  public static JSONObject b;
  public static boolean b;
  public static ArrayList<Integer> c;
  public static JSONObject c;
  public static boolean c;
  public static ArrayList<Integer> d;
  public static JSONObject d;
  public static boolean d;
  public static JSONObject e;
  public static boolean e;
  private static JSONObject f;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Boolean = true;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return -2;
    }
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return 1;
    }
    paramString1 = paramString1.trim();
    paramString2 = paramString2.trim();
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    if ((paramString1.length <= 0) || (paramString2.length <= 0)) {
      return -2;
    }
    paramString1 = new ArrayList(Arrays.asList(paramString1));
    paramString2 = new ArrayList(Arrays.asList(paramString2));
    int i;
    int j;
    int k;
    for (;;)
    {
      try
      {
        i = paramString1.size() - 1;
        if ((i < 0) || (Integer.parseInt((String)paramString1.get(i)) != 0))
        {
          i = paramString2.size() - 1;
          if (i < 0) {
            break label317;
          }
          if (Integer.parseInt((String)paramString2.get(i)) != 0)
          {
            break label317;
            if (i >= paramString1.size()) {
              continue;
            }
            j = Integer.parseInt((String)paramString1.get(i));
            if (paramString2.size() >= i + 1) {
              continue;
            }
            return 1;
          }
        }
        else
        {
          paramString1.remove(i);
          i -= 1;
          continue;
        }
        paramString2.remove(i);
        i -= 1;
        continue;
        k = Integer.parseInt((String)paramString2.get(i));
        if (j <= k) {
          break;
        }
        return 1;
        i = paramString2.size();
        j = paramString1.size();
        if (i > j) {
          return -1;
        }
        return 0;
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloConfigUtils", 1, "compareVersion fail e:" + paramString1.toString());
        return -2;
      }
      label317:
      i = 0;
    }
    if (j == k) {}
    while (j >= k)
    {
      i += 1;
      break;
    }
    return -1;
  }
  
  protected static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("[client]", "androidQQ").replace("[version]", "8.3.5.4555").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramQQAppInterface = new JSONObject(paramString);
        if (!paramQQAppInterface.has("traceConfig")) {
          continue;
        }
        jdField_d_of_type_JavaUtilArrayList.clear();
        paramQQAppInterface = paramQQAppInterface.optJSONObject("traceConfig").optJSONArray("featureList");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length() <= 0)) {
          continue;
        }
        int i = 0;
        if (i >= paramQQAppInterface.length()) {
          continue;
        }
        paramString = paramQQAppInterface.optJSONObject(i);
        int k = paramString.optInt("featureId");
        if (paramString.optInt("isFocus") == 1) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
          }
          i += 1;
          break;
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloConfigUtils", 1, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        QLog.d("ApolloConfigUtils", 1, new Object[] { "parseUrlGrayConfigJson, isUpdate:", Boolean.valueOf(paramBoolean), ",content:", paramString });
        paramQQAppInterface = new JSONObject(paramString);
        if (paramQQAppInterface.has("grayUrlConfig"))
        {
          a(paramQQAppInterface.optJSONObject("grayUrlConfig"), paramBoolean);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloConfigUtils", 1, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      aliu.ah = a(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloConfigUtils", 2, "sApolloStoreUrl = " + aliu.ah);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApplication() == null) || (TextUtils.isEmpty(paramString))) {}
    Object localObject2;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      return;
      try
      {
        localObject2 = paramQQAppInterface.getApplication();
        localObject1 = new JSONObject(paramString);
        if (localObject1 != null)
        {
          paramString = ((JSONObject)localObject1).optString("apolloSwitch");
          bdne.k((Context)localObject2, Integer.parseInt(paramString));
          localObject3 = ((JSONObject)localObject1).optString("apollo3dSwitch");
          QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] apolloSwitch=", paramString, ", apollo3dSwitch=", localObject3 });
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label266;
          }
          bdne.l((Context)localObject2, Integer.parseInt((String)localObject3));
        }
      }
      catch (Exception paramString)
      {
        try
        {
          j = paramString.length;
          i = 0;
          while (i < j)
          {
            localObject3 = paramString[i];
            jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject3)));
            i += 1;
          }
          bdne.l((Context)localObject2, 0);
        }
        catch (Exception paramString)
        {
          QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] parse game id error, e=", paramString);
        }
        paramString = paramString;
        QLog.e("ApolloConfigUtils", 1, "aplloConfig parse json exception = " + paramString);
        return;
      }
    }
    if (((JSONObject)localObject1).has("default")) {}
    int i;
    int j;
    label266:
    for (paramString = ((JSONObject)localObject1).optJSONObject("default").optJSONObject("rules");; paramString = ((JSONObject)localObject1).optJSONObject("rules"))
    {
      jdField_a_of_type_OrgJsonJSONObject = paramString;
      if (!((JSONObject)localObject1).has("switchSet")) {
        break label847;
      }
      jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject1).optJSONObject("switchSet");
      if (jdField_b_of_type_OrgJsonJSONObject == null) {
        break label953;
      }
      paramString = jdField_b_of_type_OrgJsonJSONObject.optString("gameMenuBlackList");
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] gameMenuBlackListStr=", paramString });
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      paramString = paramString.split("\\|");
      if (paramString == null) {
        break;
      }
      i = paramString.length;
      if (i <= 0) {
        break;
      }
    }
    boolean bool;
    if (jdField_b_of_type_OrgJsonJSONObject.optInt("traceReportSwitch", 1) == 1)
    {
      bool = true;
      jdField_a_of_type_Boolean = bool;
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePreLoadEngineSwitch", 0) != 1) {
        break label788;
      }
      bool = true;
      label365:
      jdField_b_of_type_Boolean = bool;
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePipeLog", 0) != 1) {
        break label794;
      }
      bool = true;
      label387:
      ApolloEngine.a(bool);
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disableSettingMeDestroySwitch", 0) != 1) {
        break label800;
      }
      bool = true;
      label409:
      jdField_c_of_type_Boolean = bool;
      jdField_b_of_type_Int = jdField_b_of_type_OrgJsonJSONObject.optInt("disableSettingMeDestroyTimeOut", 0);
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePreLoadcm3DSwitch_V2") != 1) {
        break label806;
      }
      bool = true;
      label443:
      jdField_d_of_type_Boolean = bool;
      jdField_a_of_type_Long = jdField_b_of_type_OrgJsonJSONObject.optLong("gameConnHeartbeatInterval");
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("enableGL3_0", 1) != 1) {
        break label812;
      }
      bool = true;
      label477:
      jdField_e_of_type_Boolean = bool;
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disableCreateRenderThread", 0) != 1) {
        break label818;
      }
      bool = true;
      label499:
      aknx.q = bool;
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sGameConnHeartbeatInterval=", Long.valueOf(jdField_a_of_type_Long), ", sTraceReportSwitch:", Boolean.valueOf(jdField_a_of_type_Boolean), " sDisablePreLoadEngineSwitch:", Boolean.valueOf(jdField_b_of_type_Boolean), " sDisableDestroySettingmeSwitch:", Boolean.valueOf(jdField_c_of_type_Boolean), " sDisableDestroySettingmeTimeOut:", Integer.valueOf(jdField_b_of_type_Int), " sEnableOpenGL3_0:", Boolean.valueOf(jdField_e_of_type_Boolean) });
      long l = jdField_b_of_type_OrgJsonJSONObject.optLong("store_page_load_timeout_value");
      if (l <= 0L) {
        break label824;
      }
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
      paramString.putLong("SP_KEY_APOLLO_STORE_PAGE_LOAD_TIMEOUT_VALUE", l);
      paramString.apply();
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sStorePageLoadTimeoutValue=", Long.valueOf(l) });
    }
    for (;;)
    {
      for (;;)
      {
        paramString = jdField_b_of_type_OrgJsonJSONObject.optString("transparentGameList");
        QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] transparentGameListStr=", paramString });
        if (TextUtils.isEmpty(paramString)) {
          break label847;
        }
        paramString = paramString.split("\\|");
        if (paramString == null) {
          break label847;
        }
        i = paramString.length;
        if (i <= 0) {
          break label847;
        }
        try
        {
          j = paramString.length;
          i = 0;
          while (i < j)
          {
            localObject3 = paramString[i];
            jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject3)));
            i += 1;
          }
          bool = false;
        }
        catch (Exception paramString)
        {
          label788:
          label794:
          label800:
          label806:
          label812:
          label818:
          label824:
          QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] parse trans game id error, e=", paramString);
        }
      }
      bool = false;
      break label365;
      bool = false;
      break label387;
      bool = false;
      break label409;
      bool = false;
      break label443;
      bool = false;
      break label477;
      bool = false;
      break label499;
      QLog.d("ApolloConfigUtils", 1, "[parseConfigJson] sStorePageLoadTimeoutValue from config not > 0, use default value. ");
    }
    label847:
    if (((JSONObject)localObject1).has("errorAction"))
    {
      paramString = ((JSONObject)localObject1).optString("errorAction");
      if (!TextUtils.isEmpty(paramString))
      {
        localObject3 = paramString.split(",");
        if (localObject3 != null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < paramString.length())
      {
        jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt(localObject3[i])));
        if (!QLog.isColorLevel()) {
          break label1527;
        }
        QLog.d("ApolloConfigUtils", 2, "errorAction =" + localObject3[i]);
        break label1527;
        label953:
        QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] sSwitchSet null");
        break label847;
      }
      if (((JSONObject)localObject1).has("shopUrl"))
      {
        paramString = ((JSONObject)localObject1).optJSONArray("shopUrl");
        if (paramString != null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < paramString.length())
        {
          localObject3 = paramString.getJSONObject(i);
          if (!a("8.3.5", ((JSONObject)localObject3).optString("minVersion"), ((JSONObject)localObject3).optString("maxVersion"))) {
            break label1520;
          }
          localObject3 = ((JSONObject)localObject3).optString("url");
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label1520;
          }
          a((String)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloConfigUtils", 2, "localversion target.url=" + (String)localObject3);
          }
        }
        if (((JSONObject)localObject1).has("urlConfig")) {
          a(((JSONObject)localObject1).optJSONObject("urlConfig"), paramBoolean);
        }
        if (((JSONObject)localObject1).has("freqConfig"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("freqConfig");
          if (paramString != null)
          {
            i = paramString.optInt("drawerBubble", 3);
            j = paramString.optInt("aioBubble", 3);
            localObject2 = ((Context)localObject2).getSharedPreferences("apollo_sp", 0);
            ((SharedPreferences)localObject2).edit().putInt("bubble_max_count", i);
            ((SharedPreferences)localObject2).edit().putInt("sp_key_aio_bubble_max_count", j);
            ((SharedPreferences)localObject2).edit().commit();
            i = paramString.optInt("foregroundEvent") * 1000 * 60;
            if (nud.jdField_a_of_type_Int < i) {
              nud.jdField_a_of_type_Int = i;
            }
          }
        }
        if (((JSONObject)localObject1).has("avConfig"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("avConfig");
          if (localObject2 != null)
          {
            paramString = ((JSONObject)localObject2).optString("url");
            localObject2 = ((JSONObject)localObject2).optString("md5");
            if (!TextUtils.isEmpty(paramString)) {
              aliu.af = paramString;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              aliu.ag = (String)localObject2;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, "gameAVSOUrl =" + paramString + ", md5=" + (String)localObject2);
            }
          }
        }
        if (((JSONObject)localObject1).has("gameConfig"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("gameConfig");
          if ((paramString != null) && (paramString.has("aio")))
          {
            localObject3 = paramString.getJSONObject("aio");
            paramString = ((JSONObject)localObject3).optString("aioPanelTip");
            localObject1 = ((JSONObject)localObject3).optString("gamePanelTip");
            localObject2 = ((JSONObject)localObject3).optString("gamePanelBg");
            localObject3 = ((JSONObject)localObject3).optString("gamePanelBgColor");
            if (!TextUtils.isEmpty(paramString)) {
              aliu.aC = paramString;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              aliu.aD = (String)localObject1;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              aliu.aE = ((String)localObject2).trim();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              aliu.aF = ((String)localObject3).trim();
            }
          }
        }
        if (aknx.a.get()) {
          break;
        }
        paramString = (aknx)paramQQAppInterface.getManager(153);
        aknx.a.set(true);
        paramString.h();
        return;
        label1520:
        i += 1;
      }
      label1527:
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ("mall".equals(paramString1)) {
      a(paramString2);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return;
                                  if (!"interact".equals(paramString1)) {
                                    break;
                                  }
                                } while (TextUtils.isEmpty(paramString2));
                                aliu.ai = a(paramString2);
                              } while (!QLog.isColorLevel());
                              QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloStoreInteractUrl=", aliu.ai });
                              return;
                              if ("game_rank".equals(paramString1))
                              {
                                aliu.X = paramString2;
                                return;
                              }
                              if ("game_life".equals(paramString1))
                              {
                                aliu.Y = paramString2;
                                return;
                              }
                              if ("coin".equals(paramString1))
                              {
                                aliu.Z = paramString2;
                                return;
                              }
                              if ("my_card".equals(paramString1))
                              {
                                aliu.aa = paramString2;
                                return;
                              }
                              if ("crystal".equals(paramString1))
                              {
                                aliu.ac = paramString2;
                                return;
                              }
                              if ("production".equals(paramString1))
                              {
                                aliu.ad = paramString2;
                                return;
                              }
                              if ("game_manage".equals(paramString1))
                              {
                                aliu.ae = paramString2;
                                return;
                              }
                              if ("my_card_detail".equals(paramString1))
                              {
                                aliu.ab = paramString2;
                                return;
                              }
                              if (!"new_mall".equals(paramString1)) {
                                break;
                              }
                            } while (TextUtils.isEmpty(paramString2));
                            aliu.aj = a(paramString2);
                          } while (!QLog.isColorLevel());
                          QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewStoreUrl=", aliu.aj });
                          return;
                          if (!"game_center".equals(paramString1)) {
                            break;
                          }
                        } while (TextUtils.isEmpty(paramString2));
                        aliu.ak = a(paramString2);
                      } while (!QLog.isColorLevel());
                      QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCenterUrl=", aliu.ak });
                      return;
                      if (!"new_interact".equals(paramString1)) {
                        break;
                      }
                    } while (TextUtils.isEmpty(paramString2));
                    aliu.al = a(paramString2);
                  } while (!QLog.isColorLevel());
                  QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewInteractUrl=", aliu.al });
                  return;
                  if (!"game_city".equals(paramString1)) {
                    break;
                  }
                } while (TextUtils.isEmpty(paramString2));
                aliu.am = a(paramString2);
              } while (!QLog.isColorLevel());
              QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCityUrl=", aliu.am });
              return;
              if ("apollo_drawer_game_box_lottie".equals(paramString1))
              {
                aliu.ar = paramString2;
                return;
              }
              if (!"apollo_plus_url".equals(paramString1)) {
                break;
              }
            } while (TextUtils.isEmpty(paramString2));
            aliu.as = paramString2;
            return;
            if (!"3d_mall".equals(paramString1)) {
              break;
            }
          } while (TextUtils.isEmpty(paramString2));
          aliu.an = a(paramString2);
          return;
          if (!"3d_interact".equals(paramString1)) {
            break;
          }
        } while (TextUtils.isEmpty(paramString2));
        aliu.ao = a(paramString2);
        return;
        if (!"3d_game_city".equals(paramString1)) {
          break;
        }
      } while (TextUtils.isEmpty(paramString2));
      aliu.ap = a(paramString2);
      return;
    } while ((!"2d_3available_interact".equals(paramString1)) || (TextUtils.isEmpty(paramString2)));
    aliu.aq = a(paramString2);
  }
  
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray(paramString);
        if (paramJSONObject != null)
        {
          i = 0;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            if (!a("8.3.5", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion"))) {
              continue;
            }
            String str = localJSONObject.optString("androidUrl");
            paramJSONObject = str;
            if (TextUtils.isEmpty(str)) {
              paramJSONObject = localJSONObject.optString("url");
            }
            a(paramString, paramJSONObject);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, paramString + " localversion target.url=" + paramJSONObject);
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloConfigUtils", 2, paramString + " parse configUrl error e=" + paramJSONObject.toString());
      }
      i += 1;
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
        if (localJSONArray != null)
        {
          i = 0;
          localObject1 = "8.3.5";
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            String str1 = localJSONObject.optString("minVersion");
            String str2 = localJSONObject.optString("maxVersion");
            localObject3 = localJSONObject.optString("androidUrl");
            Object localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = localJSONObject.optString("url");
            }
            if (a("8.3.5", str1, str2))
            {
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                aliu.at = (String)localObject2;
                aliu.au = localJSONObject.optString("id");
                aliu.av = aliu.jdField_a_of_type_JavaLangString + "/script/" + aliu.au + "/";
                if (paramBoolean)
                {
                  localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
                  ((SharedPreferences)localObject3).edit().putString("sp_key_config_script", paramJSONObject.toString());
                  ((SharedPreferences)localObject3).edit().commit();
                }
              }
              localObject3 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloConfigUtils", 2, new Object[] { "parseBaseScriptConfig: localversion target.url=" + (String)localObject2, ",scriptId:", aliu.au, ",isUpdate:", Boolean.valueOf(paramBoolean) });
                localObject3 = localObject1;
              }
            }
            else
            {
              localObject3 = localObject1;
              if (a("8.3.5", str1) < 0)
              {
                localObject3 = localObject1;
                if (a((String)localObject1, str1) < 0)
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    aliu.aw = (String)localObject2;
                    aliu.ax = localJSONObject.optString("id");
                    aliu.ay = aliu.jdField_a_of_type_JavaLangString + "/script/" + aliu.ax + "/";
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloConfigUtils", 2, "parseBaseScriptConfig: newestMinVersion=" + str1 + " target.url=" + (String)localObject2 + ", id=" + aliu.ax);
                  }
                  localObject3 = str1;
                }
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.d("ApolloConfigUtils", 1, paramString + " parse configUrl error e=" + paramJSONObject.toString());
      }
      return;
      i += 1;
      Object localObject1 = localObject3;
    }
  }
  
  public static void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject != null)
    {
      a(paramJSONObject, "mall");
      a(paramJSONObject, "new_mall");
      a(paramJSONObject, "interact");
      a(paramJSONObject, "game_rank");
      a(paramJSONObject, "game_life");
      a(paramJSONObject, "coin");
      a(paramJSONObject, "my_card");
      a(paramJSONObject, "my_card_detail");
      a(paramJSONObject, "crystal");
      a(paramJSONObject, "production");
      a(paramJSONObject, "game_manage");
      a(paramJSONObject, "game_center");
      a(paramJSONObject, "new_interact");
      a(paramJSONObject, "game_city");
      a(paramJSONObject, "apollo_drawer_game_box_lottie");
      a(paramJSONObject, "apollo_plus_url");
      a(paramJSONObject, "3d_mall");
      a(paramJSONObject, "3d_interact");
      a(paramJSONObject, "3d_game_city");
      a(paramJSONObject, "2d_3available_interact");
      a(paramJSONObject, "base_script", paramBoolean);
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          if ((a(paramString1, paramString2) >= 0) && (a(paramString1, paramString3) <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, "localversion target. min=" + paramString2 + ",local =" + paramString1 + ",max=" + paramString3);
            }
            return true;
          }
        }
        catch (Throwable paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloConfigUtils", 2, paramString1.toString());
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloConfigUtils", 1, "parsePreDownloadConfig content is null");
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      JSONObject localJSONObject2;
      ApolloPreDownloadData localApolloPreDownloadData;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("preDownLoadRes");
        if (paramString == null) {
          break;
        }
        localHashMap = new HashMap();
        if (i >= paramString.length()) {
          break label367;
        }
        JSONObject localJSONObject1 = paramString.optJSONObject(i);
        localJSONObject2 = localJSONObject1.optJSONObject("android");
        if (localJSONObject2 == null) {
          break label394;
        }
        localApolloPreDownloadData = new ApolloPreDownloadData();
        localApolloPreDownloadData.reportId = localJSONObject1.optString("reportId");
        localApolloPreDownloadData.url = localJSONObject1.optString("url");
        if (TextUtils.isEmpty(localApolloPreDownloadData.url))
        {
          QLog.e("ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig url is null, reportId:", localApolloPreDownloadData.reportId });
        }
        else
        {
          localApolloPreDownloadData.resId = bhpp.b(localApolloPreDownloadData.url);
          localApolloPreDownloadData.md5 = localJSONObject1.optString("md5");
          localApolloPreDownloadData.version = localJSONObject1.optInt("version");
          localApolloPreDownloadData.minVer = localJSONObject1.optString("minQQVer");
          localApolloPreDownloadData.maxVer = localJSONObject1.optString("maxQQVer");
          localApolloPreDownloadData.endTime = localJSONObject1.optLong("endTime");
          if ((!TextUtils.isEmpty(localApolloPreDownloadData.minVer)) && (!TextUtils.isEmpty(localApolloPreDownloadData.maxVer)) && (!a("8.3.5", localApolloPreDownloadData.minVer, localApolloPreDownloadData.maxVer))) {
            QLog.e("ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig ver is not correct, url:", localApolloPreDownloadData.url });
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloConfigUtils", 1, "parsePreDownloadConfig e:", paramQQAppInterface);
        return;
      }
      localApolloPreDownloadData.dir = localJSONObject2.optString("dir");
      localApolloPreDownloadData.zipDir = localJSONObject2.optString("zipDir");
      localApolloPreDownloadData.dirType = localJSONObject2.optInt("dirType");
      localHashMap.put(localApolloPreDownloadData.resId, localApolloPreDownloadData);
      break label394;
      label367:
      if (localHashMap.size() <= 0) {
        break;
      }
      ThreadManager.excute(new ApolloConfigUtils.2(paramQQAppInterface, localHashMap), 160, null, true);
      return;
      label394:
      i += 1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloConfigUtils", 1, "parseGameConfigJson content is null");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        jdField_c_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("aioGameTab");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("moreGameConfig");
        jdField_d_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("gameAudioConfig");
        jdField_e_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("plusPanelGameConfig");
        jdField_a_of_type_OrgJsonJSONArray = localJSONObject1.optJSONArray("quickTipsConfig");
        akvj.a(jdField_a_of_type_OrgJsonJSONArray);
        jdField_a_of_type_Int = localJSONObject1.optInt("gameMinTimeOut");
        jdField_a_of_type_JavaLangString = localJSONObject1.optString("notFullScreenModelList");
        f = localJSONObject1.optJSONObject("textureViewConfig");
        aknx.a(f);
        if (paramBoolean)
        {
          QLog.e("ApolloConfigUtils", 1, "parseGameConfigJson online get update");
          ThreadManager.excute(new ApolloConfigUtils.1(paramQQAppInterface), 32, null, true);
        }
        if (localJSONObject2 != null)
        {
          akts.a("aio.enter.bg", localJSONObject2.optString("entranceBkgUrl"));
          paramString = localJSONObject2.optString("entranceUrl_Android_general");
          paramBoolean = ApolloGameUtil.a(paramQQAppInterface);
          if (paramBoolean)
          {
            paramString = localJSONObject2.optString("entranceUrl_Android");
            String str = localJSONObject2.optString("entranceUrl_Android_3d");
            if ((ApolloGameUtil.b(paramQQAppInterface)) && (!TextUtils.isEmpty(str))) {
              paramString = str;
            }
          }
          else
          {
            paramQQAppInterface = paramString;
            if (TextUtils.isEmpty(paramString)) {
              paramQQAppInterface = localJSONObject2.optString("entranceUrl");
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, new Object[] { "parseGameConfigJson enter:", paramQQAppInterface, ",isOpenCmShow:", Boolean.valueOf(paramBoolean) });
            }
            akts.a("aio.enter", paramQQAppInterface);
            akts.a("aio.enter.name", localJSONObject2.optString("entranceName"));
          }
        }
        else
        {
          paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("apollo_sp", 0).edit();
          if (localJSONObject1.has("freqConfig"))
          {
            paramString = localJSONObject1.optJSONObject("freqConfig");
            if (paramString != null) {
              paramQQAppInterface.putInt("sp_key_exit_game_guide_count_limit", paramString.optInt("exitGuideCount", 1));
            }
          }
          if (localJSONObject1.has("switchSet"))
          {
            paramString = localJSONObject1.optJSONObject("switchSet");
            if (paramString != null) {
              paramQQAppInterface.putInt("sp_key_exit_show_game_box_guide", paramString.optInt("gameBoxGuideSwitch"));
            }
          }
          paramQQAppInterface.apply();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloConfigUtils", 1, "Exception:", paramQQAppInterface);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alit
 * JD-Core Version:    0.7.0.1
 */