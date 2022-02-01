package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class r
{
  public static r Cdw;
  int Cdm;
  v2protocal Cdn;
  private boolean Cdo;
  boolean Cdp;
  WeakReference<a> Cdq;
  int Cdr;
  boolean Cds;
  private int Cdt;
  public int Cdu;
  public int Cdv;
  av Cdx;
  
  private r()
  {
    AppMethodBeat.i(115083);
    this.Cdm = 0;
    this.Cdo = false;
    this.Cdp = false;
    this.Cdr = -1;
    this.Cds = false;
    this.Cdt = 0;
    this.Cdx = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115079);
        if (!r.this.Cds)
        {
          AppMethodBeat.o(115079);
          return false;
        }
        Object localObject1 = new byte[4];
        r.this.Cdn.setAppCmd(54, (byte[])localObject1, 1);
        if (localObject1[0] == 1)
        {
          if (r.this.Cdm != 1) {
            v2protocal.CfQ += 1;
          }
          localObject2 = r.this;
          if ((!((r)localObject2).Cdp) && (c.euO()))
          {
            ((r)localObject2).Cdp = true;
            ad.i("MicroMsg.VoipNetStatusChecker", "onNetWorkChangeToMobileNet");
            if (((r)localObject2).Cdq != null)
            {
              localObject2 = (r.a)((r)localObject2).Cdq.get();
              if (localObject2 != null) {
                ((r.a)localObject2).dde();
              }
            }
          }
        }
        r.this.Cdm = localObject1[0];
        Object localObject2 = r.this;
        byte[] arrayOfByte = new byte[4];
        localObject1 = new int[2];
        Object tmp150_149 = localObject1;
        tmp150_149[0] = -1;
        Object tmp154_150 = tmp150_149;
        tmp154_150[1] = -1;
        tmp154_150;
        if (((r)localObject2).Cdn.setAppCmd(10, arrayOfByte, 4) < 0)
        {
          ad.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
          if (localObject1[0] != -1)
          {
            r.this.Cdr = localObject1[0];
            r.this.Cdu = (r.this.Cdr + r.this.Cdu);
            localObject2 = r.this;
            ((r)localObject2).Cdv += 1;
            if (localObject1[1] != 0) {
              break label306;
            }
            r.a(r.this, true);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(115079);
          return true;
          int i = bt.bC(arrayOfByte);
          localObject1[0] = i;
          localObject1[1] = ((r)localObject2).Cdn.GetNetBottleneckSide();
          ad.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject1[1]) });
          break;
          label306:
          r.a(r.this, false);
        }
      }
    }, true);
    this.Cdn = new v2protocal(new ap(Looper.getMainLooper()));
    AppMethodBeat.o(115083);
  }
  
  public static r ewQ()
  {
    AppMethodBeat.i(115082);
    if (Cdw == null) {
      Cdw = new r();
    }
    r localr = Cdw;
    AppMethodBeat.o(115082);
    return localr;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(115084);
    this.Cdq = new WeakReference(parama);
    AppMethodBeat.o(115084);
  }
  
  public final void ewR()
  {
    AppMethodBeat.i(115085);
    ad.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.Cdr = -1;
    this.Cds = true;
    this.Cdv = 0;
    this.Cdu = 0;
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115080);
        r.this.Cdx.az(2000L, 2000L);
        AppMethodBeat.o(115080);
      }
    }, 3000L);
    AppMethodBeat.o(115085);
  }
  
  public final void ewS()
  {
    AppMethodBeat.i(115086);
    ad.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.Cdr = -1;
    this.Cdo = false;
    this.Cdp = false;
    this.Cds = false;
    this.Cdv = 0;
    this.Cdu = 0;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115081);
        r.this.Cdx.stopTimer();
        AppMethodBeat.o(115081);
      }
    });
    AppMethodBeat.o(115086);
  }
  
  public static abstract interface a
  {
    public abstract void dde();
    
    public abstract void ddf();
    
    public abstract void ny(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */