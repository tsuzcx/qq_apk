package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  public static String uVZ = "afterLogin";
  public static String uWa = "afterSleep";
  public static String uWb = "getMore";
  public static int uWc = 0;
  public static int uWd = 1644429312;
  public static int uWe = 302122240;
  public static int uWf = 50;
  public static int uWg = 20;
  public static int uWh = 100;
  public static int uWi = 3;
  public static int uWj = 1;
  public static int uWk = 1;
  public static int uWl = 1000;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(26515);
    int i = 0;
    if (paramString.equals(uVZ)) {
      i = 1;
    }
    for (;;)
    {
      h.wUl.f(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(26515);
      return;
      if (paramString.equals(uWa)) {
        i = 2;
      } else if (paramString.equals(uWb)) {
        i = 3;
      }
    }
  }
  
  public static void dfd()
  {
    AppMethodBeat.i(26514);
    Object localObject = com.tencent.mm.model.c.d.aAp().tJ("100224");
    if (((c)localObject).isValid())
    {
      localObject = ((c)localObject).eYV();
      uWc = bs.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      uWd = bs.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      uWe = bs.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      uWf = bs.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      uWg = bs.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      uWh = bs.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      uWi = bs.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      uWj = bs.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      uWk = bs.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      uWl = bs.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    ac.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(uWc), Integer.valueOf(uWd), Integer.valueOf(uWe), Integer.valueOf(uWf), Integer.valueOf(uWg), Integer.valueOf(uWh), Integer.valueOf(uWi), Integer.valueOf(uWj), Integer.valueOf(uWk), Integer.valueOf(uWl) });
    AppMethodBeat.o(26514);
  }
  
  public static void l(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26516);
    h.wUl.f(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.r.b
 * JD-Core Version:    0.7.0.1
 */