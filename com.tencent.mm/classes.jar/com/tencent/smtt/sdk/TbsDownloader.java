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
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.v;
import java.io.File;
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
  private static ah g;
  private static HandlerThread h;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static long l = -1L;
  
  protected static File a(int paramInt)
  {
    AppMethodBeat.i(64380);
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject1 = null;
    int n = arrayOfString.length;
    int m = 0;
    Object localObject2 = localObject1;
    if (m < n)
    {
      localObject2 = arrayOfString[m];
      if (((String)localObject2).equals(c.getApplicationInfo().packageName)) {
        break label150;
      }
      localObject2 = k.a(c, (String)localObject2, 4, false);
      if (!getOverSea(c)) {
        break label137;
      }
    }
    label137:
    for (localObject1 = "x5.oversea.tbs.org";; localObject1 = "x5.tbs.org")
    {
      localObject1 = new File((String)localObject2, (String)localObject1);
      if (!((File)localObject1).exists()) {
        break label157;
      }
      if (a.a(c, (File)localObject1) != paramInt) {
        break;
      }
      TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject1).getAbsolutePath());
      localObject2 = localObject1;
      AppMethodBeat.o(64380);
      return localObject2;
    }
    TbsLog.i("TbsDownload", "version is not match");
    for (;;)
    {
      label150:
      m += 1;
      break;
      label157:
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
    AppMethodBeat.i(139262);
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
        String str = k.a(c, (String)localObject, 4, false);
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
                break label195;
              }
              if (localJSONArray.optInt(n) != l1) {
                break label180;
              }
            }
          }
        }
      }
    }
    label180:
    label195:
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        localJSONArray.put(l1);
      }
      m += 1;
      break;
      localObject = "x5.tbs.org";
      break label65;
      localObject = new File(k.a(c, (String)localObject, 4, false), "x5.tbs.decouple");
      break label78;
      n += 1;
      break label106;
      AppMethodBeat.o(139262);
      return localJSONArray;
    }
  }
  
  private static JSONObject a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(139257);
    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    String str1 = b(c);
    String str2 = b.d(c);
    String str3 = b.c(c);
    String str4 = b.f(c);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)c.getSystemService("phone");
        if (localObject3 == null) {
          break label737;
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
    label1025:
    try
    {
      if (aj.a(c).c("tpatch_num") >= 5) {
        break label740;
      }
      ((JSONObject)localObject3).put("REQUEST_TPATCH", 1);
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!TbsShareManager.isThirdPartyApp(c)) {
        break label774;
      }
      if (!QbSdk.c) {
        break label752;
      }
      m = TbsShareManager.a(c, false);
    }
    catch (Exception localException1)
    {
      label774:
      for (;;)
      {
        int m;
        label217:
        label230:
        int n;
        label295:
        label580:
        label737:
        label740:
        label752:
        continue;
        label654:
        label1048:
        label1070:
        label1073:
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
        localObject1 = f();
        ((JSONObject)localObject3).put("TBSVLARR", localObject1);
        localTbsDownloadConfig.a.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject1).toString());
        localTbsDownloadConfig.commit();
        if (QbSdk.c) {
          ((JSONObject)localObject3).put("THIRDREQ", 1);
        }
        ((JSONObject)localObject3).put("APPN", c.getPackageName());
        ((JSONObject)localObject3).put("APPVN", a(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
        ((JSONObject)localObject3).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
        ((JSONObject)localObject3).put("APPMETA", a(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
        ((JSONObject)localObject3).put("TBSSDKV", 43663);
        ((JSONObject)localObject3).put("TBSV", m);
        if (!paramBoolean3) {
          break label1107;
        }
        n = 1;
        ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", n);
        localObject1 = localTbsDownloadConfig.a;
        if (!paramBoolean3) {
          break label1113;
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
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          if (m == 0) {
            break label1025;
          }
          if (!QbSdk.a(c, m)) {
            break label1119;
          }
          m = 0;
          ((JSONObject)localObject3).put("STATUS", m);
          ((JSONObject)localObject3).put("TBSDV", ao.a().h(c));
        }
        paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
        localObject1 = QbSdk.a(c, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label1048;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label1073;
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
        AppMethodBeat.o(139257);
        return localObject3;
        if (paramBoolean3) {}
        for (n = ao.a().i(c);; n = ao.a().m(c))
        {
          m = n;
          if (n == 0)
          {
            m = n;
            if (ao.a().l(c))
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
                  m = ao.a().i(c);
                }
              }
            }
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + m + " isDownloadForeground=" + paramBoolean2);
          if (!paramBoolean2) {
            break;
          }
          if (ao.a().l(c)) {
            break label1070;
          }
          m = 0;
          break label1070;
        }
        localException2.put("FUNCTION", n);
        break label230;
        localObject1 = a(paramBoolean3);
        if ((Apn.getApnType(c) == 3) || (((JSONArray)localObject1).length() == 0) || (m != 0) || (!paramBoolean1)) {
          break label295;
        }
        localException2.put("TBSBACKUPARR", localObject1);
        break label295;
        localException2.put("STATUS", 0);
        break label580;
        do
        {
          m = 0;
          break label654;
          do
          {
            m = 0;
            break label654;
            paramBoolean1 = false;
            continue;
            break label217;
            localObject1 = "";
            break label129;
            localObject2 = "";
            break;
            break label217;
          } while (!paramBoolean1);
        } while (paramBoolean3);
        m = 1;
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(64367);
    String[] arrayOfString = e();
    int i1 = arrayOfString.length;
    int m = 0;
    int i2;
    if (m < i1)
    {
      String str = arrayOfString[m];
      i2 = TbsShareManager.getSharedTbsCoreVersion(c, str);
      if (i2 > 0)
      {
        Context localContext = TbsShareManager.getPackageContext(c, str, true);
        if ((localContext == null) || (ao.a().f(localContext))) {
          break label93;
        }
        TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
      }
    }
    label146:
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
          break label146;
        }
        paramJSONArray.put(i2);
        break;
        n += 1;
        break label95;
        AppMethodBeat.o(64367);
        return;
      }
    }
  }
  
  private static void a(boolean paramBoolean1, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback, boolean paramBoolean2)
  {
    int n = 1;
    AppMethodBeat.i(139256);
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
      AppMethodBeat.o(139256);
      return;
      m = 0;
      break;
    }
  }
  
  static boolean a(Context paramContext)
  {
    AppMethodBeat.i(139255);
    if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1)
    {
      AppMethodBeat.o(139255);
      return true;
    }
    AppMethodBeat.o(139255);
    return false;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(139253);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    if (Build.VERSION.SDK_INT < 8)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(-102);
      AppMethodBeat.o(139253);
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
      localTbsDownloadConfig.a.put("is_oversea", Boolean.valueOf(bool));
      localTbsDownloadConfig.commit();
      j = bool;
      TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = ".concat(String.valueOf(bool)));
    }
    if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
    {
      TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
      localTbsDownloadConfig.setDownloadInterruptCode(-103);
      AppMethodBeat.o(139253);
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
        AppMethodBeat.o(139253);
        return false;
      }
      AppMethodBeat.o(139253);
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
    AppMethodBeat.i(64350);
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
      if ((l2 - l1 <= 1000L * l5) && ((i1 <= ao.a().i(c)) || (i1 <= i2)) && ((!TbsShareManager.isThirdPartyApp(c)) || (l3 <= 0L) || (l2 - l3 <= l5 * 1000L) || (l4 >= 11L)))
      {
        if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!d())) {
          ao.a().d(c);
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
          AppMethodBeat.o(64350);
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
    for (paramContext = "timeNow - timeLastCheck is " + (l2 - l1) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + d() + " appVersionName is " + str3 + " appVersionCode is " + n + " appMetadata is " + str4 + " oldAppVersionName is " + str1 + " oldAppVersionCode is " + m + " oldAppVersionMetadata is " + str2;; paramContext = null)
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
    //   0: ldc_w 670
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 14
    //   8: new 115	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 672
    //   15: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 674
    //   25: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload 4
    //   30: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   42: invokestatic 183	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   45: astore 32
    //   47: aload_0
    //   48: invokestatic 531	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifeq +41 -> 92
    //   54: iload_2
    //   55: ifeq +26 -> 81
    //   58: aload 32
    //   60: bipush 148
    //   62: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   65: ldc 14
    //   67: ldc_w 676
    //   70: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 670
    //   76: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_0
    //   80: ireturn
    //   81: aload 32
    //   83: sipush -208
    //   86: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   89: goto -24 -> 65
    //   92: new 216	org/json/JSONObject
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 677	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   100: astore 33
    //   102: aload 33
    //   104: ldc_w 679
    //   107: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   110: istore 5
    //   112: iload 5
    //   114: ifeq +49 -> 163
    //   117: iload_2
    //   118: ifeq +34 -> 152
    //   121: aload 32
    //   123: bipush 147
    //   125: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   128: ldc 14
    //   130: ldc_w 683
    //   133: iload 5
    //   135: invokestatic 686	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: ldc_w 670
    //   147: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: aload 32
    //   154: sipush -209
    //   157: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   160: goto -32 -> 128
    //   163: aload 33
    //   165: ldc_w 688
    //   168: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   171: istore 13
    //   173: aload 33
    //   175: ldc_w 690
    //   178: invokevirtual 692	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 34
    //   183: aload 33
    //   185: ldc_w 694
    //   188: ldc 147
    //   190: invokevirtual 697	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 35
    //   195: aload 33
    //   197: ldc_w 699
    //   200: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   203: istore 12
    //   205: aload 33
    //   207: ldc_w 701
    //   210: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   213: istore 14
    //   215: aload 33
    //   217: ldc_w 703
    //   220: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   223: istore 15
    //   225: aload 33
    //   227: ldc_w 705
    //   230: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   233: istore 16
    //   235: aload 33
    //   237: ldc_w 707
    //   240: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   243: istore 17
    //   245: aload 33
    //   247: ldc_w 709
    //   250: invokevirtual 712	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   253: lstore 24
    //   255: aload 33
    //   257: ldc_w 714
    //   260: invokevirtual 712	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   263: lstore 26
    //   265: aload 33
    //   267: ldc_w 716
    //   270: lconst_0
    //   271: invokevirtual 719	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   274: lstore 22
    //   276: aload 33
    //   278: ldc_w 721
    //   281: iconst_m1
    //   282: invokevirtual 723	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   285: istore 18
    //   287: iconst_0
    //   288: istore 5
    //   290: aload 33
    //   292: ldc_w 725
    //   295: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   298: istore 6
    //   300: iload 6
    //   302: istore 5
    //   304: aload 32
    //   306: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   309: ldc_w 727
    //   312: iload 5
    //   314: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: invokeinterface 269 3 0
    //   322: pop
    //   323: iload_2
    //   324: ifeq +59 -> 383
    //   327: getstatic 728	com/tencent/smtt/sdk/QbSdk:i	Z
    //   330: ifeq +53 -> 383
    //   333: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   336: invokestatic 244	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   339: ifeq +44 -> 383
    //   342: aload 33
    //   344: ldc_w 730
    //   347: iconst_0
    //   348: invokevirtual 723	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   351: istore 5
    //   353: invokestatic 735	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   356: astore_0
    //   357: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   360: astore 28
    //   362: iload 5
    //   364: iconst_1
    //   365: if_icmpne +813 -> 1178
    //   368: iconst_1
    //   369: istore 19
    //   371: aload_0
    //   372: aload 28
    //   374: ldc_w 737
    //   377: iload 19
    //   379: invokevirtual 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   382: pop
    //   383: iload_2
    //   384: ifeq +189 -> 573
    //   387: aload 33
    //   389: ldc_w 743
    //   392: iconst_0
    //   393: invokevirtual 723	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   396: istore 5
    //   398: iload 5
    //   400: iconst_1
    //   401: iand
    //   402: ifeq +812 -> 1214
    //   405: iconst_1
    //   406: istore 19
    //   408: invokestatic 735	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   411: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   414: ldc_w 745
    //   417: iload 19
    //   419: invokevirtual 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   422: pop
    //   423: ldc 14
    //   425: ldc_w 747
    //   428: iload 19
    //   430: invokestatic 519	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   433: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 750	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: iload 5
    //   441: iconst_2
    //   442: iand
    //   443: ifeq +777 -> 1220
    //   446: iconst_1
    //   447: istore 19
    //   449: invokestatic 735	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   452: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   455: ldc_w 752
    //   458: iload 19
    //   460: invokevirtual 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   463: pop
    //   464: ldc 14
    //   466: ldc_w 754
    //   469: iload 19
    //   471: invokestatic 519	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   474: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   477: invokestatic 750	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: iload 5
    //   482: iconst_4
    //   483: iand
    //   484: ifeq +742 -> 1226
    //   487: iconst_1
    //   488: istore 19
    //   490: invokestatic 735	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   493: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   496: ldc_w 756
    //   499: iload 19
    //   501: invokevirtual 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   504: pop
    //   505: iload 19
    //   507: invokestatic 760	com/tencent/smtt/sdk/QbSdk:setDisableUnpreinitBySwitch	(Z)V
    //   510: ldc 14
    //   512: ldc_w 762
    //   515: iload 19
    //   517: invokestatic 519	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   520: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   523: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: iload 5
    //   528: bipush 8
    //   530: iand
    //   531: ifeq +701 -> 1232
    //   534: iconst_1
    //   535: istore 19
    //   537: invokestatic 735	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   540: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   543: ldc_w 764
    //   546: iload 19
    //   548: invokevirtual 741	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   551: pop
    //   552: iload 19
    //   554: invokestatic 767	com/tencent/smtt/sdk/QbSdk:setDisableUseHostBackupCoreBySwitch	(Z)V
    //   557: ldc 14
    //   559: ldc_w 769
    //   562: iload 19
    //   564: invokestatic 519	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   567: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   570: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   594: ldc 147
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
    //   620: ldc_w 771
    //   623: invokevirtual 692	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   654: ldc_w 773
    //   657: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
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
    //   688: ldc_w 775
    //   691: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
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
    //   722: ldc_w 777
    //   725: invokevirtual 780	org/json/JSONObject:has	(Ljava/lang/String;)Z
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
    //   757: ldc_w 777
    //   760: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
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
    //   801: ldc_w 782
    //   804: invokevirtual 780	org/json/JSONObject:has	(Ljava/lang/String;)Z
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
    //   836: ldc_w 782
    //   839: invokevirtual 692	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   868: ldc_w 784
    //   871: invokevirtual 780	org/json/JSONObject:has	(Ljava/lang/String;)Z
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
    //   902: ldc_w 784
    //   905: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
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
    //   942: ldc_w 786
    //   945: invokevirtual 780	org/json/JSONObject:has	(Ljava/lang/String;)Z
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
    //   976: ldc_w 786
    //   979: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
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
    //   1006: ldc_w 788
    //   1009: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1012: istore 8
    //   1014: iconst_0
    //   1015: istore 9
    //   1017: aload 33
    //   1019: ldc_w 790
    //   1022: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1025: istore 10
    //   1027: iload 10
    //   1029: istore 9
    //   1031: getstatic 41	com/tencent/smtt/sdk/TbsDownloader:f	Ljava/lang/Object;
    //   1034: astore 29
    //   1036: aload 29
    //   1038: monitorenter
    //   1039: iload 5
    //   1041: ifeq +19 -> 1060
    //   1044: aload 32
    //   1046: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1049: ldc_w 792
    //   1052: ldc 147
    //   1054: invokeinterface 269 3 0
    //   1059: pop
    //   1060: aload_0
    //   1061: invokestatic 531	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1064: ifne +54 -> 1118
    //   1067: aload_0
    //   1068: invokevirtual 793	java/lang/String:length	()I
    //   1071: bipush 96
    //   1073: if_icmpne +45 -> 1118
    //   1076: new 115	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 794	java/lang/StringBuilder:<init>	()V
    //   1083: aload_0
    //   1084: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: ldc_w 796
    //   1090: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokestatic 800	com/tencent/smtt/utils/o:c	()Ljava/lang/String;
    //   1096: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: astore_0
    //   1103: aload 32
    //   1105: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1108: ldc_w 792
    //   1111: aload_0
    //   1112: invokeinterface 269 3 0
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
    //   1135: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1138: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1141: astore_0
    //   1142: iload 9
    //   1144: iconst_1
    //   1145: if_icmpne +194 -> 1339
    //   1148: iconst_1
    //   1149: istore_3
    //   1150: aload_0
    //   1151: iload_3
    //   1152: invokestatic 804	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   1155: ldc 14
    //   1157: ldc_w 806
    //   1160: iload_2
    //   1161: invokestatic 519	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1164: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1167: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1170: ldc_w 670
    //   1173: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1176: iconst_0
    //   1177: ireturn
    //   1178: iconst_0
    //   1179: istore 19
    //   1181: goto -810 -> 371
    //   1184: astore_0
    //   1185: ldc_w 808
    //   1188: new 115	java/lang/StringBuilder
    //   1191: dup
    //   1192: ldc_w 810
    //   1195: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1198: aload_0
    //   1199: invokevirtual 811	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1202: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1239: ldc_w 808
    //   1242: new 115	java/lang/StringBuilder
    //   1245: dup
    //   1246: ldc_w 810
    //   1249: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1252: aload_0
    //   1253: invokevirtual 811	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1256: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1262: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1320: ldc_w 670
    //   1323: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1326: aload_0
    //   1327: athrow
    //   1328: aload 32
    //   1330: sipush -210
    //   1333: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1336: goto -198 -> 1138
    //   1339: iconst_0
    //   1340: istore_3
    //   1341: goto -191 -> 1150
    //   1344: iload 19
    //   1346: ifne +10 -> 1356
    //   1349: aload 32
    //   1351: iload 19
    //   1353: invokevirtual 814	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockEnable	(Z)V
    //   1356: iload 20
    //   1358: ifne +10 -> 1368
    //   1361: aload 32
    //   1363: iload 20
    //   1365: invokevirtual 817	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockWaitEnable	(Z)V
    //   1368: iload 8
    //   1370: iconst_1
    //   1371: if_icmpne +9 -> 1380
    //   1374: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1377: invokestatic 820	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   1380: iload 7
    //   1382: iconst_1
    //   1383: if_icmpne +22 -> 1405
    //   1386: getstatic 466	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1389: bipush 104
    //   1391: invokevirtual 471	android/os/Handler:removeMessages	(I)V
    //   1394: getstatic 466	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1397: bipush 104
    //   1399: invokestatic 477	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1402: invokevirtual 490	android/os/Message:sendToTarget	()V
    //   1405: iload 18
    //   1407: iconst_1
    //   1408: if_icmpne +1773 -> 3181
    //   1411: lload 22
    //   1413: ldc2_w 821
    //   1416: lcmp
    //   1417: ifle +1772 -> 3189
    //   1420: ldc2_w 821
    //   1423: lstore 22
    //   1425: lload 22
    //   1427: lconst_0
    //   1428: lcmp
    //   1429: ifle +1752 -> 3181
    //   1432: invokestatic 825	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1435: lconst_0
    //   1436: lcmp
    //   1437: iflt +8 -> 1445
    //   1440: invokestatic 825	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1443: lstore 22
    //   1445: aload 32
    //   1447: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1450: ldc_w 827
    //   1453: lload 22
    //   1455: invokestatic 832	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1458: invokeinterface 269 3 0
    //   1463: pop
    //   1464: iconst_0
    //   1465: istore 5
    //   1467: iconst_0
    //   1468: istore 6
    //   1470: iload_2
    //   1471: ifeq +256 -> 1727
    //   1474: aload 33
    //   1476: ldc_w 834
    //   1479: invokevirtual 681	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1482: istore 7
    //   1484: iload 7
    //   1486: istore 5
    //   1488: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1491: invokestatic 183	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1494: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1497: ldc_w 316
    //   1500: iconst_0
    //   1501: invokeinterface 303 3 0
    //   1506: istore 7
    //   1508: iload 7
    //   1510: istore 6
    //   1512: iload 5
    //   1514: istore 7
    //   1516: iload_2
    //   1517: ifeq +36 -> 1553
    //   1520: iload 5
    //   1522: istore 7
    //   1524: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1527: invokestatic 244	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1530: ifne +23 -> 1553
    //   1533: iload 5
    //   1535: istore 7
    //   1537: iload 5
    //   1539: ifne +14 -> 1553
    //   1542: invokestatic 355	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   1545: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1548: invokevirtual 358	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;)I
    //   1551: istore 7
    //   1553: ldc 14
    //   1555: ldc_w 836
    //   1558: iload 7
    //   1560: invokestatic 686	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1563: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1566: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1569: aload 32
    //   1571: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1574: ldc_w 838
    //   1577: iload 7
    //   1579: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1582: invokeinterface 269 3 0
    //   1587: pop
    //   1588: aload 32
    //   1590: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1593: ldc_w 316
    //   1596: iload 6
    //   1598: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1601: invokeinterface 269 3 0
    //   1606: pop
    //   1607: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1610: invokestatic 244	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1613: ifne +46 -> 1659
    //   1616: iload 7
    //   1618: ifle +136 -> 1754
    //   1621: iload 7
    //   1623: invokestatic 355	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   1626: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1629: invokevirtual 358	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;)I
    //   1632: if_icmpeq +122 -> 1754
    //   1635: iload 7
    //   1637: invokestatic 355	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   1640: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1643: invokevirtual 387	com/tencent/smtt/sdk/ao:i	(Landroid/content/Context;)I
    //   1646: if_icmpne +108 -> 1754
    //   1649: invokestatic 355	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   1652: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1655: invokevirtual 841	com/tencent/smtt/sdk/ao:n	(Landroid/content/Context;)Z
    //   1658: pop
    //   1659: aload 34
    //   1661: invokestatic 531	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1664: ifeq +114 -> 1778
    //   1667: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1670: invokestatic 244	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1673: ifeq +105 -> 1778
    //   1676: aload 32
    //   1678: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1681: ldc_w 843
    //   1684: getstatic 847	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1687: invokeinterface 269 3 0
    //   1692: pop
    //   1693: aload 32
    //   1695: invokevirtual 272	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1698: iload_2
    //   1699: ifeq +12 -> 1711
    //   1702: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1705: iload 12
    //   1707: iconst_0
    //   1708: invokestatic 851	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1711: ldc 14
    //   1713: ldc_w 853
    //   1716: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1719: ldc_w 670
    //   1722: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1725: iconst_0
    //   1726: ireturn
    //   1727: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1730: invokestatic 183	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1733: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1736: ldc_w 838
    //   1739: iconst_0
    //   1740: invokeinterface 303 3 0
    //   1745: istore 7
    //   1747: iload 7
    //   1749: istore 5
    //   1751: goto -263 -> 1488
    //   1754: iload 7
    //   1756: ifne -97 -> 1659
    //   1759: invokestatic 355	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   1762: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1765: invokevirtual 857	com/tencent/smtt/sdk/ao:p	(Landroid/content/Context;)Ljava/io/File;
    //   1768: invokestatic 860	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   1771: goto -112 -> 1659
    //   1774: astore_0
    //   1775: goto -116 -> 1659
    //   1778: ldc 14
    //   1780: ldc_w 862
    //   1783: iload 13
    //   1785: invokestatic 686	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1788: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1791: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1794: iload 13
    //   1796: ifne +127 -> 1923
    //   1799: aload 32
    //   1801: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1804: ldc_w 864
    //   1807: iload 13
    //   1809: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1812: invokeinterface 269 3 0
    //   1817: pop
    //   1818: aload 32
    //   1820: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1823: ldc_w 843
    //   1826: getstatic 847	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1829: invokeinterface 269 3 0
    //   1834: pop
    //   1835: iload_2
    //   1836: ifeq +56 -> 1892
    //   1839: aload 32
    //   1841: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1844: ldc_w 866
    //   1847: bipush 145
    //   1849: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1852: invokeinterface 269 3 0
    //   1857: pop
    //   1858: aload 32
    //   1860: invokevirtual 272	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1863: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1866: invokestatic 244	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1869: ifne +7 -> 1876
    //   1872: invokestatic 869	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1875: pop
    //   1876: ldc 14
    //   1878: ldc_w 871
    //   1881: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1884: ldc_w 670
    //   1887: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1890: iconst_0
    //   1891: ireturn
    //   1892: aload 32
    //   1894: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1897: ldc_w 866
    //   1900: sipush -211
    //   1903: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1906: invokeinterface 269 3 0
    //   1911: pop
    //   1912: aload 32
    //   1914: sipush -211
    //   1917: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1920: goto -62 -> 1858
    //   1923: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1926: invokestatic 183	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1929: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1932: ldc_w 385
    //   1935: iconst_0
    //   1936: invokeinterface 303 3 0
    //   1941: istore 8
    //   1943: iload 8
    //   1945: iload 12
    //   1947: if_icmple +18 -> 1965
    //   1950: getstatic 326	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ah;
    //   1953: invokevirtual 873	com/tencent/smtt/sdk/ah:c	()V
    //   1956: invokestatic 355	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   1959: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1962: invokevirtual 875	com/tencent/smtt/sdk/ao:o	(Landroid/content/Context;)V
    //   1965: iconst_0
    //   1966: istore 5
    //   1968: iconst_0
    //   1969: istore 7
    //   1971: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1974: invokestatic 244	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1977: ifne +63 -> 2040
    //   1980: invokestatic 355	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   1983: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1986: iconst_0
    //   1987: invokevirtual 878	com/tencent/smtt/sdk/ao:e	(Landroid/content/Context;I)I
    //   1990: istore 9
    //   1992: iload 7
    //   1994: istore 5
    //   1996: iload 9
    //   1998: iload 12
    //   2000: if_icmplt +6 -> 2006
    //   2003: iconst_1
    //   2004: istore 5
    //   2006: ldc 14
    //   2008: new 115	java/lang/StringBuilder
    //   2011: dup
    //   2012: ldc_w 880
    //   2015: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2018: iload 9
    //   2020: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2023: ldc_w 882
    //   2026: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: iload 12
    //   2031: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2034: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2037: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2040: iload_1
    //   2041: iload 12
    //   2043: if_icmpge +16 -> 2059
    //   2046: aload 34
    //   2048: invokestatic 531	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2051: ifne +8 -> 2059
    //   2054: iload 5
    //   2056: ifeq +276 -> 2332
    //   2059: iload 6
    //   2061: iconst_1
    //   2062: if_icmpeq +270 -> 2332
    //   2065: aload 32
    //   2067: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2070: ldc_w 843
    //   2073: getstatic 847	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2076: invokeinterface 269 3 0
    //   2081: pop
    //   2082: iload_2
    //   2083: ifeq +175 -> 2258
    //   2086: aload 34
    //   2088: invokestatic 531	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2091: ifeq +90 -> 2181
    //   2094: aload 32
    //   2096: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2099: ldc_w 866
    //   2102: bipush 132
    //   2104: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2107: invokeinterface 269 3 0
    //   2112: pop
    //   2113: aload 32
    //   2115: invokevirtual 272	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2118: ldc 14
    //   2120: new 115	java/lang/StringBuilder
    //   2123: dup
    //   2124: ldc_w 884
    //   2127: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2130: iload_1
    //   2131: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2134: ldc_w 886
    //   2137: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2140: iload 12
    //   2142: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2145: ldc_w 888
    //   2148: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: iload 8
    //   2153: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2156: ldc_w 890
    //   2159: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: aload 34
    //   2164: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2170: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2173: ldc_w 670
    //   2176: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2179: iconst_0
    //   2180: ireturn
    //   2181: iload 12
    //   2183: ifgt +25 -> 2208
    //   2186: aload 32
    //   2188: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2191: ldc_w 866
    //   2194: bipush 131
    //   2196: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2199: invokeinterface 269 3 0
    //   2204: pop
    //   2205: goto -92 -> 2113
    //   2208: iload_1
    //   2209: iload 12
    //   2211: if_icmplt +25 -> 2236
    //   2214: aload 32
    //   2216: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2219: ldc_w 866
    //   2222: bipush 129
    //   2224: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2227: invokeinterface 269 3 0
    //   2232: pop
    //   2233: goto -120 -> 2113
    //   2236: aload 32
    //   2238: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2241: ldc_w 866
    //   2244: bipush 144
    //   2246: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2249: invokeinterface 269 3 0
    //   2254: pop
    //   2255: goto -142 -> 2113
    //   2258: sipush -212
    //   2261: istore 5
    //   2263: aload 34
    //   2265: invokestatic 531	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2268: ifeq +37 -> 2305
    //   2271: sipush -217
    //   2274: istore 5
    //   2276: aload 32
    //   2278: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2281: ldc_w 866
    //   2284: iload 5
    //   2286: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2289: invokeinterface 269 3 0
    //   2294: pop
    //   2295: aload 32
    //   2297: iload 5
    //   2299: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
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
    //   2336: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2339: ldc_w 892
    //   2342: aconst_null
    //   2343: invokeinterface 293 3 0
    //   2348: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2351: ifne +45 -> 2396
    //   2354: getstatic 326	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ah;
    //   2357: invokevirtual 873	com/tencent/smtt/sdk/ah:c	()V
    //   2360: aload 32
    //   2362: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2365: ldc_w 894
    //   2368: iconst_0
    //   2369: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2372: invokeinterface 269 3 0
    //   2377: pop
    //   2378: aload 32
    //   2380: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2383: ldc_w 896
    //   2386: iconst_0
    //   2387: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2390: invokeinterface 269 3 0
    //   2395: pop
    //   2396: aload 32
    //   2398: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2401: ldc_w 385
    //   2404: iload 12
    //   2406: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2409: invokeinterface 269 3 0
    //   2414: pop
    //   2415: ldc 14
    //   2417: ldc_w 898
    //   2420: iload 12
    //   2422: invokestatic 686	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2425: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2428: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2431: iload 12
    //   2433: ifle +43 -> 2476
    //   2436: iload 6
    //   2438: iconst_1
    //   2439: if_icmpne +342 -> 2781
    //   2442: aload 32
    //   2444: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2447: ldc_w 900
    //   2450: iconst_1
    //   2451: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2454: invokeinterface 269 3 0
    //   2459: pop
    //   2460: ldc 14
    //   2462: ldc_w 902
    //   2465: iload 6
    //   2467: invokestatic 686	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2470: invokevirtual 455	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2473: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2476: aload 32
    //   2478: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2481: ldc_w 892
    //   2484: aload 34
    //   2486: invokeinterface 269 3 0
    //   2491: pop
    //   2492: aload 32
    //   2494: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2497: ldc_w 904
    //   2500: aload 35
    //   2502: invokeinterface 269 3 0
    //   2507: pop
    //   2508: aload 32
    //   2510: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2513: ldc_w 864
    //   2516: iload 13
    //   2518: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2521: invokeinterface 269 3 0
    //   2526: pop
    //   2527: aload 32
    //   2529: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2532: ldc_w 906
    //   2535: iload 14
    //   2537: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2540: invokeinterface 269 3 0
    //   2545: pop
    //   2546: aload 32
    //   2548: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2551: ldc_w 908
    //   2554: iload 15
    //   2556: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2559: invokeinterface 269 3 0
    //   2564: pop
    //   2565: aload 32
    //   2567: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2570: ldc_w 910
    //   2573: iload 16
    //   2575: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2578: invokeinterface 269 3 0
    //   2583: pop
    //   2584: aload 32
    //   2586: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2589: ldc_w 912
    //   2592: iload 17
    //   2594: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2597: invokeinterface 269 3 0
    //   2602: pop
    //   2603: aload 32
    //   2605: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2608: ldc_w 914
    //   2611: lload 24
    //   2613: invokestatic 832	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2616: invokeinterface 269 3 0
    //   2621: pop
    //   2622: aload 32
    //   2624: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2627: ldc_w 916
    //   2630: lload 26
    //   2632: invokestatic 832	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2635: invokeinterface 269 3 0
    //   2640: pop
    //   2641: aload 32
    //   2643: invokevirtual 272	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2646: aload 28
    //   2648: ifnull +19 -> 2667
    //   2651: aload 32
    //   2653: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2656: ldc_w 918
    //   2659: aload 28
    //   2661: invokeinterface 269 3 0
    //   2666: pop
    //   2667: iload_3
    //   2668: ifne +165 -> 2833
    //   2671: iload 4
    //   2673: ifeq +160 -> 2833
    //   2676: invokestatic 355	com/tencent/smtt/sdk/ao:a	()Lcom/tencent/smtt/sdk/ao;
    //   2679: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2682: iload 12
    //   2684: invokevirtual 920	com/tencent/smtt/sdk/ao:b	(Landroid/content/Context;I)Z
    //   2687: ifeq +146 -> 2833
    //   2690: iload_2
    //   2691: ifeq +111 -> 2802
    //   2694: aload 32
    //   2696: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2699: ldc_w 866
    //   2702: bipush 143
    //   2704: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2707: invokeinterface 269 3 0
    //   2712: pop
    //   2713: aload 32
    //   2715: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2718: ldc_w 843
    //   2721: getstatic 847	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2724: invokeinterface 269 3 0
    //   2729: pop
    //   2730: ldc 14
    //   2732: ldc_w 922
    //   2735: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2738: aload 33
    //   2740: ldc_w 924
    //   2743: iconst_0
    //   2744: invokevirtual 723	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2747: iconst_1
    //   2748: if_icmpne +20 -> 2768
    //   2751: aload 32
    //   2753: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2756: ldc_w 926
    //   2759: getstatic 929	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2762: invokeinterface 269 3 0
    //   2767: pop
    //   2768: aload 32
    //   2770: invokevirtual 272	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2773: ldc_w 670
    //   2776: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2779: iconst_1
    //   2780: ireturn
    //   2781: aload 32
    //   2783: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2786: ldc_w 900
    //   2789: iconst_0
    //   2790: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2793: invokeinterface 269 3 0
    //   2798: pop
    //   2799: goto -339 -> 2460
    //   2802: aload 32
    //   2804: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2807: ldc_w 866
    //   2810: sipush -213
    //   2813: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2816: invokeinterface 269 3 0
    //   2821: pop
    //   2822: aload 32
    //   2824: sipush -213
    //   2827: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2830: goto -117 -> 2713
    //   2833: iload_3
    //   2834: ifne +151 -> 2985
    //   2837: iload 4
    //   2839: ifeq +146 -> 2985
    //   2842: getstatic 326	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ah;
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
    //   2865: invokevirtual 932	com/tencent/smtt/sdk/ah:a	(ZZ)Z
    //   2868: ifeq +117 -> 2985
    //   2871: aload 32
    //   2873: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2876: ldc_w 843
    //   2879: getstatic 847	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2882: invokeinterface 269 3 0
    //   2887: pop
    //   2888: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2891: invokestatic 623	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2894: invokevirtual 627	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2897: astore_0
    //   2898: aload_0
    //   2899: bipush 100
    //   2901: invokevirtual 632	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2904: aload_0
    //   2905: new 115	java/lang/StringBuilder
    //   2908: dup
    //   2909: ldc_w 934
    //   2912: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2915: getstatic 326	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ah;
    //   2918: getfield 936	com/tencent/smtt/sdk/ah:a	Ljava/lang/String;
    //   2921: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2924: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2927: invokevirtual 635	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2930: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2933: invokestatic 938	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2936: ifeq +33 -> 2969
    //   2939: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2942: invokestatic 623	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2945: getstatic 941	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2948: aload_0
    //   2949: invokevirtual 645	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2952: ldc 14
    //   2954: ldc_w 943
    //   2957: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2960: goto -222 -> 2738
    //   2963: iconst_0
    //   2964: istore 4
    //   2966: goto -105 -> 2861
    //   2969: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2972: invokestatic 623	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2975: getstatic 641	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2978: aload_0
    //   2979: invokevirtual 645	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2982: goto -30 -> 2952
    //   2985: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2988: invokestatic 183	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2991: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2994: ldc_w 900
    //   2997: iconst_0
    //   2998: invokeinterface 303 3 0
    //   3003: iconst_1
    //   3004: if_icmpne +120 -> 3124
    //   3007: getstatic 326	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ah;
    //   3010: invokevirtual 945	com/tencent/smtt/sdk/ah:a	()Z
    //   3013: ifeq +111 -> 3124
    //   3016: aload 32
    //   3018: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3021: ldc_w 843
    //   3024: getstatic 847	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3027: invokeinterface 269 3 0
    //   3032: pop
    //   3033: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3036: invokestatic 623	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3039: invokevirtual 627	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3042: astore_0
    //   3043: aload_0
    //   3044: bipush 100
    //   3046: invokevirtual 632	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   3049: aload_0
    //   3050: new 115	java/lang/StringBuilder
    //   3053: dup
    //   3054: ldc_w 947
    //   3057: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3060: getstatic 326	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ah;
    //   3063: getfield 936	com/tencent/smtt/sdk/ah:a	Ljava/lang/String;
    //   3066: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3069: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3072: invokevirtual 635	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   3075: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3078: invokestatic 938	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   3081: ifeq +27 -> 3108
    //   3084: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3087: invokestatic 623	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3090: getstatic 941	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3093: aload_0
    //   3094: invokevirtual 645	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3097: ldc 14
    //   3099: ldc_w 949
    //   3102: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3105: goto -367 -> 2738
    //   3108: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3111: invokestatic 623	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3114: getstatic 641	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3117: aload_0
    //   3118: invokevirtual 645	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3121: goto -24 -> 3097
    //   3124: iload_2
    //   3125: ifne +11 -> 3136
    //   3128: aload 32
    //   3130: sipush -216
    //   3133: invokevirtual 501	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3136: aload 32
    //   3138: getfield 261	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3141: ldc_w 843
    //   3144: getstatic 929	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   3147: invokeinterface 269 3 0
    //   3152: pop
    //   3153: ldc 14
    //   3155: ldc_w 951
    //   3158: invokestatic 135	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3161: goto -423 -> 2738
    //   3164: astore_0
    //   3165: goto -1653 -> 1512
    //   3168: astore_0
    //   3169: goto -1681 -> 1488
    //   3172: astore 29
    //   3174: goto -2143 -> 1031
    //   3177: astore_0
    //   3178: goto -2874 -> 304
    //   3181: ldc2_w 952
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
    AppMethodBeat.i(64381);
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
        String str2 = k.a(c, str1, 4, false);
        if (!getOverSea(c)) {
          break label115;
        }
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str2, (String)localObject);
        if ((!((File)localObject).exists()) || (a.a(c, (File)localObject) != paramInt)) {
          break label121;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
      }
      for (;;)
      {
        AppMethodBeat.o(64381);
        return localObject;
        label115:
        localObject = "x5.tbs.org";
        break;
        label121:
        localObject = new File(k.a(c, str1, 4, false), "x5.tbs.decouple");
        if ((!((File)localObject).exists()) || (a.a(c, (File)localObject) != paramInt)) {
          break label186;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
      }
      label186:
      m += 1;
    }
  }
  
  static String b(Context paramContext)
  {
    AppMethodBeat.i(139260);
    if (!TextUtils.isEmpty(b))
    {
      paramContext = b;
      AppMethodBeat.o(139260);
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
      AppMethodBeat.o(139260);
      return paramContext;
    }
  }
  
  private static void b(JSONArray paramJSONArray)
  {
    int i1 = 0;
    AppMethodBeat.i(64368);
    int i2;
    int m;
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      i2 = ao.a().a(TbsShareManager.getHostCorePathAppDefined());
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
        AppMethodBeat.o(64368);
        return;
      }
      m += 1;
    }
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(139258);
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(144));
      ((TbsDownloadUpload)localObject1).commit();
      if ((QbSdk.n == null) || (!QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) || (!QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false"))) {
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
      AppMethodBeat.o(139258);
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
    if (ao.a().c(c))
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
        AppMethodBeat.o(139258);
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
    Object localObject2 = k.a(c, 1);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    }
    for (;;)
    {
      localObject2 = new File((String)localObject2, (String)localObject1);
      Object localObject3 = k.a(c, 2);
      label417:
      label452:
      label487:
      int n;
      if (getOverSea(c))
      {
        localObject1 = "x5.oversea.tbs.org";
        localObject3 = new File((String)localObject3, (String)localObject1);
        Object localObject4 = k.a(c, 3);
        if (!getOverSea(c)) {
          break label1022;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject4 = new File((String)localObject4, (String)localObject1);
        String str2 = k.a(c, 4);
        if (!getOverSea(c)) {
          break label1029;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(str2, (String)localObject1);
        if (!((File)localObject1).exists())
        {
          if (!((File)localObject4).exists()) {
            break label1036;
          }
          ((File)localObject4).renameTo((File)localObject1);
        }
        label524:
        if (e == null)
        {
          e = b.a();
          localTbsDownloadConfig.a.put("device_cpuabi", e);
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
            break label1093;
          }
          TbsLog.e("TbsDownload", "don't support x86 devices,skip send request");
          localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
          if (!paramBoolean1) {
            break label1074;
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
      localTbsDownloadConfig.a.put("app_versionname", b.a(c));
      localTbsDownloadConfig.a.put("app_versioncode", Integer.valueOf(b.b(c)));
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
              localTbsDownloadConfig.a.put("count_request_fail_in_24hours", Long.valueOf(l1));
            }
          }
          else
          {
            localTbsDownloadConfig.a.put("request_fail", Long.valueOf(l2));
            localTbsDownloadConfig.a.put("app_versionname", b.a(c));
            localTbsDownloadConfig.a.put("app_versioncode", Integer.valueOf(b.b(c)));
            localTbsDownloadConfig.a.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            localTbsDownloadConfig.commit();
            if (m == 0) {
              break label1172;
            }
            if (!paramBoolean1) {
              break label1132;
            }
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(147));
            ((TbsDownloadUpload)localObject1).commit();
            AppMethodBeat.o(139258);
            return false;
            localObject1 = "x5.tbs.org";
            continue;
            localObject1 = "x5.tbs.org";
            break label417;
            label1022:
            localObject1 = "x5.tbs.org";
            break label452;
            label1029:
            localObject1 = "x5.tbs.org";
            break label487;
            label1036:
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
            label1074:
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
            ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
            break label662;
            label1093:
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
          label1132:
          if (!paramBoolean3)
          {
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(167));
            ((TbsDownloadUpload)localObject1).commit();
          }
        }
        label1172:
        if ((n != -1) || (paramBoolean3)) {}
        for (;;)
        {
          try
          {
            String str1 = v.a(c).d();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=".concat(String.valueOf(str1)));
            if (!paramBoolean1) {
              continue;
            }
            localObject3 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_code", Integer.valueOf(148));
            ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_sent", Integer.valueOf(1));
            ((TbsDownloadUpload)localObject3).commit();
            TbsLog.i("TbsDownload", "sendRequest query 148");
            paramBoolean2 = a(n.a(str1, ((JSONObject)localObject1).toString().getBytes("utf-8"), new al(localTbsDownloadConfig, paramBoolean1), false), n, paramBoolean1, paramBoolean2, paramBoolean4);
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
          AppMethodBeat.o(139258);
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
  
  private static void c()
  {
    try
    {
      AppMethodBeat.i(64363);
      if (h == null) {
        h = am.a();
      }
      try
      {
        g = new ah(c);
        d = new ak(h.getLooper());
        AppMethodBeat.o(64363);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
          AppMethodBeat.o(64363);
        }
      }
      return;
    }
    finally {}
  }
  
  @TargetApi(11)
  static void c(Context paramContext)
  {
    AppMethodBeat.i(139261);
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    ah.c(paramContext);
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
      AppMethodBeat.o(139261);
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  private static void c(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(64370);
    String str;
    int i2;
    Context localContext;
    if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore())
    {
      String[] arrayOfString = e();
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
            if ((localContext != null) && (!ao.a().f(localContext)))
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
      if ((localContext != null) && (!ao.a().f(localContext)))
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
        AppMethodBeat.o(64370);
        return;
      }
      break;
    }
  }
  
  private static boolean d()
  {
    AppMethodBeat.i(64365);
    try
    {
      JSONArray localJSONArray = f();
      boolean bool = TbsDownloadConfig.getInstance(c).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      AppMethodBeat.o(64365);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64365);
    }
    return false;
  }
  
  private static String[] e()
  {
    AppMethodBeat.i(64366);
    Object localObject;
    if (QbSdk.getOnlyDownload())
    {
      localObject = new String[1];
      localObject[0] = c.getApplicationContext().getPackageName();
    }
    for (;;)
    {
      AppMethodBeat.o(64366);
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
  
  private static JSONArray f()
  {
    AppMethodBeat.i(64369);
    if (TbsShareManager.isThirdPartyApp(c))
    {
      JSONArray localJSONArray = new JSONArray();
      a(localJSONArray);
      c(localJSONArray);
      b(localJSONArray);
      AppMethodBeat.o(64369);
      return localJSONArray;
    }
    AppMethodBeat.o(64369);
    return null;
  }
  
  private static boolean g()
  {
    AppMethodBeat.i(64379);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-115);
      AppMethodBeat.o(64379);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-116);
      AppMethodBeat.o(64379);
      return false;
    }
    if (!k.b(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-117);
      AppMethodBeat.o(64379);
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
        AppMethodBeat.o(64379);
        return false;
      }
    }
    AppMethodBeat.o(64379);
    return true;
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    AppMethodBeat.i(64357);
    int m = ao.a().h(c);
    AppMethodBeat.o(64357);
    return m;
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    AppMethodBeat.i(64356);
    int m = ao.a().h(paramContext);
    AppMethodBeat.o(64356);
    return m;
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(64372);
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
      AppMethodBeat.o(64372);
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
  
  public static boolean isDownloadForeground()
  {
    AppMethodBeat.i(64362);
    if ((g != null) && (g.d()))
    {
      AppMethodBeat.o(64362);
      return true;
    }
    AppMethodBeat.o(64362);
    return false;
  }
  
  public static boolean isDownloading()
  {
    try
    {
      AppMethodBeat.i(64361);
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + a);
      boolean bool = a;
      AppMethodBeat.o(64361);
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
    AppMethodBeat.i(64352);
    paramBoolean = needDownload(paramContext, paramBoolean, false, true, null);
    AppMethodBeat.o(64352);
    return paramBoolean;
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    AppMethodBeat.i(64353);
    paramBoolean1 = needDownload(paramContext, paramBoolean1, paramBoolean2, true, paramTbsDownloaderCallback);
    AppMethodBeat.o(64353);
    return paramBoolean1;
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    AppMethodBeat.i(139254);
    TbsLog.i("TbsDownload", "needDownload,process=" + QbSdk.getCurrentProcessName(paramContext) + "stack=" + Log.getStackTraceString(new Throwable()));
    TbsDownloadUpload.clear();
    TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
    localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(140));
    localTbsDownloadUpload.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] oversea=" + paramBoolean1 + ",isDownloadForeground=" + paramBoolean2);
    boolean bool1 = false;
    TbsLog.initIfNeed(paramContext);
    if (ao.b)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#1,return false");
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(171));
      localTbsDownloadUpload.commit();
      AppMethodBeat.o(139254);
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
      AppMethodBeat.o(139254);
      return false;
    }
    c();
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
      AppMethodBeat.o(139254);
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
          break label696;
        }
        paramBoolean1 = true;
      }
      label539:
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (!paramBoolean1) {
        break label732;
      }
      if (g()) {
        break label714;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
      paramBoolean1 = false;
      label591:
      if ((!bool2) && (paramTbsDownloaderCallback != null)) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=".concat(String.valueOf(paramBoolean1)));
      paramContext = localTbsDownloadUpload.a;
      if (!paramBoolean1) {
        break label860;
      }
    }
    label696:
    label714:
    label860:
    for (int m = 170;; m = 174)
    {
      paramContext.put("tbs_needdownload_return", Integer.valueOf(m));
      localTbsDownloadUpload.commit();
      AppMethodBeat.o(139254);
      return paramBoolean1;
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(143));
      localTbsDownloadUpload.commit();
      break;
      paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.getBoolean("tbs_needdownload", false);
      break label539;
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-118);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      break label591;
      label732:
      m = ao.a().m(c);
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
      break label591;
    }
  }
  
  public static boolean needDownloadDecoupleCore()
  {
    AppMethodBeat.i(64358);
    if (TbsShareManager.isThirdPartyApp(c))
    {
      AppMethodBeat.o(64358);
      return false;
    }
    if (a(c))
    {
      AppMethodBeat.o(64358);
      return false;
    }
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval())
    {
      AppMethodBeat.o(64358);
      return false;
    }
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((m > 0) && (m != ao.a().h(c)) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != m))
    {
      AppMethodBeat.o(64358);
      return true;
    }
    AppMethodBeat.o(64358);
    return false;
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(64349);
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean))
    {
      AppMethodBeat.o(64349);
      return false;
    }
    int m = ao.a().m(paramContext);
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=".concat(String.valueOf(m)));
    if (m > 0)
    {
      AppMethodBeat.o(64349);
      return false;
    }
    if (a(c, false, true))
    {
      AppMethodBeat.o(64349);
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(c);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      paramBoolean = true;
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=".concat(String.valueOf(paramBoolean)));
      if ((!paramBoolean) || (!g())) {
        break label199;
      }
    }
    label199:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(64349);
      return paramBoolean;
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
      break;
    }
  }
  
  public static void setAppContext(Context paramContext)
  {
    AppMethodBeat.i(64348);
    if ((paramContext != null) && (paramContext.getApplicationContext() != null)) {
      c = paramContext.getApplicationContext();
    }
    AppMethodBeat.o(64348);
  }
  
  public static void setRetryIntervalInSeconds(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(64376);
    if (paramContext == null)
    {
      AppMethodBeat.o(64376);
      return;
    }
    if (paramContext.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
      l = paramLong;
    }
    TbsLog.i("TbsDownload", "mRetryIntervalInSeconds is " + l);
    AppMethodBeat.o(64376);
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    AppMethodBeat.i(64359);
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(c))
    {
      AppMethodBeat.o(64359);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
    if (a(c))
    {
      AppMethodBeat.o(64359);
      return false;
    }
    if (d == null)
    {
      AppMethodBeat.o(64359);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval())
    {
      AppMethodBeat.o(64359);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((m > 0) && (m != ao.a().h(c)))
    {
      if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != m) || (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) == 1))
      {
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
        a = true;
        d.removeMessages(108);
        Message localMessage = Message.obtain(d, 108, QbSdk.m);
        localMessage.arg1 = 0;
        localMessage.sendToTarget();
        TbsDownloadConfig.getInstance(c).a.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(64359);
        return true;
      }
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + m + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
    }
    for (;;)
    {
      AppMethodBeat.o(64359);
      return false;
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + m + " getTbsCoreShareDecoupleCoreVersion is " + ao.a().h(c));
    }
  }
  
  public static void startDownload(Context paramContext)
  {
    AppMethodBeat.i(64354);
    startDownload(paramContext, false);
    AppMethodBeat.o(64354);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    int m = 1;
    for (;;)
    {
      TbsDownloadUpload localTbsDownloadUpload;
      try
      {
        AppMethodBeat.i(64355);
        localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(160));
        localTbsDownloadUpload.commit();
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + c);
        if (ao.b)
        {
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(161));
          localTbsDownloadUpload.commit();
          AppMethodBeat.o(64355);
          return;
        }
        a = true;
        paramContext = paramContext.getApplicationContext();
        c = paramContext;
        TbsDownloadConfig.getInstance(paramContext).setDownloadInterruptCode(-200);
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.m.onDownloadFinish(110);
          TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(162));
          localTbsDownloadUpload.commit();
          AppMethodBeat.o(64355);
          continue;
        }
        c();
      }
      finally {}
      if (!i) {
        break;
      }
      QbSdk.m.onDownloadFinish(121);
      TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
      localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(163));
      localTbsDownloadUpload.commit();
      AppMethodBeat.o(64355);
    }
    if (paramBoolean) {
      stopDownload();
    }
    d.removeMessages(101);
    d.removeMessages(100);
    paramContext = Message.obtain(d, 101, QbSdk.m);
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.arg1 = m;
      paramContext.sendToTarget();
      AppMethodBeat.o(64355);
      break;
      m = 0;
    }
  }
  
  public static void stopDownload()
  {
    AppMethodBeat.i(64360);
    if (i)
    {
      AppMethodBeat.o(64360);
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
    AppMethodBeat.o(64360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */