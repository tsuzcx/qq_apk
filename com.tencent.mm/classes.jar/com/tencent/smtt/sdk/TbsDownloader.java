package com.tencent.smtt.sdk;

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
  private static int l;
  private static boolean m;
  private static int n;
  private static long o;
  private static int p;
  private static JSONObject q = null;
  private static JSONObject r = null;
  private static boolean s = false;
  private static int t = 0;
  private static int u = 0;
  private static JSONObject v = null;
  private static long w = -1L;
  
  protected static File a(int paramInt)
  {
    AppMethodBeat.i(54149);
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject1 = null;
    int i2 = arrayOfString.length;
    int i1 = 0;
    Object localObject2 = localObject1;
    if (i1 < i2)
    {
      localObject2 = arrayOfString[i1];
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
      i1 += 1;
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
    int i3 = arrayOfString.length;
    int i1 = 0;
    Object localObject;
    label65:
    label78:
    long l1;
    if (i1 < i3)
    {
      localObject = arrayOfString[i1];
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
              i2 = 0;
              label106:
              if (i2 >= localJSONArray.length()) {
                break label197;
              }
              if (localJSONArray.optInt(i2) != l1) {
                break label182;
              }
            }
          }
        }
      }
    }
    label182:
    label197:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0) {
        localJSONArray.put(l1);
      }
      i1 += 1;
      break;
      localObject = getBackupFileName(false);
      break label65;
      localObject = new File(f.a(c, (String)localObject, 4, false), "x5.tbs.decouple");
      break label78;
      i2 += 1;
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
    String str2 = b.i(c);
    String str3 = b.h(c);
    String str4 = b.k(c);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    label124:
    int i2;
    label129:
    int i1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)c.getSystemService("phone");
        if (localObject3 == null) {
          break label946;
        }
        localObject3 = ((TelephonyManager)localObject3).getSimCountryIso();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        Object localObject3;
        label211:
        label365:
        label751:
        break label124;
        label286:
        label300:
        label687:
        label863:
        i1 = i2;
        label946:
        if (n.a(c).c("stable_32_tpatch_fail") != 1) {
          break label1422;
        }
      }
      if (localObject1 != null)
      {
        localObject3 = new JSONObject();
        i2 = 0;
        i1 = 0;
        if (paramBoolean3) {}
        for (;;)
        {
          try
          {
            if (!r.c(c)) {
              continue;
            }
            ((JSONObject)localObject3).put("REQUEST_TPATCH", 1);
            if (!b.b()) {
              continue;
            }
            if (n.a(c).c("stable_64_tpatch_fail") != 1) {
              continue;
            }
            ((JSONObject)localObject3).put("REQUEST_TPATCH", 0);
            TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] stable_64_last_tpatch_fail and set REQUEST_TPATCH  0 ");
            i1 = 1;
          }
          catch (Exception localException1)
          {
            int i4;
            continue;
            int i3 = 1;
            continue;
            i3 = 0;
            continue;
            i3 = 0;
            continue;
            i3 = 1;
            continue;
          }
          ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
          ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
          if (b.b()) {
            ((JSONObject)localObject3).put("REQUEST_64", 1);
          }
          ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
          if (!TbsShareManager.isThirdPartyApp(c)) {
            continue;
          }
          if (!QbSdk.c) {
            continue;
          }
          i2 = TbsShareManager.a(c, false);
          continue;
          if (!paramBoolean1) {
            continue;
          }
          ((JSONObject)localObject3).put("FUNCTION", 2);
          if (!TbsShareManager.isThirdPartyApp(c)) {
            continue;
          }
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
          ((JSONObject)localObject3).put("TBSSDKV", 44138);
          ((JSONObject)localObject3).put("TBSV", i2);
          if (!paramBoolean3) {
            continue;
          }
          i3 = 1;
          ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", i3);
          localObject1 = localTbsDownloadConfig.mSyncMap;
          if (!paramBoolean3) {
            continue;
          }
          i3 = 1;
          ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(i3));
          localTbsDownloadConfig.commit();
          if (i2 != 0) {
            ((JSONObject)localObject3).put("TBSBACKUPV", g.b(paramBoolean3));
          }
          ((JSONObject)localObject3).put("CPU", e);
          ((JSONObject)localObject3).put("UA", str1);
          ((JSONObject)localObject3).put("IMSI", a(str2));
          ((JSONObject)localObject3).put("IMEI", a(str3));
          ((JSONObject)localObject3).put("ANDROID_ID", a(str4));
          ((JSONObject)localObject3).put("GUID", b.f(c));
          if (!TbsShareManager.isThirdPartyApp(c))
          {
            TbsLog.d("TbsDownload", "tbsLocalVersion: ".concat(String.valueOf(i2)));
            if (i2 == 0) {
              continue;
            }
            if (!QbSdk.a(c, i2)) {
              continue;
            }
            i3 = 0;
            ((JSONObject)localObject3).put("STATUS", i3);
            if (!r.c(c)) {
              continue;
            }
            i4 = TbsShareManager.getTbsStableCoreVersion(c, 0);
            i3 = i4;
            if (paramBoolean3)
            {
              i3 = i4;
              if (i4 > 0)
              {
                i3 = i4;
                if (((JSONObject)localObject3).getInt("FUNCTION") == 0)
                {
                  ((JSONObject)localObject3).put("FUNCTION", 1);
                  i3 = i4;
                }
              }
            }
            ((JSONObject)localObject3).put("TBSDV", i2 % 10000);
            ((JSONObject)localObject3).put("TBSBACKUPV", i3);
            if (i1 != 0)
            {
              ((JSONObject)localObject3).put("TBSDV", 0);
              ((JSONObject)localObject3).put("TBSBACKUPV", 0);
            }
          }
          paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
          if (!QbSdk.isEnableSensitiveApi()) {
            continue;
          }
          localObject1 = QbSdk.a(c, "can_unlzma", null);
          if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
            continue;
          }
          paramBoolean1 = ((Boolean)localObject1).booleanValue();
          continue;
          if (i1 != 0) {
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
          localException2.put("REQUEST_TPATCH", 0);
          TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] stable_32_last_tpatch_fail and set REQUEST_TPATCH  0 ");
          i1 = 1;
          continue;
          if (n.a(c).c("tpatch_num") < 5)
          {
            if (TbsShareManager.isThirdPartyApp(c))
            {
              localException2.put("REQUEST_TPATCH", 2);
              i1 = 0;
            }
            else
            {
              localException2.put("REQUEST_TPATCH", 1);
              i1 = 0;
            }
          }
          else
          {
            localException2.put("REQUEST_TPATCH", 0);
            i1 = 0;
          }
        }
        i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
        break label1406;
        if (paramBoolean3) {}
        for (i3 = q.a().j(c);; i3 = q.a().n(c))
        {
          i2 = i3;
          if (i3 == 0)
          {
            i2 = i3;
            if (q.a().m(c))
            {
              i3 = -1;
              i2 = i3;
              if ("com.tencent.mobileqq".equals(c.getApplicationInfo().packageName))
              {
                TbsDownloadUpload.clear();
                localObject1 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject1).a.put("tbs_local_core_version", Integer.valueOf(-1));
                ((TbsDownloadUpload)localObject1).commit();
                TbsPVConfig.releaseInstance();
                i2 = i3;
                if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                  i2 = q.a().j(c);
                }
              }
            }
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + i2 + " isDownloadForeground=" + paramBoolean2);
          if (!paramBoolean2) {
            break;
          }
          if (q.a().m(c)) {
            break label1406;
          }
          i2 = 0;
          break label1406;
        }
      }
    }
    for (;;)
    {
      localException2.put("FUNCTION", i3);
      break label300;
      localObject1 = a(paramBoolean3);
      if ((Apn.getApnType(c) == 3) || (((JSONArray)localObject1).length() == 0) || (i2 != 0) || (!paramBoolean1)) {
        break label365;
      }
      localException2.put("TBSBACKUPARR", localObject1);
      break label365;
      localException2.put("STATUS", 0);
      break label687;
      i3 = q.a().i(c);
      break label751;
      label1406:
      do
      {
        i1 = 0;
        break label863;
        do
        {
          i1 = 0;
          break label863;
          paramBoolean1 = false;
          continue;
          break label286;
          localObject1 = "";
          break label129;
          localObject2 = "";
          break;
          break label211;
          break label286;
        } while (!paramBoolean1);
      } while (paramBoolean3);
      i1 = 1;
      break label863;
      label1422:
      break label211;
      if (i2 != 0) {
        break label1441;
      }
      i3 = 0;
    }
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(54137);
    String[] arrayOfString = f();
    int i3 = arrayOfString.length;
    int i1 = 0;
    String str;
    int i4;
    Context localContext;
    if (i1 < i3)
    {
      str = arrayOfString[i1];
      i4 = TbsShareManager.getSharedTbsCoreVersion(c, str);
      if (i4 > 0)
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
      i1 += 1;
      break;
      label93:
      int i2 = 0;
      label95:
      if (i2 < paramJSONArray.length()) {
        if (paramJSONArray.optInt(i2) != i4) {}
      }
      for (i2 = 1;; i2 = 0)
      {
        if (i2 != 0) {
          break label281;
        }
        paramJSONArray.put(i4);
        break;
        i2 += 1;
        break label95;
        arrayOfString = f();
        i3 = arrayOfString.length;
        i1 = 0;
        if (i1 < i3)
        {
          str = arrayOfString[i1];
          i4 = TbsShareManager.getCoreShareDecoupleCoreVersion(c, str);
          if (i4 > 0)
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
          i1 += 1;
          break;
          label223:
          i2 = 0;
          label225:
          if (i2 < paramJSONArray.length()) {
            if (paramJSONArray.optInt(i2) != i4) {}
          }
          for (i2 = 1;; i2 = 0)
          {
            if (i2 != 0) {
              break label276;
            }
            paramJSONArray.put(i4);
            break;
            i2 += 1;
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
    int i2 = 1;
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
      i1 = 1;
      localMessage.arg1 = i1;
      if (!paramBoolean2) {
        break label93;
      }
    }
    label93:
    for (int i1 = i2;; i1 = 0)
    {
      localMessage.arg2 = i1;
      localMessage.sendToTarget();
      AppMethodBeat.o(54134);
      return;
      i1 = 0;
      break;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219660);
    for (;;)
    {
      try
      {
        TbsLog.i("TbsDownload", "copyFromOldBackupDone newCoreVersion is " + paramInt1 + " localStableCoreVersion is " + paramInt2 + " cpuType is " + paramInt3);
        if ((paramInt1 > 0) && (paramInt1 != paramInt2))
        {
          Object localObject1 = new File(f.a(c, 3), getBackupFileName(false, paramInt3));
          int i1 = -1;
          paramInt2 = i1;
          if (((File)localObject1).exists())
          {
            paramInt2 = i1;
            if (((File)localObject1).canRead())
            {
              i1 = a.b((File)localObject1);
              paramInt2 = i1;
              if (i1 <= 0) {
                paramInt2 = a.a(c, (File)localObject1);
              }
            }
          }
          u = paramInt2;
          TbsLog.i("TbsDownload", "copyFromOldBackupDone oldBackupCoreVersion is ".concat(String.valueOf(paramInt2)));
          if (paramInt1 == paramInt2)
          {
            File localFile = new File(f.a(c, "com.tencent.mm", 4, true));
            boolean bool = f.b((File)localObject1, new File(localFile, getBackupFileName(false, paramInt3)));
            TbsLog.i("TbsDownload", "copyFromOldBackupDone #01 result is ".concat(String.valueOf(bool)));
            if (bool)
            {
              localObject1 = localFile.listFiles();
              Pattern localPattern = Pattern.compile(a.a(false, paramInt3));
              i1 = localObject1.length;
              paramInt2 = 0;
              if (paramInt2 < i1)
              {
                Object localObject2 = localObject1[paramInt2];
                if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
                  break label388;
                }
                localObject2.delete();
                break label388;
              }
              localFile = new File(localFile, a.a(false, paramInt3) + "." + paramInt1);
              if (!localFile.exists()) {
                localFile.createNewFile();
              }
            }
            AppMethodBeat.o(219660);
            return bool;
          }
        }
      }
      finally
      {
        TbsLog.i("TbsDownload", "stack is " + Log.getStackTraceString(localThrowable));
        TbsLog.i("TbsDownload", "copyFromOldBackupDone result is false  #10");
        AppMethodBeat.o(219660);
        return false;
      }
      label388:
      paramInt2 += 1;
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
        AppMethodBeat.i(219395);
        TbsLog.e("TBSEmergency", "Execute command [1000](" + paramAnonymousString + "), force tbs downloader request");
        paramAnonymousString = this.a.mPreferences.edit();
        paramAnonymousString.putLong("last_check", 0L);
        paramAnonymousString.apply();
        paramAnonymousString.commit();
        AppMethodBeat.o(219395);
      }
    });
    paramContext = null;
    String str1;
    int i1;
    String str2;
    String str3;
    int i2;
    String str4;
    long l2;
    long l1;
    if (!paramBoolean1)
    {
      str1 = ((TbsDownloadConfig)localObject).mPreferences.getString("app_versionname", null);
      i1 = ((TbsDownloadConfig)localObject).mPreferences.getInt("app_versioncode", 0);
      str2 = ((TbsDownloadConfig)localObject).mPreferences.getString("app_metadata", null);
      str3 = b.d(c);
      i2 = b.e(c);
      str4 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + str3 + " oldAppVersionName=" + str1 + " appVersionCode=" + i2 + " oldAppVersionCode=" + i1 + " appMetadata=" + str4 + " oldAppVersionMetadata=" + str2);
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
      int i3 = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
      int i4 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      if ((l2 - l1 <= 1000L * l5) && ((i3 <= q.a().j(c)) || (i3 <= i4)) && ((!TbsShareManager.isThirdPartyApp(c)) || (l3 <= 0L) || (l2 - l3 <= l5 * 1000L) || (l4 >= 11L)))
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
          if ((str3 == null) || (i2 == 0) || (str4 == null)) {
            break;
          }
          if ((str3.equals(str1)) && (i2 == i1) && (str4.equals(str2))) {
            break label756;
          }
        }
        if (!TbsShareManager.isThirdPartyApp(c)) {
          break label756;
        }
      }
    }
    label756:
    for (paramContext = "timeNow - timeLastCheck is " + (l2 - l1) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + str3 + " appVersionCode is " + i2 + " appMetadata is " + str4 + " oldAppVersionName is " + str1 + " oldAppVersionCode is " + i1 + " oldAppVersionMetadata is " + str2;; paramContext = null)
    {
      paramBoolean1 = false;
      break;
      paramBoolean1 = true;
      break;
    }
  }
  
  /* Error */
  private static boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: ldc_w 819
    //   3: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 29
    //   8: new 155	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 821
    //   15: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 823
    //   25: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload 4
    //   30: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   42: invokestatic 224	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   45: astore 32
    //   47: aload_0
    //   48: invokestatic 689	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifeq +41 -> 92
    //   54: iload_2
    //   55: ifeq +26 -> 81
    //   58: aload 32
    //   60: bipush 148
    //   62: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   65: ldc 29
    //   67: ldc_w 825
    //   70: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 819
    //   76: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_0
    //   80: ireturn
    //   81: aload 32
    //   83: sipush -208
    //   86: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   89: goto -24 -> 65
    //   92: new 257	org/json/JSONObject
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 826	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   100: astore 33
    //   102: aload 33
    //   104: ldc_w 828
    //   107: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   110: istore 5
    //   112: iload 5
    //   114: ifeq +49 -> 163
    //   117: iload_2
    //   118: ifeq +34 -> 152
    //   121: aload 32
    //   123: bipush 147
    //   125: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   128: ldc 29
    //   130: ldc_w 830
    //   133: iload 5
    //   135: invokestatic 404	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: ldc_w 819
    //   147: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: aload 32
    //   154: sipush -209
    //   157: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   160: goto -32 -> 128
    //   163: aload 33
    //   165: ldc_w 832
    //   168: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   171: istore 13
    //   173: iload 13
    //   175: putstatic 834	com/tencent/smtt/sdk/TbsDownloader:p	I
    //   178: aload 33
    //   180: ldc_w 836
    //   183: invokevirtual 838	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 34
    //   188: aload 34
    //   190: invokestatic 689	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifeq +1012 -> 1205
    //   196: iconst_1
    //   197: putstatic 840	com/tencent/smtt/sdk/TbsDownloader:m	Z
    //   200: aload 33
    //   202: ldc_w 842
    //   205: ldc 188
    //   207: invokevirtual 845	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: astore 35
    //   212: aload 33
    //   214: ldc_w 847
    //   217: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   220: istore 12
    //   222: iload 12
    //   224: putstatic 849	com/tencent/smtt/sdk/TbsDownloader:n	I
    //   227: aload 33
    //   229: ldc_w 851
    //   232: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   235: istore 14
    //   237: aload 33
    //   239: ldc_w 853
    //   242: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   245: istore 15
    //   247: aload 33
    //   249: ldc_w 855
    //   252: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   255: istore 16
    //   257: aload 33
    //   259: ldc_w 857
    //   262: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   265: istore 17
    //   267: aload 33
    //   269: ldc_w 859
    //   272: invokevirtual 862	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   275: lstore 24
    //   277: aload 33
    //   279: ldc_w 864
    //   282: invokevirtual 862	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   285: lstore 26
    //   287: lload 26
    //   289: putstatic 866	com/tencent/smtt/sdk/TbsDownloader:o	J
    //   292: aload 33
    //   294: ldc_w 868
    //   297: lconst_0
    //   298: invokevirtual 871	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   301: lstore 22
    //   303: aload 33
    //   305: ldc_w 873
    //   308: iconst_m1
    //   309: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   312: istore 18
    //   314: iconst_0
    //   315: istore 5
    //   317: aload 33
    //   319: ldc_w 877
    //   322: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   325: istore 6
    //   327: iload 6
    //   329: istore 5
    //   331: aload 32
    //   333: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   336: ldc_w 879
    //   339: iload 5
    //   341: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: invokeinterface 321 3 0
    //   349: pop
    //   350: iload_2
    //   351: ifeq +59 -> 410
    //   354: getstatic 881	com/tencent/smtt/sdk/QbSdk:h	Z
    //   357: ifeq +53 -> 410
    //   360: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   363: invokestatic 295	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   366: ifeq +44 -> 410
    //   369: aload 33
    //   371: ldc_w 883
    //   374: iconst_0
    //   375: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   378: istore 5
    //   380: invokestatic 888	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   383: astore_0
    //   384: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   387: astore 28
    //   389: iload 5
    //   391: iconst_1
    //   392: if_icmpne +820 -> 1212
    //   395: iconst_1
    //   396: istore 19
    //   398: aload_0
    //   399: aload 28
    //   401: ldc_w 890
    //   404: iload 19
    //   406: invokevirtual 894	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   409: pop
    //   410: iload_2
    //   411: ifeq +189 -> 600
    //   414: aload 33
    //   416: ldc_w 896
    //   419: iconst_0
    //   420: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   423: istore 5
    //   425: iload 5
    //   427: iconst_1
    //   428: iand
    //   429: ifeq +819 -> 1248
    //   432: iconst_1
    //   433: istore 19
    //   435: invokestatic 888	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   438: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   441: ldc_w 898
    //   444: iload 19
    //   446: invokevirtual 894	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   449: pop
    //   450: ldc 29
    //   452: ldc_w 900
    //   455: iload 19
    //   457: invokestatic 605	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   460: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   463: invokestatic 902	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: iload 5
    //   468: iconst_2
    //   469: iand
    //   470: ifeq +784 -> 1254
    //   473: iconst_1
    //   474: istore 19
    //   476: invokestatic 888	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   479: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   482: ldc_w 904
    //   485: iload 19
    //   487: invokevirtual 894	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   490: pop
    //   491: ldc 29
    //   493: ldc_w 906
    //   496: iload 19
    //   498: invokestatic 605	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   501: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   504: invokestatic 902	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: iload 5
    //   509: iconst_4
    //   510: iand
    //   511: ifeq +749 -> 1260
    //   514: iconst_1
    //   515: istore 19
    //   517: invokestatic 888	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   520: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   523: ldc_w 908
    //   526: iload 19
    //   528: invokevirtual 894	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   531: pop
    //   532: iload 19
    //   534: invokestatic 912	com/tencent/smtt/sdk/QbSdk:setDisableUnpreinitBySwitch	(Z)V
    //   537: ldc 29
    //   539: ldc_w 914
    //   542: iload 19
    //   544: invokestatic 605	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   547: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   550: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: iload 5
    //   555: bipush 8
    //   557: iand
    //   558: ifeq +708 -> 1266
    //   561: iconst_1
    //   562: istore 19
    //   564: invokestatic 888	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   567: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   570: ldc_w 916
    //   573: iload 19
    //   575: invokevirtual 894	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   578: pop
    //   579: iload 19
    //   581: invokestatic 919	com/tencent/smtt/sdk/QbSdk:setDisableUseHostBackupCoreBySwitch	(Z)V
    //   584: ldc 29
    //   586: ldc_w 921
    //   589: iload 19
    //   591: invokestatic 605	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   594: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   597: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: aconst_null
    //   601: astore 28
    //   603: iconst_0
    //   604: istore 9
    //   606: iconst_0
    //   607: istore 10
    //   609: iconst_0
    //   610: istore 11
    //   612: iconst_0
    //   613: istore 5
    //   615: iconst_1
    //   616: istore 21
    //   618: iconst_1
    //   619: istore 19
    //   621: ldc 188
    //   623: astore 30
    //   625: aload 30
    //   627: astore 29
    //   629: iload 21
    //   631: istore 20
    //   633: iload 11
    //   635: istore 8
    //   637: iload 10
    //   639: istore 7
    //   641: iload 9
    //   643: istore 6
    //   645: aload 33
    //   647: ldc_w 923
    //   650: invokevirtual 838	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   653: astore 31
    //   655: aload 30
    //   657: astore 29
    //   659: iload 21
    //   661: istore 20
    //   663: iload 11
    //   665: istore 8
    //   667: iload 10
    //   669: istore 7
    //   671: iload 9
    //   673: istore 6
    //   675: aload 31
    //   677: astore 28
    //   679: aload 33
    //   681: ldc_w 925
    //   684: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   687: istore 9
    //   689: aload 30
    //   691: astore 29
    //   693: iload 21
    //   695: istore 20
    //   697: iload 11
    //   699: istore 8
    //   701: iload 10
    //   703: istore 7
    //   705: iload 9
    //   707: istore 6
    //   709: aload 31
    //   711: astore 28
    //   713: aload 33
    //   715: ldc_w 927
    //   718: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   721: istore 10
    //   723: aload 30
    //   725: astore 29
    //   727: iload 21
    //   729: istore 20
    //   731: iload 11
    //   733: istore 8
    //   735: iload 10
    //   737: istore 7
    //   739: iload 9
    //   741: istore 6
    //   743: aload 31
    //   745: astore 28
    //   747: aload 33
    //   749: ldc_w 929
    //   752: invokevirtual 932	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   755: ifeq +44 -> 799
    //   758: aload 30
    //   760: astore 29
    //   762: iload 21
    //   764: istore 20
    //   766: iload 11
    //   768: istore 8
    //   770: iload 10
    //   772: istore 7
    //   774: iload 9
    //   776: istore 6
    //   778: aload 31
    //   780: astore 28
    //   782: aload 33
    //   784: ldc_w 929
    //   787: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   790: ifeq +512 -> 1302
    //   793: iconst_1
    //   794: istore 5
    //   796: goto +2486 -> 3282
    //   799: aload 30
    //   801: astore_0
    //   802: aload 30
    //   804: astore 29
    //   806: iload 21
    //   808: istore 20
    //   810: iload 5
    //   812: istore 8
    //   814: iload 10
    //   816: istore 7
    //   818: iload 9
    //   820: istore 6
    //   822: aload 31
    //   824: astore 28
    //   826: aload 33
    //   828: ldc_w 934
    //   831: invokevirtual 932	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   834: ifeq +36 -> 870
    //   837: aload 30
    //   839: astore 29
    //   841: iload 21
    //   843: istore 20
    //   845: iload 5
    //   847: istore 8
    //   849: iload 10
    //   851: istore 7
    //   853: iload 9
    //   855: istore 6
    //   857: aload 31
    //   859: astore 28
    //   861: aload 33
    //   863: ldc_w 934
    //   866: invokevirtual 838	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   869: astore_0
    //   870: aload_0
    //   871: astore 29
    //   873: iload 21
    //   875: istore 20
    //   877: iload 5
    //   879: istore 8
    //   881: iload 10
    //   883: istore 7
    //   885: iload 9
    //   887: istore 6
    //   889: aload 31
    //   891: astore 28
    //   893: aload 33
    //   895: ldc_w 936
    //   898: invokevirtual 932	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   901: ifeq +43 -> 944
    //   904: aload_0
    //   905: astore 29
    //   907: iload 21
    //   909: istore 20
    //   911: iload 5
    //   913: istore 8
    //   915: iload 10
    //   917: istore 7
    //   919: iload 9
    //   921: istore 6
    //   923: aload 31
    //   925: astore 28
    //   927: aload 33
    //   929: ldc_w 936
    //   932: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   935: ifeq +373 -> 1308
    //   938: iconst_1
    //   939: istore 19
    //   941: goto +2344 -> 3285
    //   944: aload_0
    //   945: astore 29
    //   947: iload 19
    //   949: istore 20
    //   951: iload 5
    //   953: istore 8
    //   955: iload 10
    //   957: istore 7
    //   959: iload 9
    //   961: istore 6
    //   963: aload 31
    //   965: astore 28
    //   967: aload 33
    //   969: ldc_w 938
    //   972: invokevirtual 932	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   975: ifeq +2301 -> 3276
    //   978: aload_0
    //   979: astore 29
    //   981: iload 19
    //   983: istore 20
    //   985: iload 5
    //   987: istore 8
    //   989: iload 10
    //   991: istore 7
    //   993: iload 9
    //   995: istore 6
    //   997: aload 31
    //   999: astore 28
    //   1001: aload 33
    //   1003: ldc_w 938
    //   1006: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1009: istore 11
    //   1011: iload 11
    //   1013: ifeq +301 -> 1314
    //   1016: iconst_1
    //   1017: istore 20
    //   1019: aload 31
    //   1021: astore 28
    //   1023: iload 9
    //   1025: istore 6
    //   1027: iload 10
    //   1029: istore 7
    //   1031: aload 33
    //   1033: ldc_w 940
    //   1036: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1039: istore 8
    //   1041: iconst_0
    //   1042: istore 9
    //   1044: aload 33
    //   1046: ldc_w 942
    //   1049: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1052: istore 10
    //   1054: iload 10
    //   1056: istore 9
    //   1058: getstatic 69	com/tencent/smtt/sdk/TbsDownloader:f	Ljava/lang/Object;
    //   1061: astore 29
    //   1063: aload 29
    //   1065: monitorenter
    //   1066: iload 5
    //   1068: ifeq +19 -> 1087
    //   1071: aload 32
    //   1073: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1076: ldc_w 944
    //   1079: ldc 188
    //   1081: invokeinterface 321 3 0
    //   1086: pop
    //   1087: aload_0
    //   1088: invokestatic 689	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1091: ifne +54 -> 1145
    //   1094: aload_0
    //   1095: invokevirtual 945	java/lang/String:length	()I
    //   1098: bipush 96
    //   1100: if_icmpne +45 -> 1145
    //   1103: new 155	java/lang/StringBuilder
    //   1106: dup
    //   1107: invokespecial 636	java/lang/StringBuilder:<init>	()V
    //   1110: aload_0
    //   1111: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: ldc_w 947
    //   1117: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: invokestatic 951	com/tencent/smtt/utils/h:c	()Ljava/lang/String;
    //   1123: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: astore_0
    //   1130: aload 32
    //   1132: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1135: ldc_w 944
    //   1138: aload_0
    //   1139: invokeinterface 321 3 0
    //   1144: pop
    //   1145: aload 29
    //   1147: monitorexit
    //   1148: iload 6
    //   1150: iconst_1
    //   1151: if_icmpne +227 -> 1378
    //   1154: iload_2
    //   1155: ifeq +207 -> 1362
    //   1158: aload 32
    //   1160: bipush 146
    //   1162: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1165: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1168: astore_0
    //   1169: iload 9
    //   1171: iconst_1
    //   1172: if_icmpne +201 -> 1373
    //   1175: iconst_1
    //   1176: istore_3
    //   1177: aload_0
    //   1178: iload_3
    //   1179: invokestatic 955	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   1182: ldc 29
    //   1184: ldc_w 957
    //   1187: iload_2
    //   1188: invokestatic 605	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1191: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1194: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1197: ldc_w 819
    //   1200: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1203: iconst_0
    //   1204: ireturn
    //   1205: iconst_0
    //   1206: putstatic 840	com/tencent/smtt/sdk/TbsDownloader:m	Z
    //   1209: goto -1009 -> 200
    //   1212: iconst_0
    //   1213: istore 19
    //   1215: goto -817 -> 398
    //   1218: astore_0
    //   1219: ldc_w 959
    //   1222: new 155	java/lang/StringBuilder
    //   1225: dup
    //   1226: ldc_w 961
    //   1229: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1232: aload_0
    //   1233: invokevirtual 964	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1236: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1242: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1245: goto -835 -> 410
    //   1248: iconst_0
    //   1249: istore 19
    //   1251: goto -816 -> 435
    //   1254: iconst_0
    //   1255: istore 19
    //   1257: goto -781 -> 476
    //   1260: iconst_0
    //   1261: istore 19
    //   1263: goto -746 -> 517
    //   1266: iconst_0
    //   1267: istore 19
    //   1269: goto -705 -> 564
    //   1272: astore_0
    //   1273: ldc_w 959
    //   1276: new 155	java/lang/StringBuilder
    //   1279: dup
    //   1280: ldc_w 961
    //   1283: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1286: aload_0
    //   1287: invokevirtual 964	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1290: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1299: goto -699 -> 600
    //   1302: iconst_0
    //   1303: istore 5
    //   1305: goto +1977 -> 3282
    //   1308: iconst_0
    //   1309: istore 19
    //   1311: goto +1974 -> 3285
    //   1314: iconst_0
    //   1315: istore 20
    //   1317: goto -298 -> 1019
    //   1320: astore_0
    //   1321: aload 29
    //   1323: astore_0
    //   1324: iconst_1
    //   1325: istore 21
    //   1327: iload 20
    //   1329: istore 19
    //   1331: iload 8
    //   1333: istore 5
    //   1335: iload 21
    //   1337: istore 20
    //   1339: goto -308 -> 1031
    //   1342: astore 29
    //   1344: iconst_0
    //   1345: istore 8
    //   1347: goto -306 -> 1041
    //   1350: astore_0
    //   1351: aload 29
    //   1353: monitorexit
    //   1354: ldc_w 819
    //   1357: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1360: aload_0
    //   1361: athrow
    //   1362: aload 32
    //   1364: sipush -210
    //   1367: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1370: goto -205 -> 1165
    //   1373: iconst_0
    //   1374: istore_3
    //   1375: goto -198 -> 1177
    //   1378: iload 19
    //   1380: ifne +10 -> 1390
    //   1383: aload 32
    //   1385: iload 19
    //   1387: invokevirtual 967	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockEnable	(Z)V
    //   1390: iload 20
    //   1392: ifne +10 -> 1402
    //   1395: aload 32
    //   1397: iload 20
    //   1399: invokevirtual 970	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockWaitEnable	(Z)V
    //   1402: iload 8
    //   1404: iconst_1
    //   1405: if_icmpne +9 -> 1414
    //   1408: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1411: invokestatic 973	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   1414: iload 7
    //   1416: iconst_1
    //   1417: if_icmpne +22 -> 1439
    //   1420: getstatic 547	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1423: bipush 104
    //   1425: invokevirtual 552	android/os/Handler:removeMessages	(I)V
    //   1428: getstatic 547	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1431: bipush 104
    //   1433: invokestatic 558	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1436: invokevirtual 570	android/os/Message:sendToTarget	()V
    //   1439: iload 18
    //   1441: iconst_1
    //   1442: if_icmpne +1823 -> 3265
    //   1445: lload 22
    //   1447: ldc2_w 974
    //   1450: lcmp
    //   1451: ifle +1822 -> 3273
    //   1454: ldc2_w 974
    //   1457: lstore 22
    //   1459: lload 22
    //   1461: lconst_0
    //   1462: lcmp
    //   1463: ifle +1802 -> 3265
    //   1466: invokestatic 978	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1469: lconst_0
    //   1470: lcmp
    //   1471: iflt +8 -> 1479
    //   1474: invokestatic 978	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1477: lstore 22
    //   1479: aload 32
    //   1481: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1484: ldc_w 980
    //   1487: lload 22
    //   1489: invokestatic 985	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1492: invokeinterface 321 3 0
    //   1497: pop
    //   1498: iconst_0
    //   1499: istore 5
    //   1501: iconst_0
    //   1502: istore 7
    //   1504: ldc 29
    //   1506: ldc_w 987
    //   1509: iload_2
    //   1510: invokestatic 605	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1513: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1516: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1519: iload_2
    //   1520: ifeq +277 -> 1797
    //   1523: aload 33
    //   1525: ldc_w 989
    //   1528: invokevirtual 420	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1531: istore 6
    //   1533: iload 6
    //   1535: istore 5
    //   1537: iload 6
    //   1539: putstatic 991	com/tencent/smtt/sdk/TbsDownloader:l	I
    //   1542: iload 6
    //   1544: istore 5
    //   1546: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1549: invokestatic 224	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1552: getfield 337	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1555: ldc_w 368
    //   1558: iconst_0
    //   1559: invokeinterface 355 3 0
    //   1564: istore 6
    //   1566: ldc 29
    //   1568: ldc_w 993
    //   1571: iload 5
    //   1573: invokestatic 404	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1576: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1579: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1582: iload 5
    //   1584: istore 7
    //   1586: iload_2
    //   1587: ifeq +36 -> 1623
    //   1590: iload 5
    //   1592: istore 7
    //   1594: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1597: invokestatic 295	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1600: ifne +23 -> 1623
    //   1603: iload 5
    //   1605: istore 7
    //   1607: iload 5
    //   1609: ifne +14 -> 1623
    //   1612: invokestatic 463	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1615: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1618: invokevirtual 514	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   1621: istore 7
    //   1623: ldc 29
    //   1625: ldc_w 995
    //   1628: iload 7
    //   1630: invokestatic 404	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1633: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1636: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1639: aload 32
    //   1641: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1644: ldc_w 997
    //   1647: iload 7
    //   1649: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1652: invokeinterface 321 3 0
    //   1657: pop
    //   1658: aload 32
    //   1660: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1663: ldc_w 368
    //   1666: iload 6
    //   1668: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1671: invokeinterface 321 3 0
    //   1676: pop
    //   1677: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1680: invokestatic 295	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1683: ifne +46 -> 1729
    //   1686: iload 7
    //   1688: ifle +136 -> 1824
    //   1691: iload 7
    //   1693: invokestatic 463	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1696: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1699: invokevirtual 514	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   1702: if_icmpeq +122 -> 1824
    //   1705: iload 7
    //   1707: invokestatic 463	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1710: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1713: invokevirtual 466	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   1716: if_icmpne +108 -> 1824
    //   1719: invokestatic 463	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1722: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1725: invokevirtual 999	com/tencent/smtt/sdk/q:o	(Landroid/content/Context;)Z
    //   1728: pop
    //   1729: aload 34
    //   1731: invokestatic 689	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1734: ifeq +114 -> 1848
    //   1737: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1740: invokestatic 295	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1743: ifeq +105 -> 1848
    //   1746: aload 32
    //   1748: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1751: ldc_w 1001
    //   1754: getstatic 1005	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1757: invokeinterface 321 3 0
    //   1762: pop
    //   1763: aload 32
    //   1765: invokevirtual 324	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1768: iload_2
    //   1769: ifeq +12 -> 1781
    //   1772: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1775: iload 12
    //   1777: iconst_0
    //   1778: invokestatic 1009	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1781: ldc 29
    //   1783: ldc_w 1011
    //   1786: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1789: ldc_w 819
    //   1792: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1795: iconst_0
    //   1796: ireturn
    //   1797: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1800: invokestatic 224	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1803: getfield 337	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1806: ldc_w 997
    //   1809: iconst_0
    //   1810: invokeinterface 355 3 0
    //   1815: istore 6
    //   1817: iload 6
    //   1819: istore 5
    //   1821: goto -275 -> 1546
    //   1824: iload 7
    //   1826: ifne -97 -> 1729
    //   1829: invokestatic 463	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1832: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1835: invokevirtual 1014	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   1838: invokestatic 1017	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   1841: goto -112 -> 1729
    //   1844: astore_0
    //   1845: goto -116 -> 1729
    //   1848: ldc 29
    //   1850: ldc_w 1019
    //   1853: iload 13
    //   1855: invokestatic 404	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1858: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1861: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1864: iload 13
    //   1866: ifne +135 -> 2001
    //   1869: aload 32
    //   1871: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1874: ldc_w 1021
    //   1877: iload 13
    //   1879: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1882: invokeinterface 321 3 0
    //   1887: pop
    //   1888: aload 32
    //   1890: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1893: ldc_w 1001
    //   1896: getstatic 1005	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1899: invokeinterface 321 3 0
    //   1904: pop
    //   1905: iload_2
    //   1906: ifeq +64 -> 1970
    //   1909: aload 32
    //   1911: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1914: ldc_w 1023
    //   1917: bipush 145
    //   1919: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1922: invokeinterface 321 3 0
    //   1927: pop
    //   1928: aload 32
    //   1930: invokevirtual 324	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1933: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1936: invokestatic 295	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1939: ifne +15 -> 1954
    //   1942: ldc 29
    //   1944: ldc_w 1025
    //   1947: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1950: invokestatic 1028	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1953: pop
    //   1954: ldc 29
    //   1956: ldc_w 1030
    //   1959: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1962: ldc_w 819
    //   1965: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1968: iconst_0
    //   1969: ireturn
    //   1970: aload 32
    //   1972: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1975: ldc_w 1023
    //   1978: sipush -211
    //   1981: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1984: invokeinterface 321 3 0
    //   1989: pop
    //   1990: aload 32
    //   1992: sipush -211
    //   1995: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1998: goto -70 -> 1928
    //   2001: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2004: invokestatic 224	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2007: getfield 337	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2010: ldc_w 458
    //   2013: iconst_0
    //   2014: invokeinterface 355 3 0
    //   2019: istore 8
    //   2021: iload 8
    //   2023: iload 12
    //   2025: if_icmple +18 -> 2043
    //   2028: getstatic 378	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2031: invokevirtual 1032	com/tencent/smtt/sdk/m:c	()V
    //   2034: invokestatic 463	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   2037: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2040: invokevirtual 1034	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   2043: iconst_0
    //   2044: istore 5
    //   2046: iconst_0
    //   2047: istore 7
    //   2049: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2052: invokestatic 295	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   2055: ifne +63 -> 2118
    //   2058: invokestatic 463	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   2061: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2064: iconst_0
    //   2065: invokevirtual 1036	com/tencent/smtt/sdk/q:e	(Landroid/content/Context;I)I
    //   2068: istore 9
    //   2070: iload 7
    //   2072: istore 5
    //   2074: iload 9
    //   2076: iload 12
    //   2078: if_icmplt +6 -> 2084
    //   2081: iconst_1
    //   2082: istore 5
    //   2084: ldc 29
    //   2086: new 155	java/lang/StringBuilder
    //   2089: dup
    //   2090: ldc_w 1038
    //   2093: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2096: iload 9
    //   2098: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2101: ldc_w 1040
    //   2104: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: iload 12
    //   2109: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2112: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2115: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2118: iload_1
    //   2119: iload 12
    //   2121: if_icmpge +16 -> 2137
    //   2124: aload 34
    //   2126: invokestatic 689	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2129: ifne +8 -> 2137
    //   2132: iload 5
    //   2134: ifeq +276 -> 2410
    //   2137: iload 6
    //   2139: iconst_1
    //   2140: if_icmpeq +270 -> 2410
    //   2143: aload 32
    //   2145: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2148: ldc_w 1001
    //   2151: getstatic 1005	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2154: invokeinterface 321 3 0
    //   2159: pop
    //   2160: iload_2
    //   2161: ifeq +175 -> 2336
    //   2164: aload 34
    //   2166: invokestatic 689	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2169: ifeq +90 -> 2259
    //   2172: aload 32
    //   2174: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2177: ldc_w 1023
    //   2180: bipush 132
    //   2182: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2185: invokeinterface 321 3 0
    //   2190: pop
    //   2191: aload 32
    //   2193: invokevirtual 324	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2196: ldc 29
    //   2198: new 155	java/lang/StringBuilder
    //   2201: dup
    //   2202: ldc_w 1042
    //   2205: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2208: iload_1
    //   2209: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2212: ldc_w 1044
    //   2215: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: iload 12
    //   2220: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2223: ldc_w 1046
    //   2226: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: iload 8
    //   2231: invokevirtual 499	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2234: ldc_w 1048
    //   2237: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: aload 34
    //   2242: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2245: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2248: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2251: ldc_w 819
    //   2254: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2257: iconst_0
    //   2258: ireturn
    //   2259: iload 12
    //   2261: ifgt +25 -> 2286
    //   2264: aload 32
    //   2266: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2269: ldc_w 1023
    //   2272: bipush 131
    //   2274: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2277: invokeinterface 321 3 0
    //   2282: pop
    //   2283: goto -92 -> 2191
    //   2286: iload_1
    //   2287: iload 12
    //   2289: if_icmplt +25 -> 2314
    //   2292: aload 32
    //   2294: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2297: ldc_w 1023
    //   2300: bipush 129
    //   2302: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2305: invokeinterface 321 3 0
    //   2310: pop
    //   2311: goto -120 -> 2191
    //   2314: aload 32
    //   2316: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2319: ldc_w 1023
    //   2322: bipush 144
    //   2324: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2327: invokeinterface 321 3 0
    //   2332: pop
    //   2333: goto -142 -> 2191
    //   2336: sipush -212
    //   2339: istore 5
    //   2341: aload 34
    //   2343: invokestatic 689	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2346: ifeq +37 -> 2383
    //   2349: sipush -217
    //   2352: istore 5
    //   2354: aload 32
    //   2356: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2359: ldc_w 1023
    //   2362: iload 5
    //   2364: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2367: invokeinterface 321 3 0
    //   2372: pop
    //   2373: aload 32
    //   2375: iload 5
    //   2377: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2380: goto -189 -> 2191
    //   2383: iload 12
    //   2385: ifgt +11 -> 2396
    //   2388: sipush -218
    //   2391: istore 5
    //   2393: goto -39 -> 2354
    //   2396: iload_1
    //   2397: iload 12
    //   2399: if_icmplt -45 -> 2354
    //   2402: sipush -219
    //   2405: istore 5
    //   2407: goto -53 -> 2354
    //   2410: aload 34
    //   2412: aload 32
    //   2414: getfield 337	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2417: ldc_w 1050
    //   2420: aconst_null
    //   2421: invokeinterface 345 3 0
    //   2426: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2429: ifne +45 -> 2474
    //   2432: getstatic 378	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2435: invokevirtual 1032	com/tencent/smtt/sdk/m:c	()V
    //   2438: aload 32
    //   2440: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2443: ldc_w 1052
    //   2446: iconst_0
    //   2447: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2450: invokeinterface 321 3 0
    //   2455: pop
    //   2456: aload 32
    //   2458: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2461: ldc_w 1054
    //   2464: iconst_0
    //   2465: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2468: invokeinterface 321 3 0
    //   2473: pop
    //   2474: aload 32
    //   2476: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2479: ldc_w 458
    //   2482: iload 12
    //   2484: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2487: invokeinterface 321 3 0
    //   2492: pop
    //   2493: ldc 29
    //   2495: ldc_w 1056
    //   2498: iload 12
    //   2500: invokestatic 404	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2503: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2506: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2509: iload 12
    //   2511: ifle +43 -> 2554
    //   2514: iload 6
    //   2516: iconst_1
    //   2517: if_icmpne +344 -> 2861
    //   2520: aload 32
    //   2522: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2525: ldc_w 1058
    //   2528: iconst_1
    //   2529: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2532: invokeinterface 321 3 0
    //   2537: pop
    //   2538: ldc 29
    //   2540: ldc_w 1060
    //   2543: iload 6
    //   2545: invokestatic 404	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2548: invokevirtual 407	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2551: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2554: aload 32
    //   2556: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2559: ldc_w 1050
    //   2562: aload 34
    //   2564: invokeinterface 321 3 0
    //   2569: pop
    //   2570: aload 32
    //   2572: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2575: ldc_w 1062
    //   2578: aload 35
    //   2580: invokeinterface 321 3 0
    //   2585: pop
    //   2586: aload 32
    //   2588: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2591: ldc_w 1021
    //   2594: iload 13
    //   2596: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2599: invokeinterface 321 3 0
    //   2604: pop
    //   2605: aload 32
    //   2607: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2610: ldc_w 1064
    //   2613: iload 14
    //   2615: iconst_2
    //   2616: imul
    //   2617: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2620: invokeinterface 321 3 0
    //   2625: pop
    //   2626: aload 32
    //   2628: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2631: ldc_w 1066
    //   2634: iload 15
    //   2636: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2639: invokeinterface 321 3 0
    //   2644: pop
    //   2645: aload 32
    //   2647: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2650: ldc_w 1068
    //   2653: iload 16
    //   2655: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2658: invokeinterface 321 3 0
    //   2663: pop
    //   2664: aload 32
    //   2666: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2669: ldc_w 1070
    //   2672: iload 17
    //   2674: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2677: invokeinterface 321 3 0
    //   2682: pop
    //   2683: aload 32
    //   2685: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2688: ldc_w 1072
    //   2691: lload 24
    //   2693: invokestatic 985	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2696: invokeinterface 321 3 0
    //   2701: pop
    //   2702: aload 32
    //   2704: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2707: ldc_w 1074
    //   2710: lload 26
    //   2712: invokestatic 985	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2715: invokeinterface 321 3 0
    //   2720: pop
    //   2721: aload 32
    //   2723: invokevirtual 324	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2726: aload 28
    //   2728: ifnull +19 -> 2747
    //   2731: aload 32
    //   2733: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2736: ldc_w 1076
    //   2739: aload 28
    //   2741: invokeinterface 321 3 0
    //   2746: pop
    //   2747: iload_3
    //   2748: ifne +165 -> 2913
    //   2751: iload 4
    //   2753: ifeq +160 -> 2913
    //   2756: invokestatic 463	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   2759: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2762: iload 12
    //   2764: invokevirtual 1078	com/tencent/smtt/sdk/q:b	(Landroid/content/Context;I)Z
    //   2767: ifeq +146 -> 2913
    //   2770: iload_2
    //   2771: ifeq +111 -> 2882
    //   2774: aload 32
    //   2776: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2779: ldc_w 1023
    //   2782: bipush 143
    //   2784: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2787: invokeinterface 321 3 0
    //   2792: pop
    //   2793: aload 32
    //   2795: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2798: ldc_w 1001
    //   2801: getstatic 1005	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2804: invokeinterface 321 3 0
    //   2809: pop
    //   2810: ldc 29
    //   2812: ldc_w 1080
    //   2815: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2818: aload 33
    //   2820: ldc_w 1082
    //   2823: iconst_0
    //   2824: invokevirtual 875	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2827: iconst_1
    //   2828: if_icmpne +20 -> 2848
    //   2831: aload 32
    //   2833: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2836: ldc_w 1084
    //   2839: getstatic 1087	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2842: invokeinterface 321 3 0
    //   2847: pop
    //   2848: aload 32
    //   2850: invokevirtual 324	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2853: ldc_w 819
    //   2856: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2859: iconst_1
    //   2860: ireturn
    //   2861: aload 32
    //   2863: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2866: ldc_w 1058
    //   2869: iconst_0
    //   2870: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2873: invokeinterface 321 3 0
    //   2878: pop
    //   2879: goto -341 -> 2538
    //   2882: aload 32
    //   2884: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2887: ldc_w 1023
    //   2890: sipush -213
    //   2893: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2896: invokeinterface 321 3 0
    //   2901: pop
    //   2902: aload 32
    //   2904: sipush -213
    //   2907: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2910: goto -117 -> 2793
    //   2913: iload_3
    //   2914: ifne +151 -> 3065
    //   2917: iload 4
    //   2919: ifeq +146 -> 3065
    //   2922: getstatic 378	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2925: astore_0
    //   2926: iload 13
    //   2928: iconst_1
    //   2929: if_icmpeq +9 -> 2938
    //   2932: iload 13
    //   2934: iconst_2
    //   2935: if_icmpne +108 -> 3043
    //   2938: iconst_1
    //   2939: istore 4
    //   2941: aload_0
    //   2942: iload_3
    //   2943: iload 4
    //   2945: invokevirtual 1090	com/tencent/smtt/sdk/m:a	(ZZ)Z
    //   2948: ifeq +117 -> 3065
    //   2951: aload 32
    //   2953: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2956: ldc_w 1001
    //   2959: getstatic 1005	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2962: invokeinterface 321 3 0
    //   2967: pop
    //   2968: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2971: invokestatic 777	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2974: invokevirtual 781	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2977: astore_0
    //   2978: aload_0
    //   2979: bipush 100
    //   2981: invokevirtual 786	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2984: aload_0
    //   2985: new 155	java/lang/StringBuilder
    //   2988: dup
    //   2989: ldc_w 1092
    //   2992: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2995: getstatic 378	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   2998: getfield 1094	com/tencent/smtt/sdk/m:a	Ljava/lang/String;
    //   3001: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3004: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3007: invokevirtual 789	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   3010: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3013: invokestatic 1096	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   3016: ifeq +33 -> 3049
    //   3019: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3022: invokestatic 777	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3025: getstatic 1099	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3028: aload_0
    //   3029: invokevirtual 799	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3032: ldc 29
    //   3034: ldc_w 1101
    //   3037: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3040: goto -222 -> 2818
    //   3043: iconst_0
    //   3044: istore 4
    //   3046: goto -105 -> 2941
    //   3049: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3052: invokestatic 777	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3055: getstatic 795	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3058: aload_0
    //   3059: invokevirtual 799	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3062: goto -30 -> 3032
    //   3065: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3068: invokestatic 224	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3071: getfield 337	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   3074: ldc_w 1058
    //   3077: iconst_0
    //   3078: invokeinterface 355 3 0
    //   3083: iconst_1
    //   3084: if_icmpne +120 -> 3204
    //   3087: getstatic 378	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   3090: invokevirtual 1103	com/tencent/smtt/sdk/m:a	()Z
    //   3093: ifeq +111 -> 3204
    //   3096: aload 32
    //   3098: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3101: ldc_w 1001
    //   3104: getstatic 1005	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3107: invokeinterface 321 3 0
    //   3112: pop
    //   3113: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3116: invokestatic 777	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3119: invokevirtual 781	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3122: astore_0
    //   3123: aload_0
    //   3124: bipush 100
    //   3126: invokevirtual 786	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   3129: aload_0
    //   3130: new 155	java/lang/StringBuilder
    //   3133: dup
    //   3134: ldc_w 1105
    //   3137: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3140: getstatic 378	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/m;
    //   3143: getfield 1094	com/tencent/smtt/sdk/m:a	Ljava/lang/String;
    //   3146: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3149: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3152: invokevirtual 789	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   3155: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3158: invokestatic 1096	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   3161: ifeq +27 -> 3188
    //   3164: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3167: invokestatic 777	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3170: getstatic 1099	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3173: aload_0
    //   3174: invokevirtual 799	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3177: ldc 29
    //   3179: ldc_w 1107
    //   3182: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3185: goto -367 -> 2818
    //   3188: getstatic 98	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3191: invokestatic 777	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3194: getstatic 795	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3197: aload_0
    //   3198: invokevirtual 799	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3201: goto -24 -> 3177
    //   3204: iload_2
    //   3205: ifne +11 -> 3216
    //   3208: aload 32
    //   3210: sipush -216
    //   3213: invokevirtual 662	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3216: aload 32
    //   3218: getfield 313	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3221: ldc_w 1001
    //   3224: getstatic 1087	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   3227: invokeinterface 321 3 0
    //   3232: pop
    //   3233: ldc 29
    //   3235: ldc_w 1109
    //   3238: invokestatic 175	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3241: goto -423 -> 2818
    //   3244: astore_0
    //   3245: iload 7
    //   3247: istore 6
    //   3249: goto -1683 -> 1566
    //   3252: astore_0
    //   3253: goto -1707 -> 1546
    //   3256: astore 29
    //   3258: goto -2200 -> 1058
    //   3261: astore_0
    //   3262: goto -2931 -> 331
    //   3265: ldc2_w 1110
    //   3268: lstore 22
    //   3270: goto -1804 -> 1466
    //   3273: goto -1814 -> 1459
    //   3276: iconst_1
    //   3277: istore 20
    //   3279: goto -2260 -> 1019
    //   3282: goto -2483 -> 799
    //   3285: goto -2341 -> 944
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3288	0	paramString	String
    //   0	3288	1	paramInt	int
    //   0	3288	2	paramBoolean1	boolean
    //   0	3288	3	paramBoolean2	boolean
    //   0	3288	4	paramBoolean3	boolean
    //   110	2296	5	i1	int
    //   325	2923	6	i2	int
    //   639	2607	7	i3	int
    //   635	1595	8	i4	int
    //   604	1493	9	i5	int
    //   607	448	10	i6	int
    //   610	402	11	i7	int
    //   220	2543	12	i8	int
    //   171	2765	13	i9	int
    //   235	2382	14	i10	int
    //   245	2390	15	i11	int
    //   255	2399	16	i12	int
    //   265	2408	17	i13	int
    //   312	1131	18	i14	int
    //   396	990	19	bool1	boolean
    //   631	2647	20	bool2	boolean
    //   616	720	21	bool3	boolean
    //   301	2968	22	l1	long
    //   275	2417	24	l2	long
    //   285	2426	26	l3	long
    //   387	2353	28	localObject1	Object
    //   627	695	29	localObject2	Object
    //   1342	10	29	localException1	Exception
    //   3256	1	29	localException2	Exception
    //   623	215	30	str1	String
    //   653	367	31	str2	String
    //   45	3172	32	localTbsDownloadConfig	TbsDownloadConfig
    //   100	2719	33	localJSONObject	JSONObject
    //   186	2377	34	str3	String
    //   210	2369	35	str4	String
    // Exception table:
    //   from	to	target	type
    //   369	389	1218	finally
    //   398	410	1218	finally
    //   414	425	1272	finally
    //   435	466	1272	finally
    //   476	507	1272	finally
    //   517	553	1272	finally
    //   564	600	1272	finally
    //   645	655	1320	java/lang/Exception
    //   679	689	1320	java/lang/Exception
    //   713	723	1320	java/lang/Exception
    //   747	758	1320	java/lang/Exception
    //   782	793	1320	java/lang/Exception
    //   826	837	1320	java/lang/Exception
    //   861	870	1320	java/lang/Exception
    //   893	904	1320	java/lang/Exception
    //   927	938	1320	java/lang/Exception
    //   967	978	1320	java/lang/Exception
    //   1001	1011	1320	java/lang/Exception
    //   1031	1041	1342	java/lang/Exception
    //   1071	1087	1350	finally
    //   1087	1145	1350	finally
    //   1145	1148	1350	finally
    //   1829	1841	1844	finally
    //   1546	1566	3244	java/lang/Exception
    //   1523	1533	3252	java/lang/Exception
    //   1537	1542	3252	java/lang/Exception
    //   1797	1817	3252	java/lang/Exception
    //   1044	1054	3256	java/lang/Exception
    //   317	327	3261	java/lang/Exception
  }
  
  protected static File b(int paramInt)
  {
    AppMethodBeat.i(54150);
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject = null;
    int i2 = arrayOfString.length;
    int i1 = 0;
    for (;;)
    {
      String str;
      if (i1 < i2)
      {
        localObject = arrayOfString[i1];
        str = f.a(c, (String)localObject, 4, false);
        if (!getOverSea(c)) {
          break label113;
        }
      }
      label113:
      for (localObject = "x5.oversea.tbs.org";; localObject = getBackupFileName(false))
      {
        localObject = new File(str, (String)localObject);
        if ((!((File)localObject).exists()) || (a.a(c, (File)localObject) != paramInt)) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        AppMethodBeat.o(54150);
        return localObject;
      }
      i1 += 1;
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
    localObject = Build.VERSION.RELEASE;
    try
    {
      String str = new String(((String)localObject).getBytes("UTF-8"), "ISO8859-1");
      localObject = str;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        if (((String)localObject).length() > 0)
        {
          localStringBuffer.append((String)localObject);
        }
        else
        {
          localStringBuffer.append("1.0");
          continue;
          localStringBuffer.append("en");
        }
      }
    }
    if (localObject == null)
    {
      localStringBuffer.append("1.0");
      localStringBuffer.append("; ");
      localObject = localLocale.getLanguage();
      if (localObject == null) {
        break label276;
      }
      localStringBuffer.append(((String)localObject).toLowerCase());
      localObject = localLocale.getCountry();
      if (localObject != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(((String)localObject).toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = r.d(paramContext);
      }
    }
    try
    {
      localObject = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = (Context)localObject;
    }
    catch (Exception localException1)
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
        break label315;
      }
      paramContext = "";
      paramContext = paramContext.replaceAll("[一-龥]", "");
      if (paramContext != null) {
        break label322;
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
    int i3 = 0;
    AppMethodBeat.i(54138);
    int i4;
    int i1;
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      i4 = q.a().a(TbsShareManager.getHostCorePathAppDefined());
      i1 = 0;
    }
    for (;;)
    {
      int i2 = i3;
      if (i1 < paramJSONArray.length())
      {
        if (paramJSONArray.optInt(i1) == i4) {
          i2 = 1;
        }
      }
      else
      {
        if (i2 == 0) {
          paramJSONArray.put(i4);
        }
        AppMethodBeat.o(54138);
        return;
      }
      i1 += 1;
    }
  }
  
  private static boolean b(final boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(54143);
    TbsLog.i("TbsDownload", "sendRequest isQuery is " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
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
    m.b(c);
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
    Object localObject4 = c;
    if (g.a == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((q)localObject1).b((Context)localObject4, bool);
      if ((!q.a().b(c)) || ((r.c(c)) && (paramBoolean3))) {
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
    localObject4 = f.a(c, 1);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    }
    for (;;)
    {
      new File((String)localObject4, (String)localObject1);
      localObject4 = f.a(c, 2);
      if (getOverSea(c))
      {
        localObject1 = "x5.oversea.tbs.org";
        label564:
        new File((String)localObject4, (String)localObject1);
        localObject4 = f.a(c, 3);
        if (!getOverSea(c)) {
          break label1256;
        }
        localObject1 = "x5.oversea.tbs.org";
        label598:
        new File((String)localObject4, (String)localObject1);
        localObject4 = f.a(c, 4);
        if (!getOverSea(c)) {
          break label1265;
        }
        localObject1 = "x5.oversea.tbs.org";
        label632:
        new File((String)localObject4, (String)localObject1);
        if (e == null)
        {
          e = b.a();
          localTbsDownloadConfig.mSyncMap.put("device_cpuabi", e);
          localTbsDownloadConfig.commit();
        }
        i1 = 0;
        i2 = i1;
        if (!TextUtils.isEmpty(e)) {
          localObject1 = null;
        }
      }
      try
      {
        localObject4 = Pattern.compile("i686|mips|x86_64").matcher(e);
        localObject1 = localObject4;
      }
      catch (Exception localException7)
      {
        label715:
        int i3;
        break label715;
      }
      int i2 = i1;
      if (localObject1 != null)
      {
        i2 = i1;
        if (((Matcher)localObject1).find())
        {
          if (!TbsShareManager.isThirdPartyApp(c)) {
            break label1293;
          }
          TbsLog.e("TbsDownload", "don't support x86 devices,skip send request");
          localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
          if (!paramBoolean1) {
            break label1274;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
          label782:
          ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail("mycpu is " + e);
          TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
          label820:
          i2 = 1;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("app_versionname", b.d(c));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.e(c)));
      localTbsDownloadConfig.commit();
      localObject1 = a(paramBoolean1, paramBoolean2, paramBoolean3);
      i3 = -1;
      try
      {
        i1 = ((JSONObject)localObject1).getInt("TBSV");
        i3 = i1;
      }
      catch (Exception localException6)
      {
        label896:
        int i4;
        break label896;
      }
      i4 = -1;
      try
      {
        i1 = ((JSONObject)localObject1).getInt("REQUEST_TPATCH");
        i4 = i1;
      }
      catch (Exception localException5)
      {
        label913:
        int i5;
        break label913;
      }
      i5 = -1;
      label930:
      label947:
      label1332:
      label1372:
      label2149:
      try
      {
        i1 = ((JSONObject)localObject1).getInt("TBSDV");
        i5 = i1;
      }
      catch (Exception localException4)
      {
        int i6;
        label1256:
        label1265:
        label1274:
        break label930;
      }
      i6 = -1;
      try
      {
        i1 = ((JSONObject)localObject1).getInt("TBSBACKUPV");
        i6 = i1;
      }
      catch (Exception localException3)
      {
        int i7;
        break label947;
      }
      int i1 = -1;
      i7 = i1;
      try
      {
        if (((JSONObject)localObject1).has("REQUEST_64")) {
          i7 = ((JSONObject)localObject1).getInt("REQUEST_64");
        }
        i1 = -1;
        try
        {
          if (((JSONObject)localObject1).has("FUNCTION")) {
            i1 = ((JSONObject)localObject1).getInt("FUNCTION");
          }
          if ((i2 != 0) || (i3 != -1))
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
              localTbsDownloadConfig.mSyncMap.put("app_versionname", b.d(c));
              localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(b.e(c)));
              localTbsDownloadConfig.mSyncMap.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
              localTbsDownloadConfig.commit();
              if (i2 == 0) {
                break label1372;
              }
              if (!paramBoolean1) {
                break label1332;
              }
              localObject1 = TbsDownloadUpload.getInstance(c);
              ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(147));
              ((TbsDownloadUpload)localObject1).commit();
              AppMethodBeat.o(54143);
              return false;
              localObject1 = getBackupFileName(false);
              continue;
              localObject1 = getBackupFileName(false);
              break label564;
              localObject1 = getBackupFileName(false);
              break label598;
              localObject1 = getBackupFileName(false);
              break label632;
              localTbsDownloadConfig.setDownloadInterruptCode(-205);
              ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
              break label782;
              label1293:
              if (paramBoolean1)
              {
                localTbsDownloadConfig.setDownloadInterruptCode(-104);
                break label820;
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
            if (!paramBoolean3)
            {
              localObject1 = TbsDownloadUpload.getInstance(c);
              ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(167));
              ((TbsDownloadUpload)localObject1).commit();
            }
          }
          if ((i3 != -1) || (paramBoolean3))
          {
            try
            {
              str2 = com.tencent.smtt.utils.o.a(c).d();
              TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=".concat(String.valueOf(str2)));
              if (!paramBoolean1) {
                break label1753;
              }
              localObject5 = TbsDownloadUpload.getInstance(c);
              ((TbsDownloadUpload)localObject5).a.put("tbs_needdownload_code", Integer.valueOf(148));
              ((TbsDownloadUpload)localObject5).a.put("tbs_needdownload_sent", Integer.valueOf(1));
              ((TbsDownloadUpload)localObject5).commit();
              TbsLog.i("TbsDownload", "sendRequest query 148");
              if (!paramBoolean1) {
                break label1837;
              }
              q = (JSONObject)localObject1;
            }
            finally
            {
              for (;;)
              {
                String str2;
                Object localObject5;
                paramBoolean2 = false;
                if (!paramBoolean1) {
                  break;
                }
                localTbsDownloadConfig.setDownloadInterruptCode(-106);
                continue;
                r = localObject2;
                continue;
                if (paramBoolean3)
                {
                  localObject5 = "requesttpatch=is=".concat(String.valueOf(i4));
                  localObject5 = (String)localObject5 + "_tbsdv=is=" + i5;
                  localObject5 = (String)localObject5 + "_tbsbackupv=is=" + i6;
                  localObject5 = (String)localObject5 + "_request64=is=" + i7;
                  localObject5 = (String)localObject5 + "_functionUpload=is=" + i1;
                  r.a(c, "request_download_update", (String)localObject5);
                }
                else if (TbsShareManager.isThirdPartyApp(c))
                {
                  localObject5 = "requesttpatch=is=".concat(String.valueOf(i4));
                  localObject5 = (String)localObject5 + "_tbsdv=is=" + i5;
                  localObject5 = (String)localObject5 + "_tbsbackupv=is=" + i6;
                  localObject5 = (String)localObject5 + "_request64=is=" + i7;
                  localObject5 = (String)localObject5 + "_functionUpload=is=" + i1;
                  new StringBuilder().append((String)localObject5).append("_tbsLocalVersion=is=").append(i3);
                  continue;
                  paramBoolean2 = paramBoolean4;
                  if (paramBoolean3)
                  {
                    str1 = "needStartDownload=is=".concat(String.valueOf(paramBoolean4));
                    str1 = str1 + "_RESPONSECODE=is=" + p;
                    str1 = str1 + "_DOWNLOADURLEmpty=is=" + m;
                    str1 = str1 + "_TBSAPKSERVERVERSION=is=" + n;
                    str1 = str1 + "_TBSAPKFILESIZE=is=" + o;
                    r.a(c, "response_download_update", str1);
                    paramBoolean2 = paramBoolean4;
                  }
                }
              }
            }
            if (paramBoolean1)
            {
              localObject5 = "requesttpatch=is=".concat(String.valueOf(i4));
              localObject5 = (String)localObject5 + "_tbsdv=is=" + i5;
              localObject5 = (String)localObject5 + "_tbsbackupv=is=" + i6;
              localObject5 = (String)localObject5 + "_request64=is=" + i7;
              r.a(c, "request_query", (String)localObject5);
              paramBoolean4 = a(com.tencent.smtt.utils.g.a(str2, ((JSONObject)localObject1).toString().getBytes("utf-8"), new g.a()
              {
                public final void a(int paramAnonymousInt)
                {
                  AppMethodBeat.i(219398);
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
                      AppMethodBeat.o(219398);
                      return;
                    }
                    this.a.setDownloadInterruptCode(-207);
                  }
                  AppMethodBeat.o(219398);
                }
              }, false), i3, paramBoolean1, paramBoolean2, paramBoolean4);
              if (!paramBoolean1) {
                break label2149;
              }
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = "needStartDownload=is=".concat(String.valueOf(paramBoolean4));
              localObject1 = (String)localObject1 + "_DECOUPLECOREVERSION=is=" + l;
              localObject1 = (String)localObject1 + "_DOWNLOADURLEmpty=is=" + m;
              localObject1 = (String)localObject1 + "_TBSAPKSERVERVERSION=is=" + n;
              r.a(c, "response_query", (String)localObject1);
              paramBoolean2 = paramBoolean4;
            }
            finally
            {
              label1753:
              String str1;
              label1837:
              paramBoolean2 = paramBoolean4;
              continue;
              localTbsDownloadConfig.setDownloadInterruptCode(-206);
              continue;
            }
            AppMethodBeat.o(54143);
            return paramBoolean2;
            if (paramBoolean3) {
              break;
            }
            localObject5 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject5).a.put("tbs_startdownload_code", Integer.valueOf(168));
            ((TbsDownloadUpload)localObject5).a.put("tbs_startdownload_sent", Integer.valueOf(1));
            ((TbsDownloadUpload)localObject5).commit();
            TbsLog.i("TbsDownload", "sendRequest download 168");
            break;
            TbsDownloadUpload localTbsDownloadUpload;
            if (paramBoolean1)
            {
              localTbsDownloadUpload = TbsDownloadUpload.getInstance(c);
              localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(149));
              localTbsDownloadUpload.commit();
              paramBoolean2 = false;
            }
            else
            {
              if (!paramBoolean3)
              {
                localTbsDownloadUpload = TbsDownloadUpload.getInstance(c);
                localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(169));
                localTbsDownloadUpload.commit();
              }
              paramBoolean2 = false;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          i7 = i1;
        }
      }
    }
  }
  
  private static void c(int paramInt)
  {
    int i3 = 1;
    AppMethodBeat.i(219722);
    for (;;)
    {
      long l1;
      String str1;
      String str2;
      try
      {
        TbsLog.i("TbsDownload", "sendRequestForOtherStableCore cpuType is " + paramInt + " mJsonDataQuery is " + q + " mJsonDataDownloadUpdate is " + r);
        if (!r.c(c))
        {
          TbsLog.i("TbsDownload", "sendRequestForOtherStableCore isStableCoreForHostEnable is false and return ");
          AppMethodBeat.o(219722);
          return;
        }
        if (paramInt < 32)
        {
          AppMethodBeat.o(219722);
          return;
        }
        if (q == null) {
          q = r;
        }
        Object localObject1 = q;
        if (localObject1 == null)
        {
          AppMethodBeat.o(219722);
          return;
        }
        l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_stable_core_other_cpu", 0L);
        if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval())
        {
          TbsLog.i("TbsDownload", "sendRequestForOtherStableCore less than and return ");
          AppMethodBeat.o(219722);
          return;
        }
        if (paramInt == 64)
        {
          q.put("REQUEST_64", 1);
          i1 = 1;
          q.put("DOWNLOADDECOUPLECORE", 1);
          if (paramInt == 64)
          {
            if (n.a(c).c("stable_64_tpatch_fail") != 1) {
              break label1544;
            }
            TbsLog.i("TbsDownload", "sendRequestForOtherStableCore stable_64_last_tpatch_fail and set REQUEST_TPATCH  0 ");
            break label1549;
            q.put("REQUEST_TPATCH", i2);
            int i4 = TbsShareManager.getTbsStableCoreVersion(c, paramInt);
            int i5 = q.a().j(c);
            q.put("TBSDV", i5 % 10000);
            q.put("TBSBACKUPV", i4);
            if (i2 == 0)
            {
              q.put("TBSDV", 0);
              q.put("TBSBACKUPV", 0);
            }
            if (i4 <= 0) {
              break label1069;
            }
            q.put("FUNCTION", 1);
            q.put("TBSV", 0);
            localObject1 = com.tencent.smtt.utils.o.a(c).d();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequestForOtherStableCore] postUrl=".concat(String.valueOf(localObject1)));
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequestForOtherStableCore] mJsonDataQuery=" + q.toString());
            v = q;
            str1 = "requesttpatch=is=".concat(String.valueOf(i2));
            str1 = str1 + "_tbsdv=is=" + i4;
            str1 = str1 + "_tbsbackupv=is=" + i4;
            str1 = str1 + "_request64=is=" + i1;
            str1 = str1 + "_functionUpload=is=" + i3;
            r.a(c, "request_download_update_other", str1);
            localObject1 = com.tencent.smtt.utils.g.a((String)localObject1, q.toString().getBytes("utf-8"), new g.a()
            {
              public final void a(int paramAnonymousInt) {}
            }, false);
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequestForOtherStableCore] response=".concat(String.valueOf(localObject1)));
            localObject1 = new JSONObject((String)localObject1);
            TbsDownloadConfig.getInstance(c).mSyncMap.put("last_download_stable_core_other_cpu", Long.valueOf(System.currentTimeMillis()));
            TbsDownloadConfig.getInstance(c).commit();
            str2 = ((JSONObject)localObject1).getString("DOWNLOADURL");
            l1 = ((JSONObject)localObject1).getLong("TBSAPKFILESIZE");
            str1 = ((JSONObject)localObject1).getString("PKGMD5");
            i1 = ((JSONObject)localObject1).getInt("TBSAPKSERVERVERSION");
            i2 = ((JSONObject)localObject1).getInt("RESPONSECODE");
            s = false;
            if (!r.c(c)) {
              break label1271;
            }
            i3 = TbsShareManager.getTbsStableCoreVersion(c, paramInt);
            localObject1 = "newcore=is=".concat(String.valueOf(i1));
            localObject1 = (String)localObject1 + "_oldcore=is=" + i3;
            localObject1 = (String)localObject1 + "_RESPONSECODE=is=" + i2;
            localObject1 = (String)localObject1 + "_DOWNLOADURLEmpty=is=" + TextUtils.isEmpty(str2);
            localObject1 = (String)localObject1 + "_TBSAPKSERVERVERSION=is=" + i1;
            localObject1 = (String)localObject1 + "_TBSAPKFILESIZE=is=" + l1;
            r.a(c, "response_download_update_other", (String)localObject1);
            if (i3 >= i1) {
              break label1518;
            }
            if (!a(i1, i3, paramInt)) {
              break label1085;
            }
            localObject1 = TbsDownloadConfig.getInstance(c);
            ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(paramInt));
            ((TbsDownloadConfig)localObject1).commit();
            TbsLog.i("TbsDownload", "sendRequestForOtherStableCore stable core " + i1 + " copy from old backup and return ");
            localObject1 = "oldcore=is=".concat(String.valueOf(i3));
            localObject1 = (String)localObject1 + "_newcore=is=" + i1;
            r.a(c, "copy_other_cpu_core_ok", (String)localObject1);
            AppMethodBeat.o(219722);
          }
        }
        else
        {
          if (paramInt != 32) {
            break label1554;
          }
          q.remove("REQUEST_64");
          break label1554;
        }
        if (n.a(c).c("stable_32_tpatch_fail") != 1) {
          break label1544;
        }
        TbsLog.i("TbsDownload", "sendRequestForOtherStableCore stable_32_last_tpatch_fail and set REQUEST_TPATCH  0 ");
      }
      finally
      {
        new StringBuilder("stack is ").append(Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(219722);
        return;
      }
      label1069:
      q.put("FUNCTION", 0);
      i3 = 0;
      continue;
      label1085:
      TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
      localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", str2);
      localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Long.valueOf(l1));
      localTbsDownloadConfig.mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(paramInt));
      Map localMap = localTbsDownloadConfig.mSyncMap;
      Object localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      localMap.put("tbs_apk_md5", localObject2);
      localTbsDownloadConfig.mSyncMap.put("tbs_downloaddecouplecore", Integer.valueOf(1));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(i1));
      localTbsDownloadConfig.mSyncMap.put("tbs_responsecode", Integer.valueOf(i2));
      localTbsDownloadConfig.commit();
      TbsLog.i("TbsDownload", "sendRequestForOtherStableCore downloadUrl is ".concat(String.valueOf(str2)), true);
      if (!TextUtils.isEmpty(str2)) {
        g.b(false, true);
      }
      for (;;)
      {
        label1271:
        d(paramInt);
        if (s)
        {
          i2 = TbsShareManager.getTbsStableCoreVersion(c, paramInt);
          u = 0;
          boolean bool = a(t, i2, paramInt);
          TbsLog.i("TbsDownload", "other cpu stable core is flowed and copyFromOldBackupDone is " + bool + " tbsDownloadVersion is " + i1 + " oldBackupCoreVersion is " + u + " localStableCore is " + i2 + " cpuType is " + paramInt);
          localObject2 = "newcore=is=" + t;
          localObject2 = (String)localObject2 + "_backupcore=is=" + u;
          localObject2 = (String)localObject2 + "_localstablecore=is=" + i2;
          localObject2 = (String)localObject2 + "_cputype=is=" + paramInt;
          localObject2 = (String)localObject2 + "_result=is=" + bool;
          r.a(c, "copy_other_cpu_core_ok_flowed", (String)localObject2);
        }
        AppMethodBeat.o(219722);
        return;
        label1518:
        if ((TextUtils.isEmpty(str2)) && (i1 == 0) && (l1 > 0L)) {
          s = true;
        }
      }
      label1544:
      int i2 = 1;
      continue;
      label1549:
      i2 = 0;
      continue;
      label1554:
      int i1 = -1;
    }
  }
  
  static void c(Context paramContext)
  {
    AppMethodBeat.i(54147);
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    m.e(paramContext);
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
    int i4;
    Context localContext;
    if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore())
    {
      String[] arrayOfString = f();
      int i3 = arrayOfString.length;
      int i1 = 0;
      for (;;)
      {
        if (i1 < i3)
        {
          str = arrayOfString[i1];
          i4 = TbsShareManager.getBackupCoreVersion(c, str);
          if (i4 > 0)
          {
            localContext = TbsShareManager.getPackageContext(c, str, false);
            if ((localContext != null) && (!q.a().g(localContext)))
            {
              TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
              i1 += 1;
              continue;
            }
            i2 = 0;
            label107:
            if (i2 >= paramJSONArray.length()) {
              break label261;
            }
            if (paramJSONArray.optInt(i2) != i4) {
              break label199;
            }
          }
        }
      }
    }
    label259:
    label261:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0) {
        paramJSONArray.put(i4);
      }
      i4 = TbsShareManager.getBackupDecoupleCoreVersion(c, str);
      if (i4 <= 0) {
        break;
      }
      localContext = TbsShareManager.getPackageContext(c, str, false);
      if ((localContext != null) && (!q.a().g(localContext)))
      {
        TbsLog.e("TbsDownload", "host check failed,packageName = ".concat(String.valueOf(str)));
        break;
        label199:
        i2 += 1;
        break label107;
      }
      i2 = 0;
      label208:
      if (i2 < paramJSONArray.length()) {
        if (paramJSONArray.optInt(i2) != i4) {}
      }
      for (i2 = 1;; i2 = 0)
      {
        if (i2 != 0) {
          break label259;
        }
        paramJSONArray.put(i4);
        break;
        i2 += 1;
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
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        int i3 = TbsShareManager.getSharedTbsCoreVersion(c, str);
        if (i3 > 0)
        {
          AppMethodBeat.o(54115);
          return true;
        }
        i1 += 1;
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
            AppMethodBeat.i(219401);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(219401);
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
                AppMethodBeat.o(219401);
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
                    AppMethodBeat.o(219401);
                  }
                }
                else
                {
                  localObject2 = localObject3;
                  if (f.a(TbsDownloader.a()))
                  {
                    TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
                    TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                    AppMethodBeat.o(219401);
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
                  break label730;
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
                AppMethodBeat.o(219401);
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
                  if (108 == paramAnonymousMessage.what)
                  {
                    ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(0));
                    ((TbsDownloadConfig)localObject3).commit();
                  }
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
                label730:
                QbSdk.l.onDownloadFinish(110);
              }
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
              if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {}
              for (int i = TbsShareManager.a(TbsDownloader.a(), false);; i = q.a().n(TbsDownloader.a()))
              {
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=".concat(String.valueOf(i)));
                TbsDownloader.b().a(i);
                TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
                AppMethodBeat.o(219401);
                return;
              }
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
              TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
              AppMethodBeat.o(219401);
              return;
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
              if (paramAnonymousMessage.arg1 == 0)
              {
                q.a().a((Context)paramAnonymousMessage.obj, true);
                AppMethodBeat.o(219401);
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
  
  private static void d(int paramInt)
  {
    int i1 = 0;
    AppMethodBeat.i(219729);
    if (v == null)
    {
      AppMethodBeat.o(219729);
      return;
    }
    for (;;)
    {
      try
      {
        v.put("FUNCTION", 2);
        Object localObject1 = com.tencent.smtt.utils.o.a(c).d();
        TbsLog.i("TbsDownload", "[TbsDownloader.resetOtherCpuStableCore] postUrl=".concat(String.valueOf(localObject1)));
        TbsLog.i("TbsDownload", "[TbsDownloader.resetOtherCpuStableCore] mJsonDataQueryReset=" + v.toString());
        localObject1 = com.tencent.smtt.utils.g.a((String)localObject1, v.toString().getBytes("utf-8"), new g.a()
        {
          public final void a(int paramAnonymousInt) {}
        }, false);
        TbsLog.i("TbsDownload", "[TbsDownloader.resetOtherCpuStableCore] response=".concat(String.valueOf(localObject1)));
        t = 0;
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).getInt("RESETDECOUPLECORE") != 1) {
          break label401;
        }
        localObject1 = TbsShareManager.getPackageContext(c, "com.tencent.mm", false);
        if (localObject1 == null)
        {
          localObject1 = new File(f.a(c, "com.tencent.mm", 4, true));
          TbsLog.i("TbsDownload", "[TbsDownloader.resetOtherCpuStableCore] resetDecoupleCore mFilePathStable is " + ((File)localObject1).getAbsolutePath(), true);
          File[] arrayOfFile = ((File)localObject1).listFiles();
          Pattern localPattern = Pattern.compile(a.a(false, paramInt));
          int i2 = arrayOfFile.length;
          if (i1 < i2)
          {
            File localFile2 = arrayOfFile[i1];
            if ((!localPattern.matcher(localFile2.getName()).find()) || (!localFile2.isFile()) || (!localFile2.exists())) {
              break label426;
            }
            TbsLog.i("TbsDownload", "resetOtherCpuStableCore file is " + localFile2.getAbsolutePath(), true);
            localFile2.delete();
            break label426;
          }
        }
        else
        {
          localObject1 = new File(f.a((Context)localObject1, 4));
          continue;
        }
        localFile1 = new File(localThrowable, getBackupFileName(false, paramInt));
      }
      finally
      {
        new StringBuilder("stack is ").append(Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(219729);
        return;
      }
      File localFile1;
      TbsLog.i("TbsDownload", "resetOtherCpuStableCore file is " + localFile1.getAbsolutePath(), true);
      localFile1.delete();
      AppMethodBeat.o(219729);
      return;
      try
      {
        label401:
        t = localFile1.getInt("DECOUPLECOREVERSION");
      }
      finally
      {
        AppMethodBeat.o(219729);
        return;
      }
      label426:
      i1 += 1;
    }
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
        int i1 = localObject.length;
        String[] arrayOfString = new String[i1 + 1];
        System.arraycopy(localObject, 0, arrayOfString, 0, i1);
        arrayOfString[i1] = str;
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
    AppMethodBeat.i(219617);
    boolean bool;
    if (paramInt == 64) {
      bool = true;
    }
    while (paramBoolean) {
      if (bool)
      {
        AppMethodBeat.o(219617);
        return "x5.tbs.decouple.64";
        if (paramInt == 32) {
          bool = false;
        } else {
          bool = b.b();
        }
      }
      else
      {
        AppMethodBeat.o(219617);
        return "x5.tbs.decouple";
      }
    }
    if (bool)
    {
      AppMethodBeat.o(219617);
      return "x5.tbs.org.64";
    }
    AppMethodBeat.o(219617);
    return "x5.tbs.org";
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    AppMethodBeat.i(54127);
    int i1 = q.a().i(c);
    AppMethodBeat.o(54127);
    return i1;
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    AppMethodBeat.i(54126);
    int i1 = q.a().i(paramContext);
    AppMethodBeat.o(54126);
    return i1;
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
    return w;
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
    r.a(paramContext, "need_download", "");
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
            AppMethodBeat.i(219394);
            TbsLog.i("TbsDownloader", "onProgressChanged,i=" + paramAnonymousInt1 + ",i1=" + paramAnonymousInt2);
            AppMethodBeat.o(219394);
          }
        });
      }
      if (!TbsOneGreyInfoHelper.a(paramContext).isComponentInstalled("file")) {
        TbsOneGreyInfoHelper.a(paramContext).installComponent("file", new TBSOneCallback()
        {
          public final void a(File paramAnonymousFile)
          {
            AppMethodBeat.i(219396);
            TbsLog.i("TbsDownloader", "file install onCompleted,onCompleted=".concat(String.valueOf(paramAnonymousFile)));
            AppMethodBeat.o(219396);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(219399);
            TbsLog.i("TbsDownloader", "file onError,i=" + paramAnonymousInt + ",str=" + paramAnonymousString);
            AppMethodBeat.o(219399);
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
          break label850;
        }
        paramBoolean1 = true;
      }
      label693:
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (!paramBoolean1) {
        break label886;
      }
      if (h()) {
        break label868;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
      paramBoolean1 = false;
      label745:
      if ((!bool2) && (paramTbsDownloaderCallback != null)) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=".concat(String.valueOf(paramBoolean1)));
      paramContext = localTbsDownloadUpload.a;
      if (!paramBoolean1) {
        break label1014;
      }
    }
    label850:
    label868:
    label1014:
    for (int i1 = 170;; i1 = 174)
    {
      paramContext.put("tbs_needdownload_return", Integer.valueOf(i1));
      localTbsDownloadUpload.commit();
      AppMethodBeat.o(54122);
      return paramBoolean1;
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(143));
      localTbsDownloadUpload.commit();
      break;
      paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.getBoolean("tbs_needdownload", false);
      break label693;
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-118);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      break label745;
      label886:
      i1 = q.a().n(c);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + i1 + ",needSendRequest=" + bool2);
      if ((bool2) || (i1 <= 0))
      {
        d.removeMessages(103);
        if ((i1 <= 0) && (!bool2)) {
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
      break label745;
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
    int i1 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((i1 > 0) && (i1 != q.a().i(c)) && (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != i1))
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
    int i1 = q.a().n(paramContext);
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=".concat(String.valueOf(i1)));
    if (i1 > 0)
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
      w = paramLong;
    }
    TbsLog.i("TbsDownload", "mRetryIntervalInSeconds is " + w);
    AppMethodBeat.o(54145);
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    AppMethodBeat.i(54129);
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded closeStableCore ");
    AppMethodBeat.o(54129);
    return false;
  }
  
  public static boolean startDecoupleCoreIfNeededImpl()
  {
    AppMethodBeat.i(219655);
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl ");
    if (TbsShareManager.isThirdPartyApp(c))
    {
      AppMethodBeat.o(219655);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl #1");
    m.a(c);
    m.b(c);
    if (a(c))
    {
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl return false #2");
      AppMethodBeat.o(219655);
      return false;
    }
    if (d == null)
    {
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl return false #3");
      AppMethodBeat.o(219655);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl #2");
    long l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    if (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval())
    {
      AppMethodBeat.o(219655);
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl #3");
    int i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if (r.c(c)) {}
    Object localObject;
    for (int i1 = TbsShareManager.getTbsStableCoreVersion(c, 0);; i1 = q.a().i(c))
    {
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl coreVersionForThirdApp is " + i1 + " deCoupleCoreVersion is " + i2);
      if ((i2 <= 0) || (i2 == i1)) {
        break label583;
      }
      if (!a(i2, i1, 0)) {
        break;
      }
      localObject = TbsDownloadConfig.getInstance(c);
      ((TbsDownloadConfig)localObject).mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(0));
      ((TbsDownloadConfig)localObject).commit();
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl stable core " + i2 + " copy from old backup and return ");
      localObject = "oldcore=is=".concat(String.valueOf(i1));
      localObject = (String)localObject + "_newcore=is=" + i2;
      r.a(c, "copy_my_cpu_core_ok", (String)localObject);
      AppMethodBeat.o(219655);
      return false;
    }
    if ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != i2) || (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) == 1))
    {
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl #4");
      a = true;
      d.removeMessages(108);
      localObject = Message.obtain(d, 108, QbSdk.l);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      TbsDownloadConfig.getInstance(c).mSyncMap.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(219655);
      return true;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + i2 + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
    for (;;)
    {
      AppMethodBeat.o(219655);
      return false;
      label583:
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeededImpl no need, deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + i1);
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
    int i1 = 1;
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
      paramContext.arg1 = i1;
      paramContext.sendToTarget();
      AppMethodBeat.o(54125);
      break;
      i1 = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */