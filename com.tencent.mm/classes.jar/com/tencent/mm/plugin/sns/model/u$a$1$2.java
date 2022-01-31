package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.platformtools.ah;

final class u$a$1$2
  implements Runnable
{
  u$a$1$2(u.a.1 param1, qv paramqv) {}
  
  public final void run()
  {
    if (!this.oqD.oqB.oqy.b(this.oqC, this.oqD.oqB.jZV)) {
      this.oqD.oqB.jZV.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.a.1.2
 * JD-Core Version:    0.7.0.1
 */