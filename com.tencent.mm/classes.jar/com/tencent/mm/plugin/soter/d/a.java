package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static int yaD = -1;
  private static int yaE = -1;
  
  public static void Od(int paramInt)
  {
    yaD = paramInt;
  }
  
  public static void Oe(int paramInt)
  {
    AppMethodBeat.i(130831);
    if (yaE == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130831);
      return;
    }
    h.vKh.f(12927, new Object[] { Integer.valueOf(yaE), Integer.valueOf(paramInt) });
    yaE = -1;
    AppMethodBeat.o(130831);
  }
  
  public static void Of(int paramInt)
  {
    AppMethodBeat.i(130832);
    if (yaE == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130832);
      return;
    }
    h.vKh.f(16995, new Object[] { Integer.valueOf(yaE), Integer.valueOf(paramInt) });
    yaE = -1;
    AppMethodBeat.o(130832);
  }
  
  public static void Og(int paramInt)
  {
    AppMethodBeat.i(130835);
    String str = bt.m(new Throwable());
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt), str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneType", "3");
    localHashMap.put("scene", String.valueOf(paramInt));
    h.vKh.e("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(str)), localHashMap);
    AppMethodBeat.o(130835);
  }
  
  public static void bV(int paramInt, String paramString)
  {
    AppMethodBeat.i(130837);
    h.vKh.f(17805, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(130837);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130828);
    if (yaD == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130828);
      return;
    }
    h.vKh.f(13413, new Object[] { Integer.valueOf(yaD), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    yaD = -1;
    AppMethodBeat.o(130828);
  }
  
  public static void dEN()
  {
    AppMethodBeat.i(130826);
    if (yaD == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130826);
      return;
    }
    h.vKh.f(12925, new Object[] { Integer.valueOf(yaD) });
    AppMethodBeat.o(130826);
  }
  
  public static void dEO()
  {
    AppMethodBeat.i(130827);
    if (yaD == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130827);
      return;
    }
    h.vKh.f(12926, new Object[] { Integer.valueOf(yaD) });
    AppMethodBeat.o(130827);
  }
  
  public static void dEP()
  {
    AppMethodBeat.i(130830);
    yaE = (int)(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(130830);
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130829);
    if (yaD == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130829);
      return;
    }
    h.vKh.f(16992, new Object[] { Integer.valueOf(yaD), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(130829);
  }
  
  public static void hC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130833);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.vKh.f(14381, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
        h.vKh.idkeyStat(672L, paramInt1, paramLong, false);
      }
      AppMethodBeat.o(130834);
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        if (ae.fFC.dAy)
        {
          paramInt1 = 7;
          continue;
        }
        paramInt1 = 8;
        continue;
        if (ae.fFC.dAy)
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
  
  public static void q(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(130836);
    h.vKh.f(17806, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.a
 * JD-Core Version:    0.7.0.1
 */