package com.tencent.mm.ui.widget.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

public final class h$1
  extends Handler
{
  public h$1(p paramp) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(198281);
    this.OTQ.dismiss();
    super.handleMessage(paramMessage);
    AppMethodBeat.o(198281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.h.1
 * JD-Core Version:    0.7.0.1
 */