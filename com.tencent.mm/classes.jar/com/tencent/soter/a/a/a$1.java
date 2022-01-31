package com.tencent.soter.a.a;

import android.os.CancellationSignal;
import com.tencent.soter.a.g.f;
import com.tencent.soter.core.c.d;

final class a$1
  implements Runnable
{
  a$1(a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    d.v("Soter.SoterBiometricCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
    this.wPw.wuX.cancel();
    if (this.wPv) {
      f.cPH().cPJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */