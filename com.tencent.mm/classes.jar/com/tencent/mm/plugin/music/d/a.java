package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.aw.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends com.tencent.mm.plugin.music.e.a
  implements d.a, e.a
{
  boolean LJC;
  private long LJG;
  f LLa;
  private com.tencent.mm.aw.c LLb;
  int LLc;
  v LLd;
  private com.google.android.exoplayer2.g.c LLe;
  private l LLf;
  private g.a LLg;
  private k LLh;
  f LLi;
  a LLj;
  e LLk;
  d LLl;
  b LLm;
  boolean LLn;
  public boolean LLo;
  boolean dcs;
  int diT;
  private String hrl;
  Handler mainHandler;
  int startTime;
  private long startTimeMs;
  protected String userAgent;
  
  public a()
  {
    AppMethodBeat.i(137252);
    this.LLc = 0;
    this.hrl = "";
    this.diT = 0;
    this.startTime = 0;
    this.LJG = 0L;
    this.dcs = false;
    this.LLi = new f((byte)0);
    this.LLj = new a((byte)0);
    this.LLk = new e((byte)0);
    this.LLl = new d((byte)0);
    this.LLm = new c();
    this.mainHandler = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(137225);
        if (100 == paramAnonymousMessage.what)
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(a.this.LLd.getDuration()), Long.valueOf(a.this.LLd.getCurrentPosition()), Long.valueOf(a.this.LLd.QF()), Long.valueOf(a.this.LLd.getBufferedPercentage()) });
          a.this.mainHandler.removeMessages(100);
          if (a.this.LJC) {
            a.this.mainHandler.sendEmptyMessageDelayed(100, 5000L);
          }
        }
        AppMethodBeat.o(137225);
      }
    };
    this.LLn = false;
    this.LLo = false;
    com.tencent.mm.plugin.music.e.b.a.goC();
    AppMethodBeat.o(137252);
  }
  
  private void b(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137274);
    if (this.LNM != null) {
      this.LNM.d(paramf, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137274);
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(137269);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.LNL = "error";
    ox localox = new ox();
    localox.hRN.action = 4;
    localox.hRN.hRG = paramf;
    localox.hRN.state = "error";
    localox.hRN.duration = getDuration();
    localox.hRN.hRO = true;
    paramf = localox.hRN;
    Log.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
    StringBuilder localStringBuilder;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
      paramf.errCode = paramInt1;
      paramf = localox.hRN;
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
      localox.asyncPublish(Looper.getMainLooper());
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
    com.tencent.mm.plugin.music.e.b.a.a(paramMetadata, "  ");
    Log.i("MicroMsg.Music.ExoMusicPlayer", "]");
    AppMethodBeat.o(137272);
  }
  
  public final boolean bLk()
  {
    AppMethodBeat.i(137259);
    if (this.LLd == null)
    {
      AppMethodBeat.o(137259);
      return false;
    }
    switch (this.LLd.QC())
    {
    case 2: 
    default: 
      AppMethodBeat.o(137259);
      return false;
    }
    boolean bool = this.LLd.QD();
    AppMethodBeat.o(137259);
    return bool;
  }
  
  public final boolean bLl()
  {
    return (this.LJC) && (this.LLo);
  }
  
  public final boolean bLm()
  {
    AppMethodBeat.i(137261);
    if ((this.LJC) && (!cNW()))
    {
      AppMethodBeat.o(137261);
      return true;
    }
    AppMethodBeat.o(137261);
    return false;
  }
  
  final boolean cNW()
  {
    AppMethodBeat.i(137260);
    if (this.LLd != null)
    {
      boolean bool = this.LLd.isLoading();
      AppMethodBeat.o(137260);
      return bool;
    }
    AppMethodBeat.o(137260);
    return false;
  }
  
  final String cwI()
  {
    AppMethodBeat.i(137273);
    String str = com.tencent.mm.plugin.music.e.b.a.jM(SystemClock.elapsedRealtime() - this.startTimeMs);
    AppMethodBeat.o(137273);
    return str;
  }
  
  public final int getDownloadPercent()
  {
    AppMethodBeat.i(137265);
    if (this.LLd != null)
    {
      int i = this.LLd.getBufferedPercentage();
      AppMethodBeat.o(137265);
      return i;
    }
    AppMethodBeat.o(137265);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137264);
    if (this.LLd != null)
    {
      int i = (int)this.LLd.getDuration();
      AppMethodBeat.o(137264);
      return i;
    }
    AppMethodBeat.o(137264);
    return 0;
  }
  
  public final int gmA()
  {
    AppMethodBeat.i(137263);
    if (this.LLd != null)
    {
      int i = (int)this.LLd.getCurrentPosition();
      AppMethodBeat.o(137263);
      return i;
    }
    AppMethodBeat.o(137263);
    return 0;
  }
  
  public final void gmZ()
  {
    AppMethodBeat.i(137254);
    this.LNM = ((com.tencent.mm.plugin.music.logic.d)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.d.class));
    this.LNN = com.tencent.mm.plugin.music.logic.j.gnw().LLw;
    AppMethodBeat.o(137254);
  }
  
  public final void gmh()
  {
    AppMethodBeat.i(137256);
    this.LLo = true;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.LLd != null)
    {
      this.LLc = 2;
      this.LLd.bv(false);
    }
    AppMethodBeat.o(137256);
  }
  
  public final boolean gmi()
  {
    return true;
  }
  
  public final com.tencent.mm.aw.c gmj()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137267);
    int n = getDuration();
    int i1 = gmA();
    boolean bool = bLk();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.LLh instanceof h))
    {
      j = n;
      if (!this.dcs) {
        j = 0;
      }
    }
    com.tencent.mm.aw.c localc;
    if (this.LLb != null)
    {
      localc = this.LLb;
      if (bool) {
        k = 1;
      }
      localc.B(j, i1, k, i);
    }
    for (;;)
    {
      this.LLb.hRO = true;
      this.LLb.mLR = got();
      localc = this.LLb;
      AppMethodBeat.o(137267);
      return localc;
      k = m;
      if (bool) {
        k = 1;
      }
      this.LLb = new com.tencent.mm.aw.c(j, i1, k, i);
    }
  }
  
  public final void gmu()
  {
    AppMethodBeat.i(137257);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    com.tencent.mm.plugin.music.logic.j.gny().cyG();
    AppMethodBeat.o(137257);
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(137253);
    super.h(paramf);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.LJG;
    if ((this.LLa != null) && (this.LLa.f(paramf)) && (l2 <= 1000L))
    {
      this.LLa = paramf;
      Log.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.hrl, Long.valueOf(l2) });
      AppMethodBeat.o(137253);
      return;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      AppMethodBeat.o(137253);
      return;
    }
    if (this.LNM != null) {
      this.LNM.z(paramf);
    }
    this.LJG = l1;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.startTime) });
    if ((this.LLd != null) && (bLk())) {
      this.LLd.stop();
    }
    this.diT = 0;
    this.startTime = paramf.startTime;
    this.startTimeMs = SystemClock.elapsedRealtime();
    this.LLa = paramf;
    L(this.LLa);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.startTime) });
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
  
  final void jZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137270);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.LLm != null) {
      this.LLm.kb(paramInt1, paramInt2);
    }
    AppMethodBeat.o(137270);
  }
  
  final void ka(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137271);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.LLm != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.LLm.adt(paramInt2);
    }
    AppMethodBeat.o(137271);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137255);
    this.LLo = false;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.LLd != null)
    {
      this.LLc = 2;
      this.LLd.bv(false);
    }
    AppMethodBeat.o(137255);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137268);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "release");
    this.mainHandler.removeMessages(100);
    gmg();
    if (this.LLd != null)
    {
      this.LLd.b(this.LLj);
      this.LLd.cHr.remove(this);
      this.LLd.release();
      this.LLd = null;
    }
    if (this.LLh != null)
    {
      this.LLh.SV();
      this.LLh = null;
    }
    this.LLe = null;
    this.LLg = null;
    AppMethodBeat.o(137268);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137258);
    this.diT = 0;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(cNW()), Boolean.valueOf(bLk()) });
    if (this.LLd != null)
    {
      if (!com.tencent.mm.plugin.music.logic.j.gny().requestFocus()) {
        break label92;
      }
      this.LLc = 1;
      this.LLd.bv(true);
      O(this.LLa);
    }
    for (;;)
    {
      this.LJC = true;
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
      if (this.LLd != null)
      {
        this.LLc = 3;
        this.LLd.bv(false);
        this.LLd.stop();
        Q(this.LLa);
      }
      com.tencent.mm.plugin.music.logic.j.gny().cyG();
      this.LJC = false;
      this.LLo = false;
      this.mainHandler.removeMessages(100);
      AppMethodBeat.o(137262);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.LLa, 504);
        b(this.LLa, -4005, -42);
      }
    }
  }
  
  public final boolean wH(int paramInt)
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
    if (this.LLd != null)
    {
      S(this.LLa);
      f localf = this.LLi;
      if ((this.LLi.sGB[3] & 0xF0000000) != 0) {
        bool = true;
      }
      localf.r(bool, 100);
      this.LLc = 4;
      this.LLd.seekTo(paramInt);
    }
    AppMethodBeat.o(137266);
    return true;
  }
  
  final class a
    implements f.a
  {
    private a() {}
    
    public final void onLoadingChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(137227);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
      if ((!paramBoolean) && (a.this.LLn))
      {
        a.this.LLn = false;
        a.b(a.this);
      }
      AppMethodBeat.o(137227);
    }
    
    public final void onPlaybackParametersChanged(p paramp)
    {
      AppMethodBeat.i(137231);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.cHk), Float.valueOf(paramp.pitch) }));
      AppMethodBeat.o(137231);
    }
    
    public final void onPlayerError(com.google.android.exoplayer2.e parame)
    {
      AppMethodBeat.i(137229);
      Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + a.this.cwI() + "]", new Object[0]);
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
            locala.jZ(-4000, -2);
            AppMethodBeat.o(137229);
            return;
          }
          locala.jZ(-4000, -3);
          AppMethodBeat.o(137229);
          return;
        }
        if ((localObject instanceof s.e))
        {
          localObject = ((Throwable)localObject).toString();
          if (!((String)localObject).contains("403")) {
            break label210;
          }
          locala.jZ(-4000, -10);
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
          locala.jZ(-4000, -11);
        }
        else if (((String)localObject).contains("500"))
        {
          locala.jZ(-4000, -12);
        }
        else if (((String)localObject).contains("502"))
        {
          locala.jZ(-4000, -13);
        }
        else
        {
          locala.jZ(-4000, -30);
          continue;
          if ((localObject instanceof s))
          {
            locala.jZ(-4001, -1);
          }
          else if ((localObject instanceof IllegalStateException))
          {
            locala.jZ(-4002, -1);
          }
          else if ((localObject instanceof b.a))
          {
            locala.jZ(-4003, -1);
          }
          else
          {
            locala.jZ(-4999, -1);
            continue;
            label356:
            locala.jZ(-4999, -1);
          }
        }
      }
    }
    
    public final void onPlayerStateChanged(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137228);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.cwI() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.e.b.a.adL(paramInt) + "]");
      a locala = a.this;
      if (locala.LLd != null)
      {
        paramBoolean = locala.LLd.QD();
        paramInt = locala.LLd.QC();
        if ((paramBoolean) && (paramInt == 3))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
          if (locala.LLm != null) {
            locala.LLm.gnb();
          }
        }
        for (;;)
        {
          int i = a.f.s(paramBoolean, paramInt);
          if (i == locala.LLi.sGB[3]) {
            break label617;
          }
          Log.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
          locala.LLi.r(paramBoolean, paramInt);
          if (i != a.f.s(true, 4)) {
            break;
          }
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
          if (locala.LLm != null) {
            locala.LLm.gnf();
          }
          AppMethodBeat.o(137228);
          return;
          if ((!paramBoolean) && (paramInt == 3) && (locala.LLc == 2))
          {
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (locala.LLm != null) {
              locala.LLm.gnc();
            }
          }
          else if ((!paramBoolean) && (paramInt == 3) && (locala.LLc == 3))
          {
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (locala.LLm != null) {
              locala.LLm.gnd();
            }
          }
        }
        if (locala.LLi.b(new int[] { a.f.s(false, 1), a.f.s(false, 2), a.f.s(false, 3) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
          if (locala.LLm != null) {
            locala.LLm.gna();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if ((locala.LLi.b(new int[] { 100, 2, 3 }, true) | locala.LLi.b(new int[] { 2, 100, 3 }, true) | locala.LLi.b(new int[] { 100, 3, 2, 3 }, true)))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
          if (locala.LLm != null) {
            locala.LLm.gne();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.LLi.b(new int[] { a.f.s(true, 3), a.f.s(true, 2) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
          locala.ka(701, locala.getDownloadPercent());
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.LLi.b(new int[] { a.f.s(true, 2), a.f.s(true, 3) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
          locala.ka(702, locala.getDownloadPercent());
        }
      }
      label617:
      AppMethodBeat.o(137228);
    }
    
    public final void onPositionDiscontinuity()
    {
      AppMethodBeat.i(137230);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
      AppMethodBeat.o(137230);
    }
    
    public final void onRepeatModeChanged(int paramInt) {}
    
    public final void onTimelineChanged(w paramw, Object paramObject) {}
    
    public final void onTracksChanged(r paramr, g paramg) {}
  }
  
  public static abstract interface b
  {
    public abstract void adt(int paramInt);
    
    public abstract void gna();
    
    public abstract void gnb();
    
    public abstract void gnc();
    
    public abstract void gnd();
    
    public abstract void gne();
    
    public abstract void gnf();
    
    public abstract void kb(int paramInt1, int paramInt2);
  }
  
  public final class c
    implements a.b
  {
    public c() {}
    
    public final void adt(int paramInt)
    {
      AppMethodBeat.i(137238);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137238);
    }
    
    public final void gna()
    {
      AppMethodBeat.i(137232);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
      if (a.this.LLa != null) {
        a.this.M(a.this.LLa);
      }
      if (a.this.startTime > 0)
      {
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(a.this.startTime) });
        a.this.wH(a.this.startTime);
      }
      if ((a.this.startTime == 0) && (!a.this.LLd.QD()))
      {
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
        a.this.LLd.bv(true);
      }
      AppMethodBeat.o(137232);
    }
    
    public final void gnb()
    {
      AppMethodBeat.i(137233);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
      if (a.this.LLa != null) {
        a.this.N(a.this.LLa);
      }
      AppMethodBeat.o(137233);
    }
    
    public final void gnc()
    {
      AppMethodBeat.i(137234);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
      if ((a.this.LLa != null) && (!a.this.LLd.QD())) {
        a.this.P(a.this.LLa);
      }
      AppMethodBeat.o(137234);
    }
    
    public final void gnd()
    {
      AppMethodBeat.i(137235);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
      if (a.this.LLa != null) {
        a.this.Q(a.this.LLa);
      }
      AppMethodBeat.o(137235);
    }
    
    public final void gne()
    {
      AppMethodBeat.i(137236);
      if (a.this.cNW())
      {
        a.this.LLn = true;
        AppMethodBeat.o(137236);
        return;
      }
      a.b(a.this);
      AppMethodBeat.o(137236);
    }
    
    public final void gnf()
    {
      AppMethodBeat.i(137237);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
      if (a.this.LLa != null) {
        a.this.T(a.this.LLa);
      }
      a.this.LJC = false;
      a.this.mainHandler.removeMessages(100);
      AppMethodBeat.o(137237);
    }
    
    public final void kb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(137239);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (a.this.LLa != null) {
        a.this.a(a.this.LLa, paramInt1, paramInt2);
      }
      if (a.this.LLd != null)
      {
        a.this.LLd.bv(false);
        a.this.LLd.stop();
      }
      a.this.LJC = false;
      a.this.mainHandler.removeMessages(100);
      a locala = a.this;
      locala.diT += 1;
      if (a.this.diT == 1) {
        a.a(a.this, a.this.LLa, paramInt1, paramInt2);
      }
      AppMethodBeat.o(137239);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.source.b, h.a
  {
    private d() {}
    
    public final void SM()
    {
      AppMethodBeat.i(137243);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
      a.this.dcs = true;
      AppMethodBeat.o(137243);
    }
    
    public final void a(int paramInt, Format paramFormat, long paramLong) {}
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(270903);
      a.a(a.this, "loadError", paramIOException);
      if ((paramj != null) && (paramFormat != null)) {
        Log.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      a.c(a.this);
      AppMethodBeat.o(270903);
    }
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void b(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(177348);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
      AppMethodBeat.o(177348);
    }
    
    public final void c(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(137242);
      a.a(a.this, "loadError", paramIOException);
      Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", paramIOException, "onLoadError", new Object[0]);
      a.c(a.this);
      AppMethodBeat.o(137242);
    }
  }
  
  final class e
    implements com.google.android.exoplayer2.a.e
  {
    private e() {}
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137244);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.cwI() + "]");
      AppMethodBeat.o(137244);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137246);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.cwI() + ", " + paramString + "]");
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
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.cwI() + ", " + Format.a(paramFormat) + "]");
      AppMethodBeat.o(137247);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137248);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.cwI() + "]");
      AppMethodBeat.o(137248);
    }
    
    public final void hl(int paramInt)
    {
      AppMethodBeat.i(137245);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + paramInt + "]");
      AppMethodBeat.o(137245);
    }
  }
  
  static final class f
  {
    int[] sGB;
    
    private f()
    {
      AppMethodBeat.i(137250);
      this.sGB = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(137250);
    }
    
    static int s(boolean paramBoolean, int paramInt)
    {
      if (paramBoolean) {}
      for (int i = -268435456;; i = 0) {
        return i | paramInt;
      }
    }
    
    final boolean b(int[] paramArrayOfInt, boolean paramBoolean)
    {
      int i;
      int j;
      if (paramBoolean)
      {
        i = 268435455;
        int k = this.sGB.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.sGB.length) {
          return paramBoolean;
        }
        if ((this.sGB[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
    
    final void r(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137251);
      int i = s(paramBoolean, paramInt);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.sGB[3] + ",newState=" + i);
      if (this.sGB[3] == i)
      {
        AppMethodBeat.o(137251);
        return;
      }
      this.sGB[0] = this.sGB[1];
      this.sGB[1] = this.sGB[2];
      this.sGB[2] = this.sGB[3];
      this.sGB[3] = i;
      Log.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.sGB[0] + "," + this.sGB[1] + "," + this.sGB[2] + "," + this.sGB[3] + "]");
      AppMethodBeat.o(137251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */