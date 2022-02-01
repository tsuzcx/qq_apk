package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  public static int tNA = 1644429312;
  public static int tNB = 302122240;
  public static int tNC = 50;
  public static int tND = 20;
  public static int tNE = 100;
  public static int tNF = 3;
  public static int tNG = 1;
  public static int tNH = 1;
  public static int tNI = 1000;
  public static String tNw = "afterLogin";
  public static String tNx = "afterSleep";
  public static String tNy = "getMore";
  public static int tNz = 0;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(26515);
    int i = 0;
    if (paramString.equals(tNw)) {
      i = 1;
    }
    for (;;)
    {
      h.vKh.f(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(26515);
      return;
      if (paramString.equals(tNx)) {
        i = 2;
      } else if (paramString.equals(tNy)) {
        i = 3;
      }
    }
  }
  
  public static void cRt()
  {
    AppMethodBeat.i(26514);
    Object localObject = com.tencent.mm.model.c.d.aty().qu("100224");
    if (((c)localObject).isValid())
    {
      localObject = ((c)localObject).eJy();
      tNz = bt.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      tNA = bt.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      tNB = bt.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      tNC = bt.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      tND = bt.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      tNE = bt.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      tNF = bt.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      tNG = bt.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      tNH = bt.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      tNI = bt.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    ad.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(tNz), Integer.valueOf(tNA), Integer.valueOf(tNB), Integer.valueOf(tNC), Integer.valueOf(tND), Integer.valueOf(tNE), Integer.valueOf(tNF), Integer.valueOf(tNG), Integer.valueOf(tNH), Integer.valueOf(tNI) });
    AppMethodBeat.o(26514);
  }
  
  public static void k(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26516);
    h.vKh.f(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.r.b
 * JD-Core Version:    0.7.0.1
 */