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
  public CancellationSignal GnW;
  
  public a()
  {
    AppMethodBeat.i(21);
    this.GnW = null;
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      fDD();
      AppMethodBeat.o(21);
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public final void fDD()
  {
    AppMethodBeat.i(23);
    this.GnW = new CancellationSignal();
    AppMethodBeat.o(23);
  }
  
  @SuppressLint({"NewApi"})
  public final boolean yG(final boolean paramBoolean)
  {
    AppMethodBeat.i(22);
    d.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.GnW.isCanceled())
    {
      if (Build.VERSION.SDK_INT < 23) {
        g.fDP().ag(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(18);
            d.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
            a.this.GnW.cancel();
            if (paramBoolean) {
              f.fDM().fDO();
            }
            AppMethodBeat.o(18);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(22);
        return true;
        g.fDP().ag(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(19);
            a.this.GnW.cancel();
            AppMethodBeat.o(19);
          }
        });
        g.fDP().o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(20);
            d.w("Soter.SoterFingerprintCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", new Object[] { Long.valueOf(350L) });
            f.fDM().fDO();
            AppMethodBeat.o(20);
          }
        }, 350L);
      }
    }
    d.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
    AppMethodBeat.o(22);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.d.a
 * JD-Core Version:    0.7.0.1
 */