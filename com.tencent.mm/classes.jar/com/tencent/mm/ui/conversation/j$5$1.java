package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;

final class j$5$1
  implements Runnable
{
  j$5$1(j.5 param5) {}
  
  public final void run()
  {
    AppMethodBeat.i(34468);
    if ((j.i(this.Alh.Alf) != null) && (j.i(this.Alh.Alf).isShowing()))
    {
      ab.i("MicroMsg.InitHelper", "update dialog is showing.");
      AppMethodBeat.o(34468);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 60L, 1L, false);
    j.a(this.Alh.Alf, com.tencent.mm.ui.base.h.a(j.a(this.Alh.Alf), this.Alh.Alg.bjm, this.Alh.Alg.title, this.Alh.Alg.xUl, this.Alh.Alg.nDF, false, new j.5.1.1(this), new j.5.1.2(this)));
    i.dlY();
    AppMethodBeat.o(34468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.5.1
 * JD-Core Version:    0.7.0.1
 */