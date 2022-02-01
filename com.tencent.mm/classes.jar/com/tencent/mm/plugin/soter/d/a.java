package com.tencent.mm.plugin.soter.d;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static int Lwx = -1;
  private static int Lwy = -1;
  
  public static void ahN(int paramInt)
  {
    Lwx = paramInt;
  }
  
  public static void ahO(int paramInt)
  {
    AppMethodBeat.i(130831);
    if (Lwy == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130831);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(12927, new Object[] { Integer.valueOf(Lwy), Integer.valueOf(paramInt) });
    Lwy = -1;
    AppMethodBeat.o(130831);
  }
  
  public static void ahP(int paramInt)
  {
    AppMethodBeat.i(130832);
    if (Lwy == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130832);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(16995, new Object[] { Integer.valueOf(Lwy), Integer.valueOf(paramInt) });
    Lwy = -1;
    AppMethodBeat.o(130832);
  }
  
  public static void ahQ(int paramInt)
  {
    AppMethodBeat.i(130835);
    String str = Util.stackTraceToString(new Throwable());
    Log.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt), str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneType", "3");
    localHashMap.put("scene", String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.h.IzE.e("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(str)), localHashMap);
    AppMethodBeat.o(130835);
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130828);
    if (Lwx == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130828);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(13413, new Object[] { Integer.valueOf(Lwx), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    Lwx = -1;
    AppMethodBeat.o(130828);
  }
  
  public static void cy(int paramInt, String paramString)
  {
    AppMethodBeat.i(130837);
    com.tencent.mm.plugin.report.service.h.IzE.a(17805, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(130837);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130829);
    if (Lwx == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130829);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(16992, new Object[] { Integer.valueOf(Lwx), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(130829);
  }
  
  public static void gae()
  {
    AppMethodBeat.i(130826);
    if (Lwx == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130826);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(12925, new Object[] { Integer.valueOf(Lwx) });
    AppMethodBeat.o(130826);
  }
  
  public static void gaf()
  {
    AppMethodBeat.i(130827);
    if (Lwx == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130827);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(12926, new Object[] { Integer.valueOf(Lwx) });
    AppMethodBeat.o(130827);
  }
  
  public static void gag()
  {
    AppMethodBeat.i(130830);
    Lwy = (int)(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(130830);
  }
  
  public static void gah()
  {
    AppMethodBeat.i(262964);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262938);
        String str1 = z.bdc();
        if ((!Util.isNullOrNil(m.LwG)) && (!m.LwG.equals(str1)))
        {
          com.tencent.mm.kernel.h.aHH();
          boolean bool1 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Viu, Boolean.FALSE)).booleanValue();
          str1 = m.ahS(1);
          String str2 = m.ahR(1);
          boolean bool2 = com.tencent.soter.core.a.bDa(str1);
          boolean bool3 = com.tencent.soter.core.a.bDa(str2);
          if ((bool1) && (!bool2) && (bool3))
          {
            bool1 = com.tencent.soter.core.a.bDa(m.gan());
            Log.i("MicroMsg.FingerpirntReporter", "report key valid before pay: %s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.plugin.report.service.h.IzE.el(1104, 50);
              AppMethodBeat.o(262938);
              return;
            }
            com.tencent.mm.plugin.report.service.h.IzE.el(1104, 49);
          }
        }
        AppMethodBeat.o(262938);
      }
    });
    AppMethodBeat.o(262964);
  }
  
  public static void kk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130833);
    Log.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.h.IzE.a(14381, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130833);
  }
  
  public static void t(int paramInt1, int paramInt2, long paramLong)
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
        Log.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(paramLong) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(672L, paramInt1, paramLong, false);
      }
      AppMethodBeat.o(130834);
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        if (af.juN.fXK)
        {
          paramInt1 = 7;
          continue;
        }
        paramInt1 = 8;
        continue;
        if (af.juN.fXK)
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
  
  public static void v(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(130836);
    com.tencent.mm.plugin.report.service.h.IzE.a(17806, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.a
 * JD-Core Version:    0.7.0.1
 */