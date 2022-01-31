package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
{
  private static long sessionId = -1L;
  
  public static void al(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(51737);
    if (sessionId == -1L)
    {
      ab.e("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report sessionId is -1, not create session, ignore");
      AppMethodBeat.o(51737);
      return;
    }
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(51737);
      return;
    }
    ab.i("MicroMsg.WalletLockReportManager", "alvinluo reportVerifyWalletLock session: %d, protectScene: %d, walletLockType: %d, result: %d", new Object[] { Long.valueOf(sessionId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.h.qsU.e(14839, new Object[] { Long.valueOf(sessionId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(51737);
  }
  
  public static void cYl()
  {
    AppMethodBeat.i(51734);
    ab.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report fingerprintlock verify by passwd success");
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(713L, 2L, 1L, false);
    AppMethodBeat.o(51734);
  }
  
  public static void cYm()
  {
    AppMethodBeat.i(51735);
    ab.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report close wallet lock success");
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(713L, 3L, 1L, false);
    AppMethodBeat.o(51735);
  }
  
  public static void cYn()
  {
    AppMethodBeat.i(51736);
    sessionId = System.currentTimeMillis();
    ab.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report create session: %d", new Object[] { Long.valueOf(sessionId) });
    AppMethodBeat.o(51736);
  }
  
  public static void gC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51732);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        ab.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(713), Integer.valueOf(paramInt1), Long.valueOf(1L) });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(713L, paramInt1, 1L, false);
      }
      AppMethodBeat.o(51732);
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
  
  public static void od(boolean paramBoolean)
  {
    AppMethodBeat.i(51733);
    ab.i("MicroMsg.WalletLockReportManager", "alvinluo idkey fingerprint open result: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    if (paramBoolean) {}
    for (long l = 0L;; l = 1L)
    {
      localh.idkeyStat(713L, l, 1L, false);
      AppMethodBeat.o(51733);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.h
 * JD-Core Version:    0.7.0.1
 */