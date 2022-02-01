package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e.b.a;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends com.tencent.mm.plugin.music.f.a
  implements d.a, e.a
{
  Handler aCF;
  int bFv;
  boolean byV;
  private String ddI;
  int dez;
  private long startTimeMs;
  protected String userAgent;
  boolean wyd;
  private long wyh;
  int wzA;
  v wzB;
  private com.google.android.exoplayer2.g.c wzC;
  private l wzD;
  private com.google.android.exoplayer2.h.g.a wzE;
  private i wzF;
  f wzG;
  a wzH;
  e wzI;
  d wzJ;
  b wzK;
  boolean wzL;
  public boolean wzM;
  f wzy;
  private com.tencent.mm.ay.c wzz;
  
  public a()
  {
    AppMethodBeat.i(137252);
    this.wzA = 0;
    this.ddI = "";
    this.bFv = 0;
    this.dez = 0;
    this.wyh = 0L;
    this.byV = false;
    this.wzG = new f((byte)0);
    this.wzH = new a((byte)0);
    this.wzI = new e((byte)0);
    this.wzJ = new d((byte)0);
    this.wzK = new c();
    this.aCF = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(137225);
        if (100 == paramAnonymousMessage.what)
        {
          ae.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(a.this.wzB.getDuration()), Long.valueOf(a.this.wzB.getCurrentPosition()), Long.valueOf(a.this.wzB.getBufferedPosition()), Long.valueOf(a.this.wzB.getBufferedPercentage()) });
          a.this.aCF.removeMessages(100);
          if (a.this.wyd) {
            a.this.aCF.sendEmptyMessageDelayed(100, 5000L);
          }
        }
        AppMethodBeat.o(137225);
      }
    };
    this.wzL = false;
    this.wzM = false;
    com.tencent.mm.plugin.music.f.b.a.dwT();
    AppMethodBeat.o(137252);
  }
  
  private void b(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137274);
    if (this.wBB != null) {
      this.wBB.d(paramf, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137274);
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(137269);
    ae.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.wBA = "error";
    mg localmg = new mg();
    localmg.dAP.action = 4;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "error";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = true;
    paramf = localmg.dAP;
    ae.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
    StringBuilder localStringBuilder;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
      paramf.errCode = paramInt1;
      paramf = localmg.dAP;
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
      com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
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
  
  public final boolean aJZ()
  {
    AppMethodBeat.i(137259);
    if (this.wzB == null)
    {
      AppMethodBeat.o(137259);
      return false;
    }
    switch (this.wzB.td())
    {
    case 2: 
    default: 
      AppMethodBeat.o(137259);
      return false;
    }
    boolean bool = this.wzB.te();
    AppMethodBeat.o(137259);
    return bool;
  }
  
  public final boolean aKa()
  {
    return (this.wyd) && (this.wzM);
  }
  
  public final boolean aKb()
  {
    AppMethodBeat.i(137261);
    if ((this.wyd) && (!cOU()))
    {
      AppMethodBeat.o(137261);
      return true;
    }
    AppMethodBeat.o(137261);
    return false;
  }
  
  public final void b(Metadata paramMetadata)
  {
    AppMethodBeat.i(137272);
    ae.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
    com.tencent.mm.plugin.music.f.b.a.a(paramMetadata, "  ");
    ae.i("MicroMsg.Music.ExoMusicPlayer", "]");
    AppMethodBeat.o(137272);
  }
  
  final boolean cOU()
  {
    AppMethodBeat.i(137260);
    if (this.wzB != null)
    {
      boolean bool = this.wzB.isLoading();
      AppMethodBeat.o(137260);
      return bool;
    }
    AppMethodBeat.o(137260);
    return false;
  }
  
  public final void duX()
  {
    AppMethodBeat.i(137256);
    this.wzM = true;
    ae.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.wzB != null)
    {
      this.wzA = 2;
      this.wzB.aP(false);
    }
    AppMethodBeat.o(137256);
  }
  
  public final boolean duY()
  {
    return true;
  }
  
  public final com.tencent.mm.ay.c duZ()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137267);
    int n = getDuration();
    int i1 = dvr();
    boolean bool = aJZ();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.wzF instanceof h))
    {
      j = n;
      if (!this.byV) {
        j = 0;
      }
    }
    com.tencent.mm.ay.c localc;
    if (this.wzz != null)
    {
      localc = this.wzz;
      if (bool) {
        k = 1;
      }
      localc.t(j, i1, k, i);
    }
    for (;;)
    {
      this.wzz.dAR = true;
      this.wzz.ijU = dwI();
      localc = this.wzz;
      AppMethodBeat.o(137267);
      return localc;
      k = m;
      if (bool) {
        k = 1;
      }
      this.wzz = new com.tencent.mm.ay.c(j, i1, k, i);
    }
  }
  
  public final void dvS()
  {
    AppMethodBeat.i(137254);
    this.wBB = ((com.tencent.mm.plugin.music.e.d)b.aQ(com.tencent.mm.plugin.music.e.d.class));
    this.wBC = k.dwp().wzU;
    AppMethodBeat.o(137254);
  }
  
  final String dvT()
  {
    AppMethodBeat.i(137273);
    String str = com.tencent.mm.plugin.music.f.b.a.yF(SystemClock.elapsedRealtime() - this.startTimeMs);
    AppMethodBeat.o(137273);
    return str;
  }
  
  public final void dvl()
  {
    AppMethodBeat.i(137257);
    ae.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.dwr().bqr();
    AppMethodBeat.o(137257);
  }
  
  public final int dvr()
  {
    AppMethodBeat.i(137263);
    if (this.wzB != null)
    {
      int i = (int)this.wzB.getCurrentPosition();
      AppMethodBeat.o(137263);
      return i;
    }
    AppMethodBeat.o(137263);
    return 0;
  }
  
  final void gK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137270);
    ae.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.wzK != null) {
      this.wzK.gM(paramInt1, paramInt2);
    }
    AppMethodBeat.o(137270);
  }
  
  final void gL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137271);
    ae.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.wzK != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.wzK.LO(paramInt2);
    }
    AppMethodBeat.o(137271);
  }
  
  public final int getDownloadPercent()
  {
    AppMethodBeat.i(137265);
    if (this.wzB != null)
    {
      int i = this.wzB.getBufferedPercentage();
      AppMethodBeat.o(137265);
      return i;
    }
    AppMethodBeat.o(137265);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137264);
    if (this.wzB != null)
    {
      int i = (int)this.wzB.getDuration();
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
    long l2 = l1 - this.wyh;
    if ((this.wzy != null) && (this.wzy.f(paramf)) && (l2 <= 1000L))
    {
      this.wzy = paramf;
      ae.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.ddI, Long.valueOf(l2) });
      AppMethodBeat.o(137253);
      return;
    }
    if (paramf == null)
    {
      ae.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      AppMethodBeat.o(137253);
      return;
    }
    if (this.wBB != null) {
      this.wBB.v(paramf);
    }
    this.wyh = l1;
    ae.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.dez) });
    if ((this.wzB != null) && (aJZ())) {
      this.wzB.stop();
    }
    this.bFv = 0;
    this.dez = paramf.dez;
    this.startTimeMs = SystemClock.elapsedRealtime();
    this.wzy = paramf;
    C(this.wzy);
    ae.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.dez) });
    ar.f(new Runnable()
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
  
  public final boolean pR(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(137266);
    int i = getDuration();
    ae.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      ae.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137266);
      return false;
    }
    if (this.wzB != null)
    {
      J(this.wzy);
      f localf = this.wzG;
      if ((this.wzG.lvI[3] & 0xF0000000) != 0) {
        bool = true;
      }
      localf.r(bool, 100);
      this.wzA = 4;
      this.wzB.seekTo(paramInt);
    }
    AppMethodBeat.o(137266);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137255);
    this.wzM = false;
    ae.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.wzB != null)
    {
      this.wzA = 2;
      this.wzB.aP(false);
    }
    AppMethodBeat.o(137255);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137268);
    ae.i("MicroMsg.Music.ExoMusicPlayer", "release");
    this.aCF.removeMessages(100);
    duW();
    if (this.wzB != null)
    {
      this.wzB.b(this.wzH);
      this.wzB.bdX.remove(this);
      this.wzB.release();
      this.wzB = null;
    }
    if (this.wzF != null)
    {
      this.wzF.vo();
      this.wzF = null;
    }
    this.wzC = null;
    this.wzE = null;
    AppMethodBeat.o(137268);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137258);
    this.bFv = 0;
    ae.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(cOU()), Boolean.valueOf(aJZ()) });
    if (this.wzB != null)
    {
      if (!k.dwr().requestFocus()) {
        break label92;
      }
      this.wzA = 1;
      this.wzB.aP(true);
      F(this.wzy);
    }
    for (;;)
    {
      this.wyd = true;
      AppMethodBeat.o(137258);
      return;
      label92:
      ae.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137262);
    ae.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
    try
    {
      if (this.wzB != null)
      {
        this.wzA = 3;
        this.wzB.aP(false);
        this.wzB.stop();
        H(this.wzy);
      }
      k.dwr().bqr();
      this.wyd = false;
      this.wzM = false;
      this.aCF.removeMessages(100);
      AppMethodBeat.o(137262);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.wzy, 504);
        b(this.wzy, -4005, -42);
      }
    }
  }
  
  final class a
    implements f.a
  {
    private a() {}
    
    public final void a(com.google.android.exoplayer2.e parame)
    {
      AppMethodBeat.i(137229);
      ae.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + a.this.dvT() + "]", new Object[0]);
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
          boolean bool = az.isNetworkConnected(ak.getContext());
          ae.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + bool + " caused by:\n" + ((Throwable)localObject).toString());
          if (!bool)
          {
            locala.gK(-4000, -2);
            AppMethodBeat.o(137229);
            return;
          }
          locala.gK(-4000, -3);
          AppMethodBeat.o(137229);
          return;
        }
        if ((localObject instanceof s.e))
        {
          localObject = ((Throwable)localObject).toString();
          if (!((String)localObject).contains("403")) {
            break label210;
          }
          locala.gK(-4000, -10);
        }
      }
      label288:
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "ExoPlaybackException", new Object[0]);
        AppMethodBeat.o(137229);
        return;
        label210:
        if (((String)localObject).contains("404"))
        {
          locala.gK(-4000, -11);
        }
        else if (((String)localObject).contains("500"))
        {
          locala.gK(-4000, -12);
        }
        else if (((String)localObject).contains("502"))
        {
          locala.gK(-4000, -13);
        }
        else
        {
          locala.gK(-4000, -30);
          continue;
          if ((localObject instanceof q))
          {
            locala.gK(-4001, -1);
          }
          else if ((localObject instanceof IllegalStateException))
          {
            locala.gK(-4002, -1);
          }
          else if ((localObject instanceof b.a))
          {
            locala.gK(-4003, -1);
          }
          else
          {
            locala.gK(-4999, -1);
            continue;
            label356:
            locala.gK(-4999, -1);
          }
        }
      }
    }
    
    public final void aA(int paramInt) {}
    
    public final void aS(boolean paramBoolean)
    {
      AppMethodBeat.i(137227);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
      if ((!paramBoolean) && (a.this.wzL))
      {
        a.this.wzL = false;
        a.b(a.this);
      }
      AppMethodBeat.o(137227);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(137231);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.bdQ), Float.valueOf(paramp.pitch) }));
      AppMethodBeat.o(137231);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137228);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.dvT() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.f.b.a.Mg(paramInt) + "]");
      a locala = a.this;
      if (locala.wzB != null)
      {
        paramBoolean = locala.wzB.te();
        paramInt = locala.wzB.td();
        if ((paramBoolean) && (paramInt == 3))
        {
          ae.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
          if (locala.wzK != null) {
            locala.wzK.dvV();
          }
        }
        for (;;)
        {
          int i = a.f.s(paramBoolean, paramInt);
          if (i == locala.wzG.lvI[3]) {
            break label616;
          }
          ae.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
          locala.wzG.r(paramBoolean, paramInt);
          if (i != a.f.s(true, 4)) {
            break;
          }
          ae.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
          if (locala.wzK != null) {
            locala.wzK.dvZ();
          }
          AppMethodBeat.o(137228);
          return;
          if ((!paramBoolean) && (paramInt == 3) && (locala.wzA == 2))
          {
            ae.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (locala.wzK != null) {
              locala.wzK.dvW();
            }
          }
          else if ((!paramBoolean) && (paramInt == 3) && (locala.wzA == 3))
          {
            ae.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (locala.wzK != null) {
              locala.wzK.dvX();
            }
          }
        }
        if (locala.wzG.a(new int[] { a.f.s(false, 1), a.f.s(false, 2), a.f.s(false, 3) }, false))
        {
          ae.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
          if (locala.wzK != null) {
            locala.wzK.dvU();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if ((locala.wzG.a(new int[] { 100, 2, 3 }, true) | locala.wzG.a(new int[] { 2, 100, 3 }, true) | locala.wzG.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          ae.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
          if (locala.wzK != null) {
            locala.wzK.dvY();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.wzG.a(new int[] { a.f.s(true, 3), a.f.s(true, 2) }, false))
        {
          ae.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
          locala.gL(701, locala.getDownloadPercent());
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.wzG.a(new int[] { a.f.s(true, 2), a.f.s(true, 3) }, false))
        {
          ae.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
          locala.gL(702, locala.getDownloadPercent());
        }
      }
      label616:
      AppMethodBeat.o(137228);
    }
    
    public final void tt() {}
    
    public final void tu() {}
    
    public final void tv()
    {
      AppMethodBeat.i(137230);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
      AppMethodBeat.o(137230);
    }
  }
  
  public static abstract interface b
  {
    public abstract void LO(int paramInt);
    
    public abstract void dvU();
    
    public abstract void dvV();
    
    public abstract void dvW();
    
    public abstract void dvX();
    
    public abstract void dvY();
    
    public abstract void dvZ();
    
    public abstract void gM(int paramInt1, int paramInt2);
  }
  
  public final class c
    implements a.b
  {
    public c() {}
    
    public final void LO(int paramInt)
    {
      AppMethodBeat.i(137238);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137238);
    }
    
    public final void dvU()
    {
      AppMethodBeat.i(137232);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
      if (a.this.wzy != null) {
        a.this.D(a.this.wzy);
      }
      if (a.this.dez > 0)
      {
        ae.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(a.this.dez) });
        a.this.pR(a.this.dez);
      }
      if ((a.this.dez == 0) && (!a.this.wzB.te()))
      {
        ae.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
        a.this.wzB.aP(true);
      }
      AppMethodBeat.o(137232);
    }
    
    public final void dvV()
    {
      AppMethodBeat.i(137233);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
      if (a.this.wzy != null) {
        a.this.E(a.this.wzy);
      }
      AppMethodBeat.o(137233);
    }
    
    public final void dvW()
    {
      AppMethodBeat.i(137234);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
      if ((a.this.wzy != null) && (!a.this.wzB.te())) {
        a.this.G(a.this.wzy);
      }
      AppMethodBeat.o(137234);
    }
    
    public final void dvX()
    {
      AppMethodBeat.i(137235);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
      if (a.this.wzy != null) {
        a.this.H(a.this.wzy);
      }
      AppMethodBeat.o(137235);
    }
    
    public final void dvY()
    {
      AppMethodBeat.i(137236);
      if (a.this.cOU())
      {
        a.this.wzL = true;
        AppMethodBeat.o(137236);
        return;
      }
      a.b(a.this);
      AppMethodBeat.o(137236);
    }
    
    public final void dvZ()
    {
      AppMethodBeat.i(137237);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
      if (a.this.wzy != null) {
        a.this.K(a.this.wzy);
      }
      a.this.wyd = false;
      a.this.aCF.removeMessages(100);
      AppMethodBeat.o(137237);
    }
    
    public final void gM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(137239);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (a.this.wzy != null) {
        a.this.a(a.this.wzy, paramInt1, paramInt2);
      }
      if (a.this.wzB != null)
      {
        a.this.wzB.aP(false);
        a.this.wzB.stop();
      }
      a.this.wyd = false;
      a.this.aCF.removeMessages(100);
      a locala = a.this;
      locala.bFv += 1;
      if (a.this.bFv == 1) {
        a.a(a.this, a.this.wzy, paramInt1, paramInt2);
      }
      AppMethodBeat.o(137239);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.g.a
  {
    private d() {}
    
    public final void a(int paramInt, Format paramFormat, long paramLong) {}
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void a(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(177347);
      a.a(a.this, "loadError", paramIOException);
      if ((paramj != null) && (paramFormat != null)) {
        ae.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      a.c(a.this);
      AppMethodBeat.o(177347);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(177348);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
      AppMethodBeat.o(177348);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(137242);
      a.a(a.this, "loadError", paramIOException);
      ae.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", paramIOException, "onLoadError", new Object[0]);
      a.c(a.this);
      AppMethodBeat.o(137242);
    }
    
    public final void vf()
    {
      AppMethodBeat.i(137243);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
      a.this.byV = true;
      AppMethodBeat.o(137243);
    }
  }
  
  final class e
    implements com.google.android.exoplayer2.a.e
  {
    private e() {}
    
    public final void c(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137249);
      a.a(a.this, "audioTrackUnderrun [" + paramInt + ", " + paramLong1 + ", " + paramLong2 + "]", null);
      AppMethodBeat.o(137249);
    }
    
    public final void c(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137244);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.dvT() + "]");
      AppMethodBeat.o(137244);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137246);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.dvT() + ", " + paramString + "]");
      AppMethodBeat.o(137246);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(137247);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.dvT() + ", " + Format.a(paramFormat) + "]");
      AppMethodBeat.o(137247);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137248);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.dvT() + "]");
      AppMethodBeat.o(137248);
    }
    
    public final void dL(int paramInt)
    {
      AppMethodBeat.i(137245);
      ae.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + paramInt + "]");
      AppMethodBeat.o(137245);
    }
  }
  
  static final class f
  {
    int[] lvI;
    
    private f()
    {
      AppMethodBeat.i(137250);
      this.lvI = new int[] { 1, 1, 1, 1 };
      AppMethodBeat.o(137250);
    }
    
    static int s(boolean paramBoolean, int paramInt)
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
        int k = this.lvI.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.lvI.length) {
          return paramBoolean;
        }
        if ((this.lvI[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
      ae.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.lvI[3] + ",newState=" + i);
      if (this.lvI[3] == i)
      {
        AppMethodBeat.o(137251);
        return;
      }
      this.lvI[0] = this.lvI[1];
      this.lvI[1] = this.lvI[2];
      this.lvI[2] = this.lvI[3];
      this.lvI[3] = i;
      ae.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.lvI[0] + "," + this.lvI[1] + "," + this.lvI[2] + "," + this.lvI[3] + "]");
      AppMethodBeat.o(137251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */