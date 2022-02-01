package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public final class r
{
  public static r CuX;
  int CuN;
  v2protocal CuO;
  private boolean CuP;
  boolean CuQ;
  WeakReference<a> CuR;
  int CuS;
  boolean CuT;
  private int CuU;
  public int CuV;
  public int CuW;
  aw CuY;
  
  private r()
  {
    AppMethodBeat.i(115083);
    this.CuN = 0;
    this.CuP = false;
    this.CuQ = false;
    this.CuS = -1;
    this.CuT = false;
    this.CuU = 0;
    this.CuY = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115079);
        if (!r.this.CuT)
        {
          AppMethodBeat.o(115079);
          return false;
        }
        Object localObject1 = new byte[4];
        r.this.CuO.setAppCmd(54, (byte[])localObject1, 1);
        if (localObject1[0] == 1)
        {
          if (r.this.CuN != 1) {
            v2protocal.Cxr += 1;
          }
          localObject2 = r.this;
          if ((!((r)localObject2).CuQ) && (c.eyu()))
          {
            ((r)localObject2).CuQ = true;
            ae.i("MicroMsg.VoipNetStatusChecker", "onNetWorkChangeToMobileNet");
            if (((r)localObject2).CuR != null)
            {
              localObject2 = (r.a)((r)localObject2).CuR.get();
              if (localObject2 != null) {
                ((r.a)localObject2).dfW();
              }
            }
          }
        }
        r.this.CuN = localObject1[0];
        Object localObject2 = r.this;
        byte[] arrayOfByte = new byte[4];
        localObject1 = new int[2];
        Object tmp150_149 = localObject1;
        tmp150_149[0] = -1;
        Object tmp154_150 = tmp150_149;
        tmp154_150[1] = -1;
        tmp154_150;
        if (((r)localObject2).CuO.setAppCmd(10, arrayOfByte, 4) < 0)
        {
          ae.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
          if (localObject1[0] != -1)
          {
            r.this.CuS = localObject1[0];
            r.this.CuV = (r.this.CuS + r.this.CuV);
            localObject2 = r.this;
            ((r)localObject2).CuW += 1;
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
          int i = bu.bF(arrayOfByte);
          localObject1[0] = i;
          localObject1[1] = ((r)localObject2).CuO.GetNetBottleneckSide();
          ae.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject1[1]) });
          break;
          label306:
          r.a(r.this, false);
        }
      }
    }, true);
    this.CuO = new v2protocal(new aq(Looper.getMainLooper()));
    AppMethodBeat.o(115083);
  }
  
  public static r eAx()
  {
    AppMethodBeat.i(115082);
    if (CuX == null) {
      CuX = new r();
    }
    r localr = CuX;
    AppMethodBeat.o(115082);
    return localr;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(115084);
    this.CuR = new WeakReference(parama);
    AppMethodBeat.o(115084);
  }
  
  public final void eAy()
  {
    AppMethodBeat.i(115085);
    ae.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.CuS = -1;
    this.CuT = true;
    this.CuW = 0;
    this.CuV = 0;
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115080);
        r.this.CuY.ay(2000L, 2000L);
        AppMethodBeat.o(115080);
      }
    }, 3000L);
    AppMethodBeat.o(115085);
  }
  
  public final void eAz()
  {
    AppMethodBeat.i(115086);
    ae.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.CuS = -1;
    this.CuP = false;
    this.CuQ = false;
    this.CuT = false;
    this.CuW = 0;
    this.CuV = 0;
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115081);
        r.this.CuY.stopTimer();
        AppMethodBeat.o(115081);
      }
    });
    AppMethodBeat.o(115086);
  }
  
  public static abstract interface a
  {
    public abstract void dfW();
    
    public abstract void dfX();
    
    public abstract void nC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */