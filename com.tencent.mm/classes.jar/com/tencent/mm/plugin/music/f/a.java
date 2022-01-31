package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.ki.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ax;

public abstract class a
  implements com.tencent.mm.plugin.music.f.a.d
{
  public boolean cAf;
  private ax oXi;
  protected boolean oXj;
  protected d.a oXk;
  protected com.tencent.mm.plugin.music.e.d paA;
  protected com.tencent.mm.plugin.music.e.a paB;
  protected String paz = "";
  
  public final void A(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(aiw()) });
    this.paz = "play";
    ki localki = new ki();
    localki.cAc.action = 0;
    localki.cAc.czW = parame;
    localki.cAc.state = "play";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
    if (this.paB != null) {
      this.paB.k(parame);
    }
  }
  
  public final void B(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.paz = "play";
    ki localki = new ki();
    localki.cAc.action = 1;
    localki.cAc.czW = parame;
    localki.cAc.state = "play";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
    if (this.paB != null) {
      this.paB.l(parame);
    }
  }
  
  public final void C(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.paz = "pause";
    ki localki = new ki();
    localki.cAc.action = 3;
    localki.cAc.czW = parame;
    localki.cAc.state = "pause";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
    if (this.paB != null) {
      this.paB.m(parame);
    }
  }
  
  public final void D(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.paz = "stop";
    ki localki = new ki();
    localki.cAc.action = 2;
    localki.cAc.czW = parame;
    localki.cAc.state = "stop";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    ki.a locala = localki.cAc;
    boolean bool = this.cAf;
    this.cAf = false;
    locala.cAf = bool;
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
    if (this.paB != null) {
      this.paB.n(parame);
    }
  }
  
  public final void E(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.paz = "seeked";
    ki localki = new ki();
    localki.cAc.action = 8;
    localki.cAc.czW = parame;
    localki.cAc.state = "seeked";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
  }
  
  public final void F(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.paz = "seeking";
    ki localki = new ki();
    localki.cAc.action = 12;
    localki.cAc.czW = parame;
    localki.cAc.state = "seeking";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
  }
  
  public final void G(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.paz = "ended";
    ki localki = new ki();
    localki.cAc.action = 7;
    localki.cAc.czW = parame;
    localki.cAc.state = "ended";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
    if (this.paB != null) {
      this.paB.o(parame);
    }
  }
  
  public final void H(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(parame, -1);
  }
  
  public void a(com.tencent.mm.aw.e parame, int paramInt1, int paramInt2)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(parame, -1);
  }
  
  public final void a(d.a parama)
  {
    this.oXk = parama;
  }
  
  protected final void bUl()
  {
    if (this.oXi != null)
    {
      this.oXi.end();
      this.oXi.dtv();
      this.oXi = null;
    }
  }
  
  protected final void bVZ()
  {
    if (this.oXi != null) {
      return;
    }
    if (b.checkSelfPermission(ah.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      ab.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.oXi = new ax();
    this.oXi.hd(ah.getContext());
    this.oXi.a(new a.1(this));
  }
  
  protected abstract void bVk();
  
  protected final String bWa()
  {
    return this.paz;
  }
  
  public final void d(com.tencent.mm.aw.e parame, int paramInt)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.paz = "error";
    ki localki = new ki();
    localki.cAc.action = 4;
    localki.cAc.czW = parame;
    localki.cAc.state = "error";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    localki.cAc.errCode = com.tencent.mm.plugin.music.f.a.e.Aw(paramInt);
    localki.cAc.errMsg = com.tencent.mm.plugin.music.f.a.e.oP(paramInt);
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
    if (this.paB != null) {
      this.paB.a(parame, paramInt);
    }
  }
  
  public void f(com.tencent.mm.aw.e parame)
  {
    bVk();
  }
  
  public final void y(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(aiw()) });
    this.paz = "waiting";
    ki localki = new ki();
    localki.cAc.action = 11;
    localki.cAc.czW = parame;
    localki.cAc.state = "waiting";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
  }
  
  public final void z(com.tencent.mm.aw.e parame)
  {
    ab.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(aiw()) });
    this.paz = "canplay";
    ki localki = new ki();
    localki.cAc.action = 9;
    localki.cAc.czW = parame;
    localki.cAc.state = "canplay";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = bUn();
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */