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
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.a.np;
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
  boolean FOH;
  private long FOL;
  f FQe;
  private com.tencent.mm.bb.c FQf;
  int FQg;
  v FQh;
  private com.google.android.exoplayer2.g.c FQi;
  private l FQj;
  private g.a FQk;
  private com.google.android.exoplayer2.source.k FQl;
  a.f FQm;
  a FQn;
  e FQo;
  d FQp;
  b FQq;
  boolean FQr;
  public boolean FQs;
  boolean biy;
  int bpq;
  Handler die;
  private String fna;
  int fod;
  private long startTimeMs;
  protected String userAgent;
  
  public a()
  {
    AppMethodBeat.i(137252);
    this.FQg = 0;
    this.fna = "";
    this.bpq = 0;
    this.fod = 0;
    this.FOL = 0L;
    this.biy = false;
    this.FQm = new a.f((byte)0);
    this.FQn = new a((byte)0);
    this.FQo = new e((byte)0);
    this.FQp = new d((byte)0);
    this.FQq = new c();
    this.die = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(137225);
        if (100 == paramAnonymousMessage.what)
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(a.this.FQh.getDuration()), Long.valueOf(a.this.FQh.getCurrentPosition()), Long.valueOf(a.this.FQh.rd()), Long.valueOf(a.this.FQh.getBufferedPercentage()) });
          a.this.die.removeMessages(100);
          if (a.this.FOH) {
            a.this.die.sendEmptyMessageDelayed(100, 5000L);
          }
        }
        AppMethodBeat.o(137225);
      }
    };
    this.FQr = false;
    this.FQs = false;
    com.tencent.mm.plugin.music.f.b.a.fft();
    AppMethodBeat.o(137252);
  }
  
  private void b(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137274);
    if (this.FSQ != null) {
      this.FSQ.d(paramf, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137274);
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(137269);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.FSP = "error";
    np localnp = new np();
    localnp.fMc.action = 4;
    localnp.fMc.fLV = paramf;
    localnp.fMc.state = "error";
    localnp.fMc.duration = getDuration();
    localnp.fMc.fMe = true;
    paramf = localnp.fMc;
    Log.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
    StringBuilder localStringBuilder;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
      paramf.errCode = paramInt1;
      paramf = localnp.fMc;
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
      EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
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
  
  final String bWw()
  {
    AppMethodBeat.i(137273);
    String str = com.tencent.mm.plugin.music.f.b.a.Hw(SystemClock.elapsedRealtime() - this.startTimeMs);
    AppMethodBeat.o(137273);
    return str;
  }
  
  public final boolean bnx()
  {
    AppMethodBeat.i(137259);
    if (this.FQh == null)
    {
      AppMethodBeat.o(137259);
      return false;
    }
    switch (this.FQh.ra())
    {
    case 2: 
    default: 
      AppMethodBeat.o(137259);
      return false;
    }
    boolean bool = this.FQh.rb();
    AppMethodBeat.o(137259);
    return bool;
  }
  
  public final boolean bny()
  {
    return (this.FOH) && (this.FQs);
  }
  
  public final boolean bnz()
  {
    AppMethodBeat.i(137261);
    if ((this.FOH) && (!cmp()))
    {
      AppMethodBeat.o(137261);
      return true;
    }
    AppMethodBeat.o(137261);
    return false;
  }
  
  final boolean cmp()
  {
    AppMethodBeat.i(137260);
    if (this.FQh != null)
    {
      boolean bool = this.FQh.isLoading();
      AppMethodBeat.o(137260);
      return bool;
    }
    AppMethodBeat.o(137260);
    return false;
  }
  
  public final void fdW()
  {
    AppMethodBeat.i(137254);
    this.FSQ = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.d.class));
    this.FSR = com.tencent.mm.plugin.music.e.k.fet().FQA;
    AppMethodBeat.o(137254);
  }
  
  public final void fde()
  {
    AppMethodBeat.i(137256);
    this.FQs = true;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.FQh != null)
    {
      this.FQg = 2;
      this.FQh.aM(false);
    }
    AppMethodBeat.o(137256);
  }
  
  public final boolean fdf()
  {
    return true;
  }
  
  public final com.tencent.mm.bb.c fdg()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137267);
    int n = getDuration();
    int i1 = fdx();
    boolean bool = bnx();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.FQl instanceof h))
    {
      j = n;
      if (!this.biy) {
        j = 0;
      }
    }
    com.tencent.mm.bb.c localc;
    if (this.FQf != null)
    {
      localc = this.FQf;
      if (bool) {
        k = 1;
      }
      localc.v(j, i1, k, i);
    }
    for (;;)
    {
      this.FQf.fMe = true;
      this.FQf.kkV = ffk();
      localc = this.FQf;
      AppMethodBeat.o(137267);
      return localc;
      k = m;
      if (bool) {
        k = 1;
      }
      this.FQf = new com.tencent.mm.bb.c(j, i1, k, i);
    }
  }
  
  public final void fdr()
  {
    AppMethodBeat.i(137257);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    com.tencent.mm.plugin.music.e.k.fev().bYq();
    AppMethodBeat.o(137257);
  }
  
  public final int fdx()
  {
    AppMethodBeat.i(137263);
    if (this.FQh != null)
    {
      int i = (int)this.FQh.getCurrentPosition();
      AppMethodBeat.o(137263);
      return i;
    }
    AppMethodBeat.o(137263);
    return 0;
  }
  
  public final int getDownloadPercent()
  {
    AppMethodBeat.i(137265);
    if (this.FQh != null)
    {
      int i = this.FQh.getBufferedPercentage();
      AppMethodBeat.o(137265);
      return i;
    }
    AppMethodBeat.o(137265);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137264);
    if (this.FQh != null)
    {
      int i = (int)this.FQh.getDuration();
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
    long l2 = l1 - this.FOL;
    if ((this.FQe != null) && (this.FQe.f(paramf)) && (l2 <= 1000L))
    {
      this.FQe = paramf;
      Log.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.fna, Long.valueOf(l2) });
      AppMethodBeat.o(137253);
      return;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      AppMethodBeat.o(137253);
      return;
    }
    if (this.FSQ != null) {
      this.FSQ.v(paramf);
    }
    this.FOL = l1;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.fod) });
    if ((this.FQh != null) && (bnx())) {
      this.FQh.stop();
    }
    this.bpq = 0;
    this.fod = paramf.fod;
    this.startTimeMs = SystemClock.elapsedRealtime();
    this.FQe = paramf;
    G(this.FQe);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.fod) });
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
  
  final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137270);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.FQq != null) {
      this.FQq.ix(paramInt1, paramInt2);
    }
    AppMethodBeat.o(137270);
  }
  
  final void iw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137271);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.FQq != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.FQq.Zi(paramInt2);
    }
    AppMethodBeat.o(137271);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137255);
    this.FQs = false;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.FQh != null)
    {
      this.FQg = 2;
      this.FQh.aM(false);
    }
    AppMethodBeat.o(137255);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137268);
    Log.i("MicroMsg.Music.ExoMusicPlayer", "release");
    this.die.removeMessages(100);
    fdd();
    if (this.FQh != null)
    {
      this.FQh.b(this.FQn);
      this.FQh.aNv.remove(this);
      this.FQh.release();
      this.FQh = null;
    }
    if (this.FQl != null)
    {
      this.FQl.ts();
      this.FQl = null;
    }
    this.FQi = null;
    this.FQk = null;
    AppMethodBeat.o(137268);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137258);
    this.bpq = 0;
    Log.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(cmp()), Boolean.valueOf(bnx()) });
    if (this.FQh != null)
    {
      if (!com.tencent.mm.plugin.music.e.k.fev().avy()) {
        break label92;
      }
      this.FQg = 1;
      this.FQh.aM(true);
      J(this.FQe);
    }
    for (;;)
    {
      this.FOH = true;
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
      if (this.FQh != null)
      {
        this.FQg = 3;
        this.FQh.aM(false);
        this.FQh.stop();
        L(this.FQe);
      }
      com.tencent.mm.plugin.music.e.k.fev().bYq();
      this.FOH = false;
      this.FQs = false;
      this.die.removeMessages(100);
      AppMethodBeat.o(137262);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.FQe, 504);
        b(this.FQe, -4005, -42);
      }
    }
  }
  
  public final boolean wG(int paramInt)
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
    if (this.FQh != null)
    {
      N(this.FQe);
      a.f localf = this.FQm;
      if ((this.FQm.pBz[3] & 0xF0000000) != 0) {
        bool = true;
      }
      localf.t(bool, 100);
      this.FQg = 4;
      this.FQh.seekTo(paramInt);
    }
    AppMethodBeat.o(137266);
    return true;
  }
  
  final class a
    implements f.a
  {
    private a() {}
    
    public final void I(int paramInt) {}
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      AppMethodBeat.i(137229);
      Log.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + a.this.bWw() + "]", new Object[0]);
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
            locala.iv(-4000, -2);
            AppMethodBeat.o(137229);
            return;
          }
          locala.iv(-4000, -3);
          AppMethodBeat.o(137229);
          return;
        }
        if ((localObject instanceof s.e))
        {
          localObject = ((Throwable)localObject).toString();
          if (!((String)localObject).contains("403")) {
            break label210;
          }
          locala.iv(-4000, -10);
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
          locala.iv(-4000, -11);
        }
        else if (((String)localObject).contains("500"))
        {
          locala.iv(-4000, -12);
        }
        else if (((String)localObject).contains("502"))
        {
          locala.iv(-4000, -13);
        }
        else
        {
          locala.iv(-4000, -30);
          continue;
          if ((localObject instanceof s))
          {
            locala.iv(-4001, -1);
          }
          else if ((localObject instanceof IllegalStateException))
          {
            locala.iv(-4002, -1);
          }
          else if ((localObject instanceof b.a))
          {
            locala.iv(-4003, -1);
          }
          else
          {
            locala.iv(-4999, -1);
            continue;
            label356:
            locala.iv(-4999, -1);
          }
        }
      }
    }
    
    public final void a(r paramr, g paramg) {}
    
    public final void aP(boolean paramBoolean)
    {
      AppMethodBeat.i(137227);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
      if ((!paramBoolean) && (a.this.FQr))
      {
        a.this.FQr = false;
        a.b(a.this);
      }
      AppMethodBeat.o(137227);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(137231);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.aNo), Float.valueOf(paramp.pitch) }));
      AppMethodBeat.o(137231);
    }
    
    public final void b(w paramw, Object paramObject) {}
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137228);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.bWw() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.f.b.a.Zy(paramInt) + "]");
      a locala = a.this;
      if (locala.FQh != null)
      {
        paramBoolean = locala.FQh.rb();
        paramInt = locala.FQh.ra();
        if ((paramBoolean) && (paramInt == 3))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
          if (locala.FQq != null) {
            locala.FQq.fdY();
          }
        }
        for (;;)
        {
          int i = a.f.u(paramBoolean, paramInt);
          if (i == locala.FQm.pBz[3]) {
            break label617;
          }
          Log.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
          locala.FQm.t(paramBoolean, paramInt);
          if (i != a.f.u(true, 4)) {
            break;
          }
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
          if (locala.FQq != null) {
            locala.FQq.fec();
          }
          AppMethodBeat.o(137228);
          return;
          if ((!paramBoolean) && (paramInt == 3) && (locala.FQg == 2))
          {
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (locala.FQq != null) {
              locala.FQq.fdZ();
            }
          }
          else if ((!paramBoolean) && (paramInt == 3) && (locala.FQg == 3))
          {
            Log.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (locala.FQq != null) {
              locala.FQq.fea();
            }
          }
        }
        if (locala.FQm.a(new int[] { a.f.u(false, 1), a.f.u(false, 2), a.f.u(false, 3) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
          if (locala.FQq != null) {
            locala.FQq.fdX();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if ((locala.FQm.a(new int[] { 100, 2, 3 }, true) | locala.FQm.a(new int[] { 2, 100, 3 }, true) | locala.FQm.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
          if (locala.FQq != null) {
            locala.FQq.feb();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.FQm.a(new int[] { a.f.u(true, 3), a.f.u(true, 2) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
          locala.iw(701, locala.getDownloadPercent());
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.FQm.a(new int[] { a.f.u(true, 2), a.f.u(true, 3) }, false))
        {
          Log.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
          locala.iw(702, locala.getDownloadPercent());
        }
      }
      label617:
      AppMethodBeat.o(137228);
    }
    
    public final void rs()
    {
      AppMethodBeat.i(137230);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
      AppMethodBeat.o(137230);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Zi(int paramInt);
    
    public abstract void fdX();
    
    public abstract void fdY();
    
    public abstract void fdZ();
    
    public abstract void fea();
    
    public abstract void feb();
    
    public abstract void fec();
    
    public abstract void ix(int paramInt1, int paramInt2);
  }
  
  public final class c
    implements a.b
  {
    public c() {}
    
    public final void Zi(int paramInt)
    {
      AppMethodBeat.i(137238);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137238);
    }
    
    public final void fdX()
    {
      AppMethodBeat.i(137232);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
      if (a.this.FQe != null) {
        a.this.H(a.this.FQe);
      }
      if (a.this.fod > 0)
      {
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(a.this.fod) });
        a.this.wG(a.this.fod);
      }
      if ((a.this.fod == 0) && (!a.this.FQh.rb()))
      {
        Log.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
        a.this.FQh.aM(true);
      }
      AppMethodBeat.o(137232);
    }
    
    public final void fdY()
    {
      AppMethodBeat.i(137233);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
      if (a.this.FQe != null) {
        a.this.I(a.this.FQe);
      }
      AppMethodBeat.o(137233);
    }
    
    public final void fdZ()
    {
      AppMethodBeat.i(137234);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
      if ((a.this.FQe != null) && (!a.this.FQh.rb())) {
        a.this.K(a.this.FQe);
      }
      AppMethodBeat.o(137234);
    }
    
    public final void fea()
    {
      AppMethodBeat.i(137235);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
      if (a.this.FQe != null) {
        a.this.L(a.this.FQe);
      }
      AppMethodBeat.o(137235);
    }
    
    public final void feb()
    {
      AppMethodBeat.i(137236);
      if (a.this.cmp())
      {
        a.this.FQr = true;
        AppMethodBeat.o(137236);
        return;
      }
      a.b(a.this);
      AppMethodBeat.o(137236);
    }
    
    public final void fec()
    {
      AppMethodBeat.i(137237);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
      if (a.this.FQe != null) {
        a.this.O(a.this.FQe);
      }
      a.this.FOH = false;
      a.this.die.removeMessages(100);
      AppMethodBeat.o(137237);
    }
    
    public final void ix(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(137239);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (a.this.FQe != null) {
        a.this.a(a.this.FQe, paramInt1, paramInt2);
      }
      if (a.this.FQh != null)
      {
        a.this.FQh.aM(false);
        a.this.FQh.stop();
      }
      a.this.FOH = false;
      a.this.die.removeMessages(100);
      a locala = a.this;
      locala.bpq += 1;
      if (a.this.bpq == 1) {
        a.a(a.this, a.this.FQe, paramInt1, paramInt2);
      }
      AppMethodBeat.o(137239);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.source.b, h.a
  {
    private d() {}
    
    public final void a(int paramInt, Format paramFormat, long paramLong) {}
    
    public final void a(j paramj, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(257089);
      a.a(a.this, "loadError", paramIOException);
      if ((paramj != null) && (paramFormat != null)) {
        Log.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      a.c(a.this);
      AppMethodBeat.o(257089);
    }
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
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
    
    public final void tj()
    {
      AppMethodBeat.i(137243);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
      a.this.biy = true;
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
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.bWw() + "]");
      AppMethodBeat.o(137244);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137246);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.bWw() + ", " + paramString + "]");
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
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.bWw() + ", " + Format.a(paramFormat) + "]");
      AppMethodBeat.o(137247);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137248);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.bWw() + "]");
      AppMethodBeat.o(137248);
    }
    
    public final void dU(int paramInt)
    {
      AppMethodBeat.i(137245);
      Log.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + paramInt + "]");
      AppMethodBeat.o(137245);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */