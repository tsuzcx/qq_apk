package com.tencent.mm.plugin.music.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends a
{
  boolean oXo;
  com.tencent.mm.aw.e oYI;
  public boolean oYV;
  com.tencent.mm.plugin.music.f.a.b paG;
  boolean paH;
  private com.tencent.mm.aw.c paI;
  b.b paJ;
  com.tencent.mm.plugin.music.c.b pao;
  
  public d()
  {
    AppMethodBeat.i(137585);
    this.paJ = new d.2(this);
    this.oYV = false;
    AppMethodBeat.o(137585);
  }
  
  private void VF(String paramString)
  {
    AppMethodBeat.i(137600);
    if (this.paA != null) {
      this.paA.a(this.oYI, paramString);
    }
    AppMethodBeat.o(137600);
  }
  
  private int getDownloadPercent()
  {
    AppMethodBeat.i(137597);
    if (this.pao != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.pao;
      int i;
      if (localb.muY)
      {
        ab.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.oYC.oYz), Long.valueOf(localb.oYC.oYx) });
        if (localb.oYC.oYz != 0L) {
          i = (int)(localb.oYC.oYx * 100L / localb.oYC.oYz);
        }
      }
      while (i > 0)
      {
        AppMethodBeat.o(137597);
        return i;
        i = 0;
        continue;
        ab.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.oYC.oYw), Long.valueOf(localb.oYC.oYv) });
        if (localb.oYC.oYw != 0L) {
          i = (int)(localb.oYC.oYv * 100L / localb.oYC.oYw);
        } else {
          i = 0;
        }
      }
      AppMethodBeat.o(137597);
      return 0;
    }
    AppMethodBeat.o(137597);
    return 0;
  }
  
  public final boolean aiw()
  {
    AppMethodBeat.i(137593);
    if (this.paG != null) {
      try
      {
        boolean bool = this.paG.isPlaying();
        AppMethodBeat.o(137593);
        return bool;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(137593);
        return false;
      }
    }
    AppMethodBeat.o(137593);
    return false;
  }
  
  public final boolean aix()
  {
    return (this.oXo) && (this.oYV);
  }
  
  public final boolean aiy()
  {
    return this.oXo;
  }
  
  final void b(com.tencent.mm.aw.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(137588);
    if (this.paG == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.iU(15))) {
        break label71;
      }
      ab.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.paG = new c();; this.paG = new b())
    {
      this.paG.J(parame);
      this.paG.a(new d.1(this));
      AppMethodBeat.o(137588);
      return;
      label71:
      ab.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
    }
  }
  
  public final void bUA()
  {
    AppMethodBeat.i(137590);
    ab.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.bVJ().bUj();
    AppMethodBeat.o(137590);
  }
  
  public final int bUH()
  {
    AppMethodBeat.i(137595);
    if (this.paG != null)
    {
      int i = this.paG.bWc();
      AppMethodBeat.o(137595);
      return i;
    }
    AppMethodBeat.o(137595);
    return -1;
  }
  
  public final void bUm()
  {
    AppMethodBeat.i(137591);
    this.oYV = true;
    ab.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.paG != null) && (this.paG.isPlaying()))
      {
        this.paG.pause();
        C(this.oYI);
      }
      AppMethodBeat.o(137591);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "passivePause", new Object[0]);
      AppMethodBeat.o(137591);
    }
  }
  
  public final boolean bUn()
  {
    return false;
  }
  
  public final com.tencent.mm.aw.c bUo()
  {
    AppMethodBeat.i(137599);
    int k = getDuration();
    int m = bUH();
    int i;
    int j;
    if (aiw())
    {
      i = 1;
      ab.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[] { Integer.valueOf(i) });
      j = getDownloadPercent();
      if (k <= 0) {
        break label165;
      }
    }
    for (;;)
    {
      if (this.paI != null) {
        this.paI.t(k, m, i, j);
      }
      for (;;)
      {
        this.paI.cAe = false;
        this.paI.fKg = bWa();
        com.tencent.mm.aw.c localc = this.paI;
        AppMethodBeat.o(137599);
        return localc;
        if ((this.oXo) && ((this.paH) || (this.oXj))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label141;
          }
          i = 0;
          break;
        }
        label141:
        i = 2;
        break;
        this.paI = new com.tencent.mm.aw.c(k, m, i, j);
      }
      label165:
      j = 0;
    }
  }
  
  protected final void bVk()
  {
    AppMethodBeat.i(137587);
    this.paA = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.d.class));
    this.paB = k.bVH().oZe;
    AppMethodBeat.o(137587);
  }
  
  public final void f(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(137586);
    super.f(parame);
    ab.i("MicroMsg.Music.MusicPlayer", "init and start download");
    stopPlay();
    if (parame == null)
    {
      ab.i("MicroMsg.Music.MusicPlayer", "music is null");
      AppMethodBeat.o(137586);
      return;
    }
    this.pao = new com.tencent.mm.plugin.music.c.b(parame, com.tencent.mm.plugin.music.cache.e.Vh(parame.fKj));
    this.pao.oYG = this.paJ;
    if (this.paA != null)
    {
      this.paA.s(parame);
      ab.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.paA.bVv();
      this.paA.a(this.pao);
    }
    this.oYI = parame;
    b(parame, false);
    ab.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { parame.fKp, parame.playUrl });
    this.pao.start();
    bVZ();
    AppMethodBeat.o(137586);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137596);
    if (this.paG != null)
    {
      int i = this.paG.getDuration();
      AppMethodBeat.o(137596);
      return i;
    }
    AppMethodBeat.o(137596);
    return -1;
  }
  
  public final boolean lN(int paramInt)
  {
    AppMethodBeat.i(137598);
    ab.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = getDuration();
      int j = getDownloadPercent();
      if ((i < 0) || (paramInt > i))
      {
        ab.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
        stopPlay();
        AppMethodBeat.o(137598);
        return false;
      }
      int k = (int)(j / 100.0D * i);
      i = paramInt;
      if (j != 100)
      {
        i = paramInt;
        if (paramInt > k)
        {
          i = k - 2000;
          ab.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[] { Integer.valueOf(i) });
        }
      }
      if ((this.paG != null) && (i >= 0))
      {
        this.paG.seek(i);
        E(this.oYI);
        AppMethodBeat.o(137598);
        return true;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "seekTo", new Object[0]);
      AppMethodBeat.o(137598);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137589);
    this.oYV = false;
    ab.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.paG != null) && (this.paG.isPlaying()))
      {
        this.paG.pause();
        this.paH = true;
        C(this.oYI);
      }
      AppMethodBeat.o(137589);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "pause", new Object[0]);
      AppMethodBeat.o(137589);
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137592);
    try
    {
      if ((this.paG != null) && (!this.paG.isPlaying()))
      {
        ab.i("MicroMsg.Music.MusicPlayer", "resume");
        if (k.bVJ().requestFocus())
        {
          this.paG.play();
          B(this.oYI);
          AppMethodBeat.o(137592);
          return;
        }
        ab.e("MicroMsg.Music.MusicPlayer", "request focus error");
        AppMethodBeat.o(137592);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "resume", new Object[0]);
      AppMethodBeat.o(137592);
      return;
    }
    ab.i("MicroMsg.Music.MusicPlayer", "music is playing");
    AppMethodBeat.o(137592);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137594);
    ab.i("MicroMsg.Music.MusicPlayer", "stopPlay");
    if ((this.paG != null) && ((this.paG instanceof c))) {
      VF(this.paG.bWd());
    }
    try
    {
      if (this.pao != null)
      {
        this.pao.isStop = true;
        this.pao = null;
      }
      if (this.paG != null)
      {
        this.paG.stop();
        this.paG = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    k.bVJ().bUj();
    this.oXo = false;
    this.oYV = false;
    AppMethodBeat.o(137594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d
 * JD-Core Version:    0.7.0.1
 */