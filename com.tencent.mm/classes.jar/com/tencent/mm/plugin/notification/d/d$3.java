package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

final class d$3
  implements Runnable
{
  d$3(d paramd, long paramLong, bi parambi) {}
  
  public final void run()
  {
    AppMethodBeat.i(23135);
    ab.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[] { Long.valueOf(this.cap) });
    pc localpc = new pc();
    localpc.cFK.cmQ = this.fkH;
    a.ymk.l(localpc);
    AppMethodBeat.o(23135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.d.3
 * JD-Core Version:    0.7.0.1
 */