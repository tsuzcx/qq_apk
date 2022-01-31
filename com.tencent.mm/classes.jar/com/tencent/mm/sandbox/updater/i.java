package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
{
  private static final long[] vMJ = { 0L, 259200000L, 604800000L };
  
  public static long F(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(28929);
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.h.Mp());
    long l = localSharedPreferences.getLong(paramString, 0L);
    ab.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    ab.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    paramLong1 = l + (paramLong1 + paramLong2);
    localSharedPreferences.edit().putLong(paramString, paramLong1).commit();
    AppMethodBeat.o(28929);
    return paramLong1;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(28920);
    MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().putString("update_downloaded_pack_md5_key", paramString1).putString("update_downloaded_pack_sig_key", paramString2).putString("update_downloaded_pack_desc_key", paramString3).putInt("update_downloaded_pack_size_key", paramInt1).putInt("update_downloaded_pack_download_mode", paramInt2).putInt("update_downloaded_pack_update_type", paramInt3).putString("update_download_not_auto_download_range", paramString4).commit();
    ab.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString4 });
    AppMethodBeat.o(28920);
  }
  
  public static boolean aoM(String paramString)
  {
    AppMethodBeat.i(28923);
    String[] arrayOfString = drN();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals(paramString))
        {
          AppMethodBeat.o(28923);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(28923);
    return false;
  }
  
  public static long aoN(String paramString)
  {
    AppMethodBeat.i(28930);
    long l = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_flowstat_prefs", com.tencent.mm.compatible.util.h.Mp()).getLong(paramString, 0L);
    ab.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(28930);
    return l;
  }
  
  public static void as(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(28913);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", false);
    localIntent.putExtra("intent_extra_opcode", paramInt);
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    AppMethodBeat.o(28913);
  }
  
  public static void at(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(28914);
    e(paramContext, paramInt, 0);
    AppMethodBeat.o(28914);
  }
  
  public static String dlS()
  {
    AppMethodBeat.i(28916);
    String str = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getString("update_downloaded_pack_md5_key", null);
    AppMethodBeat.o(28916);
    return str;
  }
  
  public static String drI()
  {
    AppMethodBeat.i(28917);
    String str = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getString("update_downloaded_pack_sig_key", null);
    AppMethodBeat.o(28917);
    return str;
  }
  
  public static String drJ()
  {
    AppMethodBeat.i(28918);
    String str = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getString("update_downloaded_pack_desc_key", null);
    AppMethodBeat.o(28918);
    return str;
  }
  
  public static int drK()
  {
    AppMethodBeat.i(28919);
    int i = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getInt("update_downloaded_pack_download_mode", 0);
    AppMethodBeat.o(28919);
    return i;
  }
  
  public static int drL()
  {
    AppMethodBeat.i(28921);
    int i = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getInt("update_downloaded_cancel_times", 0);
    ab.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(28921);
    return i;
  }
  
  public static void drM()
  {
    int i = 0;
    AppMethodBeat.i(28922);
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp());
    int j = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    ab.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", new Object[] { Integer.valueOf(j) });
    if (j >= vMJ.length - 1)
    {
      String str = dlS();
      Object localObject = null;
      if (!bo.isNullOrNil(str))
      {
        String[] arrayOfString = drN();
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
            if (!bo.isNullOrNil(localObject))
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
      AppMethodBeat.o(28922);
      return;
    }
    localSharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", j + 1).commit();
    AppMethodBeat.o(28922);
  }
  
  private static String[] drN()
  {
    AppMethodBeat.i(28924);
    Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getString("update_downloaded_ignored_pack", null);
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(28924);
      return null;
    }
    localObject = ((String)localObject).split(":");
    AppMethodBeat.o(28924);
    return localObject;
  }
  
  public static void drO()
  {
    AppMethodBeat.i(28925);
    MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
    ab.i("MicroMsg.UpdateUtil", "putDowningInSilence");
    AppMethodBeat.o(28925);
  }
  
  public static void drP()
  {
    AppMethodBeat.i(28926);
    MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().putBoolean("update_download_start_one_immediate", true).commit();
    ab.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
    AppMethodBeat.o(28926);
  }
  
  public static void drQ()
  {
    AppMethodBeat.i(28927);
    MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().remove("update_downloading_in_silence").commit();
    ab.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
    AppMethodBeat.o(28927);
  }
  
  public static void drR()
  {
    AppMethodBeat.i(28928);
    MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().clear().commit();
    ab.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
    AppMethodBeat.o(28928);
  }
  
  public static void e(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28915);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", true);
    localIntent.putExtra("intent_extra_opcode", paramInt1);
    if (paramInt1 == 2) {
      localIntent.putExtra("intent_extra_install_dialog_times", paramInt2);
    }
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    AppMethodBeat.o(28915);
  }
  
  public static int g(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(28912);
    int i = com.tencent.mm.c.h.b(com.tencent.mm.pluginsdk.f.i.er(paramContext), paramString1, paramString2, paramString3);
    AppMethodBeat.o(28912);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.i
 * JD-Core Version:    0.7.0.1
 */