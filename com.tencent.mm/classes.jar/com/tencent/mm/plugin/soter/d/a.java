package com.tencent.mm.plugin.soter.d;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static int znC = -1;
  private static int znD = -1;
  
  public static void Qi(int paramInt)
  {
    znC = paramInt;
  }
  
  public static void Qj(int paramInt)
  {
    AppMethodBeat.i(130831);
    if (znD == -1)
    {
      ac.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130831);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(12927, new Object[] { Integer.valueOf(znD), Integer.valueOf(paramInt) });
    znD = -1;
    AppMethodBeat.o(130831);
  }
  
  public static void Qk(int paramInt)
  {
    AppMethodBeat.i(130832);
    if (znD == -1)
    {
      ac.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130832);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(16995, new Object[] { Integer.valueOf(znD), Integer.valueOf(paramInt) });
    znD = -1;
    AppMethodBeat.o(130832);
  }
  
  public static void Ql(int paramInt)
  {
    AppMethodBeat.i(130835);
    String str = bs.m(new Throwable());
    ac.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt), str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneType", "3");
    localHashMap.put("scene", String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.h.wUl.g("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(str)), localHashMap);
    AppMethodBeat.o(130835);
  }
  
  public static void bZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(130837);
    com.tencent.mm.plugin.report.service.h.wUl.f(17805, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(130837);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130828);
    if (znC == -1)
    {
      ac.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130828);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(13413, new Object[] { Integer.valueOf(znC), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    znC = -1;
    AppMethodBeat.o(130828);
  }
  
  public static void dTm()
  {
    AppMethodBeat.i(130826);
    if (znC == -1)
    {
      ac.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130826);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(12925, new Object[] { Integer.valueOf(znC) });
    AppMethodBeat.o(130826);
  }
  
  public static void dTn()
  {
    AppMethodBeat.i(130827);
    if (znC == -1)
    {
      ac.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130827);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(12926, new Object[] { Integer.valueOf(znC) });
    AppMethodBeat.o(130827);
  }
  
  public static void dTo()
  {
    AppMethodBeat.i(130830);
    znD = (int)(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(130830);
  }
  
  public static void dTp()
  {
    AppMethodBeat.i(207369);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207368);
        String str1 = u.axz();
        if ((!bs.isNullOrNil(m.znM)) && (!m.znM.equals(str1)))
        {
          g.agS();
          boolean bool1 = ((Boolean)g.agR().agA().get(ah.a.GFE, Boolean.FALSE)).booleanValue();
          str1 = m.Qm(1);
          String str2 = m.dTu();
          boolean bool2 = com.tencent.soter.core.a.aTs(str1);
          boolean bool3 = com.tencent.soter.core.a.aTs(str2);
          if ((bool1) && (!bool2) && (bool3))
          {
            bool1 = com.tencent.soter.core.a.aTs(m.dTv());
            ac.i("MicroMsg.FingerpirntReporter", "report key valid before pay: %s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 50);
              AppMethodBeat.o(207368);
              return;
            }
            com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 49);
          }
        }
        AppMethodBeat.o(207368);
      }
    });
    AppMethodBeat.o(207369);
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130829);
    if (znC == -1)
    {
      ac.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130829);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(16992, new Object[] { Integer.valueOf(znC), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(130829);
  }
  
  public static void hL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130833);
    ac.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.h.wUl.f(14381, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130833);
  }
  
  public static void m(int paramInt1, int paramInt2, long paramLong)
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
        ac.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(672L, paramInt1, paramLong, false);
      }
      AppMethodBeat.o(130834);
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        if (com.tencent.mm.compatible.deviceinfo.ae.fJj.dyk)
        {
          paramInt1 = 7;
          continue;
        }
        paramInt1 = 8;
        continue;
        if (com.tencent.mm.compatible.deviceinfo.ae.fJj.dyk)
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
  
  public static void s(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(130836);
    com.tencent.mm.plugin.report.service.h.wUl.f(17806, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.a
 * JD-Core Version:    0.7.0.1
 */