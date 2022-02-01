package com.tencent.mm.plugin.u;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  implements c
{
  long EXA;
  boolean EXB;
  public l EXC;
  boolean EXD;
  a EXE;
  int EXF;
  private MMHandler.Callback EXG;
  private MMHandler.Callback EXH;
  private MMHandler.Callback EXI;
  public h EXa;
  MMHandler EXb;
  MMHandler EXx;
  MMHandler EXy;
  MMHandler EXz;
  long aNh;
  public long durationMs;
  boolean iYs;
  public int state;
  
  public k(MMHandler paramMMHandler, com.tencent.e.j.a parama, Looper paramLooper1, Looper paramLooper2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(205108);
    this.EXB = false;
    this.EXD = false;
    this.EXF = -1;
    this.EXG = new MMHandler.Callback()
    {
      private int EXJ = -1;
      private int EXK = -1;
      private long EXL = -1L;
      private int xqS = -1;
      
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133932);
        int i = paramAnonymousMessage.what;
        if ((this.EXL <= 0L) || (Util.ticksToNow(this.EXL) > 500L) || (this.EXJ != i) || (this.xqS != k.this.state) || (this.EXK != k.this.EXC.state))
        {
          Log.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { k.this.info(), Integer.valueOf(i), Integer.valueOf(k.this.state), Integer.valueOf(k.this.EXC.state) });
          this.EXL = Util.currentTicks();
          this.EXJ = i;
          this.xqS = k.this.state;
          this.EXK = k.this.EXC.state;
        }
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(133932);
          return false;
          if (k.this.state < 2) {}
          for (i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(133932);
            return false;
          }
          boolean bool2 = e.WG(k.this.EXC.state);
          boolean bool1 = bool2;
          if (k.this.EXE != null) {
            bool1 = bool2 & e.WG(k.this.EXE.state);
          }
          if (bool1)
          {
            k.this.setState(2);
            k.this.EXb.obtainMessage(1).sendToTarget();
            continue;
            k.a(k.this);
            continue;
            if (e.WK(k.this.state))
            {
              AppMethodBeat.o(133932);
              return false;
            }
            if ((e.WM(k.this.state)) || (e.WJ(k.this.state)))
            {
              k.this.setState(9);
              k.this.EXb.obtainMessage(2).sendToTarget();
              AppMethodBeat.o(133932);
              return false;
            }
            bool2 = e.WK(k.this.EXC.state);
            bool1 = bool2;
            if (k.this.EXE != null) {
              bool1 = bool2 & e.WK(k.this.EXE.state);
            }
            if (bool1)
            {
              k.this.setState(9);
              k.this.EXb.obtainMessage(2).sendToTarget();
              continue;
              if ((k.this.EXB) && ((k.this.iYs) || (k.this.EXD))) {
                k.this.EXb.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.EXH = new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133933);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(133933);
          return false;
          if (k.this.EXC.prepare())
          {
            k.this.durationMs = k.this.EXC.durationMs;
            k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
          }
          else
          {
            k.this.EXb.obtainMessage(5, -1, -1).sendToTarget();
            AppMethodBeat.o(133933);
            return false;
            paramAnonymousMessage = k.this.EXa;
            long l = Util.ticksToNow(paramAnonymousMessage.EWT);
            if ((paramAnonymousMessage.EWT > 0L) && (l >= 30L))
            {
              Log.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramAnonymousMessage.info(), Long.valueOf(paramAnonymousMessage.EWT), Long.valueOf(l) });
              paramAnonymousMessage.EWU = 0L;
            }
            if (e.WK(k.this.EXC.state))
            {
              k.this.EXz.obtainMessage(9).sendToTarget();
              k.this.EXx.removeMessages(2);
            }
            else if (e.WL(k.this.EXC.state))
            {
              k.this.EXb.obtainMessage(-1, -1, -1).sendToTarget();
              k.this.EXx.removeMessages(2);
            }
            else
            {
              int j = k.this.EXC.ah(k.this.aNh, k.this.EXA);
              if (e.WG(j)) {
                k.this.EXz.obtainMessage(2).sendToTarget();
              }
              if (j == 7) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label396;
                }
                k.this.EXz.obtainMessage(7).sendToTarget();
                k.this.EXx.removeMessages(2);
                break;
              }
              label396:
              if (e.WN(j))
              {
                k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
                k.this.EXa.EWT = Util.currentTicks();
              }
              else
              {
                if (k.this.state == 3) {
                  k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), k.this.EXa.EWU);
                }
                for (;;)
                {
                  k.this.EXa.EWT = Util.currentTicks();
                  break;
                  if (k.this.state == 5) {
                    k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 1) {
                    k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 0) {
                    k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 6) {
                    k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
                  } else {
                    k.this.EXx.removeMessages(2);
                  }
                }
                k.this.WR(3);
                k.this.EXC.start();
                k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
                continue;
                k.this.WR(4);
                k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
                k.this.EXC.pause();
                continue;
                k.this.EXC.release();
                k.this.EXB = true;
                k.this.EXz.obtainMessage(0).sendToTarget();
                continue;
                k.this.EXC.eSP();
                continue;
                if ((paramAnonymousMessage.obj instanceof int[]))
                {
                  paramAnonymousMessage = (int[])paramAnonymousMessage.obj;
                  if (paramAnonymousMessage.length == 2)
                  {
                    j = paramAnonymousMessage[0];
                    label799:
                    boolean bool;
                    if (paramAnonymousMessage[1] == 1)
                    {
                      i = 1;
                      l = k.this.EXC.WP(j);
                      if ((i == 0) || (l < 0L) || (l >= j)) {
                        break label951;
                      }
                      bool = true;
                      label834:
                      Log.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { k.this.info(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(j) });
                      k.this.EXC.setState(6);
                      k.this.setState(6);
                      if (!bool) {
                        break label957;
                      }
                    }
                    label951:
                    label957:
                    for (k.this.EXa.EWQ = j;; k.this.EXa.EWQ = l)
                    {
                      k.this.WR(6);
                      k.a(k.this, k.this.EXx, SystemClock.elapsedRealtime(), 0L);
                      break;
                      i = 0;
                      break label799;
                      bool = false;
                      break label834;
                    }
                  }
                  Log.e("MicroMsg.VideoPlayerImpl", "seek data length error");
                }
                else
                {
                  Log.e("MicroMsg.VideoPlayerImpl", "seek data type error");
                }
              }
            }
          }
        }
      }
    };
    this.EXI = new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133934);
        if (k.this.EXE == null)
        {
          AppMethodBeat.o(133934);
          return false;
        }
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(133934);
          return false;
          if (!k.this.EXE.prepare())
          {
            Log.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", new Object[] { k.this.info() });
            k.this.EXE.release();
            k.this.EXD = true;
            k.this.EXE = null;
          }
          k.a(k.this, k.this.EXy, SystemClock.elapsedRealtime(), 0L);
          continue;
          if (e.WK(k.this.EXE.state))
          {
            k.this.EXz.obtainMessage(9).sendToTarget();
            k.this.EXy.removeMessages(2);
          }
          else if (e.WL(k.this.EXE.state))
          {
            k.this.EXb.obtainMessage(-1, -1, -1).sendToTarget();
            k.this.EXx.removeMessages(2);
          }
          else
          {
            if (e.WG(k.this.EXE.ah(k.this.aNh, k.this.EXA))) {
              k.this.EXz.sendMessageDelayed(k.this.EXz.obtainMessage(2), 10L);
            }
            if (k.this.state == 3)
            {
              k.a(k.this, k.this.EXy, SystemClock.elapsedRealtime(), k.this.EXa.EWU);
            }
            else if (k.this.state == 5)
            {
              k.a(k.this, k.this.EXy, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 1)
            {
              k.a(k.this, k.this.EXy, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 0)
            {
              k.a(k.this, k.this.EXy, SystemClock.elapsedRealtime(), 0L);
            }
            else
            {
              k.this.EXy.removeMessages(2);
              continue;
              k.this.EXE.start();
              k.a(k.this, k.this.EXy, SystemClock.elapsedRealtime(), 0L);
              continue;
              k.a(k.this, k.this.EXy, SystemClock.elapsedRealtime(), 0L);
              k.this.EXE.pause();
              continue;
              k.this.EXE.release();
              k.this.EXD = true;
              k.this.EXz.obtainMessage(0).sendToTarget();
            }
          }
        }
      }
    };
    this.EXb = paramMMHandler;
    this.iYs = false;
    this.EXa = new h(this.iYs, paramInt);
    this.EXz = new MMHandler(parama, this.EXG);
    this.EXz.setLogging(false);
    this.EXC = new l(this.EXa, this.EXb);
    this.EXx = new MMHandler(paramLooper1, this.EXH);
    if (paramLooper2 != null)
    {
      this.EXE = new a(this.EXa, this.EXb);
      this.EXy = new MMHandler(paramLooper2, this.EXI);
      this.EXy.setLogging(false);
    }
    AppMethodBeat.o(205108);
  }
  
  private void a(MMHandler paramMMHandler, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(133951);
    if (e.WK(this.state))
    {
      Log.w("MicroMsg.VideoPlayerImpl", "isEnd state=%s", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(133951);
      return;
    }
    if (paramMMHandler.isQuit())
    {
      Log.w("MicroMsg.VideoPlayerImpl", "handler has quit");
      AppMethodBeat.o(133951);
      return;
    }
    paramMMHandler.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      paramMMHandler.sendEmptyMessage(2);
      AppMethodBeat.o(133951);
      return;
    }
    paramMMHandler.sendEmptyMessageDelayed(2, paramLong1);
    AppMethodBeat.o(133951);
  }
  
  private void eSV()
  {
    AppMethodBeat.i(133945);
    Log.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[] { info() });
    this.EXC.setState(5);
    if (this.EXE != null)
    {
      this.EXE.eSP();
      this.EXa.EWS = this.EXE.WP((int)this.EXa.EWQ);
      this.EXE.setState(5);
    }
    WR(7);
    setState(4);
    this.EXb.obtainMessage(3, 0, 0).sendToTarget();
    this.EXa.EWR = (this.EXa.EWQ * 1000L);
    this.EXa.EWQ = -1L;
    AppMethodBeat.o(133945);
  }
  
  public final void WQ(int paramInt)
  {
    AppMethodBeat.i(133944);
    Log.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.TRUE });
    Log.printDebugStack("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
    if (this.state < 2)
    {
      Log.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133944);
      return;
    }
    this.EXC.pause();
    this.EXx.removeMessages(4);
    if (this.EXE != null)
    {
      this.EXE.pause();
      this.EXy.removeMessages(4);
    }
    if (paramInt >= this.durationMs)
    {
      Log.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.durationMs) });
      setState(6);
      this.EXz.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133944);
      return;
    }
    this.EXx.obtainMessage(8).sendToTarget();
    this.EXx.obtainMessage(5, new int[] { paramInt, 1 }).sendToTarget();
    AppMethodBeat.o(133944);
  }
  
  final void WR(int paramInt)
  {
    AppMethodBeat.i(133949);
    Log.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.EXa.gcH), Long.valueOf(this.EXa.EWP), Long.valueOf(this.EXa.aNh) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.EXA = this.EXa.gcH;
      this.aNh = this.EXa.aNh;
      Log.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.EXA), Long.valueOf(this.aNh) });
      AppMethodBeat.o(133949);
      return;
      h localh;
      if (this.EXa.EWP > 0L)
      {
        localh = this.EXa;
        localh.aNh += this.EXa.EWP - this.EXa.gcH;
        this.EXa.EWP = 0L;
      }
      this.EXa.gcH = SystemClock.elapsedRealtime();
      continue;
      if (this.EXa.gcH <= 0L)
      {
        this.EXa.EWP = 0L;
      }
      else
      {
        this.EXa.EWP = SystemClock.elapsedRealtime();
        continue;
        this.EXa.aNh = this.EXa.EWQ;
        this.EXa.gcH = SystemClock.elapsedRealtime();
        this.EXa.EWP = 0L;
        localh = this.EXa;
        this.EXa.EWS = 0L;
        localh.EWR = 0L;
        continue;
        this.EXa.aNh = this.EXa.EWQ;
        localh = this.EXa;
        this.EXa.EWP = 0L;
        localh.gcH = 0L;
        localh = this.EXa;
        this.EXa.EWS = 0L;
        localh.EWR = 0L;
        continue;
        this.EXa.aNh = this.EXa.EWQ;
        localh = this.EXa;
        this.EXa.EWP = 0L;
        localh.gcH = 0L;
      }
    }
  }
  
  public final void bXe()
  {
    AppMethodBeat.i(133940);
    if (this.EXC != null)
    {
      Log.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { info() });
      this.EXC.setState(10);
      a(this.EXx, SystemClock.elapsedRealtime(), 0L);
    }
    AppMethodBeat.o(133940);
  }
  
  public final void eSU()
  {
    AppMethodBeat.i(133937);
    Log.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { info(), Long.valueOf(this.EXa.EWR) });
    if (this.EXC != null)
    {
      this.EXC.ai(this.EXa.EWR, -1L);
      this.EXC.eSP();
      this.EXC.EXf = 0L;
    }
    AppMethodBeat.o(133937);
  }
  
  public final long getDurationMs()
  {
    return this.durationMs;
  }
  
  public final String info()
  {
    AppMethodBeat.i(133950);
    String str = this.EXa.info() + "_" + Process.myTid();
    AppMethodBeat.o(133950);
    return str;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133942);
    setState(4);
    this.EXx.removeMessages(4);
    this.EXx.obtainMessage(4).sendToTarget();
    if (this.EXE != null)
    {
      this.EXy.removeMessages(4);
      this.EXy.obtainMessage(4).sendToTarget();
    }
    AppMethodBeat.o(133942);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(133939);
    Log.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { info() });
    this.EXx.obtainMessage(1).sendToTarget();
    if (this.EXE != null) {
      this.EXy.obtainMessage(1).sendToTarget();
    }
    AppMethodBeat.o(133939);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(133947);
    setState(9);
    this.EXz.removeMessages(2);
    this.EXz.removeMessages(9);
    this.EXx.removeMessages(1);
    this.EXx.removeMessages(2);
    this.EXx.removeMessages(3);
    this.EXx.removeMessages(4);
    this.EXx.removeMessages(6);
    this.EXx.removeCallbacksAndMessages(null);
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.wbl, 0) == 1) {
      Log.i("MicroMsg.VideoPlayerImpl", "%s release directly release videoTrack decoder", new Object[] { info() });
    }
    for (;;)
    {
      try
      {
        this.EXC.setState(9);
        Object localObject = this.EXC;
        Log.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((l)localObject).info(), Boolean.valueOf(((l)localObject).EXN) });
        if ((((l)localObject).EXN) && (d.qX(19))) {
          this.EXC.releaseDecoder();
        }
        this.EXx.removeMessages(7);
        this.EXx.obtainMessage(7).sendToTarget();
        if (this.EXy != null)
        {
          this.EXy.removeMessages(1);
          this.EXy.removeMessages(2);
          this.EXy.removeMessages(3);
          this.EXy.removeMessages(4);
          this.EXy.removeMessages(6);
          this.EXy.removeMessages(7);
          this.EXy.obtainMessage(7).sendToTarget();
        }
        localObject = this.EXa;
        ((h)localObject).gcH = 0L;
        ((h)localObject).EWP = 0L;
        ((h)localObject).EWQ = -1L;
        ((h)localObject).aNh = 0L;
        ((h)localObject).EWR = 0L;
        ((h)localObject).EWS = 0L;
        AppMethodBeat.o(133947);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "%s release error %s", new Object[] { info(), localException.toString() });
        continue;
      }
      Log.i("MicroMsg.VideoPlayerImpl", "%s release post to handler thread release videoTrack decoder", new Object[] { info() });
      this.EXC.setState(9);
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(133943);
    Log.i("MicroMsg.VideoPlayerImpl", "%s seek to mSeekSec %d", new Object[] { info(), Integer.valueOf(paramInt) });
    Log.printDebugStack("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
    if (this.state < 2)
    {
      Log.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133943);
      return;
    }
    this.EXC.pause();
    if (this.EXE != null) {
      this.EXE.pause();
    }
    setState(5);
    if (paramInt >= this.durationMs)
    {
      this.EXz.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133943);
      return;
    }
    this.EXC.eSP();
    this.EXa.EWQ = this.EXC.WP(paramInt);
    this.EXC.setState(5);
    WR(5);
    eSV();
    AppMethodBeat.o(133943);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133936);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { info(), paramString });
    this.EXC.setPath(paramString);
    if (this.EXE != null) {
      this.EXE.setPath(paramString);
    }
    AppMethodBeat.o(133936);
  }
  
  protected final void setState(int paramInt)
  {
    AppMethodBeat.i(133948);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    this.EXa.EWT = 0L;
    AppMethodBeat.o(133948);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133938);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { info(), Integer.valueOf(paramSurface.hashCode()) });
    this.EXC.surface = paramSurface;
    AppMethodBeat.o(133938);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133941);
    setState(3);
    this.EXx.removeMessages(3);
    this.EXx.obtainMessage(3).sendToTarget();
    if (this.EXE != null)
    {
      this.EXy.removeMessages(3);
      this.EXy.obtainMessage(3).sendToTarget();
    }
    AppMethodBeat.o(133941);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133946);
    setState(8);
    AppMethodBeat.o(133946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.u.k
 * JD-Core Version:    0.7.0.1
 */