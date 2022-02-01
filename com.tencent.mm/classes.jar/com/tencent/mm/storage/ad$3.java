package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storagebase.h;

final class ad$3
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(124659);
    ac localac = af.bHl();
    long l = System.currentTimeMillis();
    int j = localac.dWF();
    int i;
    if (j <= 2000)
    {
      if ((Log.getLogLevel() > 0) || (j < 500))
      {
        i = 0;
        if (i == 0) {
          break label168;
        }
      }
    }
    else
    {
      String str = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineInfo", "orderFlag", "orderFlag", "BizTimeLineInfo", "orderFlag", Integer.valueOf(100) });
      localac.omV.execSQL("BizTimeLineInfo", str);
      Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData delete cost: %d, count: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(j) });
    }
    for (;;)
    {
      ad.aAs();
      AppMethodBeat.o(124659);
      return;
      if (MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizTimeLineDeleteOldData", 0) == 1)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label168:
      Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData count: %d", new Object[] { Integer.valueOf(j) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ad.3
 * JD-Core Version:    0.7.0.1
 */