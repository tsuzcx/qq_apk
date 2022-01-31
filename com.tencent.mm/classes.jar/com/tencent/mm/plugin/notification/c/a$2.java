package com.tencent.mm.plugin.notification.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class a$2
  implements com.tencent.mm.plugin.notification.ui.a
{
  a$2(a parama) {}
  
  public final void bYe()
  {
    AppMethodBeat.i(23103);
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23101);
        h.qsU.e(11425, new Object[] { Integer.valueOf(a.2.this.piT.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
        a.2.this.piT.bYb();
        a.a(a.2.this.piT);
        a.2.this.piT.bXS();
        AppMethodBeat.o(23101);
      }
    });
    AppMethodBeat.o(23103);
  }
  
  public final void bYf()
  {
    AppMethodBeat.i(23104);
    ab.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23102);
        h.qsU.e(11425, new Object[] { Integer.valueOf(a.2.this.piT.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
        a.2.this.piT.bYb();
        a.2.this.piT.bXX();
        a.b(a.2.this.piT);
        a.2.this.piT.piL.dismiss();
        AppMethodBeat.o(23102);
      }
    });
    AppMethodBeat.o(23104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c.a.2
 * JD-Core Version:    0.7.0.1
 */