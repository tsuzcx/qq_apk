package com.tencent.mm.plugin.x;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class b
{
  public static String msB = "afterLogin";
  public static String msC = "afterSleep";
  public static String msD = "getMore";
  public static int msE = 0;
  public static int msF = 1644429312;
  public static int msG = 302122240;
  public static int msH = 50;
  public static int msI = 20;
  public static int msJ = 100;
  public static int msK = 3;
  public static int msL = 1;
  public static int msM = 1;
  public static int msN = 1000;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    if (paramString.equals(msB)) {
      i = 1;
    }
    for (;;)
    {
      h.nFQ.f(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      return;
      if (paramString.equals(msC)) {
        i = 2;
      } else if (paramString.equals(msD)) {
        i = 3;
      }
    }
  }
  
  public static void bkv()
  {
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100224");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).ctr();
      msE = bk.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      msF = bk.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      msG = bk.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      msH = bk.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      msI = bk.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      msJ = bk.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      msK = bk.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      msL = bk.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      msM = bk.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      msN = bk.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    y.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(msE), Integer.valueOf(msF), Integer.valueOf(msG), Integer.valueOf(msH), Integer.valueOf(msI), Integer.valueOf(msJ), Integer.valueOf(msK), Integer.valueOf(msL), Integer.valueOf(msM), Integer.valueOf(msN) });
  }
  
  public static void h(long paramLong, int paramInt1, int paramInt2)
  {
    h.nFQ.f(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.x.b
 * JD-Core Version:    0.7.0.1
 */