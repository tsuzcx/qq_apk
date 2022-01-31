package com.tencent.soter.core.d;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.soterserver.a;

final class d$1
  implements IBinder.DeathRecipient
{
  d$1(d paramd) {}
  
  public final void binderDied()
  {
    AppMethodBeat.i(73068);
    com.tencent.soter.core.c.d.i("Soter.SoterCoreTreble", "soter: binder died", new Object[0]);
    if (this.BmN.BmI == null)
    {
      AppMethodBeat.o(73068);
      return;
    }
    synchronized (d.a(this.BmN))
    {
      d.a(this.BmN, false);
      d.a(this.BmN).notifyAll();
      if (d.b(this.BmN) != null) {
        d.b(this.BmN).cyo();
      }
      this.BmN.BmI.asBinder().unlinkToDeath(d.c(this.BmN), 0);
      this.BmN.BmI = null;
      this.BmN.bfU();
      AppMethodBeat.o(73068);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.d.d.1
 * JD-Core Version:    0.7.0.1
 */