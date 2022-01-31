package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    if (this.oaF.oax)
    {
      y.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(this.oaF.oaz) });
      return;
    }
    synchronized (this.oaF.oap)
    {
      if (this.oaF.oaq <= 0) {
        return;
      }
    }
    byte[] arrayOfByte = new byte[this.oaF.oaq];
    System.arraycopy(this.oaF.oap, 0, arrayOfByte, 0, this.oaF.oaq);
    this.oaF.oaq = 0;
    long l = this.oaF.oas;
    this.oaF.oax = true;
    int i = this.oaF.oat;
    int j = this.oaF.oar;
    int k = this.oaF.oaz;
    boolean bool = this.oaF.oay;
    int m = this.oaF.oaA;
    if (i == 367) {
      ??? = new f(arrayOfByte, j, l, k, bool, m);
    }
    for (;;)
    {
      au.Dk().a((m)???, 0);
      return;
      if (i == 408) {
        ??? = new g(arrayOfByte, j, l, k, bool, m);
      } else {
        ??? = null;
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|tryStartNetscene";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a.3
 * JD-Core Version:    0.7.0.1
 */