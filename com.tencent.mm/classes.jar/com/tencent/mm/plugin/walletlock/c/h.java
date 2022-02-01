package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  private static long sessionId = -1L;
  
  public static void CB(boolean paramBoolean)
  {
    AppMethodBeat.i(129935);
    Log.i("MicroMsg.WalletLockReportManager", "alvinluo idkey fingerprint open result: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    if (paramBoolean) {}
    for (long l = 0L;; l = 1L)
    {
      localh.idkeyStat(713L, l, 1L, false);
      AppMethodBeat.o(129935);
      return;
    }
  }
  
  public static void aN(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(129939);
    if (sessionId == -1L)
    {
      Log.e("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report sessionId is -1, not create session, ignore");
      AppMethodBeat.o(129939);
      return;
    }
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(129939);
      return;
    }
    Log.i("MicroMsg.WalletLockReportManager", "alvinluo reportVerifyWalletLock session: %d, protectScene: %d, walletLockType: %d, result: %d", new Object[] { Long.valueOf(sessionId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.h.IzE.a(14839, new Object[] { Long.valueOf(sessionId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(129939);
  }
  
  public static void gOc()
  {
    AppMethodBeat.i(129936);
    Log.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report fingerprintlock verify by passwd success");
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(713L, 2L, 1L, false);
    AppMethodBeat.o(129936);
  }
  
  public static void gOd()
  {
    AppMethodBeat.i(129937);
    Log.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report close wallet lock success");
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(713L, 3L, 1L, false);
    AppMethodBeat.o(129937);
  }
  
  public static void gOe()
  {
    AppMethodBeat.i(129938);
    sessionId = System.currentTimeMillis();
    Log.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report create session: %d", new Object[] { Long.valueOf(sessionId) });
    AppMethodBeat.o(129938);
  }
  
  public static void lo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129934);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        Log.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(713), Integer.valueOf(paramInt1), Long.valueOf(1L) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(713L, paramInt1, 1L, false);
      }
      AppMethodBeat.o(129934);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.h
 * JD-Core Version:    0.7.0.1
 */