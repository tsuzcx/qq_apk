package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;

public final class e
  extends a
{
  int aZy;
  AudioFormat.AudioType audioType;
  String ceU;
  CommonPlayer oXm;
  boolean oXo;
  private IMediaHTTPService oXr;
  private long oXt;
  private boolean oXu;
  private PlayerListenerCallback oXw;
  com.tencent.mm.aw.e oYI;
  private c oYJ;
  public boolean oYV;
  e.a paO;
  private String paP;
  int startTime;
  
  public e()
  {
    AppMethodBeat.i(137611);
    this.ceU = "";
    this.aZy = 0;
    this.startTime = 0;
    this.oXt = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.oXu = false;
    this.oYV = false;
    this.oXw = new e.1(this);
    com.tencent.mm.plugin.music.f.a.a.bWg();
    AppMethodBeat.o(137611);
  }
  
  private boolean bUB()
  {
    AppMethodBeat.i(137619);
    if (this.oXm != null)
    {
      if (this.oXm.getPlayerState() == 3)
      {
        AppMethodBeat.o(137619);
        return true;
      }
      AppMethodBeat.o(137619);
      return false;
    }
    AppMethodBeat.o(137619);
    return false;
  }
  
  private void e(com.tencent.mm.aw.e parame, int paramInt)
  {
    AppMethodBeat.i(137628);
    if (this.paA != null) {
      this.paA.b(parame, paramInt);
    }
    AppMethodBeat.o(137628);
  }
  
  public final boolean aiw()
  {
    AppMethodBeat.i(137618);
    if (this.oXm != null)
    {
      if (this.oXm.getPlayerState() == 4)
      {
        AppMethodBeat.o(137618);
        return true;
      }
      AppMethodBeat.o(137618);
      return false;
    }
    AppMethodBeat.o(137618);
    return false;
  }
  
  public final boolean aix()
  {
    return (this.oXo) && (this.oYV);
  }
  
  public final boolean aiy()
  {
    AppMethodBeat.i(137620);
    if ((this.oXo) && (!bUB()))
    {
      AppMethodBeat.o(137620);
      return true;
    }
    AppMethodBeat.o(137620);
    return false;
  }
  
  public final void bUA()
  {
    AppMethodBeat.i(137615);
    ab.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.bVJ().bUj();
    AppMethodBeat.o(137615);
  }
  
  public final int bUH()
  {
    AppMethodBeat.i(137622);
    if (this.oXm != null)
    {
      int i = (int)this.oXm.getCurrentPosition();
      AppMethodBeat.o(137622);
      return i;
    }
    AppMethodBeat.o(137622);
    return -1;
  }
  
  public final void bUJ()
  {
    AppMethodBeat.i(137627);
    com.tencent.mm.aw.e locale = k.bVH().bVs();
    if (locale == null)
    {
      AppMethodBeat.o(137627);
      return;
    }
    if ((locale.e(this.oYI)) && (this.oXm != null) && (aiw()))
    {
      int i = (int)this.oXm.getCurrentPosition();
      int j = this.oXm.getDuration();
      if ((i > 0) && (j > 0) && (this.oXk != null)) {
        this.oXk.dW(i, j);
      }
    }
    AppMethodBeat.o(137627);
  }
  
  public final void bUm()
  {
    AppMethodBeat.i(137616);
    this.oYV = true;
    ab.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.oXm != null) && (aiw())) {
      try
      {
        this.oXm.pause();
        AppMethodBeat.o(137616);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        d(this.oYI, 503);
        e(this.oYI, 503);
      }
    }
    AppMethodBeat.o(137616);
  }
  
  public final boolean bUn()
  {
    return true;
  }
  
  public final c bUo()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137625);
    int n = getDuration();
    int i1 = bUH();
    boolean bool = aiw();
    if (this.oXm != null) {}
    for (int j = this.oXm.getBufferedPercentage();; j = 0)
    {
      int i;
      if (j >= 0)
      {
        i = j;
        if (j <= 100) {}
      }
      else
      {
        i = 0;
      }
      j = i;
      if (i < 0) {
        j = 0;
      }
      c localc;
      if (this.oYJ != null)
      {
        localc = this.oYJ;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.t(n, i1, i, j);
      }
      for (;;)
      {
        this.oYJ.cAe = true;
        this.oYJ.fKg = bWa();
        localc = this.oYJ;
        AppMethodBeat.o(137625);
        return localc;
        i = m;
        if (bool) {
          i = 1;
        }
        this.oYJ = new c(n, i1, i, j);
      }
    }
  }
  
  protected final void bVk()
  {
    AppMethodBeat.i(137613);
    this.paA = ((d)com.tencent.mm.plugin.music.f.c.b.am(d.class));
    this.paB = k.bVH().oZe;
    AppMethodBeat.o(137613);
  }
  
  public final void f(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(137612);
    super.f(parame);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.oXt;
    if ((this.oYI != null) && (this.oYI.e(parame)) && (l2 <= 3000L))
    {
      this.oYI = parame;
      ab.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.ceU, Long.valueOf(l2) });
      AppMethodBeat.o(137612);
      return;
    }
    if (parame == null)
    {
      ab.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      AppMethodBeat.o(137612);
      return;
    }
    if (this.paA != null) {
      this.paA.s(parame);
    }
    this.oXt = l1;
    this.oYI = parame;
    ab.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(parame.startTime) });
    if ((this.oXm != null) && (aiw())) {
      this.oXm.stop();
    }
    com.tencent.mm.plugin.music.f.a.a.bWh();
    this.aZy = 0;
    this.startTime = parame.startTime;
    this.audioType = null;
    this.oXu = false;
    ab.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.ceU = this.oYI.playUrl;
    this.paP = this.oYI.fKv;
    ab.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.ceU, this.paP });
    ab.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.oYI.fKp });
    if ((!bo.isNullOrNil(this.ceU)) && (bo.isNullOrNil(this.paP)))
    {
      g.Vi(this.ceU);
      g.cS(this.ceU, 0);
      g.cT(this.ceU, 0);
    }
    if (!bo.isNullOrNil(this.paP))
    {
      ab.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.paP });
      if (this.oXm == null) {
        this.oXm = new CommonPlayer(this.oXw);
      }
      this.oXm.reset();
      if (this.paP.startsWith("file://")) {
        this.paP = this.paP.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.oXm.setDataSource(this.paP);
        this.oXm.prepare();
        bVZ();
        AppMethodBeat.o(137612);
        return;
      }
      catch (Exception parame)
      {
        ab.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + parame.getMessage());
        ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", parame, "initPlayer", new Object[0]);
        d(this.oYI, 501);
        e(this.oYI, 501);
        continue;
      }
      try
      {
        parame = new URL(this.ceU);
        if (parame == null)
        {
          ab.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
          d(this.oYI, 500);
          e(this.oYI, 500);
        }
      }
      catch (Exception parame)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", parame, "initPlayer", new Object[0]);
          ab.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + parame.getMessage());
          parame = null;
        }
        if (this.oXm == null) {
          this.oXm = new CommonPlayer(this.oXw);
        }
        this.oXm.reset();
        if (this.oXr == null) {
          this.oXr = new com.tencent.mm.plugin.music.g.a.b();
        }
        try
        {
          this.oXm.setDataSource(this.oXr, Uri.parse(parame.toString()));
          this.oXm.prepare();
        }
        catch (Exception parame)
        {
          ab.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + parame.getMessage());
          ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", parame, "initPlayer", new Object[0]);
          d(this.oYI, 501);
          e(this.oYI, 501);
        }
      }
    }
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137623);
    if (this.oXm != null)
    {
      int i = this.oXm.getDuration();
      AppMethodBeat.o(137623);
      return i;
    }
    AppMethodBeat.o(137623);
    return -1;
  }
  
  public final boolean lN(int paramInt)
  {
    AppMethodBeat.i(137624);
    int i = getDuration();
    ab.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      ab.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137624);
      return false;
    }
    if (this.oXm != null)
    {
      F(this.oYI);
      this.oXm.seekTo(paramInt);
    }
    AppMethodBeat.o(137624);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137614);
    this.oYV = false;
    ab.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.oXm != null) && (aiw())) {
      try
      {
        this.oXm.pause();
        AppMethodBeat.o(137614);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        d(this.oYI, 503);
        e(this.oYI, 503);
      }
    }
    AppMethodBeat.o(137614);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137626);
    ab.i("MicroMsg.Music.QQMusicPlayer", "release");
    if (this.oXm != null)
    {
      this.oXm.release();
      this.oXm = null;
    }
    bUl();
    AppMethodBeat.o(137626);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137617);
    this.aZy = 0;
    boolean bool1 = bUB();
    boolean bool2 = aiw();
    ab.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((this.oXm == null) || (bool1) || (bool2) || (k.bVJ().requestFocus())) {}
    for (;;)
    {
      try
      {
        this.oXm.start();
        this.oXo = true;
        AppMethodBeat.o(137617);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.oYI, 502);
        e(this.oYI, 502);
        continue;
      }
      ab.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137621);
    ab.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
    try
    {
      if (this.oXm != null) {
        this.oXm.stop();
      }
      if (this.paO != null)
      {
        this.paO.isStop = true;
        this.paO = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.oYI, 504);
        e(this.oYI, 504);
      }
    }
    k.bVJ().bUj();
    this.oXo = false;
    this.oYV = false;
    AppMethodBeat.o(137621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e
 * JD-Core Version:    0.7.0.1
 */