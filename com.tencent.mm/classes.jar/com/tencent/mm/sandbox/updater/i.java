package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.c.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  private static final long[] rVO = { 0L, 259200000L, 604800000L };
  
  public static boolean YO(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = cpX();
    boolean bool1 = bool2;
    int j;
    int i;
    if (arrayOfString != null)
    {
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static long YP(String paramString)
  {
    long l = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_flowstat_prefs", 4).getLong(paramString, 0L);
    y.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    return l;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).edit().putString("update_downloaded_pack_md5_key", paramString1).putString("update_downloaded_pack_sig_key", paramString2).putString("update_downloaded_pack_desc_key", paramString3).putInt("update_downloaded_pack_size_key", paramInt1).putInt("update_downloaded_pack_download_mode", paramInt2).putInt("update_downloaded_pack_update_type", paramInt3).putString("update_download_not_auto_download_range", paramString4).commit();
    y.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString4 });
  }
  
  public static void ae(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", false);
    localIntent.putExtra("intent_extra_opcode", paramInt);
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
  }
  
  public static void af(Context paramContext, int paramInt)
  {
    e(paramContext, paramInt, 0);
  }
  
  public static String cli()
  {
    return MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
  }
  
  public static String cpS()
  {
    return MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_sig_key", null);
  }
  
  public static String cpT()
  {
    return MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_desc_key", null);
  }
  
  public static int cpU()
  {
    return MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).getInt("update_downloaded_pack_download_mode", 0);
  }
  
  public static int cpV()
  {
    int i = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).getInt("update_downloaded_cancel_times", 0);
    y.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", new Object[] { Integer.valueOf(i) });
    return i;
  }
  
  public static void cpW()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4);
    int j = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    y.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", new Object[] { Integer.valueOf(j) });
    if (j >= rVO.length - 1)
    {
      String str = cli();
      Object localObject = null;
      if (!bk.bl(str))
      {
        String[] arrayOfString = cpX();
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
            if (!bk.bl(localObject))
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
      return;
    }
    localSharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", j + 1).commit();
  }
  
  private static String[] cpX()
  {
    String str = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).getString("update_downloaded_ignored_pack", null);
    if (bk.bl(str)) {
      return null;
    }
    return str.split(":");
  }
  
  public static void cpY()
  {
    MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
    y.i("MicroMsg.UpdateUtil", "putDowningInSilence");
  }
  
  public static void cpZ()
  {
    MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).edit().putBoolean("update_download_start_one_immediate", true).commit();
    y.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
  }
  
  public static void cqa()
  {
    MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).edit().remove("update_downloading_in_silence").commit();
    y.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
  }
  
  public static void cqb()
  {
    MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_config_prefs", 4).edit().clear().commit();
    y.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
  }
  
  public static void e(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", true);
    localIntent.putExtra("intent_extra_opcode", paramInt1);
    if (paramInt1 == 2) {
      localIntent.putExtra("intent_extra_install_dialog_times", paramInt2);
    }
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
  }
  
  public static int g(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return h.b(com.tencent.mm.pluginsdk.f.i.eV(paramContext), paramString1, paramString2, paramString3);
  }
  
  public static long x(String paramString, long paramLong1, long paramLong2)
  {
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "update_flowstat_prefs", 4);
    long l = localSharedPreferences.getLong(paramString, 0L);
    y.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    y.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    paramLong1 = l + (paramLong1 + paramLong2);
    localSharedPreferences.edit().putLong(paramString, paramLong1).commit();
    return paramLong1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.i
 * JD-Core Version:    0.7.0.1
 */