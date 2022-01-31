package com.tencent.mm.plugin.music.b;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;

public final class h
  extends g
{
  int aZy;
  AudioFormat.AudioType audioType;
  String ceU;
  String ceu;
  protected com.tencent.mm.ag.b cmV;
  long eBT;
  boolean frl;
  ak ipC;
  int lCs;
  com.tencent.mm.plugin.music.b.a.d oWV;
  CommonPlayer oXm;
  private com.tencent.mm.ag.d oXn;
  boolean oXo;
  boolean oXp;
  h.a oXq;
  private IMediaHTTPService oXr;
  boolean oXs;
  private long oXt;
  boolean oXu;
  long oXv;
  private PlayerListenerCallback oXw;
  int startTime;
  
  public h()
  {
    AppMethodBeat.i(137364);
    this.ceu = "";
    this.oXp = false;
    this.frl = false;
    this.ceU = "";
    this.aZy = 0;
    this.lCs = 0;
    this.startTime = 0;
    this.oXs = false;
    this.oXt = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.oXu = false;
    this.oXv = 0L;
    this.eBT = 0L;
    this.oXw = new h.1(this);
    this.ceu = e.bTX();
    com.tencent.mm.plugin.music.f.a.a.bWg();
    if (android.support.v4.content.b.checkSelfPermission(ah.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
      ab.e("MicroMsg.Audio.BaseAudioPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
    }
    for (;;)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
      this.ipC = new ak(Looper.myLooper());
      AppMethodBeat.o(137364);
      return;
      this.oXi = new ax();
      this.oXi.hd(ah.getContext());
      this.oXi.a(new g.1(this));
    }
  }
  
  private void bUG()
  {
    AppMethodBeat.i(137384);
    try
    {
      if (this.oXm != null)
      {
        this.oXm.setVolume(0.0F, 0.0F);
        this.oXm.stop();
      }
      if (this.oXq != null)
      {
        this.oXq.isStop = true;
        this.oXq = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        zL(504);
        zM(504);
      }
    }
    this.oXo = false;
    this.oXp = true;
    this.eBT = System.currentTimeMillis();
    AppMethodBeat.o(137384);
  }
  
  private void bUy()
  {
    AppMethodBeat.i(137368);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    if ((!TextUtils.isEmpty(this.cmV.filePath)) && (this.cmV.fri == null))
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.cmV.filePath });
      if (this.oXm == null) {
        this.oXm = new CommonPlayer(this.oXw);
      }
      this.oXm.reset();
      try
      {
        this.oXm.setDataSource(this.cmV.filePath);
        this.oXm.prepare();
        AppMethodBeat.o(137368);
        return;
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer exception", new Object[0]);
        zL(501);
        zM(501);
        AppMethodBeat.o(137368);
        return;
      }
    }
    if ((!TextUtils.isEmpty(this.cmV.filePath)) && (this.cmV.fri != null))
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.cmV.filePath });
      if (this.oXm == null) {
        this.oXm = new CommonPlayer(this.oXw);
      }
      this.oXm.reset();
      com.tencent.mm.plugin.music.g.b localb = new com.tencent.mm.plugin.music.g.b(this.cmV.fri);
      try
      {
        this.oXm.setDataSource(localb);
        this.oXm.prepare();
        AppMethodBeat.o(137368);
        return;
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException2.getMessage());
        ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer", new Object[0]);
        zL(501);
        zM(501);
        AppMethodBeat.o(137368);
        return;
      }
    }
    ab.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.cmV.cfG });
    bUz();
    try
    {
      URL localURL = new URL(this.ceU);
      if (localURL == null)
      {
        ab.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
        zL(500);
        zM(500);
        AppMethodBeat.o(137368);
        return;
      }
    }
    catch (Exception localException3)
    {
      Object localObject;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
        localObject = null;
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
        this.oXm.setDataSource(this.oXr, Uri.parse(localObject.toString()));
        this.oXm.prepare();
        AppMethodBeat.o(137368);
        return;
      }
      catch (Exception localException4)
      {
        ab.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException4.getMessage());
        ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException4, "initPlayer", new Object[0]);
        zL(501);
        zM(501);
        AppMethodBeat.o(137368);
      }
    }
  }
  
  private void bUz()
  {
    AppMethodBeat.i(137369);
    this.ceU = this.cmV.cfG;
    if (com.tencent.mm.plugin.music.h.e.VJ(this.ceU)) {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.ceU });
      com.tencent.mm.plugin.music.cache.g.Vi(this.ceU);
      com.tencent.mm.plugin.music.cache.g.bb(this.ceU, bool);
      AppMethodBeat.o(137369);
      return;
    }
  }
  
  private void zM(int paramInt)
  {
    AppMethodBeat.i(137389);
    if (this.oWV != null) {
      this.oWV.eM(this.cmV.fromScene, paramInt);
    }
    AppMethodBeat.o(137389);
  }
  
  public final void Va(String paramString)
  {
    AppMethodBeat.i(137365);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.ceu = paramString;
    AppMethodBeat.o(137365);
  }
  
  public final boolean aiw()
  {
    AppMethodBeat.i(137373);
    if (this.oXm != null)
    {
      if (this.oXm.getPlayerState() == 4)
      {
        AppMethodBeat.o(137373);
        return true;
      }
      AppMethodBeat.o(137373);
      return false;
    }
    AppMethodBeat.o(137373);
    return false;
  }
  
  public final boolean aiy()
  {
    AppMethodBeat.i(137379);
    if ((this.oXo) && (!bUB()))
    {
      AppMethodBeat.o(137379);
      return true;
    }
    AppMethodBeat.o(137379);
    return false;
  }
  
  public final void b(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137366);
    this.cmV = paramb;
    this.startTime = paramb.startTime;
    this.oXs = paramb.fqX;
    if ((this.oXm != null) && (aiw()))
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.ceu, this.ceU, Double.valueOf(this.cmV.fra) });
      this.oXm.setVolume((float)this.cmV.fra, (float)this.cmV.fra);
    }
    AppMethodBeat.o(137366);
  }
  
  public final void bUA()
  {
    AppMethodBeat.i(137371);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
    AppMethodBeat.o(137371);
  }
  
  public final boolean bUB()
  {
    AppMethodBeat.i(137374);
    if (this.oXm != null)
    {
      if (this.oXm.getPlayerState() == 3)
      {
        AppMethodBeat.o(137374);
        return true;
      }
      AppMethodBeat.o(137374);
      return false;
    }
    AppMethodBeat.o(137374);
    return false;
  }
  
  public final boolean bUC()
  {
    AppMethodBeat.i(137375);
    if (this.oXm != null)
    {
      if (this.oXm.getPlayerState() == 2)
      {
        AppMethodBeat.o(137375);
        return true;
      }
      AppMethodBeat.o(137375);
      return false;
    }
    AppMethodBeat.o(137375);
    return false;
  }
  
  public final void bUD()
  {
    AppMethodBeat.i(137380);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.frl = true;
    this.oXp = true;
    AppMethodBeat.o(137380);
  }
  
  public final void bUE()
  {
    AppMethodBeat.i(137381);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.frl = true;
    bUG();
    AppMethodBeat.o(137381);
  }
  
  public final void bUF()
  {
    AppMethodBeat.i(137382);
    this.frl = false;
    this.oXp = true;
    bUu();
    this.eBT = System.currentTimeMillis();
    AppMethodBeat.o(137382);
  }
  
  public final int bUH()
  {
    AppMethodBeat.i(137385);
    if (this.oXm != null)
    {
      int i = (int)this.oXm.getCurrentPosition();
      AppMethodBeat.o(137385);
      return i;
    }
    AppMethodBeat.o(137385);
    return -1;
  }
  
  public final com.tencent.mm.ag.d bUI()
  {
    boolean bool1 = false;
    AppMethodBeat.i(137388);
    if (this.oXn == null) {
      this.oXn = new com.tencent.mm.ag.d();
    }
    int k = getDuration();
    int m = bUH();
    boolean bool2 = aiw();
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
      this.oXn.cmU = m;
      this.oXn.duration = k;
      com.tencent.mm.ag.d locald = this.oXn;
      if (bool2) {}
      for (;;)
      {
        locald.kH = bool1;
        this.oXn.frl = this.frl;
        this.oXn.frm = (j * k / 100);
        if (this.cmV == null) {
          break;
        }
        this.oXn.startTime = this.cmV.fqW;
        this.oXn.ceq = this.cmV.cfG;
        locald = this.oXn;
        AppMethodBeat.o(137388);
        return locald;
        bool1 = true;
      }
      AppMethodBeat.o(137388);
      return null;
    }
  }
  
  public final void bUJ()
  {
    AppMethodBeat.i(137391);
    if ((this.ceu.equalsIgnoreCase(this.cmV.ceu)) && (this.oXm != null) && (aiw()))
    {
      int i = (int)this.oXm.getCurrentPosition();
      int j = this.oXm.getDuration();
      if ((i > 0) && (j > 0) && (this.oXk != null)) {
        this.oXk.dW(i, j);
      }
    }
    AppMethodBeat.o(137391);
  }
  
  public final boolean bUn()
  {
    return true;
  }
  
  public final String bUp()
  {
    return this.ceu;
  }
  
  public final String getAppId()
  {
    if (this.cmV != null) {
      return this.cmV.appId;
    }
    return "";
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137386);
    if (this.oXm != null)
    {
      int i = this.oXm.getDuration();
      AppMethodBeat.o(137386);
      return i;
    }
    AppMethodBeat.o(137386);
    return -1;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(137377);
    if (this.oXm != null)
    {
      if (this.oXm.getPlayerState() == 7)
      {
        AppMethodBeat.o(137377);
        return true;
      }
      AppMethodBeat.o(137377);
      return false;
    }
    AppMethodBeat.o(137377);
    return false;
  }
  
  public final boolean isPaused()
  {
    AppMethodBeat.i(137376);
    if (this.oXm != null)
    {
      if (this.oXm.getPlayerState() == 5)
      {
        AppMethodBeat.o(137376);
        return true;
      }
      AppMethodBeat.o(137376);
      return false;
    }
    AppMethodBeat.o(137376);
    return false;
  }
  
  public final boolean isStopped()
  {
    AppMethodBeat.i(137378);
    if (this.oXm != null)
    {
      if (this.oXm.getPlayerState() == 6)
      {
        AppMethodBeat.o(137378);
        return true;
      }
      AppMethodBeat.o(137378);
      return false;
    }
    AppMethodBeat.o(137378);
    return false;
  }
  
  public final void l(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137367);
    if (paramb == null)
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      bUx();
      AppMethodBeat.o(137367);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.oXt;
    if ((this.cmV != null) && (this.cmV.e(paramb)) && (l2 <= 100L))
    {
      this.cmV = paramb;
      this.startTime = paramb.startTime;
      this.oXs = paramb.fqX;
      ab.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.ceU, Long.valueOf(l2) });
      AppMethodBeat.o(137367);
      return;
    }
    this.oWV = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.oWV != null) {
      this.oWV.zO(paramb.fromScene);
    }
    this.oXt = l1;
    this.cmV = paramb;
    ab.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.cmV.fromScene), this.ceu });
    if ((this.oXm != null) && (aiw())) {
      this.oXm.stop();
    }
    this.aZy = 0;
    this.startTime = paramb.startTime;
    this.oXs = paramb.fqX;
    this.audioType = null;
    this.oXu = false;
    this.frl = false;
    this.oXp = false;
    bUy();
    AppMethodBeat.o(137367);
  }
  
  public final boolean lN(int paramInt)
  {
    AppMethodBeat.i(137387);
    int i = getDuration();
    ab.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i < 0)
    {
      ab.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137387);
      return false;
    }
    if (paramInt > i)
    {
      ab.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137387);
      return false;
    }
    if (this.oXm != null)
    {
      ab.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      t localt = new t();
      localt.cmZ.action = 10;
      localt.cmZ.state = "seeking";
      localt.cmZ.ceu = bUp();
      localt.cmZ.appId = getAppId();
      com.tencent.mm.sdk.b.a.ymk.a(localt, Looper.getMainLooper());
      this.oXm.seekTo(paramInt);
    }
    AppMethodBeat.o(137387);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137370);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.ceu });
    this.oXp = true;
    if ((this.oXm != null) && (aiw())) {
      try
      {
        ab.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.oXm.pause();
        AppMethodBeat.o(137370);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        zL(503);
        zM(503);
        AppMethodBeat.o(137370);
        return;
      }
    }
    if ((this.oXm != null) && (isCompleted()))
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.oXo = false;
    }
    AppMethodBeat.o(137370);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137390);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.oXb = null;
    if (this.oXm != null)
    {
      this.oXm.release();
      this.oXm = null;
    }
    bUl();
    AppMethodBeat.o(137390);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137372);
    this.aZy = 0;
    boolean bool1 = bUB();
    boolean bool2 = aiw();
    this.oXp = false;
    this.frl = false;
    ab.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.oXo), this.ceu });
    if ((this.oXm != null) && (!bUC()) && (!bool1) && (!bool2) && (!this.oXo))
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.startTime = 0;
      this.oXs = true;
      bUy();
      if (this.oWV != null)
      {
        this.oWV.zO(this.cmV.fromScene);
        AppMethodBeat.o(137372);
      }
    }
    else if ((this.oXm != null) && ((isPaused()) || (bUC())) && (!bool2))
    {
      ab.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    }
    try
    {
      this.oXm.setVolume((float)this.cmV.fra, (float)this.cmV.fra);
      this.oXm.start();
      this.oXo = true;
      AppMethodBeat.o(137372);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        zL(502);
        zM(502);
      }
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137383);
    ab.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.frl = false;
    bUG();
    AppMethodBeat.o(137383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h
 * JD-Core Version:    0.7.0.1
 */