package com.tencent.mm.plugin.notification.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.notification.ui.b;
import com.tencent.mm.plugin.report.service.h;

final class a$3
  implements b
{
  a$3(a parama) {}
  
  public final void bYg()
  {
    AppMethodBeat.i(23105);
    h.qsU.e(11425, new Object[] { Integer.valueOf(this.piT.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    this.piT.bYb();
    this.piT.bYd();
    if (!this.piT.piM) {
      this.piT.piL.dismiss();
    }
    AppMethodBeat.o(23105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a.3
 * JD-Core Version:    0.7.0.1
 */