package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(24591);
    if (this.qOO.qOG)
    {
      ab.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[] { Integer.valueOf(this.qOO.qOI) });
      AppMethodBeat.o(24591);
      return;
    }
    for (;;)
    {
      long l;
      int i;
      int j;
      int k;
      boolean bool;
      int m;
      synchronized (this.qOO.qOy)
      {
        if (this.qOO.qOz <= 0)
        {
          AppMethodBeat.o(24591);
          return;
        }
        byte[] arrayOfByte1 = new byte[this.qOO.qOz];
        System.arraycopy(this.qOO.qOy, 0, arrayOfByte1, 0, this.qOO.qOz);
        this.qOO.qOz = 0;
        l = this.qOO.qOB;
        this.qOO.qOG = true;
        i = this.qOO.qOC;
        j = this.qOO.qOA;
        k = this.qOO.qOI;
        bool = this.qOO.qOH;
        m = this.qOO.qOJ;
        if (i == 367)
        {
          ??? = new f(arrayOfByte1, j, l, k, bool, m);
          aw.Rc().a((m)???, 0);
          AppMethodBeat.o(24591);
          return;
        }
      }
      if (i == 408) {
        ??? = new g(arrayOfByte2, j, l, k, bool, m);
      } else {
        ??? = null;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(24592);
    String str = super.toString() + "|tryStartNetscene";
    AppMethodBeat.o(24592);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a.3
 * JD-Core Version:    0.7.0.1
 */