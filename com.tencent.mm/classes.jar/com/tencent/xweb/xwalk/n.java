package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.a;
import com.tencent.xweb.ab;
import com.tencent.xweb.c.c;
import com.tencent.xweb.q;
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

public class n
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  static n BKj;
  XWalkInitializer BKk;
  XWalkUpdater BKl;
  protected Context mContext;
  
  public n(Context paramContext)
  {
    AppMethodBeat.i(85389);
    this.mContext = paramContext;
    this.BKk = new XWalkInitializer(this, paramContext);
    this.BKl = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(85389);
  }
  
  public static void E(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(85378);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(85378);
      return;
    }
    long l1 = localSharedPreferences.getLong("LAST_TRY_CLEAR_APK_TIME", 0L);
    long l2 = System.currentTimeMillis();
    if ((paramBoolean) || (l2 < l1) || (l2 - l1 > 259200000L)) {}
    try
    {
      jV(paramContext);
      localSharedPreferences.edit().putLong("LAST_TRY_CLEAR_APK_TIME", l2).commit();
      AppMethodBeat.o(85378);
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
  
  private static boolean TD(int paramInt)
  {
    AppMethodBeat.i(139605);
    Log.i("XWalkUpdaterImp", "clearVersion start , nVersion = ".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      Log.e("XWalkUpdaterImp", "clearVersion failed , nVersion is not valid ");
      AppMethodBeat.o(139605);
      return false;
    }
    Object localObject = XWalkEnvironment.getApplicationContext();
    if ((localObject == null) || (((Context)localObject).getApplicationInfo() == null) || (((Context)localObject).getApplicationInfo().dataDir == null))
    {
      Log.e("XWalkUpdaterImp", "clearVersion failed , context = null");
      AppMethodBeat.o(139605);
      return false;
    }
    localObject = new File(((Context)localObject).getApplicationInfo().dataDir).listFiles();
    if (localObject == null)
    {
      Log.e("XWalkUpdaterImp", "clearVersion failed , null == files ");
      AppMethodBeat.o(139605);
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      File localFile = localObject[i];
      int k = av(localFile);
      if ((k > 0) && (k == paramInt) && (com.tencent.xweb.util.b.ayf(localFile.getAbsolutePath())))
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(k)));
        AppMethodBeat.o(139605);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(139605);
    return false;
  }
  
  private static boolean TE(int paramInt)
  {
    AppMethodBeat.i(85381);
    File localFile = TG(paramInt);
    if (localFile == null)
    {
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      AppMethodBeat.o(85381);
      return false;
    }
    boolean bool = XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramInt, localFile);
    AppMethodBeat.o(85381);
    return bool;
  }
  
  private static boolean TF(int paramInt)
  {
    AppMethodBeat.i(85386);
    File localFile = TG(paramInt);
    if (localFile == null)
    {
      if (XWalkEnvironment.isTestVersion(paramInt))
      {
        AppMethodBeat.o(85386);
        return true;
      }
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      com.tencent.xweb.util.f.pf(78L);
      if ("true".equalsIgnoreCase(a.iW("dis_config_file_check", "tools")))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "dis_config_file_check ");
        AppMethodBeat.o(85386);
        return true;
      }
      AppMethodBeat.o(85386);
      return false;
    }
    boolean bool = XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramInt, localFile);
    AppMethodBeat.o(85386);
    return bool;
  }
  
  private static File TG(int paramInt)
  {
    AppMethodBeat.i(85387);
    try
    {
      File localFile = new File(XWalkEnvironment.getPatchFileListConfig(paramInt));
      boolean bool = localFile.exists();
      if (bool)
      {
        AppMethodBeat.o(85387);
        return localFile;
      }
      localFile = new File(XWalkEnvironment.getDownloadZipFileListConfig(paramInt));
      bool = localFile.exists();
      if (bool)
      {
        AppMethodBeat.o(85387);
        return localFile;
      }
      AppMethodBeat.o(85387);
      return null;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(85387);
    }
    return null;
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    int j = 1;
    AppMethodBeat.i(85377);
    if (BKj == null) {
      BKj = new n(paramContext);
    }
    if (!XWalkEnvironment.isTestVersion(XWalkEnvironment.getInstalledNewstVersion())) {
      sl(false);
    }
    if (c.c("LOAD_CORE", WebView.d.BEq).BGQ >= 6L) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.xweb.util.f.pf(252L);
      if (!"true".equalsIgnoreCase(a.iW("enable_check_dex", "tools"))) {
        break;
      }
      i = j;
      if ((i != 0) && (com.tencent.xweb.c.d.bj("check_need_fix_dex", 43200000L)))
      {
        eah();
        if (!eaj())
        {
          com.tencent.xweb.util.f.pf(248L);
          TD(XWalkEnvironment.getInstalledNewstVersion());
          XWalkEnvironment.setAvailableVersion(-1, null);
        }
      }
      E(paramContext, false);
      jW(paramContext);
      BKj.s(paramHashMap);
      AppMethodBeat.o(85377);
      return;
    }
    if (c.c("CREATE_WEBVIEW", WebView.d.BEq).BGQ >= 6L) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.xweb.util.f.pf(247L);
        i = j;
        if ("true".equalsIgnoreCase(a.iW("enable_check_dex_new_web", "tools"))) {
          break;
        }
      }
      i = 0;
      break;
    }
  }
  
  public static int aH(Context paramContext, int paramInt)
  {
    int n = 1;
    AppMethodBeat.i(85380);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed: bad context");
      AppMethodBeat.o(85380);
      return -1;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    if (paramContext == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed files is null");
      AppMethodBeat.o(85380);
      return -1;
    }
    int i2 = XWalkEnvironment.getInstalledNewstVersion();
    int i3 = paramContext.length;
    int m = 0;
    int i = -1;
    int j = 0;
    int k;
    if (m < i3)
    {
      int i1 = av(paramContext[m]);
      k = j;
      if (i1 < 0) {
        break label384;
      }
      if (i1 == paramInt) {
        j = 1;
      }
      k = j;
      if (i1 > paramInt) {
        break label384;
      }
      k = j;
      if (i1 < 49) {
        break label384;
      }
      k = j;
      if (i1 == i2) {
        break label384;
      }
      k = j;
      if (i1 <= i) {
        break label384;
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
          if (TE(paramInt))
          {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
            i = paramInt;
          }
        }
        label375:
        for (;;)
        {
          if (i == paramInt) {
            com.tencent.xweb.util.f.pf(89L);
          }
          for (;;)
          {
            XWalkEnvironment.addXWalkInitializeLog("revert from:" + XWalkEnvironment.getInstalledNewstVersion() + " to:" + i);
            XWalkEnvironment.setAvailableVersion(i, "revert from:" + XWalkEnvironment.getInstalledNewstVersion() + " to:" + i);
            AppMethodBeat.o(85380);
            return i;
            if (TE(i)) {
              break label375;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer did not find target version:".concat(String.valueOf(paramInt)));
            if (TE(i)) {
              break label375;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            if (i > 0) {
              com.tencent.xweb.util.f.pf(90L);
            } else if (k != 0) {
              com.tencent.xweb.util.f.pf(92L);
            } else {
              com.tencent.xweb.util.f.pf(91L);
            }
          }
        }
      }
      label384:
      j = k;
    }
  }
  
  private static void aM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139607);
    Log.i("XWalkUpdaterImp", "tryAbandonThisVersion scene  is ".concat(String.valueOf(paramString)));
    long l1 = c.c(paramString, WebView.d.BEq).BGQ;
    if (!"true".equalsIgnoreCase(a.iW("enable_reinstall_for_crash_at_".concat(String.valueOf(paramString)), "tools")))
    {
      AppMethodBeat.o(139607);
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
          TD(XWalkEnvironment.getInstalledNewstVersion());
          XWalkEnvironment.setAvailableVersion(-1, "");
          XWalkEnvironment.getSharedPreferencesForXWEBUpdater().edit().putLong(paramString, l1).commit();
          com.tencent.xweb.util.f.pf(paramInt1);
          AppMethodBeat.o(139607);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("XWalkUpdaterImp", "clear version failed , errmsg:" + paramString.getMessage());
          AppMethodBeat.o(139607);
          return;
        }
      }
      if (l1 - 2L > l2)
      {
        Log.i("XWalkUpdaterImp", "tryAbandonThisVersion cant not fix ");
        com.tencent.xweb.util.f.pf(paramInt2);
      }
    }
    AppMethodBeat.o(139607);
  }
  
  private static int av(File paramFile)
  {
    AppMethodBeat.i(85382);
    if (paramFile == null)
    {
      AppMethodBeat.o(85382);
      return -1;
    }
    String str = paramFile.getName();
    if ((str != null) && (str.startsWith("app_xwalk_")) && (paramFile.isDirectory()))
    {
      paramFile = str.substring(10);
      try
      {
        int i = Integer.parseInt(paramFile);
        AppMethodBeat.o(85382);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("XWalkUpdaterImp", "get apk version strApkVer  is ".concat(String.valueOf(paramFile)));
      }
    }
    AppMethodBeat.o(85382);
    return -1;
  }
  
  static void eah()
  {
    AppMethodBeat.i(139608);
    aM("LOAD_CORE", 243, 244);
    aM("CREATE_WEBVIEW", 245, 246);
    AppMethodBeat.o(139608);
  }
  
  private static boolean eai()
  {
    AppMethodBeat.i(85383);
    if (com.tencent.xweb.util.b.ayf(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersion())))
    {
      XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
      AppMethodBeat.o(85383);
      return true;
    }
    XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
    AppMethodBeat.o(85383);
    return false;
  }
  
  public static boolean eaj()
  {
    AppMethodBeat.i(85384);
    int i = XWalkEnvironment.getInstalledNewstVersion();
    if (i <= 0)
    {
      Log.i("XWalkUpdaterImp", "doFixDex stopped , because no xweb currently");
      AppMethodBeat.o(85384);
      return false;
    }
    Log.i("XWalkUpdaterImp", "doFixDex start");
    Object localObject1 = TG(i);
    if (localObject1 == null)
    {
      Log.e("XWalkUpdaterImp", "doFixDex checkfiles no config file");
      AppMethodBeat.o(85384);
      return false;
    }
    if (!XWalkUpdater.FileListMD5Checker.checkFileListMd5(i, (File)localObject1))
    {
      Log.e("XWalkUpdaterImp", "doFixDex checkFileListMd5 failed");
      AppMethodBeat.o(85384);
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
    str1 = com.tencent.xweb.util.d.getMD5((String)localObject2);
    localObject1 = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject1 = "";
    }
    boolean bool;
    if (!((String)localObject1).equalsIgnoreCase(com.tencent.xweb.util.d.getMD5(str2)))
    {
      i = 1;
      if (i == 0) {
        break label349;
      }
      com.tencent.xweb.util.f.pf(253L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex dex cruppted");
      if (!com.tencent.xweb.util.b.ayf((String)localObject2)) {
        break label330;
      }
      if (!com.tencent.xweb.util.b.copyFile(str2, (String)localObject2)) {
        break label311;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace suc");
      bool = true;
      label294:
      eai();
    }
    for (;;)
    {
      AppMethodBeat.o(85384);
      return bool;
      i = 0;
      break;
      label311:
      com.tencent.xweb.util.f.pf(249L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace failed");
      bool = false;
      break label294;
      label330:
      com.tencent.xweb.util.f.pf(250L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex delete cruppted dex failed");
      bool = false;
      break label294;
      label349:
      if (eai())
      {
        com.tencent.xweb.util.f.pf(254L);
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex suc");
        bool = true;
      }
      else
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex failed");
        com.tencent.xweb.util.f.pf(255L);
        bool = false;
      }
    }
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(85388);
    if (BKj == null)
    {
      AppMethodBeat.o(85388);
      return false;
    }
    boolean bool = com.tencent.xweb.xwalk.b.f.eaF();
    AppMethodBeat.o(85388);
    return bool;
  }
  
  private static void jV(Context paramContext)
  {
    AppMethodBeat.i(85379);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , context");
      AppMethodBeat.o(85379);
      return;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    if (paramContext == null)
    {
      Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , null == files ");
      AppMethodBeat.o(85379);
      return;
    }
    int i = 0;
    int j = 0;
    int n = XWalkEnvironment.getInstalledNewstVersion();
    int i1 = paramContext.length;
    int k = 0;
    int m;
    if (k < i1)
    {
      m = av(paramContext[k]);
      if ((m < 0) || (m == n)) {
        break label288;
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
        k = paramContext.length;
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            File localFile = paramContext[i];
            m = av(localFile);
            if ((m > 0) && (m < j) && (m != XWalkEnvironment.getAvailableVersion())) {}
            try
            {
              com.tencent.xweb.util.b.ayf(localFile.getAbsolutePath());
              XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(m)));
              com.tencent.xweb.util.f.m(577L, 65L, 1L);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", " FileUtils.deleteAll failed " + localException.getMessage());
                com.tencent.xweb.util.f.m(577L, 66L, 1L);
              }
            }
          }
        }
        AppMethodBeat.o(85379);
      }
      else
      {
        label288:
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  public static void jW(Context paramContext)
  {
    AppMethodBeat.i(139606);
    Log.i("XWalkUpdaterImp", "try clear test setings");
    if (com.tencent.xweb.c.d.bj("clear_test_settings", 2592000000L))
    {
      Log.i("XWalkUpdaterImp", "do start clear test setings");
      try
      {
        q.dYn().a("tools", WebView.d.BEp);
        q.dYn().a("appbrand", WebView.d.BEp);
        q.dYn().a("support", WebView.d.BEp);
        q.dYn().a("mm", WebView.d.BEp);
        q.dYn().a("toolsmp", WebView.d.BEp);
        q.dYn().b("tools", WebView.d.BEp);
        q.dYn().b("appbrand", WebView.d.BEp);
        q.dYn().b("support", WebView.d.BEp);
        q.dYn().b("mm", WebView.d.BEp);
        q.dYn().b("toolsmp", WebView.d.BEp);
        XWalkEnvironment.setTestDownLoadUrl(paramContext, null);
        XWalkEnvironment.setPluginTestConfigUrl("");
        AppMethodBeat.o(139606);
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("XWalkUpdaterImp", "do start clear test setings got exp = " + paramContext.getMessage());
      }
    }
    AppMethodBeat.o(139606);
  }
  
  public static void sl(boolean paramBoolean)
  {
    AppMethodBeat.i(85385);
    int i = XWalkEnvironment.getAvailableVersion();
    if (i <= 0)
    {
      AppMethodBeat.o(85385);
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(85385);
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
          break label311;
        }
        com.tencent.xweb.util.f.pf(77L);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted at first time");
        com.tencent.xweb.util.f.pf(76L);
      }
      Log.i("XWalkUpdaterImp", "checkFiles start check installed files");
      paramBoolean = TF(i);
      if (!paramBoolean)
      {
        j = localSharedPreferences.getInt("LAST_CHECK_VERSION", -1);
        localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", -1).commit();
        if (j == i) {
          break label322;
        }
        com.tencent.xweb.util.f.pf(64L);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted at first time");
        label261:
        com.tencent.xweb.util.f.pf(63L);
      }
      if ("true".equalsIgnoreCase(a.iW("disable_res_check", "tools"))) {
        break label333;
      }
      paramBoolean &= bool;
    }
    for (;;)
    {
      if (paramBoolean) {
        break label344;
      }
      XWalkEnvironment.setAvailableVersion(-1, null);
      AppMethodBeat.o(85385);
      return;
      AppMethodBeat.o(85385);
      return;
      label311:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted");
      break;
      label322:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted");
      break label261;
      label333:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "ignore res files check");
    }
    label344:
    localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", i).commit();
    Log.i("XWalkUpdaterImp", "checkfiles parse");
    AppMethodBeat.o(85385);
  }
  
  public void onXWalkInitCancelled() {}
  
  public void onXWalkInitCompleted() {}
  
  public void onXWalkInitFailed() {}
  
  public void onXWalkInitStarted() {}
  
  public void onXWalkUpdateCancelled()
  {
    AppMethodBeat.i(85393);
    com.tencent.xweb.xwalk.b.f.eaH();
    b localb = ab.dYE();
    if (localb != null) {
      localb.aMy();
    }
    AppMethodBeat.o(85393);
  }
  
  public void onXWalkUpdateCompleted()
  {
    AppMethodBeat.i(85395);
    com.tencent.xweb.xwalk.b.f.eaI();
    b localb = ab.dYE();
    if (localb != null) {
      localb.aMz();
    }
    AppMethodBeat.o(85395);
  }
  
  public void onXWalkUpdateFailed(int paramInt)
  {
    AppMethodBeat.i(85394);
    com.tencent.xweb.xwalk.b.f.TN(paramInt);
    b localb = ab.dYE();
    if (localb != null) {
      localb.aMy();
    }
    AppMethodBeat.o(85394);
  }
  
  public void onXWalkUpdateProgress(int paramInt)
  {
    AppMethodBeat.i(85392);
    b localb = ab.dYE();
    if (localb != null) {
      localb.pD(paramInt);
    }
    AppMethodBeat.o(85392);
  }
  
  public void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(85391);
    com.tencent.xweb.xwalk.b.f.eaG();
    AppMethodBeat.o(85391);
  }
  
  public final boolean s(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(85390);
    new com.tencent.xweb.xwalk.b.f(this.BKl, paramHashMap).execute(new String[0]);
    AppMethodBeat.o(85390);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.n
 * JD-Core Version:    0.7.0.1
 */