package com.tencent.mm.plugin.music.b;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.w;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.net.URL;

public final class h
  extends g
{
  AudioFormat.AudioType audioType;
  boolean autoPlay;
  int bvh;
  String cQO;
  String cRq;
  int cSh;
  protected com.tencent.mm.ai.b cZj;
  long gcd;
  boolean htD;
  ao lso;
  int pwp;
  com.tencent.mm.plugin.music.b.a.d vcJ;
  CommonPlayer vda;
  private com.tencent.mm.ai.d vdb;
  boolean vdc;
  boolean vdd;
  a vde;
  private com.tencent.mm.plugin.music.g.a.b vdf;
  private long vdg;
  boolean vdh;
  long vdi;
  private PlayerListenerCallback vdj;
  
  public h()
  {
    AppMethodBeat.i(137114);
    this.cQO = "";
    this.vdd = false;
    this.htD = false;
    this.cRq = "";
    this.bvh = 0;
    this.pwp = 0;
    this.cSh = 0;
    this.autoPlay = false;
    this.vdg = 0L;
    this.audioType = AudioFormat.AudioType.UNSUPPORT;
    this.vdh = false;
    this.vdi = 0L;
    this.gcd = 0L;
    this.vdj = new PlayerListenerCallback()
    {
      com.tencent.mm.ai.b vdk = null;
      
      public final void onBufferingUpdate(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt) {}
      
      public final void onCompletion(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137100);
        ac.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
        AppMethodBeat.o(137100);
      }
      
      public final void onError(BaseMediaPlayer paramAnonymousBaseMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(137102);
        ac.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), h.this.cQO });
        if (this.vdk == null)
        {
          ac.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
          AppMethodBeat.o(137102);
          return;
        }
        boolean bool = ax.isNetworkConnected(ai.getContext());
        if ((paramAnonymousInt2 == 80) && (bool)) {
          ac.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
        }
        if (h.this.bvh > 0)
        {
          ac.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(h.this.bvh) });
          AppMethodBeat.o(137102);
          return;
        }
        h.this.vdc = false;
        paramAnonymousBaseMediaPlayer = h.this;
        paramAnonymousBaseMediaPlayer.bvh += 1;
        h.this.pwp = paramAnonymousInt2;
        h.this.gcd = System.currentTimeMillis();
        h.a(h.this, paramAnonymousInt2);
        if (h.this.cQO.equalsIgnoreCase(this.vdk.cQO))
        {
          h.this.stopPlay();
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(137098);
              if (com.tencent.mm.plugin.music.cache.e.dip()) {}
              for (boolean bool = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dii();; bool = false)
              {
                if (bool) {
                  Toast.makeText(ai.getContext(), ai.getContext().getString(2131761469), 0).show();
                }
                AppMethodBeat.o(137098);
                return;
                ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
              }
            }
          });
        }
        h.this.Jo(paramAnonymousInt2);
        if (h.this.vde != null)
        {
          h.this.vde.isStop = true;
          h.this.vde = null;
        }
        if ((paramAnonymousInt1 == 91) && (paramAnonymousInt2 == 55))
        {
          ac.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
          com.tencent.mm.plugin.music.cache.g.anu(h.this.cRq);
        }
        AppMethodBeat.o(137102);
      }
      
      public final void onPrepared(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137103);
        ac.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
        AppMethodBeat.o(137103);
      }
      
      public final void onSeekComplete(BaseMediaPlayer paramAnonymousBaseMediaPlayer, final int paramAnonymousInt)
      {
        AppMethodBeat.i(137101);
        h.this.lso.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137097);
            ac.i("MicroMsg.Audio.QQAudioPlayer", "onSeekComplete, seekPosition:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (h.this.cSh != 0)
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(h.this.cSh) });
              h.this.cSh = 0;
              h.1.a(h.1.this);
              AppMethodBeat.o(137097);
              return;
            }
            h.1 local1 = h.1.this;
            ac.i("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
            local1.vdl.dhE();
            if (local1.vdl.aGv())
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
              local1.vdl.dhB();
            }
            AppMethodBeat.o(137097);
          }
        });
        AppMethodBeat.o(137101);
      }
      
      public final void onStarted(BaseMediaPlayer paramAnonymousBaseMediaPlayer)
      {
        AppMethodBeat.i(137105);
        ac.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
        AppMethodBeat.o(137105);
      }
      
      public final void onStateChanged(BaseMediaPlayer paramAnonymousBaseMediaPlayer, final int paramAnonymousInt)
      {
        AppMethodBeat.i(137104);
        h.this.lso.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137099);
            String str = h.this.cQO;
            ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged state %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
            if (paramAnonymousInt == 3)
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARING!");
              h.1.b(h.1.this);
              h.this.vdi = System.currentTimeMillis();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 2)
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PREPARED!");
              ac.i("MicroMsg.Audio.QQAudioPlayer", "preparing cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - h.this.vdi) });
              h.1.a(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 4)
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STARTED!");
              ac.i("MicroMsg.Audio.QQAudioPlayer", "start cost time :%d!", new Object[] { Long.valueOf(System.currentTimeMillis() - h.this.vdi) });
              h.1.c(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 5)
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PAUSED!");
              h.1.d(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 6)
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged STOPPED!");
              h.1.e(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 7)
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged PLAYBACKCOMPLETED!");
              h.1.f(h.1.this);
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 8)
            {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged END!");
              h.1.dhR();
              AppMethodBeat.o(137099);
              return;
            }
            if (paramAnonymousInt == 9) {
              ac.i("MicroMsg.Audio.QQAudioPlayer", "onStateChanged ERROR!");
            }
            AppMethodBeat.o(137099);
          }
        });
        AppMethodBeat.o(137104);
      }
    };
    this.cQO = e.dhk();
    com.tencent.mm.plugin.music.f.a.a.djo();
    if (android.support.v4.content.b.checkSelfPermission(ai.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
      ac.e("MicroMsg.Audio.BaseAudioPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
    }
    for (;;)
    {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
      this.lso = new ao(Looper.myLooper());
      AppMethodBeat.o(137114);
      return;
      this.vcW = new bb();
      this.vcW.iR(ai.getContext());
      this.vcW.a(new g.1(this));
    }
  }
  
  private void Jp(int paramInt)
  {
    AppMethodBeat.i(137139);
    if (this.vcJ != null) {
      this.vcJ.gp(this.cZj.fromScene, paramInt);
    }
    AppMethodBeat.o(137139);
  }
  
  private void dhH()
  {
    AppMethodBeat.i(137118);
    ac.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    if ((!TextUtils.isEmpty(this.cZj.filePath)) && (this.cZj.htA == null))
    {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.cZj.filePath });
      if (this.vda == null) {
        this.vda = new CommonPlayer(this.vdj);
      }
      this.vda.reset();
    }
    for (;;)
    {
      try
      {
        this.vda.setDataSource(this.cZj.filePath);
        this.vda.prepare();
        float f = 0.0F;
        if (this.cZj != null) {
          f = (float)this.cZj.htq;
        }
        if (this.vda == null) {
          break label613;
        }
        if ((f < 0.5F) || (f > 2.0F)) {
          break;
        }
        ac.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Float.valueOf(f) });
        this.vda.setSpeed(f);
        AppMethodBeat.o(137118);
        return;
      }
      catch (Exception localException1)
      {
        ac.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer exception", new Object[0]);
        Jo(501);
        Jp(501);
        continue;
      }
      if ((!TextUtils.isEmpty(this.cZj.filePath)) && (this.cZj.htA != null))
      {
        ac.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.cZj.filePath });
        if (this.vda == null) {
          this.vda = new CommonPlayer(this.vdj);
        }
        this.vda.reset();
        com.tencent.mm.plugin.music.g.b localb = new com.tencent.mm.plugin.music.g.b(this.cZj.htA);
        try
        {
          this.vda.setDataSource(localb);
          this.vda.prepare();
        }
        catch (Exception localException2)
        {
          ac.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException2.getMessage());
          ac.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer", new Object[0]);
          Jo(501);
          Jp(501);
        }
      }
      else
      {
        ac.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.cZj.cRZ });
        dhI();
        try
        {
          URL localURL = new URL(this.cRq);
          if (localURL == null)
          {
            ac.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
            Jo(500);
            Jp(500);
            AppMethodBeat.o(137118);
            return;
          }
        }
        catch (Exception localException3)
        {
          Object localObject;
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
            localObject = null;
          }
          if (this.vda == null) {
            this.vda = new CommonPlayer(this.vdj);
          }
          this.vda.reset();
          if (this.vdf == null) {
            this.vdf = new com.tencent.mm.plugin.music.g.a.b();
          }
          this.vdf.hZ(this.cRq, this.cZj.htz);
          try
          {
            this.vda.setDataSource(this.vdf, Uri.parse(localObject.toString()));
            this.vda.prepare();
          }
          catch (Exception localException4)
          {
            ac.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + localException4.getMessage());
            ac.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException4, "initPlayer", new Object[0]);
            Jo(501);
            Jp(501);
          }
        }
      }
    }
    this.vda.setSpeed(1.0F);
    label613:
    AppMethodBeat.o(137118);
  }
  
  private void dhI()
  {
    AppMethodBeat.i(137119);
    this.cRq = this.cZj.cRZ;
    if (com.tencent.mm.plugin.music.h.e.anS(this.cRq)) {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
    }
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.cRq });
      com.tencent.mm.plugin.music.cache.g.ano(this.cRq);
      com.tencent.mm.plugin.music.cache.g.br(this.cRq, bool);
      AppMethodBeat.o(137119);
      return;
    }
  }
  
  private void dhN()
  {
    AppMethodBeat.i(137134);
    try
    {
      if (this.vda != null)
      {
        this.vda.setVolume(0.0F, 0.0F);
        this.vda.stop();
      }
      if (this.vde != null)
      {
        this.vde.isStop = true;
        this.vde = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
        Jo(504);
        Jp(504);
      }
    }
    this.vdc = false;
    this.vdd = true;
    this.gcd = System.currentTimeMillis();
    AppMethodBeat.o(137134);
  }
  
  public final void a(d.a parama) {}
  
  public final boolean aGv()
  {
    AppMethodBeat.i(137123);
    if (this.vda != null)
    {
      if (this.vda.getPlayerState() == 4)
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
  
  public final boolean aGx()
  {
    AppMethodBeat.i(137129);
    if ((this.vdc) && (!cDT()))
    {
      AppMethodBeat.o(137129);
      return true;
    }
    AppMethodBeat.o(137129);
    return false;
  }
  
  public final void anf(String paramString)
  {
    AppMethodBeat.i(137115);
    ac.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.cQO = paramString;
    AppMethodBeat.o(137115);
  }
  
  public final void b(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137116);
    this.cZj = paramb;
    this.cSh = paramb.cSh;
    this.autoPlay = paramb.htn;
    if ((this.vda != null) && (aGv()))
    {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.cQO, this.cRq, Double.valueOf(this.cZj.htp) });
      this.vda.setVolume((float)this.cZj.htp, (float)this.cZj.htp);
      if (this.cZj.htq > 0.0D)
      {
        ac.i("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Double.valueOf(this.cZj.htq) });
        this.vda.setSpeed((float)this.cZj.htq);
        AppMethodBeat.o(137116);
        return;
      }
      this.vda.setSpeed(1.0F);
    }
    AppMethodBeat.o(137116);
  }
  
  public final void b(d.a parama) {}
  
  public final boolean blh()
  {
    AppMethodBeat.i(137125);
    if (this.vda != null)
    {
      if (this.vda.getPlayerState() == 2)
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
  
  public final boolean cDT()
  {
    AppMethodBeat.i(137124);
    if (this.vda != null)
    {
      if (this.vda.getPlayerState() == 3)
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
  
  public final void dhJ()
  {
    AppMethodBeat.i(137121);
    ac.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    pause();
    AppMethodBeat.o(137121);
  }
  
  public final void dhK()
  {
    AppMethodBeat.i(137130);
    ac.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.htD = true;
    this.vdd = true;
    AppMethodBeat.o(137130);
  }
  
  public final void dhL()
  {
    AppMethodBeat.i(137131);
    ac.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.htD = true;
    dhN();
    AppMethodBeat.o(137131);
  }
  
  public final void dhM()
  {
    AppMethodBeat.i(137132);
    this.htD = false;
    this.vdd = true;
    dhD();
    this.gcd = System.currentTimeMillis();
    AppMethodBeat.o(137132);
  }
  
  public final int dhO()
  {
    AppMethodBeat.i(137135);
    if (this.vda != null)
    {
      int i = (int)this.vda.getCurrentPosition();
      AppMethodBeat.o(137135);
      return i;
    }
    AppMethodBeat.o(137135);
    return -1;
  }
  
  public final com.tencent.mm.ai.d dhP()
  {
    boolean bool1 = false;
    AppMethodBeat.i(137138);
    if (this.vdb == null) {
      this.vdb = new com.tencent.mm.ai.d();
    }
    int k = getDuration();
    int m = dhO();
    boolean bool2 = aGv();
    if (this.vda != null) {}
    for (int j = this.vda.getBufferedPercentage();; j = 0)
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
      this.vdb.cZi = m;
      this.vdb.duration = k;
      com.tencent.mm.ai.d locald = this.vdb;
      if (bool2) {}
      for (;;)
      {
        locald.rM = bool1;
        this.vdb.htD = this.htD;
        this.vdb.htE = (j * k / 100);
        if (this.cZj == null) {
          break;
        }
        this.vdb.cSh = this.cZj.htm;
        this.vdb.cQK = this.cZj.cRZ;
        this.vdb.hty = this.cZj.hty;
        locald = this.vdb;
        AppMethodBeat.o(137138);
        return locald;
        bool1 = true;
      }
      AppMethodBeat.o(137138);
      return null;
    }
  }
  
  public final void dhQ()
  {
    AppMethodBeat.i(137141);
    if ((this.cQO.equalsIgnoreCase(this.cZj.cQO)) && (this.vda != null) && (aGv()))
    {
      int i = (int)this.vda.getCurrentPosition();
      int j = this.vda.getDuration();
      if ((i > 0) && (j > 0) && (this.vcY != null)) {
        this.vcY.eV(i, j);
      }
    }
    AppMethodBeat.o(137141);
  }
  
  public final boolean dhw()
  {
    return true;
  }
  
  public final String dhy()
  {
    return this.cQO;
  }
  
  public final String getAppId()
  {
    if (this.cZj != null) {
      return this.cZj.appId;
    }
    return "";
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137136);
    if (this.vda != null)
    {
      int i = this.vda.getDuration();
      AppMethodBeat.o(137136);
      return i;
    }
    AppMethodBeat.o(137136);
    return -1;
  }
  
  public final boolean isCompleted()
  {
    AppMethodBeat.i(137127);
    if (this.vda != null)
    {
      if (this.vda.getPlayerState() == 7)
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
    if (this.vda != null)
    {
      if (this.vda.getPlayerState() == 5)
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
    if (this.vda != null)
    {
      if (this.vda.getPlayerState() == 6)
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
  
  public final void l(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(137117);
    if (paramb == null)
    {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      dhG();
      AppMethodBeat.o(137117);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.vdg;
    if ((this.cZj != null) && (this.cZj.e(paramb)) && (l2 <= 100L))
    {
      this.cZj = paramb;
      this.cSh = paramb.cSh;
      this.autoPlay = paramb.htn;
      ac.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.cRq, Long.valueOf(l2) });
      AppMethodBeat.o(137117);
      return;
    }
    this.vcJ = ((com.tencent.mm.plugin.music.b.a.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.b.a.d.class));
    if (this.vcJ != null) {
      this.vcJ.Jr(paramb.fromScene);
    }
    this.vdg = l1;
    this.cZj = paramb;
    ac.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.cZj.fromScene), this.cQO });
    if ((this.vda != null) && (aGv())) {
      this.vda.stop();
    }
    this.bvh = 0;
    this.cSh = paramb.cSh;
    this.autoPlay = paramb.htn;
    this.audioType = null;
    this.vdh = false;
    this.htD = false;
    this.vdd = false;
    dhH();
    AppMethodBeat.o(137117);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137120);
    ac.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.cQO });
    this.vdd = true;
    if ((this.vda != null) && (aGv())) {
      try
      {
        ac.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.vda.pause();
        AppMethodBeat.o(137120);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        Jo(503);
        Jp(503);
        AppMethodBeat.o(137120);
        return;
      }
    }
    if ((this.vda != null) && (isCompleted()))
    {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.vdc = false;
    }
    AppMethodBeat.o(137120);
  }
  
  public final boolean pl(int paramInt)
  {
    AppMethodBeat.i(137137);
    int i = getDuration();
    ac.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i < 0)
    {
      ac.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      stopPlay();
      AppMethodBeat.o(137137);
      return false;
    }
    if (paramInt > i)
    {
      ac.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137137);
      return false;
    }
    if (this.vda != null)
    {
      ac.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
      w localw = new w();
      localw.cZm.action = 10;
      localw.cZm.state = "seeking";
      localw.cZm.cQO = dhy();
      localw.cZm.appId = getAppId();
      com.tencent.mm.sdk.b.a.GpY.a(localw, Looper.getMainLooper());
      this.vda.seekTo(paramInt);
    }
    AppMethodBeat.o(137137);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(137140);
    ac.i("MicroMsg.Audio.QQAudioPlayer", "release");
    this.vcP = null;
    if (this.vda != null)
    {
      this.vda.release();
      this.vda = null;
    }
    dhv();
    AppMethodBeat.o(137140);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137122);
    this.bvh = 0;
    boolean bool1 = cDT();
    boolean bool2 = aGv();
    this.vdd = false;
    this.htD = false;
    ac.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.vdc), this.cQO });
    if ((this.vda != null) && (!blh()) && (!bool1) && (!bool2) && (!this.vdc))
    {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.cSh = 0;
      this.autoPlay = true;
      dhH();
      if (this.vcJ != null)
      {
        this.vcJ.Jr(this.cZj.fromScene);
        AppMethodBeat.o(137122);
      }
    }
    else if ((this.vda != null) && ((isPaused()) || (blh())) && (!bool2))
    {
      ac.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
    }
    try
    {
      this.vda.setVolume((float)this.cZj.htp, (float)this.cZj.htp);
      this.vda.start();
      this.vdc = true;
      AppMethodBeat.o(137122);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        Jo(502);
        Jp(502);
      }
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137133);
    ac.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.htD = false;
    dhN();
    AppMethodBeat.o(137133);
  }
  
  final class a
    implements Runnable
  {
    boolean isStop = true;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(137113);
      ac.i("MicroMsg.Audio.QQAudioPlayer", "start run play progress task");
      for (;;)
      {
        if (!this.isStop) {
          try
          {
            if ((h.this.vda != null) && (h.this.aGv())) {
              h.this.dhQ();
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
              ac.e("MicroMsg.Audio.QQAudioPlayer", "PlayProgressTask run exception:" + localException.getMessage());
            }
          }
        }
      }
      AppMethodBeat.o(137113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.h
 * JD-Core Version:    0.7.0.1
 */