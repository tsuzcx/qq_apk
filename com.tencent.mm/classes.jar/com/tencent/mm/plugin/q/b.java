package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  public static String zFN = "afterLogin";
  public static String zFO = "afterSleep";
  public static String zFP = "getMore";
  public static int zFQ = 0;
  public static int zFR = 1644429312;
  public static int zFS = 302122240;
  public static int zFT = 50;
  public static int zFU = 20;
  public static int zFV = 100;
  public static int zFW = 3;
  public static int zFX = 1;
  public static int zFY = 1;
  public static int zFZ = 1000;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(26515);
    int i = 0;
    if (paramString.equals(zFN)) {
      i = 1;
    }
    for (;;)
    {
      h.CyF.a(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(26515);
      return;
      if (paramString.equals(zFO)) {
        i = 2;
      } else if (paramString.equals(zFP)) {
        i = 3;
      }
    }
  }
  
  public static void elt()
  {
    AppMethodBeat.i(26514);
    Object localObject = com.tencent.mm.model.c.d.aXu().Fu("100224");
    if (((c)localObject).isValid())
    {
      localObject = ((c)localObject).gzz();
      zFQ = Util.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      zFR = Util.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      zFS = Util.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      zFT = Util.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      zFU = Util.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      zFV = Util.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      zFW = Util.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      zFX = Util.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      zFY = Util.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      zFZ = Util.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    Log.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(zFQ), Integer.valueOf(zFR), Integer.valueOf(zFS), Integer.valueOf(zFT), Integer.valueOf(zFU), Integer.valueOf(zFV), Integer.valueOf(zFW), Integer.valueOf(zFX), Integer.valueOf(zFY), Integer.valueOf(zFZ) });
    AppMethodBeat.o(26514);
  }
  
  public static void l(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26516);
    h.CyF.a(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.q.b
 * JD-Core Version:    0.7.0.1
 */