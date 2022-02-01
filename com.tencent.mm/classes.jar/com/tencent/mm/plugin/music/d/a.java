package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends com.tencent.mm.plugin.music.f.a
  implements d.a, e.a
{
  boolean AhL;
  private long AhP;
  f Ajg;
  private com.tencent.mm.ay.c Ajh;
  int Aji;
  v Ajj;
  private com.google.android.exoplayer2.g.c Ajk;
  private l Ajl;
  private g.a Ajm;
  private com.google.android.exoplayer2.source.k Ajn;
  f Ajo;
  a Ajp;
  e Ajq;
  d Ajr;
  b Ajs;
  boolean Ajt;
  public boolean Aju;
  Handler aDv;
  int bFM;
  boolean byX;
  private String dus;
  int dvv;
  private long startTimeMs;
  protected String userAgent;
  
  public a()
  {
    AppMethodBeat.i(137252);
    this.Aji = 0;
    this.dus = "";
    this.bFM = 0;
    this.dvv = 0;
    this.AhP = 0L;
    this.byX = false;
    this.Ajo = new f((byte)0);
    this.Ajp = new a((byte)0);
    this.Ajq = new e((byte)0);
    this.Ajr = new d((byte)0);
    this.Ajs = new c();
    this.aDv = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(137225);
        if (100 == paramAnonymousMessage.what)
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(a.this.Ajj.getDuration()), Long.valueOf(a.this.Ajj.getCurrentPosition()), Long.valueOf(a.this.Ajj.getBufferedPosition()), Long.valueOf(a.this.Ajj.getBufferedPercentage()) });
          a.this.aDv.removeMessages(100);
          if (a.this.AhL) {
            a.this.aDv.sendEmptyMessageDelayed(100, 5000L);
          }
        }
        AppMethodBeat.o(137225);
      }
    };
    this.Ajt = false;
    this.Aju = false;
    com.tencent.mm.plugin.music.f.b.a.euZ();
    AppMethodBeat.o(137252);
  }
  
  private void b(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137274);
    if (this.AlJ != null) {
      this.AlJ.d(paramf, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137274);
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(137269);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.AlI = "error";
    mx localmx = new mx();
    localmx.dSE.action = 4;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "error";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = true;
    paramf = localmx.dSE;
    Log.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
    StringBuilder localStringBuilder;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
      paramf.errCode = paramInt1;
      paramf = localmx.dSE;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errCode:" + paramInt2 + ", err:");
      switch (paramInt2)
      {
      }
      break;
    }
    for (;;)
    {
      paramf.errMsg = localStringBuilder.toString();
      EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
      AppMethodBeat.o(137269);
      return;
      paramInt1 = 10002;
      break;
      paramInt1 = 10004;
      break;
      paramInt1 = 10001;
      break;
      paramInt1 = -1;
      break;
      localStringBuilder.append(" no network");
      continue;
      localStringBuilder.append("connect fail");
      continue;
      localStringBuilder.append(" network respCode 403");
      continue;
      localStringBuilder.append(" network respCode 404");
      continue;
      localStringBuilder.append(" network respCode 500");
      continue;
      localStringBuilder.append(" network respCode 502");
      continue;
      localStringBuilder.append(" network error");
      continue;
      localStringBuilder.append("UnrecognizedInputFormatException");
      continue;
      localStringBuilder.append("illegal state exception");
      continue;
      localStringBuilder.append("MediaCodec decoder init exception");
      continue;
      localStringBuilder.append("load error");
      continue;
      localStringBuilder.append("prepare error");
      continue;
      localStringBuilder.append("stop error");
      continue;
      localStringBuilder.append("error url format");
      continue;
      localStringBuilder.append("unknow exception");
    }
  }
  
  public final void b(Metadata paramMetadata)
  {
    AppMethodBeat.i(137272);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
    com.tencent.mm.plugin.music.f.b.a.a(paramMetadata, "  ");
    Log.i("MicroMsg.Music.ExoMusicPlayer", "]");
    AppMethodBeat.o(137272);
  }
  
  public final boolean bec()
  {
    AppMethodBeat.i(137259);
    if (this.Ajj == null)
    {
      AppMethodBeat.o(137259);
      return false;
    }
    switch (this.Ajj.ti())
    {
    case 2: 
    default: 
      AppMethodBeat.o(137259);
      return false;
    }
    boolean bool = this.Ajj.tj();
    AppMethodBeat.o(137259);
    return bool;
  }
  
  public final boolean bed()
  {
    return (this.AhL) && (this.Aju);
  }
  
  public final boolean bee()
  {
    AppMethodBeat.i(137261);
    if ((this.AhL) && (!dFr()))
    {
      AppMethodBeat.o(137261);
      return true;
    }
    AppMethodBeat.o(137261);
    return false;
  }
  
  final boolean dFr()
  {
    AppMethodBeat.i(137260);
    if (this.Ajj != null)
    {
      boolean bool = this.Ajj.isLoading();
      AppMethodBeat.o(137260);
      return bool;
    }
    AppMethodBeat.o(137260);
    return false;
  }
  
  public final void esU()
  {
    AppMethodBeat.i(137256);
    this.Aju = true;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.Ajj != null)
    {
      this.Aji = 2;
      this.Ajj.aO(false);
    }
    AppMethodBeat.o(137256);
  }
  
  public final boolean esV()
  {
    return true;
  }
  
  public final com.tencent.mm.ay.c esW()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137267);
    int n = getDuration();
    int i1 = etn();
    boolean bool = bec();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.Ajn instanceof h))
    {
      j = n;
      if (!this.byX) {
        j = 0;
      }
    }
    com.tencent.mm.ay.c localc;
    if (this.Ajh != null)
    {
      localc = this.Ajh;
      if (bool) {
        k = 1;
      }
      localc.t(j, i1, k, i);
    }
    for (;;)
    {
      this.Ajh.dSG = true;
      this.Ajh.jeQ = euQ();
      localc = this.Ajh;
      AppMethodBeat.o(137267);
      return localc;
      k = m;
      if (bool) {
        k = 1;
      }
      this.Ajh = new com.tencent.mm.ay.c(j, i1, k, i);
    }
  }
  
  public final void etM()
  {
    AppMethodBeat.i(137254);
    this.AlJ = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.d.class));
    this.AlK = com.tencent.mm.plugin.music.e.k.euj().AjC;
    AppMethodBeat.o(137254);
  }
  
  final String etN()
  {
    AppMethodBeat.i(137273);
    String str = com.tencent.mm.plugin.music.f.b.a.Hq(SystemClock.elapsedRealtime() - this.startTimeMs);
    AppMethodBeat.o(137273);
    return str;
  }
  
  public final void eth()
  {
    AppMethodBeat.i(137257);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    com.tencent.mm.plugin.music.e.k.eul().bLZ();
    AppMethodBeat.o(137257);
  }
  
  public final int etn()
  {
    AppMethodBeat.i(137263);
    if (this.Ajj != null)
    {
      int i = (int)this.Ajj.getCurrentPosition();
      AppMethodBeat.o(137263);
      return i;
    }
    AppMethodBeat.o(137263);
    return 0;
  }
  
  public final int getDownloadPercent()
  {
    AppMethodBeat.i(137265);
    if (this.Ajj != null)
    {
      int i = this.Ajj.getBufferedPercentage();
      AppMethodBeat.o(137265);
      return i;
    }
    AppMethodBeat.o(137265);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137264);
    if (this.Ajj != null)
    {
      int i = (int)this.Ajj.getDuration();
      AppMethodBeat.o(137264);
      return i;
    }
    AppMethodBeat.o(137264);
    return 0;
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(137253);
    super.h(paramf);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.AhP;
    if ((this.Ajg != null) && (this.Ajg.f(paramf)) && (l2 <= 1000L))
    {
      this.Ajg = paramf;
      Log.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.dus, Long.valueOf(l2) });
      AppMethodBeat.o(137253);
      return;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      AppMethodBeat.o(137253);
      return;
    }
    if (this.AlJ != null) {
      this.AlJ.v(paramf);
    }
    this.AhP = l1;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.dvv) });
    if ((this.Ajj != null) && (bec())) {
      this.Ajj.stop();
    }
    this.bFM = 0;
    this.dvv = paramf.dvv;
    this.startTimeMs = SystemClock.elapsedRealtime();
    this.Ajg = paramf;
    G(this.Ajg);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.dvv) });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137226);
        a.a(a.this);
        AppMethodBeat.o(137226);
      }
    });
    AppMethodBeat.o(137253);
  }
  
  final void hq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137270);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.Ajs != null) {
      this.Ajs.hs(paramInt1, paramInt2);
    }
    AppMethodBeat.o(137270);
  }
  
  final void hr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137271);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.Ajs != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.Ajs.SL(paramInt2);
    }
    AppMethodBeat.o(137271);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137255);
    this.Aju = false;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.Ajj != null)
    {
      this.Aji = 2;
      this.Ajj.aO(false);
    }
    AppMethodBeat.o(137255);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137268);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "release");
    this.aDv.removeMessages(100);
    esT();
    if (this.Ajj != null)
    {
      this.Ajj.b(this.Ajp);
      this.Ajj.bdU.remove(this);
      this.Ajj.release();
      this.Ajj = null;
    }
    if (this.Ajn != null)
    {
      this.Ajn.vu();
      this.Ajn = null;
    }
    this.Ajk = null;
    this.Ajm = null;
    AppMethodBeat.o(137268);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137258);
    this.bFM = 0;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(dFr()), Boolean.valueOf(bec()) });
    if (this.Ajj != null)
    {
      if (!com.tencent.mm.plugin.music.e.k.eul().requestFocus()) {
        break label92;
      }
      this.Aji = 1;
      this.Ajj.aO(true);
      J(this.Ajg);
    }
    for (;;)
    {
      this.AhL = true;
      AppMethodBeat.o(137258);
      return;
      label92:
      Log.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137262);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
    try
    {
      if (this.Ajj != null)
      {
        this.Aji = 3;
        this.Ajj.aO(false);
        this.Ajj.stop();
        L(this.Ajg);
      }
      com.tencent.mm.plugin.music.e.k.eul().bLZ();
      this.AhL = false;
      this.Aju = false;
      this.aDv.removeMessages(100);
      AppMethodBeat.o(137262);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.Ajg, 504);
        b(this.Ajg, -4005, -42);
      }
    }
  }
  
  public final boolean tG(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(137266);
    int i = getDuration();
    Log.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      Log.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137266);
      return false;
    }
    if (this.Ajj != null)
    {
      N(this.Ajg);
      f localf = this.Ajo;
      if ((this.Ajo.mCA[3] & 0xF0000000) != 0) {
        bool = true;
      }
      localf.q(bool, 100);
      this.Aji = 4;
      this.Ajj.seekTo(paramInt);
    }
    AppMethodBeat.o(137266);
    return true;
  }
  
  final class a
    implements f.a
  {
    private a() {}
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      AppMethodBeat.i(137229);
      Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + a.this.etN() + "]", new Object[0]);
      a locala = a.this;
      Object localObject;
      if (parame != null)
      {
        localObject = parame.getCause();
        if (localObject == null) {
          break label356;
        }
        if (!(localObject instanceof s.c)) {
          break label288;
        }
        if (((Throwable)localObject).toString().contains("Unable to connect"))
        {
          boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
          Log.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + bool + " caused by:\n" + ((Throwable)localObject).toString());
          if (!bool)
          {
            locala.hq(-4000, -2);
            AppMethodBeat.o(137229);
            return;
          }
          locala.hq(-4000, -3);
          AppMethodBeat.o(137229);
          return;
        }
        if ((localObject instanceof s.e))
        {
          localObject = ((Throwable)localObject).toString();
          if (!((String)localObject).contains("403")) {
            break label210;
          }
          locala.hq(-4000, -10);
        }
      }
      label288:
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "ExoPlaybackException", new Object[0]);
        AppMethodBeat.o(137229);
        return;
        label210:
        if (((String)localObject).contains("404"))
        {
          locala.hq(-4000, -11);
        }
        else if (((String)localObject).contains("500"))
        {
          locala.hq(-4000, -12);
        }
        else if (((String)localObject).contains("502"))
        {
          locala.hq(-4000, -13);
        }
        else
        {
          locala.hq(-4000, -30);
          continue;
          if ((localObject instanceof s))
          {
            locala.hq(-4001, -1);
          }
          else if ((localObject instanceof IllegalStateException))
          {
            locala.hq(-4002, -1);
          }
          else if ((localObject instanceof b.a))
          {
            locala.hq(-4003, -1);
          }
          else
          {
            locala.hq(-4999, -1);
            continue;
            label356:
            locala.hq(-4999, -1);
          }
        }
      }
    }
    
    public final void aA(int paramInt) {}
    
    public final void aR(boolean paramBoolean)
    {
      AppMethodBeat.i(137227);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
      if ((!paramBoolean) && (a.this.Ajt))
      {
        a.this.Ajt = false;
        a.b(a.this);
      }
      AppMethodBeat.o(137227);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(137231);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.bdN), Float.valueOf(paramp.pitch) }));
      AppMethodBeat.o(137231);
    }
    
    public final void c(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137228);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.etN() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.f.b.a.Td(paramInt) + "]");
      a locala = a.this;
      if (locala.Ajj != null)
      {
        paramBoolean = locala.Ajj.tj();
        paramInt = locala.Ajj.ti();
        if ((paramBoolean) && (paramInt == 3))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
          if (locala.Ajs != null) {
            locala.Ajs.etP();
          }
        }
        for (;;)
        {
          int i = a.f.r(paramBoolean, paramInt);
          if (i == locala.Ajo.mCA[3]) {
            break label617;
          }
          Log.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
          locala.Ajo.q(paramBoolean, paramInt);
          if (i != a.f.r(true, 4)) {
            break;
          }
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
          if (locala.Ajs != null) {
            locala.Ajs.etT();
          }
          AppMethodBeat.o(137228);
          return;
          if ((!paramBoolean) && (paramInt == 3) && (locala.Aji == 2))
          {
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (locala.Ajs != null) {
              locala.Ajs.etQ();
            }
          }
          else if ((!paramBoolean) && (paramInt == 3) && (locala.Aji == 3))
          {
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (locala.Ajs != null) {
              locala.Ajs.etR();
            }
          }
        }
        if (locala.Ajo.a(new int[] { a.f.r(false, 1), a.f.r(false, 2), a.f.r(false, 3) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
          if (locala.Ajs != null) {
            locala.Ajs.etO();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if ((locala.Ajo.a(new int[] { 100, 2, 3 }, true) | locala.Ajo.a(new int[] { 2, 100, 3 }, true) | locala.Ajo.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
          if (locala.Ajs != null) {
            locala.Ajs.etS();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.Ajo.a(new int[] { a.f.r(true, 3), a.f.r(true, 2) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
          locala.hr(701, locala.getDownloadPercent());
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.Ajo.a(new int[] { a.f.r(true, 2), a.f.r(true, 3) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
          locala.hr(702, locala.getDownloadPercent());
        }
      }
      label617:
      AppMethodBeat.o(137228);
    }
    
    public final void tA()
    {
      AppMethodBeat.i(137230);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
      AppMethodBeat.o(137230);
    }
    
    public final void ty() {}
    
    public final void tz() {}
  }
  
  public static abstract interface b
  {
    public abstract void SL(int paramInt);
    
    public abstract void etO();
    
    public abstract void etP();
    
    public abstract void etQ();
    
    public abstract void etR();
    
    public abstract void etS();
    
    public abstract void etT();
    
    public abstract void hs(int paramInt1, int paramInt2);
  }
  
  public final class c
    implements a.b
  {
    public c() {}
    
    public final void SL(int paramInt)
    {
      AppMethodBeat.i(137238);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137238);
    }
    
    public final void etO()
    {
      AppMethodBeat.i(137232);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
      if (a.this.Ajg != null) {
        a.this.H(a.this.Ajg);
      }
      if (a.this.dvv > 0)
      {
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(a.this.dvv) });
        a.this.tG(a.this.dvv);
      }
      if ((a.this.dvv == 0) && (!a.this.Ajj.tj()))
      {
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
        a.this.Ajj.aO(true);
      }
      AppMethodBeat.o(137232);
    }
    
    public final void etP()
    {
      AppMethodBeat.i(137233);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
      if (a.this.Ajg != null) {
        a.this.I(a.this.Ajg);
      }
      AppMethodBeat.o(137233);
    }
    
    public final void etQ()
    {
      AppMethodBeat.i(137234);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
      if ((a.this.Ajg != null) && (!a.this.Ajj.tj())) {
        a.this.K(a.this.Ajg);
      }
      AppMethodBeat.o(137234);
    }
    
    public final void etR()
    {
      AppMethodBeat.i(137235);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
      if (a.this.Ajg != null) {
        a.this.L(a.this.Ajg);
      }
      AppMethodBeat.o(137235);
    }
    
    public final void etS()
    {
      AppMethodBeat.i(137236);
      if (a.this.dFr())
      {
        a.this.Ajt = true;
        AppMethodBeat.o(137236);
        return;
      }
      a.b(a.this);
      AppMethodBeat.o(137236);
    }
    
    public final void etT()
    {
      AppMethodBeat.i(137237);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
      if (a.this.Ajg != null) {
        a.this.O(a.this.Ajg);
      }
      a.this.AhL = false;
      a.this.aDv.removeMessages(100);
      AppMethodBeat.o(137237);
    }
    
    public final void hs(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(137239);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (a.this.Ajg != null) {
        a.this.a(a.this.Ajg, paramInt1, paramInt2);
      }
      if (a.this.Ajj != null)
      {
        a.this.Ajj.aO(false);
        a.this.Ajj.stop();
      }
      a.this.AhL = false;
      a.this.aDv.removeMessages(100);
      a locala = a.this;
      locala.bFM += 1;
      if (a.this.bFM == 1) {
        a.a(a.this, a.this.Ajg, paramInt1, paramInt2);
      }
      AppMethodBeat.o(137239);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.source.b, h.a
  {
    private d() {}
    
    public final void a(int paramInt, Format paramFormat, long paramLong) {}
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(177347);
      a.a(a.this, "loadError", paramIOException);
      if ((paramj != null) && (paramFormat != null)) {
        Log.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      a.c(a.this);
      AppMethodBeat.o(177347);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(177348);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
      AppMethodBeat.o(177348);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(137242);
      a.a(a.this, "loadError", paramIOException);
      Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", paramIOException, "onLoadError", new Object[0]);
      a.c(a.this);
      AppMethodBeat.o(137242);
    }
    
    public final void vl()
    {
      AppMethodBeat.i(137243);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
      a.this.byX = true;
      AppMethodBeat.o(137243);
    }
  }
  
  final class e
    implements com.google.android.exoplayer2.a.e
  {
    private e() {}
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137244);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.etN() + "]");
      AppMethodBeat.o(137244);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137246);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.etN() + ", " + paramString + "]");
      AppMethodBeat.o(137246);
    }
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137249);
      a.a(a.this, "audioTrackUnderrun [" + paramInt + ", " + paramLong1 + ", " + paramLong2 + "]", null);
      AppMethodBeat.o(137249);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(137247);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.etN() + ", " + Format.a(paramFormat) + "]");
      AppMethodBeat.o(137247);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137248);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.etN() + "]");
      AppMethodBeat.o(137248);
    }
    
    public final void dG(int paramInt)
    {
      AppMethodBeat.i(137245);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + paramInt + "]");
      AppMethodBeat.o(137245);
    }
  }
  
  static final class f
  {
    int[] mCA;
    
    private f()
    {
      AppMethodBeat.i(137250);
      this.mCA = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(137250);
    }
    
    static int r(boolean paramBoolean, int paramInt)
    {
      if (paramBoolean) {}
      for (int i = -268435456;; i = 0) {
        return i | paramInt;
      }
    }
    
    final boolean a(int[] paramArrayOfInt, boolean paramBoolean)
    {
      int i;
      int j;
      if (paramBoolean)
      {
        i = 268435455;
        int k = this.mCA.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.mCA.length) {
          return paramBoolean;
        }
        if ((this.mCA[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
          break label76;
        }
      }
      label76:
      for (boolean bool = true;; bool = false)
      {
        paramBoolean &= bool;
        j += 1;
        break label23;
        i = -1;
        break;
      }
      return paramBoolean;
    }
    
    final void q(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137251);
      int i = r(paramBoolean, paramInt);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.mCA[3] + ",newState=" + i);
      if (this.mCA[3] == i)
      {
        AppMethodBeat.o(137251);
        return;
      }
      this.mCA[0] = this.mCA[1];
      this.mCA[1] = this.mCA[2];
      this.mCA[2] = this.mCA[3];
      this.mCA[3] = i;
      Log.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.mCA[0] + "," + this.mCA[1] + "," + this.mCA[2] + "," + this.mCA[3] + "]");
      AppMethodBeat.o(137251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */