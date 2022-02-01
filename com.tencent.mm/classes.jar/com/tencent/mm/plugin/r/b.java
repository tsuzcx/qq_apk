package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  public static String wll = "afterLogin";
  public static String wlm = "afterSleep";
  public static String wln = "getMore";
  public static int wlo = 0;
  public static int wlp = 1644429312;
  public static int wlq = 302122240;
  public static int wlr = 50;
  public static int wls = 20;
  public static int wlt = 100;
  public static int wlu = 3;
  public static int wlv = 1;
  public static int wlw = 1;
  public static int wlx = 1000;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(26515);
    int i = 0;
    if (paramString.equals(wll)) {
      i = 1;
    }
    for (;;)
    {
      g.yxI.f(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(26515);
      return;
      if (paramString.equals(wlm)) {
        i = 2;
      } else if (paramString.equals(wln)) {
        i = 3;
      }
    }
  }
  
  public static void drz()
  {
    AppMethodBeat.i(26514);
    Object localObject = com.tencent.mm.model.c.d.aDI().xi("100224");
    if (((c)localObject).isValid())
    {
      localObject = ((c)localObject).fsy();
      wlo = bu.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      wlp = bu.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      wlq = bu.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      wlr = bu.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      wls = bu.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      wlt = bu.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      wlu = bu.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      wlv = bu.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      wlw = bu.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      wlx = bu.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    ae.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(wlo), Integer.valueOf(wlp), Integer.valueOf(wlq), Integer.valueOf(wlr), Integer.valueOf(wls), Integer.valueOf(wlt), Integer.valueOf(wlu), Integer.valueOf(wlv), Integer.valueOf(wlw), Integer.valueOf(wlx) });
    AppMethodBeat.o(26514);
  }
  
  public static void m(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26516);
    g.yxI.f(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.r.b
 * JD-Core Version:    0.7.0.1
 */