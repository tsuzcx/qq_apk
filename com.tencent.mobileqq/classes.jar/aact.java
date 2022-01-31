import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class aact
{
  public static LruCache<String, List<String>> a;
  public static String a;
  public static boolean a;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GameCenterUtils";
    jdField_a_of_type_Boolean = true;
    b = true;
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
  }
  
  public static long a()
  {
    long l = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).getLong("gamecenter_res", 0L);
    bfnq.c(jdField_a_of_type_JavaLangString, "getResAvilTime ts" + l);
    return l;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).getLong(paramString, 0L);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).getString(paramString, "");
  }
  
  public static String a(String paramString, int paramInt)
  {
    paramString = "wadl_" + paramString + "_" + paramInt + ".apk";
    return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + "com.tencent.gamecenter.wadl" + "/" + "dlapks" + "/" + paramString;
  }
  
  public static List<DownloadInfo> a(String[] paramArrayOfString, String paramString, boolean paramBoolean)
  {
    int j = paramArrayOfString.length;
    ArrayList localArrayList = new ArrayList();
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    int i = 0;
    if (i < j)
    {
      if (TextUtils.isEmpty(paramArrayOfString[i])) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject = a(paramString + paramArrayOfString[i]);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        try
        {
          localObject = new JSONObject((String)localObject);
          localDownloadInfo.c = ((JSONObject)localObject).optString("appid");
          localDownloadInfo.j = ((JSONObject)localObject).optString("myAppId");
          localDownloadInfo.k = ((JSONObject)localObject).optString("apkId");
          localDownloadInfo.e = ((JSONObject)localObject).optString("packageName");
          localDownloadInfo.b = ((JSONObject)localObject).optInt("versionCode");
          if (paramBoolean) {
            break label219;
          }
          localArrayList.add(localDownloadInfo);
        }
        catch (Exception localException)
        {
          localArrayList.add(localDownloadInfo);
        }
        if (QLog.isColorLevel())
        {
          bfnq.b(jdField_a_of_type_JavaLangString, localDownloadInfo.c + "exception and no installed", localException);
          continue;
          label219:
          if (localPackageManager.getPackageInfo(localDownloadInfo.e.trim(), 0) == null)
          {
            localArrayList.add(localDownloadInfo);
            if (QLog.isColorLevel()) {
              bfnq.c(jdField_a_of_type_JavaLangString, localDownloadInfo.c + "no installed");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              bfnq.c(jdField_a_of_type_JavaLangString, localDownloadInfo.c + "installed");
            }
            a(null, "426", "202142", localDownloadInfo.c, "42601", "1", "116");
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    boolean bool2 = true;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.gameCfg.name(), "");
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseDPC config = " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[2];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        if (DeviceProfileManager.a(str, arrayOfInteger, new almr()) >= arrayOfInteger.length)
        {
          if (arrayOfInteger[0].intValue() != 1) {
            continue;
          }
          bool1 = true;
          jdField_a_of_type_Boolean = bool1;
          if (arrayOfInteger[1].intValue() != 1) {
            continue;
          }
          bool1 = bool2;
          b = bool1;
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        localException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseDPC isDelayDownload = " + jdField_a_of_type_Boolean + " , isAppointDownload = " + b);
      }
      return;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramAppInterface != null) {}
    for (;;)
    {
      try
      {
        paramAppInterface.getCurrentAccountUin();
        int j = ndd.a();
        if (j < 0) {
          break label460;
        }
        i = j;
        if (j >= aljq.c.length) {
          break label460;
        }
        String str2 = aljq.c[i];
        String str1 = "";
        Object localObject = str1;
        if (paramAppInterface != null)
        {
          BaseApplication localBaseApplication = paramAppInterface.getApp();
          localObject = str1;
          if (localBaseApplication != null)
          {
            localObject = localBaseApplication.getResources().getDisplayMetrics();
            localObject = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
          }
        }
        paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "8.3.3", "gamecenter_ver", "2", Build.BRAND, str2, localObject, "0", "0", "gamecenter_src", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break label455;
        }
        paramAppInterface = (QQAppInterface)paramAppInterface;
        biiv.a(paramAppInterface, "dc00087", paramString1);
        return;
      }
      catch (Exception paramAppInterface)
      {
        return;
      }
      BaseApplicationImpl.sApplication.getRuntime().getAccount();
      continue;
      label455:
      paramAppInterface = null;
      continue;
      label460:
      int i = 0;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<Integer, String> paramMap)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int i;
    try
    {
      if (!QLog.isColorLevel()) {
        break label304;
      }
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append("gameappid=").append(paramString3).append("/");
      ((StringBuffer)localObject1).append("oper_moudle=").append(paramString1).append("/");
      ((StringBuffer)localObject1).append("oper_id=").append(paramString2).append("/");
      ((StringBuffer)localObject1).append("moduleType=").append(paramString4).append("/");
      ((StringBuffer)localObject1).append("business=").append(paramString5).append("/");
      ((StringBuffer)localObject1).append("page=").append(paramString6).append("/");
      if ((paramMap != null) && (paramMap.keySet().size() > 0))
      {
        ((StringBuffer)localObject1).append("exts=[");
        localObject2 = paramMap.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          i = ((Integer)((Map.Entry)localObject3).getKey()).intValue();
          localObject3 = (String)((Map.Entry)localObject3).getValue();
          ((StringBuffer)localObject1).append(i).append("=").append((String)localObject3).append("/");
        }
        ((StringBuffer)localObject1).append("]");
      }
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "reportDC00087WithExt Exception:" + paramAppInterface.getMessage());
      }
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, ((StringBuffer)localObject1).toString());
    label304:
    int j = ndd.a();
    if (j >= 0)
    {
      i = j;
      if (j >= aljq.c.length) {}
    }
    for (;;)
    {
      localObject3 = aljq.c[i];
      localObject2 = "";
      localObject1 = localObject2;
      if (paramAppInterface != null)
      {
        BaseApplication localBaseApplication = paramAppInterface.getApp();
        localObject1 = localObject2;
        if (localBaseApplication != null)
        {
          localObject1 = localBaseApplication.getResources().getDisplayMetrics();
          localObject1 = ((DisplayMetrics)localObject1).widthPixels + "*" + ((DisplayMetrics)localObject1).heightPixels;
        }
      }
      paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "8.3.3", "gamecenter_ver", "2", Build.BRAND, localObject3, localObject1, "0", "0", "gamecenter_src", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        paramString2 = paramMap.keySet().iterator();
        while (paramString2.hasNext())
        {
          paramString3 = (Integer)paramString2.next();
          paramString1.set(paramString3.intValue() + 16, paramMap.get(paramString3));
        }
      }
      if ((paramAppInterface instanceof QQAppInterface)) {}
      for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
      {
        biiv.a(paramAppInterface, "dc00087", paramString1);
        return;
      }
      i = 0;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    int j = 0;
    if (paramAppInterface != null) {}
    try
    {
      paramAppInterface.getCurrentAccountUin();
      int k = ndd.a();
      int i;
      if (k >= 0)
      {
        i = k;
        if (k >= aljq.c.length) {}
      }
      for (;;)
      {
        String str2 = aljq.c[i];
        String str1 = "";
        Object localObject = str1;
        if (paramAppInterface != null)
        {
          BaseApplication localBaseApplication = paramAppInterface.getApp();
          localObject = str1;
          if (localBaseApplication != null)
          {
            localObject = localBaseApplication.getResources().getDisplayMetrics();
            localObject = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
          }
        }
        paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "8.3.3", "gamecenter_ver", "2", Build.BRAND, str2, localObject, "0", "0", "gamecenter_src", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
        if (paramVarArgs != null)
        {
          k = paramVarArgs.length;
          i = j;
          for (;;)
          {
            if ((i < k) && (i < 9))
            {
              paramString1.set(i + 16, paramVarArgs[i]);
              i += 1;
              continue;
              BaseApplicationImpl.sApplication.getRuntime().getAccount();
              break;
            }
          }
        }
        if ((paramAppInterface instanceof QQAppInterface)) {}
        for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
        {
          biiv.a(paramAppInterface, "dc00087", paramString1);
          return;
        }
        i = 0;
      }
      return;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public static void a(WadlResult paramWadlResult)
  {
    try
    {
      if ((BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(paramWadlResult.a.j.trim(), 0) != null) && (paramWadlResult.b != 9)) {
        paramWadlResult.b = 9;
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleQueryResult e=" + paramWadlResult.toString());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    bfnq.c(jdField_a_of_type_JavaLangString, "startDownload delay task pParamsJson=" + paramString + ",autoInstallBySdk=" + paramBoolean + ",from=" + paramInt + ",isWifi=" + AppNetConnInfo.isWifiConn());
    try
    {
      WadlJsBridge.startDownload(paramString, paramBoolean, paramInt);
      paramString = new JSONObject(paramString).optString("appid");
      if (2 == paramInt)
      {
        a(null, "427", "202139", paramString, "42701", "1", "117");
        return;
      }
      if (1 == paramInt)
      {
        a(null, "426", "202140", paramString, "42601", "1", "116");
        return;
      }
    }
    catch (Exception paramString)
    {
      bfnq.a(jdField_a_of_type_JavaLangString, "startDownload exception", paramString);
    }
  }
  
  public static void a(ArrayList<WadlResult> paramArrayList)
  {
    try
    {
      PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((localPackageManager.getPackageInfo(((WadlResult)paramArrayList.get(i)).a.j.trim(), 0) != null) && (((WadlResult)paramArrayList.get(i)).b != 9)) {
          ((WadlResult)paramArrayList.get(i)).b = 9;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleQueryResult e=" + paramArrayList.toString());
    }
  }
  
  public static void a(Map<Integer, String> paramMap, String paramString)
  {
    int i = 0;
    int j = 0;
    if (paramMap == null) {
      return;
    }
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (asjc.a == null)) {
          break;
        }
        Object localObject = (List)jdField_a_of_type_AndroidUtilLruCache.get(paramString);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "get _orted_configs from cache");
            i = j;
          }
          if (i >= ((List)localObject).size()) {
            break;
          }
          paramMap.put(Integer.valueOf(15 + i), ((List)localObject).get(i));
          i += 1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "get _orted_configs from msg decode");
        }
        localObject = (String)asjc.a.get(paramString + "_orted_configs");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "get _orted_configs from msg decode orted_configs = " + (String)localObject);
        }
        localObject = new JSONArray((String)localObject);
        localArrayList = new ArrayList();
        if (i >= ((JSONArray)localObject).length()) {
          break label349;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        Iterator localIterator = localJSONObject.keys();
        if (localIterator.hasNext())
        {
          String str = localJSONObject.optString((String)localIterator.next());
          paramMap.put(Integer.valueOf(15 + i), str);
          localArrayList.add(i, str);
        }
        else
        {
          i += 1;
        }
      }
      catch (Throwable paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "get _orted_configs err=" + paramMap.toString());
        }
        paramMap.printStackTrace();
        return;
      }
    }
    label349:
    jdField_a_of_type_AndroidUtilLruCache.put(paramString, localArrayList);
  }
  
  public static void a(String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      bfnq.c(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadDelayApp:" + paramArrayOfString);
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    for (;;)
    {
      return;
      a("DELAY_LIST", "");
      paramArrayOfString = a(paramArrayOfString, "DELAY_APPID_DETAIL_", true);
      if (paramArrayOfString.size() == 0)
      {
        if (QLog.isColorLevel()) {
          bfnq.c(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadDelayApp params.size=0:");
        }
      }
      else
      {
        paramArrayOfString = paramArrayOfString.iterator();
        while (paramArrayOfString.hasNext())
        {
          Object localObject = (DownloadInfo)paramArrayOfString.next();
          localObject = a("DELAY_APPID_DETAIL_" + ((DownloadInfo)localObject).c);
          try
          {
            a((String)localObject, true, 2);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    if ((bdee.h(BaseApplicationImpl.getContext())) && ((PowerManager)BaseApplicationImpl.getContext().getSystemService("power") != null) && ((aacp.a >= 20) || (aacp.b))) {
      return true;
    }
    a(null, "426", "205572", "", "42601", "1", "116");
    return false;
  }
  
  public static boolean a(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).edit();
    localEditor.putLong("gamecenter_res", paramLong);
    boolean bool = localEditor.commit();
    bfnq.c(jdField_a_of_type_JavaLangString, "saveResAvilTime: ts=" + paramLong + ",flag:" + bool);
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit().remove(paramString).commit();
    }
    return false;
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit();
    localEditor.putLong(paramString, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToSp " + paramString + " :" + paramLong);
    }
    return localEditor.commit();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit();
    localEditor.putString(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToSp " + paramString1 + " :" + paramString2);
    }
    return localEditor.commit();
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      bfnq.c(jdField_a_of_type_JavaLangString, "yuyue:saveAppDetail,appid:" + paramString1 + ",detail:" + paramString2 + ",keyPre:" + paramString3);
    }
    return a(paramString3 + paramString1, paramString2);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).edit();
    localEditor.putBoolean(paramString, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "writeToSp " + paramString + " :" + paramBoolean);
    }
    return localEditor.commit();
  }
  
  public static String b(String paramString)
  {
    return paramString + "_appoint";
  }
  
  public static void b(String[] paramArrayOfString)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      bfnq.c(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadAppointApp:" + paramArrayOfString);
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = "";
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject3;
      if (i < paramArrayOfString.length) {
        localObject3 = a("APPOINT_APPID_DETAIL_" + paramArrayOfString[i]);
      }
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        long l1 = ((JSONObject)localObject3).optLong("downloadStartTime", 0L);
        long l2 = ((JSONObject)localObject3).optLong("downloadEndTime", 0L);
        long l3 = NetConnInfoCenter.getServerTime();
        if ((l1 <= l3) && (l3 <= l2))
        {
          localObject3 = (String)localObject1 + paramArrayOfString[i] + "|";
          j = 1;
          localObject1 = localObject3;
        }
        else
        {
          localObject3 = (String)localObject2 + paramArrayOfString[i] + "|";
          localObject2 = localObject3;
        }
      }
      catch (Exception localException2)
      {
        i += 1;
      }
      paramArrayOfString = ((String)localObject1).split("\\|");
      if ((paramArrayOfString.length == 0) || (!a())) {
        break;
      }
      i = k;
      if (j != 0)
      {
        a("APPOINTMENT_LIST", (String)localObject2);
        i = k;
      }
      if (i < paramArrayOfString.length)
      {
        if (TextUtils.isEmpty(paramArrayOfString[i])) {}
        for (;;)
        {
          i += 1;
          break;
          c(paramArrayOfString[i], "APPOINTMENT_CHECKLIST");
        }
      }
      localObject1 = a(paramArrayOfString, "APPOINT_APPID_DETAIL_", true);
      if (((List)localObject1).size() < 1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        bfnq.c(jdField_a_of_type_JavaLangString, "checkIfNeedToDownloadAppointApp params.size=0:");
        return;
      }
      paramArrayOfString = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        localObject3 = a("APPOINT_APPID_DETAIL_" + ((DownloadInfo)localObject2).c);
        try
        {
          String str = a(((DownloadInfo)localObject2).c, ((DownloadInfo)localObject2).b);
          if (!arof.a(str)) {
            break label483;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 1, "startDownload from YY but apk is exists apkPath=" + str);
          a(null, "558", "205754", ((DownloadInfo)localObject2).c, "55801", "4", "430");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        continue;
        label483:
        a((String)localObject3, true, 1);
        c(localException1.c, "APPOINTMENT_HAS_DOWNLOAD_LIST");
        paramArrayOfString.put(localException1.c);
      }
      if (paramArrayOfString.length() <= 0) {
        break;
      }
      bkeu.a().a(paramArrayOfString, null);
      return;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return BaseApplicationImpl.sApplication.getSharedPreferences(b(BaseApplicationImpl.sApplication.getRuntime().getAccount()), 4).getBoolean(paramString, false);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String str;
    do
    {
      return false;
      str = a(paramString2);
    } while (str == null);
    return a(paramString2, str.replace(paramString1 + "|", ""));
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      str = a(paramString2);
    } while (str == null);
    if (QLog.isColorLevel()) {
      bfnq.c(jdField_a_of_type_JavaLangString, "yuyue:addAppidToList,appid:" + paramString1 + ",key:" + paramString2);
    }
    String str = str.replace(paramString1 + "|", "");
    return a(paramString2, str + paramString1 + "|");
  }
  
  public static boolean d(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return a(paramString2 + paramString1);
    }
    return false;
  }
  
  public static boolean e(String paramString1, String paramString2)
  {
    paramString1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/" + "com.tencent.gamecenter.wadl" + "/" + "res" + "/" + paramString1;
    return arof.a(paramString1 + "/" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aact
 * JD-Core Version:    0.7.0.1
 */