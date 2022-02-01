package com.tencent.mm.plugin.soter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static int RZW = -1;
  private static int RZX = -1;
  
  public static void A(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(130836);
    com.tencent.mm.plugin.report.service.h.OAn.b(17806, new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130836);
  }
  
  public static void amO(int paramInt)
  {
    RZW = paramInt;
  }
  
  public static void amP(int paramInt)
  {
    AppMethodBeat.i(130831);
    if (RZX == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130831);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(12927, new Object[] { Integer.valueOf(RZX), Integer.valueOf(paramInt) });
    RZX = -1;
    AppMethodBeat.o(130831);
  }
  
  public static void amQ(int paramInt)
  {
    AppMethodBeat.i(130832);
    if (RZX == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      AppMethodBeat.o(130832);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(16995, new Object[] { Integer.valueOf(RZX), Integer.valueOf(paramInt) });
    RZX = -1;
    AppMethodBeat.o(130832);
  }
  
  public static void amR(int paramInt)
  {
    AppMethodBeat.i(130835);
    String str = Util.stackTraceToString(new Throwable());
    Log.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt), str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneType", "3");
    localHashMap.put("scene", String.valueOf(paramInt));
    com.tencent.mm.plugin.report.service.h.OAn.e("Soter", "Fingerprint pay add authentication task failed: ".concat(String.valueOf(str)), localHashMap);
    AppMethodBeat.o(130835);
  }
  
  public static void dl(int paramInt, String paramString)
  {
    AppMethodBeat.i(130837);
    com.tencent.mm.plugin.report.service.h.OAn.b(17805, new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(130837);
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130828);
    if (RZW == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130828);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(13413, new Object[] { Integer.valueOf(RZW), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    RZW = -1;
    AppMethodBeat.o(130828);
  }
  
  public static void f(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(130829);
    if (RZW == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130829);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(16992, new Object[] { Integer.valueOf(RZW), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    AppMethodBeat.o(130829);
  }
  
  public static void htv()
  {
    AppMethodBeat.i(130826);
    if (RZW == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130826);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(12925, new Object[] { Integer.valueOf(RZW) });
    AppMethodBeat.o(130826);
  }
  
  public static void htw()
  {
    AppMethodBeat.i(130827);
    if (RZW == -1)
    {
      Log.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      AppMethodBeat.o(130827);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(12926, new Object[] { Integer.valueOf(RZW) });
    AppMethodBeat.o(130827);
  }
  
  public static void htx()
  {
    AppMethodBeat.i(130830);
    RZX = (int)(System.currentTimeMillis() / 1000L);
    AppMethodBeat.o(130830);
  }
  
  public static void hty()
  {
    AppMethodBeat.i(262516);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262495);
        String str1 = z.bAP();
        if ((!Util.isNullOrNil(j.Saf)) && (!j.Saf.equals(str1)))
        {
          com.tencent.mm.kernel.h.baF();
          boolean bool1 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJO, Boolean.FALSE)).booleanValue();
          str1 = j.amT(1);
          String str2 = j.amS(1);
          boolean bool2 = com.tencent.soter.core.a.bFF(str1);
          boolean bool3 = com.tencent.soter.core.a.bFF(str2);
          if ((bool1) && (!bool2) && (bool3))
          {
            bool1 = com.tencent.soter.core.a.bFF(j.htE());
            Log.i("MicroMsg.FingerpirntReporter", "report key valid before pay: %s", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 50);
              AppMethodBeat.o(262495);
              return;
            }
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 49);
          }
        }
        AppMethodBeat.o(262495);
      }
    });
    AppMethodBeat.o(262516);
  }
  
  public static void lW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130833);
    Log.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    com.tencent.mm.plugin.report.service.h.OAn.b(14381, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(130833);
  }
  
  public static void w(int paramInt1, int paramInt2, long paramLong)
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
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(672L, paramInt1, paramLong, false);
      }
      AppMethodBeat.o(130834);
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        if (af.lYe.idL)
        {
          paramInt1 = 7;
          continue;
        }
        paramInt1 = 8;
        continue;
        if (af.lYe.idL)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.model.a
 * JD-Core Version:    0.7.0.1
 */