package com.tencent.mm.plugin.n;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  implements c
{
  long bdG;
  public long durationMs;
  boolean guh;
  public int state;
  public h zrC;
  MMHandler zrD;
  MMHandler zrW;
  MMHandler zrX;
  MMHandler zrY;
  long zrZ;
  boolean zsa;
  public l zsb;
  boolean zsc;
  a zsd;
  int zse;
  private MMHandler.Callback zsf;
  private MMHandler.Callback zsg;
  private MMHandler.Callback zsh;
  
  public k(MMHandler paramMMHandler, com.tencent.f.j.a parama, Looper paramLooper1, Looper paramLooper2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(208745);
    this.zsa = false;
    this.zsc = false;
    this.zse = -1;
    this.zsf = new MMHandler.Callback()
    {
      private int tIj = -1;
      private int zsi = -1;
      private int zsj = -1;
      private long zsk = -1L;
      
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133932);
        int i = paramAnonymousMessage.what;
        if ((this.zsk <= 0L) || (Util.ticksToNow(this.zsk) > 500L) || (this.zsi != i) || (this.tIj != k.this.state) || (this.zsj != k.this.zsb.state))
        {
          Log.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { k.this.info(), Integer.valueOf(i), Integer.valueOf(k.this.state), Integer.valueOf(k.this.zsb.state) });
          this.zsk = Util.currentTicks();
          this.zsi = i;
          this.tIj = k.this.state;
          this.zsj = k.this.zsb.state;
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
          boolean bool2 = e.Qt(k.this.zsb.state);
          boolean bool1 = bool2;
          if (k.this.zsd != null) {
            bool1 = bool2 & e.Qt(k.this.zsd.state);
          }
          if (bool1)
          {
            k.this.setState(2);
            k.this.zrD.obtainMessage(1).sendToTarget();
            continue;
            k.a(k.this);
            continue;
            if (e.Qx(k.this.state))
            {
              AppMethodBeat.o(133932);
              return false;
            }
            if ((e.Qy(k.this.state)) || (e.Qw(k.this.state)))
            {
              k.this.setState(9);
              k.this.zrD.obtainMessage(2).sendToTarget();
              AppMethodBeat.o(133932);
              return false;
            }
            bool2 = e.Qx(k.this.zsb.state);
            bool1 = bool2;
            if (k.this.zsd != null) {
              bool1 = bool2 & e.Qx(k.this.zsd.state);
            }
            if (bool1)
            {
              k.this.setState(9);
              k.this.zrD.obtainMessage(2).sendToTarget();
              continue;
              if ((k.this.zsa) && ((k.this.guh) || (k.this.zsc))) {
                k.this.zrD.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.zsg = new MMHandler.Callback()
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
          if (k.this.zsb.prepare())
          {
            k.this.durationMs = k.this.zsb.durationMs;
            k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
          }
          else
          {
            k.this.zrD.obtainMessage(5, -1, -1).sendToTarget();
            AppMethodBeat.o(133933);
            return false;
            paramAnonymousMessage = k.this.zrC;
            long l = Util.ticksToNow(paramAnonymousMessage.zrv);
            if ((paramAnonymousMessage.zrv > 0L) && (l >= 30L))
            {
              Log.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[] { paramAnonymousMessage.info(), Long.valueOf(paramAnonymousMessage.zrv), Long.valueOf(l) });
              paramAnonymousMessage.zrw = 0L;
            }
            label788:
            if (e.Qx(k.this.zsb.state))
            {
              k.this.zrY.obtainMessage(9).sendToTarget();
              k.this.zrW.removeMessages(2);
            }
            else
            {
              int j = k.this.zsb.Z(k.this.bdG, k.this.zrZ);
              if (e.Qt(j)) {
                k.this.zrY.obtainMessage(2).sendToTarget();
              }
              if (j == 7) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label350;
                }
                k.this.zrY.obtainMessage(7).sendToTarget();
                k.this.zrW.removeMessages(2);
                break;
              }
              label350:
              if (e.Qz(j))
              {
                k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
                k.this.zrC.zrv = Util.currentTicks();
              }
              else
              {
                if (k.this.state == 3) {
                  k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), k.this.zrC.zrw);
                }
                for (;;)
                {
                  k.this.zrC.zrv = Util.currentTicks();
                  break;
                  if (k.this.state == 5) {
                    k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 1) {
                    k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 0) {
                    k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
                  } else if (k.this.state == 6) {
                    k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
                  } else {
                    k.this.zrW.removeMessages(2);
                  }
                }
                k.this.QD(3);
                k.this.zsb.start();
                k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
                continue;
                k.this.QD(4);
                k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
                k.this.zsb.pause();
                continue;
                k.this.zsb.release();
                k.this.zsa = true;
                k.this.zrY.obtainMessage(0).sendToTarget();
                continue;
                k.this.zsb.ejj();
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
                      l = k.this.zsb.QB(j);
                      if ((i == 0) || (l < 0L) || (l >= j)) {
                        break label905;
                      }
                      bool = true;
                      Log.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { k.this.info(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(j) });
                      k.this.zsb.setState(6);
                      k.this.setState(6);
                      if (!bool) {
                        break label911;
                      }
                    }
                    for (k.this.zrC.zrs = j;; k.this.zrC.zrs = l)
                    {
                      k.this.QD(6);
                      k.a(k.this, k.this.zrW, SystemClock.elapsedRealtime(), 0L);
                      break;
                      i = 0;
                      break label753;
                      bool = false;
                      break label788;
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
    this.zsh = new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133934);
        if (k.this.zsd == null)
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
          if (!k.this.zsd.prepare())
          {
            Log.i("MicroMsg.VideoPlayerImpl", "%s audio track prepare error, release now.", new Object[] { k.this.info() });
            k.this.zsd.release();
            k.this.zsc = true;
            k.this.zsd = null;
          }
          k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0L);
          continue;
          if (e.Qx(k.this.zsd.state))
          {
            k.this.zrY.obtainMessage(9).sendToTarget();
            k.this.zrX.removeMessages(2);
          }
          else
          {
            if (e.Qt(k.this.zsd.Z(k.this.bdG, k.this.zrZ))) {
              k.this.zrY.sendMessageDelayed(k.this.zrY.obtainMessage(2), 10L);
            }
            if (k.this.state == 3)
            {
              k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), k.this.zrC.zrw);
            }
            else if (k.this.state == 5)
            {
              k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 1)
            {
              k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0L);
            }
            else if (k.this.state == 0)
            {
              k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0L);
            }
            else
            {
              k.this.zrX.removeMessages(2);
              continue;
              k.this.zsd.start();
              k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0L);
              continue;
              k.a(k.this, k.this.zrX, SystemClock.elapsedRealtime(), 0L);
              k.this.zsd.pause();
              continue;
              k.this.zsd.release();
              k.this.zsc = true;
              k.this.zrY.obtainMessage(0).sendToTarget();
            }
          }
        }
      }
    };
    this.zrD = paramMMHandler;
    this.guh = false;
    this.zrC = new h(this.guh, paramInt);
    this.zrY = new MMHandler(parama, this.zsf);
    this.zrY.setLogging(false);
    this.zsb = new l(this.zrC, this.zrD);
    this.zrW = new MMHandler(paramLooper1, this.zsg);
    if (paramLooper2 != null)
    {
      this.zsd = new a(this.zrC, this.zrD);
      this.zrX = new MMHandler(paramLooper2, this.zsh);
      this.zrX.setLogging(false);
    }
    AppMethodBeat.o(208745);
  }
  
  private void a(MMHandler paramMMHandler, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(133951);
    if (e.Qx(this.state))
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
  
  private void ejo()
  {
    AppMethodBeat.i(133945);
    Log.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[] { info() });
    this.zsb.setState(5);
    if (this.zsd != null)
    {
      this.zsd.ejj();
      this.zrC.zru = this.zsd.QB((int)this.zrC.zrs);
      this.zsd.setState(5);
    }
    QD(7);
    setState(4);
    this.zrD.obtainMessage(3, 0, 0).sendToTarget();
    this.zrC.zrt = (this.zrC.zrs * 1000L);
    this.zrC.zrs = -1L;
    AppMethodBeat.o(133945);
  }
  
  public final void QC(int paramInt)
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
    this.zsb.pause();
    this.zrW.removeMessages(4);
    if (this.zsd != null)
    {
      this.zsd.pause();
      this.zrX.removeMessages(4);
    }
    if (paramInt >= this.durationMs)
    {
      Log.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.durationMs) });
      setState(6);
      this.zrY.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133944);
      return;
    }
    this.zrW.obtainMessage(8).sendToTarget();
    this.zrW.obtainMessage(5, new int[] { paramInt, 1 }).sendToTarget();
    AppMethodBeat.o(133944);
  }
  
  final void QD(int paramInt)
  {
    AppMethodBeat.i(133949);
    Log.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.zrC.eiq), Long.valueOf(this.zrC.zrr), Long.valueOf(this.zrC.bdG) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.zrZ = this.zrC.eiq;
      this.bdG = this.zrC.bdG;
      Log.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { info(), Integer.valueOf(paramInt), Long.valueOf(this.zrZ), Long.valueOf(this.bdG) });
      AppMethodBeat.o(133949);
      return;
      h localh;
      if (this.zrC.zrr > 0L)
      {
        localh = this.zrC;
        localh.bdG += this.zrC.zrr - this.zrC.eiq;
        this.zrC.zrr = 0L;
      }
      this.zrC.eiq = SystemClock.elapsedRealtime();
      continue;
      if (this.zrC.eiq <= 0L)
      {
        this.zrC.zrr = 0L;
      }
      else
      {
        this.zrC.zrr = SystemClock.elapsedRealtime();
        continue;
        this.zrC.bdG = this.zrC.zrs;
        this.zrC.eiq = SystemClock.elapsedRealtime();
        this.zrC.zrr = 0L;
        localh = this.zrC;
        this.zrC.zru = 0L;
        localh.zrt = 0L;
        continue;
        this.zrC.bdG = this.zrC.zrs;
        localh = this.zrC;
        this.zrC.zrr = 0L;
        localh.eiq = 0L;
        localh = this.zrC;
        this.zrC.zru = 0L;
        localh.zrt = 0L;
        continue;
        this.zrC.bdG = this.zrC.zrs;
        localh = this.zrC;
        this.zrC.zrr = 0L;
        localh.eiq = 0L;
      }
    }
  }
  
  public final void bLe()
  {
    AppMethodBeat.i(133940);
    if (this.zsb != null)
    {
      Log.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { info() });
      this.zsb.setState(10);
      a(this.zrW, SystemClock.elapsedRealtime(), 0L);
    }
    AppMethodBeat.o(133940);
  }
  
  public final void ejn()
  {
    AppMethodBeat.i(133937);
    Log.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { info(), Long.valueOf(this.zrC.zrt) });
    if (this.zsb != null)
    {
      this.zsb.aa(this.zrC.zrt, -1L);
      this.zsb.ejj();
      this.zsb.zrG = 0L;
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
    String str = this.zrC.info() + "_" + Process.myTid();
    AppMethodBeat.o(133950);
    return str;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133942);
    setState(4);
    this.zrW.removeMessages(4);
    this.zrW.obtainMessage(4).sendToTarget();
    if (this.zsd != null)
    {
      this.zrX.removeMessages(4);
      this.zrX.obtainMessage(4).sendToTarget();
    }
    AppMethodBeat.o(133942);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(133939);
    Log.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { info() });
    this.zrW.obtainMessage(1).sendToTarget();
    if (this.zsd != null) {
      this.zrX.obtainMessage(1).sendToTarget();
    }
    AppMethodBeat.o(133939);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(133947);
    setState(9);
    this.zrY.removeMessages(2);
    this.zrY.removeMessages(9);
    this.zrW.removeMessages(1);
    this.zrW.removeMessages(2);
    this.zrW.removeMessages(3);
    this.zrW.removeMessages(4);
    this.zrW.removeMessages(6);
    this.zrW.removeCallbacksAndMessages(null);
    try
    {
      this.zsb.setState(9);
      Object localObject = this.zsb;
      Log.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((l)localObject).info(), Boolean.valueOf(((l)localObject).zsm) });
      if ((((l)localObject).zsm) && (d.oF(19))) {
        this.zsb.releaseDecoder();
      }
      this.zrW.removeMessages(7);
      this.zrW.obtainMessage(7).sendToTarget();
      if (this.zrX != null)
      {
        this.zrX.removeMessages(1);
        this.zrX.removeMessages(2);
        this.zrX.removeMessages(3);
        this.zrX.removeMessages(4);
        this.zrX.removeMessages(6);
        this.zrX.removeMessages(7);
        this.zrX.obtainMessage(7).sendToTarget();
      }
      localObject = this.zrC;
      ((h)localObject).eiq = 0L;
      ((h)localObject).zrr = 0L;
      ((h)localObject).zrs = -1L;
      ((h)localObject).bdG = 0L;
      ((h)localObject).zrt = 0L;
      ((h)localObject).zru = 0L;
      AppMethodBeat.o(133947);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "%s release error %s", new Object[] { info(), localException.toString() });
      }
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
    this.zsb.pause();
    if (this.zsd != null) {
      this.zsd.pause();
    }
    setState(5);
    if (paramInt >= this.durationMs)
    {
      this.zrY.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(133943);
      return;
    }
    this.zsb.ejj();
    this.zrC.zrs = this.zsb.QB(paramInt);
    this.zsb.setState(5);
    QD(5);
    ejo();
    AppMethodBeat.o(133943);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133936);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { info(), paramString });
    this.zsb.setPath(paramString);
    if (this.zsd != null) {
      this.zsd.setPath(paramString);
    }
    AppMethodBeat.o(133936);
  }
  
  protected final void setState(int paramInt)
  {
    AppMethodBeat.i(133948);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d", new Object[] { info(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    this.zrC.zrv = 0L;
    AppMethodBeat.o(133948);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133938);
    Log.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { info(), Integer.valueOf(paramSurface.hashCode()) });
    this.zsb.surface = paramSurface;
    AppMethodBeat.o(133938);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133941);
    setState(3);
    this.zrW.removeMessages(3);
    this.zrW.obtainMessage(3).sendToTarget();
    if (this.zsd != null)
    {
      this.zrX.removeMessages(3);
      this.zrX.obtainMessage(3).sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.n.k
 * JD-Core Version:    0.7.0.1
 */