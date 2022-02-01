package com.tencent.soter.a.a;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;
import junit.framework.Assert;

public final class a
{
  public CancellationSignal GnW;
  
  public a()
  {
    AppMethodBeat.i(11);
    this.GnW = null;
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      fDD();
      AppMethodBeat.o(11);
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public final void fDD()
  {
    AppMethodBeat.i(13);
    this.GnW = new CancellationSignal();
    AppMethodBeat.o(13);
  }
  
  @SuppressLint({"NewApi"})
  public final boolean yE(final boolean paramBoolean)
  {
    AppMethodBeat.i(12);
    d.v("Soter.SoterBiometricCanceller", "soter: publishing cancellation. should publish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.GnW.isCanceled())
    {
      if (Build.VERSION.SDK_INT < 23) {
        g.fDP().ag(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(8);
            d.v("Soter.SoterBiometricCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
            a.this.GnW.cancel();
            if (paramBoolean) {
              f.fDM().fDO();
            }
            AppMethodBeat.o(8);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(12);
        return true;
        g.fDP().ag(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(9);
            a.this.GnW.cancel();
            AppMethodBeat.o(9);
          }
        });
        g.fDP().o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(10);
            d.w("Soter.SoterBiometricCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", new Object[] { Long.valueOf(350L) });
            f.fDM().fDO();
            AppMethodBeat.o(10);
          }
        }, 350L);
      }
    }
    d.i("Soter.SoterBiometricCanceller", "soter: cancellation signal already expired.", new Object[0]);
    AppMethodBeat.o(12);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.a.a
 * JD-Core Version:    0.7.0.1
 */