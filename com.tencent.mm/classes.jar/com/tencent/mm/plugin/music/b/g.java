package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
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
  protected c wil = null;
  bc wis;
  protected boolean wit;
  protected d.a wiu;
  
  public final void KQ(int paramInt)
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    w localw = new w();
    localw.dkE.action = 4;
    localw.dkE.state = "error";
    localw.dkE.errCode = e.LA(paramInt);
    localw.dkE.errMsg = e.uz(paramInt);
    localw.dkE.dce = drM();
    localw.dkE.appId = getAppId();
    a.IbL.a(localw, Looper.getMainLooper());
    if (this.wil != null) {
      this.wil.onError(drM());
    }
  }
  
  public final void a(c paramc)
  {
    this.wil = paramc;
  }
  
  public final boolean aJH()
  {
    return false;
  }
  
  protected final void drI()
  {
    try
    {
      if (this.wis != null)
      {
        this.wis.end();
        this.wis.fln();
        this.wis = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void drJ() {}
  
  public boolean drK()
  {
    return false;
  }
  
  public final com.tencent.mm.az.c drL()
  {
    return null;
  }
  
  public abstract String drM();
  
  public final void drN()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    w localw = new w();
    localw.dkE.action = 7;
    localw.dkE.state = "canplay";
    localw.dkE.duration = getDuration();
    localw.dkE.dce = drM();
    localw.dkE.appId = getAppId();
    a.IbL.a(localw, Looper.getMainLooper());
  }
  
  public final void drO()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(aJG()) });
    w localw = new w();
    localw.dkE.action = 0;
    localw.dkE.state = "play";
    localw.dkE.dce = drM();
    localw.dkE.appId = getAppId();
    a.IbL.a(localw, Looper.getMainLooper());
    if (this.wil != null) {
      this.wil.onStart(drM());
    }
  }
  
  public final void drP()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    w localw = new w();
    localw.dkE.action = 1;
    localw.dkE.state = "play";
    localw.dkE.dce = drM();
    localw.dkE.appId = getAppId();
    a.IbL.a(localw, Looper.getMainLooper());
    if (this.wil != null) {
      this.wil.onStart(drM());
    }
  }
  
  public final void drQ()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    w localw = new w();
    localw.dkE.action = 2;
    localw.dkE.state = "pause";
    localw.dkE.dce = drM();
    localw.dkE.appId = getAppId();
    a.IbL.a(localw, Looper.getMainLooper());
    if (this.wil != null) {
      this.wil.arJ(drM());
    }
  }
  
  public final void drR()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    w localw = new w();
    localw.dkE.action = 3;
    localw.dkE.state = "stop";
    localw.dkE.dce = drM();
    localw.dkE.appId = getAppId();
    a.IbL.a(localw, Looper.getMainLooper());
    if (this.wil != null) {
      this.wil.afY(drM());
    }
  }
  
  public final void drS()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    w localw = new w();
    localw.dkE.action = 6;
    localw.dkE.state = "seeked";
    localw.dkE.dce = drM();
    localw.dkE.appId = getAppId();
    a.IbL.a(localw, Looper.getMainLooper());
  }
  
  public final void drT()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    w localw = new w();
    localw.dkE.action = 5;
    localw.dkE.state = "ended";
    localw.dkE.dce = drM();
    localw.dkE.appId = getAppId();
    a.IbL.a(localw, Looper.getMainLooper());
    if (this.wil != null) {
      this.wil.gc(drM());
    }
  }
  
  public final void drU()
  {
    ad.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    KQ(-1);
  }
  
  public abstract String getAppId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g
 * JD-Core Version:    0.7.0.1
 */