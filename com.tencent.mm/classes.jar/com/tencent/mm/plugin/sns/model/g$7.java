package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.storage.az;

final class g$7
  implements Runnable
{
  g$7(g paramg, int paramInt, awd paramawd, az paramaz) {}
  
  public final void run()
  {
    e locale;
    b localb;
    awd localawd;
    if (!g.a(this.opn, this.opo, this.opu))
    {
      locale = new e(this.opu);
      locale.omU = this.opo;
      locale.lJQ = this.opu.lsK;
      localb = af.bDA();
      localawd = this.opu;
      if (this.opu.hQR != 6) {
        break label87;
      }
    }
    label87:
    for (int i = 5;; i = 1)
    {
      localb.a(localawd, i, locale, this.opx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.7
 * JD-Core Version:    0.7.0.1
 */