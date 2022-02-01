package com.tencent.mm.plugin.o;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class k
  implements c
{
  long aTp;
  public long bjU;
  boolean ftN;
  public int state;
  ao uIK;
  ao uIL;
  ao uIM;
  long uIN;
  boolean uIO;
  public l uIP;
  boolean uIQ;
  a uIR;
  int uIS;
  private ao.a uIT;
  private ao.a uIU;
  private ao.a uIV;
  public h uIq;
  ao uIr;
  
  public k(ao paramao, com.tencent.e.j.a parama, Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(182768);
    this.uIO = false;
    this.uIQ = false;
    this.uIS = -1;
    this.uIT = new ao.a()
    {
      private int rdt = -1;
      private int uIW = -1;
      private int uIX = -1;
      private long uIY = -1L;
      
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133932);
        int i = paramAnonymousMessage.what;
        if ((this.uIY <= 0L) || (bs.aO(this.uIY) > 500L) || (this.uIW != i) || (this.rdt != k.this.state) || (this.uIX != k.this.uIP.state))
        {
          ac.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { k.this.info(), Integer.valueOf(i), Integer.valueOf(k.this.state), Integer.valueOf(k.this.uIP.state) });
          this.uIY = bs.Gn();
          this.uIW = i;
          this.rdt = k.this.state;
          this.uIX = k.this.uIP.state;
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
          boolean bool2 = e.Iv(k.this.uIP.state);
          boolean bool1 = bool2;
          if (k.this.uIR != null) {
            bool1 = bool2 & e.Iv(k.this.uIR.state);
          }
          if (bool1)
          {
            k.this.setState(2);
            k.this.uIr.obtainMessage(1).sendToTarget();
            continue;
            k.a(k.this);
            continue;
            if (e.Iz(k.this.state))
            {
              AppMethodBeat.o(133932);
              return false;
            }
            if ((e.IA(k.this.state)) || (e.Iy(k.this.state)))
            {
              k.this.setState(9);
              k.this.uIr.obtainMessage(2).sendToTarget();
              AppMethodBeat.o(133932);
              return false;
            }
            bool2 = e.Iz(k.this.uIP.state);
            bool1 = bool2;
            if (k.this.uIR != null) {
              bool1 = bool2 & e.Iz(k.this.uIR.state);
            }
            if (bool1)
            {
              k.this.setState(9);
              k.this.uIr.obtainMessage(2).sendToTarget();
              continue;
              if ((k.this.uIO) && ((k.this.ftN) || (k.this.uIQ))) {
                k.this.uIr.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.uIU = new ao.a()
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
          if (k.this.uIP.cIc())
          {
            k.this.bjU = k.this.uIP.bjU;
            k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
          }
          else
          {
            k.this.uIr.obtainMessage(5, -1, -1).sendToTarget();
            AppMethodBeat.o(133933);
            return false;
            paramAnonymousMessage = k.this.uIq;
            long l = bs.aO(paramAnonymousMessage.uIk);
            if ((paramAnonymousMessage.uIk > 0L) && (l >= 30L))
            {
              ac.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramAnonymousMessage.info(), Long.valueOf(paramAnonymousMessage.uIk), Long.valueOf(l) });
              paramAnonymousMessage.uIl = 0L;
            }
            label788:
            if (e.Iz(k.this.uIP.state))
            {
              k.this.uIM.obtainMessage(9).sendToTarget();
              k.this.uIK.removeMessages(2);
            }
            else
            {
              int j = k.this.uIP.V(k.this.aTp, k.this.uIN);
              if (e.Iv(j)) {
                k.this.uIM.obtainMessage(2).sendToTarget();
              }
              if (j == 7) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label350;
                }
                k.this.uIM.obtainMessage(7).sendToTarget();
                k.this.uIK.removeMessages(2);
                break;
              }
              label350:
              if (e.IB(j))
              {
                k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
                k.this.uIq.uIk = bs.Gn();
              }
              else
              {
                if (k.this.state == 3) {
                  k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), k.this.uIq.uIl);
                }
                for (;;)
                {
                  k.this.uIq.uIk = bs.Gn();
                  break;
                  if (k.this.state == 5) {
                    k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 1) {
                    k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 0) {
                    k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 6) {
                    k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
                  } else {
                    k.this.uIK.removeMessages(2);
                  }
                }
                k.this.IF(3);
                k.this.uIP.start();
                k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
                continue;
                k.this.IF(4);
                k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
                k.this.uIP.pause();
                continue;
                k.this.uIP.release();
                k.this.uIO = true;
                k.this.uIM.obtainMessage(0).sendToTarget();
                continue;
                k.this.uIP.dda();
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
                      l = k.this.uIP.ID(j);
                      if ((i == 0) || (l < 0L) || (l >= j)) {
                        break label905;
                      }
                      bool = true;
                      ac.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { k.this.info(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(j) });
                      k.this.uIP.setState(6);
                      k.this.setState(6);
                      if (!bool) {
                        break label911;
                      }
                    }
                    for (k.this.uIq.uIh = j;; k.this.uIq.uIh = l)
                    {
                      k.this.IF(6);
                      k.a(k.this, k.this.uIK, SystemClock.elapsedRealtime(), 0L);
                      break;
                      i = 0;
                      break label753;
                      bool = false;
                      break label788;
                    }
                  }
                  ac.e("MicroMsg.VideoPlayerImpl", "seek data length error");
                }
                else
                {
                  ac.e("MicroMsg.VideoPlayerImpl", "seek data type error");
                }
              }
            }
          }
        }
      }
    };
    this.uIV = new ao.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133934);
        if (k.this.uIR == null)
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
          if (!k.this.uIR.cIc())
          {
            ac.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", new Object[] { k.this.info() });
            k.this.uIR.release();
            k.this.uIQ = true;
            k.this.uIR = null;
          }
          k.a(k.this, k.this.uIL, SystemClock.elapsedRealtime(), 0L);
          continue;
          if (e.Iz(k.this.uIR.state))
          {
            k.this.uIM.obtainMessage(9).sendToTarget();
            k.this.uIL.removeMessages(2);
          }
          else
          {
            if (e.Iv(k.this.uIR.V(k.this.aTp, k.this.uIN))) {
              k.this.uIM.sendMessageDelayed(k.this.uIM.obtainMessage(2), 10L);
            }
            if (k.this.state == 3)
            {
              k.a(k.this, k.this.uIL, SystemClock.elapsedRealtime(), k.this.uIq.uIl);
            }
            else if (k.this.state == 5)
            {
              k.a(k.this, k.this.uIL, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 1)
            {
              k.a(k.this, k.this.uIL, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 0)
            {
              k.a(k.this, k.this.uIL, SystemClock.elapsedRealtime(), 0L);
            }
            else
            {
              k.this.uIL.removeMessages(2);
              continue;
              k.this.uIR.start();
              k.a(k.this, k.this.uIL, SystemClock.elapsedRealtime(), 0L);
              continue;
              k.a(k.this, k.this.uIL, SystemClock.elapsedRealtime(), 0L);
              k.this.uIR.pause();
              continue;
              k.this.uIR.release();
              k.this.uIQ = true;
              k.this.uIM.obtainMessage(0).sendToTarget();
            }
          }
        }
      }
    };
    this.uIr = paramao;
    this.ftN = false;
    this.uIq = new h(this.ftN);
    this.uIM = new ao(parama, this.uIT);
    this.uIM.setLogging(false);
    this.uIP = new l(this.uIq, this.uIr);
    this.uIK = new ao(paramLooper1, this.uIU);
    if (paramLooper2 != null)
    {
      this.uIR = new a(this.uIq, this.uIr);
      this.uIL = new ao(paramLooper2, this.uIV);
      this.uIL.setLogging(false);
    }
    AppMethodBeat.o(182768);
  }
  
  private void a(ao paramao, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(133951);
    if (e.Iz(this.state))
    {
      ac.w("MicroMsg.VideoPlayerImpl", "isEnd state=%s", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(133951);
      return;
    }
    if (paramao.isQuit())
    {
      ac.w("MicroMsg.VideoPlayerImpl", "handler has quit");
      AppMethodBeat.o(133951);
      return;
    }
    paramao.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      paramao.sendEmptyMessage(2);
      AppMethodBeat.o(133951);
      return;
    }
    paramao.sendEmptyMessageDelayed(2, paramLong1);
    AppMethodBeat.o(133951);
  }
  
  private void ddf()
  {
    AppMethodBeat.i(133945);
    ac.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[] { info() });
    this.uIP.setState(5);
    if (this.uIR != null)
    {
      this.uIR.dda();
      this.uIq.uIj = this.uIR.ID((int)this.uIq.uIh);
      this.uIR.setState(5);
    }
    IF(7);
    setState(4);
    this.uIr.obtainMessage(3, 0, 0).sendToTarget();
    this.uIq.uIi = (this.uIq.uIh * 1000L);
    this.uIq.uIh = -1L;
    AppMethodBeat.o(133945);
  }
  
  public final void IE(int paramInt)
  {
    AppMethodBeat.i(133944);
    ac.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[] { info(), Integer.valueOf(paramInt), Boolean.TRUE });
    ac.l("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
    if (this.state < 2)
    {
      ac.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133944);
      return;
    }
    this.uIP.pause();
    this.uIK.removeMessages(4);
    if (this.uIR != null)
    {
      this.uIR.pause();
      this.uIL.removeMessages(4);
    }
    if (paramInt >= this.bjU)
    {
      ac.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.bjU) });
      setState(6);
      this.uIM.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133944);
      return;
    }
    this.uIK.obtainMessage(8).sendToTarget();
    this.uIK.obtainMessage(5, new int[] { paramInt, 1 }).sendToTarget();
    AppMethodBeat.o(133944);
  }
  
  final void IF(int paramInt)
  {
    AppMethodBeat.i(133949);
    ac.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.uIq.dCK), Long.valueOf(this.uIq.uIg), Long.valueOf(this.uIq.aTp) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.uIN = this.uIq.dCK;
      this.aTp = this.uIq.aTp;
      ac.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.uIN), Long.valueOf(this.aTp) });
      AppMethodBeat.o(133949);
      return;
      h localh;
      if (this.uIq.uIg > 0L)
      {
        localh = this.uIq;
        localh.aTp += this.uIq.uIg - this.uIq.dCK;
        this.uIq.uIg = 0L;
      }
      this.uIq.dCK = SystemClock.elapsedRealtime();
      continue;
      if (this.uIq.dCK <= 0L)
      {
        this.uIq.uIg = 0L;
      }
      else
      {
        this.uIq.uIg = SystemClock.elapsedRealtime();
        continue;
        this.uIq.aTp = this.uIq.uIh;
        this.uIq.dCK = SystemClock.elapsedRealtime();
        this.uIq.uIg = 0L;
        localh = this.uIq;
        this.uIq.uIj = 0L;
        localh.uIi = 0L;
        continue;
        this.uIq.aTp = this.uIq.uIh;
        localh = this.uIq;
        this.uIq.uIg = 0L;
        localh.dCK = 0L;
        localh = this.uIq;
        this.uIq.uIj = 0L;
        localh.uIi = 0L;
        continue;
        this.uIq.aTp = this.uIq.uIh;
        localh = this.uIq;
        this.uIq.uIg = 0L;
        localh.dCK = 0L;
      }
    }
  }
  
  public final void bld()
  {
    AppMethodBeat.i(133940);
    if (this.uIP != null)
    {
      ac.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { info() });
      this.uIP.setState(10);
      a(this.uIK, SystemClock.elapsedRealtime(), 0L);
    }
    AppMethodBeat.o(133940);
  }
  
  public final boolean cIc()
  {
    AppMethodBeat.i(133939);
    ac.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { info() });
    this.uIK.obtainMessage(1).sendToTarget();
    if (this.uIR != null) {
      this.uIL.obtainMessage(1).sendToTarget();
    }
    AppMethodBeat.o(133939);
    return true;
  }
  
  public final void dde()
  {
    AppMethodBeat.i(133937);
    ac.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { info(), Long.valueOf(this.uIq.uIi) });
    if (this.uIP != null)
    {
      this.uIP.W(this.uIq.uIi, -1L);
      this.uIP.dda();
      this.uIP.uIu = 0L;
    }
    AppMethodBeat.o(133937);
  }
  
  public final long getDurationMs()
  {
    return this.bjU;
  }
  
  public final String info()
  {
    AppMethodBeat.i(133950);
    String str = this.uIq.info() + "_" + Process.myTid();
    AppMethodBeat.o(133950);
    return str;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133942);
    setState(4);
    this.uIK.removeMessages(4);
    this.uIK.obtainMessage(4).sendToTarget();
    if (this.uIR != null)
    {
      this.uIL.removeMessages(4);
      this.uIL.obtainMessage(4).sendToTarget();
    }
    AppMethodBeat.o(133942);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133947);
    setState(9);
    this.uIM.removeMessages(2);
    this.uIM.removeMessages(9);
    this.uIK.removeMessages(1);
    this.uIK.removeMessages(2);
    this.uIK.removeMessages(3);
    this.uIK.removeMessages(4);
    this.uIK.removeMessages(6);
    this.uIK.removeCallbacksAndMessages(null);
    try
    {
      this.uIP.setState(9);
      Object localObject = this.uIP;
      ac.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((l)localObject).info(), Boolean.valueOf(((l)localObject).uJa) });
      if ((((l)localObject).uJa) && (d.lb(19))) {
        this.uIP.releaseDecoder();
      }
      this.uIK.removeMessages(7);
      this.uIK.obtainMessage(7).sendToTarget();
      if (this.uIL != null)
      {
        this.uIL.removeMessages(1);
        this.uIL.removeMessages(2);
        this.uIL.removeMessages(3);
        this.uIL.removeMessages(4);
        this.uIL.removeMessages(6);
        this.uIL.removeMessages(7);
        this.uIL.obtainMessage(7).sendToTarget();
      }
      localObject = this.uIq;
      ((h)localObject).dCK = 0L;
      ((h)localObject).uIg = 0L;
      ((h)localObject).uIh = -1L;
      ((h)localObject).aTp = 0L;
      ((h)localObject).uIi = 0L;
      ((h)localObject).uIj = 0L;
      AppMethodBeat.o(133947);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "%s release error %s", new Object[] { info(), localException.toString() });
      }
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(133943);
    ac.i("MicroMsg.VideoPlayerImpl", "%s seek to mSeekSec %d", new Object[] { info(), Integer.valueOf(paramInt) });
    ac.l("MicroMsg.VideoPlayerImpl", "seek stack", new Object[0]);
    if (this.state < 2)
    {
      ac.w("MicroMsg.VideoPlayerImpl", "%s player is not ready[%d], how to seek[%d]?", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
      AppMethodBeat.o(133943);
      return;
    }
    this.uIP.pause();
    if (this.uIR != null) {
      this.uIR.pause();
    }
    setState(5);
    if (paramInt >= this.bjU)
    {
      this.uIM.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133943);
      return;
    }
    this.uIP.dda();
    this.uIq.uIh = this.uIP.ID(paramInt);
    this.uIP.setState(5);
    IF(5);
    ddf();
    AppMethodBeat.o(133943);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133936);
    ac.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { info(), paramString });
    this.uIP.setPath(paramString);
    if (this.uIR != null) {
      this.uIR.setPath(paramString);
    }
    AppMethodBeat.o(133936);
  }
  
  protected final void setState(int paramInt)
  {
    AppMethodBeat.i(133948);
    ac.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    this.uIq.uIk = 0L;
    AppMethodBeat.o(133948);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133938);
    ac.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { info(), Integer.valueOf(paramSurface.hashCode()) });
    this.uIP.surface = paramSurface;
    AppMethodBeat.o(133938);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133941);
    setState(3);
    this.uIK.removeMessages(3);
    this.uIK.obtainMessage(3).sendToTarget();
    if (this.uIR != null)
    {
      this.uIL.removeMessages(3);
      this.uIL.obtainMessage(3).sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.o.k
 * JD-Core Version:    0.7.0.1
 */