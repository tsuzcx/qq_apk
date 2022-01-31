package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.os.Message;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

final class c$2
  extends ak
{
  c$2(c paramc) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(27152);
    if (c.a(this.vDt).vxs)
    {
      c.b(this.vDt).removeMessages(4096);
      AppMethodBeat.o(27152);
      return;
    }
    paramMessage = " " + a.C(ah.getContext(), c.a(this.vDt).vxE).toString();
    c.c(this.vDt).setText(paramMessage);
    sendEmptyMessageDelayed(4096, 500L);
    AppMethodBeat.o(27152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.c.2
 * JD-Core Version:    0.7.0.1
 */