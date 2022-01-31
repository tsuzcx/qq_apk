package com.tencent.soter.a.a;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;
import junit.framework.Assert;

public final class a
{
  public CancellationSignal wuX = null;
  
  public a()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      cPx();
      return;
    }
  }
  
  @SuppressLint({"NewApi"})
  public final void cPx()
  {
    this.wuX = new CancellationSignal();
  }
  
  @SuppressLint({"NewApi"})
  public final boolean oj(boolean paramBoolean)
  {
    d.v("Soter.SoterBiometricCanceller", "soter: publishing cancellation. should publish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.wuX.isCanceled())
    {
      if (Build.VERSION.SDK_INT < 23)
      {
        g.cPK().H(new a.1(this, paramBoolean));
        return true;
      }
      g.cPK().H(new a.2(this));
      g.cPK().m(new a.3(this), 350L);
      return true;
    }
    d.i("Soter.SoterBiometricCanceller", "soter: cancellation signal already expired.", new Object[0]);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.a.a
 * JD-Core Version:    0.7.0.1
 */