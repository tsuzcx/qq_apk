package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static int sol = -1;
  private static int som = -1;
  
  public static void Ft(int paramInt)
  {
    sol = paramInt;
  }
  
  public static void Fu(int paramInt)
  {
    AppMethodBeat.i(59324);
    if (som == -1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(59324);
      return;
    }
    h.qsU.e(12927, new Object[] { Integer.valueOf(som), Integer.valueOf(paramInt) });
    som = -1;
    AppMethodBeat.o(59324);
  }
  
  public static void Fv(int paramInt)
  {
    AppMethodBeat.i(59325);
    if (som == -1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(59325);
      return;
    }
    h.qsU.e(16995, new Object[] { Integer.valueOf(som), Integer.valueOf(paramInt) });
    som = -1;
    AppMethodBeat.o(59325);
  }
  
  public static void Fw(int paramInt)
  {
    AppMethodBeat.i(59328);
    String str = bo.l(new Throwable());
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt), str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneType", "3");
    localHashMap.put("scene", String.valueOf(paramInt));
    h.qsU.g("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(str)), localHashMap);
    AppMethodBeat.o(59328);
  }
  
  public static void cxZ()
  {
    AppMethodBeat.i(59319);
    if (sol == -1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(59319);
      return;
    }
    h.qsU.e(12925, new Object[] { Integer.valueOf(sol) });
    AppMethodBeat.o(59319);
  }
  
  public static void cya()
  {
    AppMethodBeat.i(59320);
    if (sol == -1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(59320);
      return;
    }
    h.qsU.e(12926, new Object[] { Integer.valueOf(sol) });
    AppMethodBeat.o(59320);
  }
  
  public static void cyb()
  {
    AppMethodBeat.i(59323);
    som = (int)(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(59323);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(59321);
    if (sol == -1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(59321);
      return;
    }
    h.qsU.e(13413, new Object[] { Integer.valueOf(sol), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    sol = -1;
    AppMethodBeat.o(59321);
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(59322);
    if (sol == -1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(59322);
      return;
    }
    h.qsU.e(16992, new Object[] { Integer.valueOf(sol), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(59322);
  }
  
  public static void fT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59326);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.qsU.e(14381, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(59326);
  }
  
  public static void j(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(156200);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
        h.qsU.idkeyStat(672L, paramInt1, paramLong, false);
      }
      AppMethodBeat.o(156200);
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        if (ac.erA.cJE)
        {
          paramInt1 = 7;
          continue;
        }
        paramInt1 = 8;
        continue;
        if (ac.erA.cJE)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.a
 * JD-Core Version:    0.7.0.1
 */