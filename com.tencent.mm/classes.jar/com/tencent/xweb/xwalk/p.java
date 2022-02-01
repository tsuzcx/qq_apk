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
import com.tencent.xweb.util.h;
import com.tencent.xweb.w.b;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.e;
import com.tencent.xweb.xwalk.updater.g;
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
  static p SHH;
  XWalkInitializer SHI;
  XWalkUpdater SHJ;
  protected Context mContext;
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(154475);
    this.mContext = paramContext;
    this.SHI = new XWalkInitializer(this, paramContext);
    this.SHJ = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154475);
  }
  
  public static void Et(boolean paramBoolean)
  {
    boolean bool1 = true;
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
    Object localObject;
    if ((paramBoolean) || (com.tencent.xweb.internal.c.cl("CHECK_FILES_MD5_TIME_KEY", 7200000L)))
    {
      Log.i("XWalkUpdaterImp", "checkFiles start check resfiles");
      localObject = XWalkEnvironment.getExtractedCoreDir(i);
      boolean bool2 = XWalkUpdater.checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(i), (String)localObject, i);
      int j;
      if (!bool2)
      {
        j = localSharedPreferences.getInt("LAST_CHECK_RES_VERSION", -1);
        localSharedPreferences.edit().putInt("LAST_CHECK_RES_VERSION", -1).commit();
        if (j == i) {
          break label270;
        }
        h.OQ(77L);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted at first time");
        h.OQ(76L);
      }
      Log.i("XWalkUpdaterImp", "checkFiles start check installed files");
      localObject = asZ(i);
      if (localObject != null) {
        break label325;
      }
      if (!XWalkEnvironment.isTestVersion(i)) {
        break label280;
      }
      paramBoolean = bool1;
      label165:
      if (!paramBoolean)
      {
        j = localSharedPreferences.getInt("LAST_CHECK_VERSION", -1);
        localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", -1).commit();
        if (j == i) {
          break label335;
        }
        h.OQ(64L);
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted at first time");
        label219:
        h.OQ(63L);
      }
      if ("true".equalsIgnoreCase(a.nS("disable_res_check", "tools"))) {
        break label345;
      }
      paramBoolean &= bool2;
    }
    for (;;)
    {
      if (paramBoolean) {
        break label355;
      }
      XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
      AppMethodBeat.o(154471);
      return;
      AppMethodBeat.o(154471);
      return;
      label270:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted");
      break;
      label280:
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      h.OQ(78L);
      if ("true".equalsIgnoreCase(a.nS("dis_config_file_check", "tools")))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "dis_config_file_check ");
        paramBoolean = bool1;
        break label165;
      }
      paramBoolean = false;
      break label165;
      label325:
      paramBoolean = XWalkUpdater.FileListMD5Checker.checkFileListMd5(i, (File)localObject);
      break label165;
      label335:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted");
      break label219;
      label345:
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "ignore res files check");
    }
    label355:
    localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", i).commit();
    Log.i("XWalkUpdaterImp", "checkfiles parse");
    AppMethodBeat.o(154471);
  }
  
  public static void L(Context paramContext, boolean paramBoolean)
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
    if (((!paramBoolean) && (l2 >= l1) && (l2 - l1 <= 259200000L)) || (paramContext != null)) {}
    Object localObject;
    HashSet localHashSet;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if ((paramContext.getApplicationInfo() != null) && (paramContext.getApplicationInfo().dataDir != null)) {
          continue;
        }
        Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , context");
      }
      catch (Exception paramContext)
      {
        Log.e("XWalkUpdaterImp", "tryClearOldXWebCore failed " + paramContext.getMessage());
        continue;
        localObject = a.nS("KEEP_XWEB_CORE_LIST", "tools");
        Log.i("XWalkUpdaterImp", "dump KEEP_XWEB_CORE_LIST: ".concat(String.valueOf(localObject)));
        localHashSet = new HashSet();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
      }
      localSharedPreferences.edit().putLong("LAST_TRY_CLEAR_APK_TIME", l2).commit();
      AppMethodBeat.o(154460);
      return;
      paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
      if (paramContext == null)
      {
        Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , null == files ");
      }
      else
      {
        localObject = ((String)localObject).split(";");
        if (localObject != null)
        {
          j = localObject.length;
          i = 0;
        }
      }
    }
    int k;
    int m;
    for (;;)
    {
      if (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        if ((!TextUtils.isEmpty(localCharSequence)) && (!TextUtils.isEmpty(localCharSequence.trim()))) {
          localHashSet.add(localCharSequence.trim());
        }
      }
      else
      {
        i = 0;
        j = 0;
        int n = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        int i1 = paramContext.length;
        k = 0;
        if (k < i1)
        {
          m = am(paramContext[k]);
          if ((m >= 0) && (m != n))
          {
            if (m < i) {
              break label550;
            }
            j = m;
            break label533;
          }
        }
        else
        {
          k = XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a");
          m = XWalkEnvironment.getInstalledNewstVersion("arm64-v8a");
          n = paramContext.length;
          i = 0;
          while (i < n)
          {
            localObject = paramContext[i];
            i1 = am((File)localObject);
            if ((!localHashSet.contains(String.valueOf(i1))) && (i1 > 0) && (i1 < j))
            {
              int i2 = XWalkEnvironment.getAvailableVersion();
              if ((i1 == i2) || (i1 == k) || (i1 == m)) {}
            }
            try
            {
              com.tencent.xweb.util.c.bsB(((File)localObject).getAbsolutePath());
              XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(i1)));
              h.s(577L, 65L, 1L);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", " FileUtils.deleteAll failed " + localException.getMessage());
                h.s(577L, 66L, 1L);
              }
            }
          }
        }
        label515:
        m = i;
        i = j;
        j = m;
        break label533;
      }
      i += 1;
    }
    for (;;)
    {
      label533:
      k += 1;
      m = i;
      i = j;
      j = m;
      break;
      label550:
      if (m < j) {
        break label515;
      }
      j = i;
      i = m;
    }
  }
  
  public static int aX(Context paramContext, int paramInt)
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
      int i1 = am(paramContext[m]);
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
          if (asY(paramInt))
          {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
            i = paramInt;
          }
        }
        label378:
        for (;;)
        {
          if (i == paramInt) {
            h.OQ(89L);
          }
          for (;;)
          {
            XWalkEnvironment.addXWalkInitializeLog("revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i);
            XWalkEnvironment.setAvailableVersion(i, "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i, XWalkEnvironment.getRuntimeAbi());
            AppMethodBeat.o(154464);
            return i;
            if (asY(i)) {
              break label378;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer did not find target version:".concat(String.valueOf(paramInt)));
            if (asY(i)) {
              break label378;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            if (i > 0) {
              h.OQ(90L);
            } else if (k != 0) {
              h.OQ(92L);
            } else {
              h.OQ(91L);
            }
          }
        }
      }
      label387:
      j = k;
    }
  }
  
  private static int am(File paramFile)
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
  
  private static boolean asX(int paramInt)
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
      int k = am(localFile);
      if ((k > 0) && (k == paramInt) && (com.tencent.xweb.util.c.bsB(localFile.getAbsolutePath())))
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
  
  private static boolean asY(int paramInt)
  {
    AppMethodBeat.i(154465);
    File localFile = asZ(paramInt);
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
  
  private static File asZ(int paramInt)
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
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154459);
    if (SHH == null) {
      SHH = new p(paramContext);
    }
    h.htW();
    String str = null;
    if (paramHashMap != null) {
      str = (String)paramHashMap.get("UpdaterCheckType");
    }
    if ("4".equals(str))
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "check emebedinstall only");
      XWalkUpdater.tryInstallFromEmebed();
      AppMethodBeat.o(154459);
      return;
    }
    XWalkUpdater.tryInstallFromEmebed();
    SHH.C(paramHashMap);
    e.lJ(paramContext);
    AppMethodBeat.o(154459);
  }
  
  private static void ba(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154467);
    Log.i("XWalkUpdaterImp", "tryAbandonThisVersion scene  is ".concat(String.valueOf(paramString)));
    long l1 = b.c(paramString, WebView.c.SAt).SDy;
    if (!"true".equalsIgnoreCase(a.nS("enable_reinstall_for_crash_at_".concat(String.valueOf(paramString)), "tools")))
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
          asX(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
          XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
          XWalkEnvironment.getSharedPreferencesForXWEBUpdater().edit().putLong(paramString, l1).commit();
          h.OQ(paramInt1);
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
        h.OQ(paramInt2);
      }
    }
    AppMethodBeat.o(154467);
  }
  
  private static void bsP(String paramString)
  {
    AppMethodBeat.i(207312);
    paramString = new File(paramString);
    if (!paramString.isDirectory())
    {
      AppMethodBeat.o(207312);
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramString[i];
      if (localFile != null)
      {
        if (!"oat".equalsIgnoreCase(localFile.getName())) {
          break label102;
        }
        com.tencent.xweb.util.c.ak(localFile);
        Log.i("XWalkUpdaterImp", "removeOptDexRecursively remove oat dir " + localFile.getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break;
        label102:
        if (localFile.getName().endsWith(".odex"))
        {
          com.tencent.xweb.util.c.ak(localFile);
          Log.i("XWalkUpdaterImp", "removeOptDexRecursively remove odex file " + localFile.getAbsolutePath());
        }
        else if (localFile.getName().endsWith(".vdex"))
        {
          com.tencent.xweb.util.c.ak(localFile);
          Log.i("XWalkUpdaterImp", "removeOptDexRecursively remove vdex file " + localFile.getAbsolutePath());
        }
        else if (localFile.isDirectory())
        {
          bsP(localFile.getAbsolutePath());
        }
      }
    }
    AppMethodBeat.o(207312);
  }
  
  public static void hQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(185201);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.xweb.update");
    localIntent.putExtra("stage", paramString);
    localIntent.putExtra("extra_data", paramInt);
    XWalkEnvironment.getApplicationContext().sendBroadcast(localIntent);
    AppMethodBeat.o(185201);
  }
  
  public static void huW()
  {
    AppMethodBeat.i(207310);
    if (!com.tencent.xweb.internal.c.cl("should_try_generate_jar", 172800000L))
    {
      AppMethodBeat.o(207310);
      return;
    }
    XWalkUpdater.try_generate_jar_for_dex_in_dir(XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), false);
    AppMethodBeat.o(207310);
  }
  
  static void huX()
  {
    AppMethodBeat.i(154468);
    ba("LOAD_CORE", 243, 244);
    ba("CREATE_WEBVIEW", 245, 246);
    AppMethodBeat.o(154468);
  }
  
  public static void huY()
  {
    int j = 1;
    AppMethodBeat.i(207311);
    if (b.c("LOAD_CORE", WebView.c.SAt).SDy >= 6L) {}
    for (int i = 1; i != 0; i = 0)
    {
      h.OQ(252L);
      if (!"true".equalsIgnoreCase(a.nS("enable_check_dex", "tools"))) {
        break;
      }
      i = j;
      if (i != 0) {
        break label132;
      }
      AppMethodBeat.o(207311);
      return;
    }
    if (b.c("CREATE_WEBVIEW", WebView.c.SAt).SDy >= 6L) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        h.OQ(247L);
        i = j;
        if ("true".equalsIgnoreCase(a.nS("enable_check_dex_new_web", "tools"))) {
          break;
        }
      }
      i = 0;
      break;
    }
    label132:
    if (!com.tencent.xweb.internal.c.cl("check_need_fix_dex", 43200000L))
    {
      AppMethodBeat.o(207311);
      return;
    }
    huX();
    if (!hva())
    {
      h.OQ(248L);
      asX(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
      XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
    }
    AppMethodBeat.o(207311);
  }
  
  private static boolean huZ()
  {
    AppMethodBeat.i(154469);
    XWalkUpdater.try_generate_jar_for_dex_in_dir(XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), true);
    if (!a.hsb().nT("DIS_REMOVE_ODEX_IN_DEX_CRRUPTION", "tools")) {
      bsP(XWalkEnvironment.getVesionDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
    }
    if (com.tencent.xweb.util.c.bsB(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi())))
    {
      XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
      AppMethodBeat.o(154469);
      return true;
    }
    XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
    AppMethodBeat.o(154469);
    return false;
  }
  
  public static boolean hva()
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
    Object localObject1 = asZ(i);
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
    if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(i), (String)localObject1, XWalkUpdater.getResFileList(i))) {
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
        break label353;
      }
      h.OQ(253L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex dex cruppted");
      if (!com.tencent.xweb.util.c.bsB((String)localObject2)) {
        break label334;
      }
      if (!com.tencent.xweb.util.c.copyFile(str2, (String)localObject2)) {
        break label315;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace suc");
      bool = true;
      label298:
      huZ();
    }
    for (;;)
    {
      AppMethodBeat.o(154470);
      return bool;
      i = 0;
      break;
      label315:
      h.OQ(249L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace failed");
      bool = false;
      break label298;
      label334:
      h.OQ(250L);
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex delete cruppted dex failed");
      bool = false;
      break label298;
      label353:
      if (huZ())
      {
        h.OQ(254L);
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex suc");
        bool = true;
      }
      else
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex failed");
        h.OQ(255L);
        bool = false;
      }
    }
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(154474);
    if (SHH == null)
    {
      AppMethodBeat.o(154474);
      return false;
    }
    if ((g.hvR()) || (e.isBusy()))
    {
      AppMethodBeat.o(154474);
      return true;
    }
    AppMethodBeat.o(154474);
    return false;
  }
  
  public static void lG(Context paramContext)
  {
    AppMethodBeat.i(154463);
    Log.i("XWalkUpdaterImp", "try clear test setings");
    if (com.tencent.xweb.internal.c.cl("clear_test_settings", 2592000000L))
    {
      Log.i("XWalkUpdaterImp", "do start clear test setings");
      try
      {
        y.hsF().a("tools", WebView.c.SAs);
        y.hsF().a("appbrand", WebView.c.SAs);
        y.hsF().a("support", WebView.c.SAs);
        y.hsF().a("mm", WebView.c.SAs);
        y.hsF().a("toolsmp", WebView.c.SAs);
        y.hsF().b("tools", WebView.c.SAs);
        y.hsF().b("appbrand", WebView.c.SAs);
        y.hsF().b("support", WebView.c.SAs);
        y.hsF().b("mm", WebView.c.SAs);
        y.hsF().b("toolsmp", WebView.c.SAs);
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
  
  public final boolean C(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154476);
    new g(this.SHJ, paramHashMap).execute(new String[0]);
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
    hQ("finished", -2);
    g.hvT();
    c localc = ah.hte();
    if (localc != null) {
      localc.bXL();
    }
    AppMethodBeat.o(154479);
  }
  
  public void onXWalkUpdateCompleted(Scheduler paramScheduler)
  {
    AppMethodBeat.i(207314);
    hQ("finished", 0);
    g.a(paramScheduler);
    paramScheduler = ah.hte();
    if (paramScheduler != null) {
      paramScheduler.bXM();
    }
    AppMethodBeat.o(207314);
  }
  
  public void onXWalkUpdateFailed(int paramInt, Scheduler paramScheduler)
  {
    AppMethodBeat.i(207313);
    hQ("finished", -1);
    g.a(paramInt, paramScheduler);
    paramScheduler = ah.hte();
    if (paramScheduler != null) {
      paramScheduler.bXL();
    }
    AppMethodBeat.o(207313);
  }
  
  public void onXWalkUpdateProgress(int paramInt)
  {
    AppMethodBeat.i(154478);
    hQ("updating", paramInt);
    c localc = ah.hte();
    if (localc != null) {
      localc.zq(paramInt);
    }
    AppMethodBeat.o(154478);
  }
  
  public void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(154477);
    hQ("start", 0);
    g.hvS();
    ah.hte();
    AppMethodBeat.o(154477);
  }
  
  public static final class a
    implements w.b
  {
    public final void b(Context paramContext, HashMap<String, String> paramHashMap)
    {
      AppMethodBeat.i(154457);
      p.b(paramContext, paramHashMap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.p
 * JD-Core Version:    0.7.0.1
 */