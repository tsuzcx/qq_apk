package com.tencent.mm.plugin.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  public static String LgZ = "afterLogin";
  public static String Lha = "afterSleep";
  public static String Lhb = "getMore";
  public static int Lhc = 0;
  public static int Lhd = 1644429312;
  public static int Lhe = 302122240;
  public static int Lhf = 50;
  public static int Lhg = 20;
  public static int Lhh = 100;
  public static int Lhi = 3;
  public static int Lhj = 1;
  public static int Lhk = 1;
  public static int Lhl = 1000;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(26515);
    int i = 0;
    if (paramString.equals(LgZ)) {
      i = 1;
    }
    for (;;)
    {
      h.OAn.b(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(26515);
      return;
      if (paramString.equals(Lha)) {
        i = 2;
      } else if (paramString.equals(Lhb)) {
        i = 3;
      }
    }
  }
  
  public static void gdP()
  {
    AppMethodBeat.i(26514);
    Object localObject = com.tencent.mm.model.newabtest.d.bEt().Fd("100224");
    if ((localObject != null) && (((c)localObject).isValid()))
    {
      localObject = ((c)localObject).iWZ();
      Lhc = Util.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      Lhd = Util.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      Lhe = Util.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      Lhf = Util.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      Lhg = Util.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      Lhh = Util.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      Lhi = Util.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      Lhj = Util.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      Lhk = Util.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      Lhl = Util.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    Log.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(Lhc), Integer.valueOf(Lhd), Integer.valueOf(Lhe), Integer.valueOf(Lhf), Integer.valueOf(Lhg), Integer.valueOf(Lhh), Integer.valueOf(Lhi), Integer.valueOf(Lhj), Integer.valueOf(Lhk), Integer.valueOf(Lhl) });
    AppMethodBeat.o(26514);
  }
  
  public static void u(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26516);
    h.OAn.b(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.z.b
 * JD-Core Version:    0.7.0.1
 */