package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.storage.bi;

final class j$5$1
  implements t.a
{
  j$5$1(j.5 param5) {}
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(30537);
    parama = u.vr(parama.fileName);
    if ((parama != null) && (parama.status == 199)) {
      j.c(this.zyk.fkH.field_imgPath, this.zyk.efI, parama.fXB, parama.fXx, parama.alP(), this.zyk.fkH.getType());
    }
    AppMethodBeat.o(30537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.5.1
 * JD-Core Version:    0.7.0.1
 */