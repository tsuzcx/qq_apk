package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.ak;

final class k$4
  extends ak
{
  k$4(k paramk) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(26667);
    if (k.c(this.vwV).vxl.booleanValue())
    {
      k.d(this.vwV).dhU();
      k.c(this.vwV).vxl = Boolean.FALSE;
    }
    k.c(this.vwV).vxE = ((int)com.tencent.mm.bk.a.hi(k.e(this.vwV)));
    sendEmptyMessageDelayed(4096, 250L);
    AppMethodBeat.o(26667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k.4
 * JD-Core Version:    0.7.0.1
 */