package com.tencent.mm.pluginsdk.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.d.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.List;

public final class g
{
  private static String DNC = "tinker-boots-install-info";
  private static String DND = "tinker-boots-last-show";
  private static String DNE = "tinker-boots-show-time";
  private static String DNF = "";
  private static final long[] QYT = { 0L, 259200000L, 604800000L };
  
  public static void bl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31145);
    r.b(paramContext, paramString, null, false);
    AppMethodBeat.o(31145);
  }
  
  public static String[] getShortIps()
  {
    int i = 0;
    AppMethodBeat.i(31149);
    if ((ac.mFt != null) && (ac.mFt.length() > 0))
    {
      localObject = ac.mFt;
      AppMethodBeat.o(31149);
      return new String[] { localObject };
    }
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    String[] arrayOfString;
    for (;;)
    {
      localObject = o.bsv((String)localObject);
      arrayOfString = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfString[i] = ((o)((List)localObject).get(i)).Ejj;
        i += 1;
      }
      localObject = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
    }
    AppMethodBeat.o(31149);
    return arrayOfString;
  }
  
  public static String hhZ()
  {
    AppMethodBeat.i(31139);
    String str = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.avK()).getString("update_downloaded_pack_md5_key", null);
    AppMethodBeat.o(31139);
    return str;
  }
  
  public static int hia()
  {
    AppMethodBeat.i(31140);
    int i = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.avK()).getInt("update_downloaded_pack_update_type", 3);
    AppMethodBeat.o(31140);
    return i;
  }
  
  public static boolean hib()
  {
    AppMethodBeat.i(31141);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.avK());
    long l1 = localSharedPreferences.getLong("update_downloaded_cancel_ts", 0L);
    int i = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    Log.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i) });
    if (i > QYT.length - 1)
    {
      AppMethodBeat.o(31141);
      return true;
    }
    long l2 = QYT[i];
    if (System.currentTimeMillis() - l1 > l2)
    {
      AppMethodBeat.o(31141);
      return false;
    }
    if (System.currentTimeMillis() - l1 < 0L)
    {
      Log.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
      MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.avK()).edit().clear().commit();
      Log.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
      AppMethodBeat.o(31141);
      return true;
    }
    AppMethodBeat.o(31141);
    return true;
  }
  
  public static boolean hic()
  {
    AppMethodBeat.i(31142);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.avK());
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
  
  public static erv hid()
  {
    AppMethodBeat.i(31146);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", com.tencent.mm.compatible.util.g.avK()).getString(DNC, "");
    if (!Util.isNullOrNil((String)localObject2)) {}
    for (;;)
    {
      try
      {
        localObject1 = new erv();
        Log.printErrStackTrace("MicroMsg.UpdateUtil", localException1, "parse tinker install failed.", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject2 = (erv)((erv)localObject1).parseFrom(Base64.decode((String)localObject2, 0));
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
  
  public static boolean hie()
  {
    AppMethodBeat.i(31147);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", com.tencent.mm.compatible.util.g.avK());
    long l1 = localSharedPreferences.getLong(DND, 0L);
    int i = localSharedPreferences.getInt(DNE, 0);
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
  
  public static void hif()
  {
    AppMethodBeat.i(31148);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", com.tencent.mm.compatible.util.g.avK());
    localSharedPreferences.edit().putLong(DND, System.currentTimeMillis()).apply();
    int i = localSharedPreferences.getInt(DNE, 0);
    localSharedPreferences.edit().putInt(DNE, i + 1).apply();
    AppMethodBeat.o(31148);
  }
  
  public static String hm(Context paramContext)
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
  
  public static String jz(Context paramContext)
  {
    AppMethodBeat.i(31143);
    paramContext = hm(paramContext);
    if ((paramContext == null) || (!new q(paramContext).ifE()))
    {
      AppMethodBeat.o(31143);
      return null;
    }
    a locala = a.gy(paramContext);
    if ((locala != null) && (locala.faM != null))
    {
      paramContext = locala.faM.apkMd5;
      AppMethodBeat.o(31143);
      return paramContext;
    }
    paramContext = u.buc(paramContext);
    AppMethodBeat.o(31143);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.g
 * JD-Core Version:    0.7.0.1
 */