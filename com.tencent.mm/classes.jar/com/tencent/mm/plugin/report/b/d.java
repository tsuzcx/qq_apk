package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.tencent.c.a.a.i;
import com.tencent.c.a.a.i.1;
import com.tencent.c.a.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class d
{
  private static i qrV;
  private static int qrW;
  
  static
  {
    AppMethodBeat.i(123501);
    qrV = i.aL(ah.getContext());
    qrW = 2;
    AppMethodBeat.o(123501);
  }
  
  public static void Yr(String paramString)
  {
    AppMethodBeat.i(123499);
    try
    {
      i locali = qrV;
      if (i.mContext != null)
      {
        i.bUI = System.currentTimeMillis();
        com.tencent.c.a.a.n.bUT = -1L;
      }
      try
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
        localEditor.putLong("__MID_LAST_CHECK_TIME__", i.bUI);
        localEditor.commit();
        if (i.mHandler != null) {
          i.mHandler.post(new i.1(locali, paramString));
        }
        ab.i("MicroMsg.MidHelper", "QueryMid local:%s", new Object[] { qrV.zP() });
        AppMethodBeat.o(123499);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s.zW();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MidHelper", "procReturnData Error e:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(123499);
    }
  }
  
  public static String chI()
  {
    AppMethodBeat.i(123498);
    try
    {
      i.a(new d.1());
      String str = qrV.zO();
      ab.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", new Object[] { str, qrV.zP() });
      AppMethodBeat.o(123498);
      return str;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MidHelper", "QueryMid Error e:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(123498);
    }
    return "";
  }
  
  public static int x(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(123500);
    if (!g.RG())
    {
      ab.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
      AppMethodBeat.o(123500);
      return -1;
    }
    long l = bo.aox();
    if ((paramInt1 == 3) && (bo.a((Long)g.RL().Ru().get(331778, null), 0L) >= l))
    {
      AppMethodBeat.o(123500);
      return 0;
    }
    int i;
    if (at.is2G(ah.getContext())) {
      i = 1;
    }
    for (;;)
    {
      String str = chI();
      ab.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", new Object[] { Integer.valueOf(paramInt1), str });
      com.tencent.mm.plugin.report.e.qrI.e(11402, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(i), q.LK(), Integer.valueOf(paramInt2), paramString, at.getISPName(ah.getContext()), Integer.valueOf(0), q.bP(false) });
      g.RL().Ru().set(331778, Long.valueOf(259200L + l));
      AppMethodBeat.o(123500);
      return 0;
      if (at.isWifi(ah.getContext())) {
        i = 3;
      } else if (at.is3G(ah.getContext())) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d
 * JD-Core Version:    0.7.0.1
 */