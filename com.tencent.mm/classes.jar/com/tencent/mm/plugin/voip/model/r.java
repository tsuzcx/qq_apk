package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public final class r
{
  public static r AEw;
  int AEm;
  v2protocal AEn;
  private boolean AEo;
  boolean AEp;
  WeakReference<a> AEq;
  int AEr;
  boolean AEs;
  private int AEt;
  public int AEu;
  public int AEv;
  au AEx;
  
  private r()
  {
    AppMethodBeat.i(115083);
    this.AEm = 0;
    this.AEo = false;
    this.AEp = false;
    this.AEr = -1;
    this.AEs = false;
    this.AEt = 0;
    this.AEx = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115079);
        if (!r.this.AEs)
        {
          AppMethodBeat.o(115079);
          return false;
        }
        Object localObject1 = new byte[4];
        r.this.AEn.setAppCmd(54, (byte[])localObject1, 1);
        if (localObject1[0] == 1)
        {
          if (r.this.AEm != 1) {
            v2protocal.AGP += 1;
          }
          localObject2 = r.this;
          if ((!((r)localObject2).AEp) && (c.ehd()))
          {
            ((r)localObject2).AEp = true;
            ac.i("MicroMsg.VoipNetStatusChecker", "onNetWorkChangeToMobileNet");
            if (((r)localObject2).AEq != null)
            {
              localObject2 = (r.a)((r)localObject2).AEq.get();
              if (localObject2 != null) {
                ((r.a)localObject2).cTT();
              }
            }
          }
        }
        r.this.AEm = localObject1[0];
        Object localObject2 = r.this;
        byte[] arrayOfByte = new byte[4];
        localObject1 = new int[2];
        Object tmp150_149 = localObject1;
        tmp150_149[0] = -1;
        Object tmp154_150 = tmp150_149;
        tmp154_150[1] = -1;
        tmp154_150;
        if (((r)localObject2).AEn.setAppCmd(10, arrayOfByte, 4) < 0)
        {
          ac.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
          if (localObject1[0] != -1)
          {
            r.this.AEr = localObject1[0];
            r.this.AEu = (r.this.AEr + r.this.AEu);
            localObject2 = r.this;
            ((r)localObject2).AEv += 1;
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
          int i = bs.bv(arrayOfByte);
          localObject1[0] = i;
          localObject1[1] = ((r)localObject2).AEn.GetNetBottleneckSide();
          ac.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject1[1]) });
          break;
          label306:
          r.a(r.this, false);
        }
      }
    }, true);
    this.AEn = new v2protocal(new ao(Looper.getMainLooper()));
    AppMethodBeat.o(115083);
  }
  
  public static r ejf()
  {
    AppMethodBeat.i(115082);
    if (AEw == null) {
      AEw = new r();
    }
    r localr = AEw;
    AppMethodBeat.o(115082);
    return localr;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(115084);
    this.AEq = new WeakReference(parama);
    AppMethodBeat.o(115084);
  }
  
  public final void ejg()
  {
    AppMethodBeat.i(115085);
    ac.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.AEr = -1;
    this.AEs = true;
    this.AEv = 0;
    this.AEu = 0;
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115080);
        r.this.AEx.au(2000L, 2000L);
        AppMethodBeat.o(115080);
      }
    }, 3000L);
    AppMethodBeat.o(115085);
  }
  
  public final void ejh()
  {
    AppMethodBeat.i(115086);
    ac.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.AEr = -1;
    this.AEo = false;
    this.AEp = false;
    this.AEs = false;
    this.AEv = 0;
    this.AEu = 0;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115081);
        r.this.AEx.stopTimer();
        AppMethodBeat.o(115081);
      }
    });
    AppMethodBeat.o(115086);
  }
  
  public static abstract interface a
  {
    public abstract void cTT();
    
    public abstract void cTU();
    
    public abstract void ne(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */