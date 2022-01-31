package com.tencent.mm.plugin.talkroom.component;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1
  implements Runnable
{
  h$1(h paramh, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(25736);
    h.a(this.tbU, true);
    try
    {
      h.a(this.tbU).p(this.tbR.value, this.tbS.value, this.tbT);
      h.a(this.tbU, false);
      AppMethodBeat.o(25736);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TalkRoomPlayer", localRemoteException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.h.1
 * JD-Core Version:    0.7.0.1
 */