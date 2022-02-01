package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storagebase.h;

final class y$5
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(124661);
    x localx = ag.aGv();
    long l = System.currentTimeMillis();
    int j = localx.ftv();
    int i;
    if (j <= 2000)
    {
      if ((ae.getLogLevel() > 0) || (j < 500))
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
      localx.hKK.execSQL("BizTimeLineInfo", str);
      ae.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData delete cost: %d, count: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(j) });
    }
    for (;;)
    {
      y.bAv();
      AppMethodBeat.o(124661);
      return;
      if (ay.aRX("brandService").decodeInt("BizTimeLineDeleteOldData", 0) == 1)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label168:
      ae.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData count: %d", new Object[] { Integer.valueOf(j) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.y.5
 * JD-Core Version:    0.7.0.1
 */