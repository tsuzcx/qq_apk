import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
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

public class aceh
{
  public static LruCache<String, List<String>> a;
  private static String a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    b = true;
    c = true;
    d = true;
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
    jdField_a_of_type_JavaLangString = "";
    Object localObject = BaseApplicationImpl.sApplication.getResources();
    if (localObject != null) {}
    for (localObject = ((Resources)localObject).getDisplayMetrics();; localObject = null)
    {
      if (localObject != null) {
        jdField_a_of_type_JavaLangString = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
      }
      return;
    }
  }
  
  public static int a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterUtils", 2, "getAppVersionCode packageName = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -1;
      try
      {
        PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
        if (localPackageManager != null) {}
        for (paramString = localPackageManager.getPackageInfo(paramString, 0); paramString != null; paramString = null)
        {
          int i = paramString.versionCode;
          return i;
        }
        return -1;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static long a()
  {
    long l = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).getLong("gamecenter_res", 0L);
    bize.c("GameCenterUtils", "getResAvilTime ts" + l);
    return l;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
        return BaseApplicationImpl.sApplication.getSharedPreferences(b((String)localObject), 4).getLong(paramString, 0L);
      }
      return 0L;
    }
    catch (Throwable paramString)
    {
      bize.b("GameCenterUtils", "readFromSpLong exception", paramString);
    }
  }
  
  public static PackageInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterUtils", 2, "getPackageInfo packageName = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
        if (localPackageManager != null)
        {
          paramString = localPackageManager.getPackageInfo(paramString, 0);
          return paramString;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static Pair<Integer, String> a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return new Pair(Integer.valueOf(-1), "");
    }
    int i = paramIntent.getIntExtra("uinType", -1);
    Object localObject = null;
    if (i == -1) {
      i = paramIntent.getIntExtra("curtype", -1);
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramIntent = (Intent)localObject;
      }
      for (;;)
      {
        localObject = paramIntent;
        if (TextUtils.isEmpty(paramIntent)) {
          localObject = "";
        }
        return new Pair(Integer.valueOf(i), localObject);
        paramIntent = paramIntent.getStringExtra("friend_uin");
        continue;
        paramIntent = paramIntent.getStringExtra("groupUin");
        continue;
        paramIntent = paramIntent.getStringExtra("dicussgroup_uin");
      }
    }
  }
  
  public static String a()
  {
    String str = bhgg.a("com.tencent.gamecenter.wadl/dlapks");
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterUtils", 4, "getDownloadApkDir realPath=" + str);
    }
    try
    {
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("GameCenterUtils", 4, "getDownloadApkDir make dir error", localThrowable);
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
      return BaseApplicationImpl.sApplication.getSharedPreferences(b((String)localObject), 4).getString(paramString, "");
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = "pkg";
    }
    for (;;)
    {
      paramString = bhgg.a("com.tencent.gamecenter.wadl/" + (String)localObject + "/" + paramString);
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterUtils", 4, "getDownloadResDir realPath=" + paramString);
      }
      try
      {
        localObject = new File(paramString);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        return paramString;
        localObject = "res";
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("GameCenterUtils", 4, "getDownloadApkDir make dir error", localThrowable);
      }
    }
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    return "wadl_" + paramString1 + "_" + paramInt + paramString2;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 257	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   5: getstatic 263	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:gameCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   8: invokevirtual 266	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   11: ldc 33
    //   13: invokevirtual 268	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore_3
    //   17: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 89
    //   25: iconst_2
    //   26: new 53	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 270
    //   36: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_3
    //   50: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +246 -> 299
    //   56: iconst_5
    //   57: anewarray 178	java/lang/Integer
    //   60: astore 4
    //   62: aload 4
    //   64: iconst_0
    //   65: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokestatic 276	java/util/Arrays:fill	([Ljava/lang/Object;Ljava/lang/Object;)V
    //   71: aload_3
    //   72: aload 4
    //   74: new 278	ankp
    //   77: dup
    //   78: invokespecial 279	ankp:<init>	()V
    //   81: invokestatic 282	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;[Ljava/lang/Object;Lanko;)I
    //   84: istore_0
    //   85: aload 4
    //   87: iconst_0
    //   88: aaload
    //   89: invokevirtual 286	java/lang/Integer:intValue	()I
    //   92: iconst_1
    //   93: if_icmpne +172 -> 265
    //   96: iconst_1
    //   97: istore_1
    //   98: iload_1
    //   99: putstatic 17	aceh:jdField_a_of_type_Boolean	Z
    //   102: aload 4
    //   104: iconst_1
    //   105: aaload
    //   106: invokevirtual 286	java/lang/Integer:intValue	()I
    //   109: iconst_1
    //   110: if_icmpne +160 -> 270
    //   113: iconst_1
    //   114: istore_1
    //   115: iload_1
    //   116: putstatic 19	aceh:b	Z
    //   119: aload 4
    //   121: iconst_2
    //   122: aaload
    //   123: invokevirtual 286	java/lang/Integer:intValue	()I
    //   126: iconst_1
    //   127: if_icmpne +148 -> 275
    //   130: iconst_1
    //   131: istore_1
    //   132: iload_1
    //   133: putstatic 21	aceh:c	Z
    //   136: aload 4
    //   138: iconst_3
    //   139: aaload
    //   140: invokevirtual 286	java/lang/Integer:intValue	()I
    //   143: iconst_1
    //   144: if_icmpne +136 -> 280
    //   147: iconst_1
    //   148: istore_1
    //   149: iload_1
    //   150: putstatic 23	aceh:d	Z
    //   153: iload_2
    //   154: istore_1
    //   155: aload 4
    //   157: iconst_4
    //   158: aaload
    //   159: invokevirtual 286	java/lang/Integer:intValue	()I
    //   162: iconst_1
    //   163: if_icmpne +5 -> 168
    //   166: iconst_1
    //   167: istore_1
    //   168: iload_1
    //   169: putstatic 288	aceh:e	Z
    //   172: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +89 -> 264
    //   178: ldc 89
    //   180: iconst_2
    //   181: new 53	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 290
    //   191: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_0
    //   195: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc_w 292
    //   201: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: getstatic 17	aceh:jdField_a_of_type_Boolean	Z
    //   207: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   210: ldc_w 297
    //   213: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: getstatic 19	aceh:b	Z
    //   219: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   222: ldc_w 299
    //   225: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: getstatic 21	aceh:c	Z
    //   231: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   234: ldc_w 301
    //   237: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: getstatic 23	aceh:d	Z
    //   243: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   246: ldc_w 303
    //   249: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: getstatic 288	aceh:e	Z
    //   255: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   258: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: return
    //   265: iconst_0
    //   266: istore_1
    //   267: goto -169 -> 98
    //   270: iconst_0
    //   271: istore_1
    //   272: goto -157 -> 115
    //   275: iconst_0
    //   276: istore_1
    //   277: goto -145 -> 132
    //   280: iconst_0
    //   281: istore_1
    //   282: goto -133 -> 149
    //   285: astore_3
    //   286: iconst_0
    //   287: istore_0
    //   288: aload_3
    //   289: invokevirtual 304	java/lang/Exception:printStackTrace	()V
    //   292: goto -120 -> 172
    //   295: astore_3
    //   296: goto -8 -> 288
    //   299: iconst_0
    //   300: istore_0
    //   301: goto -129 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   84	217	0	i	int
    //   97	185	1	bool1	boolean
    //   1	153	2	bool2	boolean
    //   16	56	3	str	String
    //   285	4	3	localException1	Exception
    //   295	1	3	localException2	Exception
    //   60	96	4	arrayOfInteger	Integer[]
    // Exception table:
    //   from	to	target	type
    //   56	85	285	java/lang/Exception
    //   85	96	295	java/lang/Exception
    //   98	113	295	java/lang/Exception
    //   115	130	295	java/lang/Exception
    //   132	147	295	java/lang/Exception
    //   149	153	295	java/lang/Exception
    //   155	166	295	java/lang/Exception
    //   168	172	295	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<Integer, String> paramMap)
  {
    try
    {
      if (!QLog.isColorLevel()) {
        break label302;
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
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          ((StringBuffer)localObject1).append(i).append("=").append((String)localObject2).append("/");
        }
        ((StringBuffer)localObject1).append("]");
      }
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterUtils", 1, "reportDC00087WithExt Exception:" + paramAppInterface.getMessage());
      }
      return;
    }
    QLog.d("GameCenterUtils", 1, ((StringBuffer)localObject1).toString());
    label302:
    Object localObject1 = nlw.a();
    paramString1 = Arrays.asList(new String[] { NetConnInfoCenter.getServerTime() + "", "1", "8.4.1", "1.0", "2", Build.BRAND, localObject1, jdField_a_of_type_JavaLangString, "0", "0", "1", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" });
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramString2 = paramMap.keySet().iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (Integer)paramString2.next();
        paramString1.set(paramString3.intValue() + 14, paramMap.get(paramString3));
      }
    }
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (paramAppInterface = (QQAppInterface)paramAppInterface;; paramAppInterface = null)
    {
      blaq.a(paramAppInterface, "dc00087", paramString1);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        String str = nlw.a();
        paramString1 = Arrays.asList(new String[] { String.valueOf(NetConnInfoCenter.getServerTime()), "1", "8.4.1", "1.0", "2", Build.BRAND, str, jdField_a_of_type_JavaLangString, "0", "0", "1", paramString1, paramString2, "0", paramString3, paramString4, "", "", "", "", "", "", "", "", "", paramString5, paramString6, "", Build.MODEL, Build.VERSION.RELEASE, "1", acei.b(), String.valueOf(bgln.b()[1]), "", "", "", "", "", "", "", "", "", "", "", "", "" });
        if (paramVarArgs != null) {
          if ((i < paramVarArgs.length) && (i < 9))
          {
            paramString1.set(i + 16, paramVarArgs[i]);
            i += 1;
            continue;
          }
        }
        if ((paramAppInterface instanceof QQAppInterface))
        {
          paramAppInterface = (QQAppInterface)paramAppInterface;
          blaq.a(paramAppInterface, "dc00087", paramString1);
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        return;
      }
      paramAppInterface = null;
    }
  }
  
  public static void a(WadlResult paramWadlResult)
  {
    try
    {
      if ((BaseApplicationImpl.getContext().getPackageManager().getPackageInfo(paramWadlResult.a.f.trim(), 0) != null) && (paramWadlResult.b != 9)) {
        paramWadlResult.b = 9;
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      QLog.e("GameCenterUtils", 1, "handleQueryResult e=" + paramWadlResult.toString());
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplicationImpl.sApplication.getRuntime();
        if (localObject != null)
        {
          localObject = ((AppRuntime)localObject).getAccount();
          localObject = BaseApplicationImpl.sApplication.getSharedPreferences(b((String)localObject), 4).edit();
          ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
          bize.c("GameCenterUtils", "writeToSpLong " + paramString + " :" + paramLong);
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
      catch (Throwable paramString)
      {
        bize.b("GameCenterUtils", "writeToSpLong exception", paramString);
        return;
      }
      Object localObject = "";
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    bize.c("GameCenterUtils", "startDownload delay task pParamsJson=" + paramString + ",autoInstallBySdk=" + paramBoolean + ",from=" + paramInt + ",isWifi=" + AppNetConnInfo.isWifiConn());
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
      bize.a("GameCenterUtils", "startDownload exception", paramString);
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
        if ((localPackageManager.getPackageInfo(((WadlResult)paramArrayList.get(i)).a.f.trim(), 0) != null) && (((WadlResult)paramArrayList.get(i)).b != 9)) {
          ((WadlResult)paramArrayList.get(i)).b = 9;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("GameCenterUtils", 1, "handleQueryResult e=" + paramArrayList.toString());
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
        if ((TextUtils.isEmpty(paramString)) || (auud.a == null)) {
          break;
        }
        Object localObject = (List)jdField_a_of_type_AndroidUtilLruCache.get(paramString);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("GameCenterUtils", 1, "get _orted_configs from cache");
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
          QLog.d("GameCenterUtils", 1, "get _orted_configs from msg decode");
        }
        localObject = (String)auud.a.get(paramString + "_orted_configs");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GameCenterUtils", 1, "get _orted_configs from msg decode orted_configs = " + (String)localObject);
        }
        localObject = new JSONArray((String)localObject);
        localArrayList = new ArrayList();
        if (i >= ((JSONArray)localObject).length()) {
          break label345;
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
          QLog.d("GameCenterUtils", 1, "get _orted_configs err=" + paramMap.toString());
        }
        paramMap.printStackTrace();
        return;
      }
    }
    label345:
    jdField_a_of_type_AndroidUtilLruCache.put(paramString, localArrayList);
  }
  
  public static boolean a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramInt);
    return atwl.a(paramString1 + "/" + paramString2);
  }
  
  public static boolean a(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("gamecenter_res", 4).edit();
    localEditor.putLong("gamecenter_res", paramLong);
    boolean bool = localEditor.commit();
    bize.c("GameCenterUtils", "saveResAvilTime: ts=" + paramLong + ",flag:" + bool);
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
      return BaseApplicationImpl.sApplication.getSharedPreferences(b((String)localObject), 4).getBoolean(paramString, false);
    }
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    int i = a(paramString);
    bize.c("GameCenterUtils", "checkVersion packageName=" + paramString + ",versionCode=" + paramInt + ",localVersion=" + i);
    return (i != -1) && (i < paramInt);
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    int i = a(paramString);
    bize.c("GameCenterUtils", "checkVersion packageName=" + paramString + ",updateVersion=" + paramInt1 + ",qgameMinVersion=" + paramInt2 + ",localVersion=" + i);
    return (paramInt2 > -1) && (i != -1) && (i < paramInt2) && (i < paramInt1);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localObject = BaseApplicationImpl.sApplication.getSharedPreferences(b((String)localObject), 4).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      bize.c("GameCenterUtils", "writeToSp " + paramString1 + " :" + paramString2);
      return ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    bize.c("GameCenterUtils", "yuyue:saveAppDetail,appid:" + paramString1 + ",detail:" + paramString2 + ",keyPre:" + paramString3);
    return a(paramString3 + paramString1, paramString2);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localObject = BaseApplicationImpl.sApplication.getSharedPreferences(b((String)localObject), 4).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, paramBoolean);
      bize.c("GameCenterUtils", "writeToSp " + paramString + " :" + paramBoolean);
      return ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean a(String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
      {
        localObject = BaseApplicationImpl.sApplication.getSharedPreferences(b((String)localObject), 4).edit();
        int j = paramVarArgs.length;
        while (i < j)
        {
          ((SharedPreferences.Editor)localObject).remove(paramVarArgs[i]);
          i += 1;
        }
      }
      return ((SharedPreferences.Editor)localObject).commit();
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    return paramString + "_appoint";
  }
  
  public static String b(String paramString, int paramInt)
  {
    String str2 = b(paramString, paramInt, ".apk");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = b(paramString, paramInt, "_tgpa.apk");
    }
    return str1;
  }
  
  public static String b(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = a(paramString1, paramInt, paramString2);
    paramString1 = a() + "/" + paramString1;
    if (atwl.a(paramString1)) {
      return paramString1;
    }
    return null;
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
  
  public static String c(String paramString)
  {
    String str = null;
    try
    {
      PackageManager localPackageManager = BaseApplicationImpl.getApplication().getPackageManager();
      if (localPackageManager != null) {}
      for (paramString = localPackageManager.getApplicationInfo(paramString, 0);; paramString = null)
      {
        if (paramString != null) {
          str = paramString.sourceDir;
        }
        return str;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      str = a(paramString2);
    } while (str == null);
    bize.c("GameCenterUtils", "yuyue:addAppidToList,appid:" + paramString1 + ",key:" + paramString2);
    String str = str.replace(paramString1 + "|", "");
    return a(paramString2, str + paramString1 + "|");
  }
  
  /* Error */
  public static String d(String paramString)
  {
    // Byte code:
    //   0: ldc 89
    //   2: new 53	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 685
    //   12: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 149	bize:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifeq +6 -> 35
    //   32: ldc 33
    //   34: areturn
    //   35: ldc 33
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: new 216	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 222	java/io/File:exists	()Z
    //   54: ifeq +316 -> 370
    //   57: aload_0
    //   58: invokevirtual 687	java/io/File:length	()J
    //   61: lconst_0
    //   62: lcmp
    //   63: ifle +307 -> 370
    //   66: aload_0
    //   67: invokevirtual 687	java/io/File:length	()J
    //   70: lstore_1
    //   71: new 689	java/io/BufferedInputStream
    //   74: dup
    //   75: new 691	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 694	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 697	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_0
    //   87: aload 4
    //   89: astore_3
    //   90: aload_0
    //   91: lload_1
    //   92: ldc2_w 698
    //   95: lsub
    //   96: invokevirtual 703	java/io/BufferedInputStream:skip	(J)J
    //   99: pop2
    //   100: aload 4
    //   102: astore_3
    //   103: bipush 50
    //   105: newarray byte
    //   107: astore 5
    //   109: aload 4
    //   111: astore_3
    //   112: aload_0
    //   113: aload 5
    //   115: iconst_0
    //   116: bipush 50
    //   118: invokevirtual 707	java/io/BufferedInputStream:read	([BII)I
    //   121: pop
    //   122: aload 4
    //   124: astore_3
    //   125: new 366	java/lang/String
    //   128: dup
    //   129: aload 5
    //   131: invokespecial 710	java/lang/String:<init>	([B)V
    //   134: astore 6
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 89
    //   141: new 53	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 712
    //   151: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 5
    //   156: invokestatic 717	bkcx:b	([B)Ljava/lang/String;
    //   159: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 149	bize:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload 4
    //   170: astore_3
    //   171: aload 6
    //   173: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +188 -> 364
    //   179: aload 4
    //   181: astore_3
    //   182: aload 6
    //   184: ldc_w 719
    //   187: invokevirtual 722	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   190: ifeq +174 -> 364
    //   193: aload 4
    //   195: astore_3
    //   196: aload 6
    //   198: aload 6
    //   200: ldc_w 719
    //   203: invokevirtual 725	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   206: bipush 10
    //   208: iadd
    //   209: invokevirtual 729	java/lang/String:substring	(I)Ljava/lang/String;
    //   212: astore 4
    //   214: aload 4
    //   216: astore_3
    //   217: aload 4
    //   219: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifne +57 -> 279
    //   225: aload 4
    //   227: astore_3
    //   228: aload 4
    //   230: invokevirtual 462	java/lang/String:trim	()Ljava/lang/String;
    //   233: astore 4
    //   235: aload 4
    //   237: astore_3
    //   238: ldc 89
    //   240: new 53	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 731
    //   250: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_3
    //   254: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 733
    //   260: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: lload_1
    //   264: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 149	bize:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_0
    //   274: invokestatic 739	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   277: aload_3
    //   278: areturn
    //   279: ldc 33
    //   281: astore_3
    //   282: goto -44 -> 238
    //   285: astore 4
    //   287: ldc 33
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_0
    //   292: ldc 89
    //   294: new 53	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 741
    //   304: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 4
    //   309: invokevirtual 376	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 743	bize:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_0
    //   322: invokestatic 739	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   325: aload_3
    //   326: areturn
    //   327: astore_0
    //   328: aload_3
    //   329: invokestatic 739	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   332: aload_0
    //   333: athrow
    //   334: astore 4
    //   336: aload_0
    //   337: astore_3
    //   338: aload 4
    //   340: astore_0
    //   341: goto -13 -> 328
    //   344: astore 4
    //   346: aload_0
    //   347: astore_3
    //   348: aload 4
    //   350: astore_0
    //   351: goto -23 -> 328
    //   354: astore 4
    //   356: goto -64 -> 292
    //   359: astore 4
    //   361: goto -69 -> 292
    //   364: ldc 33
    //   366: astore_3
    //   367: goto -94 -> 273
    //   370: aconst_null
    //   371: astore_0
    //   372: ldc 33
    //   374: astore_3
    //   375: goto -102 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramString	String
    //   70	194	1	l	long
    //   40	335	3	str1	String
    //   37	199	4	str2	String
    //   285	23	4	localException1	Exception
    //   334	5	4	localObject1	Object
    //   344	5	4	localObject2	Object
    //   354	1	4	localException2	Exception
    //   359	1	4	localException3	Exception
    //   107	48	5	arrayOfByte	byte[]
    //   134	65	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   41	87	285	java/lang/Exception
    //   41	87	327	finally
    //   90	100	334	finally
    //   103	109	334	finally
    //   112	122	334	finally
    //   125	136	334	finally
    //   139	168	334	finally
    //   171	179	334	finally
    //   182	193	334	finally
    //   196	214	334	finally
    //   217	225	334	finally
    //   228	235	334	finally
    //   238	273	334	finally
    //   292	321	344	finally
    //   90	100	354	java/lang/Exception
    //   103	109	354	java/lang/Exception
    //   112	122	354	java/lang/Exception
    //   125	136	354	java/lang/Exception
    //   139	168	354	java/lang/Exception
    //   171	179	354	java/lang/Exception
    //   182	193	354	java/lang/Exception
    //   196	214	354	java/lang/Exception
    //   217	225	354	java/lang/Exception
    //   228	235	354	java/lang/Exception
    //   238	273	359	java/lang/Exception
  }
  
  public static boolean d(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2)) {
        bool1 = a(new String[] { paramString2 + paramString1 });
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aceh
 * JD-Core Version:    0.7.0.1
 */