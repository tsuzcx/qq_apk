package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class r
{
  public static r GYJ;
  v2protocal GYA;
  private boolean GYB;
  boolean GYC;
  WeakReference<a> GYD;
  int GYE;
  boolean GYF;
  private int GYG;
  public int GYH;
  public int GYI;
  MTimerHandler GYK;
  int GYz;
  
  private r()
  {
    AppMethodBeat.i(115083);
    this.GYz = 0;
    this.GYB = false;
    this.GYC = false;
    this.GYE = -1;
    this.GYF = false;
    this.GYG = 0;
    this.GYK = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115079);
        if (!r.this.GYF)
        {
          AppMethodBeat.o(115079);
          return false;
        }
        Object localObject1 = new byte[4];
        r.this.GYA.setAppCmd(54, (byte[])localObject1, 1);
        if (localObject1[0] == 1)
        {
          if (r.this.GYz != 1) {
            v2protocal.Hbf += 1;
          }
          localObject2 = r.this;
          if ((!((r)localObject2).GYC) && (c.fFj()))
          {
            ((r)localObject2).GYC = true;
            Log.i("MicroMsg.VoipNetStatusChecker", "onNetWorkChangeToMobileNet");
            if (((r)localObject2).GYD != null)
            {
              localObject2 = (r.a)((r)localObject2).GYD.get();
              if (localObject2 != null) {
                ((r.a)localObject2).dZQ();
              }
            }
          }
        }
        r.this.GYz = localObject1[0];
        Object localObject2 = r.this;
        byte[] arrayOfByte = new byte[4];
        localObject1 = new int[2];
        Object tmp150_149 = localObject1;
        tmp150_149[0] = -1;
        Object tmp154_150 = tmp150_149;
        tmp154_150[1] = -1;
        tmp154_150;
        if (((r)localObject2).GYA.setAppCmd(10, arrayOfByte, 4) < 0)
        {
          Log.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
          if (localObject1[0] != -1)
          {
            r.this.GYE = localObject1[0];
            r.this.GYH = (r.this.GYE + r.this.GYH);
            localObject2 = r.this;
            ((r)localObject2).GYI += 1;
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
          int i = Util.byteArrayToInt(arrayOfByte);
          localObject1[0] = i;
          localObject1[1] = ((r)localObject2).GYA.GetNetBottleneckSide();
          Log.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject1[1]) });
          break;
          label306:
          r.a(r.this, false);
        }
      }
    }, true);
    this.GYA = new v2protocal(new MMHandler(Looper.getMainLooper()));
    AppMethodBeat.o(115083);
  }
  
  public static r fHo()
  {
    AppMethodBeat.i(115082);
    if (GYJ == null) {
      GYJ = new r();
    }
    r localr = GYJ;
    AppMethodBeat.o(115082);
    return localr;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(115084);
    this.GYD = new WeakReference(parama);
    AppMethodBeat.o(115084);
  }
  
  public final void fHp()
  {
    AppMethodBeat.i(115085);
    Log.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.GYE = -1;
    this.GYF = true;
    this.GYI = 0;
    this.GYH = 0;
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115080);
        r.this.GYK.startTimer(2000L);
        AppMethodBeat.o(115080);
      }
    }, 3000L);
    AppMethodBeat.o(115085);
  }
  
  public final void fHq()
  {
    AppMethodBeat.i(115086);
    Log.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.GYE = -1;
    this.GYB = false;
    this.GYC = false;
    this.GYF = false;
    this.GYI = 0;
    this.GYH = 0;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115081);
        r.this.GYK.stopTimer();
        AppMethodBeat.o(115081);
      }
    });
    AppMethodBeat.o(115086);
  }
  
  public static abstract interface a
  {
    public abstract void dZQ();
    
    public abstract void dZR();
    
    public abstract void ql(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */