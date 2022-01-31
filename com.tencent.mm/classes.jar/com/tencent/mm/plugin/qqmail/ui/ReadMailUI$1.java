package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;

final class ReadMailUI$1
  implements Runnable
{
  ReadMailUI$1(ReadMailUI paramReadMailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(68419);
    ReadMailUI.q(this.pOX);
    if (ReadMailUI.r(this.pOX) == 0)
    {
      ReadMailUI.s(this.pOX);
      if (!ReadMailUI.t(this.pOX)) {
        ReadMailUI.u(this.pOX);
      }
      ReadMailUI.a(this.pOX, new ReadMailProxy(ReadMailUI.l(this.pOX), null, new ReadMailUI.b(this.pOX), new ReadMailUI.c(this.pOX)));
      ReadMailUI.v(this.pOX).REMOTE_CALL("addDownloadCallback", new Object[0]);
    }
    AppMethodBeat.o(68419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.1
 * JD-Core Version:    0.7.0.1
 */