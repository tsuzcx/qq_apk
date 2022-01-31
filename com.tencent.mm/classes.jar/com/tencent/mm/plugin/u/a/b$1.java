package com.tencent.mm.plugin.u.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString, b.a parama, Set paramSet) {}
  
  public final void run()
  {
    AppMethodBeat.i(80750);
    b localb = this.pPs;
    Object localObject1 = this.pPp;
    b.a locala1 = this.pPq;
    Object localObject2 = this.pPr;
    localb.pPm.put(localObject1, localObject2);
    if (localb.bZ.containsKey(localObject1))
    {
      localObject1 = (List)localb.bZ.get(localObject1);
      label103:
      int i;
      if (localObject1 != null)
      {
        if (localObject1 != null)
        {
          if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
            break label126;
          }
          ab.e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
          break label135;
          i = 0;
          label105:
          if (i == 0) {
            break label173;
          }
        }
        ab.e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
      }
      for (;;)
      {
        localb.ceH();
        AppMethodBeat.o(80750);
        return;
        label126:
        localObject2 = ((List)localObject1).iterator();
        label135:
        if (!((Iterator)localObject2).hasNext()) {
          break label103;
        }
        b.a locala2 = (b.a)((Iterator)localObject2).next();
        if ((locala2 == null) || (locala2 != locala1)) {
          break;
        }
        i = 1;
        break label105;
        label173:
        ((List)localObject1).add(locala1);
      }
    }
    localObject2 = new LinkedList();
    ((List)localObject2).add(locala1);
    localb.bZ.put(localObject1, localObject2);
    localb.fGO.add(localObject1);
    localb.ceH();
    AppMethodBeat.o(80750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.b.1
 * JD-Core Version:    0.7.0.1
 */