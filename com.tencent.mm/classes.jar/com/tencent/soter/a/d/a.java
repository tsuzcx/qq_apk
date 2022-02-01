package com.tencent.soter.a.d;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;
import junit.framework.Assert;

@Deprecated
public final class a
{
  public CancellationSignal NHn;
  
  public a()
  {
    AppMethodBeat.i(21);
    this.NHn = null;
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      hlF();
      AppMethodBeat.o(21);
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public final boolean DR(final boolean paramBoolean)
  {
    AppMethodBeat.i(22);
    d.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.NHn.isCanceled())
    {
      if (Build.VERSION.SDK_INT < 23) {
        g.hlR().aj(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(18);
            d.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
            a.this.NHn.cancel();
            if (paramBoolean) {
              f.hlO().hlQ();
            }
            AppMethodBeat.o(18);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(22);
        return true;
        g.hlR().aj(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(19);
            a.this.NHn.cancel();
            AppMethodBeat.o(19);
          }
        });
        g.hlR().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(20);
            d.w("Soter.SoterFingerprintCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", new Object[] { Long.valueOf(350L) });
            f.hlO().hlQ();
            AppMethodBeat.o(20);
          }
        }, 350L);
      }
    }
    d.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
    AppMethodBeat.o(22);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public final void hlF()
  {
    AppMethodBeat.i(23);
    this.NHn = new CancellationSignal();
    AppMethodBeat.o(23);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.d.a
 * JD-Core Version:    0.7.0.1
 */