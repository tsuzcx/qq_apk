package com.tencent.mm.plugin.walletlock.c;

import com.tencent.mm.sdk.platformtools.y;

public final class h
{
  private static long fKz = -1L;
  
  public static void Y(int paramInt1, int paramInt2, int paramInt3)
  {
    if (fKz == -1L) {
      y.e("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report sessionId is -1, not create session, ignore");
    }
    while (paramInt1 == -1) {
      return;
    }
    y.i("MicroMsg.WalletLockReportManager", "alvinluo reportVerifyWalletLock session: %d, protectScene: %d, walletLockType: %d, result: %d", new Object[] { Long.valueOf(fKz), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.h.nFQ.f(14839, new Object[] { Long.valueOf(fKz), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public static void bYB()
  {
    y.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report fingerprintlock verify by passwd success");
    com.tencent.mm.plugin.report.service.h.nFQ.a(713L, 2L, 1L, false);
  }
  
  public static void bYC()
  {
    y.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report close wallet lock success");
    com.tencent.mm.plugin.report.service.h.nFQ.a(713L, 3L, 1L, false);
  }
  
  public static void bYD()
  {
    fKz = System.currentTimeMillis();
    y.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report create session: %d", new Object[] { Long.valueOf(fKz) });
  }
  
  public static void ey(int paramInt1, int paramInt2)
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
        y.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(713), Integer.valueOf(paramInt1), Long.valueOf(1L) });
        com.tencent.mm.plugin.report.service.h.nFQ.a(713L, paramInt1, 1L, false);
      }
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 4;
        continue;
        paramInt1 = 5;
        continue;
        paramInt1 = 6;
      }
      else
      {
        paramInt1 = -1;
      }
    }
  }
  
  public static void kU(boolean paramBoolean)
  {
    y.i("MicroMsg.WalletLockReportManager", "alvinluo idkey fingerprint open result: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.nFQ;
    if (paramBoolean) {}
    for (long l = 0L;; l = 1L)
    {
      localh.a(713L, l, 1L, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.h
 * JD-Core Version:    0.7.0.1
 */