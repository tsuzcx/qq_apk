package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteStatement;

public class b
{
  public static void a(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(235757);
    hr localhr;
    if (paramBoolean2)
    {
      localhr = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bh(paramString, paramLong);
      if (localhr == null)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "sender file %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
        AppMethodBeat.o(235757);
        return;
      }
      if ((localhr.rVU == 1) || (localhr.rVU == 2) || (localhr.rVU == 4)) {
        if (paramBoolean1) {
          break label355;
        }
      }
    }
    label355:
    for (int i = 5;; i = 3)
    {
      paramLong = System.currentTimeMillis();
      com.tencent.mm.plugin.priority.model.c.a(1, paramLong, i, localhr);
      paramString = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
      String str = localhr.Id;
      long l = localhr.RNc;
      paramString.GSI.bindLong(1, paramLong);
      paramString.GSI.bindLong(2, i);
      paramString.GSI.bindString(3, str);
      paramString.GSI.bindLong(4, l);
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateStatusAndDownloadTime %s res %s %s %s %s", new Object[] { Integer.valueOf(paramString.GSI.executeUpdateDelete()), str, Long.valueOf(l), Long.valueOf(paramLong), Integer.valueOf(i) });
      AppMethodBeat.o(235757);
      return;
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "already auto download msgid %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(235757);
      return;
      if (paramBoolean3)
      {
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download cancel %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
        ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().m(paramString, paramLong, 1);
        AppMethodBeat.o(235757);
        return;
      }
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "updateStatus download fail %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().m(paramString, paramLong, 4);
      AppMethodBeat.o(235757);
      return;
    }
  }
  
  public static double b(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(235746);
    double d = Math.max(Math.max(paramArrayOfDouble[0], paramArrayOfDouble[1]), paramArrayOfDouble[2]);
    AppMethodBeat.o(235746);
    return d;
  }
  
  public static void bf(String paramString, long paramLong)
  {
    AppMethodBeat.i(235752);
    hr localhr = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage().bh(paramString, paramLong);
    if (localhr == null)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "This File Sender is Me");
      AppMethodBeat.o(235752);
      return;
    }
    if (localhr.RNf > 0L)
    {
      Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileLogic", "onFileOpen file already use %s %s", new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(235752);
      return;
    }
    if (ab.Lj(localhr.RMW)) {
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jC(localhr.RMW, "@all");
    }
    ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgFileUsageStorage().jC(localhr.RMW, localhr.RMX);
    localhr.RNf = System.currentTimeMillis();
    c localc = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
    long l = localhr.RNf;
    localc.GSJ.bindLong(1, l);
    localc.GSJ.bindString(2, paramString);
    localc.GSJ.bindLong(3, paramLong);
    Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "updateOpenTime %s res %s %s %s", new Object[] { Integer.valueOf(localc.GSJ.executeUpdateDelete()), paramString, Long.valueOf(paramLong), Long.valueOf(l) });
    com.tencent.mm.plugin.priority.model.c.a(2, System.currentTimeMillis(), localhr.rVU, localhr);
    AppMethodBeat.o(235752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.b
 * JD-Core Version:    0.7.0.1
 */