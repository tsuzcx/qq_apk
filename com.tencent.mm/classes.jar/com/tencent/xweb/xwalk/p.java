package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.a;
import com.tencent.xweb.ah;
import com.tencent.xweb.internal.b;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.g;
import com.tencent.xweb.w.b;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.f;
import com.tencent.xweb.y;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.FileListMD5Checker;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public class p
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  static p MUA;
  XWalkInitializer MUB;
  XWalkUpdater MUC;
  protected Context mContext;
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(154475);
    this.mContext = paramContext;
    this.MUB = new XWalkInitializer(this, paramContext);
    this.MUC = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154475);
  }
  
  public static void Ad(boolean paramBoolean)
  {
    AppMethodBeat.i(154471);
    int i = XWalkEnvironment.getAvailableVersion();
    if (i <= 0)
    {
      AppMethodBeat.o(154471);
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(154471);
      return;
    }
    if ((paramBoolean) || (com.tencent.xweb.internal.c.cq("CHECK_FILES_MD5_TIME_KEY", 7200000L)))
    {
      Log.i("XWalkUpdaterImp", "checkFiles start check resfiles");
      String str = XWalkEnvironment.getExtractedCoreDir(i);
      boolean bool = XWalkUpdater.checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(i), str, i);
      int j;
      if (!bool)
      {
        j = localSharedPreferences.getInt("LAST_CHECK_RES_VERSION", -1);
        localSharedPreferences.edit().putInt("LAST_CHECK_RES_VERSION", -1).commit();
        if (j == i) {
          break label250;
        }
        g.FJ(77L);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted at first time");
        g.FJ(76L);
      }
      Log.i("XWalkUpdaterImp", "checkFiles start check installed files");
      paramBoolean = ajp(i);
      if (!paramBoolean)
      {
        j = localSharedPreferences.getInt("LAST_CHECK_VERSION", -1);
        localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", -1).commit();
        if (j == i) {
          break label260;
        }
        g.FJ(64L);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted at first time");
        label200:
        g.FJ(63L);
      }
      if ("true".equalsIgnoreCase(a.nb("disable_res_check", "tools"))) {
        break label270;
      }
      paramBoolean &= bool;
    }
    for (;;)
    {
      if (paramBoolean) {
        break label280;
      }
      XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
      AppMethodBeat.o(154471);
      return;
      AppMethodBeat.o(154471);
      return;
      label250:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted");
      break;
      label260:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted");
      break label200;
      label270:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "ignore res files check");
    }
    label280:
    localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", i).commit();
    Log.i("XWalkUpdaterImp", "checkfiles parse");
    AppMethodBeat.o(154471);
  }
  
  public static void K(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(154460);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(154460);
      return;
    }
    long l1 = localSharedPreferences.getLong("LAST_TRY_CLEAR_APK_TIME", 0L);
    long l2 = System.currentTimeMillis();
    if ((paramBoolean) || (l2 < l1) || (l2 - l1 > 259200000L)) {}
    try
    {
      lH(paramContext);
      localSharedPreferences.edit().putLong("LAST_TRY_CLEAR_APK_TIME", l2).commit();
      AppMethodBeat.o(154460);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("XWalkUpdaterImp", "tryClearOldXWebCore failed " + paramContext.getMessage());
      }
    }
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154459);
    if (MUA == null) {
      MUA = new p(paramContext);
    }
    g.ggD();
    if (paramHashMap != null) {}
    for (String str = (String)paramHashMap.get("UpdaterCheckType");; str = null)
    {
      if ("4".equals(str))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "check emebedinstall only");
        XWalkUpdater.tryInstallFromEmebed();
        AppMethodBeat.o(154459);
        return;
      }
      XWalkUpdater.tryInstallFromEmebed();
      if (!XWalkEnvironment.isTestVersion(XWalkEnvironment.getInstalledNewstVersionForCurAbi())) {
        Ad(false);
      }
      int i;
      if (b.c("LOAD_CORE", WebView.c.MNy).MQy >= 6L)
      {
        i = 1;
        if (i == 0) {
          break label226;
        }
        g.FJ(252L);
        if (!"true".equalsIgnoreCase(a.nb("enable_check_dex", "tools"))) {
          break label226;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (com.tencent.xweb.internal.c.cq("check_need_fix_dex", 43200000L)))
        {
          ghB();
          if (!ghD())
          {
            g.FJ(248L);
            ajn(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
            XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
          }
        }
        K(paramContext, false);
        lI(paramContext);
        if (com.tencent.xweb.internal.c.cq("should_try_generate_jar", 172800000L)) {
          XWalkUpdater.try_generate_jar_for_dex_in_dir(XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), false);
        }
        MUA.q(paramHashMap);
        AppMethodBeat.o(154459);
        return;
        i = 0;
        break;
        label226:
        if (b.c("CREATE_WEBVIEW", WebView.c.MNy).MQy >= 6L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label283;
          }
          g.FJ(247L);
          if (!"true".equalsIgnoreCase(a.nb("enable_check_dex_new_web", "tools"))) {
            break label283;
          }
          i = 1;
          break;
        }
        label283:
        i = 0;
      }
    }
  }
  
  public static int aW(Context paramContext, int paramInt)
  {
    int n = 1;
    AppMethodBeat.i(154464);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed: bad context");
      AppMethodBeat.o(154464);
      return -1;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    if (paramContext == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed files is null");
      AppMethodBeat.o(154464);
      return -1;
    }
    int i2 = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int i3 = paramContext.length;
    int m = 0;
    int i = -1;
    int j = 0;
    int k;
    if (m < i3)
    {
      int i1 = ai(paramContext[m]);
      k = j;
      if (i1 < 0) {
        break label387;
      }
      if (i1 == paramInt) {
        j = 1;
      }
      k = j;
      if (i1 > paramInt) {
        break label387;
      }
      k = j;
      if (i1 < 49) {
        break label387;
      }
      k = j;
      if (i1 == i2) {
        break label387;
      }
      k = j;
      if (i1 <= i) {
        break label387;
      }
      i = i1;
    }
    for (;;)
    {
      m += 1;
      break;
      if (i > 0) {}
      for (k = n;; k = 0)
      {
        if (j != 0) {
          if (ajo(paramInt))
          {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
            i = paramInt;
          }
        }
        label378:
        for (;;)
        {
          if (i == paramInt) {
            g.FJ(89L);
          }
          for (;;)
          {
            XWalkEnvironment.addXWalkInitializeLog("revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i);
            XWalkEnvironment.setAvailableVersion(i, "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i, XWalkEnvironment.getRuntimeAbi());
            AppMethodBeat.o(154464);
            return i;
            if (ajo(i)) {
              break label378;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer did not find target version:".concat(String.valueOf(paramInt)));
            if (ajo(i)) {
              break label378;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            if (i > 0) {
              g.FJ(90L);
            } else if (k != 0) {
              g.FJ(92L);
            } else {
              g.FJ(91L);
            }
          }
        }
      }
      label387:
      j = k;
    }
  }
  
  private static int ai(File paramFile)
  {
    AppMethodBeat.i(154466);
    if (paramFile == null)
    {
      AppMethodBeat.o(154466);
      return -1;
    }
    String str = paramFile.getName();
    if ((str != null) && (str.startsWith("app_xwalk_")) && (paramFile.isDirectory()))
    {
      paramFile = str.substring(10);
      try
      {
        int i = Integer.parseInt(paramFile);
        AppMethodBeat.o(154466);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("XWalkUpdaterImp", "get apk version strApkVer  is ".concat(String.valueOf(paramFile)));
      }
    }
    AppMethodBeat.o(154466);
    return -1;
  }
  
  private static boolean ajn(int paramInt)
  {
    AppMethodBeat.i(154462);
    Log.i("XWalkUpdaterImp", "clearVersion start , nVersion = ".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      Log.e("XWalkUpdaterImp", "clearVersion failed , nVersion is not valid ");
      AppMethodBeat.o(154462);
      return false;
    }
    Object localObject = XWalkEnvironment.getApplicationContext();
    if ((localObject == null) || (((Context)localObject).getApplicationInfo() == null) || (((Context)localObject).getApplicationInfo().dataDir == null))
    {
      Log.e("XWalkUpdaterImp", "clearVersion failed , context = null");
      AppMethodBeat.o(154462);
      return false;
    }
    localObject = new File(((Context)localObject).getApplicationInfo().dataDir).listFiles();
    if (localObject == null)
    {
      Log.e("XWalkUpdaterImp", "clearVersion failed , null == files ");
      AppMethodBeat.o(154462);
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      File localFile = localObject[i];
      int k = ai(localFile);
      if ((k > 0) && (k == paramInt) && (com.tencent.xweb.util.c.bcQ(localFile.getAbsolutePath())))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(k)));
        AppMethodBeat.o(154462);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(154462);
    return false;
  }
  
  private static boolean ajo(int paramInt)
  {
    AppMethodBeat.i(154465);
    File localFile = ajq(paramInt);
    if (localFile == null)
    {
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      AppMethodBeat.o(154465);
      return false;
    }
    boolean bool = XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramInt, localFile);
    AppMethodBeat.o(154465);
    return bool;
  }
  
  private static boolean ajp(int paramInt)
  {
    AppMethodBeat.i(154472);
    File localFile = ajq(paramInt);
    if (localFile == null)
    {
      if (XWalkEnvironment.isTestVersion(paramInt))
      {
        AppMethodBeat.o(154472);
        return true;
      }
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      g.FJ(78L);
      if ("true".equalsIgnoreCase(a.nb("dis_config_file_check", "tools")))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "dis_config_file_check ");
        AppMethodBeat.o(154472);
        return true;
      }
      AppMethodBeat.o(154472);
      return false;
    }
    boolean bool = XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramInt, localFile);
    AppMethodBeat.o(154472);
    return bool;
  }
  
  private static File ajq(int paramInt)
  {
    AppMethodBeat.i(154473);
    try
    {
      File localFile = new File(XWalkEnvironment.getPatchFileListConfig(paramInt));
      boolean bool = localFile.exists();
      if (bool)
      {
        AppMethodBeat.o(154473);
        return localFile;
      }
      localFile = new File(XWalkEnvironment.getDownloadZipFileListConfig(paramInt));
      bool = localFile.exists();
      if (bool)
      {
        AppMethodBeat.o(154473);
        return localFile;
      }
      AppMethodBeat.o(154473);
      return null;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(154473);
    }
    return null;
  }
  
  private static void bf(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154467);
    Log.i("XWalkUpdaterImp", "tryAbandonThisVersion scene  is ".concat(String.valueOf(paramString)));
    long l1 = b.c(paramString, WebView.c.MNy).MQy;
    if (!"true".equalsIgnoreCase(a.nb("enable_reinstall_for_crash_at_".concat(String.valueOf(paramString)), "tools")))
    {
      AppMethodBeat.o(154467);
      return;
    }
    if (l1 >= 15L)
    {
      paramString = "LAST_" + paramString + "_ABANDON_COUNT";
      long l2 = XWalkEnvironment.getSharedPreferencesForXWEBUpdater().getLong(paramString, 100000L);
      Log.i("XWalkUpdaterImp", "tryAbandonThisVersion try count = " + l1 + ",  last abandon count = " + l2);
      if (l1 < l2)
      {
        Log.i("XWalkUpdaterImp", "tryAbandonThisVersion should abandon this version ");
        try
        {
          ajn(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
          XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
          XWalkEnvironment.getSharedPreferencesForXWEBUpdater().edit().putLong(paramString, l1).commit();
          g.FJ(paramInt1);
          AppMethodBeat.o(154467);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("XWalkUpdaterImp", "clear version failed , errmsg:" + paramString.getMessage());
          AppMethodBeat.o(154467);
          return;
        }
      }
      if (l1 - 2L > l2)
      {
        Log.i("XWalkUpdaterImp", "tryAbandonThisVersion cant not fix ");
        g.FJ(paramInt2);
      }
    }
    AppMethodBeat.o(154467);
  }
  
  static void ghB()
  {
    AppMethodBeat.i(154468);
    bf("LOAD_CORE", 243, 244);
    bf("CREATE_WEBVIEW", 245, 246);
    AppMethodBeat.o(154468);
  }
  
  private static boolean ghC()
  {
    AppMethodBeat.i(154469);
    XWalkUpdater.try_generate_jar_for_dex_in_dir(XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), true);
    if (com.tencent.xweb.util.c.bcQ(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi())))
    {
      XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
      AppMethodBeat.o(154469);
      return true;
    }
    XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
    AppMethodBeat.o(154469);
    return false;
  }
  
  public static boolean ghD()
  {
    AppMethodBeat.i(154470);
    int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    if (i <= 0)
    {
      Log.i("XWalkUpdaterImp", "doFixDex stopped , because no xweb currently");
      AppMethodBeat.o(154470);
      return false;
    }
    Log.i("XWalkUpdaterImp", "doFixDex start");
    Object localObject1 = ajq(i);
    if (localObject1 == null)
    {
      Log.e("XWalkUpdaterImp", "doFixDex checkfiles no config file");
      AppMethodBeat.o(154470);
      return false;
    }
    if (!XWalkUpdater.FileListMD5Checker.checkFileListMd5(i, (File)localObject1))
    {
      Log.e("XWalkUpdaterImp", "doFixDex checkFileListMd5 failed");
      AppMethodBeat.o(154470);
      return false;
    }
    String str1 = XWalkEnvironment.getExtractedCoreDir(i);
    localObject1 = XWalkEnvironment.getExtractedCoreDir(i) + "_bk";
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(i), (String)localObject1)) {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex extract faield");
    }
    localObject2 = str1 + File.separator + "classes.dex";
    String str2 = (String)localObject1 + File.separator + "classes.dex";
    str1 = d.getMD5((String)localObject2);
    localObject1 = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject1 = "";
    }
    boolean bool;
    if (!((String)localObject1).equalsIgnoreCase(d.getMD5(str2)))
    {
      i = 1;
      if (i == 0) {
        break label349;
      }
      g.FJ(253L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex dex cruppted");
      if (!com.tencent.xweb.util.c.bcQ((String)localObject2)) {
        break label330;
      }
      if (!com.tencent.xweb.util.c.lS(str2, (String)localObject2)) {
        break label311;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace suc");
      bool = true;
      label294:
      ghC();
    }
    for (;;)
    {
      AppMethodBeat.o(154470);
      return bool;
      i = 0;
      break;
      label311:
      g.FJ(249L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace failed");
      bool = false;
      break label294;
      label330:
      g.FJ(250L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex delete cruppted dex failed");
      bool = false;
      break label294;
      label349:
      if (ghC())
      {
        g.FJ(254L);
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex suc");
        bool = true;
      }
      else
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex failed");
        g.FJ(255L);
        bool = false;
      }
    }
  }
  
  public static void hu(String paramString, int paramInt)
  {
    AppMethodBeat.i(185201);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.xweb.update");
    localIntent.putExtra("stage", paramString);
    localIntent.putExtra("extra_data", paramInt);
    XWalkEnvironment.getApplicationContext().sendBroadcast(localIntent);
    AppMethodBeat.o(185201);
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(154474);
    if (MUA == null)
    {
      AppMethodBeat.o(154474);
      return false;
    }
    boolean bool = f.gir();
    AppMethodBeat.o(154474);
    return bool;
  }
  
  private static void lH(Context paramContext)
  {
    AppMethodBeat.i(154461);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , context");
      AppMethodBeat.o(154461);
      return;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    if (paramContext == null)
    {
      Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , null == files ");
      AppMethodBeat.o(154461);
      return;
    }
    Object localObject = a.nb("KEEP_XWEB_CORE_LIST", "tools");
    Log.i("XWalkUpdaterImp", "dump KEEP_XWEB_CORE_LIST: ".concat(String.valueOf(localObject)));
    HashSet localHashSet = new HashSet();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if (localObject != null)
      {
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject[i];
          if ((!TextUtils.isEmpty(localCharSequence)) && (!TextUtils.isEmpty(localCharSequence.trim()))) {
            localHashSet.add(localCharSequence.trim());
          }
          i += 1;
        }
      }
    }
    int i = 0;
    int j = 0;
    int n = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int i1 = paramContext.length;
    int k = 0;
    int m;
    if (k < i1)
    {
      m = ai(paramContext[k]);
      if ((m < 0) || (m == n)) {
        break label444;
      }
      if (m >= i) {
        j = m;
      }
    }
    for (;;)
    {
      k += 1;
      m = i;
      i = j;
      j = m;
      break;
      if (m >= j)
      {
        j = i;
        i = m;
        continue;
        k = XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a");
        m = XWalkEnvironment.getInstalledNewstVersion("arm64-v8a");
        n = paramContext.length;
        i = 0;
        for (;;)
        {
          if (i < n)
          {
            localObject = paramContext[i];
            i1 = ai((File)localObject);
            if ((!localHashSet.contains(String.valueOf(i1))) && (i1 > 0) && (i1 < j) && (i1 != XWalkEnvironment.getAvailableVersion()) && (i1 != k) && (i1 != m)) {}
            try
            {
              com.tencent.xweb.util.c.bcQ(((File)localObject).getAbsolutePath());
              XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(i1)));
              g.t(577L, 65L, 1L);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", " FileUtils.deleteAll failed " + localException.getMessage());
                g.t(577L, 66L, 1L);
              }
            }
          }
        }
        AppMethodBeat.o(154461);
      }
      else
      {
        label444:
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  public static void lI(Context paramContext)
  {
    AppMethodBeat.i(154463);
    Log.i("XWalkUpdaterImp", "try clear test setings");
    if (com.tencent.xweb.internal.c.cq("clear_test_settings", 2592000000L))
    {
      Log.i("XWalkUpdaterImp", "do start clear test setings");
      try
      {
        y.gfo().a("tools", WebView.c.MNx);
        y.gfo().a("appbrand", WebView.c.MNx);
        y.gfo().a("support", WebView.c.MNx);
        y.gfo().a("mm", WebView.c.MNx);
        y.gfo().a("toolsmp", WebView.c.MNx);
        y.gfo().b("tools", WebView.c.MNx);
        y.gfo().b("appbrand", WebView.c.MNx);
        y.gfo().b("support", WebView.c.MNx);
        y.gfo().b("mm", WebView.c.MNx);
        y.gfo().b("toolsmp", WebView.c.MNx);
        XWalkEnvironment.setTestDownLoadUrl(paramContext, null);
        XWalkEnvironment.setPluginTestConfigUrl("");
        AppMethodBeat.o(154463);
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("XWalkUpdaterImp", "do start clear test setings got exp = " + paramContext.getMessage());
      }
    }
    AppMethodBeat.o(154463);
  }
  
  public void onXWalkInitCancelled() {}
  
  public void onXWalkInitCompleted() {}
  
  public void onXWalkInitFailed() {}
  
  public void onXWalkInitStarted() {}
  
  public void onXWalkUpdateCancelled()
  {
    AppMethodBeat.i(154479);
    hu("finished", -2);
    f.git();
    c localc = ah.gfM();
    if (localc != null) {
      localc.bAG();
    }
    AppMethodBeat.o(154479);
  }
  
  public void onXWalkUpdateCompleted(Scheduler paramScheduler)
  {
    AppMethodBeat.i(207584);
    hu("finished", 0);
    f.a(paramScheduler);
    paramScheduler = ah.gfM();
    if (paramScheduler != null) {
      paramScheduler.bAH();
    }
    AppMethodBeat.o(207584);
  }
  
  public void onXWalkUpdateFailed(int paramInt, Scheduler paramScheduler)
  {
    AppMethodBeat.i(207583);
    hu("finished", -1);
    f.a(paramInt, paramScheduler);
    paramScheduler = ah.gfM();
    if (paramScheduler != null) {
      paramScheduler.bAG();
    }
    AppMethodBeat.o(207583);
  }
  
  public void onXWalkUpdateProgress(int paramInt)
  {
    AppMethodBeat.i(154478);
    hu("updating", paramInt);
    c localc = ah.gfM();
    if (localc != null) {
      localc.vC(paramInt);
    }
    AppMethodBeat.o(154478);
  }
  
  public void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(154477);
    hu("start", 0);
    f.gis();
    ah.gfM();
    AppMethodBeat.o(154477);
  }
  
  public final boolean q(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154476);
    new f(this.MUC, paramHashMap).execute(new String[0]);
    AppMethodBeat.o(154476);
    return false;
  }
  
  public static final class a
    implements w.b
  {
    public final void a(Context paramContext, HashMap<String, String> paramHashMap)
    {
      AppMethodBeat.i(154457);
      p.a(paramContext, paramHashMap);
      AppMethodBeat.o(154457);
    }
    
    public final boolean isBusy()
    {
      AppMethodBeat.i(154458);
      boolean bool = p.isBusy();
      AppMethodBeat.o(154458);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.p
 * JD-Core Version:    0.7.0.1
 */