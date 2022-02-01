package com.tencent.mm.plugin.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  public static String FkX = "afterLogin";
  public static String FkY = "afterSleep";
  public static String FkZ = "getMore";
  public static int Fla = 0;
  public static int Flb = 1644429312;
  public static int Flc = 302122240;
  public static int Fld = 50;
  public static int Fle = 20;
  public static int Flf = 100;
  public static int Flg = 3;
  public static int Flh = 1;
  public static int Fli = 1;
  public static int Flj = 1000;
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(26515);
    int i = 0;
    if (paramString.equals(FkX)) {
      i = 1;
    }
    for (;;)
    {
      h.IzE.a(14108, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(26515);
      return;
      if (paramString.equals(FkY)) {
        i = 2;
      } else if (paramString.equals(FkZ)) {
        i = 3;
      }
    }
  }
  
  public static void eVc()
  {
    AppMethodBeat.i(26514);
    Object localObject = com.tencent.mm.model.c.d.bgB().Mu("100224");
    if (((c)localObject).isValid())
    {
      localObject = ((c)localObject).hvz();
      Fla = Util.getInt((String)((Map)localObject).get("SyncOpen"), 0);
      Flb = Util.getInt((String)((Map)localObject).get("WindowsVersion"), 1644429312);
      Flc = Util.getInt((String)((Map)localObject).get("MacVersion"), 302122240);
      Fld = Util.getInt((String)((Map)localObject).get("MsgSyncSessionCount"), 50);
      Fle = Util.getInt((String)((Map)localObject).get("MsgSyncMsgCount"), 20);
      Flf = Util.getInt((String)((Map)localObject).get("MsgSyncSessionListCount"), 100);
      Flg = Util.getInt((String)((Map)localObject).get("MsgSyncTimeLimit"), 3);
      Flh = Util.getInt((String)((Map)localObject).get("MsgSyncAfterSleepSwitch"), 1);
      Fli = Util.getInt((String)((Map)localObject).get("MsgSyncGetMoreSwitch"), 1);
      Flj = Util.getInt((String)((Map)localObject).get("MsgSyncGetMoreMaxMsgCount"), 1000);
    }
    Log.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d, AFTER_SLEEP_SWITCH:%d, GET_MORE_SWITCH:%d, GET_MORE_MAX_MSG_COUNT:%d", new Object[] { Integer.valueOf(Fla), Integer.valueOf(Flb), Integer.valueOf(Flc), Integer.valueOf(Fld), Integer.valueOf(Fle), Integer.valueOf(Flf), Integer.valueOf(Flg), Integer.valueOf(Flh), Integer.valueOf(Fli), Integer.valueOf(Flj) });
    AppMethodBeat.o(26514);
  }
  
  public static void m(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26516);
    h.IzE.a(14108, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.z.b
 * JD-Core Version:    0.7.0.1
 */