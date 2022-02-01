package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storagebase.h;

final class u$4
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(124660);
    t localt = af.awk();
    long l = System.currentTimeMillis();
    int j = localt.eKa();
    int i;
    if (j <= 2000)
    {
      if ((ad.getLogLevel() > 0) || (j < 500))
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
      localt.gPa.execSQL("BizTimeLineInfo", str);
      ad.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData delete cost: %d, count: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(j) });
    }
    for (;;)
    {
      u.boz();
      AppMethodBeat.o(124660);
      return;
      if (ax.aFD("brandService").decodeInt("BizTimeLineDeleteOldData", 0) == 1)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label168:
      ad.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData count: %d", new Object[] { Integer.valueOf(j) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.u.4
 * JD-Core Version:    0.7.0.1
 */