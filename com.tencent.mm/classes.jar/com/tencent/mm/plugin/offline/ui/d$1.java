package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.h.a.rp;
import com.tencent.mm.h.a.rp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;

final class d$1
  implements Runnable
{
  d$1(d paramd, rp paramrp, boolean paramBoolean) {}
  
  public final void run()
  {
    if (g.DK())
    {
      if (this.mMi.cbe.cbg)
      {
        k.bpX();
        i locali = k.bqa();
        int i = this.mMi.cbe.cbh;
        locali.dx(i, i);
      }
    }
    else {
      return;
    }
    k.bpX();
    k.bqa().hZ(this.mMj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.d.1
 * JD-Core Version:    0.7.0.1
 */