package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.c.b;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.List;

public final class i
{
  private static String nKX = "tinker-boots-install-info";
  private static String nKY = "tinker-boots-last-show";
  private static String nKZ = "tinker-boots-show-time";
  private static String nLa = "";
  private static final long[] vMJ = { 0L, 259200000L, 604800000L };
  
  public static void aC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(27443);
    q.a(paramContext, new File(paramString), null, false);
    AppMethodBeat.o(27443);
  }
  
  public static String dlS()
  {
    AppMethodBeat.i(27437);
    String str = ah.getContext().getSharedPreferences("update_config_prefs", h.Mp()).getString("update_downloaded_pack_md5_key", null);
    AppMethodBeat.o(27437);
    return str;
  }
  
  public static int dlT()
  {
    AppMethodBeat.i(27438);
    int i = ah.getContext().getSharedPreferences("update_config_prefs", h.Mp()).getInt("update_downloaded_pack_update_type", 3);
    AppMethodBeat.o(27438);
    return i;
  }
  
  public static boolean dlU()
  {
    AppMethodBeat.i(27439);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("update_config_prefs", h.Mp());
    long l1 = localSharedPreferences.getLong("update_downloaded_cancel_ts", 0L);
    int i = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    ab.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i > vMJ.length - 1)
    {
      AppMethodBeat.o(27439);
      return true;
    }
    long l2 = vMJ[i];
    if (System.currentTimeMillis() - l1 > l2)
    {
      AppMethodBeat.o(27439);
      return false;
    }
    if (System.currentTimeMillis() - l1 < 0L)
    {
      ab.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
      ah.getContext().getSharedPreferences("update_config_prefs", h.Mp()).edit().clear().commit();
      ab.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
      AppMethodBeat.o(27439);
      return true;
    }
    AppMethodBeat.o(27439);
    return true;
  }
  
  public static boolean dlV()
  {
    AppMethodBeat.i(27440);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("update_config_prefs", h.Mp());
    long l = localSharedPreferences.getLong("update_downloading_in_silence", 0L);
    boolean bool = localSharedPreferences.getBoolean("update_download_start_one_immediate", false);
    ab.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", new Object[] { Long.valueOf(l) });
    if ((bool) || ((l != 0L) && (System.currentTimeMillis() - l > 3600000L)))
    {
      AppMethodBeat.o(27440);
      return true;
    }
    AppMethodBeat.o(27440);
    return false;
  }
  
  public static ckf dlW()
  {
    AppMethodBeat.i(27444);
    Object localObject2 = ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mp()).getString(nKX, "");
    if (!bo.isNullOrNil((String)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject1 = new ckf();
        ab.printErrStackTrace("MicroMsg.UpdateUtil", localException1, "parse tinker install failed.", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (ckf)((ckf)localObject1).parseFrom(Base64.decode((String)localObject2, 0));
          localObject1 = localObject2;
          if (localObject1 == null) {
            break label88;
          }
          AppMethodBeat.o(27444);
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
      ab.i("MicroMsg.UpdateUtil", "update info is null.");
      AppMethodBeat.o(27444);
      return null;
      Object localObject1 = null;
    }
  }
  
  public static boolean dlX()
  {
    AppMethodBeat.i(27445);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mp());
    long l1 = localSharedPreferences.getLong(nKY, 0L);
    int i = localSharedPreferences.getInt(nKZ, 0);
    long l2 = System.currentTimeMillis();
    ab.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
    if ((l2 - l1 > 21600000L) && (i < 3))
    {
      AppMethodBeat.o(27445);
      return true;
    }
    AppMethodBeat.o(27445);
    return false;
  }
  
  public static void dlY()
  {
    AppMethodBeat.i(27446);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mp());
    localSharedPreferences.edit().putLong(nKY, System.currentTimeMillis()).apply();
    int i = localSharedPreferences.getInt(nKZ, 0);
    localSharedPreferences.edit().putInt(nKZ, i + 1).apply();
    AppMethodBeat.o(27446);
  }
  
  public static String er(Context paramContext)
  {
    AppMethodBeat.i(27442);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.sourceDir;
      AppMethodBeat.o(27442);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.UpdateUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(27442);
    }
    return null;
  }
  
  public static String fU(Context paramContext)
  {
    AppMethodBeat.i(27441);
    paramContext = er(paramContext);
    if ((paramContext == null) || (!new File(paramContext).exists()))
    {
      AppMethodBeat.o(27441);
      return null;
    }
    a locala = a.dn(paramContext);
    if ((locala != null) && (locala.bWr != null))
    {
      paramContext = locala.bWr.apkMd5;
      AppMethodBeat.o(27441);
      return paramContext;
    }
    paramContext = g.getMD5(paramContext);
    AppMethodBeat.o(27441);
    return paramContext;
  }
  
  public static String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(27447);
    if ((ae.gkt != null) && (ae.gkt.length() > 0))
    {
      localObject = ae.gkt;
      AppMethodBeat.o(27447);
      return new String[] { localObject };
    }
    Object localObject = ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.ano((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).nZR;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    AppMethodBeat.o(27447);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.i
 * JD-Core Version:    0.7.0.1
 */