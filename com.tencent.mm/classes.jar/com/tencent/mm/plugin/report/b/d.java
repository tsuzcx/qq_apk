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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class d
{
  private static i ygZ;
  private static int yha;
  
  static
  {
    AppMethodBeat.i(134233);
    ygZ = i.aV(aj.getContext());
    yha = 2;
    AppMethodBeat.o(134233);
  }
  
  public static int F(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(134232);
    if (!g.ajx())
    {
      ad.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
      AppMethodBeat.o(134232);
      return -1;
    }
    long l = bt.aQJ();
    if ((paramInt1 == 3) && (bt.a((Long)g.ajC().ajl().get(331778, null), 0L) >= l))
    {
      AppMethodBeat.o(134232);
      return 0;
    }
    int i;
    if (ay.is2G(aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      String str = dKh();
      ad.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", new Object[] { Integer.valueOf(paramInt1), str });
      com.tencent.mm.plugin.report.e.ygI.f(11402, new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(i), q.aay(), Integer.valueOf(paramInt2), paramString, ay.getISPName(aj.getContext()), Integer.valueOf(0), q.cH(false) });
      g.ajC().ajl().set(331778, Long.valueOf(259200L + l));
      AppMethodBeat.o(134232);
      return 0;
      if (ay.isWifi(aj.getContext())) {
        i = 3;
      } else if (ay.is3G(aj.getContext())) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void awB(String paramString)
  {
    AppMethodBeat.i(134231);
    try
    {
      i locali = ygZ;
      if (i.mContext != null)
      {
        i.cOF = System.currentTimeMillis();
        com.tencent.b.a.a.n.cOQ = -1L;
      }
      try
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
        localEditor.putLong("__MID_LAST_CHECK_TIME__", i.cOF);
        localEditor.commit();
        if (i.mHandler != null) {
          i.mHandler.post(new i.1(locali, paramString));
        }
        ad.i("MicroMsg.MidHelper", "QueryMid local:%s", new Object[] { ygZ.JF() });
        AppMethodBeat.o(134231);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s.JM();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.MidHelper", "procReturnData Error e:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(134231);
    }
  }
  
  public static String dKh()
  {
    AppMethodBeat.i(134230);
    try
    {
      i.a(new d.1());
      String str = ygZ.JE();
      ad.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", new Object[] { str, ygZ.JF() });
      AppMethodBeat.o(134230);
      return str;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MidHelper", "QueryMid Error e:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(134230);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d
 * JD-Core Version:    0.7.0.1
 */