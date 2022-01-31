package com.tencent.mm.plugin.s;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  public long aGU;
  long auM;
  boolean dnJ;
  ah meI;
  ah meJ;
  ah meK;
  long meL;
  boolean meM = false;
  k meN;
  boolean meO = false;
  a meP;
  private ah.a meQ = new j.1(this);
  private ah.a meR = new j.2(this);
  private ah.a meS = new j.3(this);
  public g mep;
  ah meq;
  int state;
  
  public j(ah paramah, Looper paramLooper1, Looper paramLooper2, Looper paramLooper3)
  {
    this.meq = paramah;
    this.dnJ = false;
    this.mep = new g(this.dnJ);
    this.meK = new ah(paramLooper1, this.meQ);
    this.meN = new k(this.mep, this.meq);
    this.meI = new ah(paramLooper2, this.meR);
    if (paramLooper3 != null)
    {
      this.meP = new a(this.mep, this.meq);
      this.meJ = new ah(paramLooper3, this.meS);
    }
  }
  
  private void a(ah paramah, long paramLong1, long paramLong2)
  {
    if (d.tK(this.state)) {}
    for (;;)
    {
      return;
      try
      {
        Thread localThread = paramah.getLooper().getThread();
        if (localThread != null)
        {
          boolean bool = localThread.isAlive();
          if (!bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        label37:
        break label37;
      }
    }
    paramah.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      paramah.sendEmptyMessage(2);
      return;
    }
    paramah.sendEmptyMessageDelayed(2, paramLong1);
  }
  
  public final void biy()
  {
    y.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[] { this.mep.ayN(), Long.valueOf(this.mep.meh) });
    if (this.meN != null)
    {
      this.meN.D(this.mep.meh, -1L);
      this.meN.biu();
      this.meN.met = 0L;
    }
  }
  
  public final void biz()
  {
    if (this.meN != null)
    {
      y.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[] { this.mep.ayN() });
      this.meN.setState(10);
      a(this.meI, SystemClock.elapsedRealtime(), 0L);
    }
  }
  
  public final void pause()
  {
    setState(4);
    this.meI.obtainMessage(4).sendToTarget();
    if (this.meP != null) {
      this.meJ.obtainMessage(4).sendToTarget();
    }
  }
  
  public final void release()
  {
    setState(9);
    this.meK.removeMessages(2);
    this.meK.removeMessages(9);
    this.meI.removeMessages(1);
    this.meI.removeMessages(2);
    this.meI.removeMessages(3);
    this.meI.removeMessages(4);
    this.meI.removeMessages(6);
    this.meI.removeCallbacksAndMessages(null);
    try
    {
      this.meN.setState(9);
      Object localObject = this.meN;
      y.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[] { ((k)localObject).ayN(), Boolean.valueOf(((k)localObject).meU) });
      if ((((k)localObject).meU) && (com.tencent.mm.compatible.util.d.gH(19))) {
        this.meN.nm();
      }
      this.meI.obtainMessage(7).sendToTarget();
      if (this.meJ != null)
      {
        this.meJ.removeMessages(1);
        this.meJ.removeMessages(2);
        this.meJ.removeMessages(3);
        this.meJ.removeMessages(4);
        this.meJ.removeMessages(6);
        this.meJ.obtainMessage(7).sendToTarget();
      }
      localObject = this.mep;
      ((g)localObject).cfq = 0L;
      ((g)localObject).mef = 0L;
      ((g)localObject).meg = -1L;
      ((g)localObject).auM = 0L;
      ((g)localObject).meh = 0L;
      ((g)localObject).mei = 0L;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.VideoPlayerImpl", localException, "release error %s", new Object[] { localException.toString() });
      }
    }
  }
  
  protected final void setState(int paramInt)
  {
    y.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", new Object[] { this.mep.ayN(), Integer.valueOf(this.state), Integer.valueOf(paramInt), bk.csb() });
    this.state = paramInt;
    this.mep.mej = 0L;
  }
  
  public final void start()
  {
    setState(3);
    this.meI.obtainMessage(3).sendToTarget();
    if (this.meP != null) {
      this.meJ.obtainMessage(3).sendToTarget();
    }
  }
  
  public final void stop()
  {
    setState(8);
  }
  
  public final void tP(int paramInt)
  {
    y.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[] { this.mep.ayN(), Integer.valueOf(paramInt), Boolean.valueOf(true) });
    this.meN.pause();
    if (this.meP != null) {
      this.meP.pause();
    }
    if (paramInt >= this.aGU)
    {
      y.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.aGU) });
      setState(6);
      this.meK.obtainMessage(9).sendToTarget();
      return;
    }
    long l = this.meN.tO(paramInt);
    boolean bool;
    if ((l >= 0L) && (l < paramInt))
    {
      bool = true;
      y.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[] { this.mep.ayN(), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(paramInt) });
      this.meN.setState(6);
      setState(6);
      if (!bool) {
        break label238;
      }
    }
    label238:
    for (this.mep.meg = paramInt;; this.mep.meg = l)
    {
      tQ(6);
      a(this.meI, SystemClock.elapsedRealtime(), 0L);
      return;
      bool = false;
      break;
    }
  }
  
  final void tQ(int paramInt)
  {
    y.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[] { this.mep.ayN(), Integer.valueOf(paramInt), Long.valueOf(this.mep.cfq), Long.valueOf(this.mep.mef), Long.valueOf(this.mep.auM) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.meL = this.mep.cfq;
      this.auM = this.mep.auM;
      y.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[] { this.mep.ayN(), Integer.valueOf(paramInt), Long.valueOf(this.meL), Long.valueOf(this.auM) });
      return;
      g localg;
      if (this.mep.mef > 0L)
      {
        localg = this.mep;
        localg.auM += this.mep.mef - this.mep.cfq;
        this.mep.mef = 0L;
      }
      this.mep.cfq = SystemClock.elapsedRealtime();
      continue;
      if (this.mep.cfq <= 0L)
      {
        this.mep.mef = 0L;
      }
      else
      {
        this.mep.mef = SystemClock.elapsedRealtime();
        continue;
        this.mep.auM = this.mep.meg;
        this.mep.cfq = SystemClock.elapsedRealtime();
        this.mep.mef = 0L;
        localg = this.mep;
        this.mep.mei = 0L;
        localg.meh = 0L;
        continue;
        this.mep.auM = this.mep.meg;
        localg = this.mep;
        this.mep.mef = 0L;
        localg.cfq = 0L;
        localg = this.mep;
        this.mep.mei = 0L;
        localg.meh = 0L;
        continue;
        this.mep.auM = this.mep.meg;
        localg = this.mep;
        this.mep.mef = 0L;
        localg.cfq = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.s.j
 * JD-Core Version:    0.7.0.1
 */