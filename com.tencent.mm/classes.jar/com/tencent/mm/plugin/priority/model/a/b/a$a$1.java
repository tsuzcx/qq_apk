package com.tencent.mm.plugin.priority.model.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.storage.bv;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, bv parambv, k.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(87826);
    this.xbd.xbb.xba = new f(this.hHF.field_msgId, this.xbc.dlu, null);
    this.xbd.xbb.xba.ptB = true;
    g.ajj().a(221, this.xbd.xbb);
    g.ajj().a(this.xbd.xbb.xba, 0);
    AppMethodBeat.o(87826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */