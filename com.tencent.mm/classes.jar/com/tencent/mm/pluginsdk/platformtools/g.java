package com.tencent.mm.pluginsdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.d.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.fne;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
{
  private static String JEQ;
  private static String JER;
  private static String JES;
  private static String JET;
  private static final Map<String, String> XUT;
  private static final long[] XUU;
  private static String XUV;
  
  static
  {
    AppMethodBeat.i(244706);
    XUT = new ConcurrentHashMap();
    XUU = new long[] { 0L, 259200000L, 604800000L };
    JEQ = "tinker-boots-install-info";
    JER = "tinker-boots-last-show";
    JES = "tinker-boots-show-time";
    JET = "hdiff-boots-install-info";
    XUV = "";
    AppMethodBeat.o(244706);
  }
  
  public static void bn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31145);
    v.b(paramContext, paramString, null, false);
    AppMethodBeat.o(31145);
  }
  
  private static String bqe(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(244664);
    if ((paramString == null) || (!new u(paramString).jKS()))
    {
      AppMethodBeat.o(244664);
      return null;
    }
    if (XUT.containsKey(paramString))
    {
      paramString = (String)XUT.get(paramString);
      AppMethodBeat.o(244664);
      return paramString;
    }
    synchronized (XUT)
    {
      if (XUT.containsKey(paramString))
      {
        paramString = (String)XUT.get(paramString);
        AppMethodBeat.o(244664);
        return paramString;
      }
      Object localObject1 = localObject2;
      if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion <= 29)
      {
        a locala = a.hY(paramString);
        localObject1 = localObject2;
        if (locala != null)
        {
          localObject1 = localObject2;
          if (locala.hem != null) {
            localObject1 = locala.hem.apkMd5;
          }
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = y.bub(paramString);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        XUT.put(paramString, localObject2);
      }
      AppMethodBeat.o(244664);
      return localObject2;
    }
  }
  
  public static fne fQq()
  {
    AppMethodBeat.i(31146);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", com.tencent.mm.compatible.util.g.aQe()).getString(JEQ, "");
    if (!Util.isNullOrNil((String)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject1 = new fne();
        Log.printErrStackTrace("MicroMsg.UpdateUtil", localException1, "parse tinker install failed.", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (fne)((fne)localObject1).parseFrom(Base64.decode((String)localObject2, 0));
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label88;
          }
          AppMethodBeat.o(31146);
          return localObject1;
        }
        catch (Exception localException2)
        {
          break label73;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label73:
      continue;
      label88:
      Log.i("MicroMsg.UpdateUtil", "update info is null.");
      AppMethodBeat.o(31146);
      return null;
      Object localObject1 = null;
    }
  }
  
  public static boolean fQr()
  {
    AppMethodBeat.i(31147);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", com.tencent.mm.compatible.util.g.aQe());
    long l1 = localSharedPreferences.getLong(JER, 0L);
    int i = localSharedPreferences.getInt(JES, 0);
    long l2 = System.currentTimeMillis();
    Log.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
    if ((l2 - l1 > 21600000L) && (i < 3))
    {
      AppMethodBeat.o(31147);
      return true;
    }
    AppMethodBeat.o(31147);
    return false;
  }
  
  public static void fQs()
  {
    AppMethodBeat.i(31148);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", com.tencent.mm.compatible.util.g.aQe());
    localSharedPreferences.edit().putLong(JER, System.currentTimeMillis()).apply();
    int i = localSharedPreferences.getInt(JES, 0);
    localSharedPreferences.edit().putInt(JES, i + 1).apply();
    AppMethodBeat.o(31148);
  }
  
  public static String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(31149);
    if ((z.pBU != null) && (z.pBU.length() > 0))
    {
      localObject = z.pBU;
      AppMethodBeat.o(31149);
      return new String[] { localObject };
    }
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.bsm((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).KbS;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    AppMethodBeat.o(31149);
    return arrayOfString;
  }
  
  public static String iH(Context paramContext)
  {
    AppMethodBeat.i(31144);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      AppMethodBeat.o(31144);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(31144);
    }
    return null;
  }
  
  public static String iIZ()
  {
    AppMethodBeat.i(31139);
    String str = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getString("update_downloaded_pack_md5_key", null);
    AppMethodBeat.o(31139);
    return str;
  }
  
  public static int iJa()
  {
    AppMethodBeat.i(31140);
    int i = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getInt("update_downloaded_pack_update_type", 3);
    AppMethodBeat.o(31140);
    return i;
  }
  
  public static boolean iJb()
  {
    AppMethodBeat.i(31141);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aQe());
    long l1 = localSharedPreferences.getLong("update_downloaded_cancel_ts", 0L);
    int i = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    Log.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i > XUU.length - 1)
    {
      AppMethodBeat.o(31141);
      return true;
    }
    long l2 = XUU[i];
    if (System.currentTimeMillis() - l1 > l2)
    {
      AppMethodBeat.o(31141);
      return false;
    }
    if (System.currentTimeMillis() - l1 < 0L)
    {
      Log.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
      MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().clear().commit();
      Log.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
      AppMethodBeat.o(31141);
      return true;
    }
    AppMethodBeat.o(31141);
    return true;
  }
  
  public static boolean iJc()
  {
    AppMethodBeat.i(31142);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aQe());
    long l = localSharedPreferences.getLong("update_downloading_in_silence", 0L);
    boolean bool = localSharedPreferences.getBoolean("update_download_start_one_immediate", false);
    Log.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", new Object[] { Long.valueOf(l) });
    if ((bool) || ((l != 0L) && (System.currentTimeMillis() - l > 3600000L)))
    {
      AppMethodBeat.o(31142);
      return true;
    }
    AppMethodBeat.o(31142);
    return false;
  }
  
  public static String ju(Context paramContext)
  {
    AppMethodBeat.i(31143);
    paramContext = bqe(iH(paramContext));
    AppMethodBeat.o(31143);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.platformtools.g
 * JD-Core Version:    0.7.0.1
 */