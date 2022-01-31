package com.tencent.mm.plugin.music.f;

import android.net.Uri;
import com.tencent.mm.av.c;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;

public final class e
  extends a
{
  int aRY = 0;
  AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
  e.a mAK;
  private String mAL;
  private PlayerListenerCallback mxA = new e.1(this);
  public CommonPlayer mxp;
  boolean mxr;
  private IMediaHTTPService mxu;
  String mxv = "";
  private long mxx = 0L;
  boolean mxy = false;
  com.tencent.mm.av.e myB;
  private c myC;
  public boolean myO = false;
  int startTime = 0;
  
  public e()
  {
    com.tencent.mm.plugin.music.f.a.a.bnK();
  }
  
  private boolean bmy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mxp != null)
    {
      bool1 = bool2;
      if (this.mxp.getPlayerState() == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean Pu()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mxp != null)
    {
      bool1 = bool2;
      if (this.mxp.getPlayerState() == 4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean Pv()
  {
    return (this.mxr) && (!bmy());
  }
  
  public final int bmA()
  {
    if (this.mxp != null) {
      return (int)this.mxp.getCurrentPosition();
    }
    return -1;
  }
  
  public final void bmC()
  {
    com.tencent.mm.av.e locale = k.bnl().bmW();
    if (locale == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while ((!locale.e(this.myB)) || (this.mxp == null) || (!Pu()));
      i = (int)this.mxp.getCurrentPosition();
      j = this.mxp.getDuration();
    } while ((i <= 0) || (j <= 0) || (this.mxn == null));
    this.mxn.cy(i, j);
  }
  
  protected final void bmO()
  {
    this.mAu = ((d)com.tencent.mm.plugin.music.f.c.b.Q(d.class));
    this.mAv = k.bnl().myY;
  }
  
  public final void bmi()
  {
    this.myO = true;
    y.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.mxp != null) && (Pu())) {}
    try
    {
      this.mxp.pause();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
      d(this.myB, 503);
      e(this.myB, 503);
    }
  }
  
  public final boolean bmj()
  {
    return (this.mxr) && (this.myO);
  }
  
  public final boolean bmk()
  {
    return true;
  }
  
  public final c bml()
  {
    int m = 0;
    int k = 0;
    int n = getDuration();
    int i1 = bmA();
    boolean bool = Pu();
    if (this.mxp != null) {}
    for (int j = this.mxp.getBufferedPercentage();; j = 0)
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
      if (this.myC != null)
      {
        c localc = this.myC;
        i = k;
        if (bool) {
          i = 1;
        }
        localc.l(n, i1, i, j);
      }
      for (;;)
      {
        this.myC.bSC = true;
        this.myC.euu = this.mAt;
        return this.myC;
        i = m;
        if (bool) {
          i = 1;
        }
        this.myC = new c(n, i1, i, j);
      }
    }
  }
  
  public final void bmw()
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.bnn().bmh();
  }
  
  final void e(com.tencent.mm.av.e parame, int paramInt)
  {
    if (this.mAu != null) {
      this.mAu.b(parame, paramInt);
    }
  }
  
  public final void f(com.tencent.mm.av.e parame)
  {
    super.f(parame);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.mxx;
    if ((this.myB != null) && (this.myB.e(parame)) && (l2 <= 3000L))
    {
      this.myB = parame;
      y.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.mxv, Long.valueOf(l2) });
      return;
    }
    if (parame == null)
    {
      y.e("MicroMsg.Music.QQMusicPlayer", "music is null");
      return;
    }
    if (this.mAu != null) {
      this.mAu.s(parame);
    }
    this.mxx = l1;
    this.myB = parame;
    y.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(parame.startTime) });
    if ((this.mxp != null) && (Pu())) {
      this.mxp.stop();
    }
    this.aRY = 0;
    this.startTime = parame.startTime;
    this.audioType = null;
    this.mxy = false;
    y.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    this.mxv = this.myB.playUrl;
    this.mAL = this.myB.euJ;
    y.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.mxv, this.mAL });
    y.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.myB.euD });
    if ((!bk.bl(this.mxv)) && (bk.bl(this.mAL)))
    {
      g.Jl(this.mxv);
      g.ca(this.mxv, 0);
      g.cb(this.mxv, 0);
    }
    if (!bk.bl(this.mAL))
    {
      y.i("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.mAL });
      if (this.mxp == null) {
        this.mxp = new CommonPlayer(this.mxA);
      }
      this.mxp.reset();
      if (this.mAL.startsWith("file://")) {
        this.mAL = this.mAL.substring(7);
      }
    }
    for (;;)
    {
      try
      {
        this.mxp.setDataSource(this.mAL);
        this.mxp.prepare();
        bnC();
        return;
      }
      catch (Exception parame)
      {
        y.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + parame.getMessage());
        y.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", parame, "initPlayer", new Object[0]);
        d(this.myB, 501);
        e(this.myB, 501);
        continue;
      }
      try
      {
        parame = new URL(this.mxv);
        if (parame == null)
        {
          y.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
          d(this.myB, 500);
          e(this.myB, 500);
        }
      }
      catch (Exception parame)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", parame, "initPlayer", new Object[0]);
          y.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + parame.getMessage());
          parame = null;
        }
        if (this.mxp == null) {
          this.mxp = new CommonPlayer(this.mxA);
        }
        this.mxp.reset();
        if (this.mxu == null) {
          this.mxu = new com.tencent.mm.plugin.music.g.a.b();
        }
        try
        {
          this.mxp.setDataSource(this.mxu, Uri.parse(parame.toString()));
          this.mxp.prepare();
        }
        catch (Exception parame)
        {
          y.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + parame.getMessage());
          y.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", parame, "initPlayer", new Object[0]);
          d(this.myB, 501);
          e(this.myB, 501);
        }
      }
    }
  }
  
  public final int getDuration()
  {
    if (this.mxp != null) {
      return this.mxp.getDuration();
    }
    return -1;
  }
  
  public final boolean iV(int paramInt)
  {
    boolean bool = true;
    int i = getDuration();
    y.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      y.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      bool = false;
    }
    while (this.mxp == null) {
      return bool;
    }
    F(this.myB);
    this.mxp.seekTo(paramInt);
    return true;
  }
  
  public final void pause()
  {
    this.myO = false;
    y.i("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.mxp != null) && (Pu())) {}
    try
    {
      this.mxp.pause();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
      d(this.myB, 503);
      e(this.myB, 503);
    }
  }
  
  public final void resume()
  {
    this.aRY = 0;
    boolean bool1 = bmy();
    boolean bool2 = Pu();
    y.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((this.mxp == null) || (bool1) || (bool2) || (k.bnn().requestFocus())) {}
    for (;;)
    {
      try
      {
        this.mxp.start();
        this.mxr = true;
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
        d(this.myB, 502);
        e(this.myB, 502);
        continue;
      }
      y.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    y.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
    try
    {
      if (this.mxp != null) {
        this.mxp.stop();
      }
      if (this.mAK != null)
      {
        this.mAK.isStop = true;
        this.mAK = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.myB, 504);
        e(this.myB, 504);
      }
    }
    k.bnn().bmh();
    this.mxr = false;
    this.myO = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.e
 * JD-Core Version:    0.7.0.1
 */