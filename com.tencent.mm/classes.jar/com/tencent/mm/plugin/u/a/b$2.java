package com.tencent.mm.plugin.u.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b$2
  implements Runnable
{
  public b$2(b paramb, String paramString, b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(80751);
    b localb = this.pPs;
    Object localObject = this.pPp;
    b.a locala1 = this.pPq;
    List localList = (List)localb.bZ.get(localObject);
    if (localList == null) {
      ab.e("MicroMsg.FileScanQueueService", "removeFormCallbackList, list is null");
    }
    for (;;)
    {
      if ((localList != null) && (localList.isEmpty()))
      {
        localb.bZ.remove(localObject);
        localb.fGO.remove(localObject);
        localb.pPm.remove(localObject);
        if ((localb.pPn != null) && (localb.pPn.equals(localObject)))
        {
          localObject = localb.pPo;
          ab.i("MicroMsg.scanner.DecodeFile", "cancelled");
          ((a)localObject).mCancelled = true;
          localb.pPo = null;
        }
        localb.ceH();
      }
      AppMethodBeat.o(80751);
      return;
      Iterator localIterator = localList.iterator();
      if (localIterator.hasNext())
      {
        b.a locala2 = (b.a)localIterator.next();
        if ((locala2 == null) || (locala2 != locala1)) {
          break;
        }
        localList.remove(locala2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.b.2
 * JD-Core Version:    0.7.0.1
 */