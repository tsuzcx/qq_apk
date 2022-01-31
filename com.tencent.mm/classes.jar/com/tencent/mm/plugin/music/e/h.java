package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public abstract class h
  implements c
{
  private com.tencent.mm.plugin.music.f.d oYZ = new com.tencent.mm.plugin.music.f.d();
  private com.tencent.mm.plugin.music.f.e oZa = new com.tencent.mm.plugin.music.f.e();
  private com.tencent.mm.plugin.music.d.a oZb = new com.tencent.mm.plugin.music.d.a();
  private Runnable oZc = new h.1(this);
  
  private void bVF()
  {
    if (this.oYZ.aiw()) {
      this.oYZ.stopPlay();
    }
    if (this.oZa.aiw()) {
      this.oZa.stopPlay();
    }
    if (this.oZb.aiw()) {
      this.oZb.stopPlay();
    }
  }
  
  public static void bVG()
  {
    ab.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    ki localki = new ki();
    localki.cAc.action = 10;
    localki.cAc.state = "preempted";
    localki.cAc.appId = "not from app brand appid";
    localki.cAc.cAe = true;
    com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
  }
  
  public void Ai(int paramInt)
  {
    ab.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    al.ae(this.oZc);
    al.p(this.oZc, paramInt);
  }
  
  public void aiu()
  {
    this.oYZ.stopPlay();
    if (this.oZa != null) {
      this.oZa.stopPlay();
    }
    if (this.oZb != null) {
      this.oZb.stopPlay();
    }
    al.ae(this.oZc);
  }
  
  public com.tencent.mm.aw.e bVs()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.music.f.a.d bVu()
  {
    com.tencent.mm.aw.e locale = bVs();
    if (com.tencent.mm.plugin.music.h.c.M(locale)) {
      return this.oZb;
    }
    if ((locale != null) && (com.tencent.mm.plugin.music.h.c.Az(locale.fKh))) {
      return this.oZa;
    }
    return this.oYZ;
  }
  
  public void finish()
  {
    aiu();
    release();
  }
  
  public void jL(boolean paramBoolean)
  {
    if (this.oYZ.aiw()) {
      this.oYZ.cAf = paramBoolean;
    }
    if (this.oZa.aiw()) {
      this.oZa.cAf = paramBoolean;
    }
    if (this.oZb.aiw()) {
      this.oZb.cAf = paramBoolean;
    }
  }
  
  public final void q(com.tencent.mm.aw.e parame)
  {
    if (com.tencent.mm.plugin.music.h.c.M(parame))
    {
      ab.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      bVF();
      this.oZb.f(parame);
    }
    for (;;)
    {
      if (parame.fKh != 11) {
        bVG();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.Az(parame.fKh))
      {
        ab.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        bVF();
        this.oZa.f(parame);
      }
      else
      {
        ab.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        bVF();
        this.oYZ.f(parame);
      }
    }
  }
  
  public final void r(com.tencent.mm.aw.e parame)
  {
    if (com.tencent.mm.plugin.music.h.c.M(parame))
    {
      this.oZb.H(parame);
      return;
    }
    if ((parame != null) && (com.tencent.mm.plugin.music.h.c.Az(parame.fKh)))
    {
      this.oZa.H(parame);
      return;
    }
    this.oYZ.H(parame);
  }
  
  public void release()
  {
    ab.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    if (this.oZa != null) {
      this.oZa.release();
    }
    if (this.oZb != null) {
      this.oZb.release();
    }
    al.ae(this.oZc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h
 * JD-Core Version:    0.7.0.1
 */