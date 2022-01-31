package com.tencent.mm.plugin.music.b;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.af.d;
import com.tencent.mm.h.a.t;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.h.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;

public final class g
  extends f
{
  int aRY = 0;
  AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
  String bFM = "";
  protected com.tencent.mm.af.b bFO;
  long dEq = 0L;
  boolean eaW = false;
  ah gNQ;
  int jsT = 0;
  private PlayerListenerCallback mxA = new g.1(this);
  com.tencent.mm.plugin.music.b.a.b mxe;
  CommonPlayer mxp;
  private d mxq;
  boolean mxr;
  boolean mxs = false;
  g.a mxt;
  private IMediaHTTPService mxu;
  String mxv = "";
  boolean mxw = false;
  private long mxx = 0L;
  boolean mxy = false;
  long mxz = 0L;
  int startTime = 0;
  
  public g()
  {
    com.tencent.mm.plugin.music.f.a.a.bnK();
    if (android.support.v4.content.b.checkSelfPermission(ae.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
      y.e("MicroMsg.Audio.BaseAudioPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
    }
    for (;;)
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
      this.gNQ = new ah(Looper.myLooper());
      return;
      this.mxl = new at();
      this.mxl.fN(ae.getContext());
      this.mxl.a(new f.1(this));
    }
  }
  
  private void bmv()
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    if ((!TextUtils.isEmpty(this.bFO.filePath)) && (this.bFO.eaV == null))
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.bFO.filePath });
      if (this.mxp == null) {
        this.mxp = new CommonPlayer(this.mxA);
      }
      this.mxp.reset();
      try
      {
        this.mxp.setDataSource(this.bFO.filePath);
        this.mxp.prepare();
        return;
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer exception", new Object[0]);
        uv(501);
        uw(501);
        return;
      }
    }
    if ((!TextUtils.isEmpty(this.bFO.filePath)) && (this.bFO.eaV != null))
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.bFO.filePath });
      if (this.mxp == null) {
        this.mxp = new CommonPlayer(this.mxA);
      }
      this.mxp.reset();
      com.tencent.mm.plugin.music.g.b localb = new com.tencent.mm.plugin.music.g.b(this.bFO.eaV);
      try
      {
        this.mxp.setDataSource(localb);
        this.mxp.prepare();
        return;
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException2.getMessage());
        y.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer", new Object[0]);
        uv(501);
        uw(501);
        return;
      }
    }
    y.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.bFO.ceM });
    this.mxv = this.bFO.ceM;
    if (e.JK(this.mxv)) {
      y.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.mxv });
      com.tencent.mm.plugin.music.cache.g.Jl(this.mxv);
      com.tencent.mm.plugin.music.cache.g.aM(this.mxv, bool);
      try
      {
        URL localURL = new URL(this.mxv);
        if (localURL == null)
        {
          y.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
          uv(500);
          uw(500);
          return;
        }
      }
      catch (Exception localException3)
      {
        Object localObject;
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
          localObject = null;
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
          this.mxp.setDataSource(this.mxu, Uri.parse(localObject.toString()));
          this.mxp.prepare();
          return;
        }
        catch (Exception localException4)
        {
          y.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException4.getMessage());
          y.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException4, "initPlayer", new Object[0]);
          uv(501);
          uw(501);
          return;
        }
      }
    }
  }
  
  private void bmx()
  {
    this.mxp.start();
    if (this.mxe != null) {
      this.mxe.a(this.bFO.bFM, this.bFO.ceM, System.currentTimeMillis() - this.bFO.eaS, this.bFO.eaT, this.bFO.eaU);
    }
  }
  
  private void uw(int paramInt)
  {
    if (this.mxe != null) {
      this.mxe.dm(this.bFO.fromScene, paramInt);
    }
  }
  
  public final void Jd(String paramString)
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.bFM = paramString;
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
  
  public final d bmB()
  {
    boolean bool1 = false;
    if (this.mxq == null) {
      this.mxq = new d();
    }
    int k = getDuration();
    int m = bmA();
    boolean bool2 = Pu();
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
      this.mxq.bFN = m;
      this.mxq.duration = k;
      d locald = this.mxq;
      if (bool2) {}
      for (;;)
      {
        locald.jJ = bool1;
        this.mxq.eaW = this.eaW;
        this.mxq.eaX = (j * k / 100);
        if (this.bFO == null) {
          break;
        }
        this.mxq.startTime = this.bFO.eaN;
        this.mxq.eaY = this.bFO.ceM;
        return this.mxq;
        bool1 = true;
      }
      return null;
    }
  }
  
  public final void bmC()
  {
    if ((this.bFM.equalsIgnoreCase(this.bFO.bFM)) && (this.mxp != null) && (Pu()))
    {
      int i = (int)this.mxp.getCurrentPosition();
      int j = this.mxp.getDuration();
      if ((i > 0) && (j > 0) && (this.mxn != null)) {
        this.mxn.cy(i, j);
      }
    }
  }
  
  public final boolean bmk()
  {
    return true;
  }
  
  public final String bmm()
  {
    return this.bFM;
  }
  
  public final void bmw()
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
  }
  
  public final boolean bmy()
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
  
  final void bmz()
  {
    try
    {
      if (this.mxp != null)
      {
        this.mxp.setVolume(0.0F, 0.0F);
        this.mxp.stop();
      }
      if (this.mxt != null)
      {
        this.mxt.isStop = true;
        this.mxt = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        uv(504);
        uw(504);
      }
    }
    this.mxr = false;
    this.mxs = true;
    this.dEq = System.currentTimeMillis();
  }
  
  public final void c(com.tencent.mm.af.b paramb)
  {
    this.bFO = paramb;
    this.startTime = paramb.startTime;
    this.mxw = paramb.eaO;
    if ((this.mxp != null) && (Pu()))
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.bFM, this.mxv, Double.valueOf(this.bFO.eaR) });
      this.mxp.setVolume((float)this.bFO.eaR, (float)this.bFO.eaR);
    }
  }
  
  public final void d(com.tencent.mm.af.b paramb)
  {
    if (paramb == null)
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      bmu();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.mxx;
    if ((this.bFO != null) && (this.bFO.a(paramb)) && (l2 <= 100L))
    {
      this.bFO = paramb;
      this.startTime = paramb.startTime;
      this.mxw = paramb.eaO;
      y.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.mxv, Long.valueOf(l2) });
      return;
    }
    this.mxe = ((com.tencent.mm.plugin.music.b.a.b)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.b.a.b.class));
    if (this.mxe != null) {
      this.mxe.ux(paramb.fromScene);
    }
    this.mxx = l1;
    this.bFO = paramb;
    y.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.bFO.fromScene), this.bFM });
    if ((this.mxp != null) && (Pu())) {
      this.mxp.stop();
    }
    this.aRY = 0;
    this.startTime = paramb.startTime;
    this.mxw = paramb.eaO;
    this.audioType = null;
    this.mxy = false;
    this.eaW = false;
    this.mxs = false;
    bmv();
  }
  
  public final String getAppId()
  {
    if (this.bFO != null) {
      return this.bFO.appId;
    }
    return "";
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
    int i = getDuration();
    y.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i < 0)
    {
      y.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      return false;
    }
    if (paramInt > i)
    {
      y.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      return false;
    }
    if (this.mxp != null)
    {
      y.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      t localt = new t();
      localt.bFS.action = 10;
      localt.bFS.state = "seeking";
      localt.bFS.bFM = bmm();
      localt.bFS.appId = getAppId();
      com.tencent.mm.sdk.b.a.udP.a(localt, Looper.getMainLooper());
      this.mxp.seekTo(paramInt);
    }
    return true;
  }
  
  public final boolean isCompleted()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mxp != null)
    {
      bool1 = bool2;
      if (this.mxp.getPlayerState() == 7) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean isPaused()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mxp != null)
    {
      bool1 = bool2;
      if (this.mxp.getPlayerState() == 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean isPrepared()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mxp != null)
    {
      bool1 = bool2;
      if (this.mxp.getPlayerState() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean isStopped()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mxp != null)
    {
      bool1 = bool2;
      if (this.mxp.getPlayerState() == 6) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void pause()
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.bFM });
    this.mxs = true;
    if ((this.mxp != null) && (Pu())) {}
    while ((this.mxp == null) || (!isCompleted())) {
      try
      {
        y.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.mxp.pause();
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        uv(503);
        uw(503);
        return;
      }
    }
    y.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
    this.mxr = false;
  }
  
  public final void release()
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.mxh = null;
    if (this.mxp != null)
    {
      this.mxp.release();
      this.mxp = null;
    }
    if (this.mxl != null)
    {
      this.mxl.end();
      this.mxl.crw();
    }
  }
  
  public final void resume()
  {
    this.aRY = 0;
    boolean bool1 = bmy();
    boolean bool2 = Pu();
    this.mxs = false;
    this.eaW = false;
    y.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.mxr), this.bFM });
    if ((this.mxp != null) && (!isPrepared()) && (!bool1) && (!bool2) && (!this.mxr))
    {
      y.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.startTime = 0;
      this.mxw = true;
      bmv();
      if (this.mxe != null) {
        this.mxe.ux(this.bFO.fromScene);
      }
    }
    while ((this.mxp == null) || ((!isPaused()) && (!isPrepared())) || (bool2)) {
      return;
    }
    y.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    try
    {
      this.mxp.setVolume((float)this.bFO.eaR, (float)this.bFO.eaR);
      bmx();
      this.mxr = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        uv(502);
        uw(502);
      }
    }
  }
  
  public final void stopPlay()
  {
    y.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.eaW = false;
    bmz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.g
 * JD-Core Version:    0.7.0.1
 */