package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;

final class o$1
  extends ak
{
  o$1(o paramo) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(81185);
    if (this.qzQ.qzx >= this.qzQ.qzy)
    {
      if (this.qzQ.qzJ != null) {
        g.Rc().a(this.qzQ.qzJ);
      }
      paramMessage = this.qzQ;
      paramMessage.qzx -= 1;
    }
    AppMethodBeat.o(81185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.o.1
 * JD-Core Version:    0.7.0.1
 */