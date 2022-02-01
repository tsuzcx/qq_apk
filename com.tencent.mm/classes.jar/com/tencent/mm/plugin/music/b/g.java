package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.a;

public abstract class g
  implements d
{
  protected c vcP = null;
  bb vcW;
  protected boolean vcX;
  protected d.a vcY;
  
  public final void EM() {}
  
  public final void Jo(int paramInt)
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    w localw = new w();
    localw.cZm.action = 4;
    localw.cZm.state = "error";
    localw.cZm.errCode = e.JY(paramInt);
    localw.cZm.errMsg = e.tV(paramInt);
    localw.cZm.cQO = dhy();
    localw.cZm.appId = getAppId();
    a.GpY.a(localw, Looper.getMainLooper());
    if (this.vcP != null) {
      this.vcP.onError(dhy());
    }
  }
  
  public final void a(c paramc)
  {
    this.vcP = paramc;
  }
  
  public final boolean aGw()
  {
    return false;
  }
  
  public final void dhA()
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(aGv()) });
    w localw = new w();
    localw.cZm.action = 0;
    localw.cZm.state = "play";
    localw.cZm.cQO = dhy();
    localw.cZm.appId = getAppId();
    a.GpY.a(localw, Looper.getMainLooper());
    if (this.vcP != null) {
      this.vcP.onStart(dhy());
    }
  }
  
  public final void dhB()
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    w localw = new w();
    localw.cZm.action = 1;
    localw.cZm.state = "play";
    localw.cZm.cQO = dhy();
    localw.cZm.appId = getAppId();
    a.GpY.a(localw, Looper.getMainLooper());
    if (this.vcP != null) {
      this.vcP.onStart(dhy());
    }
  }
  
  public final void dhC()
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    w localw = new w();
    localw.cZm.action = 2;
    localw.cZm.state = "pause";
    localw.cZm.cQO = dhy();
    localw.cZm.appId = getAppId();
    a.GpY.a(localw, Looper.getMainLooper());
    if (this.vcP != null) {
      this.vcP.amK(dhy());
    }
  }
  
  public final void dhD()
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    w localw = new w();
    localw.cZm.action = 3;
    localw.cZm.state = "stop";
    localw.cZm.cQO = dhy();
    localw.cZm.appId = getAppId();
    a.GpY.a(localw, Looper.getMainLooper());
    if (this.vcP != null) {
      this.vcP.acj(dhy());
    }
  }
  
  public final void dhE()
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    w localw = new w();
    localw.cZm.action = 6;
    localw.cZm.state = "seeked";
    localw.cZm.cQO = dhy();
    localw.cZm.appId = getAppId();
    a.GpY.a(localw, Looper.getMainLooper());
  }
  
  public final void dhF()
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    w localw = new w();
    localw.cZm.action = 5;
    localw.cZm.state = "ended";
    localw.cZm.cQO = dhy();
    localw.cZm.appId = getAppId();
    a.GpY.a(localw, Looper.getMainLooper());
    if (this.vcP != null) {
      this.vcP.fh(dhy());
    }
  }
  
  public final void dhG()
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    Jo(-1);
  }
  
  protected final void dhv()
  {
    try
    {
      if (this.vcW != null)
      {
        this.vcW.end();
        this.vcW.eVG();
        this.vcW = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean dhw()
  {
    return false;
  }
  
  public final com.tencent.mm.ay.c dhx()
  {
    return null;
  }
  
  public abstract String dhy();
  
  public final void dhz()
  {
    ac.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    w localw = new w();
    localw.cZm.action = 7;
    localw.cZm.state = "canplay";
    localw.cZm.duration = getDuration();
    localw.cZm.cQO = dhy();
    localw.cZm.appId = getAppId();
    a.GpY.a(localw, Looper.getMainLooper());
  }
  
  public abstract String getAppId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g
 * JD-Core Version:    0.7.0.1
 */