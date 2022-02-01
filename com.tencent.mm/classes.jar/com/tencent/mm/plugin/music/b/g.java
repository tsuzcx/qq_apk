package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;

public abstract class g
  implements d
{
  protected c wxQ = null;
  bd wxX;
  protected boolean wxY;
  protected d.a wxZ;
  
  public final void Lv(int paramInt)
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    w localw = new w();
    localw.dlG.action = 4;
    localw.dlG.state = "error";
    localw.dlG.errCode = e.Mf(paramInt);
    localw.dlG.errMsg = e.uF(paramInt);
    localw.dlG.ddg = dva();
    localw.dlG.appId = getAppId();
    a.IvT.a(localw, Looper.getMainLooper());
    if (this.wxQ != null) {
      this.wxQ.onError(dva());
    }
  }
  
  public final void a(c paramc)
  {
    this.wxQ = paramc;
  }
  
  public final boolean aKa()
  {
    return false;
  }
  
  protected final void duW()
  {
    try
    {
      if (this.wxX != null)
      {
        this.wxX.end();
        this.wxX.fpi();
        this.wxX = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void duX() {}
  
  public boolean duY()
  {
    return false;
  }
  
  public final com.tencent.mm.ay.c duZ()
  {
    return null;
  }
  
  public abstract String dva();
  
  public final void dvb()
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    w localw = new w();
    localw.dlG.action = 7;
    localw.dlG.state = "canplay";
    localw.dlG.duration = getDuration();
    localw.dlG.ddg = dva();
    localw.dlG.appId = getAppId();
    a.IvT.a(localw, Looper.getMainLooper());
  }
  
  public final void dvc()
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(aJZ()) });
    w localw = new w();
    localw.dlG.action = 0;
    localw.dlG.state = "play";
    localw.dlG.ddg = dva();
    localw.dlG.appId = getAppId();
    a.IvT.a(localw, Looper.getMainLooper());
    if (this.wxQ != null) {
      this.wxQ.onStart(dva());
    }
  }
  
  public final void dvd()
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    w localw = new w();
    localw.dlG.action = 1;
    localw.dlG.state = "play";
    localw.dlG.ddg = dva();
    localw.dlG.appId = getAppId();
    a.IvT.a(localw, Looper.getMainLooper());
    if (this.wxQ != null) {
      this.wxQ.onStart(dva());
    }
  }
  
  public final void dve()
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    w localw = new w();
    localw.dlG.action = 2;
    localw.dlG.state = "pause";
    localw.dlG.ddg = dva();
    localw.dlG.appId = getAppId();
    a.IvT.a(localw, Looper.getMainLooper());
    if (this.wxQ != null) {
      this.wxQ.asW(dva());
    }
  }
  
  public final void dvf()
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    w localw = new w();
    localw.dlG.action = 3;
    localw.dlG.state = "stop";
    localw.dlG.ddg = dva();
    localw.dlG.appId = getAppId();
    a.IvT.a(localw, Looper.getMainLooper());
    if (this.wxQ != null) {
      this.wxQ.agU(dva());
    }
  }
  
  public final void dvg()
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    w localw = new w();
    localw.dlG.action = 6;
    localw.dlG.state = "seeked";
    localw.dlG.ddg = dva();
    localw.dlG.appId = getAppId();
    a.IvT.a(localw, Looper.getMainLooper());
  }
  
  public final void dvh()
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    w localw = new w();
    localw.dlG.action = 5;
    localw.dlG.state = "ended";
    localw.dlG.ddg = dva();
    localw.dlG.appId = getAppId();
    a.IvT.a(localw, Looper.getMainLooper());
    if (this.wxQ != null) {
      this.wxQ.gi(dva());
    }
  }
  
  public final void dvi()
  {
    ae.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    Lv(-1);
  }
  
  public abstract String getAppId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g
 * JD-Core Version:    0.7.0.1
 */