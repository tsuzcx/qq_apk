package com.tencent.mm.plugin.notification.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.ArrayList;

final class a$8
  implements ap.a
{
  a$8(a parama, long paramLong) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(23110);
    if ((!this.piT.piN.contains(Long.valueOf(this.cap))) && (!this.piT.piO.contains(Long.valueOf(this.cap))) && (this.piT.piK.contains(this.cap)))
    {
      ab.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", new Object[] { Long.valueOf(this.cap) });
      this.piT.piO.add(Long.valueOf(this.cap));
      this.piT.piP.add(Long.valueOf(this.cap));
      if (this.piT.piN.size() + this.piT.piO.size() < this.piT.piK.piV.size()) {
        break label172;
      }
      a.e(this.piT);
    }
    for (;;)
    {
      AppMethodBeat.o(23110);
      return true;
      label172:
      long l = this.piT.piK.bYh();
      this.piT.kL(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a.8
 * JD-Core Version:    0.7.0.1
 */