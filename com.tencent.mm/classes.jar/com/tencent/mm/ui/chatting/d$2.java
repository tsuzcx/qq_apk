package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.chatting.c.as;

final class d$2
  extends ak
{
  d$2(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(30406);
    super.handleMessage(paramMessage);
    try
    {
      ab.i("MicroMsg.AutoPlay", "reset speaker");
      d.a(this.zwH);
      paramMessage = this.zwH;
      if (!this.zwH.zwv.mtW) {}
      for (boolean bool = true;; bool = false)
      {
        paramMessage.mtV = bool;
        AppMethodBeat.o(30406);
        return;
      }
      return;
    }
    catch (Exception paramMessage)
    {
      ab.printErrStackTrace("MicroMsg.AutoPlay", paramMessage, "", new Object[0]);
      AppMethodBeat.o(30406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.2
 * JD-Core Version:    0.7.0.1
 */