package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;

final class s$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(151391);
    r localr = z.afo();
    long l = System.currentTimeMillis();
    int j = localr.dwi();
    int i;
    if (j <= 10000)
    {
      if ((ab.getLogLevel() <= 0) && (j >= 500)) {
        break label143;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        String str = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineInfo", "orderFlag", "orderFlag", "BizTimeLineInfo", "orderFlag", Integer.valueOf(100) });
        localr.fnw.execSQL("BizTimeLineInfo", str);
        ab.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData delete cost: %d, count: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(j) });
      }
      s.Pt();
      AppMethodBeat.o(151391);
      return;
      label143:
      if (as.eu("brandService", 1).decodeInt("BizTimeLineDeleteOldData", 0) == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.s.1
 * JD-Core Version:    0.7.0.1
 */