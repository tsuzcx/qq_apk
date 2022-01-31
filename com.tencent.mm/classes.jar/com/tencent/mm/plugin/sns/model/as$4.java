package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

final class as$4
  implements Runnable
{
  as$4(as paramas, f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(36648);
    String str = this.fWx.crk;
    synchronized (this.riG.riE)
    {
      Iterator localIterator = this.riG.riE.iterator();
      while (localIterator.hasNext())
      {
        n localn = (n)localIterator.next();
        if ((localn != null) && (bo.isEqual(str, localn.csH())))
        {
          ab.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[] { Integer.valueOf(this.riG.hashCode()), str });
          localIterator.remove();
        }
      }
    }
    o.alG().di(false);
    if (this.riG.fWu != null) {
      this.riG.fWu.fVW = null;
    }
    this.riG.fWu = null;
    this.riG.cpK();
    this.riG.cpJ();
    AppMethodBeat.o(36648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as.4
 * JD-Core Version:    0.7.0.1
 */