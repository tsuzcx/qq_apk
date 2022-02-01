package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class r
{
  public static r UBw;
  boolean Loi;
  int UBm;
  v2protocal UBn;
  boolean UBo;
  private long UBp;
  WeakReference<a> UBq;
  int UBr;
  boolean UBs;
  int UBt;
  public int UBu;
  public int UBv;
  MTimerHandler UBx;
  
  private r()
  {
    AppMethodBeat.i(115083);
    this.UBm = 0;
    this.UBo = false;
    this.Loi = false;
    this.UBp = -1L;
    this.UBr = -1;
    this.UBs = false;
    this.UBt = 0;
    this.UBx = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115079);
        if (!r.this.UBs)
        {
          AppMethodBeat.o(115079);
          return false;
        }
        Object localObject1 = new byte[4];
        r.this.UBn.setAppCmd(54, (byte[])localObject1, 1);
        if (localObject1[0] == 1)
        {
          if (r.this.UBm != 1) {
            v2protocal.UEl += 1;
          }
          v2protocal.Ljx += 1;
          localObject2 = r.this;
          if ((!((r)localObject2).Loi) && (SubCoreVoip.hVs()))
          {
            ((r)localObject2).Loi = true;
            Log.i("MicroMsg.VoipNetStatusChecker", "onNetWorkChangeToMobileNet");
            if (((r)localObject2).UBq != null)
            {
              localObject2 = (r.a)((r)localObject2).UBq.get();
              if (localObject2 != null) {
                ((r.a)localObject2).fQN();
              }
            }
          }
          localObject2 = r.this;
          if (SubCoreVoip.hVs())
          {
            ((r)localObject2).Loi = true;
            Log.i("MicroMsg.VoipNetStatusChecker", "onNetWorkCostMax");
            if (((r)localObject2).UBq != null)
            {
              localObject2 = (r.a)((r)localObject2).UBq.get();
              if (localObject2 != null) {
                ((r.a)localObject2).fwx();
              }
            }
          }
        }
        r.this.UBm = localObject1[0];
        Object localObject2 = r.this;
        byte[] arrayOfByte = new byte[4];
        localObject1 = new int[2];
        Object tmp209_208 = localObject1;
        tmp209_208[0] = -1;
        Object tmp213_209 = tmp209_208;
        tmp213_209[1] = -1;
        tmp213_209;
        int i;
        if (((r)localObject2).UBn.setAppCmd(10, arrayOfByte, 4) < 0)
        {
          Log.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
          if (localObject1[0] != -1)
          {
            r.this.UBr = localObject1[0];
            r.this.UBu = (r.this.UBr + r.this.UBu);
            localObject2 = r.this;
            ((r)localObject2).UBv += 1;
            localObject2 = r.this;
            i = localObject1[1];
            if (((r)localObject2).UBr >= 5) {
              break label401;
            }
            if (i != -1)
            {
              if (i == 0) {
                ((r)localObject2).Gs(true);
              }
              if (i == 1) {
                ((r)localObject2).Gs(false);
              }
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(115079);
          return true;
          i = Util.byteArrayToInt(arrayOfByte);
          localObject1[0] = i;
          if ((i < 0) || (i >= 5)) {
            break;
          }
          localObject1[1] = ((r)localObject2).UBn.GetNetBottleneckSide();
          Log.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d net_bottleneck_side %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject1[1]) });
          break;
          label401:
          if (((r)localObject2).UBo) {
            if (((r)localObject2).UBt <= 0)
            {
              Log.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
              ((r)localObject2).UBt += 1;
            }
            else
            {
              ((r)localObject2).UBo = false;
              Log.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
              if (((r)localObject2).UBq != null)
              {
                localObject1 = (r.a)((r)localObject2).UBq.get();
                if (localObject1 != null) {
                  ((r.a)localObject1).fQO();
                }
              }
            }
          }
        }
      }
    }, true);
    this.UBn = new v2protocal(new MMHandler(Looper.getMainLooper()));
    AppMethodBeat.o(115083);
  }
  
  public static r hXJ()
  {
    AppMethodBeat.i(115082);
    if (UBw == null) {
      UBw = new r();
    }
    r localr = UBw;
    AppMethodBeat.o(115082);
    return localr;
  }
  
  public final void Gs(boolean paramBoolean)
  {
    AppMethodBeat.i(293300);
    if (paramBoolean)
    {
      v2protocal.UEw += 1;
      Log.d("MicroMsg.VoipNetStatusChecker", "my network bad");
    }
    long l;
    for (;;)
    {
      this.UBt = 0;
      l = System.currentTimeMillis();
      if (!this.UBo) {
        break;
      }
      AppMethodBeat.o(293300);
      return;
      v2protocal.UEx += 1;
      Log.d("MicroMsg.VoipNetStatusChecker", "otherside network bad");
    }
    if ((this.UBp != -1L) && (l - this.UBp < 5000L))
    {
      AppMethodBeat.o(293300);
      return;
    }
    this.UBo = true;
    this.UBp = l;
    Log.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
    if (this.UBq != null)
    {
      a locala = (a)this.UBq.get();
      if (locala != null) {
        locala.xy(paramBoolean);
      }
    }
    AppMethodBeat.o(293300);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(115084);
    this.UBq = new WeakReference(parama);
    AppMethodBeat.o(115084);
  }
  
  public final void hXK()
  {
    AppMethodBeat.i(115085);
    Log.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
    this.UBr = -1;
    this.UBp = -1L;
    this.UBs = true;
    this.UBv = 0;
    this.UBu = 0;
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115080);
        r.this.UBx.startTimer(2000L);
        AppMethodBeat.o(115080);
      }
    }, 3000L);
    AppMethodBeat.o(115085);
  }
  
  public final void hXL()
  {
    AppMethodBeat.i(115086);
    Log.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
    this.UBr = -1;
    this.UBp = -1L;
    this.UBo = false;
    this.Loi = false;
    this.UBs = false;
    this.UBv = 0;
    this.UBu = 0;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115081);
        r.this.UBx.stopTimer();
        AppMethodBeat.o(115081);
      }
    });
    AppMethodBeat.o(115086);
  }
  
  public static abstract interface a
  {
    public abstract void fQN();
    
    public abstract void fQO();
    
    public abstract void fwx();
    
    public abstract void xy(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r
 * JD-Core Version:    0.7.0.1
 */