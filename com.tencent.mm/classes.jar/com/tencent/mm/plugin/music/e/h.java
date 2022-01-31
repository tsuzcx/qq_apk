package com.tencent.mm.plugin.music.e;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.v;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class h
  implements c
{
  private com.tencent.mm.plugin.music.f.d myT = new com.tencent.mm.plugin.music.f.d();
  private com.tencent.mm.plugin.music.f.e myU = new com.tencent.mm.plugin.music.f.e();
  private com.tencent.mm.plugin.music.d.a myV = new com.tencent.mm.plugin.music.d.a();
  private Runnable myW = new h.1(this);
  
  private void bnj()
  {
    if (this.myT.Pu()) {
      this.myT.stopPlay();
    }
    if (this.myU.Pu()) {
      this.myU.stopPlay();
    }
    if (this.myV.Pu()) {
      this.myV.stopPlay();
    }
  }
  
  public static void bnk()
  {
    y.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    jy localjy = new jy();
    localjy.bSA.action = 10;
    localjy.bSA.state = "preempted";
    localjy.bSA.appId = "not from app brand appid";
    localjy.bSA.bSC = true;
    com.tencent.mm.sdk.b.a.udP.a(localjy, Looper.getMainLooper());
  }
  
  public void Ps()
  {
    this.myT.stopPlay();
    if (this.myU != null) {
      this.myU.stopPlay();
    }
    if (this.myV != null) {
      this.myV.stopPlay();
    }
    ai.S(this.myW);
  }
  
  public com.tencent.mm.av.e bmW()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.music.f.a.d bmY()
  {
    com.tencent.mm.av.e locale = bmW();
    if (com.tencent.mm.plugin.music.h.c.L(locale)) {
      return this.myV;
    }
    if ((locale != null) && (com.tencent.mm.plugin.music.h.c.vb(locale.euv))) {
      return this.myU;
    }
    return this.myT;
  }
  
  public void finish()
  {
    Ps();
    release();
  }
  
  public void hR(boolean paramBoolean)
  {
    if (this.myT.Pu()) {
      this.myT.bSD = paramBoolean;
    }
    if (this.myU.Pu()) {
      this.myU.bSD = paramBoolean;
    }
    if (this.myV.Pu()) {
      this.myV.bSD = paramBoolean;
    }
  }
  
  public final void q(com.tencent.mm.av.e parame)
  {
    if (com.tencent.mm.plugin.music.h.c.L(parame))
    {
      y.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      bnj();
      this.myV.f(parame);
    }
    for (;;)
    {
      if (parame.euv != 11) {
        bnk();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.vb(parame.euv))
      {
        y.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        bnj();
        this.myU.f(parame);
      }
      else
      {
        y.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        bnj();
        this.myT.f(parame);
      }
    }
  }
  
  public final void r(com.tencent.mm.av.e parame)
  {
    if (com.tencent.mm.plugin.music.h.c.L(parame))
    {
      this.myV.H(parame);
      return;
    }
    if ((parame != null) && (com.tencent.mm.plugin.music.h.c.vb(parame.euv)))
    {
      this.myU.H(parame);
      return;
    }
    this.myT.H(parame);
  }
  
  public void release()
  {
    y.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    Object localObject;
    if (this.myU != null)
    {
      localObject = this.myU;
      y.i("MicroMsg.Music.QQMusicPlayer", "release");
      if (((com.tencent.mm.plugin.music.f.e)localObject).mxp != null)
      {
        ((com.tencent.mm.plugin.music.f.e)localObject).mxp.release();
        ((com.tencent.mm.plugin.music.f.e)localObject).mxp = null;
      }
      ((com.tencent.mm.plugin.music.f.e)localObject).bnD();
    }
    if (this.myV != null)
    {
      localObject = this.myV;
      y.i("MicroMsg.Music.ExoMusicPlayer", "release");
      ((com.tencent.mm.plugin.music.d.a)localObject).gmh.removeMessages(100);
      ((com.tencent.mm.plugin.music.d.a)localObject).bnD();
      if (((com.tencent.mm.plugin.music.d.a)localObject).myE != null)
      {
        ((com.tencent.mm.plugin.music.d.a)localObject).myE.b(((com.tencent.mm.plugin.music.d.a)localObject).myK);
        ((com.tencent.mm.plugin.music.d.a)localObject).myE.ava.remove(localObject);
        ((com.tencent.mm.plugin.music.d.a)localObject).myE.release();
        ((com.tencent.mm.plugin.music.d.a)localObject).myE = null;
      }
      if (((com.tencent.mm.plugin.music.d.a)localObject).myI != null)
      {
        ((com.tencent.mm.plugin.music.d.a)localObject).myI.mF();
        ((com.tencent.mm.plugin.music.d.a)localObject).myI = null;
      }
      ((com.tencent.mm.plugin.music.d.a)localObject).myF = null;
      ((com.tencent.mm.plugin.music.d.a)localObject).myH = null;
    }
    ai.S(this.myW);
  }
  
  public void uM(int paramInt)
  {
    y.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    ai.S(this.myW);
    ai.l(this.myW, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h
 * JD-Core Version:    0.7.0.1
 */