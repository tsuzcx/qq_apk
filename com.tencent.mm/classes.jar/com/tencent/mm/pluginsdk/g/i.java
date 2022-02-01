package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.d.a;
import com.tencent.mm.d.b;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.util.List;

public final class i
{
  private static final long[] Dka = { 0L, 259200000L, 604800000L };
  private static String tGA = "tinker-boots-last-show";
  private static String tGB = "tinker-boots-show-time";
  private static String tGC = "";
  private static String tGz = "tinker-boots-install-info";
  
  public static void aH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31145);
    r.b(paramContext, paramString, null, false);
    AppMethodBeat.o(31145);
  }
  
  public static boolean eLA()
  {
    AppMethodBeat.i(31141);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("update_config_prefs", g.YK());
    long l1 = localSharedPreferences.getLong("update_downloaded_cancel_ts", 0L);
    int i = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    ac.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i > Dka.length - 1)
    {
      AppMethodBeat.o(31141);
      return true;
    }
    long l2 = Dka[i];
    if (System.currentTimeMillis() - l1 > l2)
    {
      AppMethodBeat.o(31141);
      return false;
    }
    if (System.currentTimeMillis() - l1 < 0L)
    {
      ac.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
      ai.getContext().getSharedPreferences("update_config_prefs", g.YK()).edit().clear().commit();
      ac.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
      AppMethodBeat.o(31141);
      return true;
    }
    AppMethodBeat.o(31141);
    return true;
  }
  
  public static boolean eLB()
  {
    AppMethodBeat.i(31142);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("update_config_prefs", g.YK());
    long l = localSharedPreferences.getLong("update_downloading_in_silence", 0L);
    boolean bool = localSharedPreferences.getBoolean("update_download_start_one_immediate", false);
    ac.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", new Object[] { Long.valueOf(l) });
    if ((bool) || ((l != 0L) && (System.currentTimeMillis() - l > 3600000L)))
    {
      AppMethodBeat.o(31142);
      return true;
    }
    AppMethodBeat.o(31142);
    return false;
  }
  
  public static dhl eLC()
  {
    AppMethodBeat.i(31146);
    Object localObject2 = ai.getContext().getSharedPreferences("tinker_patch_share_config", g.YK()).getString(tGz, "");
    if (!bs.isNullOrNil((String)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject1 = new dhl();
        ac.printErrStackTrace("MicroMsg.UpdateUtil", localException1, "parse tinker install failed.", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (dhl)((dhl)localObject1).parseFrom(Base64.decode((String)localObject2, 0));
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
      ac.i("MicroMsg.UpdateUtil", "update info is null.");
      AppMethodBeat.o(31146);
      return null;
      Object localObject1 = null;
    }
  }
  
  public static boolean eLD()
  {
    AppMethodBeat.i(31147);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("tinker_patch_share_config", g.YK());
    long l1 = localSharedPreferences.getLong(tGA, 0L);
    int i = localSharedPreferences.getInt(tGB, 0);
    long l2 = System.currentTimeMillis();
    ac.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
    if ((l2 - l1 > 21600000L) && (i < 3))
    {
      AppMethodBeat.o(31147);
      return true;
    }
    AppMethodBeat.o(31147);
    return false;
  }
  
  public static void eLE()
  {
    AppMethodBeat.i(31148);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("tinker_patch_share_config", g.YK());
    localSharedPreferences.edit().putLong(tGA, System.currentTimeMillis()).apply();
    int i = localSharedPreferences.getInt(tGB, 0);
    localSharedPreferences.edit().putInt(tGB, i + 1).apply();
    AppMethodBeat.o(31148);
  }
  
  public static String eLy()
  {
    AppMethodBeat.i(31139);
    String str = ai.getContext().getSharedPreferences("update_config_prefs", g.YK()).getString("update_downloaded_pack_md5_key", null);
    AppMethodBeat.o(31139);
    return str;
  }
  
  public static int eLz()
  {
    AppMethodBeat.i(31140);
    int i = ai.getContext().getSharedPreferences("update_config_prefs", g.YK()).getInt("update_downloaded_pack_update_type", 3);
    AppMethodBeat.o(31140);
    return i;
  }
  
  public static String fz(Context paramContext)
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
      ac.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(31144);
    }
    return null;
  }
  
  public static String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(31149);
    if ((ab.ivp != null) && (ab.ivp.length() > 0))
    {
      localObject = ab.ivp;
      AppMethodBeat.o(31149);
      return new String[] { localObject };
    }
    Object localObject = ai.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.aIA((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).tWE;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    AppMethodBeat.o(31149);
    return arrayOfString;
  }
  
  public static String hr(Context paramContext)
  {
    AppMethodBeat.i(31143);
    paramContext = fz(paramContext);
    if ((paramContext == null) || (!new e(paramContext).exists()))
    {
      AppMethodBeat.o(31143);
      return null;
    }
    a locala = a.ea(paramContext);
    if ((locala != null) && (locala.cGV != null))
    {
      paramContext = locala.cGV.apkMd5;
      AppMethodBeat.o(31143);
      return paramContext;
    }
    paramContext = com.tencent.mm.vfs.i.aKe(paramContext);
    AppMethodBeat.o(31143);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.i
 * JD-Core Version:    0.7.0.1
 */