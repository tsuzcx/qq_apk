package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Set;

final class g$6
  implements Runnable
{
  g$6(g paramg, int paramInt, awd paramawd, String paramString1, String paramString2) {}
  
  public final void run()
  {
    while (g.e(this.opn).size() >= 60)
    {
      localb = (g.b)g.e(this.opn).removeFirst();
      this.opn.opl.remove(localb.key);
    }
    y.i("MicroMsg.LazyerImageLoader2", "add loaderlist size:" + g.e(this.opn).size());
    g.b localb = new g.b(this.opn, i.aG(this.opo, this.opu.lsK), this.opv + this.opw, this.opv, this.opu, this.opo);
    if (!g.f(this.opn).aC(localb.key)) {
      g.e(this.opn).add(localb);
    }
    for (;;)
    {
      g.g(this.opn);
      return;
      this.opn.opl.remove(localb.key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.6
 * JD-Core Version:    0.7.0.1
 */