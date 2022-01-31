package com.tencent.mm.storage;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class r$7
  implements Runnable
{
  public r$7(r paramr) {}
  
  public final void run()
  {
    AppMethodBeat.i(151389);
    if ((r.ywC != null) && (r.ywC.length > 0))
    {
      ab.d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed start");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < r.ywC.length)
      {
        long l = System.currentTimeMillis();
        r.a(this.ywK).execSQL("BizTimeLineInfo", r.ywC[i]);
        int j = (int)((System.currentTimeMillis() - l) / 1000L);
        IDKey localIDKey = new IDKey();
        localIDKey.SetID(1049);
        localIDKey.SetKey(r.No(j));
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h.qsU.b(localArrayList, false);
      ab.d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed end");
    }
    AppMethodBeat.o(151389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.r.7
 * JD-Core Version:    0.7.0.1
 */