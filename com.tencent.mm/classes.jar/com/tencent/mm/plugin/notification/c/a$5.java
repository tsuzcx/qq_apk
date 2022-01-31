package com.tencent.mm.plugin.notification.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.ArrayList;

final class a$5
  implements ap.a
{
  a$5(a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(23107);
    if (this.piT.piM)
    {
      ab.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(this.piT.piK.piV.size()), Integer.valueOf(this.piT.piN.size()), Integer.valueOf(this.piT.piO.size()) });
      a.c(this.piT);
      ab.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[] { Integer.valueOf(this.piT.piK.piV.size()), Integer.valueOf(this.piT.piN.size()), Integer.valueOf(this.piT.piO.size()) });
      if (this.piT.piK.piV.size() > 0) {
        a.d(this.piT);
      }
      for (;;)
      {
        AppMethodBeat.o(23107);
        return true;
        a.e(this.piT);
      }
    }
    AppMethodBeat.o(23107);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a.5
 * JD-Core Version:    0.7.0.1
 */