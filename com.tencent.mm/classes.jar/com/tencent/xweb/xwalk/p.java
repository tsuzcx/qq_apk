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
import com.tencent.xweb.aj;
import com.tencent.xweb.f.a;
import com.tencent.xweb.f.c;
import com.tencent.xweb.internal.b;
import com.tencent.xweb.util.d;
import com.tencent.xweb.w.b;
import com.tencent.xweb.xwalk.b.i;
import com.tencent.xweb.xwalk.b.j;
import com.tencent.xweb.xwalk.b.k;
import com.tencent.xweb.y;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;

public class p
  implements XWalkUpdater.f, XWalkInitializer.XWalkInitListener
{
  static p aajz;
  XWalkInitializer aajA;
  XWalkUpdater aajB;
  protected Context mContext;
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(154475);
    this.mContext = paramContext;
    this.aajA = new XWalkInitializer(this, paramContext);
    this.aajB = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154475);
  }
  
  public static void IW(boolean paramBoolean)
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
    if ((paramBoolean) || (com.tencent.xweb.internal.c.cv("CHECK_FILES_MD5_TIME_KEY", 7200000L)))
    {
      Log.i("xwalkupimp", "checkFiles start check resfiles");
      localObject = XWalkEnvironment.getExtractedCoreDir(i);
      boolean bool2 = XWalkUpdater.aJ(XWalkEnvironment.getDownloadResFileListConfig(i), (String)localObject, i);
      int j;
      if (!bool2)
      {
        j = localSharedPreferences.getInt("LAST_CHECK_RES_VERSION", -1);
        localSharedPreferences.edit().putInt("LAST_CHECK_RES_VERSION", -1).commit();
        if (j == i) {
          break label270;
        }
        com.tencent.xweb.util.h.Xg(77L);
        XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", "some res corrupted at first time");
        com.tencent.xweb.util.h.Xg(76L);
      }
      Log.i("xwalkupimp", "checkFiles start check installed files");
      localObject = aCV(i);
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
        com.tencent.xweb.util.h.Xg(64L);
        XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", "some files corrupted at first time");
        label219:
        com.tencent.xweb.util.h.Xg(63L);
      }
      if ("true".equalsIgnoreCase(a.oO("disable_res_check", "tools"))) {
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
      XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", "some res corrupted");
      break;
      label280:
      Log.e("xwalkupimp", "checkfiles no config file");
      com.tencent.xweb.util.h.Xg(78L);
      if ("true".equalsIgnoreCase(a.oO("dis_config_file_check", "tools")))
      {
        XWalkInitializer.addXWalkInitializeLog("xwalkupimp", "dis_config_file_check ");
        paramBoolean = bool1;
        break label165;
      }
      paramBoolean = false;
      break label165;
      label325:
      paramBoolean = XWalkUpdater.c.a(i, (File)localObject);
      break label165;
      label335:
      XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", "some files corrupted");
      break label219;
      label345:
      XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", "ignore res files check");
    }
    label355:
    localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", i).commit();
    Log.i("xwalkupimp", "checkfiles parse");
    AppMethodBeat.o(154471);
  }
  
  public static void Q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(154460);
    if (XWalkEnvironment.getSharedPreferencesForUpdateConfig() == null)
    {
      AppMethodBeat.o(154460);
      return;
    }
    if ((paramBoolean) || (com.tencent.xweb.internal.c.cv("CLEAR_OLD_APK", 86400000L)))
    {
      if (paramContext != null) {}
      try
      {
        if ((paramContext.getApplicationInfo() != null) && (paramContext.getApplicationInfo().dataDir != null)) {
          break label97;
        }
        Log.e("xwalkupimp", "clearOldXWebCore failed , context");
        AppMethodBeat.o(154460);
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("xwalkupimp", "tryClearOldXWebCore failed " + paramContext.getMessage());
      }
    }
    else
    {
      AppMethodBeat.o(154460);
      return;
    }
    label97:
    paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    if (paramContext == null)
    {
      Log.e("xwalkupimp", "clearOldXWebCore failed , null == files ");
      AppMethodBeat.o(154460);
      return;
    }
    Object localObject = a.oO("KEEP_XWEB_CORE_LIST", "tools");
    Log.i("xwalkupimp", "dump KEEP_XWEB_CORE_LIST: ".concat(String.valueOf(localObject)));
    HashSet localHashSet = new HashSet();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if (localObject != null)
      {
        j = localObject.length;
        i = 0;
        if (i < j)
        {
          CharSequence localCharSequence = localObject[i];
          if ((TextUtils.isEmpty(localCharSequence)) || (TextUtils.isEmpty(localCharSequence.trim()))) {
            break label471;
          }
          localHashSet.add(localCharSequence.trim());
          break label471;
        }
      }
    }
    int m = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int n = paramContext.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k;
      if (j < n)
      {
        k = af(paramContext[j]);
        if ((k >= 0) && (k != m) && (k >= i))
        {
          i = k;
          break label478;
        }
      }
      else
      {
        k = XWalkEnvironment.getInstalledNewstVersion("armeabi-v7a");
        m = XWalkEnvironment.getInstalledNewstVersion("arm64-v8a");
        n = paramContext.length;
        j = 0;
        for (;;)
        {
          if (j < n)
          {
            localObject = paramContext[j];
            int i1 = af((File)localObject);
            if ((!localHashSet.contains(String.valueOf(i1))) && (i1 > 0) && (i1 < i))
            {
              int i2 = XWalkEnvironment.getAvailableVersion();
              if ((i1 == i2) || (i1 == k) || (i1 == m)) {}
            }
            try
            {
              com.tencent.xweb.util.c.bFA(((File)localObject).getAbsolutePath());
              XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", "cleared version = ".concat(String.valueOf(i1)));
              com.tencent.xweb.util.h.u(577L, 65L, 1L);
              j += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", " FileUtils.deleteAll failed " + localException.getMessage());
                com.tencent.xweb.util.h.u(577L, 66L, 1L);
              }
            }
          }
        }
        AppMethodBeat.o(154460);
        return;
      }
      break label478;
      label471:
      i += 1;
      break;
      label478:
      j += 1;
    }
  }
  
  public static boolean aCT(int paramInt)
  {
    AppMethodBeat.i(154462);
    Log.i("xwalkupimp", "clearVersion start , nVersion = ".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      Log.e("xwalkupimp", "clearVersion failed , nVersion is not valid ");
      AppMethodBeat.o(154462);
      return false;
    }
    Object localObject = XWalkEnvironment.getApplicationContext();
    if ((localObject == null) || (((Context)localObject).getApplicationInfo() == null) || (((Context)localObject).getApplicationInfo().dataDir == null))
    {
      Log.e("xwalkupimp", "clearVersion failed , context = null");
      AppMethodBeat.o(154462);
      return false;
    }
    localObject = new File(((Context)localObject).getApplicationInfo().dataDir).listFiles();
    if (localObject == null)
    {
      Log.e("xwalkupimp", "clearVersion failed , null == files ");
      AppMethodBeat.o(154462);
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      File localFile = localObject[i];
      int k = af(localFile);
      if ((k > 0) && (k == paramInt) && (com.tencent.xweb.util.c.bFA(localFile.getAbsolutePath())))
      {
        XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", "cleared version = ".concat(String.valueOf(k)));
        AppMethodBeat.o(154462);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(154462);
    return false;
  }
  
  private static boolean aCU(int paramInt)
  {
    AppMethodBeat.i(154465);
    File localFile = aCV(paramInt);
    if (localFile == null)
    {
      Log.e("xwalkupimp", "checkfiles no config file");
      AppMethodBeat.o(154465);
      return false;
    }
    boolean bool = XWalkUpdater.c.a(paramInt, localFile);
    AppMethodBeat.o(154465);
    return bool;
  }
  
  private static File aCV(int paramInt)
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
  
  private static int af(File paramFile)
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
        Log.e("xwalkupimp", "get apk version strApkVer  is ".concat(String.valueOf(paramFile)));
      }
    }
    AppMethodBeat.o(154466);
    return -1;
  }
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154459);
    if (aajz == null) {
      aajz = new p(paramContext);
    }
    com.tencent.xweb.util.h.ixF();
    String str = null;
    if (paramHashMap != null) {
      str = (String)paramHashMap.get("UpdaterCheckType");
    }
    if ("4".equals(str))
    {
      XWalkEnvironment.addXWalkInitializeLog("xwalkupimp", "check emebedinstall only");
      XWalkUpdater.iyL();
      AppMethodBeat.o(154459);
      return;
    }
    XWalkUpdater.iyL();
    aajz.z(paramHashMap);
    com.tencent.xweb.xwalk.b.f.mG(paramContext);
    AppMethodBeat.o(154459);
  }
  
  private static void bFQ(String paramString)
  {
    AppMethodBeat.i(204980);
    paramString = new File(paramString);
    if (!paramString.isDirectory())
    {
      AppMethodBeat.o(204980);
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
        com.tencent.xweb.util.c.ae(localFile);
        Log.i("xwalkupimp", "removeOptDexRecursively remove oat dir " + localFile.getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break;
        label102:
        if (localFile.getName().endsWith(".odex"))
        {
          com.tencent.xweb.util.c.ae(localFile);
          Log.i("xwalkupimp", "removeOptDexRecursively remove odex file " + localFile.getAbsolutePath());
        }
        else if (localFile.getName().endsWith(".vdex"))
        {
          com.tencent.xweb.util.c.ae(localFile);
          Log.i("xwalkupimp", "removeOptDexRecursively remove vdex file " + localFile.getAbsolutePath());
        }
        else if (localFile.isDirectory())
        {
          bFQ(localFile.getAbsolutePath());
        }
      }
    }
    AppMethodBeat.o(204980);
  }
  
  private static void bd(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154467);
    Log.i("xwalkupimp", "tryAbandonThisVersion scene  is ".concat(String.valueOf(paramString)));
    long l1 = b.c(paramString, WebView.c.aabm).aaeI;
    if (!"true".equalsIgnoreCase(a.oO("enable_reinstall_for_crash_at_".concat(String.valueOf(paramString)), "tools")))
    {
      AppMethodBeat.o(154467);
      return;
    }
    if (l1 >= 15L)
    {
      paramString = "LAST_" + paramString + "_ABANDON_COUNT";
      long l2 = XWalkEnvironment.getSharedPreferencesForXWEBUpdater().getLong(paramString, 100000L);
      Log.i("xwalkupimp", "tryAbandonThisVersion try count = " + l1 + ",  last abandon count = " + l2);
      if (l1 < l2)
      {
        Log.i("xwalkupimp", "tryAbandonThisVersion should abandon this version ");
        try
        {
          aCT(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
          XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
          XWalkEnvironment.getSharedPreferencesForXWEBUpdater().edit().putLong(paramString, l1).commit();
          com.tencent.xweb.util.h.Xg(paramInt1);
          AppMethodBeat.o(154467);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("xwalkupimp", "clear version failed , errmsg:" + paramString.getMessage());
          AppMethodBeat.o(154467);
          return;
        }
      }
      if (l1 - 2L > l2)
      {
        Log.i("xwalkupimp", "tryAbandonThisVersion cant not fix ");
        com.tencent.xweb.util.h.Xg(paramInt2);
      }
    }
    AppMethodBeat.o(154467);
  }
  
  public static int bq(Context paramContext, int paramInt)
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
      int i1 = af(paramContext[m]);
      k = j;
      if (i1 < 0) {
        break label388;
      }
      if (i1 == paramInt) {
        j = 1;
      }
      k = j;
      if (i1 > paramInt) {
        break label388;
      }
      k = j;
      if (i1 < 2000) {
        break label388;
      }
      k = j;
      if (i1 == i2) {
        break label388;
      }
      k = j;
      if (i1 <= i) {
        break label388;
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
          if (aCU(paramInt))
          {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
            i = paramInt;
          }
        }
        label379:
        for (;;)
        {
          if (i == paramInt) {
            com.tencent.xweb.util.h.Xg(89L);
          }
          for (;;)
          {
            XWalkEnvironment.addXWalkInitializeLog("revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i);
            XWalkEnvironment.setAvailableVersion(i, "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i, XWalkEnvironment.getRuntimeAbi());
            AppMethodBeat.o(154464);
            return i;
            if (aCU(i)) {
              break label379;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer did not find target version:".concat(String.valueOf(paramInt)));
            if (aCU(i)) {
              break label379;
            }
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            if (i > 0) {
              com.tencent.xweb.util.h.Xg(90L);
            } else if (k != 0) {
              com.tencent.xweb.util.h.Xg(92L);
            } else {
              com.tencent.xweb.util.h.Xg(91L);
            }
          }
        }
      }
      label388:
      j = k;
    }
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(154474);
    if (aajz == null)
    {
      AppMethodBeat.o(154474);
      return false;
    }
    if ((Math.abs(System.currentTimeMillis() - i.izT()) < 10000L) || (com.tencent.xweb.xwalk.b.h.izO()) || (com.tencent.xweb.xwalk.b.f.isBusy()))
    {
      AppMethodBeat.o(154474);
      return true;
    }
    AppMethodBeat.o(154474);
    return false;
  }
  
  public static void iyP()
  {
    AppMethodBeat.i(204978);
    if (!com.tencent.xweb.internal.c.cv("should_try_generate_jar", 172800000L))
    {
      AppMethodBeat.o(204978);
      return;
    }
    XWalkUpdater.p(XWalkEnvironment.getInstalledNewstVersionForCurAbi(), XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), false);
    AppMethodBeat.o(204978);
  }
  
  static void iyQ()
  {
    AppMethodBeat.i(154468);
    bd("LOAD_CORE", 243, 244);
    bd("CREATE_WEBVIEW", 245, 246);
    AppMethodBeat.o(154468);
  }
  
  public static void iyR()
  {
    int j = 1;
    AppMethodBeat.i(204979);
    if (b.c("LOAD_CORE", WebView.c.aabm).aaeI >= 6L) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.xweb.util.h.Xg(252L);
      if (!"true".equalsIgnoreCase(a.oO("enable_check_dex", "tools"))) {
        break;
      }
      i = j;
      if (i != 0) {
        break label132;
      }
      AppMethodBeat.o(204979);
      return;
    }
    if (b.c("CREATE_WEBVIEW", WebView.c.aabm).aaeI >= 6L) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.xweb.util.h.Xg(247L);
        i = j;
        if ("true".equalsIgnoreCase(a.oO("enable_check_dex_new_web", "tools"))) {
          break;
        }
      }
      i = 0;
      break;
    }
    label132:
    if (!com.tencent.xweb.internal.c.cv("check_need_fix_dex", 43200000L))
    {
      AppMethodBeat.o(204979);
      return;
    }
    iyQ();
    if (!iyT())
    {
      com.tencent.xweb.util.h.Xg(248L);
      aCT(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
      XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
    }
    AppMethodBeat.o(204979);
  }
  
  private static boolean iyS()
  {
    AppMethodBeat.i(154469);
    XWalkUpdater.p(XWalkEnvironment.getInstalledNewstVersionForCurAbi(), XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), true);
    if (!a.ivJ().oP("DIS_REMOVE_ODEX_IN_DEX_CRRUPTION", "tools")) {
      bFQ(XWalkEnvironment.getVesionDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
    }
    if (com.tencent.xweb.util.c.bFA(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi())))
    {
      XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
      AppMethodBeat.o(154469);
      return true;
    }
    XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
    AppMethodBeat.o(154469);
    return false;
  }
  
  public static boolean iyT()
  {
    AppMethodBeat.i(154470);
    int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    if (i <= 0)
    {
      Log.i("xwalkupimp", "doFixDex stopped , because no xweb currently");
      AppMethodBeat.o(154470);
      return false;
    }
    Log.i("xwalkupimp", "doFixDex start");
    Object localObject1 = aCV(i);
    if (localObject1 == null)
    {
      Log.e("xwalkupimp", "doFixDex checkfiles no config file");
      AppMethodBeat.o(154470);
      return false;
    }
    if (!XWalkUpdater.c.a(i, (File)localObject1))
    {
      Log.e("xwalkupimp", "doFixDex checkFileListMd5 failed");
      AppMethodBeat.o(154470);
      return false;
    }
    String str1 = XWalkEnvironment.getExtractedCoreDir(i);
    localObject1 = XWalkEnvironment.getExtractedCoreDir(i) + "_bk";
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(i), (String)localObject1, XWalkUpdater.aCQ(i))) {
      XWalkInitializer.addXWalkInitializeLog("xwalkupimp", " doFixDex extract faield");
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
      com.tencent.xweb.util.h.Xg(253L);
      XWalkInitializer.addXWalkInitializeLog("xwalkupimp", " doFixDex dex cruppted");
      if (!com.tencent.xweb.util.c.bFA((String)localObject2)) {
        break label334;
      }
      if (!com.tencent.xweb.util.c.copyFile(str2, (String)localObject2)) {
        break label315;
      }
      XWalkInitializer.addXWalkInitializeLog("xwalkupimp", " doFixDex copy dex to replace suc");
      bool = true;
      label298:
      iyS();
    }
    for (;;)
    {
      AppMethodBeat.o(154470);
      return bool;
      i = 0;
      break;
      label315:
      com.tencent.xweb.util.h.Xg(249L);
      XWalkInitializer.addXWalkInitializeLog("xwalkupimp", " doFixDex copy dex to replace failed");
      bool = false;
      break label298;
      label334:
      com.tencent.xweb.util.h.Xg(250L);
      XWalkInitializer.addXWalkInitializeLog("xwalkupimp", " doFixDex delete cruppted dex failed");
      bool = false;
      break label298;
      label353:
      if (iyS())
      {
        com.tencent.xweb.util.h.Xg(254L);
        XWalkInitializer.addXWalkInitializeLog("xwalkupimp", "doFixDex try remove  opt dex suc");
        bool = true;
      }
      else
      {
        XWalkInitializer.addXWalkInitializeLog("xwalkupimp", "doFixDex try remove  opt dex failed");
        com.tencent.xweb.util.h.Xg(255L);
        bool = false;
      }
    }
  }
  
  public static void iz(String paramString, int paramInt)
  {
    AppMethodBeat.i(185201);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.xweb.update");
    localIntent.putExtra("stage", paramString);
    localIntent.putExtra("extra_data", paramInt);
    XWalkEnvironment.getApplicationContext().sendBroadcast(localIntent);
    AppMethodBeat.o(185201);
  }
  
  public static void mD(Context paramContext)
  {
    AppMethodBeat.i(154463);
    Log.i("xwalkupimp", "try clear test setings");
    if (com.tencent.xweb.internal.c.cv("clear_test_settings", 2592000000L))
    {
      Log.i("xwalkupimp", "do start clear test setings");
      try
      {
        y.iwp().a("tools", WebView.c.aabl);
        y.iwp().a("appbrand", WebView.c.aabl);
        y.iwp().a("support", WebView.c.aabl);
        y.iwp().a("mm", WebView.c.aabl);
        y.iwp().a("toolsmp", WebView.c.aabl);
        y.iwp().b("tools", WebView.c.aabl);
        y.iwp().b("appbrand", WebView.c.aabl);
        y.iwp().b("support", WebView.c.aabl);
        y.iwp().b("mm", WebView.c.aabl);
        y.iwp().b("toolsmp", WebView.c.aabl);
        y.iwp().a(com.tencent.xweb.f.ZZI, f.a.ZZK);
        y.iwp().a(com.tencent.xweb.f.ZZI, f.c.ZZP);
        XWalkEnvironment.setTestDownLoadUrl(paramContext, null);
        XWalkEnvironment.setPluginTestConfigUrl("");
        XWalkEnvironment.setGrayValueForTest(0);
        AppMethodBeat.o(154463);
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("xwalkupimp", "do start clear test setings got exp = " + paramContext.getMessage());
      }
    }
    AppMethodBeat.o(154463);
  }
  
  public final void a(int paramInt, com.tencent.xweb.xwalk.b.c paramc)
  {
    AppMethodBeat.i(204983);
    iz("finished", -1);
    com.tencent.xweb.xwalk.b.h.b(paramInt, paramc);
    paramc = aj.iwM();
    if (paramc != null) {
      paramc.ckv();
    }
    AppMethodBeat.o(204983);
  }
  
  public final void a(com.tencent.xweb.xwalk.b.c paramc)
  {
    AppMethodBeat.i(204984);
    iz("finished", 0);
    com.tencent.xweb.xwalk.b.h.b(paramc);
    paramc = aj.iwM();
    if (paramc != null) {
      paramc.ckw();
    }
    AppMethodBeat.o(204984);
  }
  
  public final void aCS(int paramInt)
  {
    AppMethodBeat.i(154478);
    iz("updating", paramInt);
    c localc = aj.iwM();
    if (localc != null) {
      localc.CT(paramInt);
    }
    AppMethodBeat.o(154478);
  }
  
  public final void iyN()
  {
    AppMethodBeat.i(154477);
    iz("start", 0);
    com.tencent.xweb.xwalk.b.h.izP();
    aj.iwM();
    AppMethodBeat.o(154477);
  }
  
  public final void iyO()
  {
    AppMethodBeat.i(154479);
    iz("finished", -2);
    com.tencent.xweb.xwalk.b.h.izQ();
    c localc = aj.iwM();
    if (localc != null) {
      localc.ckv();
    }
    AppMethodBeat.o(154479);
  }
  
  public void onXWalkInitCancelled() {}
  
  public void onXWalkInitCompleted() {}
  
  public void onXWalkInitFailed() {}
  
  public void onXWalkInitStarted() {}
  
  public final boolean z(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154476);
    new com.tencent.xweb.xwalk.b.h(this.aajB, paramHashMap).execute(new String[0]);
    AppMethodBeat.o(154476);
    return false;
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
    
    public final boolean iwo()
    {
      AppMethodBeat.i(206836);
      if ((com.tencent.xweb.xwalk.b.h.izR()) || (k.izV().IZ(false)) || (j.izU().IZ(false)))
      {
        AppMethodBeat.o(206836);
        return true;
      }
      AppMethodBeat.o(206836);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.p
 * JD-Core Version:    0.7.0.1
 */