package com.tencent.mm.plugin.n;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
{
  public long aNP;
  long axe;
  boolean efg;
  public g oEN;
  ak oEO;
  ak oFh;
  ak oFi;
  ak oFj;
  long oFk;
  boolean oFl;
  public k oFm;
  boolean oFn;
  a oFo;
  private ak.a oFp;
  private ak.a oFq;
  private ak.a oFr;
  public int state;
  
  public j(ak paramak, Looper paramLooper1, Looper paramLooper2, Looper paramLooper3)
  {
    AppMethodBeat.i(117895);
    this.oFl = false;
    this.oFn = false;
    this.oFp = new ak.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(117892);
        int i = paramAnonymousMessage.what;
        ab.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[] { j.this.oEN.bau(), Integer.valueOf(i), Integer.valueOf(j.this.state), Integer.valueOf(j.this.oFm.state) });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(117892);
          return false;
          if (j.this.state < 2) {}
          for (i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(117892);
            return false;
          }
          boolean bool2 = d.yZ(j.this.oFm.state);
          boolean bool1 = bool2;
          if (j.this.oFo != null) {
            bool1 = bool2 & d.yZ(j.this.oFo.state);
          }
          if (bool1)
          {
            j.this.setState(2);
            j.this.oEO.obtainMessage(1).sendToTarget();
            continue;
            j.a(j.this);
            continue;
            if (d.zd(j.this.state))
            {
              AppMethodBeat.o(117892);
              return false;
            }
            if ((d.ze(j.this.state)) || (d.zc(j.this.state)))
            {
              j.this.setState(9);
              j.this.oEO.obtainMessage(2).sendToTarget();
              AppMethodBeat.o(117892);
              return false;
            }
            bool2 = d.zd(j.this.oFm.state);
            bool1 = bool2;
            if (j.this.oFo != null) {
              bool1 = bool2 & d.zd(j.this.oFo.state);
            }
            if (bool1)
            {
              j.this.setState(9);
              j.this.oEO.obtainMessage(2).sendToTarget();
              continue;
              if ((j.this.oFl) && ((j.this.efg) || (j.this.oFn))) {
                j.this.oEO.obtainMessage(6).sendToTarget();
              }
            }
          }
        }
      }
    };
    this.oFq = new j.2(this);
    this.oFr = new j.3(this);
    this.oEO = paramak;
    this.efg = false;
    this.oEN = new g(this.efg);
    this.oFj = new ak(paramLooper1, this.oFp);
    this.oFm = new k(this.oEN, this.oEO);
    this.oFh = new ak(paramLooper2, this.oFq);
    if (paramLooper3 != null)
    {
      this.oFo = new a(this.oEN, this.oEO);
      this.oFi = new ak(paramLooper3, this.oFr);
    }
    AppMethodBeat.o(117895);
  }
  
  private void a(ak paramak, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(117905);
    if (d.zd(this.state))
    {
      AppMethodBeat.o(117905);
      return;
    }
    try
    {
      Thread localThread = paramak.getLooper().getThread();
      if (localThread != null)
      {
        boolean bool = localThread.isAlive();
        if (!bool)
        {
          AppMethodBeat.o(117905);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      paramak.removeMessages(2);
      paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
      if (paramLong1 <= 0L)
      {
        paramak.sendEmptyMessage(2);
        AppMethodBeat.o(117905);
        return;
      }
      paramak.sendEmptyMessageDelayed(2, paramLong1);
      AppMethodBeat.o(117905);
    }
  }
  
  public final void bQA()
  {
    AppMethodBeat.i(117896);
    ab.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { this.oEN.bau(), Long.valueOf(this.oEN.oEF) });
    if (this.oFm != null)
    {
      this.oFm.P(this.oEN.oEF, -1L);
      this.oFm.bQw();
      this.oFm.oER = 0L;
    }
    AppMethodBeat.o(117896);
  }
  
  public final void bQB()
  {
    AppMethodBeat.i(117897);
    if (this.oFm != null)
    {
      ab.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { this.oEN.bau() });
      this.oFm.setState(10);
      a(this.oFh, SystemClock.elapsedRealtime(), 0L);
    }
    AppMethodBeat.o(117897);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(117899);
    setState(4);
    this.oFh.obtainMessage(4).sendToTarget();
    if (this.oFo != null) {
      this.oFi.obtainMessage(4).sendToTarget();
    }
    AppMethodBeat.o(117899);
  }
  
  public final void release()
  {
    AppMethodBeat.i(117902);
    setState(9);
    this.oFj.removeMessages(2);
    this.oFj.removeMessages(9);
    this.oFh.removeMessages(1);
    this.oFh.removeMessages(2);
    this.oFh.removeMessages(3);
    this.oFh.removeMessages(4);
    this.oFh.removeMessages(6);
    this.oFh.removeCallbacksAndMessages(null);
    try
    {
      this.oFm.setState(9);
      Object localObject = this.oFm;
      ab.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((k)localObject).bau(), Boolean.valueOf(((k)localObject).oFt) });
      if ((((k)localObject).oFt) && (com.tencent.mm.compatible.util.d.iU(19))) {
        this.oFm.pJ();
      }
      this.oFh.obtainMessage(7).sendToTarget();
      if (this.oFi != null)
      {
        this.oFi.removeMessages(1);
        this.oFi.removeMessages(2);
        this.oFi.removeMessages(3);
        this.oFi.removeMessages(4);
        this.oFi.removeMessages(6);
        this.oFi.obtainMessage(7).sendToTarget();
      }
      localObject = this.oEN;
      ((g)localObject).cNY = 0L;
      ((g)localObject).oED = 0L;
      ((g)localObject).oEE = -1L;
      ((g)localObject).axe = 0L;
      ((g)localObject).oEF = 0L;
      ((g)localObject).oEG = 0L;
      AppMethodBeat.o(117902);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "%s release error %s", new Object[] { this.oEN.bau(), localException.toString() });
      }
    }
  }
  
  protected final void setState(int paramInt)
  {
    AppMethodBeat.i(117903);
    ab.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", new Object[] { this.oEN.bau(), Integer.valueOf(this.state), Integer.valueOf(paramInt), bo.dtY() });
    this.state = paramInt;
    this.oEN.oEH = 0L;
    AppMethodBeat.o(117903);
  }
  
  public final void start()
  {
    AppMethodBeat.i(117898);
    setState(3);
    this.oFh.obtainMessage(3).sendToTarget();
    if (this.oFo != null) {
      this.oFi.obtainMessage(3).sendToTarget();
    }
    AppMethodBeat.o(117898);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(117901);
    setState(8);
    AppMethodBeat.o(117901);
  }
  
  public final void zi(int paramInt)
  {
    AppMethodBeat.i(117900);
    ab.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[] { this.oEN.bau(), Integer.valueOf(paramInt), Boolean.TRUE });
    this.oFm.pause();
    this.oFh.removeMessages(4);
    if (this.oFo != null)
    {
      this.oFo.pause();
      this.oFi.removeMessages(4);
    }
    if (paramInt >= this.aNP)
    {
      ab.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.aNP) });
      setState(6);
      this.oFj.obtainMessage(9).sendToTarget();
      AppMethodBeat.o(117900);
      return;
    }
    long l = this.oFm.zh(paramInt);
    boolean bool;
    if ((l >= 0L) && (l < paramInt))
    {
      bool = true;
      ab.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { this.oEN.bau(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(paramInt) });
      this.oFm.setState(6);
      setState(6);
      if (!bool) {
        break label271;
      }
    }
    label271:
    for (this.oEN.oEE = paramInt;; this.oEN.oEE = l)
    {
      zj(6);
      a(this.oFh, SystemClock.elapsedRealtime(), 0L);
      AppMethodBeat.o(117900);
      return;
      bool = false;
      break;
    }
  }
  
  final void zj(int paramInt)
  {
    AppMethodBeat.i(117904);
    ab.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { this.oEN.bau(), Integer.valueOf(paramInt), Long.valueOf(this.oEN.cNY), Long.valueOf(this.oEN.oED), Long.valueOf(this.oEN.axe) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.oFk = this.oEN.cNY;
      this.axe = this.oEN.axe;
      ab.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { this.oEN.bau(), Integer.valueOf(paramInt), Long.valueOf(this.oFk), Long.valueOf(this.axe) });
      AppMethodBeat.o(117904);
      return;
      g localg;
      if (this.oEN.oED > 0L)
      {
        localg = this.oEN;
        localg.axe += this.oEN.oED - this.oEN.cNY;
        this.oEN.oED = 0L;
      }
      this.oEN.cNY = SystemClock.elapsedRealtime();
      continue;
      if (this.oEN.cNY <= 0L)
      {
        this.oEN.oED = 0L;
      }
      else
      {
        this.oEN.oED = SystemClock.elapsedRealtime();
        continue;
        this.oEN.axe = this.oEN.oEE;
        this.oEN.cNY = SystemClock.elapsedRealtime();
        this.oEN.oED = 0L;
        localg = this.oEN;
        this.oEN.oEG = 0L;
        localg.oEF = 0L;
        continue;
        this.oEN.axe = this.oEN.oEE;
        localg = this.oEN;
        this.oEN.oED = 0L;
        localg.cNY = 0L;
        localg = this.oEN;
        this.oEN.oEG = 0L;
        localg.oEF = 0L;
        continue;
        this.oEN.axe = this.oEN.oEE;
        localg = this.oEN;
        this.oEN.oED = 0L;
        localg.cNY = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.n.j
 * JD-Core Version:    0.7.0.1
 */