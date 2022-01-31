package com.tencent.soter.a.d;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;
import junit.framework.Assert;

@Deprecated
public final class a
{
  public CancellationSignal APY;
  
  public a()
  {
    AppMethodBeat.i(10470);
    this.APY = null;
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      dVt();
      AppMethodBeat.o(10470);
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public final void dVt()
  {
    AppMethodBeat.i(10472);
    this.APY = new CancellationSignal();
    AppMethodBeat.o(10472);
  }
  
  @SuppressLint({"NewApi"})
  public final boolean rX(boolean paramBoolean)
  {
    AppMethodBeat.i(10471);
    d.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.APY.isCanceled())
    {
      if (Build.VERSION.SDK_INT < 23) {
        g.dVG().O(new a.1(this, paramBoolean));
      }
      for (;;)
      {
        AppMethodBeat.o(10471);
        return true;
        g.dVG().O(new a.2(this));
        g.dVG().t(new a.3(this), 350L);
      }
    }
    d.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
    AppMethodBeat.o(10471);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.d.a
 * JD-Core Version:    0.7.0.1
 */