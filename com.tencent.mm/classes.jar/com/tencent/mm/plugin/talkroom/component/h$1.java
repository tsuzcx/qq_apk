package com.tencent.mm.plugin.talkroom.component;

import android.os.RemoteException;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.y;

final class h$1
  implements Runnable
{
  h$1(h paramh, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean) {}
  
  public final void run()
  {
    h.a(this.pAi, true);
    try
    {
      h.a(this.pAi).k(this.pAf.value, this.pAg.value, this.pAh);
      h.a(this.pAi, false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TalkRoomPlayer", localRemoteException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.h.1
 * JD-Core Version:    0.7.0.1
 */