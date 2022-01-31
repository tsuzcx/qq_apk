package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.c.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.List;

public final class i
{
  private static final long[] rVO = { 0L, 259200000L, 604800000L };
  private static String rVP = "tinker-boots-install-info";
  private static String rVQ = "tinker-boots-last-show";
  private static String rVR = "tinker-boots-show-time";
  private static String rVS = "";
  
  public static String We(String paramString)
  {
    return clr() + paramString + ".apk";
  }
  
  public static void a(bxs parambxs)
  {
    try
    {
      com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("tinker_patch_share_config", 4).edit().putString(rVP, Base64.encodeToString(parambxs.toByteArray(), 0)).apply();
      y.d("MicroMsg.UpdateUtil", "save tinker install update info.");
      return;
    }
    catch (Exception parambxs)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.UpdateUtil", parambxs, "", new Object[0]);
      }
    }
  }
  
  public static void bl(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
    paramContext.startActivity(localIntent);
  }
  
  public static String cli()
  {
    return com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
  }
  
  public static int clj()
  {
    return com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("update_config_prefs", 4).getInt("update_downloaded_pack_update_type", 3);
  }
  
  public static boolean clk()
  {
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("update_config_prefs", 4);
    long l1 = localSharedPreferences.getLong("update_downloaded_cancel_ts", 0L);
    int i = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    y.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i > rVO.length - 1) {}
    do
    {
      return true;
      long l2 = rVO[i];
      if (System.currentTimeMillis() - l1 > l2) {
        return false;
      }
    } while (System.currentTimeMillis() - l1 >= 0L);
    y.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
    y.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
    return true;
  }
  
  public static boolean cll()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("update_config_prefs", 4);
    long l = localSharedPreferences.getLong("update_downloading_in_silence", 0L);
    boolean bool1 = localSharedPreferences.getBoolean("update_download_start_one_immediate", false);
    y.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", new Object[] { Long.valueOf(l) });
    if (!bool1)
    {
      bool1 = bool2;
      if (l != 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() - l <= 3600000L) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static bxs clm()
  {
    Object localObject2 = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString(rVP, "");
    if (!bk.bl((String)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject1 = new bxs();
        y.printErrStackTrace("MicroMsg.UpdateUtil", localException1, "parse tinker install failed.", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (bxs)((bxs)localObject1).aH(Base64.decode((String)localObject2, 0));
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label74;
          }
          return localObject1;
        }
        catch (Exception localException2)
        {
          break label59;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label59:
      continue;
      label74:
      y.i("MicroMsg.UpdateUtil", "update info is null.");
      return null;
      Object localObject1 = null;
    }
  }
  
  public static boolean cln()
  {
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("tinker_patch_share_config", 4);
    long l1 = localSharedPreferences.getLong(rVQ, 0L);
    int i = localSharedPreferences.getInt(rVR, 0);
    long l2 = System.currentTimeMillis();
    y.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
    return (l2 - l1 > 21600000L) && (i < 3);
  }
  
  public static void clo()
  {
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("tinker_patch_share_config", 4);
    localSharedPreferences.edit().putLong(rVQ, System.currentTimeMillis()).apply();
    int i = localSharedPreferences.getInt(rVR, 0);
    localSharedPreferences.edit().putInt(rVR, i + 1).apply();
  }
  
  public static void clp()
  {
    y.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
    SharedPreferences localSharedPreferences = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("tinker_patch_share_config", 4);
    localSharedPreferences.edit().putString(rVP, "").apply();
    localSharedPreferences.edit().putLong(rVQ, 0L).apply();
    localSharedPreferences.edit().putInt(rVR, 0).apply();
  }
  
  public static void clq()
  {
    au.DS().O(new i.1());
  }
  
  public static String clr()
  {
    if (bk.bl(rVS)) {
      rVS = e.dzB + "bsdiff/";
    }
    return rVS;
  }
  
  public static String eU(Context paramContext)
  {
    paramContext = eV(paramContext);
    if ((paramContext == null) || (!new File(paramContext).exists())) {
      return null;
    }
    a locala = a.cc(paramContext);
    if ((locala != null) && (locala.bvg != null)) {
      return locala.bvg.apkMd5;
    }
    return g.bQ(paramContext);
  }
  
  public static String eV(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static String[] getShortIps()
  {
    int i = 0;
    if ((com.tencent.mm.platformtools.ae.eSy != null) && (com.tencent.mm.platformtools.ae.eSy.length() > 0)) {
      return new String[] { com.tencent.mm.platformtools.ae.eSy };
    }
    Object localObject = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = n.Xs((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((n)((List)localObject).get(i)).lCF;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.i
 * JD-Core Version:    0.7.0.1
 */