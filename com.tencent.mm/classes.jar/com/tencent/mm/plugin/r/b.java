package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  public static String vZh = "afterLogin";
  public static String vZi = "afterSleep";
  public static String vZj = "getMore";
  public static int vZk = 0;
  public static int vZl = 1644429312;
  public static int vZm = 302122240;
  public static int vZn = 50;
  public static int vZo = 20;
  public static int vZp = 100;
  public static int vZq = 3;
  public static int vZr = 1;
  public static int vZs = 1;
  public static int vZt = 1000;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(26515);
    int i = 0;
    if (paramString.equals(vZh)) {
      i = 1;
    }
    for (;;)
    {
      g.yhR.f(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(26515);
      return;
      if (paramString.equals(vZi)) {
        i = 2;
      } else if (paramString.equals(vZj)) {
        i = 3;
      }
    }
  }
  
  public static void doB()
  {
    AppMethodBeat.i(26514);
    Object localObject = com.tencent.mm.model.c.d.aDs().wz("100224");
    if (((c)localObject).isValid())
    {
      localObject = ((c)localObject).foF();
      vZk = bt.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      vZl = bt.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      vZm = bt.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      vZn = bt.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      vZo = bt.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      vZp = bt.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      vZq = bt.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      vZr = bt.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      vZs = bt.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      vZt = bt.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    ad.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(vZk), Integer.valueOf(vZl), Integer.valueOf(vZm), Integer.valueOf(vZn), Integer.valueOf(vZo), Integer.valueOf(vZp), Integer.valueOf(vZq), Integer.valueOf(vZr), Integer.valueOf(vZs), Integer.valueOf(vZt) });
    AppMethodBeat.o(26514);
  }
  
  public static void m(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26516);
    g.yhR.f(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.r.b
 * JD-Core Version:    0.7.0.1
 */