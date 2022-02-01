package com.tencent.mm.plugin.o;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class k
  implements c
{
  long bdJ;
  public long bup;
  boolean fOX;
  public int state;
  public h vXA;
  aq vXB;
  aq vXU;
  aq vXV;
  aq vXW;
  long vXX;
  boolean vXY;
  public l vXZ;
  boolean vYa;
  a vYb;
  int vYc;
  private aq.a vYd;
  private aq.a vYe;
  private aq.a vYf;
  
  public k(aq paramaq, com.tencent.e.j.a parama, Looper paramLooper1, Looper paramLooper2, int paramInt)
  {
    AppMethodBeat.i(220264);
    this.vXY = false;
    this.vYa = false;
    this.vYc = -1;
    this.vYd = new aq.a()
    {
      private int rZr = -1;
      private int vYg = -1;
      private int vYh = -1;
      private long vYi = -1L;
      
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133932);
        int i = paramAnonymousMessage.what;
        if ((this.vYi <= 0L) || (bu.aO(this.vYi) > 500L) || (this.vYg != i) || (this.rZr != k.this.state) || (this.vYh != k.this.vXZ.state))
        {
          ae.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { k.this.info(), Integer.valueOf(i), Integer.valueOf(k.this.state), Integer.valueOf(k.this.vXZ.state) });
          this.vYi = bu.HQ();
          this.vYg = i;
          this.rZr = k.this.state;
          this.vYh = k.this.vXZ.state;
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
          boolean bool2 = e.Ks(k.this.vXZ.state);
          boolean bool1 = bool2;
          if (k.this.vYb != null) {
            bool1 = bool2 & e.Ks(k.this.vYb.state);
          }
          if (bool1)
          {
            k.this.setState(2);
            k.this.vXB.obtainMessage(1).sendToTarget();
            continue;
            k.a(k.this);
            continue;
            if (e.Kw(k.this.state))
            {
              AppMethodBeat.o(133932);
              return false;
            }
            if ((e.Kx(k.this.state)) || (e.Kv(k.this.state)))
            {
              k.this.setState(9);
              k.this.vXB.obtainMessage(2).sendToTarget();
              AppMethodBeat.o(133932);
              return false;
            }
            bool2 = e.Kw(k.this.vXZ.state);
            bool1 = bool2;
            if (k.this.vYb != null) {
              bool1 = bool2 & e.Kw(k.this.vYb.state);
            }
            if (bool1)
            {
              k.this.setState(9);
              k.this.vXB.obtainMessage(2).sendToTarget();
              continue;
              if ((k.this.vXY) && ((k.this.fOX) || (k.this.vYa))) {
                k.this.vXB.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.vYe = new aq.a()
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
          if (k.this.vXZ.cSW())
          {
            k.this.bup = k.this.vXZ.bup;
            k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
          }
          else
          {
            k.this.vXB.obtainMessage(5, -1, -1).sendToTarget();
            AppMethodBeat.o(133933);
            return false;
            paramAnonymousMessage = k.this.vXA;
            long l = bu.aO(paramAnonymousMessage.vXt);
            if ((paramAnonymousMessage.vXt > 0L) && (l >= 30L))
            {
              ae.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramAnonymousMessage.info(), Long.valueOf(paramAnonymousMessage.vXt), Long.valueOf(l) });
              paramAnonymousMessage.vXu = 0L;
            }
            label788:
            if (e.Kw(k.this.vXZ.state))
            {
              k.this.vXW.obtainMessage(9).sendToTarget();
              k.this.vXU.removeMessages(2);
            }
            else
            {
              int j = k.this.vXZ.V(k.this.bdJ, k.this.vXX);
              if (e.Ks(j)) {
                k.this.vXW.obtainMessage(2).sendToTarget();
              }
              if (j == 7) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label350;
                }
                k.this.vXW.obtainMessage(7).sendToTarget();
                k.this.vXU.removeMessages(2);
                break;
              }
              label350:
              if (e.Ky(j))
              {
                k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
                k.this.vXA.vXt = bu.HQ();
              }
              else
              {
                if (k.this.state == 3) {
                  k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), k.this.vXA.vXu);
                }
                for (;;)
                {
                  k.this.vXA.vXt = bu.HQ();
                  break;
                  if (k.this.state == 5) {
                    k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 1) {
                    k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 0) {
                    k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 6) {
                    k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
                  } else {
                    k.this.vXU.removeMessages(2);
                  }
                }
                k.this.KC(3);
                k.this.vXZ.start();
                k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
                continue;
                k.this.KC(4);
                k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
                k.this.vXZ.pause();
                continue;
                k.this.vXZ.release();
                k.this.vXY = true;
                k.this.vXW.obtainMessage(0).sendToTarget();
                continue;
                k.this.vXZ.dpu();
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
                      l = k.this.vXZ.KA(j);
                      if ((i == 0) || (l < 0L) || (l >= j)) {
                        break label905;
                      }
                      bool = true;
                      ae.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { k.this.info(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(j) });
                      k.this.vXZ.setState(6);
                      k.this.setState(6);
                      if (!bool) {
                        break label911;
                      }
                    }
                    for (k.this.vXA.vXq = j;; k.this.vXA.vXq = l)
                    {
                      k.this.KC(6);
                      k.a(k.this, k.this.vXU, SystemClock.elapsedRealtime(), 0L);
                      break;
                      i = 0;
                      break label753;
                      bool = false;
                      break label788;
                    }
                  }
                  ae.e("MicroMsg.VideoPlayerImpl", "seek data length error");
                }
                else
                {
                  ae.e("MicroMsg.VideoPlayerImpl", "seek data type error");
                }
              }
            }
          }
        }
      }
    };
    this.vYf = new aq.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133934);
        if (k.this.vYb == null)
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
          if (!k.this.vYb.cSW())
          {
            ae.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", new Object[] { k.this.info() });
            k.this.vYb.release();
            k.this.vYa = true;
            k.this.vYb = null;
          }
          k.a(k.this, k.this.vXV, SystemClock.elapsedRealtime(), 0L);
          continue;
          if (e.Kw(k.this.vYb.state))
          {
            k.this.vXW.obtainMessage(9).sendToTarget();
            k.this.vXV.removeMessages(2);
          }
          else
          {
            if (e.Ks(k.this.vYb.V(k.this.bdJ, k.this.vXX))) {
              k.this.vXW.sendMessageDelayed(k.this.vXW.obtainMessage(2), 10L);
            }
            if (k.this.state == 3)
            {
              k.a(k.this, k.this.vXV, SystemClock.elapsedRealtime(), k.this.vXA.vXu);
            }
            else if (k.this.state == 5)
            {
              k.a(k.this, k.this.vXV, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 1)
            {
              k.a(k.this, k.this.vXV, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 0)
            {
              k.a(k.this, k.this.vXV, SystemClock.elapsedRealtime(), 0L);
            }
            else
            {
              k.this.vXV.removeMessages(2);
              continue;
              k.this.vYb.start();
              k.a(k.this, k.this.vXV, SystemClock.elapsedRealtime(), 0L);
              continue;
              k.a(k.this, k.this.vXV, SystemClock.elapsedRealtime(), 0L);
              k.this.vYb.pause();
              continue;
              k.this.vYb.release();
              k.this.vYa = true;
              k.this.vXW.obtainMessage(0).sendToTarget();
            }
          }
        }
      }
    };
    this.vXB = paramaq;
    this.fOX = false;
    this.vXA = new h(this.fOX, paramInt);
    this.vXW = new aq(parama, this.vYd);
    this.vXW.setLogging(false);
    this.vXZ = new l(this.vXA, this.vXB);
    this.vXU = new aq(paramLooper1, this.vYe);
    if (paramLooper2 != null)
    {
      this.vYb = new a(this.vXA, this.vXB);
      this.vXV = new aq(paramLooper2, this.vYf);
      this.vXV.setLogging(false);
    }
    AppMethodBeat.o(220264);
  }
  
  private void a(aq paramaq, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(133951);
    if (e.Kw(this.state))
    {
      ae.w("MicroMsg.VideoPlayerImpl", "isEnd state=%s", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(133951);
      return;
    }
    if (paramaq.isQuit())
    {
      ae.w("MicroMsg.VideoPlayerImpl", "handler has quit");
      AppMethodBeat.o(133951);
      return;
    }
    paramaq.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      paramaq.sendEmptyMessage(2);
      AppMethodBeat.o(133951);
      return;
    }
    paramaq.sendEmptyMessageDelayed(2, paramLong1);
    AppMethodBeat.o(133951);
  }
  
  private void dpz()
  {
    AppMethodBeat.i(133945);
    ae.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[] { info() });
    this.vXZ.setState(5);
    if (this.vYb != null)
    {
      this.vYb.dpu();
      this.vXA.vXs = this.vYb.KA((int)this.vXA.vXq);
      this.vYb.setState(5);
    }
    KC(7);
    setState(4);
    this.vXB.obtainMessage(3, 0, 0).sendToTarget();
    this.vXA.vXr = (this.vXA.vXq * 1000L);
    this.vXA.vXq = -1L;
    AppMethodBeat.o(133945);
  }
  
  public final void KB(int paramInt)
  {
    AppMethodBeat.i(133944);
    ae.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.TRUE });
    ae.l("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
    if (this.state < 2)
    {
      ae.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133944);
      return;
    }
    this.vXZ.pause();
    this.vXU.removeMessages(4);
    if (this.vYb != null)
    {
      this.vYb.pause();
      this.vXV.removeMessages(4);
    }
    if (paramInt >= this.bup)
    {
      ae.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.bup) });
      setState(6);
      this.vXW.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133944);
      return;
    }
    this.vXU.obtainMessage(8).sendToTarget();
    this.vXU.obtainMessage(5, new int[] { paramInt, 1 }).sendToTarget();
    AppMethodBeat.o(133944);
  }
  
  final void KC(int paramInt)
  {
    AppMethodBeat.i(133949);
    ae.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.vXA.dQn), Long.valueOf(this.vXA.vXp), Long.valueOf(this.vXA.bdJ) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.vXX = this.vXA.dQn;
      this.bdJ = this.vXA.bdJ;
      ae.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.vXX), Long.valueOf(this.bdJ) });
      AppMethodBeat.o(133949);
      return;
      h localh;
      if (this.vXA.vXp > 0L)
      {
        localh = this.vXA;
        localh.bdJ += this.vXA.vXp - this.vXA.dQn;
        this.vXA.vXp = 0L;
      }
      this.vXA.dQn = SystemClock.elapsedRealtime();
      continue;
      if (this.vXA.dQn <= 0L)
      {
        this.vXA.vXp = 0L;
      }
      else
      {
        this.vXA.vXp = SystemClock.elapsedRealtime();
        continue;
        this.vXA.bdJ = this.vXA.vXq;
        this.vXA.dQn = SystemClock.elapsedRealtime();
        this.vXA.vXp = 0L;
        localh = this.vXA;
        this.vXA.vXs = 0L;
        localh.vXr = 0L;
        continue;
        this.vXA.bdJ = this.vXA.vXq;
        localh = this.vXA;
        this.vXA.vXp = 0L;
        localh.dQn = 0L;
        localh = this.vXA;
        this.vXA.vXs = 0L;
        localh.vXr = 0L;
        continue;
        this.vXA.bdJ = this.vXA.vXq;
        localh = this.vXA;
        this.vXA.vXp = 0L;
        localh.dQn = 0L;
      }
    }
  }
  
  public final void bpy()
  {
    AppMethodBeat.i(133940);
    if (this.vXZ != null)
    {
      ae.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { info() });
      this.vXZ.setState(10);
      a(this.vXU, SystemClock.elapsedRealtime(), 0L);
    }
    AppMethodBeat.o(133940);
  }
  
  public final boolean cSW()
  {
    AppMethodBeat.i(133939);
    ae.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { info() });
    this.vXU.obtainMessage(1).sendToTarget();
    if (this.vYb != null) {
      this.vXV.obtainMessage(1).sendToTarget();
    }
    AppMethodBeat.o(133939);
    return true;
  }
  
  public final void dpy()
  {
    AppMethodBeat.i(133937);
    ae.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { info(), Long.valueOf(this.vXA.vXr) });
    if (this.vXZ != null)
    {
      this.vXZ.W(this.vXA.vXr, -1L);
      this.vXZ.dpu();
      this.vXZ.vXE = 0L;
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
    String str = this.vXA.info() + "_" + Process.myTid();
    AppMethodBeat.o(133950);
    return str;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133942);
    setState(4);
    this.vXU.removeMessages(4);
    this.vXU.obtainMessage(4).sendToTarget();
    if (this.vYb != null)
    {
      this.vXV.removeMessages(4);
      this.vXV.obtainMessage(4).sendToTarget();
    }
    AppMethodBeat.o(133942);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133947);
    setState(9);
    this.vXW.removeMessages(2);
    this.vXW.removeMessages(9);
    this.vXU.removeMessages(1);
    this.vXU.removeMessages(2);
    this.vXU.removeMessages(3);
    this.vXU.removeMessages(4);
    this.vXU.removeMessages(6);
    this.vXU.removeCallbacksAndMessages(null);
    try
    {
      this.vXZ.setState(9);
      Object localObject = this.vXZ;
      ae.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((l)localObject).info(), Boolean.valueOf(((l)localObject).vYk) });
      if ((((l)localObject).vYk) && (d.lC(19))) {
        this.vXZ.releaseDecoder();
      }
      this.vXU.removeMessages(7);
      this.vXU.obtainMessage(7).sendToTarget();
      if (this.vXV != null)
      {
        this.vXV.removeMessages(1);
        this.vXV.removeMessages(2);
        this.vXV.removeMessages(3);
        this.vXV.removeMessages(4);
        this.vXV.removeMessages(6);
        this.vXV.removeMessages(7);
        this.vXV.obtainMessage(7).sendToTarget();
      }
      localObject = this.vXA;
      ((h)localObject).dQn = 0L;
      ((h)localObject).vXp = 0L;
      ((h)localObject).vXq = -1L;
      ((h)localObject).bdJ = 0L;
      ((h)localObject).vXr = 0L;
      ((h)localObject).vXs = 0L;
      AppMethodBeat.o(133947);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "%s release error %s", new Object[] { info(), localException.toString() });
      }
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(133943);
    ae.i("MicroMsg.VideoPlayerImpl", "%s seek to mSeekSec %d", new Object[] { info(), Integer.valueOf(paramInt) });
    ae.l("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
    if (this.state < 2)
    {
      ae.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133943);
      return;
    }
    this.vXZ.pause();
    if (this.vYb != null) {
      this.vYb.pause();
    }
    setState(5);
    if (paramInt >= this.bup)
    {
      this.vXW.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133943);
      return;
    }
    this.vXZ.dpu();
    this.vXA.vXq = this.vXZ.KA(paramInt);
    this.vXZ.setState(5);
    KC(5);
    dpz();
    AppMethodBeat.o(133943);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133936);
    ae.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { info(), paramString });
    this.vXZ.setPath(paramString);
    if (this.vYb != null) {
      this.vYb.setPath(paramString);
    }
    AppMethodBeat.o(133936);
  }
  
  protected final void setState(int paramInt)
  {
    AppMethodBeat.i(133948);
    ae.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    this.vXA.vXt = 0L;
    AppMethodBeat.o(133948);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133938);
    ae.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { info(), Integer.valueOf(paramSurface.hashCode()) });
    this.vXZ.surface = paramSurface;
    AppMethodBeat.o(133938);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133941);
    setState(3);
    this.vXU.removeMessages(3);
    this.vXU.obtainMessage(3).sendToTarget();
    if (this.vYb != null)
    {
      this.vXV.removeMessages(3);
      this.vXV.obtainMessage(3).sendToTarget();
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