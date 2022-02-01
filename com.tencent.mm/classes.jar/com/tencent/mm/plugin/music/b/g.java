package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;

public abstract class g
  implements d
{
  protected c tUh = null;
  bc tUo;
  protected boolean tUp;
  protected d.a tUq;
  
  public final void Hp(int paramInt)
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    v localv = new v();
    localv.dbN.action = 4;
    localv.dbN.state = "error";
    localv.dbN.errCode = e.HZ(paramInt);
    localv.dbN.errMsg = e.te(paramInt);
    localv.dbN.cTr = cTR();
    localv.dbN.appId = getAppId();
    a.ESL.a(localv, Looper.getMainLooper());
    if (this.tUh != null) {
      this.tUh.onError(cTR());
    }
  }
  
  public final void a(c paramc)
  {
    this.tUh = paramc;
  }
  
  public final void a(d.a parama)
  {
    this.tUq = parama;
  }
  
  public final boolean azG()
  {
    return false;
  }
  
  protected final void cTN()
  {
    try
    {
      if (this.tUo != null)
      {
        this.tUo.end();
        this.tUo.eGl();
        this.tUo = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cTO() {}
  
  public boolean cTP()
  {
    return false;
  }
  
  public final com.tencent.mm.az.c cTQ()
  {
    return null;
  }
  
  public abstract String cTR();
  
  public final void cTS()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    v localv = new v();
    localv.dbN.action = 7;
    localv.dbN.state = "canplay";
    localv.dbN.duration = getDuration();
    localv.dbN.cTr = cTR();
    localv.dbN.appId = getAppId();
    a.ESL.a(localv, Looper.getMainLooper());
  }
  
  public final void cTT()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(azF()) });
    v localv = new v();
    localv.dbN.action = 0;
    localv.dbN.state = "play";
    localv.dbN.cTr = cTR();
    localv.dbN.appId = getAppId();
    a.ESL.a(localv, Looper.getMainLooper());
    if (this.tUh != null) {
      this.tUh.onStart(cTR());
    }
  }
  
  public final void cTU()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    v localv = new v();
    localv.dbN.action = 1;
    localv.dbN.state = "play";
    localv.dbN.cTr = cTR();
    localv.dbN.appId = getAppId();
    a.ESL.a(localv, Looper.getMainLooper());
    if (this.tUh != null) {
      this.tUh.onStart(cTR());
    }
  }
  
  public final void cTV()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    v localv = new v();
    localv.dbN.action = 2;
    localv.dbN.state = "pause";
    localv.dbN.cTr = cTR();
    localv.dbN.appId = getAppId();
    a.ESL.a(localv, Looper.getMainLooper());
    if (this.tUh != null) {
      this.tUh.ahP(cTR());
    }
  }
  
  public final void cTW()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    v localv = new v();
    localv.dbN.action = 3;
    localv.dbN.state = "stop";
    localv.dbN.cTr = cTR();
    localv.dbN.appId = getAppId();
    a.ESL.a(localv, Looper.getMainLooper());
    if (this.tUh != null) {
      this.tUh.XM(cTR());
    }
  }
  
  public final void cTX()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    v localv = new v();
    localv.dbN.action = 6;
    localv.dbN.state = "seeked";
    localv.dbN.cTr = cTR();
    localv.dbN.appId = getAppId();
    a.ESL.a(localv, Looper.getMainLooper());
  }
  
  public final void cTY()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    v localv = new v();
    localv.dbN.action = 5;
    localv.dbN.state = "ended";
    localv.dbN.cTr = cTR();
    localv.dbN.appId = getAppId();
    a.ESL.a(localv, Looper.getMainLooper());
    if (this.tUh != null) {
      this.tUh.fr(cTR());
    }
  }
  
  public final void cTZ()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    Hp(-1);
  }
  
  public abstract String getAppId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g
 * JD-Core Version:    0.7.0.1
 */