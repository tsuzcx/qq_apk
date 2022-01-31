package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.a;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.vfs.e;

final class j$5
  implements Runnable
{
  j$5(j paramj, ckf paramckf) {}
  
  public final void run()
  {
    AppMethodBeat.i(34470);
    if ((this.Alg != null) && (this.Alg.nKT.equalsIgnoreCase(i.fU(ah.getContext()))))
    {
      if ((e.cN(this.Alg.xUk)) && (a.jdMethod_do(this.Alg.xUk)))
      {
        al.d(new j.5.1(this));
        AppMethodBeat.o(34470);
        return;
      }
      al.d(new j.5.2(this));
    }
    AppMethodBeat.o(34470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.5
 * JD-Core Version:    0.7.0.1
 */