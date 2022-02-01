package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.luggage.j.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ac;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import java.net.URL;
import java.util.ArrayList;

public final class l
  extends j
{
  com.tencent.mm.plugin.music.b.a.d LIY;
  CommonPlayer LJA;
  private com.tencent.mm.al.d LJB;
  boolean LJC;
  boolean LJD;
  a LJE;
  private com.tencent.mm.plugin.music.g.a.b LJF;
  private long LJG;
  boolean LJH;
  long LJI;
  private String LJJ;
  private PlayerListenerCallback LJK;
  private IAudioListener LJL;
  AudioFormat.AudioType audioType;
  boolean autoPlay;
  int diT;
  public a ete;
  String hqQ;
  String hrl;
  protected com.tencent.mm.al.b hzU;
  long mwK;
  boolean orB;
  int startTime;
  MMHandler tiG;
  int yoO;
  
  public l()
  {
    AppMethodBeat.i(137114);
    this.hqQ = "";
    this.LJD = false;
    this.orB = false;
    this.hrl = "";
    this.diT = 0;
    this.yoO = 0;
    this.startTime = 0;
    this.autoPlay = false;
    this.LJG = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.LJH = false;
    this.LJI = 0L;
    this.mwK = 0L;
    this.ete = null;
    this.LJJ = "";
    this.LJK = new PlayerListenerCallback()
    {
      com.tencent.mm.al.b LJM = null;
      
      public final void onBufferingUpdate(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt) {}
      
      public final void onCompletion(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137100);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
        AppMethodBeat.o(137100);
      }
      
      public final void onError(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137102);
        Log.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), l.this.hqQ });
        if (this.LJM == null)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
          AppMethodBeat.o(137102);
          return;
        }
        boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
        }
        if (l.this.diT > 0)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(l.this.diT) });
          AppMethodBeat.o(137102);
          return;
        }
        l.this.LJC = false;
        paramAnonymousBaseMediaPlayer = l.this;
        paramAnonymousBaseMediaPlayer.diT += 1;
        l.this.yoO = paramAnonymousInt2;
        l.this.mwK = System.currentTimeMillis();
        l.a(l.this, paramAnonymousInt2);
        if (l.this.hqQ.equalsIgnoreCase(this.LJM.hqQ))
        {
          l.this.stopPlay();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(137098);
              if (com.tencent.mm.plugin.music.cache.e.gmX()) {}
              for (boolean bool = ((com.tencent.mm.plugin.music.cache.c)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.cache.c.class)).gmR();; bool = false)
              {
                if (bool) {
                  Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.a.music_file_wrong), 0).show();
                }
                AppMethodBeat.o(137098);
                return;
                Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
              }
            }
          });
        }
        l.this.adb(paramAnonymousInt2);
        if (l.this.LJE != null)
        {
          l.this.LJE.isStop = true;
          l.this.LJE = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          Log.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
          g.aOJ(l.this.hrl);
        }
        AppMethodBeat.o(137102);
      }
      
      public final void onPrepared(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137103);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
        AppMethodBeat.o(137103);
      }
      
      public final void onSeekComplete(BaseMediaPlayer paramAnonymousBaseMediaPlayer, final int paramAnonymousInt)
      {
        AppMethodBeat.i(137101);
        l.this.tiG.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137097);
            Log.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (l.this.startTime != 0)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(l.this.startTime) });
              l.this.startTime = 0;
              AppMethodBeat.o(137097);
              return;
            }
            l.1 local1 = l.1.this;
            Log.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
            local1.LJN.gmq();
            if (local1.LJN.bLk())
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
              local1.LJN.gmn();
            }
            AppMethodBeat.o(137097);
          }
        });
        AppMethodBeat.o(137101);
      }
      
      public final void onStarted(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137105);
        Log.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
        AppMethodBeat.o(137105);
      }
      
      public final void onStateChanged(BaseMediaPlayer paramAnonymousBaseMediaPlayer, final int paramAnonymousInt)
      {
        AppMethodBeat.i(137104);
        l.this.tiG.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137099);
            String str = l.this.hqQ;
            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            if (paramAnonymousInt == 3)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
              l.1.a(l.1.this);
              l.this.LJI = System.currentTimeMillis();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 2)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
              Log.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l.this.LJI) });
              l.1.b(l.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 4)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
              Log.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l.this.LJI) });
              l.1.c(l.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 5)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
              l.1.d(l.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 6)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
              l.1.e(l.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 7)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
              l.1.f(l.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 8)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
              l.1.gmD();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 9) {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
            }
            AppMethodBeat.o(137099);
          }
        });
        AppMethodBeat.o(137104);
      }
    };
    this.LJL = new l.2(this);
    this.hqQ = h.glT();
    com.tencent.mm.plugin.music.e.a.a.goy();
    i locali = i.glV();
    for (;;)
    {
      synchronized (locali.LJc)
      {
        if (!locali.LJc.contains(this)) {
          locali.LJc.add(this);
        }
        Log.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
        this.tiG = new MMHandler(Looper.myLooper());
        if (com.tencent.mm.plugin.music.cache.e.gmX())
        {
          ??? = ((com.tencent.mm.plugin.music.cache.c)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.cache.c.class)).gmU();
          this.LJJ = ((String)???);
          Log.i("MicroMsg.Audio.QQAudioPlayer", "playCacheTempDir:%s", new Object[] { this.LJJ });
          AppMethodBeat.o(137114);
          return;
        }
      }
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
      ??? = "";
    }
  }
  
  private void adc(int paramInt)
  {
    AppMethodBeat.i(137139);
    if (this.LIY != null) {
      this.LIY.jX(this.hzU.fromScene, paramInt);
    }
    AppMethodBeat.o(137139);
  }
  
  private void eDO()
  {
    AppMethodBeat.i(137118);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    com.tencent.mm.plugin.music.g.c localc1;
    if (r(this.hzU))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "play with pByteBuff");
      if (this.LJA == null) {
        this.LJA = new CommonPlayer(this.LJK);
      }
      this.LJA.reset();
      localc1 = new com.tencent.mm.plugin.music.g.c(this.hzU.orz);
    }
    for (;;)
    {
      try
      {
        this.LJA.setDataSource(localc1);
        this.LJA.addAudioListener(this.LJL);
        this.LJA.prepare();
        float f = 0.0F;
        if (this.hzU != null) {
          f = (float)this.hzU.orm;
        }
        if (this.LJA != null)
        {
          if ((f < 0.5F) || (f > 2.0F)) {
            break label830;
          }
          Log.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Float.valueOf(f) });
          this.LJA.setSpeed(f);
          this.LJA.setVolume((float)this.hzU.orl, (float)this.hzU.orl);
        }
        AppMethodBeat.o(137118);
        return;
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException1.getMessage());
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer", new Object[0]);
        adb(501);
        adc(501);
        continue;
      }
      if ((!TextUtils.isEmpty(this.hzU.filePath)) && (this.hzU.orw == null))
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.hzU.filePath });
        if (this.LJA == null) {
          this.LJA = new CommonPlayer(this.LJK);
        }
        this.LJA.reset();
        try
        {
          this.LJA.setDataSource(this.hzU.filePath);
          this.LJA.addAudioListener(this.LJL);
          this.LJA.prepare();
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer exception", new Object[0]);
          adb(501);
          adc(501);
        }
      }
      else if ((!TextUtils.isEmpty(this.hzU.filePath)) && (this.hzU.orw != null))
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.hzU.filePath });
        if (this.LJA == null) {
          this.LJA = new CommonPlayer(this.LJK);
        }
        this.LJA.reset();
        com.tencent.mm.plugin.music.g.c localc2 = new com.tencent.mm.plugin.music.g.c(this.hzU.orw);
        try
        {
          this.LJA.setDataSource(localc2);
          this.LJA.addAudioListener(this.LJL);
          this.LJA.prepare();
        }
        catch (Exception localException3)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException3.getMessage());
          Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
          adb(501);
          adc(501);
        }
      }
      else
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.hzU.hsg });
        gmt();
        try
        {
          URL localURL = new URL(this.hrl);
          if (localURL == null)
          {
            Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
            adb(500);
            adc(500);
            AppMethodBeat.o(137118);
            return;
          }
        }
        catch (Exception localException4)
        {
          Object localObject;
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException4, "initPlayer", new Object[0]);
            localObject = null;
          }
          if (this.LJA == null) {
            this.LJA = new CommonPlayer(this.LJK);
          }
          this.LJA.reset();
          if (this.LJF == null) {
            this.LJF = new com.tencent.mm.plugin.music.g.a.b();
          }
          this.LJF.kA(this.hrl, this.hzU.orv);
          try
          {
            if (!TextUtils.isEmpty(this.LJJ)) {
              this.LJA.setOnlinePlayCacheDir(this.LJJ);
            }
            this.LJA.setDataSource(this.LJF, Uri.parse(localObject.toString()));
            this.LJA.addAudioListener(this.LJL);
            this.LJA.prepare();
          }
          catch (Exception localException5)
          {
            Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException5.getMessage());
            Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException5, "initPlayer", new Object[0]);
            adb(501);
            adc(501);
          }
        }
        continue;
        label830:
        this.LJA.setSpeed(1.0F);
      }
    }
  }
  
  private void gmt()
  {
    AppMethodBeat.i(137119);
    this.hrl = this.hzU.hsg;
    if (com.tencent.mm.plugin.music.h.e.aPq(this.hrl)) {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.hrl });
      g.aOD(this.hrl);
      g.cv(this.hrl, bool);
      AppMethodBeat.o(137119);
      return;
    }
  }
  
  private void gmv()
  {
    AppMethodBeat.i(270894);
    if ((cxs()) || (isPaused())) {
      this.LJA.setAudioStreamType(i.glV().getStreamType());
    }
    this.LJA.start();
    this.LJA.setVolume((float)this.hzU.orl, (float)this.hzU.orl);
    AppMethodBeat.o(270894);
  }
  
  private void gmz()
  {
    AppMethodBeat.i(137134);
    for (;;)
    {
      try
      {
        if (this.LJA != null)
        {
          this.LJA.setVolume(0.0F, 0.0F);
          if ((!cxs()) && (!isPaused()) && (!bLk())) {
            continue;
          }
          Log.i("MicroMsg.Audio.QQAudioPlayer", "stop");
          this.LJA.stop();
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        adb(504);
        adc(504);
        continue;
        Log.i("MicroMsg.Audio.QQAudioPlayer", "reset and send stop event");
        this.LJA.reset();
        gmp();
        continue;
      }
      if (this.LJE != null)
      {
        this.LJE.isStop = true;
        this.LJE = null;
      }
      this.LJC = false;
      this.LJD = true;
      this.mwK = System.currentTimeMillis();
      AppMethodBeat.o(137134);
      return;
      if (!this.orB) {
        continue;
      }
      Log.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
      this.LJA.reset();
      gmo();
    }
  }
  
  private static boolean r(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(270889);
    if ((paramb != null) && (paramb.hsg.startsWith("wxblob://")) && (paramb.orz != null))
    {
      AppMethodBeat.o(270889);
      return true;
    }
    AppMethodBeat.o(270889);
    return false;
  }
  
  public final void a(d.a parama) {}
  
  public final void aOv(String paramString)
  {
    AppMethodBeat.i(137115);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.hqQ = paramString;
    AppMethodBeat.o(137115);
  }
  
  public final void b(d.a parama) {}
  
  public final boolean bLk()
  {
    AppMethodBeat.i(137123);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 4)
      {
        AppMethodBeat.o(137123);
        return true;
      }
      AppMethodBeat.o(137123);
      return false;
    }
    AppMethodBeat.o(137123);
    return false;
  }
  
  public final boolean bLm()
  {
    AppMethodBeat.i(137129);
    if ((this.LJC) && (!cNW()))
    {
      AppMethodBeat.o(137129);
      return true;
    }
    AppMethodBeat.o(137129);
    return false;
  }
  
  public final boolean cNW()
  {
    AppMethodBeat.i(137124);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 3)
      {
        AppMethodBeat.o(137124);
        return true;
      }
      AppMethodBeat.o(137124);
      return false;
    }
    AppMethodBeat.o(137124);
    return false;
  }
  
  public final boolean cxs()
  {
    AppMethodBeat.i(137125);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 2)
      {
        AppMethodBeat.o(137125);
        return true;
      }
      AppMethodBeat.o(137125);
      return false;
    }
    AppMethodBeat.o(137125);
    return false;
  }
  
  public final void g(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(137116);
    this.hzU = paramb;
    this.startTime = paramb.startTime;
    this.autoPlay = paramb.orj;
    if ((this.LJA != null) && (bLk()))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.hqQ, this.hrl, Double.valueOf(this.hzU.orl) });
      this.LJA.setVolume((float)this.hzU.orl, (float)this.hzU.orl);
      if (this.hzU.orm > 0.0D)
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Double.valueOf(this.hzU.orm) });
        this.LJA.setSpeed((float)this.hzU.orm);
        AppMethodBeat.o(137116);
        return;
      }
      this.LJA.setSpeed(1.0F);
    }
    AppMethodBeat.o(137116);
  }
  
  public final String getAppId()
  {
    if (this.hzU != null) {
      return this.hzU.appId;
    }
    return "";
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137136);
    if (this.LJA != null)
    {
      int i = this.LJA.getDuration();
      AppMethodBeat.o(137136);
      return i;
    }
    AppMethodBeat.o(137136);
    return -1;
  }
  
  public final int gmA()
  {
    AppMethodBeat.i(137135);
    if (this.LJA != null)
    {
      int i = (int)this.LJA.getCurrentPosition();
      AppMethodBeat.o(137135);
      return i;
    }
    AppMethodBeat.o(137135);
    return -1;
  }
  
  public final com.tencent.mm.al.d gmB()
  {
    boolean bool1 = false;
    AppMethodBeat.i(137138);
    if (this.LJB == null) {
      this.LJB = new com.tencent.mm.al.d();
    }
    int k = getDuration();
    int m = gmA();
    boolean bool2 = bLk();
    if (this.LJA != null) {}
    for (int j = this.LJA.getBufferedPercentage();; j = 0)
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
      this.LJB.currentTime = m;
      this.LJB.duration = k;
      com.tencent.mm.al.d locald = this.LJB;
      if (bool2) {}
      for (;;)
      {
        locald.orA = bool1;
        this.LJB.orB = this.orB;
        this.LJB.orC = (j * k / 100);
        if (this.hzU == null) {
          break;
        }
        this.LJB.startTime = this.hzU.ori;
        this.LJB.hqM = this.hzU.hsg;
        this.LJB.oru = this.hzU.oru;
        locald = this.LJB;
        AppMethodBeat.o(137138);
        return locald;
        bool1 = true;
      }
      AppMethodBeat.o(137138);
      return null;
    }
  }
  
  public final void gmC()
  {
    AppMethodBeat.i(137141);
    if ((this.hqQ.equalsIgnoreCase(this.hzU.hqQ)) && (this.LJA != null) && (bLk()))
    {
      int i = (int)this.LJA.getCurrentPosition();
      int j = this.LJA.getDuration();
      if ((i > 0) && (j > 0) && (this.LJz != null)) {
        this.LJz.onProgress(i, j);
      }
    }
    AppMethodBeat.o(137141);
  }
  
  public final boolean gmi()
  {
    return true;
  }
  
  public final String gmk()
  {
    return this.hqQ;
  }
  
  public final void gmu()
  {
    AppMethodBeat.i(137121);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
    AppMethodBeat.o(137121);
  }
  
  public final void gmw()
  {
    AppMethodBeat.i(137130);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.orB = true;
    this.LJD = true;
    AppMethodBeat.o(137130);
  }
  
  public final void gmx()
  {
    AppMethodBeat.i(137131);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.orB = true;
    gmz();
    AppMethodBeat.o(137131);
  }
  
  public final void gmy()
  {
    AppMethodBeat.i(137132);
    this.orB = false;
    this.LJD = true;
    gmp();
    this.mwK = System.currentTimeMillis();
    AppMethodBeat.o(137132);
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(137127);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 7)
      {
        AppMethodBeat.o(137127);
        return true;
      }
      AppMethodBeat.o(137127);
      return false;
    }
    AppMethodBeat.o(137127);
    return false;
  }
  
  public final boolean isPaused()
  {
    AppMethodBeat.i(137126);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 5)
      {
        AppMethodBeat.o(137126);
        return true;
      }
      AppMethodBeat.o(137126);
      return false;
    }
    AppMethodBeat.o(137126);
    return false;
  }
  
  public final boolean isStopped()
  {
    AppMethodBeat.i(137128);
    if (this.LJA != null)
    {
      if (this.LJA.getPlayerState() == 6)
      {
        AppMethodBeat.o(137128);
        return true;
      }
      AppMethodBeat.o(137128);
      return false;
    }
    AppMethodBeat.o(137128);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137120);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.hqQ });
    this.LJD = true;
    if ((this.LJA != null) && (bLk())) {
      try
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.LJA.pause();
        AppMethodBeat.o(137120);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        adb(503);
        adc(503);
        AppMethodBeat.o(137120);
        return;
      }
    }
    if ((this.LJA != null) && (isCompleted()))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.LJC = false;
    }
    AppMethodBeat.o(137120);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137140);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.LJo = null;
    this.ete = null;
    if (this.LJA != null)
    {
      this.LJA.release();
      this.LJA = null;
    }
    i locali = i.glV();
    synchronized (locali.LJc)
    {
      if (locali.LJc.contains(this)) {
        locali.LJc.remove(this);
      }
      AppMethodBeat.o(137140);
      return;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137122);
    this.diT = 0;
    boolean bool1 = cNW();
    boolean bool2 = bLk();
    this.LJD = false;
    this.orB = false;
    Log.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.LJC), this.hqQ });
    if ((this.LJA != null) && (!cxs()) && (!bool1) && (!bool2) && (!this.LJC))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.startTime = 0;
      this.autoPlay = true;
      eDO();
      if (this.LIY != null)
      {
        this.LIY.adf(this.hzU.fromScene);
        AppMethodBeat.o(137122);
      }
    }
    else if ((this.LJA != null) && ((isPaused()) || (cxs())) && (!bool2))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    }
    try
    {
      this.LJA.setVolume((float)this.hzU.orl, (float)this.hzU.orl);
      gmv();
      this.LJC = true;
      AppMethodBeat.o(137122);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        adb(502);
        adc(502);
      }
    }
  }
  
  public final void s(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(137117);
    if (paramb == null)
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      gms();
      AppMethodBeat.o(137117);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.LJG;
    if ((this.hzU != null) && (this.hzU.j(paramb)) && (l2 <= 20L))
    {
      this.hzU = paramb;
      this.startTime = paramb.startTime;
      this.autoPlay = paramb.orj;
      Log.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.hrl, Long.valueOf(l2) });
      AppMethodBeat.o(137117);
      return;
    }
    this.LIY = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.LIY != null) {
      this.LIY.adf(paramb.fromScene);
    }
    this.LJG = l1;
    this.hzU = paramb;
    Log.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.hzU.fromScene), this.hqQ });
    if ((this.LJA != null) && (bLk())) {
      this.LJA.stop();
    }
    this.diT = 0;
    this.startTime = paramb.startTime;
    this.autoPlay = paramb.orj;
    this.audioType = null;
    this.LJH = false;
    this.orB = false;
    this.LJD = false;
    eDO();
    AppMethodBeat.o(137117);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137133);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.orB = false;
    gmz();
    AppMethodBeat.o(137133);
  }
  
  public final boolean wH(int paramInt)
  {
    AppMethodBeat.i(137137);
    int i = getDuration();
    Log.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i < 0)
    {
      Log.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137137);
      return false;
    }
    if (paramInt > i)
    {
      Log.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137137);
      return false;
    }
    if (this.LJA != null)
    {
      Log.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      ac localac = new ac();
      localac.hzX.action = 10;
      localac.hzX.state = "seeking";
      localac.hzX.hqQ = gmk();
      localac.hzX.appId = getAppId();
      localac.asyncPublish(Looper.getMainLooper());
      this.LJA.seekTo(paramInt);
    }
    AppMethodBeat.o(137137);
    return true;
  }
  
  final class a
    implements Runnable
  {
    boolean isStop = true;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(137113);
      Log.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
      for (;;)
      {
        if (!this.isStop) {
          try
          {
            if ((l.this.LJA != null) && (l.this.bLk())) {
              l.this.gmC();
            }
            try
            {
              Thread.sleep(200L);
            }
            catch (InterruptedException localInterruptedException) {}
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + localException.getMessage());
            }
          }
        }
      }
      AppMethodBeat.o(137113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.l
 * JD-Core Version:    0.7.0.1
 */