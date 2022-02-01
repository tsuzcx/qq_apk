package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.a;
import com.tencent.mm.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import java.io.File;
import java.io.RandomAccessFile;

public final class i
{
  private static final long[] XUU = { 0L, 259200000L, 604800000L };
  
  private static int A(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(248423);
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null)) {
      try
      {
        File localFile2 = new File(paramString1);
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile2, "r");
        File localFile1 = new File(paramString3);
        paramString2 = new File(paramString2);
        if ((localFile2.exists()) && (paramString2.exists()))
        {
          int j = 0;
          int i = j;
          if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion <= 29)
          {
            paramString1 = com.tencent.mm.d.a.hY(paramString1);
            i = j;
            if (paramString1 != null)
            {
              i = j;
              if (paramString1.hel != null)
              {
                i = paramString1.hel.heo + 8;
                Log.i("MicroMsg.UpdateUtil", "MicroMsg.MergePatchApk:extLen = %d", new Object[] { Integer.valueOf(i) });
              }
            }
          }
          if (i != 0) {}
          for (i = d.a(localRandomAccessFile, localFile1, paramString2, i); i != 1; i = com.tencent.tinker.b.a.a(localRandomAccessFile, localFile1, paramString2))
          {
            Log.w("MicroMsg.UpdateUtil", "MicroMsg.MergePatchApk:merge failed in patchLessMemory()");
            localRandomAccessFile.close();
            AppMethodBeat.o(248423);
            return -1;
          }
          localRandomAccessFile.close();
          boolean bool = paramString4.equalsIgnoreCase(com.tencent.mm.d.g.getMD5(paramString3));
          if (!bool)
          {
            AppMethodBeat.o(248423);
            return -2;
          }
          AppMethodBeat.o(248423);
          return 0;
        }
        Log.w("MicroMsg.UpdateUtil", "MicroMsg.MergePatchApk: file not found in merge(): oldFile.exists()=" + localFile2.exists() + ", newFile.exists()=" + localFile1.exists() + ", patch.exists()=" + paramString2.exists());
        localRandomAccessFile.close();
        AppMethodBeat.o(248423);
        return -1;
      }
      catch (Exception paramString1)
      {
        Log.w("MicroMsg.UpdateUtil", "MicroMsg.MergePatchApk:Exception in merge()");
        AppMethodBeat.o(248423);
        return -1;
      }
    }
    AppMethodBeat.o(248423);
    return -1;
  }
  
  public static long Q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(32742);
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.g.aQe());
    long l = localSharedPreferences.getLong(paramString, 0L);
    Log.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Log.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    paramLong1 = l + (paramLong1 + paramLong2);
    localSharedPreferences.edit().putLong(paramString, paramLong1).commit();
    AppMethodBeat.o(32742);
    return paramLong1;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(32733);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().putString("update_downloaded_pack_md5_key", paramString1).putString("update_downloaded_pack_sig_key", paramString2).putString("update_downloaded_pack_desc_key", paramString3).putInt("update_downloaded_pack_size_key", paramInt1).putInt("update_downloaded_pack_download_mode", paramInt2).putInt("update_downloaded_pack_update_type", paramInt3).putString("update_download_not_auto_download_range", paramString4).commit();
    Log.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString4 });
    AppMethodBeat.o(32733);
  }
  
  public static boolean bud(String paramString)
  {
    AppMethodBeat.i(32736);
    String[] arrayOfString = iSv();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(paramString))
        {
          AppMethodBeat.o(32736);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(32736);
    return false;
  }
  
  public static long bue(String paramString)
  {
    AppMethodBeat.i(32743);
    long l = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.g.aQe()).getLong(paramString, 0L);
    Log.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(32743);
    return l;
  }
  
  public static void bv(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(32726);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", false);
    localIntent.putExtra("intent_extra_opcode", paramInt);
    paramContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
    AppMethodBeat.o(32726);
  }
  
  public static void bw(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(32727);
    r(paramContext, paramInt, 0);
    AppMethodBeat.o(32727);
  }
  
  public static String iIZ()
  {
    AppMethodBeat.i(32729);
    String str = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getString("update_downloaded_pack_md5_key", null);
    AppMethodBeat.o(32729);
    return str;
  }
  
  public static String iSq()
  {
    AppMethodBeat.i(32730);
    String str = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getString("update_downloaded_pack_sig_key", null);
    AppMethodBeat.o(32730);
    return str;
  }
  
  public static String iSr()
  {
    AppMethodBeat.i(32731);
    String str = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getString("update_downloaded_pack_desc_key", null);
    AppMethodBeat.o(32731);
    return str;
  }
  
  public static int iSs()
  {
    AppMethodBeat.i(32732);
    int i = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getInt("update_downloaded_pack_download_mode", 0);
    AppMethodBeat.o(32732);
    return i;
  }
  
  public static int iSt()
  {
    AppMethodBeat.i(32734);
    int i = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getInt("update_downloaded_cancel_times", 0);
    Log.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(32734);
    return i;
  }
  
  public static void iSu()
  {
    int i = 0;
    AppMethodBeat.i(32735);
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe());
    int j = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    Log.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", new Object[] { Integer.valueOf(j) });
    if (j >= XUU.length - 1)
    {
      String str = iIZ();
      Object localObject = null;
      if (!Util.isNullOrNil(str))
      {
        String[] arrayOfString = iSv();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localObject = localStringBuffer;
        if (arrayOfString != null)
        {
          j = arrayOfString.length;
          for (;;)
          {
            localObject = localStringBuffer;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i];
            if (!Util.isNullOrNil(localObject))
            {
              localStringBuffer.append(":");
              localStringBuffer.append(localObject);
            }
            i += 1;
          }
        }
      }
      localSharedPreferences.edit().clear().commit();
      if (localObject != null) {
        localSharedPreferences.edit().putString("update_downloaded_ignored_pack", localObject.toString()).commit();
      }
      AppMethodBeat.o(32735);
      return;
    }
    localSharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", j + 1).commit();
    AppMethodBeat.o(32735);
  }
  
  private static String[] iSv()
  {
    AppMethodBeat.i(32737);
    Object localObject = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getString("update_downloaded_ignored_pack", null);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(32737);
      return null;
    }
    localObject = ((String)localObject).split(":");
    AppMethodBeat.o(32737);
    return localObject;
  }
  
  public static void iSw()
  {
    AppMethodBeat.i(32738);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
    Log.i("MicroMsg.UpdateUtil", "putDowningInSilence");
    AppMethodBeat.o(32738);
  }
  
  public static void iSx()
  {
    AppMethodBeat.i(32739);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().putBoolean("update_download_start_one_immediate", true).commit();
    Log.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
    AppMethodBeat.o(32739);
  }
  
  public static void iSy()
  {
    AppMethodBeat.i(32740);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().remove("update_downloading_in_silence").commit();
    Log.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
    AppMethodBeat.o(32740);
  }
  
  public static void iSz()
  {
    AppMethodBeat.i(32741);
    MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().clear().commit();
    Log.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
    AppMethodBeat.o(32741);
  }
  
  public static int k(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(32725);
    int i = A(com.tencent.mm.pluginsdk.platformtools.g.iH(paramContext), paramString1, paramString2, paramString3);
    AppMethodBeat.o(32725);
    return i;
  }
  
  public static void r(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32728);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", true);
    localIntent.putExtra("intent_extra_opcode", paramInt1);
    if (paramInt1 == 2) {
      localIntent.putExtra("intent_extra_install_dialog_times", paramInt2);
    }
    paramContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
    AppMethodBeat.o(32728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.i
 * JD-Core Version:    0.7.0.1
 */