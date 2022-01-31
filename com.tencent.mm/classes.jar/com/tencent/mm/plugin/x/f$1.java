package com.tencent.mm.plugin.x;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements aq
{
  f$1(f paramf, d paramd) {}
  
  public final void Hn()
  {
    y.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[] { Boolean.valueOf(this.mtl.mtj), Boolean.valueOf(a.hw(g.DN().dJB)) });
    if ((this.mtl.mtj) && (a.hw(g.DN().dJB)))
    {
      y.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
      au.Hx();
      c.b(this);
      this.mtl.mtj = false;
      this.mtl.a(this.msR, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.x.f.1
 * JD-Core Version:    0.7.0.1
 */