package com.tencent.mm.plugin.soter.d;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static int AFw = -1;
  private static int AFx = -1;
  
  public static void RQ(int paramInt)
  {
    AFw = paramInt;
  }
  
  public static void RR(int paramInt)
  {
    AppMethodBeat.i(130831);
    if (AFx == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130831);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(12927, new Object[] { Integer.valueOf(AFx), Integer.valueOf(paramInt) });
    AFx = -1;
    AppMethodBeat.o(130831);
  }
  
  public static void RS(int paramInt)
  {
    AppMethodBeat.i(130832);
    if (AFx == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130832);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(16995, new Object[] { Integer.valueOf(AFx), Integer.valueOf(paramInt) });
    AFx = -1;
    AppMethodBeat.o(130832);
  }
  
  public static void RT(int paramInt)
  {
    AppMethodBeat.i(130835);
    String str = bt.n(new Throwable());
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt), str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneType", "3");
    localHashMap.put("scene", String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.g.yhR.g("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(str)), localHashMap);
    AppMethodBeat.o(130835);
  }
  
  public static void cg(int paramInt, String paramString)
  {
    AppMethodBeat.i(130837);
    com.tencent.mm.plugin.report.service.g.yhR.f(17805, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(130837);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130828);
    if (AFw == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130828);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(13413, new Object[] { Integer.valueOf(AFw), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AFw = -1;
    AppMethodBeat.o(130828);
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130829);
    if (AFw == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130829);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(16992, new Object[] { Integer.valueOf(AFw), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(130829);
  }
  
  public static void efA()
  {
    AppMethodBeat.i(130826);
    if (AFw == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130826);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(12925, new Object[] { Integer.valueOf(AFw) });
    AppMethodBeat.o(130826);
  }
  
  public static void efB()
  {
    AppMethodBeat.i(130827);
    if (AFw == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130827);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(12926, new Object[] { Integer.valueOf(AFw) });
    AppMethodBeat.o(130827);
  }
  
  public static void efC()
  {
    AppMethodBeat.i(130830);
    AFx = (int)(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(130830);
  }
  
  public static void efD()
  {
    AppMethodBeat.i(214668);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214667);
        String str1 = u.aAp();
        if ((!bt.isNullOrNil(m.AFG)) && (!m.AFG.equals(str1)))
        {
          com.tencent.mm.kernel.g.ajD();
          boolean bool1 = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrW, Boolean.FALSE)).booleanValue();
          str1 = m.RV(1);
          String str2 = m.RU(1);
          boolean bool2 = com.tencent.soter.core.a.aZs(str1);
          boolean bool3 = com.tencent.soter.core.a.aZs(str2);
          if ((bool1) && (!bool2) && (bool3))
          {
            bool1 = com.tencent.soter.core.a.aZs(m.efJ());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerpirntReporter", "report key valid before pay: %s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 50);
              AppMethodBeat.o(214667);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 49);
          }
        }
        AppMethodBeat.o(214667);
      }
    });
    AppMethodBeat.o(214668);
  }
  
  public static void ic(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130833);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.g.yhR.f(14381, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130833);
  }
  
  public static void n(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(130834);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(672L, paramInt1, paramLong, false);
      }
      AppMethodBeat.o(130834);
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        if (ae.gcK.dKx)
        {
          paramInt1 = 7;
          continue;
        }
        paramInt1 = 8;
        continue;
        if (ae.gcK.dKx)
        {
          paramInt1 = 9;
          continue;
        }
        paramInt1 = 10;
        continue;
        paramInt1 = 3;
        continue;
        paramInt1 = 4;
        continue;
        paramInt1 = 5;
        continue;
        if (paramInt1 == 1)
        {
          paramInt1 = 11;
          continue;
          if (paramInt1 == 1)
          {
            paramInt1 = 12;
            continue;
          }
        }
      }
      paramInt1 = -1;
    }
  }
  
  public static void r(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(130836);
    com.tencent.mm.plugin.report.service.g.yhR.f(17806, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.a
 * JD-Core Version:    0.7.0.1
 */