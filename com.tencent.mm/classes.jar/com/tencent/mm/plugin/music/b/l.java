package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.luggage.i.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.z;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.event.EventCenter;
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
  CommonPlayer FOF;
  private com.tencent.mm.al.d FOG;
  boolean FOH;
  boolean FOI;
  a FOJ;
  private com.tencent.mm.plugin.music.g.a.b FOK;
  private long FOL;
  boolean FOM;
  long FON;
  private PlayerListenerCallback FOO;
  private IAudioListener FOP;
  com.tencent.mm.plugin.music.b.a.d FOc;
  AudioFormat.AudioType audioType;
  boolean autoPlay;
  int bpq;
  public a cAJ;
  String fmF;
  String fna;
  int fod;
  protected com.tencent.mm.al.b fvz;
  long jWQ;
  boolean lAa;
  MMHandler qdR;
  int vdb;
  
  public l()
  {
    AppMethodBeat.i(137114);
    this.fmF = "";
    this.FOI = false;
    this.lAa = false;
    this.fna = "";
    this.bpq = 0;
    this.vdb = 0;
    this.fod = 0;
    this.autoPlay = false;
    this.FOL = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.FOM = false;
    this.FON = 0L;
    this.jWQ = 0L;
    this.cAJ = null;
    this.FOO = new PlayerListenerCallback()
    {
      com.tencent.mm.al.b FOQ = null;
      
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
        Log.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), l.this.fmF });
        if (this.FOQ == null)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
          AppMethodBeat.o(137102);
          return;
        }
        boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
        }
        if (l.this.bpq > 0)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(l.this.bpq) });
          AppMethodBeat.o(137102);
          return;
        }
        l.this.FOH = false;
        paramAnonymousBaseMediaPlayer = l.this;
        paramAnonymousBaseMediaPlayer.bpq += 1;
        l.this.vdb = paramAnonymousInt2;
        l.this.jWQ = System.currentTimeMillis();
        l.a(l.this, paramAnonymousInt2);
        if (l.this.fmF.equalsIgnoreCase(this.FOQ.fmF))
        {
          l.this.stopPlay();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(137098);
              if (com.tencent.mm.plugin.music.cache.e.fdV()) {}
              for (boolean bool = ((com.tencent.mm.plugin.music.cache.c)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.cache.c.class)).fdQ();; bool = false)
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
        l.this.YP(paramAnonymousInt2);
        if (l.this.FOJ != null)
        {
          l.this.FOJ.isStop = true;
          l.this.FOJ = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          Log.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
          g.aRR(l.this.fna);
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
        l.this.qdR.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137097);
            Log.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (l.this.fod != 0)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(l.this.fod) });
              l.this.fod = 0;
              AppMethodBeat.o(137097);
              return;
            }
            l.1 local1 = l.1.this;
            Log.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
            local1.FOR.fdn();
            if (local1.FOR.bnx())
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
              local1.FOR.fdk();
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
        l.this.qdR.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137099);
            String str = l.this.fmF;
            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            if (paramAnonymousInt == 3)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
              l.1.a(l.1.this);
              l.this.FON = System.currentTimeMillis();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 2)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
              Log.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l.this.FON) });
              l.1.b(l.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 4)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
              Log.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - l.this.FON) });
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
              l.1.fdA();
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
    this.FOP = new l.2(this);
    this.fmF = h.fcQ();
    com.tencent.mm.plugin.music.f.a.a.ffp();
    i locali = i.fcS();
    synchronized (locali.FOg)
    {
      if (!locali.FOg.contains(this)) {
        locali.FOg.add(this);
      }
      Log.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
      this.qdR = new MMHandler(Looper.myLooper());
      AppMethodBeat.o(137114);
      return;
    }
  }
  
  private void YQ(int paramInt)
  {
    AppMethodBeat.i(137139);
    if (this.FOc != null) {
      this.FOc.it(this.fvz.fromScene, paramInt);
    }
    AppMethodBeat.o(137139);
  }
  
  private void dLb()
  {
    AppMethodBeat.i(137118);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    com.tencent.mm.plugin.music.g.c localc1;
    if (r(this.fvz))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "play with pByteBuff");
      if (this.FOF == null) {
        this.FOF = new CommonPlayer(this.FOO);
      }
      this.FOF.reset();
      localc1 = new com.tencent.mm.plugin.music.g.c(this.fvz.lzY);
    }
    for (;;)
    {
      try
      {
        this.FOF.setDataSource(localc1);
        this.FOF.addAudioListener(this.FOP);
        this.FOF.prepare();
        float f = 0.0F;
        if (this.fvz != null) {
          f = (float)this.fvz.lzL;
        }
        if (this.FOF == null) {
          break label792;
        }
        if ((f < 0.5F) || (f > 2.0F)) {
          break;
        }
        Log.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Float.valueOf(f) });
        this.FOF.setSpeed(f);
        AppMethodBeat.o(137118);
        return;
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException1.getMessage());
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer", new Object[0]);
        YP(501);
        YQ(501);
        continue;
      }
      if ((!TextUtils.isEmpty(this.fvz.filePath)) && (this.fvz.lzV == null))
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.fvz.filePath });
        if (this.FOF == null) {
          this.FOF = new CommonPlayer(this.FOO);
        }
        this.FOF.reset();
        try
        {
          this.FOF.setDataSource(this.fvz.filePath);
          this.FOF.addAudioListener(this.FOP);
          this.FOF.prepare();
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer exception", new Object[0]);
          YP(501);
          YQ(501);
        }
      }
      else if ((!TextUtils.isEmpty(this.fvz.filePath)) && (this.fvz.lzV != null))
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.fvz.filePath });
        if (this.FOF == null) {
          this.FOF = new CommonPlayer(this.FOO);
        }
        this.FOF.reset();
        com.tencent.mm.plugin.music.g.c localc2 = new com.tencent.mm.plugin.music.g.c(this.fvz.lzV);
        try
        {
          this.FOF.setDataSource(localc2);
          this.FOF.addAudioListener(this.FOP);
          this.FOF.prepare();
        }
        catch (Exception localException3)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException3.getMessage());
          Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
          YP(501);
          YQ(501);
        }
      }
      else
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.fvz.fnV });
        fdq();
        try
        {
          URL localURL = new URL(this.fna);
          if (localURL == null)
          {
            Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
            YP(500);
            YQ(500);
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
          if (this.FOF == null) {
            this.FOF = new CommonPlayer(this.FOO);
          }
          this.FOF.reset();
          if (this.FOK == null) {
            this.FOK = new com.tencent.mm.plugin.music.g.a.b();
          }
          this.FOK.jl(this.fna, this.fvz.lzU);
          try
          {
            this.FOF.setDataSource(this.FOK, Uri.parse(localObject.toString()));
            this.FOF.addAudioListener(this.FOP);
            this.FOF.prepare();
          }
          catch (Exception localException5)
          {
            Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException5.getMessage());
            Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException5, "initPlayer", new Object[0]);
            YP(501);
            YQ(501);
          }
        }
      }
    }
    this.FOF.setSpeed(1.0F);
    label792:
    AppMethodBeat.o(137118);
  }
  
  private void fdq()
  {
    AppMethodBeat.i(137119);
    this.fna = this.fvz.fnV;
    if (com.tencent.mm.plugin.music.h.e.aSw(this.fna)) {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.fna });
      g.aRL(this.fna);
      g.bZ(this.fna, bool);
      AppMethodBeat.o(137119);
      return;
    }
  }
  
  private void fdw()
  {
    AppMethodBeat.i(137134);
    for (;;)
    {
      try
      {
        if (this.FOF != null)
        {
          this.FOF.setVolume(0.0F, 0.0F);
          if ((!ayN()) && (!isPaused()) && (!bnx())) {
            continue;
          }
          Log.i("MicroMsg.Audio.QQAudioPlayer", "stop");
          this.FOF.stop();
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        YP(504);
        YQ(504);
        continue;
        Log.i("MicroMsg.Audio.QQAudioPlayer", "reset and send stop event");
        this.FOF.reset();
        fdm();
        continue;
      }
      if (this.FOJ != null)
      {
        this.FOJ.isStop = true;
        this.FOJ = null;
      }
      this.FOH = false;
      this.FOI = true;
      this.jWQ = System.currentTimeMillis();
      AppMethodBeat.o(137134);
      return;
      if (!this.lAa) {
        continue;
      }
      Log.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
      this.FOF.reset();
      fdl();
    }
  }
  
  private static boolean r(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(257496);
    if ((paramb != null) && (paramb.fnV.startsWith("wxblob://")) && (paramb.lzY != null))
    {
      AppMethodBeat.o(257496);
      return true;
    }
    AppMethodBeat.o(257496);
    return false;
  }
  
  public final void a(d.a parama) {}
  
  public final void aRD(String paramString)
  {
    AppMethodBeat.i(137115);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.fmF = paramString;
    AppMethodBeat.o(137115);
  }
  
  public final boolean ayN()
  {
    AppMethodBeat.i(137125);
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 2)
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
  
  public final void b(d.a parama) {}
  
  public final boolean bnx()
  {
    AppMethodBeat.i(137123);
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 4)
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
  
  public final boolean bnz()
  {
    AppMethodBeat.i(137129);
    if ((this.FOH) && (!cmp()))
    {
      AppMethodBeat.o(137129);
      return true;
    }
    AppMethodBeat.o(137129);
    return false;
  }
  
  public final boolean cmp()
  {
    AppMethodBeat.i(137124);
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 3)
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
  
  public final boolean fdf()
  {
    return true;
  }
  
  public final String fdh()
  {
    return this.fmF;
  }
  
  public final void fdr()
  {
    AppMethodBeat.i(137121);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
    AppMethodBeat.o(137121);
  }
  
  final void fds()
  {
    AppMethodBeat.i(257498);
    if ((ayN()) || (isPaused())) {
      this.FOF.setAudioStreamType(i.fcS().getStreamType());
    }
    this.FOF.start();
    AppMethodBeat.o(257498);
  }
  
  public final void fdt()
  {
    AppMethodBeat.i(137130);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.lAa = true;
    this.FOI = true;
    AppMethodBeat.o(137130);
  }
  
  public final void fdu()
  {
    AppMethodBeat.i(137131);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.lAa = true;
    fdw();
    AppMethodBeat.o(137131);
  }
  
  public final void fdv()
  {
    AppMethodBeat.i(137132);
    this.lAa = false;
    this.FOI = true;
    fdm();
    this.jWQ = System.currentTimeMillis();
    AppMethodBeat.o(137132);
  }
  
  public final int fdx()
  {
    AppMethodBeat.i(137135);
    if (this.FOF != null)
    {
      int i = (int)this.FOF.getCurrentPosition();
      AppMethodBeat.o(137135);
      return i;
    }
    AppMethodBeat.o(137135);
    return -1;
  }
  
  public final com.tencent.mm.al.d fdy()
  {
    boolean bool1 = false;
    AppMethodBeat.i(137138);
    if (this.FOG == null) {
      this.FOG = new com.tencent.mm.al.d();
    }
    int k = getDuration();
    int m = fdx();
    boolean bool2 = bnx();
    if (this.FOF != null) {}
    for (int j = this.FOF.getBufferedPercentage();; j = 0)
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
      this.FOG.currentTime = m;
      this.FOG.duration = k;
      com.tencent.mm.al.d locald = this.FOG;
      if (bool2) {}
      for (;;)
      {
        locald.lzZ = bool1;
        this.FOG.lAa = this.lAa;
        this.FOG.lAb = (j * k / 100);
        if (this.fvz == null) {
          break;
        }
        this.FOG.fod = this.fvz.lzH;
        this.FOG.fmB = this.fvz.fnV;
        this.FOG.lzT = this.fvz.lzT;
        locald = this.FOG;
        AppMethodBeat.o(137138);
        return locald;
        bool1 = true;
      }
      AppMethodBeat.o(137138);
      return null;
    }
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(137141);
    if ((this.fmF.equalsIgnoreCase(this.fvz.fmF)) && (this.FOF != null) && (bnx()))
    {
      int i = (int)this.FOF.getCurrentPosition();
      int j = this.FOF.getDuration();
      if ((i > 0) && (j > 0) && (this.FOE != null)) {
        this.FOE.fK(i, j);
      }
    }
    AppMethodBeat.o(137141);
  }
  
  public final void g(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(137116);
    this.fvz = paramb;
    this.fod = paramb.fod;
    this.autoPlay = paramb.lzI;
    if ((this.FOF != null) && (bnx()))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.fmF, this.fna, Double.valueOf(this.fvz.lzK) });
      this.FOF.setVolume((float)this.fvz.lzK, (float)this.fvz.lzK);
      if (this.fvz.lzL > 0.0D)
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Double.valueOf(this.fvz.lzL) });
        this.FOF.setSpeed((float)this.fvz.lzL);
        AppMethodBeat.o(137116);
        return;
      }
      this.FOF.setSpeed(1.0F);
    }
    AppMethodBeat.o(137116);
  }
  
  public final String getAppId()
  {
    if (this.fvz != null) {
      return this.fvz.appId;
    }
    return "";
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137136);
    if (this.FOF != null)
    {
      int i = this.FOF.getDuration();
      AppMethodBeat.o(137136);
      return i;
    }
    AppMethodBeat.o(137136);
    return -1;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(137127);
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 7)
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
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 5)
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
    if (this.FOF != null)
    {
      if (this.FOF.getPlayerState() == 6)
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
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.fmF });
    this.FOI = true;
    if ((this.FOF != null) && (bnx())) {
      try
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.FOF.pause();
        AppMethodBeat.o(137120);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        YP(503);
        YQ(503);
        AppMethodBeat.o(137120);
        return;
      }
    }
    if ((this.FOF != null) && (isCompleted()))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.FOH = false;
    }
    AppMethodBeat.o(137120);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137140);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.FOs = null;
    this.cAJ = null;
    if (this.FOF != null)
    {
      this.FOF.release();
      this.FOF = null;
    }
    i locali = i.fcS();
    synchronized (locali.FOg)
    {
      if (locali.FOg.contains(this)) {
        locali.FOg.remove(this);
      }
      AppMethodBeat.o(137140);
      return;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137122);
    this.bpq = 0;
    boolean bool1 = cmp();
    boolean bool2 = bnx();
    this.FOI = false;
    this.lAa = false;
    Log.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.FOH), this.fmF });
    if ((this.FOF != null) && (!ayN()) && (!bool1) && (!bool2) && (!this.FOH))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.fod = 0;
      this.autoPlay = true;
      dLb();
      if (this.FOc != null)
      {
        this.FOc.YS(this.fvz.fromScene);
        AppMethodBeat.o(137122);
      }
    }
    else if ((this.FOF != null) && ((isPaused()) || (ayN())) && (!bool2))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    }
    try
    {
      this.FOF.setVolume((float)this.fvz.lzK, (float)this.fvz.lzK);
      fds();
      this.FOH = true;
      AppMethodBeat.o(137122);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        YP(502);
        YQ(502);
      }
    }
  }
  
  public final void s(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(137117);
    if (paramb == null)
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      fdp();
      AppMethodBeat.o(137117);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.FOL;
    if ((this.fvz != null) && (this.fvz.j(paramb)) && (l2 <= 20L))
    {
      this.fvz = paramb;
      this.fod = paramb.fod;
      this.autoPlay = paramb.lzI;
      Log.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.fna, Long.valueOf(l2) });
      AppMethodBeat.o(137117);
      return;
    }
    this.FOc = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.FOc != null) {
      this.FOc.YS(paramb.fromScene);
    }
    this.FOL = l1;
    this.fvz = paramb;
    Log.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.fvz.fromScene), this.fmF });
    if ((this.FOF != null) && (bnx())) {
      this.FOF.stop();
    }
    this.bpq = 0;
    this.fod = paramb.fod;
    this.autoPlay = paramb.lzI;
    this.audioType = null;
    this.FOM = false;
    this.lAa = false;
    this.FOI = false;
    dLb();
    AppMethodBeat.o(137117);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137133);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.lAa = false;
    fdw();
    AppMethodBeat.o(137133);
  }
  
  public final boolean wG(int paramInt)
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
    if (this.FOF != null)
    {
      Log.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      z localz = new z();
      localz.fvC.action = 10;
      localz.fvC.state = "seeking";
      localz.fvC.fmF = fdh();
      localz.fvC.appId = getAppId();
      EventCenter.instance.asyncPublish(localz, Looper.getMainLooper());
      this.FOF.seekTo(paramInt);
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
            if ((l.this.FOF != null) && (l.this.bnx())) {
              l.this.fdz();
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