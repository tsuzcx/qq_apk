package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$1
  implements Runnable
{
  n$1(n paramn, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(79558);
    Iterator localIterator = this.vNX.iterator();
    if (localIterator.hasNext())
    {
      bvi localbvi = (bvi)localIterator.next();
      Object localObject2 = this.vNY.getTag();
      int i = localbvi.jKs;
      if (bo.es(localbvi.xJb)) {}
      for (Object localObject1 = "null";; localObject1 = String.valueOf(localbvi.xJb.size()))
      {
        ab.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
        if (bo.es(localbvi.xJb)) {
          break;
        }
        localObject1 = localbvi.xJb.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bvd)((Iterator)localObject1).next();
          n.a(this.vNY, localbvi.jKs, (bvd)localObject2);
        }
        break;
      }
    }
    AppMethodBeat.o(79558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.n.1
 * JD-Core Version:    0.7.0.1
 */