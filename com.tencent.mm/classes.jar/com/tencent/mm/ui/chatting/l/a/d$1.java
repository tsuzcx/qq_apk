package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.c.b.h;

final class d$1
  implements Runnable
{
  d$1(d paramd, Bundle paramBundle, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(32729);
    h localh = (h)this.zQE.caz.ay(h.class);
    if (this.zQo.getInt("SCENE", 0) == 1)
    {
      this.zQE.Qp(this.zQD);
      AppMethodBeat.o(32729);
      return;
    }
    if (this.zQo.getInt("SCENE", 0) == 2)
    {
      localh.PA(this.zQD);
      this.zQE.caz.bJ(this.zQD);
    }
    AppMethodBeat.o(32729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a.d.1
 * JD-Core Version:    0.7.0.1
 */