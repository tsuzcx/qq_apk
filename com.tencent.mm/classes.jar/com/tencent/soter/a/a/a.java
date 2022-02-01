package com.tencent.soter.a.a;

import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;

public final class a
{
  public CancellationSignal eMV;
  
  public a()
  {
    AppMethodBeat.i(11);
    this.eMV = null;
    if (Build.VERSION.SDK_INT >= 16) {
      jYs();
    }
    AppMethodBeat.o(11);
  }
  
  public final boolean Os(final boolean paramBoolean)
  {
    AppMethodBeat.i(12);
    d.v("Soter.SoterBiometricCanceller", "soter: publishing cancellation. should publish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.eMV.isCanceled())
    {
      if (Build.VERSION.SDK_INT < 23) {
        g.jYG().au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8);
            d.v("Soter.SoterBiometricCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
            a.this.eMV.cancel();
            if (paramBoolean) {
              f.jYD().jYF();
            }
            AppMethodBeat.o(8);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(12);
        return true;
        g.jYG().au(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(9);
            a.this.eMV.cancel();
            AppMethodBeat.o(9);
          }
        });
        g.jYG().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(10);
            d.w("Soter.SoterBiometricCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", new Object[] { Long.valueOf(350L) });
            f.jYD().jYF();
            AppMethodBeat.o(10);
          }
        }, 350L);
      }
    }
    d.i("Soter.SoterBiometricCanceller", "soter: cancellation signal already expired.", new Object[0]);
    AppMethodBeat.o(12);
    return false;
  }
  
  public final void jYs()
  {
    AppMethodBeat.i(13);
    this.eMV = new CancellationSignal();
    AppMethodBeat.o(13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.a.a
 * JD-Core Version:    0.7.0.1
 */