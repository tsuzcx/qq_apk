package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class d$3
  extends ak
{
  d$3(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(30407);
    super.handleMessage(paramMessage);
    try
    {
      ab.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
      this.zwH.dFL();
      AppMethodBeat.o(30407);
      return;
    }
    catch (Exception paramMessage)
    {
      ab.printErrStackTrace("MicroMsg.AutoPlay", paramMessage, "", new Object[0]);
      AppMethodBeat.o(30407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.3
 * JD-Core Version:    0.7.0.1
 */