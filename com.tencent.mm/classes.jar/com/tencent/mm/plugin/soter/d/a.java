package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static int psj = -1;
  private static int psk = -1;
  
  public static void bKN()
  {
    if (psj == -1)
    {
      y.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      return;
    }
    h.nFQ.f(12925, new Object[] { Integer.valueOf(psj) });
  }
  
  public static void bKO()
  {
    if (psj == -1)
    {
      y.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      return;
    }
    h.nFQ.f(12926, new Object[] { Integer.valueOf(psj) });
  }
  
  public static void bKP()
  {
    psk = (int)(System.currentTimeMillis() / 1000L);
  }
  
  public static boolean bKQ()
  {
    return psj >= 0;
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (psj == -1)
    {
      y.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
      return;
    }
    h.nFQ.f(13413, new Object[] { Integer.valueOf(psj), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
  
  public static void ef(int paramInt1, int paramInt2)
  {
    y.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.nFQ.f(14381, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void eg(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        y.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(1L) });
        h.nFQ.a(672L, paramInt1, 1L, false);
      }
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        paramInt1 = 1;
        continue;
        paramInt1 = 2;
        continue;
        paramInt1 = 3;
        continue;
        paramInt1 = 4;
        continue;
        paramInt1 = 5;
      }
      else
      {
        paramInt1 = -1;
      }
    }
  }
  
  public static void zi(int paramInt)
  {
    psj = paramInt;
  }
  
  public static void zj(int paramInt)
  {
    if (psk == -1)
    {
      y.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
      return;
    }
    h.nFQ.f(12927, new Object[] { Integer.valueOf(psk), Integer.valueOf(paramInt) });
    psj = -1;
  }
  
  public static void zk(int paramInt)
  {
    String str = bk.j(new Throwable());
    y.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt), str });
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneType", "3");
    localHashMap.put("scene", String.valueOf(paramInt));
    h.nFQ.d("Soter", "Fingerprint pay add authentication task failed: " + str, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.a
 * JD-Core Version:    0.7.0.1
 */