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
import com.tencent.mm.g.a.lw;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends com.tencent.mm.plugin.music.f.a
  implements d.a, e.a
{
  Handler aAO;
  boolean boA;
  private long bvf;
  int bvh;
  private String cRq;
  int cSh;
  protected String userAgent;
  boolean vdc;
  private long vdg;
  int veA;
  v veB;
  private com.google.android.exoplayer2.g.c veC;
  private l veD;
  private com.google.android.exoplayer2.h.g.a veE;
  private i veF;
  f veG;
  a veH;
  e veI;
  d veJ;
  b veK;
  boolean veL;
  public boolean veM;
  f vey;
  private com.tencent.mm.ay.c vez;
  
  public a()
  {
    AppMethodBeat.i(137252);
    this.veA = 0;
    this.cRq = "";
    this.bvh = 0;
    this.cSh = 0;
    this.vdg = 0L;
    this.boA = false;
    this.veG = new f((byte)0);
    this.veH = new a((byte)0);
    this.veI = new e((byte)0);
    this.veJ = new d((byte)0);
    this.veK = new c();
    this.aAO = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(137225);
        if (100 == paramAnonymousMessage.what)
        {
          ac.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(a.this.veB.getDuration()), Long.valueOf(a.this.veB.getCurrentPosition()), Long.valueOf(a.this.veB.getBufferedPosition()), Long.valueOf(a.this.veB.getBufferedPercentage()) });
          a.this.aAO.removeMessages(100);
          if (a.this.vdc) {
            a.this.aAO.sendEmptyMessageDelayed(100, 5000L);
          }
        }
        AppMethodBeat.o(137225);
      }
    };
    this.veL = false;
    this.veM = false;
    com.tencent.mm.plugin.music.f.b.a.djs();
    AppMethodBeat.o(137252);
  }
  
  private void b(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137274);
    if (this.vgx != null) {
      this.vgx.d(paramf, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137274);
  }
  
  public final void EM()
  {
    AppMethodBeat.i(137256);
    this.veM = true;
    ac.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.veB != null)
    {
      this.veA = 2;
      this.veB.aO(false);
    }
    AppMethodBeat.o(137256);
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(137269);
    ac.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.vgw = "error";
    lw locallw = new lw();
    locallw.dnW.action = 4;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "error";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = true;
    paramf = locallw.dnW;
    ac.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
    StringBuilder localStringBuilder;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
      paramf.errCode = paramInt1;
      paramf = locallw.dnW;
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
      com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
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
  
  public final boolean aGv()
  {
    AppMethodBeat.i(137259);
    if (this.veB == null)
    {
      AppMethodBeat.o(137259);
      return false;
    }
    switch (this.veB.rE())
    {
    case 2: 
    default: 
      AppMethodBeat.o(137259);
      return false;
    }
    boolean bool = this.veB.rF();
    AppMethodBeat.o(137259);
    return bool;
  }
  
  public final boolean aGw()
  {
    return (this.vdc) && (this.veM);
  }
  
  public final boolean aGx()
  {
    AppMethodBeat.i(137261);
    if ((this.vdc) && (!cDT()))
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
    ac.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
    com.tencent.mm.plugin.music.f.b.a.a(paramMetadata, "  ");
    ac.i("MicroMsg.Music.ExoMusicPlayer", "]");
    AppMethodBeat.o(137272);
  }
  
  final boolean cDT()
  {
    AppMethodBeat.i(137260);
    if (this.veB != null)
    {
      boolean bool = this.veB.isLoading();
      AppMethodBeat.o(137260);
      return bool;
    }
    AppMethodBeat.o(137260);
    return false;
  }
  
  public final void dhJ()
  {
    AppMethodBeat.i(137257);
    ac.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.diQ().bjF();
    AppMethodBeat.o(137257);
  }
  
  public final int dhO()
  {
    AppMethodBeat.i(137263);
    if (this.veB != null)
    {
      int i = (int)this.veB.getCurrentPosition();
      AppMethodBeat.o(137263);
      return i;
    }
    AppMethodBeat.o(137263);
    return 0;
  }
  
  public final boolean dhw()
  {
    return true;
  }
  
  public final com.tencent.mm.ay.c dhx()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137267);
    int n = getDuration();
    int i1 = dhO();
    boolean bool = aGv();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.veF instanceof h))
    {
      j = n;
      if (!this.boA) {
        j = 0;
      }
    }
    com.tencent.mm.ay.c localc;
    if (this.vez != null)
    {
      localc = this.vez;
      if (bool) {
        k = 1;
      }
      localc.t(j, i1, k, i);
    }
    for (;;)
    {
      this.vez.dnY = true;
      this.vez.hNN = djh();
      localc = this.vez;
      AppMethodBeat.o(137267);
      return localc;
      k = m;
      if (bool) {
        k = 1;
      }
      this.vez = new com.tencent.mm.ay.c(j, i1, k, i);
    }
  }
  
  public final void dir()
  {
    AppMethodBeat.i(137254);
    this.vgx = ((com.tencent.mm.plugin.music.e.d)b.aQ(com.tencent.mm.plugin.music.e.d.class));
    this.vgy = k.diO().veU;
    AppMethodBeat.o(137254);
  }
  
  final String dis()
  {
    AppMethodBeat.i(137273);
    String str = com.tencent.mm.plugin.music.f.b.a.wc(SystemClock.elapsedRealtime() - this.bvf);
    AppMethodBeat.o(137273);
    return str;
  }
  
  public final int getDownloadPercent()
  {
    AppMethodBeat.i(137265);
    if (this.veB != null)
    {
      int i = this.veB.getBufferedPercentage();
      AppMethodBeat.o(137265);
      return i;
    }
    AppMethodBeat.o(137265);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137264);
    if (this.veB != null)
    {
      int i = (int)this.veB.getDuration();
      AppMethodBeat.o(137264);
      return i;
    }
    AppMethodBeat.o(137264);
    return 0;
  }
  
  final void gr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137270);
    ac.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.veK != null) {
      this.veK.gt(paramInt1, paramInt2);
    }
    AppMethodBeat.o(137270);
  }
  
  final void gs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137271);
    ac.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.veK != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.veK.JH(paramInt2);
    }
    AppMethodBeat.o(137271);
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(137253);
    super.h(paramf);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.vdg;
    if ((this.vey != null) && (this.vey.f(paramf)) && (l2 <= 1000L))
    {
      this.vey = paramf;
      ac.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.cRq, Long.valueOf(l2) });
      AppMethodBeat.o(137253);
      return;
    }
    if (paramf == null)
    {
      ac.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      AppMethodBeat.o(137253);
      return;
    }
    if (this.vgx != null) {
      this.vgx.v(paramf);
    }
    this.vdg = l1;
    ac.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.cSh) });
    if ((this.veB != null) && (aGv())) {
      this.veB.stop();
    }
    this.bvh = 0;
    this.cSh = paramf.cSh;
    this.bvf = SystemClock.elapsedRealtime();
    this.vey = paramf;
    C(this.vey);
    ac.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.cSh) });
    ap.f(new Runnable()
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
  
  public final void pause()
  {
    AppMethodBeat.i(137255);
    this.veM = false;
    ac.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.veB != null)
    {
      this.veA = 2;
      this.veB.aO(false);
    }
    AppMethodBeat.o(137255);
  }
  
  public final boolean pl(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(137266);
    int i = getDuration();
    ac.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      ac.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137266);
      return false;
    }
    if (this.veB != null)
    {
      J(this.vey);
      f localf = this.veG;
      if ((this.veG.kUl[3] & 0xF0000000) != 0) {
        bool = true;
      }
      localf.r(bool, 100);
      this.veA = 4;
      this.veB.seekTo(paramInt);
    }
    AppMethodBeat.o(137266);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(137268);
    ac.i("MicroMsg.Music.ExoMusicPlayer", "release");
    this.aAO.removeMessages(100);
    dhv();
    if (this.veB != null)
    {
      this.veB.b(this.veH);
      this.veB.aTD.remove(this);
      this.veB.release();
      this.veB = null;
    }
    if (this.veF != null)
    {
      this.veF.tP();
      this.veF = null;
    }
    this.veC = null;
    this.veE = null;
    AppMethodBeat.o(137268);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137258);
    this.bvh = 0;
    ac.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(cDT()), Boolean.valueOf(aGv()) });
    if (this.veB != null)
    {
      if (!k.diQ().requestFocus()) {
        break label92;
      }
      this.veA = 1;
      this.veB.aO(true);
      F(this.vey);
    }
    for (;;)
    {
      this.vdc = true;
      AppMethodBeat.o(137258);
      return;
      label92:
      ac.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137262);
    ac.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
    try
    {
      if (this.veB != null)
      {
        this.veA = 3;
        this.veB.aO(false);
        this.veB.stop();
        H(this.vey);
      }
      k.diQ().bjF();
      this.vdc = false;
      this.veM = false;
      this.aAO.removeMessages(100);
      AppMethodBeat.o(137262);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.vey, 504);
        b(this.vey, -4005, -42);
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
      ac.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + a.this.dis() + "]", new Object[0]);
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
          boolean bool = ax.isNetworkConnected(ai.getContext());
          ac.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + bool + " caused by:\n" + ((Throwable)localObject).toString());
          if (!bool)
          {
            locala.gr(-4000, -2);
            AppMethodBeat.o(137229);
            return;
          }
          locala.gr(-4000, -3);
          AppMethodBeat.o(137229);
          return;
        }
        if ((localObject instanceof s.e))
        {
          localObject = ((Throwable)localObject).toString();
          if (!((String)localObject).contains("403")) {
            break label210;
          }
          locala.gr(-4000, -10);
        }
      }
      label288:
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "ExoPlaybackException", new Object[0]);
        AppMethodBeat.o(137229);
        return;
        label210:
        if (((String)localObject).contains("404"))
        {
          locala.gr(-4000, -11);
        }
        else if (((String)localObject).contains("500"))
        {
          locala.gr(-4000, -12);
        }
        else if (((String)localObject).contains("502"))
        {
          locala.gr(-4000, -13);
        }
        else
        {
          locala.gr(-4000, -30);
          continue;
          if ((localObject instanceof q))
          {
            locala.gr(-4001, -1);
          }
          else if ((localObject instanceof IllegalStateException))
          {
            locala.gr(-4002, -1);
          }
          else if ((localObject instanceof b.a))
          {
            locala.gr(-4003, -1);
          }
          else
          {
            locala.gr(-4999, -1);
            continue;
            label356:
            locala.gr(-4999, -1);
          }
        }
      }
    }
    
    public final void aA(int paramInt) {}
    
    public final void aR(boolean paramBoolean)
    {
      AppMethodBeat.i(137227);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
      if ((!paramBoolean) && (a.this.veL))
      {
        a.this.veL = false;
        a.b(a.this);
      }
      AppMethodBeat.o(137227);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(137231);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.aTw), Float.valueOf(paramp.pitch) }));
      AppMethodBeat.o(137231);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137228);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.dis() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.f.b.a.JZ(paramInt) + "]");
      a locala = a.this;
      if (locala.veB != null)
      {
        paramBoolean = locala.veB.rF();
        paramInt = locala.veB.rE();
        if ((paramBoolean) && (paramInt == 3))
        {
          ac.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
          if (locala.veK != null) {
            locala.veK.diu();
          }
        }
        for (;;)
        {
          int i = a.f.s(paramBoolean, paramInt);
          if (i == locala.veG.kUl[3]) {
            break label616;
          }
          ac.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
          locala.veG.r(paramBoolean, paramInt);
          if (i != a.f.s(true, 4)) {
            break;
          }
          ac.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
          if (locala.veK != null) {
            locala.veK.diy();
          }
          AppMethodBeat.o(137228);
          return;
          if ((!paramBoolean) && (paramInt == 3) && (locala.veA == 2))
          {
            ac.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (locala.veK != null) {
              locala.veK.div();
            }
          }
          else if ((!paramBoolean) && (paramInt == 3) && (locala.veA == 3))
          {
            ac.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (locala.veK != null) {
              locala.veK.diw();
            }
          }
        }
        if (locala.veG.a(new int[] { a.f.s(false, 1), a.f.s(false, 2), a.f.s(false, 3) }, false))
        {
          ac.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
          if (locala.veK != null) {
            locala.veK.dit();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if ((locala.veG.a(new int[] { 100, 2, 3 }, true) | locala.veG.a(new int[] { 2, 100, 3 }, true) | locala.veG.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          ac.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
          if (locala.veK != null) {
            locala.veK.dix();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.veG.a(new int[] { a.f.s(true, 3), a.f.s(true, 2) }, false))
        {
          ac.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
          locala.gs(701, locala.getDownloadPercent());
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.veG.a(new int[] { a.f.s(true, 2), a.f.s(true, 3) }, false))
        {
          ac.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
          locala.gs(702, locala.getDownloadPercent());
        }
      }
      label616:
      AppMethodBeat.o(137228);
    }
    
    public final void rU() {}
    
    public final void rV() {}
    
    public final void rW()
    {
      AppMethodBeat.i(137230);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
      AppMethodBeat.o(137230);
    }
  }
  
  public static abstract interface b
  {
    public abstract void JH(int paramInt);
    
    public abstract void dit();
    
    public abstract void diu();
    
    public abstract void div();
    
    public abstract void diw();
    
    public abstract void dix();
    
    public abstract void diy();
    
    public abstract void gt(int paramInt1, int paramInt2);
  }
  
  public final class c
    implements a.b
  {
    public c() {}
    
    public final void JH(int paramInt)
    {
      AppMethodBeat.i(137238);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137238);
    }
    
    public final void dit()
    {
      AppMethodBeat.i(137232);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
      if (a.this.vey != null) {
        a.this.D(a.this.vey);
      }
      if (a.this.cSh > 0)
      {
        ac.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(a.this.cSh) });
        a.this.pl(a.this.cSh);
      }
      if ((a.this.cSh == 0) && (!a.this.veB.rF()))
      {
        ac.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
        a.this.veB.aO(true);
      }
      AppMethodBeat.o(137232);
    }
    
    public final void diu()
    {
      AppMethodBeat.i(137233);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
      if (a.this.vey != null) {
        a.this.E(a.this.vey);
      }
      AppMethodBeat.o(137233);
    }
    
    public final void div()
    {
      AppMethodBeat.i(137234);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
      if ((a.this.vey != null) && (!a.this.veB.rF())) {
        a.this.G(a.this.vey);
      }
      AppMethodBeat.o(137234);
    }
    
    public final void diw()
    {
      AppMethodBeat.i(137235);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
      if (a.this.vey != null) {
        a.this.H(a.this.vey);
      }
      AppMethodBeat.o(137235);
    }
    
    public final void dix()
    {
      AppMethodBeat.i(137236);
      if (a.this.cDT())
      {
        a.this.veL = true;
        AppMethodBeat.o(137236);
        return;
      }
      a.b(a.this);
      AppMethodBeat.o(137236);
    }
    
    public final void diy()
    {
      AppMethodBeat.i(137237);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
      if (a.this.vey != null) {
        a.this.K(a.this.vey);
      }
      a.this.vdc = false;
      a.this.aAO.removeMessages(100);
      AppMethodBeat.o(137237);
    }
    
    public final void gt(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(137239);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (a.this.vey != null) {
        a.this.a(a.this.vey, paramInt1, paramInt2);
      }
      if (a.this.veB != null)
      {
        a.this.veB.aO(false);
        a.this.veB.stop();
      }
      a.this.vdc = false;
      a.this.aAO.removeMessages(100);
      a locala = a.this;
      locala.bvh += 1;
      if (a.this.bvh == 1) {
        a.a(a.this, a.this.vey, paramInt1, paramInt2);
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
        ac.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      a.c(a.this);
      AppMethodBeat.o(177347);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(177348);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
      AppMethodBeat.o(177348);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(137242);
      a.a(a.this, "loadError", paramIOException);
      ac.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", paramIOException, "onLoadError", new Object[0]);
      a.c(a.this);
      AppMethodBeat.o(137242);
    }
    
    public final void tG()
    {
      AppMethodBeat.i(137243);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
      a.this.boA = true;
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
      ac.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.dis() + "]");
      AppMethodBeat.o(137244);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137246);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.dis() + ", " + paramString + "]");
      AppMethodBeat.o(137246);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(137247);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.dis() + ", " + Format.a(paramFormat) + "]");
      AppMethodBeat.o(137247);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137248);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.dis() + "]");
      AppMethodBeat.o(137248);
    }
    
    public final void dH(int paramInt)
    {
      AppMethodBeat.i(137245);
      ac.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + paramInt + "]");
      AppMethodBeat.o(137245);
    }
  }
  
  static final class f
  {
    int[] kUl;
    
    private f()
    {
      AppMethodBeat.i(137250);
      this.kUl = new int[] { 1, 1, 1, 1 };
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
        int k = this.kUl.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.kUl.length) {
          return paramBoolean;
        }
        if ((this.kUl[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
      ac.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.kUl[3] + ",newState=" + i);
      if (this.kUl[3] == i)
      {
        AppMethodBeat.o(137251);
        return;
      }
      this.kUl[0] = this.kUl[1];
      this.kUl[1] = this.kUl[2];
      this.kUl[2] = this.kUl[3];
      this.kUl[3] = i;
      ac.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.kUl[0] + "," + this.kUl[1] + "," + this.kUl[2] + "," + this.kUl[3] + "]");
      AppMethodBeat.o(137251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */