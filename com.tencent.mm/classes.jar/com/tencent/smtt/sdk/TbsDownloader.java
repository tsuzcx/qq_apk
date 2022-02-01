package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.g.a;
import com.tencent.smtt.utils.n;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader
{
  public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
  public static boolean DOWNLOAD_OVERSEA_TBS = false;
  public static final String LOGTAG = "TbsDownload";
  public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  static boolean a;
  private static String b;
  private static Context c;
  private static Handler d;
  private static String e;
  private static Object f = new byte[0];
  private static k g;
  private static HandlerThread h;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static long l = -1L;
  
  protected static File a(int paramInt)
  {
    AppMethodBeat.i(54149);
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject1 = null;
    int n = arrayOfString.length;
    int m = 0;
    Object localObject2 = localObject1;
    if (m < n)
    {
      localObject2 = arrayOfString[m];
      if (((String)localObject2).equals(c.getApplicationInfo().packageName)) {
        break label152;
      }
      localObject2 = f.a(c, (String)localObject2, 4, false);
      if (!getOverSea(c)) {
        break label137;
      }
    }
    label137:
    for (localObject1 = "x5.oversea.tbs.org";; localObject1 = getBackupFileName(false))
    {
      localObject1 = new File((String)localObject2, (String)localObject1);
      if (!((File)localObject1).exists()) {
        break label159;
      }
      if (a.a(c, (File)localObject1) != paramInt) {
        break;
      }
      TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject1).getAbsolutePath());
      localObject2 = localObject1;
      AppMethodBeat.o(54149);
      return localObject2;
    }
    TbsLog.i("TbsDownload", "version is not match");
    for (;;)
    {
      label152:
      m += 1;
      break;
      label159:
      TbsLog.i("TbsDownload", "can not find local backup core file");
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static JSONArray a(boolean paramBoolean)
  {
    AppMethodBeat.i(54151);
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = arrayOfString.length;
    int m = 0;
    Object localObject;
    label65:
    label78:
    long l1;
    if (m < i1)
    {
      localObject = arrayOfString[m];
      if (paramBoolean)
      {
        String str = f.a(c, (String)localObject, 4, false);
        if (getOverSea(c))
        {
          localObject = "x5.oversea.tbs.org";
          localObject = new File(str, (String)localObject);
          if (((File)localObject).exists())
          {
            l1 = a.a(c, (File)localObject);
            if (l1 > 0L)
            {
              n = 0;
              label106:
              if (n >= localJSONArray.length()) {
                break label197;
              }
              if (localJSONArray.optInt(n) != l1) {
                break label182;
              }
            }
          }
        }
      }
    }
    label182:
    label197:
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        localJSONArray.put(l1);
      }
      m += 1;
      break;
      localObject = getBackupFileName(false);
      break label65;
      localObject = new File(f.a(c, (String)localObject, 4, false), "x5.tbs.decouple");
      break label78;
      n += 1;
      break label106;
      AppMethodBeat.o(54151);
      return localJSONArray;
    }
  }
  
  private static JSONObject a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(54141);
    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    String str1 = b(c);
    String str2 = b.e(c);
    String str3 = b.d(c);
    String str4 = b.g(c);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)c.getSystemService("phone");
        if (localObject3 == null) {
          break label784;
        }
        localObject3 = ((TelephonyManager)localObject3).getSimCountryIso();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          label129:
          continue;
          localException2.put("REQUEST_TPATCH", 0);
        }
        m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      }
      if (localObject1 != null) {
        localObject3 = new JSONObject();
      }
    }
    label784:
    label787:
    label799:
    label1073:
    try
    {
      if (l.a(c).c("tpatch_num") >= 5) {
        break label787;
      }
      ((JSONObject)localObject3).put("REQUEST_TPATCH", 1);
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      if (b.c()) {
        ((JSONObject)localObject3).put("REQUEST_64", 1);
      }
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!TbsShareManager.isThirdPartyApp(c)) {
        break label821;
      }
      if (!QbSdk.c) {
        break label799;
      }
      m = TbsShareManager.a(c, false);
    }
    catch (Exception localException1)
    {
      label821:
      for (;;)
      {
        int m;
        label233:
        label247:
        int n;
        label312:
        label627:
        continue;
        label701:
        label1096:
        label1118:
        label1121:
        if (m == 0)
        {
          n = 0;
        }
        else
        {
          n = 1;
          continue;
          n = 0;
          continue;
          n = 0;
          continue;
          m = 1;
        }
      }
    }
    if (paramBoolean1)
    {
      ((JSONObject)localObject3).put("FUNCTION", 2);
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject1 = g();
        ((JSONObject)localObject3).put("TBSVLARR", localObject1);
        localTbsDownloadConfig.mSyncMap.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject1).toString());
        localTbsDownloadConfig.commit();
        if (QbSdk.c) {
          ((JSONObject)localObject3).put("THIRDREQ", 1);
        }
        ((JSONObject)localObject3).put("APPN", c.getPackageName());
        ((JSONObject)localObject3).put("APPVN", a(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
        ((JSONObject)localObject3).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
        ((JSONObject)localObject3).put("APPMETA", a(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
        ((JSONObject)localObject3).put("TBSSDKV", 43804);
        ((JSONObject)localObject3).put("TBSV", m);
        if (!paramBoolean3) {
          break label1155;
        }
        n = 1;
        ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", n);
        localObject1 = localTbsDownloadConfig.mSyncMap;
        if (!paramBoolean3) {
          break label1161;
        }
        n = 1;
        ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(n));
        localTbsDownloadConfig.commit();
        if (m != 0) {
          ((JSONObject)localObject3).put("TBSBACKUPV", g.b(paramBoolean3));
        }
        ((JSONObject)localObject3).put("CPU", e);
        ((JSONObject)localObject3).put("UA", str1);
        ((JSONObject)localObject3).put("IMSI", a(str2));
        ((JSONObject)localObject3).put("IMEI", a(str3));
        ((JSONObject)localObject3).put("ANDROID_ID", a(str4));
        ((JSONObject)localObject3).put("GUID", b.c(c));
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          TbsLog.d("TbsDownload", "tbsLocalVersion: ".concat(String.valueOf(m)));
          if (m == 0) {
            break label1073;
          }
          if (!QbSdk.a(c, m)) {
            break label1167;
          }
          m = 0;
          ((JSONObject)localObject3).put("STATUS", m);
          ((JSONObject)localObject3).put("TBSDV", o.a().h(c));
        }
        paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
        localObject1 = QbSdk.a(c, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label1096;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label1121;
      }
      for (;;)
      {
        if (m != 0) {
          ((JSONObject)localObject3).put("REQUEST_LZMA", 1);
        }
        if (getOverSea(c)) {
          ((JSONObject)localObject3).put("OVERSEA", 1);
        }
        if (paramBoolean2) {
          ((JSONObject)localObject3).put("DOWNLOAD_FOREGROUND", 1);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + ((JSONObject)localObject3).toString());
        AppMethodBeat.o(54141);
        return localObject3;
        if (paramBoolean3) {}
        for (n = o.a().i(c);; n = o.a().m(c))
        {
          m = n;
          if (n == 0)
          {
            m = n;
            if (o.a().l(c))
            {
              n = -1;
              m = n;
              if ("com.tencent.mobileqq".equals(c.getApplicationInfo().packageName))
              {
                TbsDownloadUpload.clear();
                localObject1 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject1).a.put("tbs_local_core_version", Integer.valueOf(-1));
                ((TbsDownloadUpload)localObject1).commit();
                TbsPVConfig.releaseInstance();
                m = n;
                if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                  m = o.a().i(c);
                }
              }
            }
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + m + " isDownloadForeground=" + paramBoolean2);
          if (!paramBoolean2) {
            break;
          }
          if (o.a().l(c)) {
            break label1118;
          }
          m = 0;
          break label1118;
        }
        localException2.put("FUNCTION", n);
        break label247;
        localObject1 = a(paramBoolean3);
        if ((Apn.getApnType(c) == 3) || (((JSONArray)localObject1).length() == 0) || (m != 0) || (!paramBoolean1)) {
          break label312;
        }
        localException2.put("TBSBACKUPARR", localObject1);
        break label312;
        localException2.put("STATUS", 0);
        break label627;
        do
        {
          m = 0;
          break label701;
          do
          {
            m = 0;
            break label701;
            paramBoolean1 = false;
            continue;
            break label233;
            localObject1 = "";
            break label129;
            localObject2 = "";
            break;
            break label233;
          } while (!paramBoolean1);
        } while (paramBoolean3);
        m = 1;
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(54137);
    String[] arrayOfString = f();
    int i1 = arrayOfString.length;
    int m = 0;
    String str;
    int i2;
    Context localContext;
    if (m < i1)
    {
      str = arrayOfString[m];
      i2 = TbsShareManager.getSharedTbsCoreVersion(c, str);
      if (i2 > 0)
      {
        localContext = TbsShareManager.getPackageContext(c, str, true);
        if ((localContext == null) || (o.a().f(localContext))) {
          break label93;
        }
        TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
      }
    }
    label276:
    label281:
    for (;;)
    {
      m += 1;
      break;
      label93:
      int n = 0;
      label95:
      if (n < paramJSONArray.length()) {
        if (paramJSONArray.optInt(n) != i2) {}
      }
      for (n = 1;; n = 0)
      {
        if (n != 0) {
          break label281;
        }
        paramJSONArray.put(i2);
        break;
        n += 1;
        break label95;
        arrayOfString = f();
        i1 = arrayOfString.length;
        m = 0;
        if (m < i1)
        {
          str = arrayOfString[m];
          i2 = TbsShareManager.getCoreShareDecoupleCoreVersion(c, str);
          if (i2 > 0)
          {
            localContext = TbsShareManager.getPackageContext(c, str, true);
            if ((localContext == null) || (o.a().f(localContext))) {
              break label223;
            }
            TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
          }
        }
        for (;;)
        {
          m += 1;
          break;
          label223:
          n = 0;
          label225:
          if (n < paramJSONArray.length()) {
            if (paramJSONArray.optInt(n) != i2) {}
          }
          for (n = 1;; n = 0)
          {
            if (n != 0) {
              break label276;
            }
            paramJSONArray.put(i2);
            break;
            n += 1;
            break label225;
            AppMethodBeat.o(54137);
            return;
          }
        }
      }
    }
  }
  
  private static void a(boolean paramBoolean1, TbsDownloaderCallback paramTbsDownloaderCallback, boolean paramBoolean2)
  {
    int n = 1;
    AppMethodBeat.i(54134);
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    d.removeMessages(100);
    Message localMessage = Message.obtain(d, 100);
    if (paramTbsDownloaderCallback != null) {
      localMessage.obj = paramTbsDownloaderCallback;
    }
    localMessage.arg1 = 0;
    if (paramBoolean1)
    {
      m = 1;
      localMessage.arg1 = m;
      if (!paramBoolean2) {
        break label93;
      }
    }
    label93:
    for (int m = n;; m = 0)
    {
      localMessage.arg2 = m;
      localMessage.sendToTarget();
      AppMethodBeat.o(54134);
      return;
      m = 0;
      break;
    }
  }
  
  static boolean a(Context paramContext)
  {
    AppMethodBeat.i(54123);
    if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1)
    {
      AppMethodBeat.o(54123);
      return true;
    }
    AppMethodBeat.o(54123);
    return false;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(54119);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    if (Build.VERSION.SDK_INT < 8)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(-102);
      AppMethodBeat.o(54119);
      return false;
    }
    if ((!QbSdk.c) && (TbsShareManager.isThirdPartyApp(c)) && (!c()))
    {
      AppMethodBeat.o(54119);
      return false;
    }
    if (!localTbsDownloadConfig.mPreferences.contains("is_oversea"))
    {
      boolean bool = paramBoolean;
      if (paramBoolean)
      {
        bool = paramBoolean;
        if (!"com.tencent.mm".equals(paramContext.getApplicationInfo().packageName))
        {
          TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
          bool = false;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("is_oversea", Boolean.valueOf(bool));
      localTbsDownloadConfig.commit();
      j = bool;
      TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = ".concat(String.valueOf(bool)));
    }
    if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
    {
      TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
      localTbsDownloadConfig.setDownloadInterruptCode(-103);
      AppMethodBeat.o(54119);
      return false;
    }
    paramContext = localTbsDownloadConfig.mPreferences.getString("device_cpuabi", null);
    e = paramContext;
    if (!TextUtils.isEmpty(paramContext)) {}
    try
    {
      paramContext = Pattern.compile("i686|mips|x86_64").matcher(e);
      if ((paramContext != null) && (paramContext.find()))
      {
        TbsLog.e("TbsDownload", "can not support x86 devices!!");
        localTbsDownloadConfig.setDownloadInterruptCode(-104);
        AppMethodBeat.o(54119);
        return false;
      }
      AppMethodBeat.o(54119);
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(54118);
    Object localObject = TbsDownloadConfig.getInstance(paramContext);
    paramContext = null;
    String str1;
    int m;
    String str2;
    String str3;
    int n;
    String str4;
    long l2;
    long l1;
    if (!paramBoolean1)
    {
      str1 = ((TbsDownloadConfig)localObject).mPreferences.getString("app_versionname", null);
      m = ((TbsDownloadConfig)localObject).mPreferences.getInt("app_versioncode", 0);
      str2 = ((TbsDownloadConfig)localObject).mPreferences.getString("app_metadata", null);
      str3 = b.a(c);
      n = b.b(c);
      str4 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + str3 + " oldAppVersionName=" + str1 + " appVersionCode=" + n + " oldAppVersionCode=" + m + " appMetadata=" + str4 + " oldAppVersionMetadata=" + str2);
      l2 = System.currentTimeMillis();
      long l3 = ((TbsDownloadConfig)localObject).mPreferences.getLong("last_check", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + l3 + " timeNow=" + l2);
      l1 = l3;
      if (paramBoolean2)
      {
        paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.contains("last_check");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=".concat(String.valueOf(paramBoolean1)));
        l1 = l3;
        if (paramBoolean1)
        {
          l1 = l3;
          if (l3 == 0L) {
            l1 = l2;
          }
        }
      }
      l3 = ((TbsDownloadConfig)localObject).mPreferences.getLong("last_request_success", 0L);
      long l4 = ((TbsDownloadConfig)localObject).mPreferences.getLong("count_request_fail_in_24hours", 0L);
      long l5 = ((TbsDownloadConfig)localObject).getRetryInterval();
      TbsLog.i("TbsDownload", "retryInterval = " + l5 + " s");
      TbsPVConfig.releaseInstance();
      int i1 = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
      int i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      if ((l2 - l1 <= 1000L * l5) && ((i1 <= o.a().i(c)) || (i1 <= i2)) && ((!TbsShareManager.isThirdPartyApp(c)) || (l3 <= 0L) || (l2 - l3 <= l5 * 1000L) || (l4 >= 11L)))
      {
        if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!e())) {
          o.a().d(c);
        }
        for (paramBoolean1 = true;; paramBoolean1 = true)
        {
          if ((!paramBoolean1) && (TbsShareManager.isThirdPartyApp(c)))
          {
            localObject = TbsLogReport.getInstance(c).tbsLogInfo();
            ((TbsLogReport.TbsLogInfo)localObject).setErrorCode(-119);
            ((TbsLogReport.TbsLogInfo)localObject).setFailDetail(paramContext);
            TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject);
          }
          AppMethodBeat.o(54118);
          return paramBoolean1;
          if ((str3 == null) || (n == 0) || (str4 == null)) {
            break;
          }
          if ((str3.equals(str1)) && (n == m) && (str4.equals(str2))) {
            break label734;
          }
        }
        if (!TbsShareManager.isThirdPartyApp(c)) {
          break label734;
        }
      }
    }
    label734:
    for (paramContext = "timeNow - timeLastCheck is " + (l2 - l1) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + str3 + " appVersionCode is " + n + " appMetadata is " + str4 + " oldAppVersionName is " + str1 + " oldAppVersionCode is " + m + " oldAppVersionMetadata is " + str2;; paramContext = null)
    {
      paramBoolean1 = false;
      break;
      paramBoolean1 = true;
      break;
    }
  }
  
  /* Error */
  @TargetApi(11)
  private static boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: ldc_w 701
    //   3: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 23
    //   8: new 124	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 703
    //   15: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 705
    //   25: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload 4
    //   30: invokevirtual 186	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   42: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   45: astore 32
    //   47: aload_0
    //   48: invokestatic 562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifeq +41 -> 92
    //   54: iload_2
    //   55: ifeq +26 -> 81
    //   58: aload 32
    //   60: bipush 148
    //   62: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   65: ldc 23
    //   67: ldc_w 707
    //   70: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 701
    //   76: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_0
    //   80: ireturn
    //   81: aload 32
    //   83: sipush -208
    //   86: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   89: goto -24 -> 65
    //   92: new 227	org/json/JSONObject
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 708	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   100: astore 33
    //   102: aload 33
    //   104: ldc_w 710
    //   107: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   110: istore 5
    //   112: iload 5
    //   114: ifeq +49 -> 163
    //   117: iload_2
    //   118: ifeq +34 -> 152
    //   121: aload 32
    //   123: bipush 147
    //   125: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   128: ldc 23
    //   130: ldc_w 714
    //   133: iload 5
    //   135: invokestatic 368	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: ldc_w 701
    //   147: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: aload 32
    //   154: sipush -209
    //   157: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   160: goto -32 -> 128
    //   163: aload 33
    //   165: ldc_w 716
    //   168: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   171: istore 13
    //   173: aload 33
    //   175: ldc_w 718
    //   178: invokevirtual 720	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 34
    //   183: aload 33
    //   185: ldc_w 722
    //   188: ldc 158
    //   190: invokevirtual 725	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 35
    //   195: aload 33
    //   197: ldc_w 727
    //   200: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   203: istore 12
    //   205: aload 33
    //   207: ldc_w 729
    //   210: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   213: istore 14
    //   215: aload 33
    //   217: ldc_w 731
    //   220: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   223: istore 15
    //   225: aload 33
    //   227: ldc_w 733
    //   230: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   233: istore 16
    //   235: aload 33
    //   237: ldc_w 735
    //   240: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   243: istore 17
    //   245: aload 33
    //   247: ldc_w 737
    //   250: invokevirtual 740	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   253: lstore 24
    //   255: aload 33
    //   257: ldc_w 742
    //   260: invokevirtual 740	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   263: lstore 26
    //   265: aload 33
    //   267: ldc_w 744
    //   270: lconst_0
    //   271: invokevirtual 747	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   274: lstore 22
    //   276: aload 33
    //   278: ldc_w 749
    //   281: iconst_m1
    //   282: invokevirtual 751	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   285: istore 18
    //   287: iconst_0
    //   288: istore 5
    //   290: aload 33
    //   292: ldc_w 753
    //   295: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   298: istore 6
    //   300: iload 6
    //   302: istore 5
    //   304: aload 32
    //   306: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   309: ldc_w 755
    //   312: iload 5
    //   314: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: invokeinterface 285 3 0
    //   322: pop
    //   323: iload_2
    //   324: ifeq +59 -> 383
    //   327: getstatic 757	com/tencent/smtt/sdk/QbSdk:h	Z
    //   330: ifeq +53 -> 383
    //   333: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   336: invokestatic 259	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   339: ifeq +44 -> 383
    //   342: aload 33
    //   344: ldc_w 759
    //   347: iconst_0
    //   348: invokevirtual 751	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   351: istore 5
    //   353: invokestatic 764	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   356: astore_0
    //   357: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   360: astore 28
    //   362: iload 5
    //   364: iconst_1
    //   365: if_icmpne +813 -> 1178
    //   368: iconst_1
    //   369: istore 19
    //   371: aload_0
    //   372: aload 28
    //   374: ldc_w 766
    //   377: iload 19
    //   379: invokevirtual 770	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   382: pop
    //   383: iload_2
    //   384: ifeq +189 -> 573
    //   387: aload 33
    //   389: ldc_w 772
    //   392: iconst_0
    //   393: invokevirtual 751	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   396: istore 5
    //   398: iload 5
    //   400: iconst_1
    //   401: iand
    //   402: ifeq +812 -> 1214
    //   405: iconst_1
    //   406: istore 19
    //   408: invokestatic 764	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   411: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   414: ldc_w 774
    //   417: iload 19
    //   419: invokevirtual 770	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   422: pop
    //   423: ldc 23
    //   425: ldc_w 776
    //   428: iload 19
    //   430: invokestatic 550	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   433: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 779	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: iload 5
    //   441: iconst_2
    //   442: iand
    //   443: ifeq +777 -> 1220
    //   446: iconst_1
    //   447: istore 19
    //   449: invokestatic 764	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   452: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   455: ldc_w 781
    //   458: iload 19
    //   460: invokevirtual 770	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   463: pop
    //   464: ldc 23
    //   466: ldc_w 783
    //   469: iload 19
    //   471: invokestatic 550	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   474: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   477: invokestatic 779	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: iload 5
    //   482: iconst_4
    //   483: iand
    //   484: ifeq +742 -> 1226
    //   487: iconst_1
    //   488: istore 19
    //   490: invokestatic 764	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   493: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   496: ldc_w 785
    //   499: iload 19
    //   501: invokevirtual 770	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   504: pop
    //   505: iload 19
    //   507: invokestatic 789	com/tencent/smtt/sdk/QbSdk:setDisableUnpreinitBySwitch	(Z)V
    //   510: ldc 23
    //   512: ldc_w 791
    //   515: iload 19
    //   517: invokestatic 550	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   520: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   523: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: iload 5
    //   528: bipush 8
    //   530: iand
    //   531: ifeq +701 -> 1232
    //   534: iconst_1
    //   535: istore 19
    //   537: invokestatic 764	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   540: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   543: ldc_w 793
    //   546: iload 19
    //   548: invokevirtual 770	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   551: pop
    //   552: iload 19
    //   554: invokestatic 796	com/tencent/smtt/sdk/QbSdk:setDisableUseHostBackupCoreBySwitch	(Z)V
    //   557: ldc 23
    //   559: ldc_w 798
    //   562: iload 19
    //   564: invokestatic 550	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   567: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   570: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: aconst_null
    //   574: astore 28
    //   576: iconst_0
    //   577: istore 9
    //   579: iconst_0
    //   580: istore 10
    //   582: iconst_0
    //   583: istore 11
    //   585: iconst_0
    //   586: istore 5
    //   588: iconst_1
    //   589: istore 21
    //   591: iconst_1
    //   592: istore 19
    //   594: ldc 158
    //   596: astore 30
    //   598: aload 30
    //   600: astore 29
    //   602: iload 21
    //   604: istore 20
    //   606: iload 11
    //   608: istore 8
    //   610: iload 10
    //   612: istore 7
    //   614: iload 9
    //   616: istore 6
    //   618: aload 33
    //   620: ldc_w 800
    //   623: invokevirtual 720	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   626: astore 31
    //   628: aload 30
    //   630: astore 29
    //   632: iload 21
    //   634: istore 20
    //   636: iload 11
    //   638: istore 8
    //   640: iload 10
    //   642: istore 7
    //   644: iload 9
    //   646: istore 6
    //   648: aload 31
    //   650: astore 28
    //   652: aload 33
    //   654: ldc_w 802
    //   657: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   660: istore 9
    //   662: aload 30
    //   664: astore 29
    //   666: iload 21
    //   668: istore 20
    //   670: iload 11
    //   672: istore 8
    //   674: iload 10
    //   676: istore 7
    //   678: iload 9
    //   680: istore 6
    //   682: aload 31
    //   684: astore 28
    //   686: aload 33
    //   688: ldc_w 804
    //   691: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   694: istore 10
    //   696: aload 30
    //   698: astore 29
    //   700: iload 21
    //   702: istore 20
    //   704: iload 11
    //   706: istore 8
    //   708: iload 10
    //   710: istore 7
    //   712: iload 9
    //   714: istore 6
    //   716: aload 31
    //   718: astore 28
    //   720: aload 33
    //   722: ldc_w 806
    //   725: invokevirtual 809	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   728: ifeq +44 -> 772
    //   731: aload 30
    //   733: astore 29
    //   735: iload 21
    //   737: istore 20
    //   739: iload 11
    //   741: istore 8
    //   743: iload 10
    //   745: istore 7
    //   747: iload 9
    //   749: istore 6
    //   751: aload 31
    //   753: astore 28
    //   755: aload 33
    //   757: ldc_w 806
    //   760: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   763: ifeq +505 -> 1268
    //   766: iconst_1
    //   767: istore 5
    //   769: goto +2429 -> 3198
    //   772: aload 30
    //   774: astore_0
    //   775: aload 30
    //   777: astore 29
    //   779: iload 21
    //   781: istore 20
    //   783: iload 5
    //   785: istore 8
    //   787: iload 10
    //   789: istore 7
    //   791: iload 9
    //   793: istore 6
    //   795: aload 31
    //   797: astore 28
    //   799: aload 33
    //   801: ldc_w 811
    //   804: invokevirtual 809	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   807: ifeq +36 -> 843
    //   810: aload 30
    //   812: astore 29
    //   814: iload 21
    //   816: istore 20
    //   818: iload 5
    //   820: istore 8
    //   822: iload 10
    //   824: istore 7
    //   826: iload 9
    //   828: istore 6
    //   830: aload 31
    //   832: astore 28
    //   834: aload 33
    //   836: ldc_w 811
    //   839: invokevirtual 720	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   842: astore_0
    //   843: aload_0
    //   844: astore 29
    //   846: iload 21
    //   848: istore 20
    //   850: iload 5
    //   852: istore 8
    //   854: iload 10
    //   856: istore 7
    //   858: iload 9
    //   860: istore 6
    //   862: aload 31
    //   864: astore 28
    //   866: aload 33
    //   868: ldc_w 813
    //   871: invokevirtual 809	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   874: ifeq +43 -> 917
    //   877: aload_0
    //   878: astore 29
    //   880: iload 21
    //   882: istore 20
    //   884: iload 5
    //   886: istore 8
    //   888: iload 10
    //   890: istore 7
    //   892: iload 9
    //   894: istore 6
    //   896: aload 31
    //   898: astore 28
    //   900: aload 33
    //   902: ldc_w 813
    //   905: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   908: ifeq +366 -> 1274
    //   911: iconst_1
    //   912: istore 19
    //   914: goto +2287 -> 3201
    //   917: aload_0
    //   918: astore 29
    //   920: iload 19
    //   922: istore 20
    //   924: iload 5
    //   926: istore 8
    //   928: iload 10
    //   930: istore 7
    //   932: iload 9
    //   934: istore 6
    //   936: aload 31
    //   938: astore 28
    //   940: aload 33
    //   942: ldc_w 815
    //   945: invokevirtual 809	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   948: ifeq +2244 -> 3192
    //   951: aload_0
    //   952: astore 29
    //   954: iload 19
    //   956: istore 20
    //   958: iload 5
    //   960: istore 8
    //   962: iload 10
    //   964: istore 7
    //   966: iload 9
    //   968: istore 6
    //   970: aload 31
    //   972: astore 28
    //   974: aload 33
    //   976: ldc_w 815
    //   979: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   982: istore 11
    //   984: iload 11
    //   986: ifeq +294 -> 1280
    //   989: iconst_1
    //   990: istore 20
    //   992: aload 31
    //   994: astore 28
    //   996: iload 9
    //   998: istore 6
    //   1000: iload 10
    //   1002: istore 7
    //   1004: aload 33
    //   1006: ldc_w 817
    //   1009: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1012: istore 8
    //   1014: iconst_0
    //   1015: istore 9
    //   1017: aload 33
    //   1019: ldc_w 819
    //   1022: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1025: istore 10
    //   1027: iload 10
    //   1029: istore 9
    //   1031: getstatic 50	com/tencent/smtt/sdk/TbsDownloader:f	Ljava/lang/Object;
    //   1034: astore 29
    //   1036: aload 29
    //   1038: monitorenter
    //   1039: iload 5
    //   1041: ifeq +19 -> 1060
    //   1044: aload 32
    //   1046: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1049: ldc_w 821
    //   1052: ldc 158
    //   1054: invokeinterface 285 3 0
    //   1059: pop
    //   1060: aload_0
    //   1061: invokestatic 562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1064: ifne +54 -> 1118
    //   1067: aload_0
    //   1068: invokevirtual 822	java/lang/String:length	()I
    //   1071: bipush 96
    //   1073: if_icmpne +45 -> 1118
    //   1076: new 124	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 823	java/lang/StringBuilder:<init>	()V
    //   1083: aload_0
    //   1084: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: ldc_w 825
    //   1090: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokestatic 829	com/tencent/smtt/utils/h:c	()Ljava/lang/String;
    //   1096: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: astore_0
    //   1103: aload 32
    //   1105: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1108: ldc_w 821
    //   1111: aload_0
    //   1112: invokeinterface 285 3 0
    //   1117: pop
    //   1118: aload 29
    //   1120: monitorexit
    //   1121: iload 6
    //   1123: iconst_1
    //   1124: if_icmpne +220 -> 1344
    //   1127: iload_2
    //   1128: ifeq +200 -> 1328
    //   1131: aload 32
    //   1133: bipush 146
    //   1135: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1138: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1141: astore_0
    //   1142: iload 9
    //   1144: iconst_1
    //   1145: if_icmpne +194 -> 1339
    //   1148: iconst_1
    //   1149: istore_3
    //   1150: aload_0
    //   1151: iload_3
    //   1152: invokestatic 833	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   1155: ldc 23
    //   1157: ldc_w 835
    //   1160: iload_2
    //   1161: invokestatic 550	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1164: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1167: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1170: ldc_w 701
    //   1173: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1176: iconst_0
    //   1177: ireturn
    //   1178: iconst_0
    //   1179: istore 19
    //   1181: goto -810 -> 371
    //   1184: astore_0
    //   1185: ldc_w 837
    //   1188: new 124	java/lang/StringBuilder
    //   1191: dup
    //   1192: ldc_w 839
    //   1195: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1198: aload_0
    //   1199: invokevirtual 840	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1202: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1211: goto -828 -> 383
    //   1214: iconst_0
    //   1215: istore 19
    //   1217: goto -809 -> 408
    //   1220: iconst_0
    //   1221: istore 19
    //   1223: goto -774 -> 449
    //   1226: iconst_0
    //   1227: istore 19
    //   1229: goto -739 -> 490
    //   1232: iconst_0
    //   1233: istore 19
    //   1235: goto -698 -> 537
    //   1238: astore_0
    //   1239: ldc_w 837
    //   1242: new 124	java/lang/StringBuilder
    //   1245: dup
    //   1246: ldc_w 839
    //   1249: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1252: aload_0
    //   1253: invokevirtual 840	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1256: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1262: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1265: goto -692 -> 573
    //   1268: iconst_0
    //   1269: istore 5
    //   1271: goto +1927 -> 3198
    //   1274: iconst_0
    //   1275: istore 19
    //   1277: goto +1924 -> 3201
    //   1280: iconst_0
    //   1281: istore 20
    //   1283: goto -291 -> 992
    //   1286: astore_0
    //   1287: aload 29
    //   1289: astore_0
    //   1290: iconst_1
    //   1291: istore 21
    //   1293: iload 20
    //   1295: istore 19
    //   1297: iload 8
    //   1299: istore 5
    //   1301: iload 21
    //   1303: istore 20
    //   1305: goto -301 -> 1004
    //   1308: astore 29
    //   1310: iconst_0
    //   1311: istore 8
    //   1313: goto -299 -> 1014
    //   1316: astore_0
    //   1317: aload 29
    //   1319: monitorexit
    //   1320: ldc_w 701
    //   1323: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1326: aload_0
    //   1327: athrow
    //   1328: aload 32
    //   1330: sipush -210
    //   1333: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1336: goto -198 -> 1138
    //   1339: iconst_0
    //   1340: istore_3
    //   1341: goto -191 -> 1150
    //   1344: iload 19
    //   1346: ifne +10 -> 1356
    //   1349: aload 32
    //   1351: iload 19
    //   1353: invokevirtual 843	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockEnable	(Z)V
    //   1356: iload 20
    //   1358: ifne +10 -> 1368
    //   1361: aload 32
    //   1363: iload 20
    //   1365: invokevirtual 846	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockWaitEnable	(Z)V
    //   1368: iload 8
    //   1370: iconst_1
    //   1371: if_icmpne +9 -> 1380
    //   1374: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1377: invokestatic 849	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   1380: iload 7
    //   1382: iconst_1
    //   1383: if_icmpne +22 -> 1405
    //   1386: getstatic 497	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1389: bipush 104
    //   1391: invokevirtual 502	android/os/Handler:removeMessages	(I)V
    //   1394: getstatic 497	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1397: bipush 104
    //   1399: invokestatic 508	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1402: invokevirtual 521	android/os/Message:sendToTarget	()V
    //   1405: iload 18
    //   1407: iconst_1
    //   1408: if_icmpne +1773 -> 3181
    //   1411: lload 22
    //   1413: ldc2_w 850
    //   1416: lcmp
    //   1417: ifle +1772 -> 3189
    //   1420: ldc2_w 850
    //   1423: lstore 22
    //   1425: lload 22
    //   1427: lconst_0
    //   1428: lcmp
    //   1429: ifle +1752 -> 3181
    //   1432: invokestatic 854	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1435: lconst_0
    //   1436: lcmp
    //   1437: iflt +8 -> 1445
    //   1440: invokestatic 854	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1443: lstore 22
    //   1445: aload 32
    //   1447: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1450: ldc_w 856
    //   1453: lload 22
    //   1455: invokestatic 861	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1458: invokeinterface 285 3 0
    //   1463: pop
    //   1464: iconst_0
    //   1465: istore 5
    //   1467: iconst_0
    //   1468: istore 6
    //   1470: iload_2
    //   1471: ifeq +256 -> 1727
    //   1474: aload 33
    //   1476: ldc_w 863
    //   1479: invokevirtual 712	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1482: istore 7
    //   1484: iload 7
    //   1486: istore 5
    //   1488: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1491: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1494: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1497: ldc_w 332
    //   1500: iconst_0
    //   1501: invokeinterface 319 3 0
    //   1506: istore 7
    //   1508: iload 7
    //   1510: istore 6
    //   1512: iload 5
    //   1514: istore 7
    //   1516: iload_2
    //   1517: ifeq +36 -> 1553
    //   1520: iload 5
    //   1522: istore 7
    //   1524: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1527: invokestatic 259	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1530: ifne +23 -> 1553
    //   1533: iload 5
    //   1535: istore 7
    //   1537: iload 5
    //   1539: ifne +14 -> 1553
    //   1542: invokestatic 385	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   1545: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1548: invokevirtual 388	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;)I
    //   1551: istore 7
    //   1553: ldc 23
    //   1555: ldc_w 865
    //   1558: iload 7
    //   1560: invokestatic 368	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1563: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1566: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1569: aload 32
    //   1571: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1574: ldc_w 867
    //   1577: iload 7
    //   1579: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1582: invokeinterface 285 3 0
    //   1587: pop
    //   1588: aload 32
    //   1590: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1593: ldc_w 332
    //   1596: iload 6
    //   1598: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1601: invokeinterface 285 3 0
    //   1606: pop
    //   1607: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1610: invokestatic 259	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1613: ifne +46 -> 1659
    //   1616: iload 7
    //   1618: ifle +136 -> 1754
    //   1621: iload 7
    //   1623: invokestatic 385	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   1626: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1629: invokevirtual 388	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;)I
    //   1632: if_icmpeq +122 -> 1754
    //   1635: iload 7
    //   1637: invokestatic 385	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   1640: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1643: invokevirtual 417	com/tencent/smtt/sdk/o:i	(Landroid/content/Context;)I
    //   1646: if_icmpne +108 -> 1754
    //   1649: invokestatic 385	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   1652: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1655: invokevirtual 870	com/tencent/smtt/sdk/o:n	(Landroid/content/Context;)Z
    //   1658: pop
    //   1659: aload 34
    //   1661: invokestatic 562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1664: ifeq +114 -> 1778
    //   1667: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1670: invokestatic 259	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1673: ifeq +105 -> 1778
    //   1676: aload 32
    //   1678: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1681: ldc_w 872
    //   1684: getstatic 876	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1687: invokeinterface 285 3 0
    //   1692: pop
    //   1693: aload 32
    //   1695: invokevirtual 288	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1698: iload_2
    //   1699: ifeq +12 -> 1711
    //   1702: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1705: iload 12
    //   1707: iconst_0
    //   1708: invokestatic 880	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1711: ldc 23
    //   1713: ldc_w 882
    //   1716: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1719: ldc_w 701
    //   1722: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1725: iconst_0
    //   1726: ireturn
    //   1727: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1730: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1733: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1736: ldc_w 867
    //   1739: iconst_0
    //   1740: invokeinterface 319 3 0
    //   1745: istore 7
    //   1747: iload 7
    //   1749: istore 5
    //   1751: goto -263 -> 1488
    //   1754: iload 7
    //   1756: ifne -97 -> 1659
    //   1759: invokestatic 385	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   1762: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1765: invokevirtual 886	com/tencent/smtt/sdk/o:p	(Landroid/content/Context;)Ljava/io/File;
    //   1768: invokestatic 889	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   1771: goto -112 -> 1659
    //   1774: astore_0
    //   1775: goto -116 -> 1659
    //   1778: ldc 23
    //   1780: ldc_w 891
    //   1783: iload 13
    //   1785: invokestatic 368	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1788: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1791: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1794: iload 13
    //   1796: ifne +127 -> 1923
    //   1799: aload 32
    //   1801: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1804: ldc_w 893
    //   1807: iload 13
    //   1809: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1812: invokeinterface 285 3 0
    //   1817: pop
    //   1818: aload 32
    //   1820: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1823: ldc_w 872
    //   1826: getstatic 876	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1829: invokeinterface 285 3 0
    //   1834: pop
    //   1835: iload_2
    //   1836: ifeq +56 -> 1892
    //   1839: aload 32
    //   1841: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1844: ldc_w 895
    //   1847: bipush 145
    //   1849: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1852: invokeinterface 285 3 0
    //   1857: pop
    //   1858: aload 32
    //   1860: invokevirtual 288	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1863: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1866: invokestatic 259	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1869: ifne +7 -> 1876
    //   1872: invokestatic 898	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1875: pop
    //   1876: ldc 23
    //   1878: ldc_w 900
    //   1881: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1884: ldc_w 701
    //   1887: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1890: iconst_0
    //   1891: ireturn
    //   1892: aload 32
    //   1894: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1897: ldc_w 895
    //   1900: sipush -211
    //   1903: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1906: invokeinterface 285 3 0
    //   1911: pop
    //   1912: aload 32
    //   1914: sipush -211
    //   1917: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1920: goto -62 -> 1858
    //   1923: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1926: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1929: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1932: ldc_w 415
    //   1935: iconst_0
    //   1936: invokeinterface 319 3 0
    //   1941: istore 8
    //   1943: iload 8
    //   1945: iload 12
    //   1947: if_icmple +18 -> 1965
    //   1950: getstatic 342	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/k;
    //   1953: invokevirtual 902	com/tencent/smtt/sdk/k:c	()V
    //   1956: invokestatic 385	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   1959: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1962: invokevirtual 904	com/tencent/smtt/sdk/o:o	(Landroid/content/Context;)V
    //   1965: iconst_0
    //   1966: istore 5
    //   1968: iconst_0
    //   1969: istore 7
    //   1971: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1974: invokestatic 259	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1977: ifne +63 -> 2040
    //   1980: invokestatic 385	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   1983: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1986: iconst_0
    //   1987: invokevirtual 907	com/tencent/smtt/sdk/o:e	(Landroid/content/Context;I)I
    //   1990: istore 9
    //   1992: iload 7
    //   1994: istore 5
    //   1996: iload 9
    //   1998: iload 12
    //   2000: if_icmplt +6 -> 2006
    //   2003: iconst_1
    //   2004: istore 5
    //   2006: ldc 23
    //   2008: new 124	java/lang/StringBuilder
    //   2011: dup
    //   2012: ldc_w 909
    //   2015: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2018: iload 9
    //   2020: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2023: ldc_w 911
    //   2026: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: iload 12
    //   2031: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2034: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2037: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2040: iload_1
    //   2041: iload 12
    //   2043: if_icmpge +16 -> 2059
    //   2046: aload 34
    //   2048: invokestatic 562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2051: ifne +8 -> 2059
    //   2054: iload 5
    //   2056: ifeq +276 -> 2332
    //   2059: iload 6
    //   2061: iconst_1
    //   2062: if_icmpeq +270 -> 2332
    //   2065: aload 32
    //   2067: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2070: ldc_w 872
    //   2073: getstatic 876	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2076: invokeinterface 285 3 0
    //   2081: pop
    //   2082: iload_2
    //   2083: ifeq +175 -> 2258
    //   2086: aload 34
    //   2088: invokestatic 562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2091: ifeq +90 -> 2181
    //   2094: aload 32
    //   2096: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2099: ldc_w 895
    //   2102: bipush 132
    //   2104: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2107: invokeinterface 285 3 0
    //   2112: pop
    //   2113: aload 32
    //   2115: invokevirtual 288	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2118: ldc 23
    //   2120: new 124	java/lang/StringBuilder
    //   2123: dup
    //   2124: ldc_w 913
    //   2127: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2130: iload_1
    //   2131: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2134: ldc_w 915
    //   2137: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2140: iload 12
    //   2142: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2145: ldc_w 917
    //   2148: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: iload 8
    //   2153: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2156: ldc_w 919
    //   2159: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: aload 34
    //   2164: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2170: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2173: ldc_w 701
    //   2176: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2179: iconst_0
    //   2180: ireturn
    //   2181: iload 12
    //   2183: ifgt +25 -> 2208
    //   2186: aload 32
    //   2188: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2191: ldc_w 895
    //   2194: bipush 131
    //   2196: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2199: invokeinterface 285 3 0
    //   2204: pop
    //   2205: goto -92 -> 2113
    //   2208: iload_1
    //   2209: iload 12
    //   2211: if_icmplt +25 -> 2236
    //   2214: aload 32
    //   2216: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2219: ldc_w 895
    //   2222: bipush 129
    //   2224: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2227: invokeinterface 285 3 0
    //   2232: pop
    //   2233: goto -120 -> 2113
    //   2236: aload 32
    //   2238: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2241: ldc_w 895
    //   2244: bipush 144
    //   2246: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2249: invokeinterface 285 3 0
    //   2254: pop
    //   2255: goto -142 -> 2113
    //   2258: sipush -212
    //   2261: istore 5
    //   2263: aload 34
    //   2265: invokestatic 562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2268: ifeq +37 -> 2305
    //   2271: sipush -217
    //   2274: istore 5
    //   2276: aload 32
    //   2278: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2281: ldc_w 895
    //   2284: iload 5
    //   2286: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2289: invokeinterface 285 3 0
    //   2294: pop
    //   2295: aload 32
    //   2297: iload 5
    //   2299: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2302: goto -189 -> 2113
    //   2305: iload 12
    //   2307: ifgt +11 -> 2318
    //   2310: sipush -218
    //   2313: istore 5
    //   2315: goto -39 -> 2276
    //   2318: iload_1
    //   2319: iload 12
    //   2321: if_icmplt -45 -> 2276
    //   2324: sipush -219
    //   2327: istore 5
    //   2329: goto -53 -> 2276
    //   2332: aload 34
    //   2334: aload 32
    //   2336: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2339: ldc_w 921
    //   2342: aconst_null
    //   2343: invokeinterface 309 3 0
    //   2348: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2351: ifne +45 -> 2396
    //   2354: getstatic 342	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/k;
    //   2357: invokevirtual 902	com/tencent/smtt/sdk/k:c	()V
    //   2360: aload 32
    //   2362: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2365: ldc_w 923
    //   2368: iconst_0
    //   2369: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2372: invokeinterface 285 3 0
    //   2377: pop
    //   2378: aload 32
    //   2380: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2383: ldc_w 925
    //   2386: iconst_0
    //   2387: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2390: invokeinterface 285 3 0
    //   2395: pop
    //   2396: aload 32
    //   2398: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2401: ldc_w 415
    //   2404: iload 12
    //   2406: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2409: invokeinterface 285 3 0
    //   2414: pop
    //   2415: ldc 23
    //   2417: ldc_w 927
    //   2420: iload 12
    //   2422: invokestatic 368	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2425: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2428: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2431: iload 12
    //   2433: ifle +43 -> 2476
    //   2436: iload 6
    //   2438: iconst_1
    //   2439: if_icmpne +342 -> 2781
    //   2442: aload 32
    //   2444: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2447: ldc_w 929
    //   2450: iconst_1
    //   2451: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2454: invokeinterface 285 3 0
    //   2459: pop
    //   2460: ldc 23
    //   2462: ldc_w 931
    //   2465: iload 6
    //   2467: invokestatic 368	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2470: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2473: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2476: aload 32
    //   2478: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2481: ldc_w 921
    //   2484: aload 34
    //   2486: invokeinterface 285 3 0
    //   2491: pop
    //   2492: aload 32
    //   2494: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2497: ldc_w 933
    //   2500: aload 35
    //   2502: invokeinterface 285 3 0
    //   2507: pop
    //   2508: aload 32
    //   2510: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2513: ldc_w 893
    //   2516: iload 13
    //   2518: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2521: invokeinterface 285 3 0
    //   2526: pop
    //   2527: aload 32
    //   2529: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2532: ldc_w 935
    //   2535: iload 14
    //   2537: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2540: invokeinterface 285 3 0
    //   2545: pop
    //   2546: aload 32
    //   2548: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2551: ldc_w 937
    //   2554: iload 15
    //   2556: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2559: invokeinterface 285 3 0
    //   2564: pop
    //   2565: aload 32
    //   2567: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2570: ldc_w 939
    //   2573: iload 16
    //   2575: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2578: invokeinterface 285 3 0
    //   2583: pop
    //   2584: aload 32
    //   2586: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2589: ldc_w 941
    //   2592: iload 17
    //   2594: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2597: invokeinterface 285 3 0
    //   2602: pop
    //   2603: aload 32
    //   2605: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2608: ldc_w 943
    //   2611: lload 24
    //   2613: invokestatic 861	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2616: invokeinterface 285 3 0
    //   2621: pop
    //   2622: aload 32
    //   2624: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2627: ldc_w 945
    //   2630: lload 26
    //   2632: invokestatic 861	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2635: invokeinterface 285 3 0
    //   2640: pop
    //   2641: aload 32
    //   2643: invokevirtual 288	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2646: aload 28
    //   2648: ifnull +19 -> 2667
    //   2651: aload 32
    //   2653: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2656: ldc_w 947
    //   2659: aload 28
    //   2661: invokeinterface 285 3 0
    //   2666: pop
    //   2667: iload_3
    //   2668: ifne +165 -> 2833
    //   2671: iload 4
    //   2673: ifeq +160 -> 2833
    //   2676: invokestatic 385	com/tencent/smtt/sdk/o:a	()Lcom/tencent/smtt/sdk/o;
    //   2679: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2682: iload 12
    //   2684: invokevirtual 949	com/tencent/smtt/sdk/o:b	(Landroid/content/Context;I)Z
    //   2687: ifeq +146 -> 2833
    //   2690: iload_2
    //   2691: ifeq +111 -> 2802
    //   2694: aload 32
    //   2696: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2699: ldc_w 895
    //   2702: bipush 143
    //   2704: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2707: invokeinterface 285 3 0
    //   2712: pop
    //   2713: aload 32
    //   2715: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2718: ldc_w 872
    //   2721: getstatic 876	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2724: invokeinterface 285 3 0
    //   2729: pop
    //   2730: ldc 23
    //   2732: ldc_w 951
    //   2735: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2738: aload 33
    //   2740: ldc_w 953
    //   2743: iconst_0
    //   2744: invokevirtual 751	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2747: iconst_1
    //   2748: if_icmpne +20 -> 2768
    //   2751: aload 32
    //   2753: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2756: ldc_w 955
    //   2759: getstatic 958	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2762: invokeinterface 285 3 0
    //   2767: pop
    //   2768: aload 32
    //   2770: invokevirtual 288	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2773: ldc_w 701
    //   2776: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2779: iconst_1
    //   2780: ireturn
    //   2781: aload 32
    //   2783: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2786: ldc_w 929
    //   2789: iconst_0
    //   2790: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2793: invokeinterface 285 3 0
    //   2798: pop
    //   2799: goto -339 -> 2460
    //   2802: aload 32
    //   2804: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2807: ldc_w 895
    //   2810: sipush -213
    //   2813: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2816: invokeinterface 285 3 0
    //   2821: pop
    //   2822: aload 32
    //   2824: sipush -213
    //   2827: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2830: goto -117 -> 2713
    //   2833: iload_3
    //   2834: ifne +151 -> 2985
    //   2837: iload 4
    //   2839: ifeq +146 -> 2985
    //   2842: getstatic 342	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/k;
    //   2845: astore_0
    //   2846: iload 13
    //   2848: iconst_1
    //   2849: if_icmpeq +9 -> 2858
    //   2852: iload 13
    //   2854: iconst_2
    //   2855: if_icmpne +108 -> 2963
    //   2858: iconst_1
    //   2859: istore 4
    //   2861: aload_0
    //   2862: iload_3
    //   2863: iload 4
    //   2865: invokevirtual 961	com/tencent/smtt/sdk/k:a	(ZZ)Z
    //   2868: ifeq +117 -> 2985
    //   2871: aload 32
    //   2873: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2876: ldc_w 872
    //   2879: getstatic 876	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2882: invokeinterface 285 3 0
    //   2887: pop
    //   2888: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2891: invokestatic 654	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2894: invokevirtual 658	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2897: astore_0
    //   2898: aload_0
    //   2899: bipush 100
    //   2901: invokevirtual 663	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2904: aload_0
    //   2905: new 124	java/lang/StringBuilder
    //   2908: dup
    //   2909: ldc_w 963
    //   2912: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2915: getstatic 342	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/k;
    //   2918: getfield 965	com/tencent/smtt/sdk/k:a	Ljava/lang/String;
    //   2921: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2924: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2927: invokevirtual 666	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2930: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2933: invokestatic 967	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2936: ifeq +33 -> 2969
    //   2939: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2942: invokestatic 654	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2945: getstatic 970	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2948: aload_0
    //   2949: invokevirtual 676	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2952: ldc 23
    //   2954: ldc_w 972
    //   2957: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2960: goto -222 -> 2738
    //   2963: iconst_0
    //   2964: istore 4
    //   2966: goto -105 -> 2861
    //   2969: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2972: invokestatic 654	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2975: getstatic 672	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2978: aload_0
    //   2979: invokevirtual 676	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2982: goto -30 -> 2952
    //   2985: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2988: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2991: getfield 301	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2994: ldc_w 929
    //   2997: iconst_0
    //   2998: invokeinterface 319 3 0
    //   3003: iconst_1
    //   3004: if_icmpne +120 -> 3124
    //   3007: getstatic 342	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/k;
    //   3010: invokevirtual 974	com/tencent/smtt/sdk/k:a	()Z
    //   3013: ifeq +111 -> 3124
    //   3016: aload 32
    //   3018: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3021: ldc_w 872
    //   3024: getstatic 876	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3027: invokeinterface 285 3 0
    //   3032: pop
    //   3033: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3036: invokestatic 654	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3039: invokevirtual 658	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3042: astore_0
    //   3043: aload_0
    //   3044: bipush 100
    //   3046: invokevirtual 663	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   3049: aload_0
    //   3050: new 124	java/lang/StringBuilder
    //   3053: dup
    //   3054: ldc_w 976
    //   3057: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3060: getstatic 342	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/k;
    //   3063: getfield 965	com/tencent/smtt/sdk/k:a	Ljava/lang/String;
    //   3066: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3069: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3072: invokevirtual 666	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   3075: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3078: invokestatic 967	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   3081: ifeq +27 -> 3108
    //   3084: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3087: invokestatic 654	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3090: getstatic 970	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3093: aload_0
    //   3094: invokevirtual 676	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3097: ldc 23
    //   3099: ldc_w 978
    //   3102: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3105: goto -367 -> 2738
    //   3108: getstatic 67	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3111: invokestatic 654	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3114: getstatic 672	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3117: aload_0
    //   3118: invokevirtual 676	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3121: goto -24 -> 3097
    //   3124: iload_2
    //   3125: ifne +11 -> 3136
    //   3128: aload 32
    //   3130: sipush -216
    //   3133: invokevirtual 532	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3136: aload 32
    //   3138: getfield 277	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3141: ldc_w 872
    //   3144: getstatic 958	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   3147: invokeinterface 285 3 0
    //   3152: pop
    //   3153: ldc 23
    //   3155: ldc_w 980
    //   3158: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3161: goto -423 -> 2738
    //   3164: astore_0
    //   3165: goto -1653 -> 1512
    //   3168: astore_0
    //   3169: goto -1681 -> 1488
    //   3172: astore 29
    //   3174: goto -2143 -> 1031
    //   3177: astore_0
    //   3178: goto -2874 -> 304
    //   3181: ldc2_w 981
    //   3184: lstore 22
    //   3186: goto -1754 -> 1432
    //   3189: goto -1764 -> 1425
    //   3192: iconst_1
    //   3193: istore 20
    //   3195: goto -2203 -> 992
    //   3198: goto -2426 -> 772
    //   3201: goto -2284 -> 917
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3204	0	paramString	String
    //   0	3204	1	paramInt	int
    //   0	3204	2	paramBoolean1	boolean
    //   0	3204	3	paramBoolean2	boolean
    //   0	3204	4	paramBoolean3	boolean
    //   110	2218	5	m	int
    //   298	2168	6	n	int
    //   612	1381	7	i1	int
    //   608	1544	8	i2	int
    //   577	1442	9	i3	int
    //   580	448	10	i4	int
    //   583	402	11	i5	int
    //   203	2480	12	i6	int
    //   171	2685	13	i7	int
    //   213	2323	14	i8	int
    //   223	2332	15	i9	int
    //   233	2341	16	i10	int
    //   243	2350	17	i11	int
    //   285	1124	18	i12	int
    //   369	983	19	bool1	boolean
    //   604	2590	20	bool2	boolean
    //   589	713	21	bool3	boolean
    //   274	2911	22	l1	long
    //   253	2359	24	l2	long
    //   263	2368	26	l3	long
    //   360	2300	28	localObject1	Object
    //   600	688	29	localObject2	Object
    //   1308	10	29	localException1	Exception
    //   3172	1	29	localException2	Exception
    //   596	215	30	str1	String
    //   626	367	31	str2	String
    //   45	3092	32	localTbsDownloadConfig	TbsDownloadConfig
    //   100	2639	33	localJSONObject	JSONObject
    //   181	2304	34	str3	String
    //   193	2308	35	str4	String
    // Exception table:
    //   from	to	target	type
    //   342	362	1184	java/lang/Throwable
    //   371	383	1184	java/lang/Throwable
    //   387	398	1238	java/lang/Throwable
    //   408	439	1238	java/lang/Throwable
    //   449	480	1238	java/lang/Throwable
    //   490	526	1238	java/lang/Throwable
    //   537	573	1238	java/lang/Throwable
    //   618	628	1286	java/lang/Exception
    //   652	662	1286	java/lang/Exception
    //   686	696	1286	java/lang/Exception
    //   720	731	1286	java/lang/Exception
    //   755	766	1286	java/lang/Exception
    //   799	810	1286	java/lang/Exception
    //   834	843	1286	java/lang/Exception
    //   866	877	1286	java/lang/Exception
    //   900	911	1286	java/lang/Exception
    //   940	951	1286	java/lang/Exception
    //   974	984	1286	java/lang/Exception
    //   1004	1014	1308	java/lang/Exception
    //   1044	1060	1316	finally
    //   1060	1118	1316	finally
    //   1118	1121	1316	finally
    //   1317	1320	1316	finally
    //   1759	1771	1774	java/lang/Throwable
    //   1488	1508	3164	java/lang/Exception
    //   1474	1484	3168	java/lang/Exception
    //   1727	1747	3168	java/lang/Exception
    //   1017	1027	3172	java/lang/Exception
    //   290	300	3177	java/lang/Exception
  }
  
  protected static File b(int paramInt)
  {
    AppMethodBeat.i(54150);
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject = null;
    int n = arrayOfString.length;
    int m = 0;
    for (;;)
    {
      String str1;
      if (m < n)
      {
        str1 = arrayOfString[m];
        String str2 = f.a(c, str1, 4, false);
        if (!getOverSea(c)) {
          break label115;
        }
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str2, (String)localObject);
        if ((!((File)localObject).exists()) || (a.a(c, (File)localObject) != paramInt)) {
          break label123;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
      }
      for (;;)
      {
        AppMethodBeat.o(54150);
        return localObject;
        label115:
        localObject = getBackupFileName(false);
        break;
        label123:
        localObject = new File(f.a(c, str1, 4, false), "x5.tbs.decouple");
        if ((!((File)localObject).exists()) || (a.a(c, (File)localObject) != paramInt)) {
          break label188;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
      }
      label188:
      m += 1;
    }
  }
  
  static String b(Context paramContext)
  {
    AppMethodBeat.i(54146);
    if (!TextUtils.isEmpty(b))
    {
      paramContext = b;
      AppMethodBeat.o(54146);
      return paramContext;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuffer = new StringBuffer();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str;
        continue;
        if (paramContext.length() > 0)
        {
          localStringBuffer.append(paramContext);
        }
        else
        {
          localStringBuffer.append("1.0");
          continue;
          localStringBuffer.append("en");
        }
      }
    }
    if (paramContext == null)
    {
      localStringBuffer.append("1.0");
      localStringBuffer.append("; ");
      paramContext = localLocale.getLanguage();
      if (paramContext == null) {
        break label272;
      }
      localStringBuffer.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(paramContext.toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = Build.MODEL;
      }
    }
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        if (paramContext.length() > 0)
        {
          localStringBuffer.append("; ");
          localStringBuffer.append(paramContext);
          continue;
          paramContext = Build.ID;
          continue;
          if (paramContext.length() > 0)
          {
            localStringBuffer.append(" Build/");
            localStringBuffer.append(paramContext);
          }
        }
      }
    }
    if (paramContext == null)
    {
      localStringBuffer.append("; ");
      if (Build.ID != null) {
        break label311;
      }
      paramContext = "";
      paramContext = paramContext.replaceAll("[一-龥]", "");
      if (paramContext != null) {
        break label318;
      }
      localStringBuffer.append(" Build/");
      localStringBuffer.append("00");
      paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
      b = paramContext;
      AppMethodBeat.o(54146);
      return paramContext;
    }
  }
  
  private static void b(JSONArray paramJSONArray)
  {
    int i1 = 0;
    AppMethodBeat.i(54138);
    int i2;
    int m;
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      i2 = o.a().a(TbsShareManager.getHostCorePathAppDefined());
      m = 0;
    }
    for (;;)
    {
      int n = i1;
      if (m < paramJSONArray.length())
      {
        if (paramJSONArray.optInt(m) == i2) {
          n = 1;
        }
      }
      else
      {
        if (n == 0) {
          paramJSONArray.put(i2);
        }
        AppMethodBeat.o(54138);
        return;
      }
      m += 1;
    }
  }
  
  private static boolean b(final boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(54143);
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(144));
      ((TbsDownloadUpload)localObject1).commit();
      if ((QbSdk.mSettings == null) || (!QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) || (!QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false"))) {
        break label216;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      if (!paramBoolean1) {
        break label176;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(145));
      ((TbsDownloadUpload)localObject1).commit();
    }
    for (;;)
    {
      AppMethodBeat.o(54143);
      return false;
      if (paramBoolean3) {
        break;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(164));
      ((TbsDownloadUpload)localObject1).commit();
      break;
      label176:
      if (!paramBoolean3)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(165));
        ((TbsDownloadUpload)localObject1).commit();
      }
    }
    label216:
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    if (o.a().c(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
      if (paramBoolean1)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(146));
        ((TbsDownloadUpload)localObject1).commit();
      }
      for (;;)
      {
        AppMethodBeat.o(54143);
        return false;
        if (!paramBoolean3)
        {
          localObject1 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(166));
          ((TbsDownloadUpload)localObject1).commit();
        }
      }
    }
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    Object localObject2 = f.a(c, 1);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    }
    for (;;)
    {
      localObject2 = new File((String)localObject2, (String)localObject1);
      Object localObject3 = f.a(c, 2);
      label417:
      label452:
      label487:
      int n;
      if (getOverSea(c))
      {
        localObject1 = "x5.oversea.tbs.org";
        localObject3 = new File((String)localObject3, (String)localObject1);
        Object localObject4 = f.a(c, 3);
        if (!getOverSea(c)) {
          break label1026;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject4 = new File((String)localObject4, (String)localObject1);
        String str2 = f.a(c, 4);
        if (!getOverSea(c)) {
          break label1035;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(str2, (String)localObject1);
        if (!((File)localObject1).exists())
        {
          if (!((File)localObject4).exists()) {
            break label1044;
          }
          ((File)localObject4).renameTo((File)localObject1);
        }
        label524:
        if (e == null)
        {
          e = b.a();
          localTbsDownloadConfig.mSyncMap.put("device_cpuabi", e);
          localTbsDownloadConfig.commit();
        }
        n = 0;
        m = n;
        if (!TextUtils.isEmpty(e)) {
          localObject1 = null;
        }
      }
      try
      {
        localObject2 = Pattern.compile("i686|mips|x86_64").matcher(e);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        label595:
        break label595;
      }
      int m = n;
      if (localObject1 != null)
      {
        m = n;
        if (((Matcher)localObject1).find())
        {
          if (!TbsShareManager.isThirdPartyApp(c)) {
            break label1101;
          }
          TbsLog.e("TbsDownload", "don't support x86 devices,skip send request");
          localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
          if (!paramBoolean1) {
            break label1082;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
          label662:
          ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail("mycpu is " + e);
          TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
          label700:
          m = 1;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("app_versionname", b.a(c));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.b(c)));
      localTbsDownloadConfig.commit();
      localObject1 = a(paramBoolean1, paramBoolean2, paramBoolean3);
      try
      {
        n = ((JSONObject)localObject1).getInt("TBSV");
        if ((m != 0) || (n != -1))
        {
          long l2 = System.currentTimeMillis();
          if (TbsShareManager.isThirdPartyApp(c))
          {
            l1 = localTbsDownloadConfig.mPreferences.getLong("request_fail", 0L);
            long l3 = localTbsDownloadConfig.mPreferences.getLong("count_request_fail_in_24hours", 0L);
            if (l2 - l1 < localTbsDownloadConfig.getRetryInterval() * 1000L)
            {
              l1 = 1L + l3;
              localTbsDownloadConfig.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(l1));
            }
          }
          else
          {
            localTbsDownloadConfig.mSyncMap.put("request_fail", Long.valueOf(l2));
            localTbsDownloadConfig.mSyncMap.put("app_versionname", b.a(c));
            localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.b(c)));
            localTbsDownloadConfig.mSyncMap.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            localTbsDownloadConfig.commit();
            if (m == 0) {
              break label1180;
            }
            if (!paramBoolean1) {
              break label1140;
            }
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(147));
            ((TbsDownloadUpload)localObject1).commit();
            AppMethodBeat.o(54143);
            return false;
            localObject1 = getBackupFileName(false);
            continue;
            localObject1 = getBackupFileName(false);
            break label417;
            label1026:
            localObject1 = getBackupFileName(false);
            break label452;
            label1035:
            localObject1 = getBackupFileName(false);
            break label487;
            label1044:
            if (((File)localObject3).exists())
            {
              ((File)localObject3).renameTo((File)localObject1);
              break label524;
            }
            if (!((File)localObject2).exists()) {
              break label524;
            }
            ((File)localObject2).renameTo((File)localObject1);
            break label524;
            label1082:
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
            ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
            break label662;
            label1101:
            if (paramBoolean1)
            {
              localTbsDownloadConfig.setDownloadInterruptCode(-104);
              break label700;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          n = -1;
          continue;
          long l1 = 1L;
          continue;
          label1140:
          if (!paramBoolean3)
          {
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(167));
            ((TbsDownloadUpload)localObject1).commit();
          }
        }
        label1180:
        if ((n != -1) || (paramBoolean3)) {}
        for (;;)
        {
          try
          {
            String str1 = n.a(c).d();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=".concat(String.valueOf(str1)));
            if (!paramBoolean1) {
              continue;
            }
            localObject3 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_code", Integer.valueOf(148));
            ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_sent", Integer.valueOf(1));
            ((TbsDownloadUpload)localObject3).commit();
            TbsLog.i("TbsDownload", "sendRequest query 148");
            paramBoolean2 = a(g.a(str1, ((JSONObject)localObject1).toString().getBytes("utf-8"), new g.a()
            {
              public final void a(int paramAnonymousInt)
              {
                AppMethodBeat.i(54985);
                long l = System.currentTimeMillis();
                this.a.mSyncMap.put("last_check", Long.valueOf(l));
                this.a.commit();
                TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=".concat(String.valueOf(paramAnonymousInt)));
                if ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (paramAnonymousInt == 200))
                {
                  this.a.mSyncMap.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
                  this.a.mSyncMap.put("request_fail", Long.valueOf(0L));
                  this.a.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(0L));
                  this.a.commit();
                }
                if (paramAnonymousInt >= 300)
                {
                  if (paramBoolean1)
                  {
                    this.a.setDownloadInterruptCode(-107);
                    AppMethodBeat.o(54985);
                    return;
                  }
                  this.a.setDownloadInterruptCode(-207);
                }
                AppMethodBeat.o(54985);
              }
            }, false), n, paramBoolean1, paramBoolean2, paramBoolean4);
            paramBoolean1 = paramBoolean2;
          }
          catch (Throwable localThrowable)
          {
            if (!paramBoolean1) {
              continue;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-106);
            paramBoolean1 = false;
            continue;
            localTbsDownloadConfig.setDownloadInterruptCode(-206);
            paramBoolean1 = false;
            continue;
          }
          AppMethodBeat.o(54143);
          return paramBoolean1;
          if (!paramBoolean3)
          {
            localObject3 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_code", Integer.valueOf(168));
            ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_sent", Integer.valueOf(1));
            ((TbsDownloadUpload)localObject3).commit();
            TbsLog.i("TbsDownload", "sendRequest download 168");
            continue;
            TbsDownloadUpload localTbsDownloadUpload;
            if (paramBoolean1)
            {
              localTbsDownloadUpload = TbsDownloadUpload.getInstance(c);
              localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(149));
              localTbsDownloadUpload.commit();
              paramBoolean1 = false;
            }
            else
            {
              if (!paramBoolean3)
              {
                localTbsDownloadUpload = TbsDownloadUpload.getInstance(c);
                localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(169));
                localTbsDownloadUpload.commit();
              }
              paramBoolean1 = false;
            }
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  static void c(Context paramContext)
  {
    AppMethodBeat.i(54147);
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    k.c(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      localSharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT < 11) {
        break label111;
      }
    }
    label111:
    for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      paramContext.edit().clear().commit();
      AppMethodBeat.o(54147);
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  private static void c(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(54140);
    String str;
    int i2;
    Context localContext;
    if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore())
    {
      String[] arrayOfString = f();
      int i1 = arrayOfString.length;
      int m = 0;
      for (;;)
      {
        if (m < i1)
        {
          str = arrayOfString[m];
          i2 = TbsShareManager.getBackupCoreVersion(c, str);
          if (i2 > 0)
          {
            localContext = TbsShareManager.getPackageContext(c, str, false);
            if ((localContext != null) && (!o.a().f(localContext)))
            {
              TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
              m += 1;
              continue;
            }
            n = 0;
            label107:
            if (n >= paramJSONArray.length()) {
              break label261;
            }
            if (paramJSONArray.optInt(n) != i2) {
              break label199;
            }
          }
        }
      }
    }
    label259:
    label261:
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        paramJSONArray.put(i2);
      }
      i2 = TbsShareManager.getBackupDecoupleCoreVersion(c, str);
      if (i2 <= 0) {
        break;
      }
      localContext = TbsShareManager.getPackageContext(c, str, false);
      if ((localContext != null) && (!o.a().f(localContext)))
      {
        TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
        break;
        label199:
        n += 1;
        break label107;
      }
      n = 0;
      label208:
      if (n < paramJSONArray.length()) {
        if (paramJSONArray.optInt(n) != i2) {}
      }
      for (n = 1;; n = 0)
      {
        if (n != 0) {
          break label259;
        }
        paramJSONArray.put(i2);
        break;
        n += 1;
        break label208;
        AppMethodBeat.o(54140);
        return;
      }
      break;
    }
  }
  
  private static boolean c()
  {
    AppMethodBeat.i(54115);
    try
    {
      String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        int i1 = TbsShareManager.getSharedTbsCoreVersion(c, str);
        if (i1 > 0)
        {
          AppMethodBeat.o(54115);
          return true;
        }
        m += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54115);
    }
  }
  
  private static void d()
  {
    try
    {
      AppMethodBeat.i(54133);
      if (h == null) {
        h = m.a();
      }
      try
      {
        g = new k(c);
        d = new Handler(h.getLooper())
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            boolean bool3 = true;
            AppMethodBeat.i(55112);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(55112);
              return;
              label80:
              boolean bool1;
              if (paramAnonymousMessage.arg1 == 1)
              {
                i = 1;
                if (paramAnonymousMessage.arg2 != 1) {
                  break label254;
                }
                bool1 = true;
                label90:
                bool1 = TbsDownloader.a(true, false, false, bool1);
                if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
                {
                  TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=".concat(String.valueOf(bool1)));
                  localObject2 = "";
                  localObject1 = localObject2;
                  if (TbsDownloader.a() != null)
                  {
                    localObject1 = localObject2;
                    if (TbsDownloader.a().getApplicationContext() != null)
                    {
                      localObject1 = localObject2;
                      if (TbsDownloader.a().getApplicationContext().getApplicationInfo() != null) {
                        localObject1 = TbsDownloader.a().getApplicationContext().getApplicationInfo().packageName;
                      }
                    }
                  }
                  if ((bool1) && (i == 0)) {
                    break label259;
                  }
                  ((TbsDownloader.TbsDownloaderCallback)paramAnonymousMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
                }
              }
              while ((TbsShareManager.isThirdPartyApp(TbsDownloader.a())) && (bool1))
              {
                TbsDownloader.startDownload(TbsDownloader.a());
                AppMethodBeat.o(55112);
                return;
                i = 0;
                break label80;
                label254:
                bool1 = false;
                break label90;
                label259:
                if (("com.tencent.mm".equals(localObject1)) || ("com.tencent.mobileqq".equals(localObject1)))
                {
                  TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = ".concat(String.valueOf(bool1)));
                  ((TbsDownloader.TbsDownloaderCallback)paramAnonymousMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
                }
              }
              Object localObject1 = null;
              Object localObject3 = null;
              Object localObject2 = localObject3;
              if (!TbsShareManager.isThirdPartyApp(TbsDownloader.a()))
              {
                localObject1 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0) + ".txt";
                localObject1 = f.b(TbsDownloader.a(), false, (String)localObject1);
                if (localObject1 != null)
                {
                  localObject3 = f.a(TbsDownloader.a(), (FileOutputStream)localObject1);
                  localObject2 = localObject3;
                  if (localObject3 == null)
                  {
                    QbSdk.l.onDownloadFinish(177);
                    TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                    TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-203);
                    TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                    AppMethodBeat.o(55112);
                  }
                }
                else
                {
                  localObject2 = localObject3;
                  if (f.a(TbsDownloader.a()))
                  {
                    TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
                    TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                    AppMethodBeat.o(55112);
                    return;
                  }
                }
              }
              boolean bool2;
              if (paramAnonymousMessage.arg1 == 1)
              {
                bool1 = true;
                localObject3 = TbsDownloadConfig.getInstance(TbsDownloader.a());
                if (108 != paramAnonymousMessage.what) {
                  break label617;
                }
                bool2 = true;
                label530:
                if (!TbsDownloader.a(false, bool1, bool2, true)) {
                  break label699;
                }
                if ((!bool1) || (!o.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0)))) {
                  break label623;
                }
                QbSdk.l.onDownloadFinish(122);
                ((TbsDownloadConfig)localObject3).setDownloadInterruptCode(-213);
              }
              for (;;)
              {
                TbsLog.i("TbsDownload", "------freeFileLock called :");
                f.a((FileLock)localObject2, (FileOutputStream)localObject1);
                AppMethodBeat.o(55112);
                return;
                bool1 = false;
                break;
                label617:
                bool2 = false;
                break label530;
                label623:
                if (((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false))
                {
                  TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-215);
                  localObject3 = TbsDownloader.b();
                  if (108 == paramAnonymousMessage.what) {}
                  for (bool2 = bool3;; bool2 = false)
                  {
                    ((k)localObject3).b(bool1, bool2);
                    break;
                  }
                }
                QbSdk.l.onDownloadFinish(110);
                continue;
                label699:
                QbSdk.l.onDownloadFinish(110);
              }
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
              if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {}
              for (int i = TbsShareManager.a(TbsDownloader.a(), false);; i = o.a().m(TbsDownloader.a()))
              {
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=".concat(String.valueOf(i)));
                TbsDownloader.b().a(i);
                TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
                AppMethodBeat.o(55112);
                return;
              }
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
              TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
              AppMethodBeat.o(55112);
              return;
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
              if (paramAnonymousMessage.arg1 == 0)
              {
                o.a().a((Context)paramAnonymousMessage.obj, true);
                AppMethodBeat.o(55112);
                return;
              }
              o.a().a((Context)paramAnonymousMessage.obj, false);
            }
          }
        };
        AppMethodBeat.o(54133);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
          AppMethodBeat.o(54133);
        }
      }
      return;
    }
    finally {}
  }
  
  private static boolean e()
  {
    AppMethodBeat.i(54135);
    try
    {
      JSONArray localJSONArray = g();
      boolean bool = TbsDownloadConfig.getInstance(c).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      AppMethodBeat.o(54135);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54135);
    }
    return false;
  }
  
  private static String[] f()
  {
    AppMethodBeat.i(54136);
    Object localObject;
    if (QbSdk.getOnlyDownload())
    {
      localObject = new String[1];
      localObject[0] = c.getApplicationContext().getPackageName();
    }
    for (;;)
    {
      AppMethodBeat.o(54136);
      return localObject;
      localObject = TbsShareManager.getCoreProviderAppList();
      String str = c.getApplicationContext().getPackageName();
      if (str.equals(TbsShareManager.f(c)))
      {
        int m = localObject.length;
        String[] arrayOfString = new String[m + 1];
        System.arraycopy(localObject, 0, arrayOfString, 0, m);
        arrayOfString[m] = str;
        localObject = arrayOfString;
      }
    }
  }
  
  private static JSONArray g()
  {
    AppMethodBeat.i(54139);
    if (TbsShareManager.isThirdPartyApp(c))
    {
      JSONArray localJSONArray = new JSONArray();
      a(localJSONArray);
      c(localJSONArray);
      b(localJSONArray);
      AppMethodBeat.o(54139);
      return localJSONArray;
    }
    AppMethodBeat.o(54139);
    return null;
  }
  
  public static String getBackupFileName(boolean paramBoolean)
  {
    AppMethodBeat.i(54114);
    if (paramBoolean)
    {
      if (b.c())
      {
        AppMethodBeat.o(54114);
        return "x5.tbs.decouple.64";
      }
      AppMethodBeat.o(54114);
      return "x5.tbs.decouple";
    }
    if (b.c())
    {
      AppMethodBeat.o(54114);
      return "x5.tbs.org.64";
    }
    AppMethodBeat.o(54114);
    return "x5.tbs.org";
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    AppMethodBeat.i(54127);
    int m = o.a().h(c);
    AppMethodBeat.o(54127);
    return m;
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    AppMethodBeat.i(54126);
    int m = o.a().h(paramContext);
    AppMethodBeat.o(54126);
    return m;
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(54142);
      if (!k)
      {
        k = true;
        paramContext = TbsDownloadConfig.getInstance(paramContext);
        if (paramContext.mPreferences.contains("is_oversea"))
        {
          j = paramContext.mPreferences.getBoolean("is_oversea", false);
          TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + j);
      }
      boolean bool = j;
      AppMethodBeat.o(54142);
      return bool;
    }
    finally {}
  }
  
  public static long getRetryIntervalInSeconds()
  {
    return l;
  }
  
  public static HandlerThread getsTbsHandlerThread()
  {
    return h;
  }
  
  private static boolean h()
  {
    AppMethodBeat.i(54148);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-115);
      AppMethodBeat.o(54148);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-116);
      AppMethodBeat.o(54148);
      return false;
    }
    if (!f.b(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-117);
      AppMethodBeat.o(54148);
      return false;
    }
    if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l1 = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=".concat(String.valueOf(l1)));
      if (l1 >= localTbsDownloadConfig.getDownloadMaxflow())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        localTbsDownloadConfig.setDownloadInterruptCode(-120);
        AppMethodBeat.o(54148);
        return false;
      }
    }
    AppMethodBeat.o(54148);
    return true;
  }
  
  public static boolean isDownloadForeground()
  {
    AppMethodBeat.i(54132);
    if ((g != null) && (g.d()))
    {
      AppMethodBeat.o(54132);
      return true;
    }
    AppMethodBeat.o(54132);
    return false;
  }
  
  public static boolean isDownloading()
  {
    try
    {
      AppMethodBeat.i(54131);
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + a);
      boolean bool = a;
      AppMethodBeat.o(54131);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(54120);
    paramBoolean = needDownload(paramContext, paramBoolean, false, true, null);
    AppMethodBeat.o(54120);
    return paramBoolean;
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    AppMethodBeat.i(54121);
    paramBoolean1 = needDownload(paramContext, paramBoolean1, paramBoolean2, true, paramTbsDownloaderCallback);
    AppMethodBeat.o(54121);
    return paramBoolean1;
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    AppMethodBeat.i(54122);
    TbsOneGreyInfoHelper.initExtension(paramContext);
    TbsLog.i("TbsDownload", "current Process=" + QbSdk.getCurrentProcessName(paramContext) + ",oneEnable=" + TbsOneGreyInfoHelper.isTbsOneModeEnable(paramContext) + Log.getStackTraceString(new Throwable()));
    if (TbsOneGreyInfoHelper.isTbsOneModeEnable(paramContext))
    {
      TbsOneGreyInfoHelper.a(paramContext).setAutoUpdateEnabled(true);
      if (!TbsOneGreyInfoHelper.a(paramContext).isComponentInstalled("x5webview")) {
        TbsOneGreyInfoHelper.a(paramContext).installComponent("x5webview", new TBSOneCallback()
        {
          public final void a(File paramAnonymousFile)
          {
            AppMethodBeat.i(55107);
            TbsLog.i("TbsDownloader", "x5webview onCompleted,onCompleted=".concat(String.valueOf(paramAnonymousFile)));
            AppMethodBeat.o(55107);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(55106);
            TbsLog.i("TbsDownloader", "onError,i=" + paramAnonymousInt + ",str=" + paramAnonymousString);
            AppMethodBeat.o(55106);
          }
          
          public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(55105);
            TbsLog.i("TbsDownloader", "onProgressChanged,i=" + paramAnonymousInt1 + ",i1=" + paramAnonymousInt2);
            AppMethodBeat.o(55105);
          }
        });
      }
      if (!TbsOneGreyInfoHelper.a(paramContext).isComponentInstalled("file")) {
        TbsOneGreyInfoHelper.a(paramContext).installComponent("file", new TBSOneCallback()
        {
          public final void a(File paramAnonymousFile)
          {
            AppMethodBeat.i(55211);
            TbsLog.i("TbsDownloader", "file install onCompleted,onCompleted=".concat(String.valueOf(paramAnonymousFile)));
            AppMethodBeat.o(55211);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(55212);
            TbsLog.i("TbsDownloader", "file onError,i=" + paramAnonymousInt + ",str=" + paramAnonymousString);
            AppMethodBeat.o(55212);
          }
        });
      }
      AppMethodBeat.o(54122);
      return false;
    }
    TbsLog.i("TbsDownload", "needDownload,process=" + QbSdk.getCurrentProcessName(paramContext) + "stack=" + Log.getStackTraceString(new Throwable()));
    TbsDownloadUpload.clear();
    TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
    localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(140));
    localTbsDownloadUpload.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] oversea=" + paramBoolean1 + ",isDownloadForeground=" + paramBoolean2);
    boolean bool1 = false;
    TbsLog.initIfNeed(paramContext);
    if (o.b)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#1,return false");
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(171));
      localTbsDownloadUpload.commit();
      AppMethodBeat.o(54122);
      return false;
    }
    TbsLog.app_extra("TbsDownload", paramContext);
    Object localObject = paramContext.getApplicationContext();
    c = (Context)localObject;
    localObject = TbsDownloadConfig.getInstance((Context)localObject);
    ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-100);
    if (!a(c, paramBoolean1))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#2,return false");
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(141));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(172));
      localTbsDownloadUpload.commit();
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      AppMethodBeat.o(54122);
      return false;
    }
    d();
    if (i)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-105);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#3,return false");
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(142));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(173));
      localTbsDownloadUpload.commit();
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      AppMethodBeat.o(54122);
      return false;
    }
    boolean bool2 = a(c, paramBoolean2, false);
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],needSendRequest=".concat(String.valueOf(bool2)));
    if (bool2)
    {
      a(paramBoolean2, paramTbsDownloaderCallback, paramBoolean3);
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-114);
      d.removeMessages(102);
      Message.obtain(d, 102).sendToTarget();
      paramBoolean2 = false;
      if (!QbSdk.c)
      {
        paramBoolean1 = bool1;
        if (TbsShareManager.isThirdPartyApp(paramContext)) {}
      }
      else
      {
        paramBoolean2 = ((TbsDownloadConfig)localObject).mPreferences.contains("tbs_needdownload");
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=".concat(String.valueOf(paramBoolean2)));
        if ((paramBoolean2) || (TbsShareManager.isThirdPartyApp(paramContext))) {
          break label834;
        }
        paramBoolean1 = true;
      }
      label677:
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (!paramBoolean1) {
        break label870;
      }
      if (h()) {
        break label852;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
      paramBoolean1 = false;
      label729:
      if ((!bool2) && (paramTbsDownloaderCallback != null)) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=".concat(String.valueOf(paramBoolean1)));
      paramContext = localTbsDownloadUpload.a;
      if (!paramBoolean1) {
        break label998;
      }
    }
    label834:
    label852:
    label998:
    for (int m = 170;; m = 174)
    {
      paramContext.put("tbs_needdownload_return", Integer.valueOf(m));
      localTbsDownloadUpload.commit();
      AppMethodBeat.o(54122);
      return paramBoolean1;
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(143));
      localTbsDownloadUpload.commit();
      break;
      paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.getBoolean("tbs_needdownload", false);
      break label677;
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-118);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      break label729;
      label870:
      m = o.a().m(c);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + m + ",needSendRequest=" + bool2);
      if ((bool2) || (m <= 0))
      {
        d.removeMessages(103);
        if ((m <= 0) && (!bool2)) {
          Message.obtain(d, 103, 0, 0, c).sendToTarget();
        }
        for (;;)
        {
          ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-121);
          break;
          Message.obtain(d, 103, 1, 0, c).sendToTarget();
        }
      }
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-119);
      break label729;
    }
  }
  
  public static boolean needDownloadDecoupleCore()
  {
    AppMethodBeat.i(54128);
    if (TbsShareManager.isThirdPartyApp(c))
    {
      AppMethodBeat.o(54128);
      return false;
    }
    if (a(c))
    {
      AppMethodBeat.o(54128);
      return false;
    }
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval())
    {
      AppMethodBeat.o(54128);
      return false;
    }
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((m > 0) && (m != o.a().h(c)) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != m))
    {
      AppMethodBeat.o(54128);
      return true;
    }
    AppMethodBeat.o(54128);
    return false;
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(54117);
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean))
    {
      AppMethodBeat.o(54117);
      return false;
    }
    int m = o.a().m(paramContext);
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=".concat(String.valueOf(m)));
    if (m > 0)
    {
      AppMethodBeat.o(54117);
      return false;
    }
    if (a(c, false, true))
    {
      AppMethodBeat.o(54117);
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(c);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      paramBoolean = true;
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=".concat(String.valueOf(paramBoolean)));
      if ((!paramBoolean) || (!h())) {
        break label199;
      }
    }
    label199:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(54117);
      return paramBoolean;
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
      break;
    }
  }
  
  public static void setAppContext(Context paramContext)
  {
    AppMethodBeat.i(54116);
    if ((paramContext != null) && (paramContext.getApplicationContext() != null)) {
      c = paramContext.getApplicationContext();
    }
    AppMethodBeat.o(54116);
  }
  
  public static void setRetryIntervalInSeconds(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(54145);
    if (paramContext == null)
    {
      AppMethodBeat.o(54145);
      return;
    }
    if (paramContext.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
      l = paramLong;
    }
    TbsLog.i("TbsDownload", "mRetryIntervalInSeconds is " + l);
    AppMethodBeat.o(54145);
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    AppMethodBeat.i(54129);
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(c))
    {
      AppMethodBeat.o(54129);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
    if (a(c))
    {
      AppMethodBeat.o(54129);
      return false;
    }
    if (d == null)
    {
      AppMethodBeat.o(54129);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval())
    {
      AppMethodBeat.o(54129);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((m > 0) && (m != o.a().h(c)))
    {
      if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != m) || (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) == 1))
      {
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
        a = true;
        d.removeMessages(108);
        Message localMessage = Message.obtain(d, 108, QbSdk.l);
        localMessage.arg1 = 0;
        localMessage.sendToTarget();
        TbsDownloadConfig.getInstance(c).mSyncMap.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(54129);
        return true;
      }
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + m + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
    }
    for (;;)
    {
      AppMethodBeat.o(54129);
      return false;
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + m + " getTbsCoreShareDecoupleCoreVersion is " + o.a().h(c));
    }
  }
  
  public static void startDownload(Context paramContext)
  {
    AppMethodBeat.i(54124);
    startDownload(paramContext, false);
    AppMethodBeat.o(54124);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    int m = 1;
    for (;;)
    {
      TbsDownloadUpload localTbsDownloadUpload;
      try
      {
        AppMethodBeat.i(54125);
        localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(160));
        localTbsDownloadUpload.commit();
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + c);
        if (o.b)
        {
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(161));
          localTbsDownloadUpload.commit();
          AppMethodBeat.o(54125);
          return;
        }
        a = true;
        paramContext = paramContext.getApplicationContext();
        c = paramContext;
        TbsDownloadConfig.getInstance(paramContext).setDownloadInterruptCode(-200);
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.l.onDownloadFinish(110);
          TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(162));
          localTbsDownloadUpload.commit();
          AppMethodBeat.o(54125);
          continue;
        }
        d();
      }
      finally {}
      if (!i) {
        break;
      }
      QbSdk.l.onDownloadFinish(121);
      TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
      localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(163));
      localTbsDownloadUpload.commit();
      AppMethodBeat.o(54125);
    }
    if (paramBoolean) {
      stopDownload();
    }
    d.removeMessages(101);
    d.removeMessages(100);
    paramContext = Message.obtain(d, 101, QbSdk.l);
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.arg1 = m;
      paramContext.sendToTarget();
      AppMethodBeat.o(54125);
      break;
      m = 0;
    }
  }
  
  public static void stopDownload()
  {
    AppMethodBeat.i(54130);
    if (i)
    {
      AppMethodBeat.o(54130);
      return;
    }
    TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
    if (g != null) {
      g.b();
    }
    if (d != null)
    {
      d.removeMessages(100);
      d.removeMessages(101);
      d.removeMessages(108);
    }
    AppMethodBeat.o(54130);
  }
  
  public static abstract interface TbsDownloaderCallback
  {
    public abstract void onNeedDownloadFinish(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */