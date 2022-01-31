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
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.s;
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
  private static ag g;
  private static HandlerThread h;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static long l = -1L;
  
  protected static File a(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject1 = null;
    int n = arrayOfString.length;
    int m = 0;
    Object localObject2 = localObject1;
    if (m < n)
    {
      localObject2 = arrayOfString[m];
      if (((String)localObject2).equals(c.getApplicationInfo().packageName)) {
        break label140;
      }
      localObject2 = j.a(c, (String)localObject2, 4, false);
      if (!getOverSea(c)) {
        break label127;
      }
    }
    label127:
    for (localObject1 = "x5.oversea.tbs.org";; localObject1 = "x5.tbs.org")
    {
      localObject1 = new File((String)localObject2, (String)localObject1);
      if (!((File)localObject1).exists()) {
        break label147;
      }
      if (a.a(c, (File)localObject1) != paramInt) {
        break;
      }
      TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject1).getAbsolutePath());
      localObject2 = localObject1;
      return localObject2;
    }
    TbsLog.i("TbsDownload", "version is not match");
    for (;;)
    {
      label140:
      m += 1;
      break;
      label147:
      TbsLog.i("TbsDownload", "can not find local backup core file");
    }
  }
  
  static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
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
        break label238;
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
        break label275;
      }
      paramContext = "";
      paramContext = paramContext.replaceAll("[一-龥]", "");
      if (paramContext != null) {
        break label282;
      }
      localStringBuffer.append(" Build/");
      localStringBuffer.append("00");
      paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
      b = paramContext;
      return paramContext;
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
  
  private static void a(boolean paramBoolean, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    int m = 0;
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    d.removeMessages(100);
    Message localMessage = Message.obtain(d, 100);
    if (paramTbsDownloaderCallback != null) {
      localMessage.obj = paramTbsDownloaderCallback;
    }
    localMessage.arg1 = 0;
    if (paramBoolean) {
      m = 1;
    }
    localMessage.arg1 = m;
    localMessage.sendToTarget();
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    Object localObject = null;
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    if (Build.VERSION.SDK_INT < 8)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(-102);
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
      TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + bool);
    }
    if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
    {
      TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-103);
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
        if (paramTbsDownloaderCallback != null) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        localTbsDownloadConfig.setDownloadInterruptCode(-104);
        return false;
      }
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
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + paramBoolean1);
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
      if ((l2 - l1 <= 1000L * l5) && ((i1 <= an.a().j(c)) || (i1 <= i2)) && ((!TbsShareManager.isThirdPartyApp(c)) || (l3 <= 0L) || (l2 - l3 <= l5 * 1000L) || (l4 >= 11L)))
      {
        if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!d())) {
          an.a().d(c);
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
          return paramBoolean1;
          if ((str3 == null) || (n == 0) || (str4 == null)) {
            break;
          }
          if ((str3.equals(str1)) && (n == m) && (str4.equals(str2))) {
            break label729;
          }
        }
        if (!TbsShareManager.isThirdPartyApp(c)) {
          break label729;
        }
      }
    }
    label729:
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
  private static boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 14
    //   2: new 109	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 494
    //   9: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   25: invokestatic 261	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: astore 31
    //   30: aload_0
    //   31: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifeq +35 -> 69
    //   37: iload_2
    //   38: ifeq +20 -> 58
    //   41: aload 31
    //   43: bipush 148
    //   45: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   48: ldc 14
    //   50: ldc_w 496
    //   53: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: iconst_0
    //   57: ireturn
    //   58: aload 31
    //   60: sipush -208
    //   63: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   66: goto -18 -> 48
    //   69: new 498	org/json/JSONObject
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 499	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   77: astore 32
    //   79: aload 32
    //   81: ldc_w 501
    //   84: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   87: istore 4
    //   89: iload 4
    //   91: ifeq +50 -> 141
    //   94: iload_2
    //   95: ifeq +35 -> 130
    //   98: aload 31
    //   100: bipush 147
    //   102: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   105: ldc 14
    //   107: new 109	java/lang/StringBuilder
    //   110: dup
    //   111: ldc_w 506
    //   114: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: iload 4
    //   119: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: iconst_0
    //   129: ireturn
    //   130: aload 31
    //   132: sipush -209
    //   135: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   138: goto -33 -> 105
    //   141: aload 32
    //   143: ldc_w 508
    //   146: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   149: istore 12
    //   151: aload 32
    //   153: ldc_w 510
    //   156: invokevirtual 512	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 33
    //   161: aload 32
    //   163: ldc_w 514
    //   166: ldc 204
    //   168: invokevirtual 517	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 34
    //   173: aload 32
    //   175: ldc_w 519
    //   178: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   181: istore 11
    //   183: aload 32
    //   185: ldc_w 521
    //   188: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   191: istore 13
    //   193: aload 32
    //   195: ldc_w 523
    //   198: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   201: istore 14
    //   203: aload 32
    //   205: ldc_w 525
    //   208: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   211: istore 15
    //   213: aload 32
    //   215: ldc_w 527
    //   218: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   221: istore 16
    //   223: aload 32
    //   225: ldc_w 529
    //   228: invokevirtual 532	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   231: lstore 23
    //   233: aload 32
    //   235: ldc_w 534
    //   238: invokevirtual 532	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   241: lstore 25
    //   243: aload 32
    //   245: ldc_w 536
    //   248: lconst_0
    //   249: invokevirtual 539	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   252: lstore 21
    //   254: aload 32
    //   256: ldc_w 541
    //   259: iconst_m1
    //   260: invokevirtual 544	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   263: istore 17
    //   265: iconst_0
    //   266: istore 4
    //   268: aload 32
    //   270: ldc_w 546
    //   273: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   276: istore 5
    //   278: iload 5
    //   280: istore 4
    //   282: aload 31
    //   284: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   287: ldc_w 548
    //   290: iload 4
    //   292: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: invokeinterface 298 3 0
    //   300: pop
    //   301: iload_2
    //   302: ifeq +59 -> 361
    //   305: getstatic 556	com/tencent/smtt/sdk/QbSdk:i	Z
    //   308: ifeq +53 -> 361
    //   311: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   314: invokestatic 431	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   317: ifeq +44 -> 361
    //   320: aload 32
    //   322: ldc_w 558
    //   325: iconst_0
    //   326: invokevirtual 544	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   329: istore 4
    //   331: invokestatic 563	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   334: astore_0
    //   335: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   338: astore 27
    //   340: iload 4
    //   342: iconst_1
    //   343: if_icmpne +842 -> 1185
    //   346: iconst_1
    //   347: istore 18
    //   349: aload_0
    //   350: aload 27
    //   352: ldc_w 565
    //   355: iload 18
    //   357: invokevirtual 569	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   360: pop
    //   361: iload_2
    //   362: ifeq +217 -> 579
    //   365: aload 32
    //   367: ldc_w 571
    //   370: iconst_0
    //   371: invokevirtual 544	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   374: istore 4
    //   376: iload 4
    //   378: iconst_1
    //   379: iand
    //   380: ifeq +841 -> 1221
    //   383: iconst_1
    //   384: istore 18
    //   386: invokestatic 563	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   389: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   392: ldc_w 573
    //   395: iload 18
    //   397: invokevirtual 569	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   400: pop
    //   401: ldc 14
    //   403: new 109	java/lang/StringBuilder
    //   406: dup
    //   407: ldc_w 575
    //   410: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   413: iload 18
    //   415: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   418: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 578	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: iload 4
    //   426: iconst_2
    //   427: iand
    //   428: ifeq +799 -> 1227
    //   431: iconst_1
    //   432: istore 18
    //   434: invokestatic 563	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   437: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   440: ldc_w 580
    //   443: iload 18
    //   445: invokevirtual 569	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   448: pop
    //   449: ldc 14
    //   451: new 109	java/lang/StringBuilder
    //   454: dup
    //   455: ldc_w 582
    //   458: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   461: iload 18
    //   463: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   466: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 578	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: iload 4
    //   474: iconst_4
    //   475: iand
    //   476: ifeq +757 -> 1233
    //   479: iconst_1
    //   480: istore 18
    //   482: invokestatic 563	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   485: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   488: ldc_w 584
    //   491: iload 18
    //   493: invokevirtual 569	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   496: pop
    //   497: iload 18
    //   499: invokestatic 588	com/tencent/smtt/sdk/QbSdk:setDisableUnpreinitBySwitch	(Z)V
    //   502: ldc 14
    //   504: new 109	java/lang/StringBuilder
    //   507: dup
    //   508: ldc_w 590
    //   511: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   514: iload 18
    //   516: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   519: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: iload 4
    //   527: bipush 8
    //   529: iand
    //   530: ifeq +709 -> 1239
    //   533: iconst_1
    //   534: istore 18
    //   536: invokestatic 563	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   539: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   542: ldc_w 592
    //   545: iload 18
    //   547: invokevirtual 569	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   550: pop
    //   551: iload 18
    //   553: invokestatic 595	com/tencent/smtt/sdk/QbSdk:setDisableUseHostBackupCoreBySwitch	(Z)V
    //   556: ldc 14
    //   558: new 109	java/lang/StringBuilder
    //   561: dup
    //   562: ldc_w 597
    //   565: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: iload 18
    //   570: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   573: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: aconst_null
    //   580: astore 27
    //   582: iconst_0
    //   583: istore 8
    //   585: iconst_0
    //   586: istore 9
    //   588: iconst_0
    //   589: istore 10
    //   591: iconst_0
    //   592: istore 4
    //   594: iconst_1
    //   595: istore 20
    //   597: iconst_1
    //   598: istore 18
    //   600: ldc 204
    //   602: astore 29
    //   604: aload 29
    //   606: astore 28
    //   608: iload 20
    //   610: istore 19
    //   612: iload 10
    //   614: istore 7
    //   616: iload 9
    //   618: istore 6
    //   620: iload 8
    //   622: istore 5
    //   624: aload 32
    //   626: ldc_w 599
    //   629: invokevirtual 512	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   632: astore 30
    //   634: aload 29
    //   636: astore 28
    //   638: iload 20
    //   640: istore 19
    //   642: iload 10
    //   644: istore 7
    //   646: iload 9
    //   648: istore 6
    //   650: iload 8
    //   652: istore 5
    //   654: aload 30
    //   656: astore 27
    //   658: aload 32
    //   660: ldc_w 601
    //   663: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   666: istore 8
    //   668: aload 29
    //   670: astore 28
    //   672: iload 20
    //   674: istore 19
    //   676: iload 10
    //   678: istore 7
    //   680: iload 9
    //   682: istore 6
    //   684: iload 8
    //   686: istore 5
    //   688: aload 30
    //   690: astore 27
    //   692: aload 32
    //   694: ldc_w 603
    //   697: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   700: istore 9
    //   702: aload 29
    //   704: astore 28
    //   706: iload 20
    //   708: istore 19
    //   710: iload 10
    //   712: istore 7
    //   714: iload 9
    //   716: istore 6
    //   718: iload 8
    //   720: istore 5
    //   722: aload 30
    //   724: astore 27
    //   726: aload 32
    //   728: ldc_w 605
    //   731: invokevirtual 608	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   734: ifeq +44 -> 778
    //   737: aload 29
    //   739: astore 28
    //   741: iload 20
    //   743: istore 19
    //   745: iload 10
    //   747: istore 7
    //   749: iload 9
    //   751: istore 6
    //   753: iload 8
    //   755: istore 5
    //   757: aload 30
    //   759: astore 27
    //   761: aload 32
    //   763: ldc_w 605
    //   766: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   769: ifeq +506 -> 1275
    //   772: iconst_1
    //   773: istore 4
    //   775: goto +2451 -> 3226
    //   778: aload 29
    //   780: astore_0
    //   781: aload 29
    //   783: astore 28
    //   785: iload 20
    //   787: istore 19
    //   789: iload 4
    //   791: istore 7
    //   793: iload 9
    //   795: istore 6
    //   797: iload 8
    //   799: istore 5
    //   801: aload 30
    //   803: astore 27
    //   805: aload 32
    //   807: ldc_w 610
    //   810: invokevirtual 608	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   813: ifeq +36 -> 849
    //   816: aload 29
    //   818: astore 28
    //   820: iload 20
    //   822: istore 19
    //   824: iload 4
    //   826: istore 7
    //   828: iload 9
    //   830: istore 6
    //   832: iload 8
    //   834: istore 5
    //   836: aload 30
    //   838: astore 27
    //   840: aload 32
    //   842: ldc_w 610
    //   845: invokevirtual 512	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   848: astore_0
    //   849: aload_0
    //   850: astore 28
    //   852: iload 20
    //   854: istore 19
    //   856: iload 4
    //   858: istore 7
    //   860: iload 9
    //   862: istore 6
    //   864: iload 8
    //   866: istore 5
    //   868: aload 30
    //   870: astore 27
    //   872: aload 32
    //   874: ldc_w 612
    //   877: invokevirtual 608	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   880: ifeq +43 -> 923
    //   883: aload_0
    //   884: astore 28
    //   886: iload 20
    //   888: istore 19
    //   890: iload 4
    //   892: istore 7
    //   894: iload 9
    //   896: istore 6
    //   898: iload 8
    //   900: istore 5
    //   902: aload 30
    //   904: astore 27
    //   906: aload 32
    //   908: ldc_w 612
    //   911: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   914: ifeq +367 -> 1281
    //   917: iconst_1
    //   918: istore 18
    //   920: goto +2309 -> 3229
    //   923: aload_0
    //   924: astore 28
    //   926: iload 18
    //   928: istore 19
    //   930: iload 4
    //   932: istore 7
    //   934: iload 9
    //   936: istore 6
    //   938: iload 8
    //   940: istore 5
    //   942: aload 30
    //   944: astore 27
    //   946: aload 32
    //   948: ldc_w 614
    //   951: invokevirtual 608	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   954: ifeq +2266 -> 3220
    //   957: aload_0
    //   958: astore 28
    //   960: iload 18
    //   962: istore 19
    //   964: iload 4
    //   966: istore 7
    //   968: iload 9
    //   970: istore 6
    //   972: iload 8
    //   974: istore 5
    //   976: aload 30
    //   978: astore 27
    //   980: aload 32
    //   982: ldc_w 614
    //   985: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   988: istore 10
    //   990: iload 10
    //   992: ifeq +295 -> 1287
    //   995: iconst_1
    //   996: istore 19
    //   998: aload 30
    //   1000: astore 27
    //   1002: iload 8
    //   1004: istore 5
    //   1006: iload 9
    //   1008: istore 6
    //   1010: aload 32
    //   1012: ldc_w 616
    //   1015: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1018: istore 7
    //   1020: iconst_0
    //   1021: istore 8
    //   1023: aload 32
    //   1025: ldc_w 618
    //   1028: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1031: istore 9
    //   1033: iload 9
    //   1035: istore 8
    //   1037: getstatic 41	com/tencent/smtt/sdk/TbsDownloader:f	Ljava/lang/Object;
    //   1040: astore 28
    //   1042: aload 28
    //   1044: monitorenter
    //   1045: iload 4
    //   1047: ifeq +19 -> 1066
    //   1050: aload 31
    //   1052: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1055: ldc_w 620
    //   1058: ldc 204
    //   1060: invokeinterface 298 3 0
    //   1065: pop
    //   1066: aload_0
    //   1067: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1070: ifne +54 -> 1124
    //   1073: aload_0
    //   1074: invokevirtual 224	java/lang/String:length	()I
    //   1077: bipush 96
    //   1079: if_icmpne +45 -> 1124
    //   1082: new 109	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 621	java/lang/StringBuilder:<init>	()V
    //   1089: aload_0
    //   1090: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: ldc_w 623
    //   1096: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokestatic 627	com/tencent/smtt/utils/n:c	()Ljava/lang/String;
    //   1102: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: astore_0
    //   1109: aload 31
    //   1111: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1114: ldc_w 620
    //   1117: aload_0
    //   1118: invokeinterface 298 3 0
    //   1123: pop
    //   1124: aload 28
    //   1126: monitorexit
    //   1127: iload 5
    //   1129: iconst_1
    //   1130: if_icmpne +215 -> 1345
    //   1133: iload_2
    //   1134: ifeq +195 -> 1329
    //   1137: aload 31
    //   1139: bipush 146
    //   1141: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1144: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1147: astore_0
    //   1148: iload 8
    //   1150: iconst_1
    //   1151: if_icmpne +189 -> 1340
    //   1154: iconst_1
    //   1155: istore_3
    //   1156: aload_0
    //   1157: iload_3
    //   1158: invokestatic 631	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   1161: ldc 14
    //   1163: new 109	java/lang/StringBuilder
    //   1166: dup
    //   1167: ldc_w 633
    //   1170: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1173: iload_2
    //   1174: invokevirtual 306	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1177: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1183: iconst_0
    //   1184: ireturn
    //   1185: iconst_0
    //   1186: istore 18
    //   1188: goto -839 -> 349
    //   1191: astore_0
    //   1192: ldc_w 635
    //   1195: new 109	java/lang/StringBuilder
    //   1198: dup
    //   1199: ldc_w 637
    //   1202: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1205: aload_0
    //   1206: invokevirtual 638	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1209: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1218: goto -857 -> 361
    //   1221: iconst_0
    //   1222: istore 18
    //   1224: goto -838 -> 386
    //   1227: iconst_0
    //   1228: istore 18
    //   1230: goto -796 -> 434
    //   1233: iconst_0
    //   1234: istore 18
    //   1236: goto -754 -> 482
    //   1239: iconst_0
    //   1240: istore 18
    //   1242: goto -706 -> 536
    //   1245: astore_0
    //   1246: ldc_w 635
    //   1249: new 109	java/lang/StringBuilder
    //   1252: dup
    //   1253: ldc_w 637
    //   1256: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1259: aload_0
    //   1260: invokevirtual 638	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1263: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1272: goto -693 -> 579
    //   1275: iconst_0
    //   1276: istore 4
    //   1278: goto +1948 -> 3226
    //   1281: iconst_0
    //   1282: istore 18
    //   1284: goto +1945 -> 3229
    //   1287: iconst_0
    //   1288: istore 19
    //   1290: goto -292 -> 998
    //   1293: astore_0
    //   1294: aload 28
    //   1296: astore_0
    //   1297: iconst_1
    //   1298: istore 20
    //   1300: iload 19
    //   1302: istore 18
    //   1304: iload 7
    //   1306: istore 4
    //   1308: iload 20
    //   1310: istore 19
    //   1312: goto -302 -> 1010
    //   1315: astore 28
    //   1317: iconst_0
    //   1318: istore 7
    //   1320: goto -300 -> 1020
    //   1323: astore_0
    //   1324: aload 28
    //   1326: monitorexit
    //   1327: aload_0
    //   1328: athrow
    //   1329: aload 31
    //   1331: sipush -210
    //   1334: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1337: goto -193 -> 1144
    //   1340: iconst_0
    //   1341: istore_3
    //   1342: goto -186 -> 1156
    //   1345: iload 18
    //   1347: ifne +10 -> 1357
    //   1350: aload 31
    //   1352: iload 18
    //   1354: invokevirtual 641	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockEnable	(Z)V
    //   1357: iload 19
    //   1359: ifne +10 -> 1369
    //   1362: aload 31
    //   1364: iload 19
    //   1366: invokevirtual 644	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockWaitEnable	(Z)V
    //   1369: iload 7
    //   1371: iconst_1
    //   1372: if_icmpne +9 -> 1381
    //   1375: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1378: invokestatic 647	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   1381: iload 6
    //   1383: iconst_1
    //   1384: if_icmpne +22 -> 1406
    //   1387: getstatic 232	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1390: bipush 104
    //   1392: invokevirtual 238	android/os/Handler:removeMessages	(I)V
    //   1395: getstatic 232	com/tencent/smtt/sdk/TbsDownloader:d	Landroid/os/Handler;
    //   1398: bipush 104
    //   1400: invokestatic 244	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1403: invokevirtual 254	android/os/Message:sendToTarget	()V
    //   1406: iload 17
    //   1408: iconst_1
    //   1409: if_icmpne +1800 -> 3209
    //   1412: lload 21
    //   1414: ldc2_w 648
    //   1417: lcmp
    //   1418: ifle +1799 -> 3217
    //   1421: ldc2_w 648
    //   1424: lstore 21
    //   1426: lload 21
    //   1428: lconst_0
    //   1429: lcmp
    //   1430: ifle +1779 -> 3209
    //   1433: invokestatic 652	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1436: lconst_0
    //   1437: lcmp
    //   1438: iflt +8 -> 1446
    //   1441: invokestatic 652	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1444: lstore 21
    //   1446: aload 31
    //   1448: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1451: ldc_w 654
    //   1454: lload 21
    //   1456: invokestatic 659	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1459: invokeinterface 298 3 0
    //   1464: pop
    //   1465: iconst_0
    //   1466: istore 4
    //   1468: iconst_0
    //   1469: istore 5
    //   1471: iload_2
    //   1472: ifeq +258 -> 1730
    //   1475: aload 32
    //   1477: ldc_w 661
    //   1480: invokevirtual 504	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1483: istore 6
    //   1485: iload 6
    //   1487: istore 4
    //   1489: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1492: invokestatic 261	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1495: getfield 271	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1498: ldc_w 663
    //   1501: iconst_0
    //   1502: invokeinterface 350 3 0
    //   1507: istore 6
    //   1509: iload 6
    //   1511: istore 5
    //   1513: iload 4
    //   1515: istore 6
    //   1517: iload_2
    //   1518: ifeq +36 -> 1554
    //   1521: iload 4
    //   1523: istore 6
    //   1525: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1528: invokestatic 431	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1531: ifne +23 -> 1554
    //   1534: iload 4
    //   1536: istore 6
    //   1538: iload 4
    //   1540: ifne +14 -> 1554
    //   1543: invokestatic 426	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   1546: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1549: invokevirtual 665	com/tencent/smtt/sdk/an:i	(Landroid/content/Context;)I
    //   1552: istore 6
    //   1554: ldc 14
    //   1556: new 109	java/lang/StringBuilder
    //   1559: dup
    //   1560: ldc_w 667
    //   1563: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1566: iload 6
    //   1568: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1571: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1574: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1577: aload 31
    //   1579: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1582: ldc_w 669
    //   1585: iload 6
    //   1587: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1590: invokeinterface 298 3 0
    //   1595: pop
    //   1596: aload 31
    //   1598: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1601: ldc_w 663
    //   1604: iload 5
    //   1606: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1609: invokeinterface 298 3 0
    //   1614: pop
    //   1615: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1618: invokestatic 431	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1621: ifne +46 -> 1667
    //   1624: iload 6
    //   1626: ifle +131 -> 1757
    //   1629: iload 6
    //   1631: invokestatic 426	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   1634: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1637: invokevirtual 665	com/tencent/smtt/sdk/an:i	(Landroid/content/Context;)I
    //   1640: if_icmpeq +117 -> 1757
    //   1643: iload 6
    //   1645: invokestatic 426	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   1648: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1651: invokevirtual 428	com/tencent/smtt/sdk/an:j	(Landroid/content/Context;)I
    //   1654: if_icmpne +103 -> 1757
    //   1657: invokestatic 426	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   1660: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1663: invokevirtual 672	com/tencent/smtt/sdk/an:o	(Landroid/content/Context;)Z
    //   1666: pop
    //   1667: aload 33
    //   1669: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1672: ifeq +109 -> 1781
    //   1675: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1678: invokestatic 431	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1681: ifeq +100 -> 1781
    //   1684: aload 31
    //   1686: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1689: ldc_w 674
    //   1692: iconst_0
    //   1693: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1696: invokeinterface 298 3 0
    //   1701: pop
    //   1702: aload 31
    //   1704: invokevirtual 301	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1707: iload_2
    //   1708: ifeq +12 -> 1720
    //   1711: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1714: iload 11
    //   1716: iconst_0
    //   1717: invokestatic 678	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1720: ldc 14
    //   1722: ldc_w 680
    //   1725: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1728: iconst_0
    //   1729: ireturn
    //   1730: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1733: invokestatic 261	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1736: getfield 271	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1739: ldc_w 669
    //   1742: iconst_0
    //   1743: invokeinterface 350 3 0
    //   1748: istore 6
    //   1750: iload 6
    //   1752: istore 4
    //   1754: goto -265 -> 1489
    //   1757: iload 6
    //   1759: ifne -92 -> 1667
    //   1762: invokestatic 426	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   1765: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1768: invokevirtual 684	com/tencent/smtt/sdk/an:q	(Landroid/content/Context;)Ljava/io/File;
    //   1771: invokestatic 687	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   1774: goto -107 -> 1667
    //   1777: astore_0
    //   1778: goto -111 -> 1667
    //   1781: ldc 14
    //   1783: new 109	java/lang/StringBuilder
    //   1786: dup
    //   1787: ldc_w 689
    //   1790: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1793: iload 12
    //   1795: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1798: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1804: iload 12
    //   1806: ifne +122 -> 1928
    //   1809: aload 31
    //   1811: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1814: ldc_w 691
    //   1817: iload 12
    //   1819: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1822: invokeinterface 298 3 0
    //   1827: pop
    //   1828: aload 31
    //   1830: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1833: ldc_w 674
    //   1836: iconst_0
    //   1837: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1840: invokeinterface 298 3 0
    //   1845: pop
    //   1846: iload_2
    //   1847: ifeq +50 -> 1897
    //   1850: aload 31
    //   1852: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1855: ldc_w 693
    //   1858: bipush 145
    //   1860: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1863: invokeinterface 298 3 0
    //   1868: pop
    //   1869: aload 31
    //   1871: invokevirtual 301	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1874: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1877: invokestatic 431	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1880: ifne +7 -> 1887
    //   1883: invokestatic 696	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1886: pop
    //   1887: ldc 14
    //   1889: ldc_w 698
    //   1892: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1895: iconst_0
    //   1896: ireturn
    //   1897: aload 31
    //   1899: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1902: ldc_w 693
    //   1905: sipush -211
    //   1908: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1911: invokeinterface 298 3 0
    //   1916: pop
    //   1917: aload 31
    //   1919: sipush -211
    //   1922: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1925: goto -56 -> 1869
    //   1928: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1931: invokestatic 261	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1934: getfield 271	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1937: ldc_w 419
    //   1940: iconst_0
    //   1941: invokeinterface 350 3 0
    //   1946: istore 7
    //   1948: iload 7
    //   1950: iload 11
    //   1952: if_icmple +18 -> 1970
    //   1955: getstatic 700	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ag;
    //   1958: invokevirtual 704	com/tencent/smtt/sdk/ag:d	()V
    //   1961: invokestatic 426	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   1964: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1967: invokevirtual 707	com/tencent/smtt/sdk/an:p	(Landroid/content/Context;)V
    //   1970: iconst_0
    //   1971: istore 4
    //   1973: iconst_0
    //   1974: istore 6
    //   1976: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1979: invokestatic 431	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1982: ifne +62 -> 2044
    //   1985: invokestatic 426	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   1988: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   1991: invokevirtual 709	com/tencent/smtt/sdk/an:h	(Landroid/content/Context;)I
    //   1994: istore 8
    //   1996: iload 6
    //   1998: istore 4
    //   2000: iload 8
    //   2002: iload 11
    //   2004: if_icmplt +6 -> 2010
    //   2007: iconst_1
    //   2008: istore 4
    //   2010: ldc 14
    //   2012: new 109	java/lang/StringBuilder
    //   2015: dup
    //   2016: ldc_w 711
    //   2019: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2022: iload 8
    //   2024: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2027: ldc_w 713
    //   2030: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: iload 11
    //   2035: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2038: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2041: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2044: iload_1
    //   2045: iload 11
    //   2047: if_icmpge +16 -> 2063
    //   2050: aload 33
    //   2052: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2055: ifne +8 -> 2063
    //   2058: iload 4
    //   2060: ifeq +271 -> 2331
    //   2063: iload 5
    //   2065: iconst_1
    //   2066: if_icmpeq +265 -> 2331
    //   2069: aload 31
    //   2071: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2074: ldc_w 674
    //   2077: iconst_0
    //   2078: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2081: invokeinterface 298 3 0
    //   2086: pop
    //   2087: iload_2
    //   2088: ifeq +169 -> 2257
    //   2091: aload 33
    //   2093: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2096: ifeq +84 -> 2180
    //   2099: aload 31
    //   2101: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2104: ldc_w 693
    //   2107: bipush 132
    //   2109: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2112: invokeinterface 298 3 0
    //   2117: pop
    //   2118: aload 31
    //   2120: invokevirtual 301	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2123: ldc 14
    //   2125: new 109	java/lang/StringBuilder
    //   2128: dup
    //   2129: ldc_w 715
    //   2132: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2135: iload_1
    //   2136: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2139: ldc_w 717
    //   2142: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2145: iload 11
    //   2147: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2150: ldc_w 719
    //   2153: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2156: iload 7
    //   2158: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2161: ldc_w 721
    //   2164: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: aload 33
    //   2169: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2175: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2178: iconst_0
    //   2179: ireturn
    //   2180: iload 11
    //   2182: ifgt +25 -> 2207
    //   2185: aload 31
    //   2187: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2190: ldc_w 693
    //   2193: bipush 131
    //   2195: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2198: invokeinterface 298 3 0
    //   2203: pop
    //   2204: goto -86 -> 2118
    //   2207: iload_1
    //   2208: iload 11
    //   2210: if_icmplt +25 -> 2235
    //   2213: aload 31
    //   2215: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2218: ldc_w 693
    //   2221: bipush 129
    //   2223: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2226: invokeinterface 298 3 0
    //   2231: pop
    //   2232: goto -114 -> 2118
    //   2235: aload 31
    //   2237: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2240: ldc_w 693
    //   2243: bipush 144
    //   2245: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2248: invokeinterface 298 3 0
    //   2253: pop
    //   2254: goto -136 -> 2118
    //   2257: sipush -212
    //   2260: istore 4
    //   2262: aload 33
    //   2264: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2267: ifeq +37 -> 2304
    //   2270: sipush -217
    //   2273: istore 4
    //   2275: aload 31
    //   2277: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2280: ldc_w 693
    //   2283: iload 4
    //   2285: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2288: invokeinterface 298 3 0
    //   2293: pop
    //   2294: aload 31
    //   2296: iload 4
    //   2298: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2301: goto -183 -> 2118
    //   2304: iload 11
    //   2306: ifgt +11 -> 2317
    //   2309: sipush -218
    //   2312: istore 4
    //   2314: goto -39 -> 2275
    //   2317: iload_1
    //   2318: iload 11
    //   2320: if_icmplt -45 -> 2275
    //   2323: sipush -219
    //   2326: istore 4
    //   2328: goto -53 -> 2275
    //   2331: aload 33
    //   2333: aload 31
    //   2335: getfield 271	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2338: ldc_w 723
    //   2341: aconst_null
    //   2342: invokeinterface 322 3 0
    //   2347: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2350: ifne +45 -> 2395
    //   2353: getstatic 700	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ag;
    //   2356: invokevirtual 704	com/tencent/smtt/sdk/ag:d	()V
    //   2359: aload 31
    //   2361: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2364: ldc_w 725
    //   2367: iconst_0
    //   2368: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2371: invokeinterface 298 3 0
    //   2376: pop
    //   2377: aload 31
    //   2379: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2382: ldc_w 727
    //   2385: iconst_0
    //   2386: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2389: invokeinterface 298 3 0
    //   2394: pop
    //   2395: aload 31
    //   2397: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2400: ldc_w 419
    //   2403: iload 11
    //   2405: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2408: invokeinterface 298 3 0
    //   2413: pop
    //   2414: ldc 14
    //   2416: new 109	java/lang/StringBuilder
    //   2419: dup
    //   2420: ldc_w 729
    //   2423: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2426: iload 11
    //   2428: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2431: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2434: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2437: iload 11
    //   2439: ifle +50 -> 2489
    //   2442: iload 5
    //   2444: iconst_1
    //   2445: if_icmpne +340 -> 2785
    //   2448: aload 31
    //   2450: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2453: ldc_w 731
    //   2456: iconst_1
    //   2457: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2460: invokeinterface 298 3 0
    //   2465: pop
    //   2466: ldc 14
    //   2468: new 109	java/lang/StringBuilder
    //   2471: dup
    //   2472: ldc_w 733
    //   2475: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2478: iload 5
    //   2480: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2483: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2486: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2489: aload 31
    //   2491: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2494: ldc_w 723
    //   2497: aload 33
    //   2499: invokeinterface 298 3 0
    //   2504: pop
    //   2505: aload 31
    //   2507: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2510: ldc_w 735
    //   2513: aload 34
    //   2515: invokeinterface 298 3 0
    //   2520: pop
    //   2521: aload 31
    //   2523: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2526: ldc_w 691
    //   2529: iload 12
    //   2531: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2534: invokeinterface 298 3 0
    //   2539: pop
    //   2540: aload 31
    //   2542: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2545: ldc_w 737
    //   2548: iload 13
    //   2550: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2553: invokeinterface 298 3 0
    //   2558: pop
    //   2559: aload 31
    //   2561: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2564: ldc_w 739
    //   2567: iload 14
    //   2569: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2572: invokeinterface 298 3 0
    //   2577: pop
    //   2578: aload 31
    //   2580: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2583: ldc_w 741
    //   2586: iload 15
    //   2588: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2591: invokeinterface 298 3 0
    //   2596: pop
    //   2597: aload 31
    //   2599: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2602: ldc_w 743
    //   2605: iload 16
    //   2607: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2610: invokeinterface 298 3 0
    //   2615: pop
    //   2616: aload 31
    //   2618: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2621: ldc_w 745
    //   2624: lload 23
    //   2626: invokestatic 659	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2629: invokeinterface 298 3 0
    //   2634: pop
    //   2635: aload 31
    //   2637: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2640: ldc_w 747
    //   2643: lload 25
    //   2645: invokestatic 659	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2648: invokeinterface 298 3 0
    //   2653: pop
    //   2654: aload 31
    //   2656: invokevirtual 301	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2659: aload 27
    //   2661: ifnull +19 -> 2680
    //   2664: aload 31
    //   2666: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2669: ldc_w 749
    //   2672: aload 27
    //   2674: invokeinterface 298 3 0
    //   2679: pop
    //   2680: iload_3
    //   2681: ifne +156 -> 2837
    //   2684: invokestatic 426	com/tencent/smtt/sdk/an:a	()Lcom/tencent/smtt/sdk/an;
    //   2687: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2690: iload 11
    //   2692: invokevirtual 752	com/tencent/smtt/sdk/an:b	(Landroid/content/Context;I)Z
    //   2695: ifeq +142 -> 2837
    //   2698: iload_2
    //   2699: ifeq +107 -> 2806
    //   2702: aload 31
    //   2704: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2707: ldc_w 693
    //   2710: bipush 143
    //   2712: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2715: invokeinterface 298 3 0
    //   2720: pop
    //   2721: aload 31
    //   2723: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2726: ldc_w 674
    //   2729: iconst_0
    //   2730: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2733: invokeinterface 298 3 0
    //   2738: pop
    //   2739: ldc 14
    //   2741: ldc_w 754
    //   2744: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2747: aload 32
    //   2749: ldc_w 756
    //   2752: iconst_0
    //   2753: invokevirtual 544	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2756: iconst_1
    //   2757: if_icmpne +21 -> 2778
    //   2760: aload 31
    //   2762: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2765: ldc_w 758
    //   2768: iconst_1
    //   2769: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2772: invokeinterface 298 3 0
    //   2777: pop
    //   2778: aload 31
    //   2780: invokevirtual 301	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2783: iconst_1
    //   2784: ireturn
    //   2785: aload 31
    //   2787: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2790: ldc_w 731
    //   2793: iconst_0
    //   2794: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2797: invokeinterface 298 3 0
    //   2802: pop
    //   2803: goto -337 -> 2466
    //   2806: aload 31
    //   2808: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2811: ldc_w 693
    //   2814: sipush -213
    //   2817: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2820: invokeinterface 298 3 0
    //   2825: pop
    //   2826: aload 31
    //   2828: sipush -213
    //   2831: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2834: goto -113 -> 2721
    //   2837: iload_3
    //   2838: ifne +160 -> 2998
    //   2841: getstatic 700	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ag;
    //   2844: astore_0
    //   2845: iload 12
    //   2847: iconst_1
    //   2848: if_icmpeq +9 -> 2857
    //   2851: iload 12
    //   2853: iconst_2
    //   2854: if_icmpne +122 -> 2976
    //   2857: iconst_1
    //   2858: istore 18
    //   2860: aload_0
    //   2861: iload_3
    //   2862: iload 18
    //   2864: invokevirtual 761	com/tencent/smtt/sdk/ag:a	(ZZ)Z
    //   2867: ifeq +131 -> 2998
    //   2870: aload 31
    //   2872: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   2875: ldc_w 674
    //   2878: iconst_0
    //   2879: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2882: invokeinterface 298 3 0
    //   2887: pop
    //   2888: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2891: invokestatic 446	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2894: invokevirtual 450	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2897: astore_0
    //   2898: aload_0
    //   2899: bipush 100
    //   2901: invokevirtual 455	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2904: aload_0
    //   2905: new 109	java/lang/StringBuilder
    //   2908: dup
    //   2909: ldc_w 763
    //   2912: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2915: getstatic 700	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ag;
    //   2918: getfield 765	com/tencent/smtt/sdk/ag:a	Ljava/lang/String;
    //   2921: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2924: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2927: invokevirtual 458	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2930: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2933: invokestatic 261	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2936: getfield 271	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2939: ldc_w 663
    //   2942: iconst_0
    //   2943: invokeinterface 350 3 0
    //   2948: iconst_1
    //   2949: if_icmpne +33 -> 2982
    //   2952: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2955: invokestatic 446	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2958: getstatic 768	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2961: aload_0
    //   2962: invokevirtual 468	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2965: ldc 14
    //   2967: ldc_w 770
    //   2970: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2973: goto -226 -> 2747
    //   2976: iconst_0
    //   2977: istore 18
    //   2979: goto -119 -> 2860
    //   2982: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   2985: invokestatic 446	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2988: getstatic 464	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2991: aload_0
    //   2992: invokevirtual 468	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2995: goto -30 -> 2965
    //   2998: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3001: invokestatic 261	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3004: getfield 271	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   3007: ldc_w 731
    //   3010: iconst_0
    //   3011: invokeinterface 350 3 0
    //   3016: iconst_1
    //   3017: if_icmpne +134 -> 3151
    //   3020: getstatic 700	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ag;
    //   3023: invokevirtual 772	com/tencent/smtt/sdk/ag:a	()Z
    //   3026: ifeq +125 -> 3151
    //   3029: aload 31
    //   3031: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3034: ldc_w 674
    //   3037: iconst_0
    //   3038: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3041: invokeinterface 298 3 0
    //   3046: pop
    //   3047: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3050: invokestatic 446	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3053: invokevirtual 450	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   3056: astore_0
    //   3057: aload_0
    //   3058: bipush 100
    //   3060: invokevirtual 455	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   3063: aload_0
    //   3064: new 109	java/lang/StringBuilder
    //   3067: dup
    //   3068: ldc_w 774
    //   3071: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3074: getstatic 700	com/tencent/smtt/sdk/TbsDownloader:g	Lcom/tencent/smtt/sdk/ag;
    //   3077: getfield 765	com/tencent/smtt/sdk/ag:a	Ljava/lang/String;
    //   3080: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3083: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3086: invokevirtual 458	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   3089: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3092: invokestatic 261	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3095: getfield 271	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   3098: ldc_w 663
    //   3101: iconst_0
    //   3102: invokeinterface 350 3 0
    //   3107: iconst_1
    //   3108: if_icmpne +27 -> 3135
    //   3111: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3114: invokestatic 446	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3117: getstatic 768	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3120: aload_0
    //   3121: invokevirtual 468	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3124: ldc 14
    //   3126: ldc_w 776
    //   3129: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3132: goto -385 -> 2747
    //   3135: getstatic 58	com/tencent/smtt/sdk/TbsDownloader:c	Landroid/content/Context;
    //   3138: invokestatic 446	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3141: getstatic 464	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3144: aload_0
    //   3145: invokevirtual 468	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3148: goto -24 -> 3124
    //   3151: iload_2
    //   3152: ifne +11 -> 3163
    //   3155: aload 31
    //   3157: sipush -216
    //   3160: invokevirtual 267	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3163: aload 31
    //   3165: getfield 286	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   3168: ldc_w 674
    //   3171: iconst_1
    //   3172: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3175: invokeinterface 298 3 0
    //   3180: pop
    //   3181: ldc 14
    //   3183: ldc_w 778
    //   3186: invokestatic 129	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3189: goto -442 -> 2747
    //   3192: astore_0
    //   3193: goto -1680 -> 1513
    //   3196: astore_0
    //   3197: goto -1708 -> 1489
    //   3200: astore 28
    //   3202: goto -2165 -> 1037
    //   3205: astore_0
    //   3206: goto -2924 -> 282
    //   3209: ldc2_w 779
    //   3212: lstore 21
    //   3214: goto -1781 -> 1433
    //   3217: goto -1791 -> 1426
    //   3220: iconst_1
    //   3221: istore 19
    //   3223: goto -2225 -> 998
    //   3226: goto -2448 -> 778
    //   3229: goto -2306 -> 923
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3232	0	paramString	String
    //   0	3232	1	paramInt	int
    //   0	3232	2	paramBoolean1	boolean
    //   0	3232	3	paramBoolean2	boolean
    //   87	2240	4	m	int
    //   276	2203	5	n	int
    //   618	1379	6	i1	int
    //   614	1543	7	i2	int
    //   583	1440	8	i3	int
    //   586	448	9	i4	int
    //   589	402	10	i5	int
    //   181	2510	11	i6	int
    //   149	2706	12	i7	int
    //   191	2358	13	i8	int
    //   201	2367	14	i9	int
    //   211	2376	15	i10	int
    //   221	2385	16	i11	int
    //   263	1147	17	i12	int
    //   347	2631	18	bool1	boolean
    //   610	2612	19	bool2	boolean
    //   595	714	20	bool3	boolean
    //   252	2961	21	l1	long
    //   231	2394	23	l2	long
    //   241	2403	25	l3	long
    //   338	2335	27	localObject1	Object
    //   606	689	28	localObject2	Object
    //   1315	10	28	localException1	Exception
    //   3200	1	28	localException2	Exception
    //   602	215	29	str1	String
    //   632	367	30	str2	String
    //   28	3136	31	localTbsDownloadConfig	TbsDownloadConfig
    //   77	2671	32	localJSONObject	JSONObject
    //   159	2339	33	str3	String
    //   171	2343	34	str4	String
    // Exception table:
    //   from	to	target	type
    //   320	340	1191	java/lang/Throwable
    //   349	361	1191	java/lang/Throwable
    //   365	376	1245	java/lang/Throwable
    //   386	424	1245	java/lang/Throwable
    //   434	472	1245	java/lang/Throwable
    //   482	525	1245	java/lang/Throwable
    //   536	579	1245	java/lang/Throwable
    //   624	634	1293	java/lang/Exception
    //   658	668	1293	java/lang/Exception
    //   692	702	1293	java/lang/Exception
    //   726	737	1293	java/lang/Exception
    //   761	772	1293	java/lang/Exception
    //   805	816	1293	java/lang/Exception
    //   840	849	1293	java/lang/Exception
    //   872	883	1293	java/lang/Exception
    //   906	917	1293	java/lang/Exception
    //   946	957	1293	java/lang/Exception
    //   980	990	1293	java/lang/Exception
    //   1010	1020	1315	java/lang/Exception
    //   1050	1066	1323	finally
    //   1066	1124	1323	finally
    //   1124	1127	1323	finally
    //   1324	1327	1323	finally
    //   1762	1774	1777	java/lang/Throwable
    //   1489	1509	3192	java/lang/Exception
    //   1475	1485	3196	java/lang/Exception
    //   1730	1750	3196	java/lang/Exception
    //   1023	1033	3200	java/lang/Exception
    //   268	278	3205	java/lang/Exception
  }
  
  protected static File b(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject = null;
    int n = arrayOfString.length;
    int m = 0;
    for (;;)
    {
      String str1;
      String str2;
      if (m < n)
      {
        str1 = arrayOfString[m];
        str2 = j.a(c, str1, 4, false);
        if (!getOverSea(c)) {
          break label103;
        }
      }
      label103:
      for (localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
      {
        localObject = new File(str2, (String)localObject);
        if ((!((File)localObject).exists()) || (a.a(c, (File)localObject) != paramInt)) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return localObject;
      }
      localObject = new File(j.a(c, str1, 4, false), "x5.tbs.decouple");
      if ((((File)localObject).exists()) && (a.a(c, (File)localObject) == paramInt))
      {
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return localObject;
      }
      m += 1;
    }
  }
  
  private static JSONObject b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = 0;
    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    String str1 = a(c);
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
          break label712;
        }
        localObject3 = ((TelephonyManager)localObject3).getSimCountryIso();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        Object localObject3;
        label125:
        break label125;
        label130:
        m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
      }
      if (localObject1 != null) {
        localObject3 = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!TbsShareManager.isThirdPartyApp(c)) {
        break label737;
      }
      if (!QbSdk.c) {
        break label715;
      }
      m = TbsShareManager.a(c, false);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label197:
        label211:
        label634:
        continue;
        label276:
        label560:
        label712:
        label715:
        label737:
        int n = 1;
        continue;
        n = 0;
        continue;
        n = 0;
        continue;
        int m = 1;
      }
    }
    if (paramBoolean1)
    {
      ((JSONObject)localObject3).put("FUNCTION", 2);
      if (TbsShareManager.isThirdPartyApp(c))
      {
        localObject1 = e();
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
        ((JSONObject)localObject3).put("TBSSDKV", 43617);
        ((JSONObject)localObject3).put("TBSV", m);
        if (!paramBoolean3) {
          break label963;
        }
        n = 1;
        ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", n);
        localObject1 = localTbsDownloadConfig.a;
        if (!paramBoolean3) {
          break label969;
        }
        n = 1;
        ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(n));
        localTbsDownloadConfig.commit();
        if (m != 0) {
          ((JSONObject)localObject3).put("TBSBACKUPV", g.b());
        }
        ((JSONObject)localObject3).put("CPU", e);
        ((JSONObject)localObject3).put("UA", str1);
        ((JSONObject)localObject3).put("IMSI", a(str2));
        ((JSONObject)localObject3).put("IMEI", a(str3));
        ((JSONObject)localObject3).put("ANDROID_ID", a(str4));
        if (!TbsShareManager.isThirdPartyApp(c))
        {
          if (m == 0) {
            break label885;
          }
          if (!QbSdk.a(c, m)) {
            break label975;
          }
          m = 0;
          ((JSONObject)localObject3).put("STATUS", m);
          ((JSONObject)localObject3).put("TBSDV", an.a().i(c));
        }
        paramBoolean3 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
        localObject1 = QbSdk.a(c, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label898;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label923;
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
        return localObject3;
        n = an.a().n(c);
        m = n;
        if (n == 0)
        {
          m = n;
          if (an.a().m(c)) {
            m = -1;
          }
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + m + " isDownloadForeground=" + paramBoolean2);
        if (!paramBoolean2) {
          break label903;
        }
        if (an.a().m(c)) {
          break label920;
        }
        m = 0;
        break label920;
      }
    }
    for (;;)
    {
      localException2.put("FUNCTION", n);
      break label211;
      localObject1 = g();
      if ((Apn.getApnType(c) == 3) || (((JSONArray)localObject1).length() == 0) || (m != 0) || (!paramBoolean1)) {
        break label276;
      }
      localException2.put("TBSBACKUPARR", localObject1);
      break label276;
      label885:
      localException2.put("STATUS", 0);
      break label560;
      label898:
      paramBoolean1 = false;
      break label923;
      label903:
      break label197;
      localObject1 = "";
      break label130;
      localObject2 = "";
      break;
      label920:
      break label197;
      label923:
      m = i1;
      if (!paramBoolean1) {
        break label634;
      }
      m = i1;
      if (paramBoolean3) {
        break label634;
      }
      m = 1;
      break label634;
      if (m != 0) {
        break label957;
      }
      n = 0;
    }
  }
  
  @TargetApi(11)
  static void b(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    ag.c(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      localSharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT < 11) {
        break label99;
      }
    }
    label99:
    for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      paramContext.edit().clear().commit();
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return c(paramBoolean1, paramBoolean2, false);
  }
  
  private static void c()
  {
    try
    {
      if (h == null) {
        h = al.a();
      }
      try
      {
        g = new ag(c);
        d = new aj(h.getLooper());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
        }
      }
      return;
    }
    finally {}
  }
  
  private static boolean c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(144));
      ((TbsDownloadUpload)localObject1).commit();
      if ((QbSdk.n == null) || (!QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) || (!QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false"))) {
        break label204;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      if (!paramBoolean1) {
        break label164;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(145));
      ((TbsDownloadUpload)localObject1).commit();
    }
    for (;;)
    {
      return false;
      if (paramBoolean3) {
        break;
      }
      localObject1 = TbsDownloadUpload.getInstance(c);
      ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(164));
      ((TbsDownloadUpload)localObject1).commit();
      break;
      label164:
      if (!paramBoolean3)
      {
        localObject1 = TbsDownloadUpload.getInstance(c);
        ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(165));
        ((TbsDownloadUpload)localObject1).commit();
      }
    }
    label204:
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    if (an.a().c(c))
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
    Object localObject2 = j.a(c, 1);
    if (getOverSea(c)) {
      localObject1 = "x5.oversea.tbs.org";
    }
    for (;;)
    {
      localObject2 = new File((String)localObject2, (String)localObject1);
      Object localObject3 = j.a(c, 2);
      label400:
      label435:
      label470:
      label507:
      int n;
      if (getOverSea(c))
      {
        localObject1 = "x5.oversea.tbs.org";
        localObject3 = new File((String)localObject3, (String)localObject1);
        Object localObject4 = j.a(c, 3);
        if (!getOverSea(c)) {
          break label1004;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject4 = new File((String)localObject4, (String)localObject1);
        String str2 = j.a(c, 4);
        if (!getOverSea(c)) {
          break label1011;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(str2, (String)localObject1);
        if (!((File)localObject1).exists())
        {
          if (!((File)localObject4).exists()) {
            break label1018;
          }
          ((File)localObject4).renameTo((File)localObject1);
        }
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
        label577:
        break label577;
      }
      int m = n;
      if (localObject1 != null)
      {
        m = n;
        if (((Matcher)localObject1).find())
        {
          if (!TbsShareManager.isThirdPartyApp(c)) {
            break label1075;
          }
          localObject1 = TbsLogReport.getInstance(c).tbsLogInfo();
          if (!paramBoolean1) {
            break label1056;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
          label634:
          ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail("mycpu is " + e);
          TbsLogReport.getInstance(c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
          label672:
          m = 1;
        }
      }
      localTbsDownloadConfig.a.put("app_versionname", b.a(c));
      localTbsDownloadConfig.a.put("app_versioncode", Integer.valueOf(b.b(c)));
      localTbsDownloadConfig.commit();
      localObject1 = b(paramBoolean1, paramBoolean2, paramBoolean3);
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
            localTbsDownloadConfig.a.put("last_check", Long.valueOf(l2));
            localTbsDownloadConfig.a.put("request_fail", Long.valueOf(l2));
            localTbsDownloadConfig.a.put("app_versionname", b.a(c));
            localTbsDownloadConfig.a.put("app_versioncode", Integer.valueOf(b.b(c)));
            localTbsDownloadConfig.a.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            localTbsDownloadConfig.commit();
            if (m == 0) {
              break label1154;
            }
            if (!paramBoolean1) {
              break label1114;
            }
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_needdownload_code", Integer.valueOf(147));
            ((TbsDownloadUpload)localObject1).commit();
            return false;
            localObject1 = "x5.tbs.org";
            continue;
            localObject1 = "x5.tbs.org";
            break label400;
            label1004:
            localObject1 = "x5.tbs.org";
            break label435;
            label1011:
            localObject1 = "x5.tbs.org";
            break label470;
            label1018:
            if (((File)localObject3).exists())
            {
              ((File)localObject3).renameTo((File)localObject1);
              break label507;
            }
            if (!((File)localObject2).exists()) {
              break label507;
            }
            ((File)localObject2).renameTo((File)localObject1);
            break label507;
            label1056:
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
            ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
            break label634;
            label1075:
            if (paramBoolean1)
            {
              localTbsDownloadConfig.setDownloadInterruptCode(-104);
              break label672;
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
          label1114:
          if (!paramBoolean3)
          {
            localObject1 = TbsDownloadUpload.getInstance(c);
            ((TbsDownloadUpload)localObject1).a.put("tbs_startdownload_code", Integer.valueOf(167));
            ((TbsDownloadUpload)localObject1).commit();
          }
        }
        label1154:
        TbsDownloadUpload localTbsDownloadUpload;
        if (n != -1)
        {
          try
          {
            String str1 = s.a(c).d();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + str1);
            if (paramBoolean1)
            {
              localObject3 = TbsDownloadUpload.getInstance(c);
              ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_code", Integer.valueOf(148));
              ((TbsDownloadUpload)localObject3).a.put("tbs_needdownload_sent", Integer.valueOf(1));
              ((TbsDownloadUpload)localObject3).commit();
              TbsLog.i("TbsDownload", "sendRequest query 148");
            }
            for (;;)
            {
              return a(m.a(str1, ((JSONObject)localObject1).toString().getBytes("utf-8"), new ak(localTbsDownloadConfig, paramBoolean1), false), n, paramBoolean1, paramBoolean2);
              if (!paramBoolean3)
              {
                localObject3 = TbsDownloadUpload.getInstance(c);
                ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_code", Integer.valueOf(168));
                ((TbsDownloadUpload)localObject3).a.put("tbs_startdownload_sent", Integer.valueOf(1));
                ((TbsDownloadUpload)localObject3).commit();
                TbsLog.i("TbsDownload", "sendRequest download 168");
              }
            }
            if (!paramBoolean1) {
              break label1422;
            }
          }
          catch (Throwable localThrowable)
          {
            if (paramBoolean1)
            {
              localTbsDownloadConfig.setDownloadInterruptCode(-106);
              return false;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-206);
            return false;
          }
        }
        else
        {
          localTbsDownloadUpload = TbsDownloadUpload.getInstance(c);
          localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(149));
          localTbsDownloadUpload.commit();
          return false;
        }
        label1422:
        if (!paramBoolean3)
        {
          localTbsDownloadUpload = TbsDownloadUpload.getInstance(c);
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(169));
          localTbsDownloadUpload.commit();
        }
        return false;
      }
    }
  }
  
  private static boolean d()
  {
    try
    {
      JSONArray localJSONArray = e();
      boolean bool = TbsDownloadConfig.getInstance(c).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static JSONArray e()
  {
    int i1 = 0;
    JSONArray localJSONArray;
    Object localObject1;
    if (TbsShareManager.isThirdPartyApp(c))
    {
      localJSONArray = new JSONArray();
      if (QbSdk.getOnlyDownload())
      {
        localObject1 = new String[1];
        localObject1[0] = c.getApplicationContext().getPackageName();
      }
    }
    label51:
    label198:
    label200:
    label459:
    label592:
    label594:
    for (;;)
    {
      int i2 = localObject1.length;
      int m = 0;
      Object localObject2;
      int i3;
      Object localObject3;
      if (m < i2)
      {
        localObject2 = localObject1[m];
        i3 = TbsShareManager.getSharedTbsCoreVersion(c, (String)localObject2);
        if (i3 > 0)
        {
          localObject3 = TbsShareManager.getPackageContext(c, (String)localObject2);
          if ((localObject3 == null) || (an.a().f((Context)localObject3))) {
            break label198;
          }
          TbsLog.e("TbsDownload", "host check failed,packageName = " + (String)localObject2);
        }
      }
      for (;;)
      {
        m += 1;
        break label51;
        localObject1 = TbsShareManager.getCoreProviderAppList();
        localObject3 = c.getApplicationContext().getPackageName();
        if (!((String)localObject3).equals(TbsShareManager.f(c))) {
          break label594;
        }
        m = localObject1.length;
        localObject2 = new String[m + 1];
        System.arraycopy(localObject1, 0, localObject2, 0, m);
        localObject2[m] = localObject3;
        localObject1 = localObject2;
        break;
        int n = 0;
        if (n < localJSONArray.length()) {
          if (localJSONArray.optInt(n) != i3) {}
        }
        for (n = 1;; n = 0)
        {
          if (n != 0) {
            break label592;
          }
          localJSONArray.put(i3);
          break;
          n += 1;
          break label200;
          boolean bool = TbsExtensionFunctionManager.getInstance().canUseFunction(c, "disable_use_host_backup_core.txt");
          QbSdk.mDisableUseHostBackupCore = bool;
          if (!bool)
          {
            i2 = localObject1.length;
            m = 0;
            for (;;)
            {
              if (m < i2)
              {
                localObject2 = localObject1[m];
                i3 = TbsShareManager.getBackupCoreVersion(c, (String)localObject2);
                if (i3 > 0)
                {
                  localObject3 = TbsShareManager.getPackageContext(c, (String)localObject2);
                  if ((localObject3 != null) && (!an.a().f((Context)localObject3)))
                  {
                    TbsLog.e("TbsDownload", "host check failed,packageName = " + (String)localObject2);
                    m += 1;
                    continue;
                  }
                  n = 0;
                  label358:
                  if (n >= localJSONArray.length()) {
                    break label584;
                  }
                  if (localJSONArray.optInt(n) != i3) {
                    break label459;
                  }
                }
              }
            }
          }
          for (n = 1;; n = 0)
          {
            if (n == 0) {
              localJSONArray.put(i3);
            }
            i3 = TbsShareManager.getBackupDecoupleCoreVersion(c, (String)localObject2);
            if (i3 <= 0) {
              break;
            }
            localObject3 = TbsShareManager.getPackageContext(c, (String)localObject2);
            if ((localObject3 != null) && (!an.a().f((Context)localObject3)))
            {
              TbsLog.e("TbsDownload", "host check failed,packageName = " + (String)localObject2);
              break;
              n += 1;
              break label358;
            }
            n = 0;
            label468:
            if (n < localJSONArray.length()) {
              if (localJSONArray.optInt(n) != i3) {}
            }
            for (n = 1;; n = 0)
            {
              if (n != 0) {
                break label582;
              }
              localJSONArray.put(i3);
              break;
              n += 1;
              break label468;
              if (TbsShareManager.getHostCorePathAppDefined() != null)
              {
                i2 = an.a().a(TbsShareManager.getHostCorePathAppDefined());
                m = 0;
                for (;;)
                {
                  n = i1;
                  if (m < localJSONArray.length())
                  {
                    if (localJSONArray.optInt(m) == i2) {
                      n = 1;
                    }
                  }
                  else
                  {
                    if (n == 0) {
                      localJSONArray.put(i2);
                    }
                    return localJSONArray;
                  }
                  m += 1;
                }
              }
              return localJSONArray;
              return null;
            }
            break;
          }
        }
      }
    }
  }
  
  private static boolean f()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-115);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-116);
      return false;
    }
    if (!j.b(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-117);
      return false;
    }
    if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l1 = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + l1);
      if (l1 >= localTbsDownloadConfig.getDownloadMaxflow())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        localTbsDownloadConfig.setDownloadInterruptCode(-120);
        return false;
      }
    }
    return true;
  }
  
  private static JSONArray g()
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = arrayOfString.length;
    int m = 0;
    Object localObject;
    label56:
    long l1;
    if (m < i1)
    {
      localObject = arrayOfString[m];
      String str = j.a(c, (String)localObject, 4, false);
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
            label95:
            if (n >= localJSONArray.length()) {
              break label153;
            }
            if (localJSONArray.optInt(n) != l1) {
              break label143;
            }
          }
        }
      }
    }
    label143:
    label153:
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        localJSONArray.put(l1);
      }
      m += 1;
      break;
      localObject = "x5.tbs.org";
      break label56;
      n += 1;
      break label95;
      return localJSONArray;
    }
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    return an.a().i(c);
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    return an.a().i(paramContext);
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
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
    return (g != null) && (g.e());
  }
  
  public static boolean isDownloading()
  {
    try
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + a);
      boolean bool = a;
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
    return needDownload(paramContext, paramBoolean, false, null);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    TbsDownloadUpload.clear();
    TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
    localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(140));
    localTbsDownloadUpload.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] oversea=" + paramBoolean1 + ",isDownloadForeground=" + paramBoolean2);
    TbsLog.initIfNeed(paramContext);
    if (an.b)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#1,return false");
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(171));
      localTbsDownloadUpload.commit();
      return false;
    }
    TbsLog.app_extra("TbsDownload", paramContext);
    Object localObject = paramContext.getApplicationContext();
    c = (Context)localObject;
    localObject = TbsDownloadConfig.getInstance((Context)localObject);
    ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-100);
    if (!a(c, paramBoolean1, paramTbsDownloaderCallback))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#2,return false");
      localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(141));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.a.put("tbs_needdownload_return", Integer.valueOf(172));
      localTbsDownloadUpload.commit();
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
      return false;
    }
    boolean bool = a(c, paramBoolean2, false);
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],needSendRequest=" + bool);
    if (bool)
    {
      a(paramBoolean2, paramTbsDownloaderCallback);
      ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-114);
      d.removeMessages(102);
      Message.obtain(d, 102).sendToTarget();
      if ((!QbSdk.c) && (TbsShareManager.isThirdPartyApp(paramContext))) {
        break label772;
      }
      paramBoolean2 = ((TbsDownloadConfig)localObject).mPreferences.contains("tbs_needdownload");
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + paramBoolean2);
      if ((paramBoolean2) || (TbsShareManager.isThirdPartyApp(paramContext))) {
        break label600;
      }
      paramBoolean1 = true;
    }
    for (;;)
    {
      label444:
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (paramBoolean1) {
        if (!f())
        {
          TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
          paramBoolean1 = false;
          label496:
          if ((!bool) && (paramTbsDownloaderCallback != null)) {
            paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + paramBoolean1);
          paramContext = localTbsDownloadUpload.a;
          if (!paramBoolean1) {
            break label764;
          }
        }
      }
      label600:
      label764:
      for (int m = 170;; m = 174)
      {
        paramContext.put("tbs_needdownload_return", Integer.valueOf(m));
        localTbsDownloadUpload.commit();
        return paramBoolean1;
        localTbsDownloadUpload.a.put("tbs_needdownload_code", Integer.valueOf(143));
        localTbsDownloadUpload.commit();
        break;
        paramBoolean1 = ((TbsDownloadConfig)localObject).mPreferences.getBoolean("tbs_needdownload", false);
        break label444;
        ((TbsDownloadConfig)localObject).setDownloadInterruptCode(-118);
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
        break label496;
        m = an.a().n(c);
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + m + ",needSendRequest=" + bool);
        if ((bool) || (m <= 0))
        {
          d.removeMessages(103);
          if ((m <= 0) && (!bool)) {
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
        break label496;
      }
      label772:
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
  }
  
  public static boolean needDownloadDecoupleCore()
  {
    if (TbsShareManager.isThirdPartyApp(c)) {}
    int m;
    do
    {
      long l1;
      do
      {
        do
        {
          return false;
        } while (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1);
        l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
      } while (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval());
      m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    } while ((m <= 0) || (m == an.a().i(c)) || (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) == m));
    return true;
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean, null)) {}
    int m;
    do
    {
      return false;
      m = an.a().n(paramContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + m);
    } while (m > 0);
    if (a(c, false, true)) {
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(c);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + paramBoolean);
    if (!paramBoolean)
    {
      paramBoolean = true;
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + paramBoolean);
      if ((!paramBoolean) || (!f())) {
        break label196;
      }
    }
    label196:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + paramBoolean);
      return paramBoolean;
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
      break;
    }
  }
  
  public static void setAppContext(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationContext() != null)) {
      c = paramContext.getApplicationContext();
    }
  }
  
  public static void setRetryIntervalInSeconds(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    if (paramContext.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
      l = paramLong;
    }
    TbsLog.i("TbsDownload", "mRetryIntervalInSeconds is " + l);
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(c)) {}
    long l1;
    do
    {
      do
      {
        return false;
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
      } while ((TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) || (d == null));
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
      l1 = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0L);
    } while (System.currentTimeMillis() - l1 < 1000L * TbsDownloadConfig.getInstance(c).getRetryInterval());
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((m > 0) && (m != an.a().i(c)))
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
        return true;
      }
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + m + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + m + " getTbsCoreShareDecoupleCoreVersion is " + an.a().i(c));
    return false;
  }
  
  public static void startDownload(Context paramContext)
  {
    startDownload(paramContext, false);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    int m = 1;
    for (;;)
    {
      TbsDownloadUpload localTbsDownloadUpload;
      try
      {
        localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
        localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(160));
        localTbsDownloadUpload.commit();
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + c);
        if (an.b)
        {
          localTbsDownloadUpload.a.put("tbs_startdownload_code", Integer.valueOf(161));
          localTbsDownloadUpload.commit();
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
      break;
      m = 0;
    }
  }
  
  public static void stopDownload()
  {
    if (i) {}
    do
    {
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
      if (g != null) {
        g.c();
      }
    } while (d == null);
    d.removeMessages(100);
    d.removeMessages(101);
    d.removeMessages(108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */