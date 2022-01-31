package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.h.a.jy.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
  implements com.tencent.mm.plugin.music.f.a.d
{
  public boolean bSD;
  public String mAt = "";
  public com.tencent.mm.plugin.music.e.d mAu;
  public com.tencent.mm.plugin.music.e.a mAv;
  private at mxl;
  protected boolean mxm;
  protected d.a mxn;
  
  public final void A(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(Pu()) });
    this.mAt = "play";
    jy localjy = new jy();
    localjy.bSA.action = 0;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "play";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
    if (this.mAv != null) {
      this.mAv.k(parame);
    }
  }
  
  public final void B(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.mAt = "play";
    jy localjy = new jy();
    localjy.bSA.action = 1;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "play";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
    if (this.mAv != null) {
      this.mAv.l(parame);
    }
  }
  
  public final void C(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.mAt = "pause";
    jy localjy = new jy();
    localjy.bSA.action = 3;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "pause";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
    if (this.mAv != null) {
      this.mAv.m(parame);
    }
  }
  
  public final void D(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.mAt = "stop";
    jy localjy = new jy();
    localjy.bSA.action = 2;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "stop";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    jy.a locala = localjy.bSA;
    boolean bool = this.bSD;
    this.bSD = false;
    locala.bSD = bool;
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
    if (this.mAv != null) {
      this.mAv.n(parame);
    }
  }
  
  public final void E(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.mAt = "seeked";
    jy localjy = new jy();
    localjy.bSA.action = 8;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "seeked";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
  }
  
  public final void F(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.mAt = "seeking";
    jy localjy = new jy();
    localjy.bSA.action = 12;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "seeking";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
  }
  
  public final void G(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.mAt = "ended";
    jy localjy = new jy();
    localjy.bSA.action = 7;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "ended";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
    if (this.mAv != null) {
      this.mAv.o(parame);
    }
  }
  
  public final void H(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(parame, -1);
  }
  
  public final void a(d.a parama)
  {
    this.mxn = parama;
  }
  
  public abstract void bmO();
  
  protected final void bnC()
  {
    if (this.mxl != null) {
      return;
    }
    if (b.checkSelfPermission(ae.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      y.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.mxl = new at();
    this.mxl.fN(ae.getContext());
    this.mxl.a(new a.1(this));
  }
  
  public final void bnD()
  {
    if (this.mxl != null)
    {
      this.mxl.end();
      this.mxl.crw();
    }
  }
  
  public final void d(com.tencent.mm.av.e parame, int paramInt)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.mAt = "error";
    jy localjy = new jy();
    localjy.bSA.action = 4;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "error";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    localjy.bSA.errCode = com.tencent.mm.plugin.music.f.a.e.uV(paramInt);
    localjy.bSA.aox = com.tencent.mm.plugin.music.f.a.e.uW(paramInt);
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
    if (this.mAv != null) {
      this.mAv.a(parame, paramInt);
    }
  }
  
  public void f(com.tencent.mm.av.e parame)
  {
    bmO();
  }
  
  public final void y(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(Pu()) });
    this.mAt = "waiting";
    jy localjy = new jy();
    localjy.bSA.action = 11;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "waiting";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
  }
  
  public final void z(com.tencent.mm.av.e parame)
  {
    y.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(Pu()) });
    this.mAt = "canplay";
    jy localjy = new jy();
    localjy.bSA.action = 9;
    localjy.bSA.bSu = parame;
    localjy.bSA.state = "canplay";
    localjy.bSA.duration = getDuration();
    localjy.bSA.bSC = bmk();
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */