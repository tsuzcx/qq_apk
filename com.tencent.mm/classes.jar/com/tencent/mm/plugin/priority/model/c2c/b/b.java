package com.tencent.mm.plugin.priority.model.c2c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.wcdb.database.SQLiteStatement;

public class b
{
  public static void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(283803);
    in localin;
    if (paramBoolean2)
    {
      localin = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bs(paramString, paramLong);
      if (localin == null)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "sender file %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
        AppMethodBeat.o(283803);
        return;
      }
      if ((localin.vhk == 1) || (localin.vhk == 2) || (localin.vhk == 4)) {
        if (paramBoolean1) {
          break label355;
        }
      }
    }
    label355:
    for (int i = 5;; i = 3)
    {
      paramLong = System.currentTimeMillis();
      com.tencent.mm.plugin.priority.model.c.a(1, paramLong, i, localin);
      paramString = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
      String str = localin.Id;
      long l = localin.YKq;
      paramString.MQm.bindLong(1, paramLong);
      paramString.MQm.bindLong(2, i);
      paramString.MQm.bindString(3, str);
      paramString.MQm.bindLong(4, l);
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatusAndDownloadTime %s res %s %s %s %s", new Object[] { Integer.valueOf(paramString.MQm.executeUpdateDelete()), str, Long.valueOf(l), Long.valueOf(paramLong), Integer.valueOf(i) });
      AppMethodBeat.o(283803);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "already auto download msgid %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(283803);
      return;
      if (paramBoolean3)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download cancel %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
        ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().o(paramString, paramLong, 1);
        AppMethodBeat.o(283803);
        return;
      }
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download fail %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
      ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().o(paramString, paramLong, 4);
      AppMethodBeat.o(283803);
      return;
    }
  }
  
  public static void bp(String paramString, long paramLong)
  {
    AppMethodBeat.i(283800);
    in localin = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bs(paramString, paramLong);
    if (localin == null)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "This File Sender is Me");
      AppMethodBeat.o(283800);
      return;
    }
    if (localin.YKt > 0L)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "onFileOpen file already use %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(283800);
      return;
    }
    if (au.bwE(localin.YKk)) {
      ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kW(localin.YKk, "@all");
    }
    ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgFileUsageStorage().kW(localin.YKk, localin.YKl);
    localin.YKt = System.currentTimeMillis();
    c localc = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
    long l = localin.YKt;
    localc.MQn.bindLong(1, l);
    localc.MQn.bindString(2, paramString);
    localc.MQn.bindLong(3, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateOpenTime %s res %s %s %s", new Object[] { Integer.valueOf(localc.MQn.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Long.valueOf(l) });
    com.tencent.mm.plugin.priority.model.c.a(2, System.currentTimeMillis(), localin.vhk, localin);
    AppMethodBeat.o(283800);
  }
  
  public static double d(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(283797);
    double d = Math.max(Math.max(paramArrayOfDouble[0], paramArrayOfDouble[1]), paramArrayOfDouble[2]);
    AppMethodBeat.o(283797);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.c2c.b.b
 * JD-Core Version:    0.7.0.1
 */