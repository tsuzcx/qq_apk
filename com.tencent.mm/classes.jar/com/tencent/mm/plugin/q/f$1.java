package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;

final class f$1
  implements as
{
  f$1(f paramf, d paramd) {}
  
  public final void aaq()
  {
    AppMethodBeat.i(22903);
    ab.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[] { Boolean.valueOf(this.oSW.oSU), Boolean.valueOf(a.jM(g.RJ().eHa)) });
    if ((this.oSW.oSU) && (a.jM(g.RJ().eHa)))
    {
      ab.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
      aw.aaz();
      c.b(this);
      this.oSW.oSU = false;
      this.oSW.a(this.oSC, false);
    }
    AppMethodBeat.o(22903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.q.f.1
 * JD-Core Version:    0.7.0.1
 */