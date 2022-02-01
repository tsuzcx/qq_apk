package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.clb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class n$1
  implements Runnable
{
  n$1(n paramn, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(152002);
    Iterator localIterator = this.BSX.iterator();
    if (localIterator.hasNext())
    {
      clb localclb = (clb)localIterator.next();
      Object localObject2 = this.BSY.getTag();
      int i = localclb.mBH;
      if (bt.gL(localclb.EgB)) {}
      for (Object localObject1 = "null";; localObject1 = String.valueOf(localclb.EgB.size()))
      {
        ad.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
        if (bt.gL(localclb.EgB)) {
          break;
        }
        localObject1 = localclb.EgB.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ckw)((Iterator)localObject1).next();
          n.a(this.BSY, localclb.mBH, (ckw)localObject2);
        }
        break;
      }
    }
    AppMethodBeat.o(152002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.n.1
 * JD-Core Version:    0.7.0.1
 */