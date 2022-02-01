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
  int LmI;
  long aSw;
  public long bjp;
  boolean fqj;
  public int state;
  ap tAo;
  ap tAp;
  ap tAq;
  long tAr;
  boolean tAs;
  public l tAt;
  boolean tAu;
  a tAv;
  private ap.a tAw;
  private ap.a tAx;
  private ap.a tAy;
  public h tzT;
  ap tzU;
  
  public k(ap paramap, com.tencent.e.j.a parama, Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(182768);
    this.tAs = false;
    this.tAu = false;
    this.LmI = -1;
    this.tAw = new ap.a()
    {
      private int qsI = -1;
      private int tAA = -1;
      private long tAB = -1L;
      private int tAz = -1;
      
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133932);
        int i = paramAnonymousMessage.what;
        if ((this.tAB <= 0L) || (bt.aS(this.tAB) > 500L) || (this.tAz != i) || (this.qsI != k.this.state) || (this.tAA != k.this.tAt.state))
        {
          ad.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { k.this.info(), Integer.valueOf(i), Integer.valueOf(k.this.state), Integer.valueOf(k.this.tAt.state) });
          this.tAB = bt.GC();
          this.tAz = i;
          this.qsI = k.this.state;
          this.tAA = k.this.tAt.state;
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
          boolean bool2 = e.Gz(k.this.tAt.state);
          boolean bool1 = bool2;
          if (k.this.tAv != null) {
            bool1 = bool2 & e.Gz(k.this.tAv.state);
          }
          if (bool1)
          {
            k.this.setState(2);
            k.this.tzU.obtainMessage(1).sendToTarget();
            continue;
            k.a(k.this);
            continue;
            if (e.GD(k.this.state))
            {
              AppMethodBeat.o(133932);
              return false;
            }
            if ((e.GE(k.this.state)) || (e.GC(k.this.state)))
            {
              k.this.setState(9);
              k.this.tzU.obtainMessage(2).sendToTarget();
              AppMethodBeat.o(133932);
              return false;
            }
            bool2 = e.GD(k.this.tAt.state);
            bool1 = bool2;
            if (k.this.tAv != null) {
              bool1 = bool2 & e.GD(k.this.tAv.state);
            }
            if (bool1)
            {
              k.this.setState(9);
              k.this.tzU.obtainMessage(2).sendToTarget();
              continue;
              if ((k.this.tAs) && ((k.this.fqj) || (k.this.tAu))) {
                k.this.tzU.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.tAx = new ap.a()
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
          if (k.this.tAt.cuQ())
          {
            k.this.bjp = k.this.tAt.bjp;
            k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
          }
          else
          {
            k.this.tzU.obtainMessage(5, -1, -1).sendToTarget();
            AppMethodBeat.o(133933);
            return false;
            paramAnonymousMessage = k.this.tzT;
            long l = bt.aS(paramAnonymousMessage.tzN);
            if ((paramAnonymousMessage.tzN > 0L) && (l >= 30L))
            {
              ad.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramAnonymousMessage.info(), Long.valueOf(paramAnonymousMessage.tzN), Long.valueOf(l) });
              paramAnonymousMessage.tzO = 0L;
            }
            label788:
            if (e.GD(k.this.tAt.state))
            {
              k.this.tAq.obtainMessage(9).sendToTarget();
              k.this.tAo.removeMessages(2);
            }
            else
            {
              int j = k.this.tAt.Y(k.this.aSw, k.this.tAr);
              if (e.Gz(j)) {
                k.this.tAq.obtainMessage(2).sendToTarget();
              }
              if (j == 7) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label350;
                }
                k.this.tAq.obtainMessage(7).sendToTarget();
                k.this.tAo.removeMessages(2);
                break;
              }
              label350:
              if (e.GF(j))
              {
                k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
                k.this.tzT.tzN = bt.GC();
              }
              else
              {
                if (k.this.state == 3) {
                  k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), k.this.tzT.tzO);
                }
                for (;;)
                {
                  k.this.tzT.tzN = bt.GC();
                  break;
                  if (k.this.state == 5) {
                    k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 1) {
                    k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 0) {
                    k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 6) {
                    k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
                  } else {
                    k.this.tAo.removeMessages(2);
                  }
                }
                k.this.GJ(3);
                k.this.tAt.start();
                k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
                continue;
                k.this.GJ(4);
                k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
                k.this.tAt.pause();
                continue;
                k.this.tAt.release();
                k.this.tAs = true;
                k.this.tAq.obtainMessage(0).sendToTarget();
                continue;
                k.this.tAt.cPr();
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
                      l = k.this.tAt.GH(j);
                      if ((i == 0) || (l < 0L) || (l >= j)) {
                        break label905;
                      }
                      bool = true;
                      ad.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { k.this.info(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(j) });
                      k.this.tAt.setState(6);
                      k.this.setState(6);
                      if (!bool) {
                        break label911;
                      }
                    }
                    for (k.this.tzT.tzK = j;; k.this.tzT.tzK = l)
                    {
                      k.this.GJ(6);
                      k.a(k.this, k.this.tAo, SystemClock.elapsedRealtime(), 0L);
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
    this.tAy = new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133934);
        if (k.this.tAv == null)
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
          if (!k.this.tAv.cuQ())
          {
            ad.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", new Object[] { k.this.info() });
            k.this.tAv.release();
            k.this.tAu = true;
            k.this.tAv = null;
          }
          k.a(k.this, k.this.tAp, SystemClock.elapsedRealtime(), 0L);
          continue;
          if (e.GD(k.this.tAv.state))
          {
            k.this.tAq.obtainMessage(9).sendToTarget();
            k.this.tAp.removeMessages(2);
          }
          else
          {
            if (e.Gz(k.this.tAv.Y(k.this.aSw, k.this.tAr))) {
              k.this.tAq.sendMessageDelayed(k.this.tAq.obtainMessage(2), 10L);
            }
            if (k.this.state == 3)
            {
              k.a(k.this, k.this.tAp, SystemClock.elapsedRealtime(), k.this.tzT.tzO);
            }
            else if (k.this.state == 5)
            {
              k.a(k.this, k.this.tAp, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 1)
            {
              k.a(k.this, k.this.tAp, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 0)
            {
              k.a(k.this, k.this.tAp, SystemClock.elapsedRealtime(), 0L);
            }
            else
            {
              k.this.tAp.removeMessages(2);
              continue;
              k.this.tAv.start();
              k.a(k.this, k.this.tAp, SystemClock.elapsedRealtime(), 0L);
              continue;
              k.a(k.this, k.this.tAp, SystemClock.elapsedRealtime(), 0L);
              k.this.tAv.pause();
              continue;
              k.this.tAv.release();
              k.this.tAu = true;
              k.this.tAq.obtainMessage(0).sendToTarget();
            }
          }
        }
      }
    };
    this.tzU = paramap;
    this.fqj = false;
    this.tzT = new h(this.fqj);
    this.tAq = new ap(parama, this.tAw);
    this.tAq.setLogging(false);
    this.tAt = new l(this.tzT, this.tzU);
    this.tAo = new ap(paramLooper1, this.tAx);
    if (paramLooper2 != null)
    {
      this.tAv = new a(this.tzT, this.tzU);
      this.tAp = new ap(paramLooper2, this.tAy);
      this.tAp.setLogging(false);
    }
    AppMethodBeat.o(182768);
  }
  
  private void a(ap paramap, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(133951);
    if (e.GD(this.state))
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
  
  private void cPw()
  {
    AppMethodBeat.i(133945);
    ad.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[] { info() });
    this.tAt.setState(5);
    if (this.tAv != null)
    {
      this.tAv.cPr();
      this.tzT.tzM = this.tAv.GH((int)this.tzT.tzK);
      this.tAv.setState(5);
    }
    GJ(7);
    setState(4);
    this.tzU.obtainMessage(3, 0, 0).sendToTarget();
    this.tzT.tzL = (this.tzT.tzK * 1000L);
    this.tzT.tzK = -1L;
    AppMethodBeat.o(133945);
  }
  
  public final void GI(int paramInt)
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
    this.tAt.pause();
    this.tAo.removeMessages(4);
    if (this.tAv != null)
    {
      this.tAv.pause();
      this.tAp.removeMessages(4);
    }
    if (paramInt >= this.bjp)
    {
      ad.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.bjp) });
      setState(6);
      this.tAq.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133944);
      return;
    }
    this.tAo.obtainMessage(8).sendToTarget();
    this.tAo.obtainMessage(5, new int[] { paramInt, 1 }).sendToTarget();
    AppMethodBeat.o(133944);
  }
  
  final void GJ(int paramInt)
  {
    AppMethodBeat.i(133949);
    ad.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.tzT.bof), Long.valueOf(this.tzT.tzJ), Long.valueOf(this.tzT.aSw) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.tAr = this.tzT.bof;
      this.aSw = this.tzT.aSw;
      ad.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.tAr), Long.valueOf(this.aSw) });
      AppMethodBeat.o(133949);
      return;
      h localh;
      if (this.tzT.tzJ > 0L)
      {
        localh = this.tzT;
        localh.aSw += this.tzT.tzJ - this.tzT.bof;
        this.tzT.tzJ = 0L;
      }
      this.tzT.bof = SystemClock.elapsedRealtime();
      continue;
      if (this.tzT.bof <= 0L)
      {
        this.tzT.tzJ = 0L;
      }
      else
      {
        this.tzT.tzJ = SystemClock.elapsedRealtime();
        continue;
        this.tzT.aSw = this.tzT.tzK;
        this.tzT.bof = SystemClock.elapsedRealtime();
        this.tzT.tzJ = 0L;
        localh = this.tzT;
        this.tzT.tzM = 0L;
        localh.tzL = 0L;
        continue;
        this.tzT.aSw = this.tzT.tzK;
        localh = this.tzT;
        this.tzT.tzJ = 0L;
        localh.bof = 0L;
        localh = this.tzT;
        this.tzT.tzM = 0L;
        localh.tzL = 0L;
        continue;
        this.tzT.aSw = this.tzT.tzK;
        localh = this.tzT;
        this.tzT.tzJ = 0L;
        localh.bof = 0L;
      }
    }
  }
  
  public final void bej()
  {
    AppMethodBeat.i(133940);
    if (this.tAt != null)
    {
      ad.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { info() });
      this.tAt.setState(10);
      a(this.tAo, SystemClock.elapsedRealtime(), 0L);
    }
    AppMethodBeat.o(133940);
  }
  
  public final void cPv()
  {
    AppMethodBeat.i(133937);
    ad.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { info(), Long.valueOf(this.tzT.tzL) });
    if (this.tAt != null)
    {
      this.tAt.Z(this.tzT.tzL, -1L);
      this.tAt.cPr();
      this.tAt.tzX = 0L;
    }
    AppMethodBeat.o(133937);
  }
  
  public final boolean cuQ()
  {
    AppMethodBeat.i(133939);
    ad.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { info() });
    this.tAo.obtainMessage(1).sendToTarget();
    if (this.tAv != null) {
      this.tAp.obtainMessage(1).sendToTarget();
    }
    AppMethodBeat.o(133939);
    return true;
  }
  
  public final long cuR()
  {
    return this.bjp;
  }
  
  public final String info()
  {
    AppMethodBeat.i(133950);
    String str = this.tzT.info() + "_" + Process.myTid();
    AppMethodBeat.o(133950);
    return str;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133942);
    setState(4);
    this.tAo.removeMessages(4);
    this.tAo.obtainMessage(4).sendToTarget();
    if (this.tAv != null)
    {
      this.tAp.removeMessages(4);
      this.tAp.obtainMessage(4).sendToTarget();
    }
    AppMethodBeat.o(133942);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133947);
    setState(9);
    this.tAq.removeMessages(2);
    this.tAq.removeMessages(9);
    this.tAo.removeMessages(1);
    this.tAo.removeMessages(2);
    this.tAo.removeMessages(3);
    this.tAo.removeMessages(4);
    this.tAo.removeMessages(6);
    this.tAo.removeCallbacksAndMessages(null);
    try
    {
      this.tAt.setState(9);
      Object localObject = this.tAt;
      ad.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((l)localObject).info(), Boolean.valueOf(((l)localObject).tAD) });
      if ((((l)localObject).tAD) && (d.lh(19))) {
        this.tAt.releaseDecoder();
      }
      this.tAo.removeMessages(7);
      this.tAo.obtainMessage(7).sendToTarget();
      if (this.tAp != null)
      {
        this.tAp.removeMessages(1);
        this.tAp.removeMessages(2);
        this.tAp.removeMessages(3);
        this.tAp.removeMessages(4);
        this.tAp.removeMessages(6);
        this.tAp.removeMessages(7);
        this.tAp.obtainMessage(7).sendToTarget();
      }
      localObject = this.tzT;
      ((h)localObject).bof = 0L;
      ((h)localObject).tzJ = 0L;
      ((h)localObject).tzK = -1L;
      ((h)localObject).aSw = 0L;
      ((h)localObject).tzL = 0L;
      ((h)localObject).tzM = 0L;
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
    this.tAt.pause();
    if (this.tAv != null) {
      this.tAv.pause();
    }
    setState(5);
    if (paramInt >= this.bjp)
    {
      this.tAq.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133943);
      return;
    }
    this.tAt.cPr();
    this.tzT.tzK = this.tAt.GH(paramInt);
    this.tAt.setState(5);
    GJ(5);
    cPw();
    AppMethodBeat.o(133943);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133936);
    ad.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { info(), paramString });
    this.tAt.setPath(paramString);
    if (this.tAv != null) {
      this.tAv.setPath(paramString);
    }
    AppMethodBeat.o(133936);
  }
  
  protected final void setState(int paramInt)
  {
    AppMethodBeat.i(133948);
    ad.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    this.tzT.tzN = 0L;
    AppMethodBeat.o(133948);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133938);
    ad.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { info(), Integer.valueOf(paramSurface.hashCode()) });
    this.tAt.surface = paramSurface;
    AppMethodBeat.o(133938);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133941);
    setState(3);
    this.tAo.removeMessages(3);
    this.tAo.obtainMessage(3).sendToTarget();
    if (this.tAv != null)
    {
      this.tAp.removeMessages(3);
      this.tAp.obtainMessage(3).sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.o.k
 * JD-Core Version:    0.7.0.1
 */