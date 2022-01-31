package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public final class q
{
  public static q tyI;
  v2protocal tyA;
  private boolean tyB;
  private WeakReference<q.a> tyC;
  int tyD;
  boolean tyE;
  private int tyF;
  public int tyG;
  public int tyH;
  ap tyJ;
  
  private q()
  {
    AppMethodBeat.i(4571);
    this.tyB = false;
    this.tyD = -1;
    this.tyE = false;
    this.tyF = 0;
    this.tyJ = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(4567);
        if (!q.this.tyE)
        {
          AppMethodBeat.o(4567);
          return false;
        }
        q localq = q.this;
        byte[] arrayOfByte = new byte[4];
        int[] arrayOfInt = new int[2];
        int[] tmp39_38 = arrayOfInt;
        tmp39_38[0] = -1;
        int[] tmp43_39 = tmp39_38;
        tmp43_39[1] = -1;
        tmp43_39;
        if (localq.tyA.setAppCmd(10, arrayOfByte, 4) < 0)
        {
          ab.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
          if (arrayOfInt[0] != -1)
          {
            q.this.tyD = arrayOfInt[0];
            q.this.tyG = (q.this.tyD + q.this.tyG);
            localq = q.this;
            localq.tyH += 1;
            if (arrayOfInt[1] != 0) {
              break label196;
            }
            q.a(q.this, true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(4567);
          return true;
          int i = bo.bg(arrayOfByte);
          arrayOfInt[0] = i;
          arrayOfInt[1] = localq.tyA.GetNetBottleneckSide();
          ab.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", new Object[] { Integer.valueOf(i), Integer.valueOf(arrayOfInt[1]) });
          break;
          label196:
          q.a(q.this, false);
        }
      }
    }, true);
    this.tyA = new v2protocal(new ak(Looper.getMainLooper()));
    AppMethodBeat.o(4571);
  }
  
  public static q cNr()
  {
    AppMethodBeat.i(4570);
    if (tyI == null) {
      tyI = new q();
    }
    q localq = tyI;
    AppMethodBeat.o(4570);
    return localq;
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(4572);
    this.tyC = new WeakReference(parama);
    AppMethodBeat.o(4572);
  }
  
  public final void cNs()
  {
    AppMethodBeat.i(4573);
    ab.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.tyD = -1;
    this.tyE = true;
    this.tyH = 0;
    this.tyG = 0;
    al.p(new q.2(this), 3000L);
    AppMethodBeat.o(4573);
  }
  
  public final void cNt()
  {
    AppMethodBeat.i(4574);
    ab.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.tyD = -1;
    this.tyB = false;
    this.tyE = false;
    this.tyH = 0;
    this.tyG = 0;
    al.d(new q.3(this));
    AppMethodBeat.o(4574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.q
 * JD-Core Version:    0.7.0.1
 */