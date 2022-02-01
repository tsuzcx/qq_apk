package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.d.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
{
  private static final long[] EPd = { 0L, 259200000L, 604800000L };
  
  public static long K(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(32742);
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_flowstat_prefs", g.abm());
    long l = localSharedPreferences.getLong(paramString, 0L);
    ad.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    ad.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    paramLong1 = l + (paramLong1 + paramLong2);
    localSharedPreferences.edit().putLong(paramString, paramLong1).commit();
    AppMethodBeat.o(32742);
    return paramLong1;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    AppMethodBeat.i(32733);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).edit().putString("update_downloaded_pack_md5_key", paramString1).putString("update_downloaded_pack_sig_key", paramString2).putString("update_downloaded_pack_desc_key", paramString3).putInt("update_downloaded_pack_size_key", paramInt1).putInt("update_downloaded_pack_download_mode", paramInt2).putInt("update_downloaded_pack_update_type", paramInt3).putString("update_download_not_auto_download_range", paramString4).commit();
    ad.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString4 });
    AppMethodBeat.o(32733);
  }
  
  public static void aB(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(32726);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", false);
    localIntent.putExtra("intent_extra_opcode", paramInt);
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    AppMethodBeat.o(32726);
  }
  
  public static void aC(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(32727);
    i(paramContext, paramInt, 0);
    AppMethodBeat.o(32727);
  }
  
  public static boolean aPM(String paramString)
  {
    AppMethodBeat.i(32736);
    String[] arrayOfString = fiM();
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
  
  public static long aPN(String paramString)
  {
    AppMethodBeat.i(32743);
    long l = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_flowstat_prefs", g.abm()).getLong(paramString, 0L);
    ad.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", new Object[] { paramString, Long.valueOf(l) });
    AppMethodBeat.o(32743);
    return l;
  }
  
  public static int e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(32725);
    int i = h.a(com.tencent.mm.pluginsdk.i.j.fE(paramContext), paramString1, paramString2, paramString3);
    AppMethodBeat.o(32725);
    return i;
  }
  
  public static String fav()
  {
    AppMethodBeat.i(32729);
    String str = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).getString("update_downloaded_pack_md5_key", null);
    AppMethodBeat.o(32729);
    return str;
  }
  
  public static String fiH()
  {
    AppMethodBeat.i(32730);
    String str = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).getString("update_downloaded_pack_sig_key", null);
    AppMethodBeat.o(32730);
    return str;
  }
  
  public static String fiI()
  {
    AppMethodBeat.i(32731);
    String str = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).getString("update_downloaded_pack_desc_key", null);
    AppMethodBeat.o(32731);
    return str;
  }
  
  public static int fiJ()
  {
    AppMethodBeat.i(32732);
    int i = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).getInt("update_downloaded_pack_download_mode", 0);
    AppMethodBeat.o(32732);
    return i;
  }
  
  public static int fiK()
  {
    AppMethodBeat.i(32734);
    int i = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).getInt("update_downloaded_cancel_times", 0);
    ad.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(32734);
    return i;
  }
  
  public static void fiL()
  {
    int i = 0;
    AppMethodBeat.i(32735);
    SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm());
    int j = localSharedPreferences.getInt("update_downloaded_cancel_times", 0);
    ad.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", new Object[] { Integer.valueOf(j) });
    if (j >= EPd.length - 1)
    {
      String str = fav();
      Object localObject = null;
      if (!bt.isNullOrNil(str))
      {
        String[] arrayOfString = fiM();
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
            if (!bt.isNullOrNil(localObject))
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
  
  private static String[] fiM()
  {
    AppMethodBeat.i(32737);
    Object localObject = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).getString("update_downloaded_ignored_pack", null);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(32737);
      return null;
    }
    localObject = ((String)localObject).split(":");
    AppMethodBeat.o(32737);
    return localObject;
  }
  
  public static void fiN()
  {
    AppMethodBeat.i(32738);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
    ad.i("MicroMsg.UpdateUtil", "putDowningInSilence");
    AppMethodBeat.o(32738);
  }
  
  public static void fiO()
  {
    AppMethodBeat.i(32739);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).edit().putBoolean("update_download_start_one_immediate", true).commit();
    ad.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
    AppMethodBeat.o(32739);
  }
  
  public static void fiP()
  {
    AppMethodBeat.i(32740);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).edit().remove("update_downloading_in_silence").commit();
    ad.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
    AppMethodBeat.o(32740);
  }
  
  public static void fiQ()
  {
    AppMethodBeat.i(32741);
    MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "update_config_prefs", g.abm()).edit().clear().commit();
    ad.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
    AppMethodBeat.o(32741);
  }
  
  public static void i(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32728);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
    localIntent.putExtra("intent_extra_is_silence_stat", true);
    localIntent.putExtra("intent_extra_opcode", paramInt1);
    if (paramInt1 == 2) {
      localIntent.putExtra("intent_extra_install_dialog_times", paramInt2);
    }
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    AppMethodBeat.o(32728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.j
 * JD-Core Version:    0.7.0.1
 */