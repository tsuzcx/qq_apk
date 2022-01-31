package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class e$3
  implements Runnable
{
  e$3(e parame, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(23157);
    ab.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[] { Long.valueOf(this.cap) });
    pe localpe = new pe();
    localpe.cFO.cFP = ((int)this.cap);
    a.ymk.l(localpe);
    AppMethodBeat.o(23157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.e.3
 * JD-Core Version:    0.7.0.1
 */