package com.tencent.soter.core.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.soterserver.a.a;

final class d$2
  implements ServiceConnection
{
  d$2(d paramd) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    AppMethodBeat.i(73069);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: onServiceConnected", new Object[0]);
    synchronized (d.a(this.BmN))
    {
      d.a(this.BmN, true);
      d.a(this.BmN).notifyAll();
    }
    try
    {
      paramIBinder.linkToDeath(d.c(this.BmN), 0);
      this.BmN.BmI = a.a.N(paramIBinder);
      if (d.b(this.BmN) != null) {
        d.b(this.BmN).onServiceConnected();
      }
      com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: Binding is done - Service connected", new Object[0]);
      d.d(this.BmN).countDown();
      AppMethodBeat.o(73069);
      return;
      paramIBinder = finally;
      AppMethodBeat.o(73069);
      throw paramIBinder;
    }
    catch (RemoteException ???)
    {
      for (;;)
      {
        com.tencent.soter.core.c.d.e("Soter.SoterCoreTreble", "soter: Binding deathRecipient is error - RemoteException" + ???.toString(), new Object[0]);
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName arg1)
  {
    AppMethodBeat.i(73070);
    synchronized (d.a(this.BmN))
    {
      d.a(this.BmN, false);
      d.a(this.BmN).notifyAll();
      this.BmN.BmI = null;
      com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: unBinding is done - Service disconnected", new Object[0]);
      if (d.b(this.BmN) != null) {
        d.b(this.BmN).cyn();
      }
      d.d(this.BmN).countDown();
      this.BmN.bfU();
      AppMethodBeat.o(73070);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.d.d.2
 * JD-Core Version:    0.7.0.1
 */