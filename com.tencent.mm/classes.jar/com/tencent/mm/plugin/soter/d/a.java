package com.tencent.mm.plugin.soter.d;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static int AWZ = -1;
  private static int AXa = -1;
  
  public static void SA(int paramInt)
  {
    AppMethodBeat.i(130835);
    String str = bu.o(new Throwable());
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt), str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneType", "3");
    localHashMap.put("scene", String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.g.yxI.g("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(str)), localHashMap);
    AppMethodBeat.o(130835);
  }
  
  public static void Sx(int paramInt)
  {
    AWZ = paramInt;
  }
  
  public static void Sy(int paramInt)
  {
    AppMethodBeat.i(130831);
    if (AXa == -1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130831);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(12927, new Object[] { Integer.valueOf(AXa), Integer.valueOf(paramInt) });
    AXa = -1;
    AppMethodBeat.o(130831);
  }
  
  public static void Sz(int paramInt)
  {
    AppMethodBeat.i(130832);
    if (AXa == -1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130832);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(16995, new Object[] { Integer.valueOf(AXa), Integer.valueOf(paramInt) });
    AXa = -1;
    AppMethodBeat.o(130832);
  }
  
  public static void cg(int paramInt, String paramString)
  {
    AppMethodBeat.i(130837);
    com.tencent.mm.plugin.report.service.g.yxI.f(17805, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(130837);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130828);
    if (AWZ == -1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130828);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(13413, new Object[] { Integer.valueOf(AWZ), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AWZ = -1;
    AppMethodBeat.o(130828);
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130829);
    if (AWZ == -1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130829);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(16992, new Object[] { Integer.valueOf(AWZ), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(130829);
  }
  
  public static void eji()
  {
    AppMethodBeat.i(130826);
    if (AWZ == -1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130826);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(12925, new Object[] { Integer.valueOf(AWZ) });
    AppMethodBeat.o(130826);
  }
  
  public static void ejj()
  {
    AppMethodBeat.i(130827);
    if (AWZ == -1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130827);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(12926, new Object[] { Integer.valueOf(AWZ) });
    AppMethodBeat.o(130827);
  }
  
  public static void ejk()
  {
    AppMethodBeat.i(130830);
    AXa = (int)(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(130830);
  }
  
  public static void ejl()
  {
    AppMethodBeat.i(217884);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217883);
        String str1 = v.aAF();
        if ((!bu.isNullOrNil(m.AXj)) && (!m.AXj.equals(str1)))
        {
          com.tencent.mm.kernel.g.ajS();
          boolean bool1 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMs, Boolean.FALSE)).booleanValue();
          str1 = m.SC(1);
          String str2 = m.SB(1);
          boolean bool2 = com.tencent.soter.core.a.baV(str1);
          boolean bool3 = com.tencent.soter.core.a.baV(str2);
          if ((bool1) && (!bool2) && (bool3))
          {
            bool1 = com.tencent.soter.core.a.baV(m.ejr());
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FingerpirntReporter", "report key valid before pay: %s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 50);
              AppMethodBeat.o(217883);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 49);
          }
        }
        AppMethodBeat.o(217883);
      }
    });
    AppMethodBeat.o(217884);
  }
  
  public static void jdMethod_if(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130833);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.g.yxI.f(14381, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(672L, paramInt1, paramLong, false);
      }
      AppMethodBeat.o(130834);
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        if (com.tencent.mm.compatible.deviceinfo.ae.geS.dLM)
        {
          paramInt1 = 7;
          continue;
        }
        paramInt1 = 8;
        continue;
        if (com.tencent.mm.compatible.deviceinfo.ae.geS.dLM)
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
    com.tencent.mm.plugin.report.service.g.yxI.f(17806, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.a
 * JD-Core Version:    0.7.0.1
 */