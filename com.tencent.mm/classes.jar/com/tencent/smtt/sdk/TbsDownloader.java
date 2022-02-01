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
import com.tencent.smtt.utils.g.a;
import com.tencent.smtt.utils.r;
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
  private static m g;
  private static HandlerThread h;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static JSONObject l = null;
  private static long m = -1L;
  
  protected static File a(int paramInt)
  {
    AppMethodBeat.i(54149);
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject1 = null;
    int i1 = arrayOfString.length;
    int n = 0;
    Object localObject2 = localObject1;
    if (n < i1)
    {
      localObject2 = arrayOfString[n];
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
      n += 1;
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
    int i2 = arrayOfString.length;
    int n = 0;
    Object localObject;
    label65:
    label78:
    long l1;
    if (n < i2)
    {
      localObject = arrayOfString[n];
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
              i1 = 0;
              label106:
              if (i1 >= localJSONArray.length()) {
                break label197;
              }
              if (localJSONArray.optInt(i1) != l1) {
                break label182;
              }
            }
          }
        }
      }
    }
    label182:
    label197:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        localJSONArray.put(l1);
      }
      n += 1;
      break;
      localObject = getBackupFileName(false);
      break label65;
      localObject = new File(f.a(c, (String)localObject, 4, false), "x5.tbs.decouple");
      break label78;
      i1 += 1;
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
    String str2 = b.h(c);
    String str3 = b.g(c);
    String str4 = b.j(c);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)c.getSystemService("phone");
        if (localObject3 == null) {
          break label801;
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
        n = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      }
      if (localObject1 != null) {
        localObject3 = new JSONObject();
      }
    }
    label314:
    label1090:
    try
    {
      if (n.a(c).c("tpatch_num") >= 5) {
        break label804;
      }
      ((JSONObject)localObject3).put("REQUEST_TPATCH", 1);
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      if (b.d()) {
        ((JSONObject)localObject3).put("REQUEST_64", 1);
      }
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!TbsShareManager.isThirdPartyApp(c)) {
        break label838;
      }
      if (!QbSdk.c) {
        break label816;
      }
      n = TbsShareManager.a(c, false);
    }
    catch (Exception localException1)
    {
      label838:
      for (;;)
      {
        int n;
        label235:
        label249:
        int i1;
        label629:
        label1148:
        label1151:
        continue;
        label718:
        label1103:
        label1126:
        if (n == 0)
        {
          i1 = 0;
        }
        else
        {
          i1 = 1;
          continue;
          i1 = 0;
          continue;
          i1 = 0;
          continue;
          n = 1;
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
        ((JSONObject)localObject3).put("TBSSDKV", 44052);
        ((JSONObject)localObject3).put("TBSV", n);
        if (!paramBoolean3) {
          break label1185;
        }
        i1 = 1;
        ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", i1);
        localObject1 = localTbsDownloadConfig.mSyncMap;
        if (!paramBoolean3) {
          break label1191;
        }
        i1 = 1;
        ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(i1));
        localTbsDownloadConfig.commit();
        if (n != 0) {
          ((JSONObject)localObject3).put("TBSBACKUPV", g.b(paramBoolean3));
        }
        ((JSONObject)localObject3).put("CPU", e);
        ((JSONObject)localObject3).put("UA", str1);
        ((JSONObject)localObject3).put("IMSI", a(str2));
        ((JSONObject)localObject3).put("IMEI", a(str3));
        ((JSONObject)localObject3).put("ANDROID_ID", a(str4));
        ((JSONObject)localObject3).put("GUID", b.e(c));
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          TbsLog.d("TbsDownload", "tbsLocalVersion: ".concat(String.valueOf(n)));
          if (n == 0) {
            break label1090;
          }
          if (!QbSdk.a(c, n)) {
            break label1197;
          }
          n = 0;
          ((JSONObject)localObject3).put("STATUS", n);
          if (!r.b(c)) {
            break label1103;
          }
          n = TbsShareManager.getTbsStableCoreVersion(c, 0);
          label646:
          ((JSONObject)localObject3).put("TBSDV", n);
        }
        paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
        if (!QbSdk.isEnableSensitiveApi()) {
          break label1126;
        }
        localObject1 = QbSdk.a(c, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label1126;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label1151;
      }
      for (;;)
      {
        if (n != 0) {
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
        label801:
        label804:
        label816:
        if (paramBoolean3) {}
        for (i1 = q.a().j(c);; i1 = q.a().n(c))
        {
          n = i1;
          if (i1 == 0)
          {
            n = i1;
            if (q.a().m(c))
            {
              i1 = -1;
              n = i1;
              if ("com.tencent.mobileqq".equals(c.getApplicationInfo().packageName))
              {
                TbsDownloadUpload.clear();
                localObject1 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject1).a.put("tbs_local_core_version", Integer.valueOf(-1));
                ((TbsDownloadUpload)localObject1).commit();
                TbsPVConfig.releaseInstance();
                n = i1;
                if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                  n = q.a().j(c);
                }
              }
            }
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + n + " isDownloadForeground=" + paramBoolean2);
          if (!paramBoolean2) {
            break;
          }
          if (q.a().m(c)) {
            break label1148;
          }
          n = 0;
          break label1148;
        }
        localException2.put("FUNCTION", i1);
        break label249;
        localObject1 = a(paramBoolean3);
        if ((Apn.getApnType(c) == 3) || (((JSONArray)localObject1).length() == 0) || (n != 0) || (!paramBoolean1)) {
          break label314;
        }
        localException2.put("TBSBACKUPARR", localObject1);
        break label314;
        localException2.put("STATUS", 0);
        break label629;
        n = q.a().i(c);
        break label646;
        do
        {
          n = 0;
          break label718;
          do
          {
            n = 0;
            break label718;
            paramBoolean1 = false;
            continue;
            break label235;
            localObject1 = "";
            break label129;
            localObject2 = "";
            break;
            break label235;
          } while (!paramBoolean1);
        } while (paramBoolean3);
        n = 1;
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(54137);
    String[] arrayOfString = f();
    int i2 = arrayOfString.length;
    int n = 0;
    String str;
    int i3;
    Context localContext;
    if (n < i2)
    {
      str = arrayOfString[n];
      i3 = TbsShareManager.getSharedTbsCoreVersion(c, str);
      if (i3 > 0)
      {
        localContext = TbsShareManager.getPackageContext(c, str, true);
        if ((localContext == null) || (q.a().g(localContext))) {
          break label93;
        }
        TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
      }
    }
    label276:
    label281:
    for (;;)
    {
      n += 1;
      break;
      label93:
      int i1 = 0;
      label95:
      if (i1 < paramJSONArray.length()) {
        if (paramJSONArray.optInt(i1) != i3) {}
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label281;
        }
        paramJSONArray.put(i3);
        break;
        i1 += 1;
        break label95;
        arrayOfString = f();
        i2 = arrayOfString.length;
        n = 0;
        if (n < i2)
        {
          str = arrayOfString[n];
          i3 = TbsShareManager.getCoreShareDecoupleCoreVersion(c, str);
          if (i3 > 0)
          {
            localContext = TbsShareManager.getPackageContext(c, str, true);
            if ((localContext == null) || (q.a().g(localContext))) {
              break label223;
            }
            TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
          }
        }
        for (;;)
        {
          n += 1;
          break;
          label223:
          i1 = 0;
          label225:
          if (i1 < paramJSONArray.length()) {
            if (paramJSONArray.optInt(i1) != i3) {}
          }
          for (i1 = 1;; i1 = 0)
          {
            if (i1 != 0) {
              break label276;
            }
            paramJSONArray.put(i3);
            break;
            i1 += 1;
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
    int i1 = 1;
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
      n = 1;
      localMessage.arg1 = n;
      if (!paramBoolean2) {
        break label93;
      }
    }
    label93:
    for (int n = i1;; n = 0)
    {
      localMessage.arg2 = n;
      localMessage.sendToTarget();
      AppMethodBeat.o(54134);
      return;
      n = 0;
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
    c.a().a(paramContext, Integer.valueOf(1000), new c.a()
    {
      public final void a(String paramAnonymousString)
      {
        AppMethodBeat.i(196637);
        TbsLog.e("TBSEmergency", "Execute command [1000](" + paramAnonymousString + "), force tbs downloader request");
        paramAnonymousString = this.a.mPreferences.edit();
        paramAnonymousString.putLong("last_check", 0L);
        paramAnonymousString.apply();
        paramAnonymousString.commit();
        AppMethodBeat.o(196637);
      }
    });
    paramContext = null;
    String str1;
    int n;
    String str2;
    String str3;
    int i1;
    String str4;
    long l2;
    long l1;
    if (!paramBoolean1)
    {
      str1 = ((TbsDownloadConfig)localObject).mPreferences.getString("app_versionname", null);
      n = ((TbsDownloadConfig)localObject).mPreferences.getInt("app_versioncode", 0);
      str2 = ((TbsDownloadConfig)localObject).mPreferences.getString("app_metadata", null);
      str3 = b.c(c);
      i1 = b.d(c);
      str4 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + str3 + " oldAppVersionName=" + str1 + " appVersionCode=" + i1 + " oldAppVersionCode=" + n + " appMetadata=" + str4 + " oldAppVersionMetadata=" + str2);
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
      int i2 = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
      int i3 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      if ((l2 - l1 <= 1000L * l5) && ((i2 <= q.a().j(c)) || (i2 <= i3)) && ((!TbsShareManager.isThirdPartyApp(c)) || (l3 <= 0L) || (l2 - l3 <= l5 * 1000L) || (l4 >= 11L)))
      {
        if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!e())) {
          q.a().e(c);
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
          if ((str3 == null) || (i1 == 0) || (str4 == null)) {
            break;
          }
          if ((str3.equals(str1)) && (i1 == n) && (str4.equals(str2))) {
            break label756;
          }
        }
        if (!TbsShareManager.isThirdPartyApp(c)) {
          break label756;
        }
      }
    }
    label756:
    for (paramContext = "timeNow - timeLastCheck is " + (l2 - l1) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + str3 + " appVersionCode is " + i1 + " appMetadata is " + str4 + " oldAppVersionName is " + str1 + " oldAppVersionCode is " + n + " oldAppVersionMetadata is " + str2;; paramContext = null)
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
    //   0: ldc_w 732
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 27
    //   8: new 132	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 734
    //   15: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 736
    //   25: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload 4
    //   30: invokevirtual 194	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   42: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   45: astore 32
    //   47: aload_0
    //   48: invokestatic 582	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifeq +41 -> 92
    //   54: iload_2
    //   55: ifeq +26 -> 81
    //   58: aload 32
    //   60: bipush 148
    //   62: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   65: ldc 27
    //   67: ldc_w 738
    //   70: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 732
    //   76: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_0
    //   80: ireturn
    //   81: aload 32
    //   83: sipush -208
    //   86: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   89: goto -24 -> 65
    //   92: new 235	org/json/JSONObject
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 739	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   100: astore 33
    //   102: aload 33
    //   104: ldc_w 741
    //   107: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   110: istore 5
    //   112: iload 5
    //   114: ifeq +49 -> 163
    //   117: iload_2
    //   118: ifeq +34 -> 152
    //   121: aload 32
    //   123: bipush 147
    //   125: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   128: ldc 27
    //   130: ldc_w 745
    //   133: iload 5
    //   135: invokestatic 376	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: ldc_w 732
    //   147: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: aload 32
    //   154: sipush -209
    //   157: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   160: goto -32 -> 128
    //   163: aload 33
    //   165: ldc_w 747
    //   168: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   171: istore 13
    //   173: aload 33
    //   175: ldc_w 749
    //   178: invokevirtual 751	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 34
    //   183: aload 33
    //   185: ldc_w 753
    //   188: ldc 166
    //   190: invokevirtual 756	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 35
    //   195: aload 33
    //   197: ldc_w 758
    //   200: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   203: istore 12
    //   205: aload 33
    //   207: ldc_w 760
    //   210: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   213: istore 14
    //   215: aload 33
    //   217: ldc_w 762
    //   220: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   223: istore 15
    //   225: aload 33
    //   227: ldc_w 764
    //   230: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   233: istore 16
    //   235: aload 33
    //   237: ldc_w 766
    //   240: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   243: istore 17
    //   245: aload 33
    //   247: ldc_w 768
    //   250: invokevirtual 771	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   253: lstore 24
    //   255: aload 33
    //   257: ldc_w 773
    //   260: invokevirtual 771	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   263: lstore 26
    //   265: aload 33
    //   267: ldc_w 775
    //   270: lconst_0
    //   271: invokevirtual 778	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   274: lstore 22
    //   276: aload 33
    //   278: ldc_w 780
    //   281: iconst_m1
    //   282: invokevirtual 782	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   285: istore 18
    //   287: iconst_0
    //   288: istore 5
    //   290: aload 33
    //   292: ldc_w 784
    //   295: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   298: istore 6
    //   300: iload 6
    //   302: istore 5
    //   304: aload 32
    //   306: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   309: ldc_w 786
    //   312: iload 5
    //   314: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: invokeinterface 293 3 0
    //   322: pop
    //   323: iload_2
    //   324: ifeq +59 -> 383
    //   327: getstatic 788	com/tencent/smtt/sdk/QbSdk:h	Z
    //   330: ifeq +53 -> 383
    //   333: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   336: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   339: ifeq +44 -> 383
    //   342: aload 33
    //   344: ldc_w 790
    //   347: iconst_0
    //   348: invokevirtual 782	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   351: istore 5
    //   353: invokestatic 795	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   356: astore_0
    //   357: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   360: astore 28
    //   362: iload 5
    //   364: iconst_1
    //   365: if_icmpne +813 -> 1178
    //   368: iconst_1
    //   369: istore 19
    //   371: aload_0
    //   372: aload 28
    //   374: ldc_w 797
    //   377: iload 19
    //   379: invokevirtual 801	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   382: pop
    //   383: iload_2
    //   384: ifeq +189 -> 573
    //   387: aload 33
    //   389: ldc_w 803
    //   392: iconst_0
    //   393: invokevirtual 782	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   396: istore 5
    //   398: iload 5
    //   400: iconst_1
    //   401: iand
    //   402: ifeq +812 -> 1214
    //   405: iconst_1
    //   406: istore 19
    //   408: invokestatic 795	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   411: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   414: ldc_w 805
    //   417: iload 19
    //   419: invokevirtual 801	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   422: pop
    //   423: ldc 27
    //   425: ldc_w 807
    //   428: iload 19
    //   430: invokestatic 570	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   433: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 810	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: iload 5
    //   441: iconst_2
    //   442: iand
    //   443: ifeq +777 -> 1220
    //   446: iconst_1
    //   447: istore 19
    //   449: invokestatic 795	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   452: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   455: ldc_w 812
    //   458: iload 19
    //   460: invokevirtual 801	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   463: pop
    //   464: ldc 27
    //   466: ldc_w 814
    //   469: iload 19
    //   471: invokestatic 570	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   474: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   477: invokestatic 810	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: iload 5
    //   482: iconst_4
    //   483: iand
    //   484: ifeq +742 -> 1226
    //   487: iconst_1
    //   488: istore 19
    //   490: invokestatic 795	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   493: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   496: ldc_w 816
    //   499: iload 19
    //   501: invokevirtual 801	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   504: pop
    //   505: iload 19
    //   507: invokestatic 820	com/tencent/smtt/sdk/QbSdk:setDisableUnpreinitBySwitch	(Z)V
    //   510: ldc 27
    //   512: ldc_w 822
    //   515: iload 19
    //   517: invokestatic 570	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   520: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   523: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: iload 5
    //   528: bipush 8
    //   530: iand
    //   531: ifeq +701 -> 1232
    //   534: iconst_1
    //   535: istore 19
    //   537: invokestatic 795	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   540: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   543: ldc_w 824
    //   546: iload 19
    //   548: invokevirtual 801	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   551: pop
    //   552: iload 19
    //   554: invokestatic 827	com/tencent/smtt/sdk/QbSdk:setDisableUseHostBackupCoreBySwitch	(Z)V
    //   557: ldc 27
    //   559: ldc_w 829
    //   562: iload 19
    //   564: invokestatic 570	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   567: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   570: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   594: ldc 166
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
    //   620: ldc_w 831
    //   623: invokevirtual 751	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   654: ldc_w 833
    //   657: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
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
    //   688: ldc_w 835
    //   691: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
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
    //   722: ldc_w 837
    //   725: invokevirtual 840	org/json/JSONObject:has	(Ljava/lang/String;)Z
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
    //   757: ldc_w 837
    //   760: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   763: ifeq +505 -> 1268
    //   766: iconst_1
    //   767: istore 5
    //   769: goto +2431 -> 3200
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
    //   801: ldc_w 842
    //   804: invokevirtual 840	org/json/JSONObject:has	(Ljava/lang/String;)Z
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
    //   836: ldc_w 842
    //   839: invokevirtual 751	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   868: ldc_w 844
    //   871: invokevirtual 840	org/json/JSONObject:has	(Ljava/lang/String;)Z
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
    //   902: ldc_w 844
    //   905: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   908: ifeq +366 -> 1274
    //   911: iconst_1
    //   912: istore 19
    //   914: goto +2289 -> 3203
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
    //   942: ldc_w 846
    //   945: invokevirtual 840	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   948: ifeq +2246 -> 3194
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
    //   976: ldc_w 846
    //   979: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
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
    //   1006: ldc_w 848
    //   1009: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1012: istore 8
    //   1014: iconst_0
    //   1015: istore 9
    //   1017: aload 33
    //   1019: ldc_w 850
    //   1022: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1025: istore 10
    //   1027: iload 10
    //   1029: istore 9
    //   1031: getstatic 56	com/tencent/smtt/sdk/TbsDownloader:f	Ljava/lang/Object;
    //   1034: astore 29
    //   1036: aload 29
    //   1038: monitorenter
    //   1039: iload 5
    //   1041: ifeq +19 -> 1060
    //   1044: aload 32
    //   1046: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1049: ldc_w 852
    //   1052: ldc 166
    //   1054: invokeinterface 293 3 0
    //   1059: pop
    //   1060: aload_0
    //   1061: invokestatic 582	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1064: ifne +54 -> 1118
    //   1067: aload_0
    //   1068: invokevirtual 853	java/lang/String:length	()I
    //   1071: bipush 96
    //   1073: if_icmpne +45 -> 1118
    //   1076: new 132	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 854	java/lang/StringBuilder:<init>	()V
    //   1083: aload_0
    //   1084: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: ldc_w 856
    //   1090: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokestatic 860	com/tencent/smtt/utils/h:c	()Ljava/lang/String;
    //   1096: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: astore_0
    //   1103: aload 32
    //   1105: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1108: ldc_w 852
    //   1111: aload_0
    //   1112: invokeinterface 293 3 0
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
    //   1135: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1138: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1141: astore_0
    //   1142: iload 9
    //   1144: iconst_1
    //   1145: if_icmpne +194 -> 1339
    //   1148: iconst_1
    //   1149: istore_3
    //   1150: aload_0
    //   1151: iload_3
    //   1152: invokestatic 864	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   1155: ldc 27
    //   1157: ldc_w 866
    //   1160: iload_2
    //   1161: invokestatic 570	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1164: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1167: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1170: ldc_w 732
    //   1173: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1176: iconst_0
    //   1177: ireturn
    //   1178: iconst_0
    //   1179: istore 19
    //   1181: goto -810 -> 371
    //   1184: astore_0
    //   1185: ldc_w 868
    //   1188: new 132	java/lang/StringBuilder
    //   1191: dup
    //   1192: ldc_w 870
    //   1195: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1198: aload_0
    //   1199: invokevirtual 871	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1202: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1239: ldc_w 868
    //   1242: new 132	java/lang/StringBuilder
    //   1245: dup
    //   1246: ldc_w 870
    //   1249: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1252: aload_0
    //   1253: invokevirtual 871	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1256: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1262: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1265: goto -692 -> 573
    //   1268: iconst_0
    //   1269: istore 5
    //   1271: goto +1929 -> 3200
    //   1274: iconst_0
    //   1275: istore 19
    //   1277: goto +1926 -> 3203
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
    //   1320: ldc_w 732
    //   1323: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1326: aload_0
    //   1327: athrow
    //   1328: aload 32
    //   1330: sipush -210
    //   1333: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1336: goto -198 -> 1138
    //   1339: iconst_0
    //   1340: istore_3
    //   1341: goto -191 -> 1150
    //   1344: iload 19
    //   1346: ifne +10 -> 1356
    //   1349: aload 32
    //   1351: iload 19
    //   1353: invokevirtual 874	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockEnable	(Z)V
    //   1356: iload 20
    //   1358: ifne +10 -> 1368
    //   1361: aload 32
    //   1363: iload 20
    //   1365: invokevirtual 877	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockWaitEnable	(Z)V
    //   1368: iload 8
    //   1370: iconst_1
    //   1371: if_icmpne +9 -> 1380
    //   1374: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1377: invokestatic 880	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   1380: iload 7
    //   1382: iconst_1
    //   1383: if_icmpne +22 -> 1405
    //   1386: getstatic 516	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1389: bipush 104
    //   1391: invokevirtual 521	android/os/Handler:removeMessages	(I)V
    //   1394: getstatic 516	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1397: bipush 104
    //   1399: invokestatic 527	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1402: invokevirtual 540	android/os/Message:sendToTarget	()V
    //   1405: iload 18
    //   1407: iconst_1
    //   1408: if_icmpne +1775 -> 3183
    //   1411: lload 22
    //   1413: ldc2_w 881
    //   1416: lcmp
    //   1417: ifle +1774 -> 3191
    //   1420: ldc2_w 881
    //   1423: lstore 22
    //   1425: lload 22
    //   1427: lconst_0
    //   1428: lcmp
    //   1429: ifle +1754 -> 3183
    //   1432: invokestatic 885	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1435: lconst_0
    //   1436: lcmp
    //   1437: iflt +8 -> 1445
    //   1440: invokestatic 885	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1443: lstore 22
    //   1445: aload 32
    //   1447: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1450: ldc_w 887
    //   1453: lload 22
    //   1455: invokestatic 892	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1458: invokeinterface 293 3 0
    //   1463: pop
    //   1464: iconst_0
    //   1465: istore 5
    //   1467: iconst_0
    //   1468: istore 6
    //   1470: iload_2
    //   1471: ifeq +256 -> 1727
    //   1474: aload 33
    //   1476: ldc_w 894
    //   1479: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1482: istore 7
    //   1484: iload 7
    //   1486: istore 5
    //   1488: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1491: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1494: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1497: ldc_w 340
    //   1500: iconst_0
    //   1501: invokeinterface 327 3 0
    //   1506: istore 7
    //   1508: iload 7
    //   1510: istore 6
    //   1512: iload 5
    //   1514: istore 7
    //   1516: iload_2
    //   1517: ifeq +36 -> 1553
    //   1520: iload 5
    //   1522: istore 7
    //   1524: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1527: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1530: ifne +23 -> 1553
    //   1533: iload 5
    //   1535: istore 7
    //   1537: iload 5
    //   1539: ifne +14 -> 1553
    //   1542: invokestatic 431	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1545: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1548: invokevirtual 483	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   1551: istore 7
    //   1553: ldc 27
    //   1555: ldc_w 896
    //   1558: iload 7
    //   1560: invokestatic 376	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1563: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1566: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1569: aload 32
    //   1571: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1574: ldc_w 898
    //   1577: iload 7
    //   1579: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1582: invokeinterface 293 3 0
    //   1587: pop
    //   1588: aload 32
    //   1590: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1593: ldc_w 340
    //   1596: iload 6
    //   1598: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1601: invokeinterface 293 3 0
    //   1606: pop
    //   1607: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1610: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1613: ifne +46 -> 1659
    //   1616: iload 7
    //   1618: ifle +136 -> 1754
    //   1621: iload 7
    //   1623: invokestatic 431	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1626: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1629: invokevirtual 483	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   1632: if_icmpeq +122 -> 1754
    //   1635: iload 7
    //   1637: invokestatic 431	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1640: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1643: invokevirtual 434	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   1646: if_icmpne +108 -> 1754
    //   1649: invokestatic 431	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1652: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1655: invokevirtual 900	com/tencent/smtt/sdk/q:o	(Landroid/content/Context;)Z
    //   1658: pop
    //   1659: aload 34
    //   1661: invokestatic 582	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1664: ifeq +114 -> 1778
    //   1667: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1670: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1673: ifeq +105 -> 1778
    //   1676: aload 32
    //   1678: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1681: ldc_w 902
    //   1684: getstatic 906	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1687: invokeinterface 293 3 0
    //   1692: pop
    //   1693: aload 32
    //   1695: invokevirtual 296	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1698: iload_2
    //   1699: ifeq +12 -> 1711
    //   1702: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1705: iload 12
    //   1707: iconst_0
    //   1708: invokestatic 910	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1711: ldc 27
    //   1713: ldc_w 912
    //   1716: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1719: ldc_w 732
    //   1722: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1725: iconst_0
    //   1726: ireturn
    //   1727: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1730: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1733: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1736: ldc_w 898
    //   1739: iconst_0
    //   1740: invokeinterface 327 3 0
    //   1745: istore 7
    //   1747: iload 7
    //   1749: istore 5
    //   1751: goto -263 -> 1488
    //   1754: iload 7
    //   1756: ifne -97 -> 1659
    //   1759: invokestatic 431	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1762: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1765: invokevirtual 916	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   1768: invokestatic 919	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   1771: goto -112 -> 1659
    //   1774: astore_0
    //   1775: goto -116 -> 1659
    //   1778: ldc 27
    //   1780: ldc_w 921
    //   1783: iload 13
    //   1785: invokestatic 376	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1788: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1791: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1794: iload 13
    //   1796: ifne +127 -> 1923
    //   1799: aload 32
    //   1801: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1804: ldc_w 923
    //   1807: iload 13
    //   1809: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1812: invokeinterface 293 3 0
    //   1817: pop
    //   1818: aload 32
    //   1820: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1823: ldc_w 902
    //   1826: getstatic 906	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1829: invokeinterface 293 3 0
    //   1834: pop
    //   1835: iload_2
    //   1836: ifeq +56 -> 1892
    //   1839: aload 32
    //   1841: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1844: ldc_w 925
    //   1847: bipush 145
    //   1849: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1852: invokeinterface 293 3 0
    //   1857: pop
    //   1858: aload 32
    //   1860: invokevirtual 296	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1863: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1866: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1869: ifne +7 -> 1876
    //   1872: invokestatic 928	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1875: pop
    //   1876: ldc 27
    //   1878: ldc_w 930
    //   1881: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1884: ldc_w 732
    //   1887: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1890: iconst_0
    //   1891: ireturn
    //   1892: aload 32
    //   1894: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1897: ldc_w 925
    //   1900: sipush -211
    //   1903: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1906: invokeinterface 293 3 0
    //   1911: pop
    //   1912: aload 32
    //   1914: sipush -211
    //   1917: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1920: goto -62 -> 1858
    //   1923: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1926: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1929: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1932: ldc_w 426
    //   1935: iconst_0
    //   1936: invokeinterface 327 3 0
    //   1941: istore 8
    //   1943: iload 8
    //   1945: iload 12
    //   1947: if_icmple +18 -> 1965
    //   1950: getstatic 350	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   1953: invokevirtual 932	com/tencent/smtt/sdk/m:c	()V
    //   1956: invokestatic 431	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1959: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1962: invokevirtual 935	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   1965: iconst_0
    //   1966: istore 5
    //   1968: iconst_0
    //   1969: istore 7
    //   1971: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1974: invokestatic 267	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1977: ifne +63 -> 2040
    //   1980: invokestatic 431	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1983: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1986: iconst_0
    //   1987: invokevirtual 937	com/tencent/smtt/sdk/q:e	(Landroid/content/Context;I)I
    //   1990: istore 9
    //   1992: iload 7
    //   1994: istore 5
    //   1996: iload 9
    //   1998: iload 12
    //   2000: if_icmplt +6 -> 2006
    //   2003: iconst_1
    //   2004: istore 5
    //   2006: ldc 27
    //   2008: new 132	java/lang/StringBuilder
    //   2011: dup
    //   2012: ldc_w 939
    //   2015: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2018: iload 9
    //   2020: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2023: ldc_w 941
    //   2026: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: iload 12
    //   2031: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2034: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2037: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2040: iload_1
    //   2041: iload 12
    //   2043: if_icmpge +16 -> 2059
    //   2046: aload 34
    //   2048: invokestatic 582	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2051: ifne +8 -> 2059
    //   2054: iload 5
    //   2056: ifeq +276 -> 2332
    //   2059: iload 6
    //   2061: iconst_1
    //   2062: if_icmpeq +270 -> 2332
    //   2065: aload 32
    //   2067: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2070: ldc_w 902
    //   2073: getstatic 906	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2076: invokeinterface 293 3 0
    //   2081: pop
    //   2082: iload_2
    //   2083: ifeq +175 -> 2258
    //   2086: aload 34
    //   2088: invokestatic 582	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2091: ifeq +90 -> 2181
    //   2094: aload 32
    //   2096: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2099: ldc_w 925
    //   2102: bipush 132
    //   2104: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2107: invokeinterface 293 3 0
    //   2112: pop
    //   2113: aload 32
    //   2115: invokevirtual 296	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2118: ldc 27
    //   2120: new 132	java/lang/StringBuilder
    //   2123: dup
    //   2124: ldc_w 943
    //   2127: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2130: iload_1
    //   2131: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2134: ldc_w 945
    //   2137: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2140: iload 12
    //   2142: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2145: ldc_w 947
    //   2148: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: iload 8
    //   2153: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2156: ldc_w 949
    //   2159: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: aload 34
    //   2164: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2170: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2173: ldc_w 732
    //   2176: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2179: iconst_0
    //   2180: ireturn
    //   2181: iload 12
    //   2183: ifgt +25 -> 2208
    //   2186: aload 32
    //   2188: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2191: ldc_w 925
    //   2194: bipush 131
    //   2196: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2199: invokeinterface 293 3 0
    //   2204: pop
    //   2205: goto -92 -> 2113
    //   2208: iload_1
    //   2209: iload 12
    //   2211: if_icmplt +25 -> 2236
    //   2214: aload 32
    //   2216: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2219: ldc_w 925
    //   2222: bipush 129
    //   2224: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2227: invokeinterface 293 3 0
    //   2232: pop
    //   2233: goto -120 -> 2113
    //   2236: aload 32
    //   2238: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2241: ldc_w 925
    //   2244: bipush 144
    //   2246: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2249: invokeinterface 293 3 0
    //   2254: pop
    //   2255: goto -142 -> 2113
    //   2258: sipush -212
    //   2261: istore 5
    //   2263: aload 34
    //   2265: invokestatic 582	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2268: ifeq +37 -> 2305
    //   2271: sipush -217
    //   2274: istore 5
    //   2276: aload 32
    //   2278: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2281: ldc_w 925
    //   2284: iload 5
    //   2286: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2289: invokeinterface 293 3 0
    //   2294: pop
    //   2295: aload 32
    //   2297: iload 5
    //   2299: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
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
    //   2336: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2339: ldc_w 951
    //   2342: aconst_null
    //   2343: invokeinterface 317 3 0
    //   2348: invokevirtual 105	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2351: ifne +45 -> 2396
    //   2354: getstatic 350	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2357: invokevirtual 932	com/tencent/smtt/sdk/m:c	()V
    //   2360: aload 32
    //   2362: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2365: ldc_w 953
    //   2368: iconst_0
    //   2369: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2372: invokeinterface 293 3 0
    //   2377: pop
    //   2378: aload 32
    //   2380: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2383: ldc_w 955
    //   2386: iconst_0
    //   2387: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2390: invokeinterface 293 3 0
    //   2395: pop
    //   2396: aload 32
    //   2398: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2401: ldc_w 426
    //   2404: iload 12
    //   2406: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2409: invokeinterface 293 3 0
    //   2414: pop
    //   2415: ldc 27
    //   2417: ldc_w 957
    //   2420: iload 12
    //   2422: invokestatic 376	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2425: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2428: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2431: iload 12
    //   2433: ifle +43 -> 2476
    //   2436: iload 6
    //   2438: iconst_1
    //   2439: if_icmpne +344 -> 2783
    //   2442: aload 32
    //   2444: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2447: ldc_w 959
    //   2450: iconst_1
    //   2451: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2454: invokeinterface 293 3 0
    //   2459: pop
    //   2460: ldc 27
    //   2462: ldc_w 961
    //   2465: iload 6
    //   2467: invokestatic 376	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2470: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2473: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2476: aload 32
    //   2478: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2481: ldc_w 951
    //   2484: aload 34
    //   2486: invokeinterface 293 3 0
    //   2491: pop
    //   2492: aload 32
    //   2494: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2497: ldc_w 963
    //   2500: aload 35
    //   2502: invokeinterface 293 3 0
    //   2507: pop
    //   2508: aload 32
    //   2510: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2513: ldc_w 923
    //   2516: iload 13
    //   2518: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2521: invokeinterface 293 3 0
    //   2526: pop
    //   2527: aload 32
    //   2529: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2532: ldc_w 965
    //   2535: iload 14
    //   2537: iconst_2
    //   2538: imul
    //   2539: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2542: invokeinterface 293 3 0
    //   2547: pop
    //   2548: aload 32
    //   2550: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2553: ldc_w 967
    //   2556: iload 15
    //   2558: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2561: invokeinterface 293 3 0
    //   2566: pop
    //   2567: aload 32
    //   2569: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2572: ldc_w 969
    //   2575: iload 16
    //   2577: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2580: invokeinterface 293 3 0
    //   2585: pop
    //   2586: aload 32
    //   2588: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2591: ldc_w 971
    //   2594: iload 17
    //   2596: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2599: invokeinterface 293 3 0
    //   2604: pop
    //   2605: aload 32
    //   2607: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2610: ldc_w 973
    //   2613: lload 24
    //   2615: invokestatic 892	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2618: invokeinterface 293 3 0
    //   2623: pop
    //   2624: aload 32
    //   2626: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2629: ldc_w 975
    //   2632: lload 26
    //   2634: invokestatic 892	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2637: invokeinterface 293 3 0
    //   2642: pop
    //   2643: aload 32
    //   2645: invokevirtual 296	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2648: aload 28
    //   2650: ifnull +19 -> 2669
    //   2653: aload 32
    //   2655: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2658: ldc_w 977
    //   2661: aload 28
    //   2663: invokeinterface 293 3 0
    //   2668: pop
    //   2669: iload_3
    //   2670: ifne +165 -> 2835
    //   2673: iload 4
    //   2675: ifeq +160 -> 2835
    //   2678: invokestatic 431	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   2681: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2684: iload 12
    //   2686: invokevirtual 979	com/tencent/smtt/sdk/q:b	(Landroid/content/Context;I)Z
    //   2689: ifeq +146 -> 2835
    //   2692: iload_2
    //   2693: ifeq +111 -> 2804
    //   2696: aload 32
    //   2698: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2701: ldc_w 925
    //   2704: bipush 143
    //   2706: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2709: invokeinterface 293 3 0
    //   2714: pop
    //   2715: aload 32
    //   2717: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2720: ldc_w 902
    //   2723: getstatic 906	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2726: invokeinterface 293 3 0
    //   2731: pop
    //   2732: ldc 27
    //   2734: ldc_w 981
    //   2737: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2740: aload 33
    //   2742: ldc_w 983
    //   2745: iconst_0
    //   2746: invokevirtual 782	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2749: iconst_1
    //   2750: if_icmpne +20 -> 2770
    //   2753: aload 32
    //   2755: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2758: ldc_w 985
    //   2761: getstatic 988	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2764: invokeinterface 293 3 0
    //   2769: pop
    //   2770: aload 32
    //   2772: invokevirtual 296	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2775: ldc_w 732
    //   2778: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2781: iconst_1
    //   2782: ireturn
    //   2783: aload 32
    //   2785: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2788: ldc_w 959
    //   2791: iconst_0
    //   2792: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2795: invokeinterface 293 3 0
    //   2800: pop
    //   2801: goto -341 -> 2460
    //   2804: aload 32
    //   2806: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2809: ldc_w 925
    //   2812: sipush -213
    //   2815: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2818: invokeinterface 293 3 0
    //   2823: pop
    //   2824: aload 32
    //   2826: sipush -213
    //   2829: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2832: goto -117 -> 2715
    //   2835: iload_3
    //   2836: ifne +151 -> 2987
    //   2839: iload 4
    //   2841: ifeq +146 -> 2987
    //   2844: getstatic 350	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2847: astore_0
    //   2848: iload 13
    //   2850: iconst_1
    //   2851: if_icmpeq +9 -> 2860
    //   2854: iload 13
    //   2856: iconst_2
    //   2857: if_icmpne +108 -> 2965
    //   2860: iconst_1
    //   2861: istore 4
    //   2863: aload_0
    //   2864: iload_3
    //   2865: iload 4
    //   2867: invokevirtual 991	com/tencent/smtt/sdk/m:a	(ZZ)Z
    //   2870: ifeq +117 -> 2987
    //   2873: aload 32
    //   2875: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2878: ldc_w 902
    //   2881: getstatic 906	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2884: invokeinterface 293 3 0
    //   2889: pop
    //   2890: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2893: invokestatic 685	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2896: invokevirtual 689	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2899: astore_0
    //   2900: aload_0
    //   2901: bipush 100
    //   2903: invokevirtual 694	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2906: aload_0
    //   2907: new 132	java/lang/StringBuilder
    //   2910: dup
    //   2911: ldc_w 993
    //   2914: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2917: getstatic 350	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2920: getfield 995	com/tencent/smtt/sdk/m:a	Ljava/lang/String;
    //   2923: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2926: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2929: invokevirtual 697	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2932: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2935: invokestatic 997	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2938: ifeq +33 -> 2971
    //   2941: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2944: invokestatic 685	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2947: getstatic 1000	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2950: aload_0
    //   2951: invokevirtual 707	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2954: ldc 27
    //   2956: ldc_w 1002
    //   2959: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2962: goto -222 -> 2740
    //   2965: iconst_0
    //   2966: istore 4
    //   2968: goto -105 -> 2863
    //   2971: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2974: invokestatic 685	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2977: getstatic 703	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2980: aload_0
    //   2981: invokevirtual 707	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2984: goto -30 -> 2954
    //   2987: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2990: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2993: getfield 309	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2996: ldc_w 959
    //   2999: iconst_0
    //   3000: invokeinterface 327 3 0
    //   3005: iconst_1
    //   3006: if_icmpne +120 -> 3126
    //   3009: getstatic 350	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   3012: invokevirtual 1004	com/tencent/smtt/sdk/m:a	()Z
    //   3015: ifeq +111 -> 3126
    //   3018: aload 32
    //   3020: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3023: ldc_w 902
    //   3026: getstatic 906	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3029: invokeinterface 293 3 0
    //   3034: pop
    //   3035: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3038: invokestatic 685	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3041: invokevirtual 689	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3044: astore_0
    //   3045: aload_0
    //   3046: bipush 100
    //   3048: invokevirtual 694	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   3051: aload_0
    //   3052: new 132	java/lang/StringBuilder
    //   3055: dup
    //   3056: ldc_w 1006
    //   3059: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3062: getstatic 350	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   3065: getfield 995	com/tencent/smtt/sdk/m:a	Ljava/lang/String;
    //   3068: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3074: invokevirtual 697	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   3077: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3080: invokestatic 997	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   3083: ifeq +27 -> 3110
    //   3086: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3089: invokestatic 685	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3092: getstatic 1000	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3095: aload_0
    //   3096: invokevirtual 707	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3099: ldc 27
    //   3101: ldc_w 1008
    //   3104: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3107: goto -367 -> 2740
    //   3110: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3113: invokestatic 685	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3116: getstatic 703	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3119: aload_0
    //   3120: invokevirtual 707	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3123: goto -24 -> 3099
    //   3126: iload_2
    //   3127: ifne +11 -> 3138
    //   3130: aload 32
    //   3132: sipush -216
    //   3135: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3138: aload 32
    //   3140: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3143: ldc_w 902
    //   3146: getstatic 988	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   3149: invokeinterface 293 3 0
    //   3154: pop
    //   3155: ldc 27
    //   3157: ldc_w 1010
    //   3160: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3163: goto -423 -> 2740
    //   3166: astore_0
    //   3167: goto -1655 -> 1512
    //   3170: astore_0
    //   3171: goto -1683 -> 1488
    //   3174: astore 29
    //   3176: goto -2145 -> 1031
    //   3179: astore_0
    //   3180: goto -2876 -> 304
    //   3183: ldc2_w 1011
    //   3186: lstore 22
    //   3188: goto -1756 -> 1432
    //   3191: goto -1766 -> 1425
    //   3194: iconst_1
    //   3195: istore 20
    //   3197: goto -2205 -> 992
    //   3200: goto -2428 -> 772
    //   3203: goto -2286 -> 917
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3206	0	paramString	String
    //   0	3206	1	paramInt	int
    //   0	3206	2	paramBoolean1	boolean
    //   0	3206	3	paramBoolean2	boolean
    //   0	3206	4	paramBoolean3	boolean
    //   110	2218	5	n	int
    //   298	2168	6	i1	int
    //   612	1381	7	i2	int
    //   608	1544	8	i3	int
    //   577	1442	9	i4	int
    //   580	448	10	i5	int
    //   583	402	11	i6	int
    //   203	2482	12	i7	int
    //   171	2687	13	i8	int
    //   213	2326	14	i9	int
    //   223	2334	15	i10	int
    //   233	2343	16	i11	int
    //   243	2352	17	i12	int
    //   285	1124	18	i13	int
    //   369	983	19	bool1	boolean
    //   604	2592	20	bool2	boolean
    //   589	713	21	bool3	boolean
    //   274	2913	22	l1	long
    //   253	2361	24	l2	long
    //   263	2370	26	l3	long
    //   360	2302	28	localObject1	Object
    //   600	688	29	localObject2	Object
    //   1308	10	29	localException1	Exception
    //   3174	1	29	localException2	Exception
    //   596	215	30	str1	String
    //   626	367	31	str2	String
    //   45	3094	32	localTbsDownloadConfig	TbsDownloadConfig
    //   100	2641	33	localJSONObject	JSONObject
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
    //   1759	1771	1774	java/lang/Throwable
    //   1488	1508	3166	java/lang/Exception
    //   1474	1484	3170	java/lang/Exception
    //   1727	1747	3170	java/lang/Exception
    //   1017	1027	3174	java/lang/Exception
    //   290	300	3179	java/lang/Exception
  }
  
  protected static File b(int paramInt)
  {
    AppMethodBeat.i(54150);
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject = null;
    int i1 = arrayOfString.length;
    int n = 0;
    for (;;)
    {
      String str1;
      if (n < i1)
      {
        str1 = arrayOfString[n];
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
      n += 1;
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
    int i2 = 0;
    AppMethodBeat.i(54138);
    int i3;
    int n;
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      i3 = q.a().a(TbsShareManager.getHostCorePathAppDefined());
      n = 0;
    }
    for (;;)
    {
      int i1 = i2;
      if (n < paramJSONArray.length())
      {
        if (paramJSONArray.optInt(n) == i3) {
          i1 = 1;
        }
      }
      else
      {
        if (i1 == 0) {
          paramJSONArray.put(i3);
        }
        AppMethodBeat.o(54138);
        return;
      }
      n += 1;
    }
  }
  
  private static boolean b(final boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(54143);
    if (paramBoolean1)
    {
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(144));
      ((TbsDownloadUpload)localObject1).commit();
    }
    while ((!paramBoolean1) && (Apn.getApnType(c) != 3) && (!QbSdk.getDownloadWithoutWifi()))
    {
      TbsLog.i("TbsDownload", "current request is download,current network is not wifi,return!");
      AppMethodBeat.o(54143);
      return false;
      if (!paramBoolean3)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(164));
        ((TbsDownloadUpload)localObject1).commit();
      }
    }
    if ((QbSdk.mSettings != null) && (QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      if (paramBoolean1)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(145));
        ((TbsDownloadUpload)localObject1).commit();
      }
      for (;;)
      {
        AppMethodBeat.o(54143);
        return false;
        if (!paramBoolean3)
        {
          localObject1 = TbsDownloadUpload.getInstance(c);
          ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(165));
          ((TbsDownloadUpload)localObject1).commit();
        }
      }
    }
    Object localObject1 = q.a();
    Object localObject2 = c;
    if (g.a == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((q)localObject1).b((Context)localObject2, bool);
      if (!q.a().b(c)) {
        break;
      }
      TbsLog.i("TbsDownload", "need To Rename,no need to send request!");
      AppMethodBeat.o(54143);
      return false;
    }
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    if (q.a().d(c))
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
    localObject2 = f.a(c, 1);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    }
    for (;;)
    {
      localObject2 = new File((String)localObject2, (String)localObject1);
      Object localObject3 = f.a(c, 2);
      label515:
      label550:
      label585:
      label622:
      int i1;
      if (getOverSea(c))
      {
        localObject1 = "x5.oversea.tbs.org";
        localObject3 = new File((String)localObject3, (String)localObject1);
        Object localObject4 = f.a(c, 3);
        if (!getOverSea(c)) {
          break label1124;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject4 = new File((String)localObject4, (String)localObject1);
        String str2 = f.a(c, 4);
        if (!getOverSea(c)) {
          break label1133;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(str2, (String)localObject1);
        if (!((File)localObject1).exists())
        {
          if (!((File)localObject4).exists()) {
            break label1142;
          }
          ((File)localObject4).renameTo((File)localObject1);
        }
        if (e == null)
        {
          e = b.b();
          localTbsDownloadConfig.mSyncMap.put("device_cpuabi", e);
          localTbsDownloadConfig.commit();
        }
        i1 = 0;
        n = i1;
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
        label693:
        break label693;
      }
      int n = i1;
      if (localObject1 != null)
      {
        n = i1;
        if (((Matcher)localObject1).find())
        {
          if (!TbsShareManager.isThirdPartyApp(c)) {
            break label1199;
          }
          TbsLog.e("TbsDownload", "don't support x86 devices,skip send request");
          localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
          if (!paramBoolean1) {
            break label1180;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
          label760:
          ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail("mycpu is " + e);
          TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
          label798:
          n = 1;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("app_versionname", b.c(c));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.d(c)));
      localTbsDownloadConfig.commit();
      localObject1 = a(paramBoolean1, paramBoolean2, paramBoolean3);
      try
      {
        i1 = ((JSONObject)localObject1).getInt("TBSV");
        if ((n != 0) || (i1 != -1))
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
            localTbsDownloadConfig.mSyncMap.put("app_versionname", b.c(c));
            localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.d(c)));
            localTbsDownloadConfig.mSyncMap.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            localTbsDownloadConfig.commit();
            if (n == 0) {
              break label1278;
            }
            if (!paramBoolean1) {
              break label1238;
            }
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(147));
            ((TbsDownloadUpload)localObject1).commit();
            AppMethodBeat.o(54143);
            return false;
            localObject1 = getBackupFileName(false);
            continue;
            localObject1 = getBackupFileName(false);
            break label515;
            label1124:
            localObject1 = getBackupFileName(false);
            break label550;
            label1133:
            localObject1 = getBackupFileName(false);
            break label585;
            label1142:
            if (((File)localObject3).exists())
            {
              ((File)localObject3).renameTo((File)localObject1);
              break label622;
            }
            if (!((File)localObject2).exists()) {
              break label622;
            }
            ((File)localObject2).renameTo((File)localObject1);
            break label622;
            label1180:
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
            ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
            break label760;
            label1199:
            if (paramBoolean1)
            {
              localTbsDownloadConfig.setDownloadInterruptCode(-104);
              break label798;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i1 = -1;
          continue;
          long l1 = 1L;
          continue;
          label1238:
          if (!paramBoolean3)
          {
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(167));
            ((TbsDownloadUpload)localObject1).commit();
          }
        }
        label1278:
        if ((i1 != -1) || (paramBoolean3)) {}
        for (;;)
        {
          try
          {
            String str1 = com.tencent.smtt.utils.o.a(c).d();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=".concat(String.valueOf(str1)));
            if (!paramBoolean1) {
              continue;
            }
            localObject3 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_code", Integer.valueOf(148));
            ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_sent", Integer.valueOf(1));
            ((TbsDownloadUpload)localObject3).commit();
            TbsLog.i("TbsDownload", "sendRequest query 148");
            if (paramBoolean1) {
              l = (JSONObject)localObject1;
            }
            paramBoolean2 = a(com.tencent.smtt.utils.g.a(str1, ((JSONObject)localObject1).toString().getBytes("utf-8"), new g.a()
            {
              public final void a(int paramAnonymousInt)
              {
                AppMethodBeat.i(193549);
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
                    AppMethodBeat.o(193549);
                    return;
                  }
                  this.a.setDownloadInterruptCode(-207);
                }
                AppMethodBeat.o(193549);
              }
            }, false), i1, paramBoolean1, paramBoolean2, paramBoolean4);
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
  
  /* Error */
  private static void c(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 1188
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_0
    //   9: bipush 32
    //   11: if_icmpge +10 -> 21
    //   14: ldc_w 1188
    //   17: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnonnull +10 -> 38
    //   31: ldc_w 1188
    //   34: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: iload_0
    //   39: bipush 64
    //   41: if_icmpne +313 -> 354
    //   44: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   47: ldc_w 262
    //   50: iconst_1
    //   51: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   54: pop
    //   55: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   58: ldc_w 276
    //   61: iconst_2
    //   62: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   65: pop
    //   66: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   69: ldc_w 338
    //   72: iconst_1
    //   73: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   76: pop
    //   77: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   80: iload_0
    //   81: invokestatic 394	com/tencent/smtt/sdk/TbsShareManager:getTbsStableCoreVersion	(Landroid/content/Context;I)I
    //   84: istore_2
    //   85: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   88: ldc_w 396
    //   91: iload_2
    //   92: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   95: pop
    //   96: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   99: ldc_w 336
    //   102: iconst_0
    //   103: invokevirtual 251	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   106: pop
    //   107: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   110: invokestatic 1163	com/tencent/smtt/utils/o:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/o;
    //   113: invokevirtual 1165	com/tencent/smtt/utils/o:d	()Ljava/lang/String;
    //   116: astore 5
    //   118: ldc 27
    //   120: ldc_w 1190
    //   123: aload 5
    //   125: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   128: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: ldc 27
    //   136: new 132	java/lang/StringBuilder
    //   139: dup
    //   140: ldc_w 1192
    //   143: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   149: invokevirtual 424	org/json/JSONObject:toString	()Ljava/lang/String;
    //   152: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 5
    //   163: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   166: invokevirtual 424	org/json/JSONObject:toString	()Ljava/lang/String;
    //   169: ldc_w 1173
    //   172: invokevirtual 1039	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   175: new 16	com/tencent/smtt/sdk/TbsDownloader$6
    //   178: dup
    //   179: invokespecial 1193	com/tencent/smtt/sdk/TbsDownloader$6:<init>	()V
    //   182: iconst_0
    //   183: invokestatic 1181	com/tencent/smtt/utils/g:a	(Ljava/lang/String;[BLcom/tencent/smtt/utils/g$a;Z)Ljava/lang/String;
    //   186: astore 5
    //   188: ldc 27
    //   190: ldc_w 1195
    //   193: aload 5
    //   195: invokestatic 502	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   198: invokevirtual 379	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokestatic 152	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: new 235	org/json/JSONObject
    //   207: dup
    //   208: aload 5
    //   210: invokespecial 739	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   213: astore 5
    //   215: aload 5
    //   217: ldc_w 848
    //   220: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   223: iconst_1
    //   224: if_icmpne +226 -> 450
    //   227: new 118	java/io/File
    //   230: dup
    //   231: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   234: ldc_w 561
    //   237: iconst_0
    //   238: invokestatic 495	com/tencent/smtt/sdk/TbsShareManager:getPackageContext	(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Context;
    //   241: iconst_4
    //   242: invokestatic 1144	com/tencent/smtt/utils/f:a	(Landroid/content/Context;I)Ljava/lang/String;
    //   245: invokespecial 1196	java/io/File:<init>	(Ljava/lang/String;)V
    //   248: astore 6
    //   250: aload 6
    //   252: invokevirtual 1200	java/io/File:listFiles	()[Ljava/io/File;
    //   255: astore 7
    //   257: iconst_0
    //   258: iload_0
    //   259: invokestatic 1203	com/tencent/smtt/utils/a:a	(ZI)Ljava/lang/String;
    //   262: invokestatic 590	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   265: astore 8
    //   267: aload 7
    //   269: arraylength
    //   270: istore_2
    //   271: iload_1
    //   272: iload_2
    //   273: if_icmpge +128 -> 401
    //   276: aload 7
    //   278: iload_1
    //   279: aaload
    //   280: astore 9
    //   282: aload 8
    //   284: aload 9
    //   286: invokevirtual 1206	java/io/File:getName	()Ljava/lang/String;
    //   289: invokevirtual 594	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   292: invokevirtual 599	java/util/regex/Matcher:find	()Z
    //   295: ifeq +52 -> 347
    //   298: aload 9
    //   300: invokevirtual 1209	java/io/File:isFile	()Z
    //   303: ifeq +44 -> 347
    //   306: aload 9
    //   308: invokevirtual 125	java/io/File:exists	()Z
    //   311: ifeq +36 -> 347
    //   314: ldc 27
    //   316: new 132	java/lang/StringBuilder
    //   319: dup
    //   320: ldc_w 1211
    //   323: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   326: aload 9
    //   328: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   331: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: iconst_1
    //   338: invokestatic 1214	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   341: aload 9
    //   343: invokevirtual 1217	java/io/File:delete	()Z
    //   346: pop
    //   347: iload_1
    //   348: iconst_1
    //   349: iadd
    //   350: istore_1
    //   351: goto -80 -> 271
    //   354: iload_0
    //   355: bipush 32
    //   357: if_icmpne -302 -> 55
    //   360: getstatic 64	com/tencent/smtt/sdk/TbsDownloader:l	Lorg/json/JSONObject;
    //   363: ldc_w 262
    //   366: invokevirtual 1220	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   369: pop
    //   370: goto -315 -> 55
    //   373: astore 5
    //   375: new 132	java/lang/StringBuilder
    //   378: dup
    //   379: ldc_w 1222
    //   382: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   385: aload 5
    //   387: invokestatic 1228	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   390: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: ldc_w 1188
    //   397: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: return
    //   401: new 118	java/io/File
    //   404: dup
    //   405: aload 6
    //   407: iconst_0
    //   408: iload_0
    //   409: invokestatic 1230	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(ZI)Ljava/lang/String;
    //   412: invokespecial 1233	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   415: astore 6
    //   417: ldc 27
    //   419: new 132	java/lang/StringBuilder
    //   422: dup
    //   423: ldc_w 1211
    //   426: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   429: aload 6
    //   431: invokevirtual 141	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   434: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: iconst_1
    //   441: invokestatic 1214	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   444: aload 6
    //   446: invokevirtual 1217	java/io/File:delete	()Z
    //   449: pop
    //   450: aload 5
    //   452: ldc_w 749
    //   455: invokevirtual 751	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: astore 8
    //   460: aload 5
    //   462: ldc_w 773
    //   465: invokevirtual 771	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   468: lstore_3
    //   469: aload 5
    //   471: ldc_w 831
    //   474: invokevirtual 751	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   477: astore 6
    //   479: aload 5
    //   481: ldc_w 758
    //   484: invokevirtual 743	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   487: istore_1
    //   488: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   491: invokestatic 390	com/tencent/smtt/utils/r:b	(Landroid/content/Context;)Z
    //   494: ifeq +156 -> 650
    //   497: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   500: iload_0
    //   501: invokestatic 394	com/tencent/smtt/sdk/TbsShareManager:getTbsStableCoreVersion	(Landroid/content/Context;I)I
    //   504: iload_1
    //   505: if_icmpge +145 -> 650
    //   508: getstatic 75	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   511: invokestatic 202	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   514: astore 7
    //   516: aload 7
    //   518: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   521: ldc_w 951
    //   524: aload 8
    //   526: invokeinterface 293 3 0
    //   531: pop
    //   532: aload 7
    //   534: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   537: ldc_w 975
    //   540: lload_3
    //   541: invokestatic 892	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   544: invokeinterface 293 3 0
    //   549: pop
    //   550: aload 7
    //   552: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   555: ldc_w 1235
    //   558: iload_0
    //   559: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   562: invokeinterface 293 3 0
    //   567: pop
    //   568: aload 7
    //   570: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   573: astore 8
    //   575: aload 6
    //   577: astore 5
    //   579: aload 6
    //   581: ifnonnull +7 -> 588
    //   584: ldc 166
    //   586: astore 5
    //   588: aload 8
    //   590: ldc_w 977
    //   593: aload 5
    //   595: invokeinterface 293 3 0
    //   600: pop
    //   601: aload 7
    //   603: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   606: ldc_w 340
    //   609: iconst_1
    //   610: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   613: invokeinterface 293 3 0
    //   618: pop
    //   619: aload 7
    //   621: getfield 285	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   624: ldc_w 426
    //   627: iload_1
    //   628: invokestatic 346	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   631: invokeinterface 293 3 0
    //   636: pop
    //   637: aload 7
    //   639: invokevirtual 296	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   642: getstatic 350	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   645: iconst_0
    //   646: iconst_1
    //   647: invokevirtual 1238	com/tencent/smtt/sdk/m:b	(ZZ)V
    //   650: ldc_w 1188
    //   653: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   656: return
    //   657: astore 6
    //   659: goto -209 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	paramInt	int
    //   1	627	1	n	int
    //   84	190	2	i1	int
    //   468	73	3	l1	long
    //   24	192	5	localObject1	Object
    //   373	107	5	localThrowable	Throwable
    //   577	17	5	localObject2	Object
    //   248	332	6	localObject3	Object
    //   657	1	6	localException	Exception
    //   255	383	7	localObject4	Object
    //   265	324	8	localObject5	Object
    //   280	62	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	373	java/lang/Throwable
    //   44	55	373	java/lang/Throwable
    //   55	215	373	java/lang/Throwable
    //   215	271	373	java/lang/Throwable
    //   282	347	373	java/lang/Throwable
    //   360	370	373	java/lang/Throwable
    //   401	450	373	java/lang/Throwable
    //   450	575	373	java/lang/Throwable
    //   588	650	373	java/lang/Throwable
    //   215	271	657	java/lang/Exception
    //   282	347	657	java/lang/Exception
    //   401	450	657	java/lang/Exception
  }
  
  @TargetApi(11)
  static void c(Context paramContext)
  {
    AppMethodBeat.i(54147);
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    m.c(paramContext);
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
    int i3;
    Context localContext;
    if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore())
    {
      String[] arrayOfString = f();
      int i2 = arrayOfString.length;
      int n = 0;
      for (;;)
      {
        if (n < i2)
        {
          str = arrayOfString[n];
          i3 = TbsShareManager.getBackupCoreVersion(c, str);
          if (i3 > 0)
          {
            localContext = TbsShareManager.getPackageContext(c, str, false);
            if ((localContext != null) && (!q.a().g(localContext)))
            {
              TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
              n += 1;
              continue;
            }
            i1 = 0;
            label107:
            if (i1 >= paramJSONArray.length()) {
              break label261;
            }
            if (paramJSONArray.optInt(i1) != i3) {
              break label199;
            }
          }
        }
      }
    }
    label259:
    label261:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        paramJSONArray.put(i3);
      }
      i3 = TbsShareManager.getBackupDecoupleCoreVersion(c, str);
      if (i3 <= 0) {
        break;
      }
      localContext = TbsShareManager.getPackageContext(c, str, false);
      if ((localContext != null) && (!q.a().g(localContext)))
      {
        TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
        break;
        label199:
        i1 += 1;
        break label107;
      }
      i1 = 0;
      label208:
      if (i1 < paramJSONArray.length()) {
        if (paramJSONArray.optInt(i1) != i3) {}
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label259;
        }
        paramJSONArray.put(i3);
        break;
        i1 += 1;
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
      int i1 = arrayOfString.length;
      int n = 0;
      while (n < i1)
      {
        String str = arrayOfString[n];
        int i2 = TbsShareManager.getSharedTbsCoreVersion(c, str);
        if (i2 > 0)
        {
          AppMethodBeat.o(54115);
          return true;
        }
        n += 1;
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
        h = o.a();
      }
      try
      {
        g = new m(c);
        d = new Handler(h.getLooper())
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            boolean bool3 = true;
            AppMethodBeat.i(195255);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(195255);
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
                AppMethodBeat.o(195255);
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
                    AppMethodBeat.o(195255);
                  }
                }
                else
                {
                  localObject2 = localObject3;
                  if (f.a(TbsDownloader.a()))
                  {
                    TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
                    TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                    AppMethodBeat.o(195255);
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
                if ((!bool1) || (!q.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0)))) {
                  break label623;
                }
                QbSdk.l.onDownloadFinish(122);
                ((TbsDownloadConfig)localObject3).setDownloadInterruptCode(-213);
              }
              for (;;)
              {
                TbsLog.i("TbsDownload", "------freeFileLock called :");
                f.a((FileLock)localObject2, (FileOutputStream)localObject1);
                AppMethodBeat.o(195255);
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
                    ((m)localObject3).b(bool1, bool2);
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
              for (int i = TbsShareManager.a(TbsDownloader.a(), false);; i = q.a().n(TbsDownloader.a()))
              {
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=".concat(String.valueOf(i)));
                TbsDownloader.b().a(i);
                TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
                AppMethodBeat.o(195255);
                return;
              }
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
              TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
              AppMethodBeat.o(195255);
              return;
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
              if (paramAnonymousMessage.arg1 == 0)
              {
                q.a().a((Context)paramAnonymousMessage.obj, true);
                AppMethodBeat.o(195255);
                return;
              }
              q.a().a((Context)paramAnonymousMessage.obj, false);
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
        int n = localObject.length;
        String[] arrayOfString = new String[n + 1];
        System.arraycopy(localObject, 0, arrayOfString, 0, n);
        arrayOfString[n] = str;
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
    String str = getBackupFileName(paramBoolean, 0);
    AppMethodBeat.o(54114);
    return str;
  }
  
  public static String getBackupFileName(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(193745);
    boolean bool;
    if (paramInt == 64) {
      bool = true;
    }
    while (paramBoolean) {
      if (bool)
      {
        AppMethodBeat.o(193745);
        return "x5.tbs.decouple.64";
        if (paramInt == 32) {
          bool = false;
        } else {
          bool = b.d();
        }
      }
      else
      {
        AppMethodBeat.o(193745);
        return "x5.tbs.decouple";
      }
    }
    if (bool)
    {
      AppMethodBeat.o(193745);
      return "x5.tbs.org.64";
    }
    AppMethodBeat.o(193745);
    return "x5.tbs.org";
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    AppMethodBeat.i(54127);
    int n = q.a().i(c);
    AppMethodBeat.o(54127);
    return n;
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    AppMethodBeat.i(54126);
    int n = q.a().i(paramContext);
    AppMethodBeat.o(54126);
    return n;
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
    return m;
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
            AppMethodBeat.i(55211);
            TbsLog.i("TbsDownloader", "x5webview onCompleted,onCompleted=".concat(String.valueOf(paramAnonymousFile)));
            AppMethodBeat.o(55211);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(55212);
            TbsLog.i("TbsDownloader", "onError,i=" + paramAnonymousInt + ",str=" + paramAnonymousString);
            AppMethodBeat.o(55212);
          }
          
          public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(192628);
            TbsLog.i("TbsDownloader", "onProgressChanged,i=" + paramAnonymousInt1 + ",i1=" + paramAnonymousInt2);
            AppMethodBeat.o(192628);
          }
        });
      }
      if (!TbsOneGreyInfoHelper.a(paramContext).isComponentInstalled("file")) {
        TbsOneGreyInfoHelper.a(paramContext).installComponent("file", new TBSOneCallback()
        {
          public final void a(File paramAnonymousFile)
          {
            AppMethodBeat.i(195614);
            TbsLog.i("TbsDownloader", "file install onCompleted,onCompleted=".concat(String.valueOf(paramAnonymousFile)));
            AppMethodBeat.o(195614);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(195616);
            TbsLog.i("TbsDownloader", "file onError,i=" + paramAnonymousInt + ",str=" + paramAnonymousString);
            AppMethodBeat.o(195616);
          }
        });
      }
      AppMethodBeat.o(54122);
      return false;
    }
    c = paramContext.getApplicationContext();
    TbsLog.i("TbsDownload", "needDownload,process=" + QbSdk.getCurrentProcessName(paramContext) + "stack=" + Log.getStackTraceString(new Throwable()));
    TbsDownloadUpload.clear();
    TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
    localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(140));
    localTbsDownloadUpload.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] oversea=" + paramBoolean1 + ",isDownloadForeground=" + paramBoolean2);
    boolean bool1 = false;
    TbsLog.initIfNeed(paramContext);
    if (q.b)
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
          break label841;
        }
        paramBoolean1 = true;
      }
      label684:
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (!paramBoolean1) {
        break label877;
      }
      if (h()) {
        break label859;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
      paramBoolean1 = false;
      label736:
      if ((!bool2) && (paramTbsDownloaderCallback != null)) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=".concat(String.valueOf(paramBoolean1)));
      paramContext = localTbsDownloadUpload.a;
      if (!paramBoolean1) {
        break label1005;
      }
    }
    label841:
    label859:
    label1005:
    for (int n = 170;; n = 174)
    {
      paramContext.put("tbs_needdownload_return", Integer.valueOf(n));
      localTbsDownloadUpload.commit();
      AppMethodBeat.o(54122);
      return paramBoolean1;
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(143));
      localTbsDownloadUpload.commit();
      break;
      paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.getBoolean("tbs_needdownload", false);
      break label684;
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-118);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      break label736;
      label877:
      n = q.a().n(c);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + n + ",needSendRequest=" + bool2);
      if ((bool2) || (n <= 0))
      {
        d.removeMessages(103);
        if ((n <= 0) && (!bool2)) {
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
      break label736;
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
    int n = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((n > 0) && (n != q.a().i(c)) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != n))
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
    int n = q.a().n(paramContext);
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=".concat(String.valueOf(n)));
    if (n > 0)
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
      m = paramLong;
    }
    TbsLog.i("TbsDownload", "mRetryIntervalInSeconds is " + m);
    AppMethodBeat.o(54145);
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    int n = 32;
    AppMethodBeat.i(54129);
    boolean bool = startDecoupleCoreIfNeededImpl();
    int i1;
    if ((!bool) && (r.b(c)))
    {
      i1 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_cpu_type_other_stable_core", 0);
      if (i1 != 0) {
        break label73;
      }
      if (!b.d()) {
        break label67;
      }
      c(n);
    }
    for (;;)
    {
      AppMethodBeat.o(54129);
      return bool;
      label67:
      n = 64;
      break;
      label73:
      if ((i1 == 32) || (i1 == 64))
      {
        TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
        localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", "");
        localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_apk_md5", "");
        localTbsDownloadConfig.mSyncMap.put("tbs_downloaddecouplecore", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(0));
        localTbsDownloadConfig.commit();
      }
    }
  }
  
  public static boolean startDecoupleCoreIfNeededImpl()
  {
    AppMethodBeat.i(193755);
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(c))
    {
      AppMethodBeat.o(193755);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
    if (a(c))
    {
      AppMethodBeat.o(193755);
      return false;
    }
    if (d == null)
    {
      AppMethodBeat.o(193755);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval())
    {
      AppMethodBeat.o(193755);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int i1 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if (r.b(c)) {}
    for (int n = TbsShareManager.getTbsStableCoreVersion(c, 0);; n = q.a().i(c))
    {
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded coreVersionForThirdApp is ".concat(String.valueOf(n)));
      if ((i1 <= 0) || (i1 == n)) {
        break label412;
      }
      if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) == i1) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) != 1)) {
        break;
      }
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
      a = true;
      d.removeMessages(108);
      Message localMessage = Message.obtain(d, 108, QbSdk.l);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      TbsDownloadConfig.getInstance(c).mSyncMap.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(193755);
      return true;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + i1 + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
    for (;;)
    {
      AppMethodBeat.o(193755);
      return false;
      label412:
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + n);
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
    int n = 1;
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
        if (q.b)
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
      paramContext.arg1 = n;
      paramContext.sendToTarget();
      AppMethodBeat.o(54125);
      break;
      n = 0;
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