package com.tencent.soter.a.d;

import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.d;

final class a$1
  implements Runnable
{
  a$1(a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(10467);
    d.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
    this.Bnb.APY.cancel();
    if (this.BmU) {
      f.dVD().dVF();
    }
    AppMethodBeat.o(10467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.d.a.1
 * JD-Core Version:    0.7.0.1
 */