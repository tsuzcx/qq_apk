package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.tencent.b.a.a.i;
import com.tencent.b.a.a.i.1;
import com.tencent.b.a.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class d
{
  private static i CxM;
  private static int CxN;
  
  static
  {
    AppMethodBeat.i(134233);
    CxM = i.bq(MMApplicationContext.getContext());
    CxN = 2;
    AppMethodBeat.o(134233);
  }
  
  public static int E(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(134232);
    if (!g.aAc())
    {
      Log.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
      AppMethodBeat.o(134232);
      return -1;
    }
    long l = Util.nowSecond();
    if ((paramInt1 == 3) && (Util.nullAs((Long)g.aAh().azQ().get(331778, null), 0L) >= l))
    {
      AppMethodBeat.o(134232);
      return 0;
    }
    int i;
    if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      String str = eOz();
      Log.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", new Object[] { Integer.valueOf(paramInt1), str });
      com.tencent.mm.plugin.report.e.Cxv.a(11402, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(i), q.aoG(), Integer.valueOf(paramInt2), paramString, NetStatusUtil.getISPName(MMApplicationContext.getContext()), Integer.valueOf(0), q.dr(false) });
      g.aAh().azQ().set(331778, Long.valueOf(259200L + l));
      AppMethodBeat.o(134232);
      return 0;
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        i = 3;
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void aMs(String paramString)
  {
    AppMethodBeat.i(134231);
    try
    {
      i locali = CxM;
      if (i.mContext != null)
      {
        i.dfO = System.currentTimeMillis();
        com.tencent.b.a.a.n.dfZ = -1L;
      }
      try
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
        localEditor.putLong("__MID_LAST_CHECK_TIME__", i.dfO);
        localEditor.commit();
        if (i.mHandler != null) {
          i.mHandler.post(new i.1(locali, paramString));
        }
        Log.i("MicroMsg.MidHelper", "QueryMid local:%s", new Object[] { CxM.Ua() });
        AppMethodBeat.o(134231);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s.Uh();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MidHelper", "procReturnData Error e:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(134231);
    }
  }
  
  public static String eOz()
  {
    AppMethodBeat.i(134230);
    try
    {
      i.a(new d.1());
      String str = CxM.TZ();
      Log.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", new Object[] { str, CxM.Ua() });
      AppMethodBeat.o(134230);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MidHelper", "QueryMid Error e:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(134230);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d
 * JD-Core Version:    0.7.0.1
 */