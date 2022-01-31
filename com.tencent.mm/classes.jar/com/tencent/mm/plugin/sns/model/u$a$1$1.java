package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.platformtools.ah;

final class u$a$1$1
  implements Runnable
{
  u$a$1$1(u.a.1 param1, qv paramqv) {}
  
  public final void run()
  {
    if (!this.oqD.oqB.oqy.a(this.oqC, this.oqD.oqB.jZV)) {
      this.oqD.oqB.jZV.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.a.1.1
 * JD-Core Version:    0.7.0.1
 */