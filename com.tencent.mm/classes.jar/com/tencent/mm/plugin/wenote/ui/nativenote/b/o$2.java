package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.os.Message;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

final class o$2
  extends ak
{
  o$2(o paramo) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(27185);
    if (o.a(this.vEi).vxs)
    {
      o.b(this.vEi).removeMessages(4096);
      AppMethodBeat.o(27185);
      return;
    }
    paramMessage = " " + a.C(ah.getContext(), o.a(this.vEi).vxE).toString();
    o.c(this.vEi).setText(paramMessage);
    sendEmptyMessageDelayed(4096, 500L);
    AppMethodBeat.o(27185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.o.2
 * JD-Core Version:    0.7.0.1
 */