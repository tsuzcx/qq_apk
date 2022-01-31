package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class b
{
  public static String oSm = "afterLogin";
  public static String oSn = "afterSleep";
  public static String oSo = "getMore";
  public static int oSp = 0;
  public static int oSq = 1644429312;
  public static int oSr = 302122240;
  public static int oSs = 50;
  public static int oSt = 20;
  public static int oSu = 100;
  public static int oSv = 3;
  public static int oSw = 1;
  public static int oSx = 1;
  public static int oSy = 1000;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(22891);
    int i = 0;
    if (paramString.equals(oSm)) {
      i = 1;
    }
    for (;;)
    {
      h.qsU.e(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(22891);
      return;
      if (paramString.equals(oSn)) {
        i = 2;
      } else if (paramString.equals(oSo)) {
        i = 3;
      }
    }
  }
  
  public static void bSv()
  {
    AppMethodBeat.i(22890);
    Object localObject = com.tencent.mm.model.c.c.abU().me("100224");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).dvN();
      oSp = bo.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      oSq = bo.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      oSr = bo.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      oSs = bo.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      oSt = bo.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      oSu = bo.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      oSv = bo.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      oSw = bo.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      oSx = bo.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      oSy = bo.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    ab.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(oSp), Integer.valueOf(oSq), Integer.valueOf(oSr), Integer.valueOf(oSs), Integer.valueOf(oSt), Integer.valueOf(oSu), Integer.valueOf(oSv), Integer.valueOf(oSw), Integer.valueOf(oSx), Integer.valueOf(oSy) });
    AppMethodBeat.o(22890);
  }
  
  public static void k(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22892);
    h.qsU.e(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(22892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.q.b
 * JD-Core Version:    0.7.0.1
 */