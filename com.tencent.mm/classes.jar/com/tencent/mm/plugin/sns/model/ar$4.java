package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class ar$4
  implements Runnable
{
  ar$4(ar paramar, f paramf) {}
  
  public final void run()
  {
    String str = this.eGH.bJQ;
    synchronized (this.otO.otM)
    {
      Iterator localIterator = this.otO.otM.iterator();
      while (localIterator.hasNext())
      {
        n localn = (n)localIterator.next();
        if ((localn != null) && (bk.isEqual(str, localn.bGE())))
        {
          y.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[] { Integer.valueOf(this.otO.hashCode()), str });
          localIterator.remove();
        }
      }
    }
    o.St().cf(false);
    if (this.otO.eGE != null) {
      this.otO.eGE.eGf = null;
    }
    this.otO.eGE = null;
    this.otO.bEl();
    this.otO.bEj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar.4
 * JD-Core Version:    0.7.0.1
 */