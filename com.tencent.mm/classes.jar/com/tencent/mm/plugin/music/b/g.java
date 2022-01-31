package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ax;

public abstract class g
  implements d
{
  protected c oXb = null;
  ax oXi;
  protected boolean oXj;
  protected d.a oXk;
  
  public final void a(c paramc)
  {
    this.oXb = paramc;
  }
  
  public final void a(d.a parama)
  {
    this.oXk = parama;
  }
  
  public final boolean aix()
  {
    return false;
  }
  
  protected final void bUl()
  {
    try
    {
      if (this.oXi != null)
      {
        this.oXi.end();
        this.oXi.dtv();
        this.oXi = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bUm() {}
  
  public boolean bUn()
  {
    return false;
  }
  
  public final com.tencent.mm.aw.c bUo()
  {
    return null;
  }
  
  public abstract String bUp();
  
  public final void bUq()
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    t localt = new t();
    localt.cmZ.action = 7;
    localt.cmZ.state = "canplay";
    localt.cmZ.duration = getDuration();
    localt.cmZ.ceu = bUp();
    localt.cmZ.appId = getAppId();
    a.ymk.a(localt, Looper.getMainLooper());
  }
  
  public final void bUr()
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(aiw()) });
    t localt = new t();
    localt.cmZ.action = 0;
    localt.cmZ.state = "play";
    localt.cmZ.ceu = bUp();
    localt.cmZ.appId = getAppId();
    a.ymk.a(localt, Looper.getMainLooper());
    if (this.oXb != null) {
      this.oXb.onStart(bUp());
    }
  }
  
  public final void bUs()
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    t localt = new t();
    localt.cmZ.action = 1;
    localt.cmZ.state = "play";
    localt.cmZ.ceu = bUp();
    localt.cmZ.appId = getAppId();
    a.ymk.a(localt, Looper.getMainLooper());
    if (this.oXb != null) {
      this.oXb.onStart(bUp());
    }
  }
  
  public final void bUt()
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    t localt = new t();
    localt.cmZ.action = 2;
    localt.cmZ.state = "pause";
    localt.cmZ.ceu = bUp();
    localt.cmZ.appId = getAppId();
    a.ymk.a(localt, Looper.getMainLooper());
    if (this.oXb != null) {
      this.oXb.UF(bUp());
    }
  }
  
  public final void bUu()
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    t localt = new t();
    localt.cmZ.action = 3;
    localt.cmZ.state = "stop";
    localt.cmZ.ceu = bUp();
    localt.cmZ.appId = getAppId();
    a.ymk.a(localt, Looper.getMainLooper());
    if (this.oXb != null) {
      this.oXb.Ns(bUp());
    }
  }
  
  public final void bUv()
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    t localt = new t();
    localt.cmZ.action = 6;
    localt.cmZ.state = "seeked";
    localt.cmZ.ceu = bUp();
    localt.cmZ.appId = getAppId();
    a.ymk.a(localt, Looper.getMainLooper());
  }
  
  public final void bUw()
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    t localt = new t();
    localt.cmZ.action = 5;
    localt.cmZ.state = "ended";
    localt.cmZ.ceu = bUp();
    localt.cmZ.appId = getAppId();
    a.ymk.a(localt, Looper.getMainLooper());
    if (this.oXb != null) {
      this.oXb.ek(bUp());
    }
  }
  
  public final void bUx()
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    zL(-1);
  }
  
  public abstract String getAppId();
  
  public final void zL(int paramInt)
  {
    ab.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    t localt = new t();
    localt.cmZ.action = 4;
    localt.cmZ.state = "error";
    localt.cmZ.errCode = e.Aw(paramInt);
    localt.cmZ.errMsg = e.oP(paramInt);
    localt.cmZ.ceu = bUp();
    localt.cmZ.appId = getAppId();
    a.ymk.a(localt, Looper.getMainLooper());
    if (this.oXb != null) {
      this.oXb.onError(bUp());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g
 * JD-Core Version:    0.7.0.1
 */