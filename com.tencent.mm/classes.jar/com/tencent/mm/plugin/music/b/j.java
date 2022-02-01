package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.mm.bb.c;
import com.tencent.mm.f.a.z;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class j
  implements k, d
{
  protected boolean FOD;
  protected d.a FOE;
  protected f FOs = null;
  
  public final void YP(int paramInt)
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    z localz = new z();
    localz.fvC.action = 4;
    localz.fvC.state = "error";
    localz.fvC.errCode = e.Zx(paramInt);
    localz.fvC.errMsg = e.BW(paramInt);
    localz.fvC.fmF = fdh();
    localz.fvC.appId = getAppId();
    EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
    if (this.FOs != null) {
      this.FOs.onError(fdh());
    }
  }
  
  public final void a(f paramf)
  {
    this.FOs = paramf;
  }
  
  public final boolean bny()
  {
    return false;
  }
  
  public final void fde() {}
  
  public boolean fdf()
  {
    return false;
  }
  
  public final c fdg()
  {
    return null;
  }
  
  public abstract String fdh();
  
  public final void fdi()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    z localz = new z();
    localz.fvC.action = 7;
    localz.fvC.state = "canplay";
    localz.fvC.duration = getDuration();
    localz.fvC.fmF = fdh();
    localz.fvC.appId = getAppId();
    EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
  }
  
  public final void fdj()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(bnx()) });
    z localz = new z();
    localz.fvC.action = 0;
    localz.fvC.state = "play";
    localz.fvC.fmF = fdh();
    localz.fvC.appId = getAppId();
    EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
    if (this.FOs != null) {
      this.FOs.aRh(fdh());
    }
  }
  
  public final void fdk()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    z localz = new z();
    localz.fvC.action = 1;
    localz.fvC.state = "play";
    localz.fvC.fmF = fdh();
    localz.fvC.appId = getAppId();
    EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
    if (this.FOs != null) {
      this.FOs.aRh(fdh());
    }
  }
  
  public final void fdl()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    z localz = new z();
    localz.fvC.action = 2;
    localz.fvC.state = "pause";
    localz.fvC.fmF = fdh();
    localz.fvC.appId = getAppId();
    EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
    if (this.FOs != null) {
      this.FOs.aRi(fdh());
    }
  }
  
  public final void fdm()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    z localz = new z();
    localz.fvC.action = 3;
    localz.fvC.state = "stop";
    localz.fvC.fmF = fdh();
    localz.fvC.appId = getAppId();
    EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
    if (this.FOs != null) {
      this.FOs.azE(fdh());
    }
  }
  
  public final void fdn()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    z localz = new z();
    localz.fvC.action = 6;
    localz.fvC.state = "seeked";
    localz.fvC.fmF = fdh();
    localz.fvC.appId = getAppId();
    EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
  }
  
  public final void fdo()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onCompleteEvent");
    z localz = new z();
    localz.fvC.action = 5;
    localz.fvC.state = "ended";
    localz.fvC.fmF = fdh();
    localz.fvC.appId = getAppId();
    EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
    if (this.FOs != null) {
      this.FOs.hL(fdh());
    }
  }
  
  public final void fdp()
  {
    Log.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    YP(-1);
  }
  
  public abstract String getAppId();
  
  public final void onPhoneCall(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!this.FOD);
      this.FOD = false;
      resume();
      return;
    } while (!bnx());
    this.FOD = true;
    pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.j
 * JD-Core Version:    0.7.0.1
 */