package com.tencent.mm.ui.chatting;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.storage.bi;

final class k$5$1
  implements t.a
{
  k$5$1(k.5 param5) {}
  
  public final void a(t.a.a parama)
  {
    parama = u.oe(parama.fileName);
    if ((parama != null) && (parama.status == 199)) {
      k.b(this.vjl.dUy.field_imgPath, this.vjl.dol, parama.eHL, parama.eHH, parama.SD(), this.vjl.dUy.getType());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.5.1
 * JD-Core Version:    0.7.0.1
 */