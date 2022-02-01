package com.tencent.mm.plugin.u;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  implements c
{
  public h KSM;
  MMHandler KSN;
  MMHandler KTi;
  MMHandler KTj;
  MMHandler KTk;
  long KTl;
  boolean KTm;
  public l KTn;
  boolean KTp;
  a KTq;
  int KTr;
  private MMHandler.Callback KTs;
  private MMHandler.Callback KTt;
  private MMHandler.Callback KTu;
  long cHd;
  public long durationMs;
  boolean lAj;
  public int state;
  
  public k(MMHandler paramMMHandler, com.tencent.threadpool.j.a parama, Looper paramLooper1, Looper paramLooper2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(260370);
    this.KTm = false;
    this.KTp = false;
    this.KTr = -1;
    this.KTs = new MMHandler.Callback()
    {
      private int AOc = -1;
      private int KTv = -1;
      private int KTw = -1;
      private long KTx = -1L;
      
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133932);
        int i = paramAnonymousMessage.what;
        if ((this.KTx <= 0L) || (Util.ticksToNow(this.KTx) > 500L) || (this.KTv != i) || (this.AOc != k.this.state) || (this.KTw != k.this.KTn.state))
        {
          Log.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { k.this.info(), Integer.valueOf(i), Integer.valueOf(k.this.state), Integer.valueOf(k.this.KTn.state) });
          this.KTx = Util.currentTicks();
          this.KTv = i;
          this.AOc = k.this.state;
          this.KTw = k.this.KTn.state;
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
          boolean bool2 = e.aaI(k.this.KTn.state);
          boolean bool1 = bool2;
          if (k.this.KTq != null) {
            bool1 = bool2 & e.aaI(k.this.KTq.state);
          }
          if (bool1)
          {
            k.this.setState(2);
            k.this.KSN.obtainMessage(1).sendToTarget();
            continue;
            k.a(k.this);
            continue;
            if (e.aaM(k.this.state))
            {
              AppMethodBeat.o(133932);
              return false;
            }
            if ((e.aaO(k.this.state)) || (e.aaL(k.this.state)))
            {
              k.this.setState(9);
              k.this.KSN.obtainMessage(2).sendToTarget();
              AppMethodBeat.o(133932);
              return false;
            }
            bool2 = e.aaM(k.this.KTn.state);
            bool1 = bool2;
            if (k.this.KTq != null) {
              bool1 = bool2 & e.aaM(k.this.KTq.state);
            }
            if (bool1)
            {
              k.this.setState(9);
              k.this.KSN.obtainMessage(2).sendToTarget();
              continue;
              if ((k.this.KTm) && ((k.this.lAj) || (k.this.KTp))) {
                k.this.KSN.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.KTt = new MMHandler.Callback()
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
          if (k.this.KTn.prepare())
          {
            k.this.durationMs = k.this.KTn.durationMs;
            k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
          }
          else
          {
            k.this.KSN.obtainMessage(5, -1, -1).sendToTarget();
            AppMethodBeat.o(133933);
            return false;
            paramAnonymousMessage = k.this.KSM;
            long l = Util.ticksToNow(paramAnonymousMessage.KSF);
            if ((paramAnonymousMessage.KSF > 0L) && (l >= 30L))
            {
              Log.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramAnonymousMessage.info(), Long.valueOf(paramAnonymousMessage.KSF), Long.valueOf(l) });
              paramAnonymousMessage.KSG = 0L;
            }
            if (e.aaM(k.this.KTn.state))
            {
              k.this.KTk.obtainMessage(9).sendToTarget();
              k.this.KTi.removeMessages(2);
            }
            else if (e.aaN(k.this.KTn.state))
            {
              k.this.KSN.obtainMessage(-1, -1, -1).sendToTarget();
              k.this.KTi.removeMessages(2);
            }
            else
            {
              int j = k.this.KTn.aQ(k.this.cHd, k.this.KTl);
              if (e.aaI(j)) {
                k.this.KTk.obtainMessage(2).sendToTarget();
              }
              if (j == 7) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label396;
                }
                k.this.KTk.obtainMessage(7).sendToTarget();
                k.this.KTi.removeMessages(2);
                break;
              }
              label396:
              if (e.aaP(j))
              {
                k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
                k.this.KSM.KSF = Util.currentTicks();
              }
              else
              {
                if (k.this.state == 3) {
                  k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), k.this.KSM.KSG);
                }
                for (;;)
                {
                  k.this.KSM.KSF = Util.currentTicks();
                  break;
                  if (k.this.state == 5) {
                    k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 1) {
                    k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 0) {
                    k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 6) {
                    k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
                  } else {
                    k.this.KTi.removeMessages(2);
                  }
                }
                k.this.aaT(3);
                k.this.KTn.start();
                k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
                continue;
                k.this.aaT(4);
                k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
                k.this.KTn.pause();
                continue;
                k.this.KTn.release();
                k.this.KTm = true;
                k.this.KTk.obtainMessage(0).sendToTarget();
                continue;
                k.this.KTn.gbI();
                continue;
                if ((paramAnonymousMessage.obj instanceof int[]))
                {
                  paramAnonymousMessage = (int[])paramAnonymousMessage.obj;
                  if (paramAnonymousMessage.length == 2)
                  {
                    j = paramAnonymousMessage[0];
                    label796:
                    boolean bool;
                    if (paramAnonymousMessage[1] == 1)
                    {
                      i = 1;
                      l = k.this.KTn.aaR(j);
                      if ((i == 0) || (l < 0L) || (l >= j)) {
                        break label948;
                      }
                      bool = true;
                      label831:
                      Log.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { k.this.info(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(j) });
                      k.this.KTn.setState(6);
                      k.this.setState(6);
                      if (!bool) {
                        break label954;
                      }
                    }
                    label948:
                    label954:
                    for (k.this.KSM.KSC = j;; k.this.KSM.KSC = l)
                    {
                      k.this.aaT(6);
                      k.a(k.this, k.this.KTi, SystemClock.elapsedRealtime(), 0L);
                      break;
                      i = 0;
                      break label796;
                      bool = false;
                      break label831;
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
    this.KTu = new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133934);
        if (k.this.KTq == null)
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
          if (!k.this.KTq.prepare())
          {
            Log.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", new Object[] { k.this.info() });
            k.this.KTq.release();
            k.this.KTp = true;
            k.this.KTq = null;
          }
          k.a(k.this, k.this.KTj, SystemClock.elapsedRealtime(), 0L);
          continue;
          if (e.aaM(k.this.KTq.state))
          {
            k.this.KTk.obtainMessage(9).sendToTarget();
            k.this.KTj.removeMessages(2);
          }
          else if (e.aaN(k.this.KTq.state))
          {
            k.this.KSN.obtainMessage(-1, -1, -1).sendToTarget();
            k.this.KTi.removeMessages(2);
          }
          else
          {
            if (e.aaI(k.this.KTq.aQ(k.this.cHd, k.this.KTl))) {
              k.this.KTk.sendMessageDelayed(k.this.KTk.obtainMessage(2), 10L);
            }
            if (k.this.state == 3)
            {
              k.a(k.this, k.this.KTj, SystemClock.elapsedRealtime(), k.this.KSM.KSG);
            }
            else if (k.this.state == 5)
            {
              k.a(k.this, k.this.KTj, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 1)
            {
              k.a(k.this, k.this.KTj, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 0)
            {
              k.a(k.this, k.this.KTj, SystemClock.elapsedRealtime(), 0L);
            }
            else
            {
              k.this.KTj.removeMessages(2);
              continue;
              k.this.KTq.start();
              k.a(k.this, k.this.KTj, SystemClock.elapsedRealtime(), 0L);
              continue;
              k.a(k.this, k.this.KTj, SystemClock.elapsedRealtime(), 0L);
              k.this.KTq.pause();
              continue;
              k.this.KTq.release();
              k.this.KTp = true;
              k.this.KTk.obtainMessage(0).sendToTarget();
            }
          }
        }
      }
    };
    this.KSN = paramMMHandler;
    this.lAj = false;
    this.KSM = new h(this.lAj, paramInt);
    this.KTk = new MMHandler(parama, this.KTs);
    this.KTk.setLogging(false);
    this.KTn = new l(this.KSM, this.KSN);
    this.KTi = new MMHandler(paramLooper1, this.KTt);
    if (paramLooper2 != null)
    {
      this.KTq = new a(this.KSM, this.KSN);
      this.KTj = new MMHandler(paramLooper2, this.KTu);
      this.KTj.setLogging(false);
    }
    AppMethodBeat.o(260370);
  }
  
  private void a(MMHandler paramMMHandler, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(133951);
    if (e.aaM(this.state))
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
  
  private void gbO()
  {
    AppMethodBeat.i(133945);
    Log.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[] { info() });
    this.KTn.setState(5);
    if (this.KTq != null)
    {
      this.KTq.gbI();
      this.KSM.KSE = this.KTq.aaR((int)this.KSM.KSC);
      this.KTq.setState(5);
    }
    aaT(7);
    setState(4);
    this.KSN.obtainMessage(3, 0, 0).sendToTarget();
    this.KSM.KSD = (this.KSM.KSC * 1000L);
    this.KSM.KSC = -1L;
    AppMethodBeat.o(133945);
  }
  
  public final void aaS(int paramInt)
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
    this.KTn.pause();
    this.KTi.removeMessages(4);
    if (this.KTq != null)
    {
      this.KTq.pause();
      this.KTj.removeMessages(4);
    }
    if (paramInt >= this.durationMs)
    {
      Log.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.durationMs) });
      setState(6);
      this.KTk.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133944);
      return;
    }
    this.KTi.obtainMessage(8).sendToTarget();
    this.KTi.obtainMessage(5, new int[] { paramInt, 1 }).sendToTarget();
    AppMethodBeat.o(133944);
  }
  
  final void aaT(int paramInt)
  {
    AppMethodBeat.i(133949);
    Log.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.KSM.startMs), Long.valueOf(this.KSM.KSB), Long.valueOf(this.KSM.cHd) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.KTl = this.KSM.startMs;
      this.cHd = this.KSM.cHd;
      Log.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.KTl), Long.valueOf(this.cHd) });
      AppMethodBeat.o(133949);
      return;
      h localh;
      if (this.KSM.KSB > 0L)
      {
        localh = this.KSM;
        localh.cHd += this.KSM.KSB - this.KSM.startMs;
        this.KSM.KSB = 0L;
      }
      this.KSM.startMs = SystemClock.elapsedRealtime();
      continue;
      if (this.KSM.startMs <= 0L)
      {
        this.KSM.KSB = 0L;
      }
      else
      {
        this.KSM.KSB = SystemClock.elapsedRealtime();
        continue;
        this.KSM.cHd = this.KSM.KSC;
        this.KSM.startMs = SystemClock.elapsedRealtime();
        this.KSM.KSB = 0L;
        localh = this.KSM;
        this.KSM.KSE = 0L;
        localh.KSD = 0L;
        continue;
        this.KSM.cHd = this.KSM.KSC;
        localh = this.KSM;
        this.KSM.KSB = 0L;
        localh.startMs = 0L;
        localh = this.KSM;
        this.KSM.KSE = 0L;
        localh.KSD = 0L;
        continue;
        this.KSM.cHd = this.KSM.KSC;
        localh = this.KSM;
        this.KSM.KSB = 0L;
        localh.startMs = 0L;
      }
    }
  }
  
  public final void cxp()
  {
    AppMethodBeat.i(133940);
    if (this.KTn != null)
    {
      Log.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { info() });
      this.KTn.setState(10);
      a(this.KTi, SystemClock.elapsedRealtime(), 0L);
    }
    AppMethodBeat.o(133940);
  }
  
  public final void gbN()
  {
    AppMethodBeat.i(133937);
    Log.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { info(), Long.valueOf(this.KSM.KSD) });
    if (this.KTn != null)
    {
      this.KTn.aR(this.KSM.KSD, -1L);
      this.KTn.gbI();
      this.KTn.KSR = 0L;
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
    String str = this.KSM.info() + "_" + Process.myTid();
    AppMethodBeat.o(133950);
    return str;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133942);
    setState(4);
    this.KTi.removeMessages(4);
    this.KTi.obtainMessage(4).sendToTarget();
    if (this.KTq != null)
    {
      this.KTj.removeMessages(4);
      this.KTj.obtainMessage(4).sendToTarget();
    }
    AppMethodBeat.o(133942);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(133939);
    Log.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { info() });
    this.KTi.obtainMessage(1).sendToTarget();
    if (this.KTq != null) {
      this.KTj.obtainMessage(1).sendToTarget();
    }
    AppMethodBeat.o(133939);
    return true;
  }
  
  public final void r(Surface paramSurface)
  {
    AppMethodBeat.i(260389);
    Log.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { info(), Integer.valueOf(paramSurface.hashCode()) });
    this.KTn.r(paramSurface);
    AppMethodBeat.o(260389);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133947);
    setState(9);
    this.KTk.removeMessages(2);
    this.KTk.removeMessages(9);
    this.KTi.removeMessages(1);
    this.KTi.removeMessages(2);
    this.KTi.removeMessages(3);
    this.KTi.removeMessages(4);
    this.KTi.removeMessages(6);
    this.KTi.removeCallbacksAndMessages(null);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zuG, 0) == 1) {
      Log.i("MicroMsg.VideoPlayerImpl", "%s release directly release videoTrack decoder", new Object[] { info() });
    }
    for (;;)
    {
      try
      {
        this.KTn.setState(9);
        Object localObject = this.KTn;
        Log.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((l)localObject).info(), Boolean.valueOf(((l)localObject).KTz) });
        if ((((l)localObject).KTz) && (d.rd(19))) {
          this.KTn.releaseDecoder();
        }
        this.KTi.removeMessages(7);
        this.KTi.obtainMessage(7).sendToTarget();
        if (this.KTj != null)
        {
          this.KTj.removeMessages(1);
          this.KTj.removeMessages(2);
          this.KTj.removeMessages(3);
          this.KTj.removeMessages(4);
          this.KTj.removeMessages(6);
          this.KTj.removeMessages(7);
          this.KTj.obtainMessage(7).sendToTarget();
        }
        localObject = this.KSM;
        ((h)localObject).startMs = 0L;
        ((h)localObject).KSB = 0L;
        ((h)localObject).KSC = -1L;
        ((h)localObject).cHd = 0L;
        ((h)localObject).KSD = 0L;
        ((h)localObject).KSE = 0L;
        AppMethodBeat.o(133947);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "%s release error %s", new Object[] { info(), localException.toString() });
        continue;
      }
      Log.i("MicroMsg.VideoPlayerImpl", "%s release post to handler thread release videoTrack decoder", new Object[] { info() });
      this.KTn.setState(9);
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
    this.KTn.pause();
    if (this.KTq != null) {
      this.KTq.pause();
    }
    setState(5);
    if (paramInt >= this.durationMs)
    {
      this.KTk.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133943);
      return;
    }
    this.KTn.gbI();
    this.KSM.KSC = this.KTn.aaR(paramInt);
    this.KTn.setState(5);
    aaT(5);
    gbO();
    AppMethodBeat.o(133943);
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(260386);
    if (this.KSM != null)
    {
      Log.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
      this.KSM.ykm = paramBoolean;
    }
    AppMethodBeat.o(260386);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(260401);
    if (this.KTq != null)
    {
      Log.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
      this.KTq.setMute(paramBoolean);
    }
    AppMethodBeat.o(260401);
  }
  
  public final void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(260384);
    Log.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", new Object[] { info(), Boolean.valueOf(paramBoolean) });
    if (this.KSM != null) {
      this.KSM.ykl = paramBoolean;
    }
    AppMethodBeat.o(260384);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133936);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { info(), paramString });
    this.KTn.setPath(paramString);
    if (this.KTq != null) {
      this.KTq.setPath(paramString);
    }
    AppMethodBeat.o(133936);
  }
  
  protected final void setState(int paramInt)
  {
    AppMethodBeat.i(133948);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    this.KSM.KSF = 0L;
    AppMethodBeat.o(133948);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133938);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { info(), Integer.valueOf(paramSurface.hashCode()) });
    this.KTn.surface = paramSurface;
    AppMethodBeat.o(133938);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133941);
    setState(3);
    this.KTi.removeMessages(3);
    this.KTi.obtainMessage(3).sendToTarget();
    if (this.KTq != null)
    {
      this.KTj.removeMessages(3);
      this.KTj.obtainMessage(3).sendToTarget();
    }
    AppMethodBeat.o(133941);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133946);
    setState(8);
    AppMethodBeat.o(133946);
  }
  
  public final void yr(boolean paramBoolean)
  {
    this.KTn.KTB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.u.k
 * JD-Core Version:    0.7.0.1
 */