package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class r
{
  public static r zlI;
  v2protocal zlA;
  private boolean zlB;
  private WeakReference<a> zlC;
  int zlD;
  boolean zlE;
  private int zlF;
  public int zlG;
  public int zlH;
  av zlJ;
  
  private r()
  {
    AppMethodBeat.i(115083);
    this.zlB = false;
    this.zlD = -1;
    this.zlE = false;
    this.zlF = 0;
    this.zlJ = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115079);
        if (!r.this.zlE)
        {
          AppMethodBeat.o(115079);
          return false;
        }
        r localr = r.this;
        byte[] arrayOfByte = new byte[4];
        int[] arrayOfInt = new int[2];
        int[] tmp37_36 = arrayOfInt;
        tmp37_36[0] = -1;
        int[] tmp41_37 = tmp37_36;
        tmp41_37[1] = -1;
        tmp41_37;
        if (localr.zlA.setAppCmd(10, arrayOfByte, 4) < 0)
        {
          ad.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
          if (arrayOfInt[0] != -1)
          {
            r.this.zlD = arrayOfInt[0];
            r.this.zlG = (r.this.zlD + r.this.zlG);
            localr = r.this;
            localr.zlH += 1;
            if (arrayOfInt[1] != 0) {
              break label193;
            }
            r.a(r.this, true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(115079);
          return true;
          int i = bt.bw(arrayOfByte);
          arrayOfInt[0] = i;
          arrayOfInt[1] = localr.zlA.GetNetBottleneckSide();
          ad.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", new Object[] { Integer.valueOf(i), Integer.valueOf(arrayOfInt[1]) });
          break;
          label193:
          r.a(r.this, false);
        }
      }
    }, true);
    this.zlA = new v2protocal(new ap(Looper.getMainLooper()));
    AppMethodBeat.o(115083);
  }
  
  public static r dTT()
  {
    AppMethodBeat.i(115082);
    if (zlI == null) {
      zlI = new r();
    }
    r localr = zlI;
    AppMethodBeat.o(115082);
    return localr;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(115084);
    this.zlC = new WeakReference(parama);
    AppMethodBeat.o(115084);
  }
  
  public final void dTU()
  {
    AppMethodBeat.i(115085);
    ad.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.zlD = -1;
    this.zlE = true;
    this.zlH = 0;
    this.zlG = 0;
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115080);
        r.this.zlJ.av(2000L, 2000L);
        AppMethodBeat.o(115080);
      }
    }, 3000L);
    AppMethodBeat.o(115085);
  }
  
  public final void dTV()
  {
    AppMethodBeat.i(115086);
    ad.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.zlD = -1;
    this.zlB = false;
    this.zlE = false;
    this.zlH = 0;
    this.zlG = 0;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115081);
        r.this.zlJ.stopTimer();
        AppMethodBeat.o(115081);
      }
    });
    AppMethodBeat.o(115086);
  }
  
  public static abstract interface a
  {
    public abstract void cGJ();
    
    public abstract void ml(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */