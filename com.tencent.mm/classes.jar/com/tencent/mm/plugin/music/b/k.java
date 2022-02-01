package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.y;
import com.tencent.mm.plugin.music.f.a.a;
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
import java.net.URL;
import java.util.ArrayList;

public final class k
  extends i
{
  CommonPlayer AhJ;
  private com.tencent.mm.ai.d AhK;
  boolean AhL;
  boolean AhM;
  a AhN;
  private com.tencent.mm.plugin.music.g.a.b AhO;
  private long AhP;
  boolean AhQ;
  long AhR;
  private PlayerListenerCallback AhS;
  com.tencent.mm.plugin.music.b.a.d Ahi;
  AudioFormat.AudioType audioType;
  boolean autoPlay;
  int bFM;
  protected com.tencent.mm.ai.b dCT;
  String dtX;
  String dus;
  int dvv;
  long hlh;
  boolean iJV;
  MMHandler ndA;
  int rxv;
  
  public k()
  {
    AppMethodBeat.i(137114);
    this.dtX = "";
    this.AhM = false;
    this.iJV = false;
    this.dus = "";
    this.bFM = 0;
    this.rxv = 0;
    this.dvv = 0;
    this.autoPlay = false;
    this.AhP = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.AhQ = false;
    this.AhR = 0L;
    this.hlh = 0L;
    this.AhS = new PlayerListenerCallback()
    {
      com.tencent.mm.ai.b AhT = null;
      
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
        Log.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), k.this.dtX });
        if (this.AhT == null)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
          AppMethodBeat.o(137102);
          return;
        }
        boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
        }
        if (k.this.bFM > 0)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(k.this.bFM) });
          AppMethodBeat.o(137102);
          return;
        }
        k.this.AhL = false;
        paramAnonymousBaseMediaPlayer = k.this;
        paramAnonymousBaseMediaPlayer.bFM += 1;
        k.this.rxv = paramAnonymousInt2;
        k.this.hlh = System.currentTimeMillis();
        k.a(k.this, paramAnonymousInt2);
        if (k.this.dtX.equalsIgnoreCase(this.AhT.dtX))
        {
          k.this.stopPlay();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(137098);
              if (com.tencent.mm.plugin.music.cache.e.etK()) {}
              for (boolean bool = ((com.tencent.mm.plugin.music.cache.c)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.cache.c.class)).etD();; bool = false)
              {
                if (bool) {
                  Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131763349), 0).show();
                }
                AppMethodBeat.o(137098);
                return;
                Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
              }
            }
          });
        }
        k.this.St(paramAnonymousInt2);
        if (k.this.AhN != null)
        {
          k.this.AhN.isStop = true;
          k.this.AhN = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          Log.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
          com.tencent.mm.plugin.music.cache.g.aHD(k.this.dus);
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
        k.this.ndA.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137097);
            Log.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (k.this.dvv != 0)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(k.this.dvv) });
              k.this.dvv = 0;
              AppMethodBeat.o(137097);
              return;
            }
            k.1 local1 = k.1.this;
            Log.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
            local1.AhU.etd();
            if (local1.AhU.bec())
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
              local1.AhU.eta();
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
        k.this.ndA.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137099);
            String str = k.this.dtX;
            Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            if (paramAnonymousInt == 3)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
              k.1.a(k.1.this);
              k.this.AhR = System.currentTimeMillis();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 2)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
              Log.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - k.this.AhR) });
              k.1.b(k.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 4)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
              Log.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - k.this.AhR) });
              k.1.c(k.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 5)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
              k.1.d(k.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 6)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
              k.1.e(k.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 7)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
              k.1.f(k.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 8)
            {
              Log.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
              k.1.etq();
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
    this.dtX = g.esG();
    a.euV();
    h localh = h.esI();
    synchronized (localh.Ahm)
    {
      if (!localh.Ahm.contains(this)) {
        localh.Ahm.add(this);
      }
      Log.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
      this.ndA = new MMHandler(Looper.myLooper());
      AppMethodBeat.o(137114);
      return;
    }
  }
  
  private void Su(int paramInt)
  {
    AppMethodBeat.i(137139);
    if (this.Ahi != null) {
      this.Ahi.ho(this.dCT.fromScene, paramInt);
    }
    AppMethodBeat.o(137139);
  }
  
  private void dlb()
  {
    AppMethodBeat.i(137118);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    com.tencent.mm.plugin.music.g.c localc1;
    if (r(this.dCT))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "play with pByteBuff");
      if (this.AhJ == null) {
        this.AhJ = new CommonPlayer(this.AhS);
      }
      this.AhJ.reset();
      localc1 = new com.tencent.mm.plugin.music.g.c(this.dCT.iJU);
    }
    for (;;)
    {
      try
      {
        this.AhJ.setDataSource(localc1);
        this.AhJ.prepare();
        float f = 0.0F;
        if (this.dCT != null) {
          f = (float)this.dCT.iJH;
        }
        if (this.AhJ == null) {
          break label745;
        }
        if ((f < 0.5F) || (f > 2.0F)) {
          break;
        }
        Log.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Float.valueOf(f) });
        this.AhJ.setSpeed(f);
        AppMethodBeat.o(137118);
        return;
      }
      catch (Exception localException1)
      {
        Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException1.getMessage());
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer", new Object[0]);
        St(501);
        Su(501);
        continue;
      }
      if ((!TextUtils.isEmpty(this.dCT.filePath)) && (this.dCT.iJR == null))
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.dCT.filePath });
        if (this.AhJ == null) {
          this.AhJ = new CommonPlayer(this.AhS);
        }
        this.AhJ.reset();
        try
        {
          this.AhJ.setDataSource(this.dCT.filePath);
          this.AhJ.prepare();
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer exception", new Object[0]);
          St(501);
          Su(501);
        }
      }
      else if ((!TextUtils.isEmpty(this.dCT.filePath)) && (this.dCT.iJR != null))
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.dCT.filePath });
        if (this.AhJ == null) {
          this.AhJ = new CommonPlayer(this.AhS);
        }
        this.AhJ.reset();
        com.tencent.mm.plugin.music.g.c localc2 = new com.tencent.mm.plugin.music.g.c(this.dCT.iJR);
        try
        {
          this.AhJ.setDataSource(localc2);
          this.AhJ.prepare();
        }
        catch (Exception localException3)
        {
          Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException3.getMessage());
          Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
          St(501);
          Su(501);
        }
      }
      else
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.dCT.dvn });
        etg();
        try
        {
          URL localURL = new URL(this.dus);
          if (localURL == null)
          {
            Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
            St(500);
            Su(500);
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
          if (this.AhJ == null) {
            this.AhJ = new CommonPlayer(this.AhS);
          }
          this.AhJ.reset();
          if (this.AhO == null) {
            this.AhO = new com.tencent.mm.plugin.music.g.a.b();
          }
          this.AhO.jb(this.dus, this.dCT.iJQ);
          try
          {
            this.AhJ.setDataSource(this.AhO, Uri.parse(localObject.toString()));
            this.AhJ.prepare();
          }
          catch (Exception localException5)
          {
            Log.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException5.getMessage());
            Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException5, "initPlayer", new Object[0]);
            St(501);
            Su(501);
          }
        }
      }
    }
    this.AhJ.setSpeed(1.0F);
    label745:
    AppMethodBeat.o(137118);
  }
  
  private void etg()
  {
    AppMethodBeat.i(137119);
    this.dus = this.dCT.dvn;
    if (com.tencent.mm.plugin.music.h.e.aIg(this.dus)) {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.dus });
      com.tencent.mm.plugin.music.cache.g.aHx(this.dus);
      com.tencent.mm.plugin.music.cache.g.bS(this.dus, bool);
      AppMethodBeat.o(137119);
      return;
    }
  }
  
  private void etm()
  {
    AppMethodBeat.i(137134);
    for (;;)
    {
      try
      {
        if (this.AhJ != null)
        {
          this.AhJ.setVolume(0.0F, 0.0F);
          if ((!asa()) && (!isPaused()) && (!bec())) {
            continue;
          }
          Log.i("MicroMsg.Audio.QQAudioPlayer", "stop");
          this.AhJ.stop();
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        St(504);
        Su(504);
        continue;
        Log.i("MicroMsg.Audio.QQAudioPlayer", "reset and send stop event");
        this.AhJ.reset();
        etc();
        continue;
      }
      if (this.AhN != null)
      {
        this.AhN.isStop = true;
        this.AhN = null;
      }
      this.AhL = false;
      this.AhM = true;
      this.hlh = System.currentTimeMillis();
      AppMethodBeat.o(137134);
      return;
      if (!this.iJV) {
        continue;
      }
      Log.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
      this.AhJ.reset();
      etb();
    }
  }
  
  private static boolean r(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(198175);
    if ((paramb != null) && (paramb.dvn.startsWith("wxblob://")) && (paramb.iJU != null))
    {
      AppMethodBeat.o(198175);
      return true;
    }
    AppMethodBeat.o(198175);
    return false;
  }
  
  public final void aHp(String paramString)
  {
    AppMethodBeat.i(137115);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.dtX = paramString;
    AppMethodBeat.o(137115);
  }
  
  public final boolean asa()
  {
    AppMethodBeat.i(137125);
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 2)
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
  
  public final boolean bec()
  {
    AppMethodBeat.i(137123);
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 4)
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
  
  public final boolean bee()
  {
    AppMethodBeat.i(137129);
    if ((this.AhL) && (!dFr()))
    {
      AppMethodBeat.o(137129);
      return true;
    }
    AppMethodBeat.o(137129);
    return false;
  }
  
  public final void c(d.a parama) {}
  
  public final boolean dFr()
  {
    AppMethodBeat.i(137124);
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 3)
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
  
  public final boolean esV()
  {
    return true;
  }
  
  public final String esX()
  {
    return this.dtX;
  }
  
  public final void eth()
  {
    AppMethodBeat.i(137121);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
    AppMethodBeat.o(137121);
  }
  
  final void eti()
  {
    AppMethodBeat.i(198176);
    if ((asa()) || (isPaused())) {
      this.AhJ.setAudioStreamType(h.esI().getStreamType());
    }
    this.AhJ.start();
    AppMethodBeat.o(198176);
  }
  
  public final void etj()
  {
    AppMethodBeat.i(137130);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.iJV = true;
    this.AhM = true;
    AppMethodBeat.o(137130);
  }
  
  public final void etk()
  {
    AppMethodBeat.i(137131);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.iJV = true;
    etm();
    AppMethodBeat.o(137131);
  }
  
  public final void etl()
  {
    AppMethodBeat.i(137132);
    this.iJV = false;
    this.AhM = true;
    etc();
    this.hlh = System.currentTimeMillis();
    AppMethodBeat.o(137132);
  }
  
  public final int etn()
  {
    AppMethodBeat.i(137135);
    if (this.AhJ != null)
    {
      int i = (int)this.AhJ.getCurrentPosition();
      AppMethodBeat.o(137135);
      return i;
    }
    AppMethodBeat.o(137135);
    return -1;
  }
  
  public final com.tencent.mm.ai.d eto()
  {
    boolean bool1 = false;
    AppMethodBeat.i(137138);
    if (this.AhK == null) {
      this.AhK = new com.tencent.mm.ai.d();
    }
    int k = getDuration();
    int m = etn();
    boolean bool2 = bec();
    if (this.AhJ != null) {}
    for (int j = this.AhJ.getBufferedPercentage();; j = 0)
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
      this.AhK.dCS = m;
      this.AhK.duration = k;
      com.tencent.mm.ai.d locald = this.AhK;
      if (bool2) {}
      for (;;)
      {
        locald.tN = bool1;
        this.AhK.iJV = this.iJV;
        this.AhK.iJW = (j * k / 100);
        if (this.dCT == null) {
          break;
        }
        this.AhK.dvv = this.dCT.iJD;
        this.AhK.dtT = this.dCT.dvn;
        this.AhK.iJP = this.dCT.iJP;
        locald = this.AhK;
        AppMethodBeat.o(137138);
        return locald;
        bool1 = true;
      }
      AppMethodBeat.o(137138);
      return null;
    }
  }
  
  public final void etp()
  {
    AppMethodBeat.i(137141);
    if ((this.dtX.equalsIgnoreCase(this.dCT.dtX)) && (this.AhJ != null) && (bec()))
    {
      int i = (int)this.AhJ.getCurrentPosition();
      int j = this.AhJ.getDuration();
      if ((i > 0) && (j > 0) && (this.AhI != null)) {
        this.AhI.fn(i, j);
      }
    }
    AppMethodBeat.o(137141);
  }
  
  public final void g(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137116);
    this.dCT = paramb;
    this.dvv = paramb.dvv;
    this.autoPlay = paramb.iJE;
    if ((this.AhJ != null) && (bec()))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.dtX, this.dus, Double.valueOf(this.dCT.iJG) });
      this.AhJ.setVolume((float)this.dCT.iJG, (float)this.dCT.iJG);
      if (this.dCT.iJH > 0.0D)
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Double.valueOf(this.dCT.iJH) });
        this.AhJ.setSpeed((float)this.dCT.iJH);
        AppMethodBeat.o(137116);
        return;
      }
      this.AhJ.setSpeed(1.0F);
    }
    AppMethodBeat.o(137116);
  }
  
  public final String getAppId()
  {
    if (this.dCT != null) {
      return this.dCT.appId;
    }
    return "";
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137136);
    if (this.AhJ != null)
    {
      int i = this.AhJ.getDuration();
      AppMethodBeat.o(137136);
      return i;
    }
    AppMethodBeat.o(137136);
    return -1;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(137127);
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 7)
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
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 5)
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
    if (this.AhJ != null)
    {
      if (this.AhJ.getPlayerState() == 6)
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
    Log.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.dtX });
    this.AhM = true;
    if ((this.AhJ != null) && (bec())) {
      try
      {
        Log.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.AhJ.pause();
        AppMethodBeat.o(137120);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        St(503);
        Su(503);
        AppMethodBeat.o(137120);
        return;
      }
    }
    if ((this.AhJ != null) && (isCompleted()))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.AhL = false;
    }
    AppMethodBeat.o(137120);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137140);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.Ahw = null;
    if (this.AhJ != null)
    {
      this.AhJ.release();
      this.AhJ = null;
    }
    h localh = h.esI();
    synchronized (localh.Ahm)
    {
      if (localh.Ahm.contains(this)) {
        localh.Ahm.remove(this);
      }
      AppMethodBeat.o(137140);
      return;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137122);
    this.bFM = 0;
    boolean bool1 = dFr();
    boolean bool2 = bec();
    this.AhM = false;
    this.iJV = false;
    Log.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.AhL), this.dtX });
    if ((this.AhJ != null) && (!asa()) && (!bool1) && (!bool2) && (!this.AhL))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.dvv = 0;
      this.autoPlay = true;
      dlb();
      if (this.Ahi != null)
      {
        this.Ahi.Sw(this.dCT.fromScene);
        AppMethodBeat.o(137122);
      }
    }
    else if ((this.AhJ != null) && ((isPaused()) || (asa())) && (!bool2))
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    }
    try
    {
      this.AhJ.setVolume((float)this.dCT.iJG, (float)this.dCT.iJG);
      eti();
      this.AhL = true;
      AppMethodBeat.o(137122);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        St(502);
        Su(502);
      }
    }
  }
  
  public final void s(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137117);
    if (paramb == null)
    {
      Log.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      etf();
      AppMethodBeat.o(137117);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.AhP;
    if ((this.dCT != null) && (this.dCT.j(paramb)) && (l2 <= 20L))
    {
      this.dCT = paramb;
      this.dvv = paramb.dvv;
      this.autoPlay = paramb.iJE;
      Log.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.dus, Long.valueOf(l2) });
      AppMethodBeat.o(137117);
      return;
    }
    this.Ahi = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.Ahi != null) {
      this.Ahi.Sw(paramb.fromScene);
    }
    this.AhP = l1;
    this.dCT = paramb;
    Log.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.dCT.fromScene), this.dtX });
    if ((this.AhJ != null) && (bec())) {
      this.AhJ.stop();
    }
    this.bFM = 0;
    this.dvv = paramb.dvv;
    this.autoPlay = paramb.iJE;
    this.audioType = null;
    this.AhQ = false;
    this.iJV = false;
    this.AhM = false;
    dlb();
    AppMethodBeat.o(137117);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137133);
    Log.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.iJV = false;
    etm();
    AppMethodBeat.o(137133);
  }
  
  public final boolean tG(int paramInt)
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
    if (this.AhJ != null)
    {
      Log.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      y localy = new y();
      localy.dCW.action = 10;
      localy.dCW.state = "seeking";
      localy.dCW.dtX = esX();
      localy.dCW.appId = getAppId();
      EventCenter.instance.asyncPublish(localy, Looper.getMainLooper());
      this.AhJ.seekTo(paramInt);
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
            if ((k.this.AhJ != null) && (k.this.bec())) {
              k.this.etp();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.k
 * JD-Core Version:    0.7.0.1
 */