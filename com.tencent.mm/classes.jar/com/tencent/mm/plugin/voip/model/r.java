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
  public static r NOW;
  boolean FrV;
  int NON;
  v2protocal NOO;
  private boolean NOP;
  WeakReference<a> NOQ;
  int NOR;
  boolean NOS;
  private int NOT;
  public int NOU;
  public int NOV;
  MTimerHandler NOX;
  
  private r()
  {
    AppMethodBeat.i(115083);
    this.NON = 0;
    this.NOP = false;
    this.FrV = false;
    this.NOR = -1;
    this.NOS = false;
    this.NOT = 0;
    this.NOX = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115079);
        if (!r.this.NOS)
        {
          AppMethodBeat.o(115079);
          return false;
        }
        Object localObject1 = new byte[4];
        r.this.NOO.setAppCmd(54, (byte[])localObject1, 1);
        if (localObject1[0] == 1)
        {
          if (r.this.NON != 1) {
            v2protocal.NRr += 1;
          }
          v2protocal.Fno += 1;
          localObject2 = r.this;
          if ((!((r)localObject2).FrV) && (c.gxv()))
          {
            ((r)localObject2).FrV = true;
            Log.i("MicroMsg.VoipNetStatusChecker", "onNetWorkChangeToMobileNet");
            if (((r)localObject2).NOQ != null)
            {
              localObject2 = (r.a)((r)localObject2).NOQ.get();
              if (localObject2 != null) {
                ((r.a)localObject2).eIN();
              }
            }
          }
          localObject2 = r.this;
          if (c.gxv())
          {
            ((r)localObject2).FrV = true;
            Log.i("MicroMsg.VoipNetStatusChecker", "onNetWorkCostMax");
            if (((r)localObject2).NOQ != null)
            {
              localObject2 = (r.a)((r)localObject2).NOQ.get();
              if (localObject2 != null) {
                ((r.a)localObject2).eIO();
              }
            }
          }
        }
        r.this.NON = localObject1[0];
        Object localObject2 = r.this;
        byte[] arrayOfByte = new byte[4];
        localObject1 = new int[2];
        Object tmp209_208 = localObject1;
        tmp209_208[0] = -1;
        Object tmp213_209 = tmp209_208;
        tmp213_209[1] = -1;
        tmp213_209;
        if (((r)localObject2).NOO.setAppCmd(10, arrayOfByte, 4) < 0)
        {
          Log.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
          if (localObject1[0] != -1)
          {
            r.this.NOR = localObject1[0];
            r.this.NOU = (r.this.NOR + r.this.NOU);
            localObject2 = r.this;
            ((r)localObject2).NOV += 1;
            if (localObject1[1] != 0) {
              break label365;
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
          localObject1[1] = ((r)localObject2).NOO.GetNetBottleneckSide();
          Log.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject1[1]) });
          break;
          label365:
          r.a(r.this, false);
        }
      }
    }, true);
    this.NOO = new v2protocal(new MMHandler(Looper.getMainLooper()));
    AppMethodBeat.o(115083);
  }
  
  public static r gzC()
  {
    AppMethodBeat.i(115082);
    if (NOW == null) {
      NOW = new r();
    }
    r localr = NOW;
    AppMethodBeat.o(115082);
    return localr;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(115084);
    this.NOQ = new WeakReference(parama);
    AppMethodBeat.o(115084);
  }
  
  public final void gzD()
  {
    AppMethodBeat.i(115085);
    Log.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.NOR = -1;
    this.NOS = true;
    this.NOV = 0;
    this.NOU = 0;
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115080);
        r.this.NOX.startTimer(2000L);
        AppMethodBeat.o(115080);
      }
    }, 3000L);
    AppMethodBeat.o(115085);
  }
  
  public final void gzE()
  {
    AppMethodBeat.i(115086);
    Log.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.NOR = -1;
    this.NOP = false;
    this.FrV = false;
    this.NOS = false;
    this.NOV = 0;
    this.NOU = 0;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115081);
        r.this.NOX.stopTimer();
        AppMethodBeat.o(115081);
      }
    });
    AppMethodBeat.o(115086);
  }
  
  public static abstract interface a
  {
    public abstract void eIN();
    
    public abstract void eIO();
    
    public abstract void eIP();
    
    public abstract void tn(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */