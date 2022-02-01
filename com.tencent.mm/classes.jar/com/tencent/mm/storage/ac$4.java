package com.tencent.mm.storage;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class ac$4
  implements Runnable
{
  public ac$4(ac paramac) {}
  
  public final void run()
  {
    AppMethodBeat.i(248813);
    if ((ac.acFK != null) && (ac.acFK.length > 0))
    {
      Log.d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed start");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < ac.acFK.length)
      {
        long l = System.currentTimeMillis();
        ac.a(this.acFU).execSQL("BizTimeLineInfo", ac.acFK[i]);
        int j = (int)((System.currentTimeMillis() - l) / 1000L);
        IDKey localIDKey = new IDKey();
        localIDKey.SetID(1049);
        localIDKey.SetKey(ac.ayD(j));
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
        i += 1;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(localArrayList, false);
      Log.d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed end");
    }
    AppMethodBeat.o(248813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.storage.ac.4
 * JD-Core Version:    0.7.0.1
 */