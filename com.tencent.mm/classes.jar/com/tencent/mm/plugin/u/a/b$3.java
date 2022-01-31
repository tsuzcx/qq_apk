package com.tencent.mm.plugin.u.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class b$3
  implements Runnable
{
  b$3(b paramb, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(80752);
    b localb = this.pPs;
    Object localObject1 = this.pPt;
    ab.i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", new Object[] { localb.pPn, localObject1 });
    Object localObject2 = (List)localb.bZ.get(localb.pPn);
    if ((localObject2 != null) && (localObject1 != null))
    {
      ab.d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
      localObject2 = ((List)localObject2).iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      ((b.a)((Iterator)localObject2).next()).a(localb.pPn, ((d)localObject1).result, ((d)localObject1).rawData, ((d)localObject1).cpE, ((d)localObject1).cpF, ((d)localObject1).pPC);
      continue;
      if (localObject2 != null)
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((b.a)((Iterator)localObject1).next()).XF(localb.pPn);
        }
      }
    }
    localb.bZ.remove(localb.pPn);
    localb.pPm.remove(localb.pPn);
    localb.pPn = null;
    localb.pPo = null;
    localb.ceH();
    AppMethodBeat.o(80752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.b.3
 * JD-Core Version:    0.7.0.1
 */