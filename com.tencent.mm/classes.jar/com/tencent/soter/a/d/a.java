package com.tencent.soter.a.d;

import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;

@Deprecated
public final class a
{
  public CancellationSignal eMV;
  
  public a()
  {
    AppMethodBeat.i(21);
    this.eMV = null;
    if (Build.VERSION.SDK_INT >= 16) {
      jYs();
    }
    AppMethodBeat.o(21);
  }
  
  public final boolean Ou(final boolean paramBoolean)
  {
    AppMethodBeat.i(22);
    d.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.eMV.isCanceled())
    {
      if (Build.VERSION.SDK_INT < 23) {
        g.jYG().au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(18);
            d.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
            a.this.eMV.cancel();
            if (paramBoolean) {
              f.jYD().jYF();
            }
            AppMethodBeat.o(18);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(22);
        return true;
        g.jYG().au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(19);
            a.this.eMV.cancel();
            AppMethodBeat.o(19);
          }
        });
        g.jYG().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(20);
            d.w("Soter.SoterFingerprintCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", new Object[] { Long.valueOf(350L) });
            f.jYD().jYF();
            AppMethodBeat.o(20);
          }
        }, 350L);
      }
    }
    d.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
    AppMethodBeat.o(22);
    return false;
  }
  
  public final void jYs()
  {
    AppMethodBeat.i(23);
    this.eMV = new CancellationSignal();
    AppMethodBeat.o(23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.d.a
 * JD-Core Version:    0.7.0.1
 */