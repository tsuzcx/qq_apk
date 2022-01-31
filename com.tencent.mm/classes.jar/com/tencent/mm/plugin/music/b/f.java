package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.mm.av.c;
import com.tencent.mm.h.a.t;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.y;

public abstract class f
  implements d
{
  protected b mxh = null;
  at mxl;
  protected boolean mxm;
  protected d.a mxn;
  
  public final void a(b paramb)
  {
    this.mxh = paramb;
  }
  
  public final void a(d.a parama)
  {
    this.mxn = parama;
  }
  
  public final void bmi() {}
  
  public final boolean bmj()
  {
    return false;
  }
  
  public boolean bmk()
  {
    return false;
  }
  
  public final c bml()
  {
    return null;
  }
  
  public abstract String bmm();
  
  public final void bmn()
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    t localt = new t();
    localt.bFS.action = 7;
    localt.bFS.state = "canplay";
    localt.bFS.duration = getDuration();
    localt.bFS.bFM = bmm();
    localt.bFS.appId = getAppId();
    a.udP.a(localt, Looper.getMainLooper());
  }
  
  public final void bmo()
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(Pu()) });
    t localt = new t();
    localt.bFS.action = 0;
    localt.bFS.state = "play";
    localt.bFS.bFM = bmm();
    localt.bFS.appId = getAppId();
    a.udP.a(localt, Looper.getMainLooper());
    if (this.mxh != null) {
      this.mxh.onStart(bmm());
    }
  }
  
  public final void bmp()
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    t localt = new t();
    localt.bFS.action = 1;
    localt.bFS.state = "play";
    localt.bFS.bFM = bmm();
    localt.bFS.appId = getAppId();
    a.udP.a(localt, Looper.getMainLooper());
    if (this.mxh != null) {
      this.mxh.onStart(bmm());
    }
  }
  
  public final void bmq()
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    t localt = new t();
    localt.bFS.action = 2;
    localt.bFS.state = "pause";
    localt.bFS.bFM = bmm();
    localt.bFS.appId = getAppId();
    a.udP.a(localt, Looper.getMainLooper());
    if (this.mxh != null) {
      this.mxh.IP(bmm());
    }
  }
  
  public final void bmr()
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    t localt = new t();
    localt.bFS.action = 3;
    localt.bFS.state = "stop";
    localt.bFS.bFM = bmm();
    localt.bFS.appId = getAppId();
    a.udP.a(localt, Looper.getMainLooper());
    if (this.mxh != null) {
      this.mxh.Cr(bmm());
    }
  }
  
  public final void bms()
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    t localt = new t();
    localt.bFS.action = 6;
    localt.bFS.state = "seeked";
    localt.bFS.bFM = bmm();
    localt.bFS.appId = getAppId();
    a.udP.a(localt, Looper.getMainLooper());
  }
  
  public final void bmt()
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    t localt = new t();
    localt.bFS.action = 5;
    localt.bFS.state = "ended";
    localt.bFS.bFM = bmm();
    localt.bFS.appId = getAppId();
    a.udP.a(localt, Looper.getMainLooper());
    if (this.mxh != null) {
      this.mxh.IQ(bmm());
    }
  }
  
  public final void bmu()
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    uv(-1);
  }
  
  public abstract String getAppId();
  
  public final void uv(int paramInt)
  {
    y.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    t localt = new t();
    localt.bFS.action = 4;
    localt.bFS.state = "error";
    localt.bFS.errCode = e.uV(paramInt);
    localt.bFS.aox = e.uW(paramInt);
    localt.bFS.bFM = bmm();
    localt.bFS.appId = getAppId();
    a.udP.a(localt, Looper.getMainLooper());
    if (this.mxh != null) {
      this.mxh.onError(bmm());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f
 * JD-Core Version:    0.7.0.1
 */