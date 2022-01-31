package com.tencent.mm.ui.chatting;

import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class s$f$1
  extends ak
{
  s$f$1(s.f paramf) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(30721);
    paramMessage = (View)paramMessage.obj;
    if (this.zzW.vap != paramMessage.getScrollY())
    {
      this.zzW.tau = true;
      this.zzW.handler.sendMessageDelayed(this.zzW.handler.obtainMessage(0, paramMessage), 5L);
      this.zzW.vap = paramMessage.getScrollY();
      AppMethodBeat.o(30721);
      return;
    }
    this.zzW.tau = false;
    AppMethodBeat.o(30721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.f.1
 * JD-Core Version:    0.7.0.1
 */