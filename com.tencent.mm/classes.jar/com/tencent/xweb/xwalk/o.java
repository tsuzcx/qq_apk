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
import com.tencent.xweb.af;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.g;
import com.tencent.xweb.v.a;
import com.tencent.xweb.x;
import com.tencent.xweb.xwalk.updater.e;
import java.io.File;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.FileListMD5Checker;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public class o
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  static o IUu;
  XWalkInitializer IUv;
  XWalkUpdater IUw;
  protected Context mContext;
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(154475);
    this.mContext = paramContext;
    this.IUv = new XWalkInitializer(this, paramContext);
    this.IUw = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154475);
  }
  
  public static void H(Context paramContext, boolean paramBoolean)
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
      lb(paramContext);
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
    if (IUu == null) {
      IUu = new o(paramContext);
    }
    g.fsd();
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
        xL(false);
      }
      int i;
      if (com.tencent.xweb.internal.b.c("LOAD_CORE", WebView.c.INC).IQz >= 6L)
      {
        i = 1;
        if (i == 0) {
          break label201;
        }
        g.xs(252L);
        if (!"true".equalsIgnoreCase(a.lW("enable_check_dex", "tools"))) {
          break label201;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (com.tencent.xweb.internal.c.cg("check_need_fix_dex", 43200000L)))
        {
          fsZ();
          if (!ftb())
          {
            g.xs(248L);
            adi(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
            XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
          }
        }
        H(paramContext, false);
        lc(paramContext);
        IUu.o(paramHashMap);
        AppMethodBeat.o(154459);
        return;
        i = 0;
        break;
        label201:
        if (com.tencent.xweb.internal.b.c("CREATE_WEBVIEW", WebView.c.INC).IQz >= 6L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label256;
          }
          g.xs(247L);
          if (!"true".equalsIgnoreCase(a.lW("enable_check_dex_new_web", "tools"))) {
            break label256;
          }
          i = 1;
          break;
        }
        label256:
        i = 0;
      }
    }
  }
  
  public static int aN(Context paramContext, int paramInt)
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
      int i1 = ad(paramContext[m]);
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
          if (adj(paramInt))
          {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
            i = paramInt;
          }
        }
        label378:
        for (;;)
        {
          if (i == paramInt) {
            g.xs(89L);
          }
          for (;;)
          {
            XWalkEnvironment.addXWalkInitializeLog("revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i);
            XWalkEnvironment.setAvailableVersion(i, "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i, XWalkEnvironment.getRuntimeAbi());
            AppMethodBeat.o(154464);
            return i;
            if (adj(i)) {
              break label378;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer did not find target version:".concat(String.valueOf(paramInt)));
            if (adj(i)) {
              break label378;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            if (i > 0) {
              g.xs(90L);
            } else if (k != 0) {
              g.xs(92L);
            } else {
              g.xs(91L);
            }
          }
        }
      }
      label387:
      j = k;
    }
  }
  
  private static void aX(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154467);
    Log.i("XWalkUpdaterImp", "tryAbandonThisVersion scene  is ".concat(String.valueOf(paramString)));
    long l1 = com.tencent.xweb.internal.b.c(paramString, WebView.c.INC).IQz;
    if (!"true".equalsIgnoreCase(a.lW("enable_reinstall_for_crash_at_".concat(String.valueOf(paramString)), "tools")))
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
          adi(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
          XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
          XWalkEnvironment.getSharedPreferencesForXWEBUpdater().edit().putLong(paramString, l1).commit();
          g.xs(paramInt1);
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
        g.xs(paramInt2);
      }
    }
    AppMethodBeat.o(154467);
  }
  
  private static int ad(File paramFile)
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
  
  private static boolean adi(int paramInt)
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
      int k = ad(localFile);
      if ((k > 0) && (k == paramInt) && (com.tencent.xweb.util.c.aPq(localFile.getAbsolutePath())))
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
  
  private static boolean adj(int paramInt)
  {
    AppMethodBeat.i(154465);
    File localFile = adl(paramInt);
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
  
  private static boolean adk(int paramInt)
  {
    AppMethodBeat.i(154472);
    File localFile = adl(paramInt);
    if (localFile == null)
    {
      if (XWalkEnvironment.isTestVersion(paramInt))
      {
        AppMethodBeat.o(154472);
        return true;
      }
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      g.xs(78L);
      if ("true".equalsIgnoreCase(a.lW("dis_config_file_check", "tools")))
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
  
  private static File adl(int paramInt)
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
  
  static void fsZ()
  {
    AppMethodBeat.i(154468);
    aX("LOAD_CORE", 243, 244);
    aX("CREATE_WEBVIEW", 245, 246);
    AppMethodBeat.o(154468);
  }
  
  private static boolean fta()
  {
    AppMethodBeat.i(154469);
    if (com.tencent.xweb.util.c.aPq(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi())))
    {
      XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
      AppMethodBeat.o(154469);
      return true;
    }
    XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
    AppMethodBeat.o(154469);
    return false;
  }
  
  public static boolean ftb()
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
    Object localObject1 = adl(i);
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
      g.xs(253L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex dex cruppted");
      if (!com.tencent.xweb.util.c.aPq((String)localObject2)) {
        break label330;
      }
      if (!com.tencent.xweb.util.c.kP(str2, (String)localObject2)) {
        break label311;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace suc");
      bool = true;
      label294:
      fta();
    }
    for (;;)
    {
      AppMethodBeat.o(154470);
      return bool;
      i = 0;
      break;
      label311:
      g.xs(249L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace failed");
      bool = false;
      break label294;
      label330:
      g.xs(250L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex delete cruppted dex failed");
      bool = false;
      break label294;
      label349:
      if (fta())
      {
        g.xs(254L);
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex suc");
        bool = true;
      }
      else
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex failed");
        g.xs(255L);
        bool = false;
      }
    }
  }
  
  public static void gG(String paramString, int paramInt)
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
    if (IUu == null)
    {
      AppMethodBeat.o(154474);
      return false;
    }
    boolean bool = e.ftH();
    AppMethodBeat.o(154474);
    return bool;
  }
  
  private static void lb(Context paramContext)
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
    int i = 0;
    int j = 0;
    int n = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int i1 = paramContext.length;
    int k = 0;
    int m;
    if (k < i1)
    {
      m = ad(paramContext[k]);
      if ((m < 0) || (m == n)) {
        break label319;
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
            File localFile = paramContext[i];
            i1 = ad(localFile);
            if ((i1 > 0) && (i1 < j) && (i1 != XWalkEnvironment.getAvailableVersion()) && (i1 != k) && (i1 != m)) {}
            try
            {
              com.tencent.xweb.util.c.aPq(localFile.getAbsolutePath());
              XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(i1)));
              g.r(577L, 65L, 1L);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", " FileUtils.deleteAll failed " + localException.getMessage());
                g.r(577L, 66L, 1L);
              }
            }
          }
        }
        AppMethodBeat.o(154461);
      }
      else
      {
        label319:
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  public static void lc(Context paramContext)
  {
    AppMethodBeat.i(154463);
    Log.i("XWalkUpdaterImp", "try clear test setings");
    if (com.tencent.xweb.internal.c.cg("clear_test_settings", 2592000000L))
    {
      Log.i("XWalkUpdaterImp", "do start clear test setings");
      try
      {
        x.fqR().a("tools", WebView.c.INB);
        x.fqR().a("appbrand", WebView.c.INB);
        x.fqR().a("support", WebView.c.INB);
        x.fqR().a("mm", WebView.c.INB);
        x.fqR().a("toolsmp", WebView.c.INB);
        x.fqR().b("tools", WebView.c.INB);
        x.fqR().b("appbrand", WebView.c.INB);
        x.fqR().b("support", WebView.c.INB);
        x.fqR().b("mm", WebView.c.INB);
        x.fqR().b("toolsmp", WebView.c.INB);
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
  
  public static void xL(boolean paramBoolean)
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
    long l1 = localSharedPreferences.getLong("CHECK_FILES_MD5_TIME", 0L);
    long l2 = System.currentTimeMillis();
    if ((paramBoolean) || (l2 < l1) || (l2 - l1 > 7200000L))
    {
      localSharedPreferences.edit().putLong("CHECK_FILES_MD5_TIME", l2).commit();
      String str = XWalkEnvironment.getExtractedCoreDir(i);
      Log.i("XWalkUpdaterImp", "checkFiles start check resfiles");
      boolean bool = XWalkUpdater.checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(i), str, i);
      int j;
      if (!bool)
      {
        j = localSharedPreferences.getInt("LAST_CHECK_RES_VERSION", -1);
        localSharedPreferences.edit().putInt("LAST_CHECK_RES_VERSION", -1).commit();
        if (j == i) {
          break label314;
        }
        g.xs(77L);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted at first time");
        g.xs(76L);
      }
      Log.i("XWalkUpdaterImp", "checkFiles start check installed files");
      paramBoolean = adk(i);
      if (!paramBoolean)
      {
        j = localSharedPreferences.getInt("LAST_CHECK_VERSION", -1);
        localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", -1).commit();
        if (j == i) {
          break label325;
        }
        g.xs(64L);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted at first time");
        label261:
        g.xs(63L);
      }
      if ("true".equalsIgnoreCase(a.lW("disable_res_check", "tools"))) {
        break label336;
      }
      paramBoolean &= bool;
    }
    for (;;)
    {
      if (paramBoolean) {
        break label347;
      }
      XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
      AppMethodBeat.o(154471);
      return;
      AppMethodBeat.o(154471);
      return;
      label314:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted");
      break;
      label325:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted");
      break label261;
      label336:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "ignore res files check");
    }
    label347:
    localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", i).commit();
    Log.i("XWalkUpdaterImp", "checkfiles parse");
    AppMethodBeat.o(154471);
  }
  
  public final boolean o(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154476);
    new e(this.IUw, paramHashMap).execute(new String[0]);
    AppMethodBeat.o(154476);
    return false;
  }
  
  public void onXWalkInitCancelled() {}
  
  public void onXWalkInitCompleted() {}
  
  public void onXWalkInitFailed() {}
  
  public void onXWalkInitStarted() {}
  
  public void onXWalkUpdateCancelled()
  {
    AppMethodBeat.i(154479);
    gG("finished", -2);
    e.ftJ();
    b localb = af.fro();
    if (localb != null) {
      localb.boK();
    }
    AppMethodBeat.o(154479);
  }
  
  public void onXWalkUpdateCompleted()
  {
    AppMethodBeat.i(154481);
    gG("finished", 0);
    e.ftK();
    b localb = af.fro();
    if (localb != null) {
      localb.boL();
    }
    AppMethodBeat.o(154481);
  }
  
  public void onXWalkUpdateFailed(int paramInt)
  {
    AppMethodBeat.i(154480);
    gG("finished", -1);
    e.adv(paramInt);
    b localb = af.fro();
    if (localb != null) {
      localb.boK();
    }
    AppMethodBeat.o(154480);
  }
  
  public void onXWalkUpdateProgress(int paramInt)
  {
    AppMethodBeat.i(154478);
    gG("updating", paramInt);
    b localb = af.fro();
    if (localb != null) {
      localb.ua(paramInt);
    }
    AppMethodBeat.o(154478);
  }
  
  public void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(154477);
    gG("start", 0);
    e.ftI();
    af.fro();
    AppMethodBeat.o(154477);
  }
  
  public static final class a
    implements v.a
  {
    public final void a(Context paramContext, HashMap<String, String> paramHashMap)
    {
      AppMethodBeat.i(154457);
      o.a(paramContext, paramHashMap);
      AppMethodBeat.o(154457);
    }
    
    public final boolean isBusy()
    {
      AppMethodBeat.i(154458);
      boolean bool = o.isBusy();
      AppMethodBeat.o(154458);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.o
 * JD-Core Version:    0.7.0.1
 */