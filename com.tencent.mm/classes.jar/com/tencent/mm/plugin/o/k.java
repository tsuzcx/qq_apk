package com.tencent.mm.plugin.o;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  implements c
{
  long bdJ;
  public long bup;
  boolean fMP;
  public int state;
  ap vLQ;
  ap vLR;
  ap vLS;
  long vLT;
  boolean vLU;
  public l vLV;
  boolean vLW;
  a vLX;
  int vLY;
  private ap.a vLZ;
  public h vLw;
  ap vLx;
  private ap.a vMa;
  private ap.a vMb;
  
  public k(ap paramap, com.tencent.e.j.a parama, Looper paramLooper1, Looper paramLooper2, int paramInt)
  {
    AppMethodBeat.i(197030);
    this.vLU = false;
    this.vLW = false;
    this.vLY = -1;
    this.vLZ = new ap.a()
    {
      private int rQP = -1;
      private int vMc = -1;
      private int vMd = -1;
      private long vMe = -1L;
      
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133932);
        int i = paramAnonymousMessage.what;
        if ((this.vMe <= 0L) || (bt.aO(this.vMe) > 500L) || (this.vMc != i) || (this.rQP != k.this.state) || (this.vMd != k.this.vLV.state))
        {
          ad.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { k.this.info(), Integer.valueOf(i), Integer.valueOf(k.this.state), Integer.valueOf(k.this.vLV.state) });
          this.vMe = bt.HI();
          this.vMc = i;
          this.rQP = k.this.state;
          this.vMd = k.this.vLV.state;
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
          boolean bool2 = e.JS(k.this.vLV.state);
          boolean bool1 = bool2;
          if (k.this.vLX != null) {
            bool1 = bool2 & e.JS(k.this.vLX.state);
          }
          if (bool1)
          {
            k.this.setState(2);
            k.this.vLx.obtainMessage(1).sendToTarget();
            continue;
            k.a(k.this);
            continue;
            if (e.JW(k.this.state))
            {
              AppMethodBeat.o(133932);
              return false;
            }
            if ((e.JX(k.this.state)) || (e.JV(k.this.state)))
            {
              k.this.setState(9);
              k.this.vLx.obtainMessage(2).sendToTarget();
              AppMethodBeat.o(133932);
              return false;
            }
            bool2 = e.JW(k.this.vLV.state);
            bool1 = bool2;
            if (k.this.vLX != null) {
              bool1 = bool2 & e.JW(k.this.vLX.state);
            }
            if (bool1)
            {
              k.this.setState(9);
              k.this.vLx.obtainMessage(2).sendToTarget();
              continue;
              if ((k.this.vLU) && ((k.this.fMP) || (k.this.vLW))) {
                k.this.vLx.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.vMa = new ap.a()
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
          label905:
          label911:
          if (k.this.vLV.cQr())
          {
            k.this.bup = k.this.vLV.bup;
            k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
          }
          else
          {
            k.this.vLx.obtainMessage(5, -1, -1).sendToTarget();
            AppMethodBeat.o(133933);
            return false;
            paramAnonymousMessage = k.this.vLw;
            long l = bt.aO(paramAnonymousMessage.vLp);
            if ((paramAnonymousMessage.vLp > 0L) && (l >= 30L))
            {
              ad.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramAnonymousMessage.info(), Long.valueOf(paramAnonymousMessage.vLp), Long.valueOf(l) });
              paramAnonymousMessage.vLq = 0L;
            }
            label788:
            if (e.JW(k.this.vLV.state))
            {
              k.this.vLS.obtainMessage(9).sendToTarget();
              k.this.vLQ.removeMessages(2);
            }
            else
            {
              int j = k.this.vLV.W(k.this.bdJ, k.this.vLT);
              if (e.JS(j)) {
                k.this.vLS.obtainMessage(2).sendToTarget();
              }
              if (j == 7) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label350;
                }
                k.this.vLS.obtainMessage(7).sendToTarget();
                k.this.vLQ.removeMessages(2);
                break;
              }
              label350:
              if (e.JY(j))
              {
                k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
                k.this.vLw.vLp = bt.HI();
              }
              else
              {
                if (k.this.state == 3) {
                  k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), k.this.vLw.vLq);
                }
                for (;;)
                {
                  k.this.vLw.vLp = bt.HI();
                  break;
                  if (k.this.state == 5) {
                    k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 1) {
                    k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 0) {
                    k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 6) {
                    k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
                  } else {
                    k.this.vLQ.removeMessages(2);
                  }
                }
                k.this.Kc(3);
                k.this.vLV.start();
                k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
                continue;
                k.this.Kc(4);
                k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
                k.this.vLV.pause();
                continue;
                k.this.vLV.release();
                k.this.vLU = true;
                k.this.vLS.obtainMessage(0).sendToTarget();
                continue;
                k.this.vLV.dmw();
                continue;
                if ((paramAnonymousMessage.obj instanceof int[]))
                {
                  paramAnonymousMessage = (int[])paramAnonymousMessage.obj;
                  if (paramAnonymousMessage.length == 2)
                  {
                    j = paramAnonymousMessage[0];
                    label753:
                    boolean bool;
                    if (paramAnonymousMessage[1] == 1)
                    {
                      i = 1;
                      l = k.this.vLV.Ka(j);
                      if ((i == 0) || (l < 0L) || (l >= j)) {
                        break label905;
                      }
                      bool = true;
                      ad.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { k.this.info(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(j) });
                      k.this.vLV.setState(6);
                      k.this.setState(6);
                      if (!bool) {
                        break label911;
                      }
                    }
                    for (k.this.vLw.vLm = j;; k.this.vLw.vLm = l)
                    {
                      k.this.Kc(6);
                      k.a(k.this, k.this.vLQ, SystemClock.elapsedRealtime(), 0L);
                      break;
                      i = 0;
                      break label753;
                      bool = false;
                      break label788;
                    }
                  }
                  ad.e("MicroMsg.VideoPlayerImpl", "seek data length error");
                }
                else
                {
                  ad.e("MicroMsg.VideoPlayerImpl", "seek data type error");
                }
              }
            }
          }
        }
      }
    };
    this.vMb = new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133934);
        if (k.this.vLX == null)
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
          if (!k.this.vLX.cQr())
          {
            ad.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", new Object[] { k.this.info() });
            k.this.vLX.release();
            k.this.vLW = true;
            k.this.vLX = null;
          }
          k.a(k.this, k.this.vLR, SystemClock.elapsedRealtime(), 0L);
          continue;
          if (e.JW(k.this.vLX.state))
          {
            k.this.vLS.obtainMessage(9).sendToTarget();
            k.this.vLR.removeMessages(2);
          }
          else
          {
            if (e.JS(k.this.vLX.W(k.this.bdJ, k.this.vLT))) {
              k.this.vLS.sendMessageDelayed(k.this.vLS.obtainMessage(2), 10L);
            }
            if (k.this.state == 3)
            {
              k.a(k.this, k.this.vLR, SystemClock.elapsedRealtime(), k.this.vLw.vLq);
            }
            else if (k.this.state == 5)
            {
              k.a(k.this, k.this.vLR, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 1)
            {
              k.a(k.this, k.this.vLR, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 0)
            {
              k.a(k.this, k.this.vLR, SystemClock.elapsedRealtime(), 0L);
            }
            else
            {
              k.this.vLR.removeMessages(2);
              continue;
              k.this.vLX.start();
              k.a(k.this, k.this.vLR, SystemClock.elapsedRealtime(), 0L);
              continue;
              k.a(k.this, k.this.vLR, SystemClock.elapsedRealtime(), 0L);
              k.this.vLX.pause();
              continue;
              k.this.vLX.release();
              k.this.vLW = true;
              k.this.vLS.obtainMessage(0).sendToTarget();
            }
          }
        }
      }
    };
    this.vLx = paramap;
    this.fMP = false;
    this.vLw = new h(this.fMP, paramInt);
    this.vLS = new ap(parama, this.vLZ);
    this.vLS.setLogging(false);
    this.vLV = new l(this.vLw, this.vLx);
    this.vLQ = new ap(paramLooper1, this.vMa);
    if (paramLooper2 != null)
    {
      this.vLX = new a(this.vLw, this.vLx);
      this.vLR = new ap(paramLooper2, this.vMb);
      this.vLR.setLogging(false);
    }
    AppMethodBeat.o(197030);
  }
  
  private void a(ap paramap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(133951);
    if (e.JW(this.state))
    {
      ad.w("MicroMsg.VideoPlayerImpl", "isEnd state=%s", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(133951);
      return;
    }
    if (paramap.isQuit())
    {
      ad.w("MicroMsg.VideoPlayerImpl", "handler has quit");
      AppMethodBeat.o(133951);
      return;
    }
    paramap.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      paramap.sendEmptyMessage(2);
      AppMethodBeat.o(133951);
      return;
    }
    paramap.sendEmptyMessageDelayed(2, paramLong1);
    AppMethodBeat.o(133951);
  }
  
  private void dmB()
  {
    AppMethodBeat.i(133945);
    ad.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[] { info() });
    this.vLV.setState(5);
    if (this.vLX != null)
    {
      this.vLX.dmw();
      this.vLw.vLo = this.vLX.Ka((int)this.vLw.vLm);
      this.vLX.setState(5);
    }
    Kc(7);
    setState(4);
    this.vLx.obtainMessage(3, 0, 0).sendToTarget();
    this.vLw.vLn = (this.vLw.vLm * 1000L);
    this.vLw.vLm = -1L;
    AppMethodBeat.o(133945);
  }
  
  public final void Kb(int paramInt)
  {
    AppMethodBeat.i(133944);
    ad.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.TRUE });
    ad.l("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
    if (this.state < 2)
    {
      ad.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133944);
      return;
    }
    this.vLV.pause();
    this.vLQ.removeMessages(4);
    if (this.vLX != null)
    {
      this.vLX.pause();
      this.vLR.removeMessages(4);
    }
    if (paramInt >= this.bup)
    {
      ad.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.bup) });
      setState(6);
      this.vLS.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133944);
      return;
    }
    this.vLQ.obtainMessage(8).sendToTarget();
    this.vLQ.obtainMessage(5, new int[] { paramInt, 1 }).sendToTarget();
    AppMethodBeat.o(133944);
  }
  
  final void Kc(int paramInt)
  {
    AppMethodBeat.i(133949);
    ad.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.vLw.dOX), Long.valueOf(this.vLw.vLl), Long.valueOf(this.vLw.bdJ) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.vLT = this.vLw.dOX;
      this.bdJ = this.vLw.bdJ;
      ad.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.vLT), Long.valueOf(this.bdJ) });
      AppMethodBeat.o(133949);
      return;
      h localh;
      if (this.vLw.vLl > 0L)
      {
        localh = this.vLw;
        localh.bdJ += this.vLw.vLl - this.vLw.dOX;
        this.vLw.vLl = 0L;
      }
      this.vLw.dOX = SystemClock.elapsedRealtime();
      continue;
      if (this.vLw.dOX <= 0L)
      {
        this.vLw.vLl = 0L;
      }
      else
      {
        this.vLw.vLl = SystemClock.elapsedRealtime();
        continue;
        this.vLw.bdJ = this.vLw.vLm;
        this.vLw.dOX = SystemClock.elapsedRealtime();
        this.vLw.vLl = 0L;
        localh = this.vLw;
        this.vLw.vLo = 0L;
        localh.vLn = 0L;
        continue;
        this.vLw.bdJ = this.vLw.vLm;
        localh = this.vLw;
        this.vLw.vLl = 0L;
        localh.dOX = 0L;
        localh = this.vLw;
        this.vLw.vLo = 0L;
        localh.vLn = 0L;
        continue;
        this.vLw.bdJ = this.vLw.vLm;
        localh = this.vLw;
        this.vLw.vLl = 0L;
        localh.dOX = 0L;
      }
    }
  }
  
  public final void boO()
  {
    AppMethodBeat.i(133940);
    if (this.vLV != null)
    {
      ad.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { info() });
      this.vLV.setState(10);
      a(this.vLQ, SystemClock.elapsedRealtime(), 0L);
    }
    AppMethodBeat.o(133940);
  }
  
  public final boolean cQr()
  {
    AppMethodBeat.i(133939);
    ad.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { info() });
    this.vLQ.obtainMessage(1).sendToTarget();
    if (this.vLX != null) {
      this.vLR.obtainMessage(1).sendToTarget();
    }
    AppMethodBeat.o(133939);
    return true;
  }
  
  public final void dmA()
  {
    AppMethodBeat.i(133937);
    ad.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { info(), Long.valueOf(this.vLw.vLn) });
    if (this.vLV != null)
    {
      this.vLV.X(this.vLw.vLn, -1L);
      this.vLV.dmw();
      this.vLV.vLA = 0L;
    }
    AppMethodBeat.o(133937);
  }
  
  public final long getDurationMs()
  {
    return this.bup;
  }
  
  public final String info()
  {
    AppMethodBeat.i(133950);
    String str = this.vLw.info() + "_" + Process.myTid();
    AppMethodBeat.o(133950);
    return str;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133942);
    setState(4);
    this.vLQ.removeMessages(4);
    this.vLQ.obtainMessage(4).sendToTarget();
    if (this.vLX != null)
    {
      this.vLR.removeMessages(4);
      this.vLR.obtainMessage(4).sendToTarget();
    }
    AppMethodBeat.o(133942);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133947);
    setState(9);
    this.vLS.removeMessages(2);
    this.vLS.removeMessages(9);
    this.vLQ.removeMessages(1);
    this.vLQ.removeMessages(2);
    this.vLQ.removeMessages(3);
    this.vLQ.removeMessages(4);
    this.vLQ.removeMessages(6);
    this.vLQ.removeCallbacksAndMessages(null);
    try
    {
      this.vLV.setState(9);
      Object localObject = this.vLV;
      ad.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((l)localObject).info(), Boolean.valueOf(((l)localObject).vMg) });
      if ((((l)localObject).vMg) && (d.lA(19))) {
        this.vLV.releaseDecoder();
      }
      this.vLQ.removeMessages(7);
      this.vLQ.obtainMessage(7).sendToTarget();
      if (this.vLR != null)
      {
        this.vLR.removeMessages(1);
        this.vLR.removeMessages(2);
        this.vLR.removeMessages(3);
        this.vLR.removeMessages(4);
        this.vLR.removeMessages(6);
        this.vLR.removeMessages(7);
        this.vLR.obtainMessage(7).sendToTarget();
      }
      localObject = this.vLw;
      ((h)localObject).dOX = 0L;
      ((h)localObject).vLl = 0L;
      ((h)localObject).vLm = -1L;
      ((h)localObject).bdJ = 0L;
      ((h)localObject).vLn = 0L;
      ((h)localObject).vLo = 0L;
      AppMethodBeat.o(133947);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "%s release error %s", new Object[] { info(), localException.toString() });
      }
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(133943);
    ad.i("MicroMsg.VideoPlayerImpl", "%s seek to mSeekSec %d", new Object[] { info(), Integer.valueOf(paramInt) });
    ad.l("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
    if (this.state < 2)
    {
      ad.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133943);
      return;
    }
    this.vLV.pause();
    if (this.vLX != null) {
      this.vLX.pause();
    }
    setState(5);
    if (paramInt >= this.bup)
    {
      this.vLS.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133943);
      return;
    }
    this.vLV.dmw();
    this.vLw.vLm = this.vLV.Ka(paramInt);
    this.vLV.setState(5);
    Kc(5);
    dmB();
    AppMethodBeat.o(133943);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133936);
    ad.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { info(), paramString });
    this.vLV.setPath(paramString);
    if (this.vLX != null) {
      this.vLX.setPath(paramString);
    }
    AppMethodBeat.o(133936);
  }
  
  protected final void setState(int paramInt)
  {
    AppMethodBeat.i(133948);
    ad.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    this.vLw.vLp = 0L;
    AppMethodBeat.o(133948);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133938);
    ad.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { info(), Integer.valueOf(paramSurface.hashCode()) });
    this.vLV.surface = paramSurface;
    AppMethodBeat.o(133938);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133941);
    setState(3);
    this.vLQ.removeMessages(3);
    this.vLQ.obtainMessage(3).sendToTarget();
    if (this.vLX != null)
    {
      this.vLR.removeMessages(3);
      this.vLR.obtainMessage(3).sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.o.k
 * JD-Core Version:    0.7.0.1
 */