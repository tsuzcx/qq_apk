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
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends com.tencent.mm.plugin.music.f.a
  implements d.a, e.a
{
  Handler aCF;
  int bFv;
  boolean byV;
  private String dcG;
  int ddx;
  private long startTimeMs;
  protected String userAgent;
  private long wiC;
  boolean wiy;
  f wjT;
  private com.tencent.mm.az.c wjU;
  int wjV;
  v wjW;
  private com.google.android.exoplayer2.g.c wjX;
  private l wjY;
  private com.google.android.exoplayer2.h.g.a wjZ;
  private i wka;
  f wkb;
  a wkc;
  e wkd;
  d wke;
  b wkf;
  boolean wkg;
  public boolean wkh;
  
  public a()
  {
    AppMethodBeat.i(137252);
    this.wjV = 0;
    this.dcG = "";
    this.bFv = 0;
    this.ddx = 0;
    this.wiC = 0L;
    this.byV = false;
    this.wkb = new f((byte)0);
    this.wkc = new a((byte)0);
    this.wkd = new e((byte)0);
    this.wke = new d((byte)0);
    this.wkf = new c();
    this.aCF = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(137225);
        if (100 == paramAnonymousMessage.what)
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(a.this.wjW.getDuration()), Long.valueOf(a.this.wjW.getCurrentPosition()), Long.valueOf(a.this.wjW.getBufferedPosition()), Long.valueOf(a.this.wjW.getBufferedPercentage()) });
          a.this.aCF.removeMessages(100);
          if (a.this.wiy) {
            a.this.aCF.sendEmptyMessageDelayed(100, 5000L);
          }
        }
        AppMethodBeat.o(137225);
      }
    };
    this.wkg = false;
    this.wkh = false;
    com.tencent.mm.plugin.music.f.b.a.dtE();
    AppMethodBeat.o(137252);
  }
  
  private void b(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137274);
    if (this.wlS != null) {
      this.wlS.d(paramf, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137274);
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(137269);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.wlR = "error";
    mf localmf = new mf();
    localmf.dzK.action = 4;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "error";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = true;
    paramf = localmf.dzK;
    ad.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
    StringBuilder localStringBuilder;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
      paramf.errCode = paramInt1;
      paramf = localmf.dzK;
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
      com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
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
  
  public final boolean aJG()
  {
    AppMethodBeat.i(137259);
    if (this.wjW == null)
    {
      AppMethodBeat.o(137259);
      return false;
    }
    switch (this.wjW.td())
    {
    case 2: 
    default: 
      AppMethodBeat.o(137259);
      return false;
    }
    boolean bool = this.wjW.te();
    AppMethodBeat.o(137259);
    return bool;
  }
  
  public final boolean aJH()
  {
    return (this.wiy) && (this.wkh);
  }
  
  public final boolean aJI()
  {
    AppMethodBeat.i(137261);
    if ((this.wiy) && (!cMm()))
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
    ad.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
    com.tencent.mm.plugin.music.f.b.a.a(paramMetadata, "  ");
    ad.i("MicroMsg.Music.ExoMusicPlayer", "]");
    AppMethodBeat.o(137272);
  }
  
  final boolean cMm()
  {
    AppMethodBeat.i(137260);
    if (this.wjW != null)
    {
      boolean bool = this.wjW.isLoading();
      AppMethodBeat.o(137260);
      return bool;
    }
    AppMethodBeat.o(137260);
    return false;
  }
  
  public final void drJ()
  {
    AppMethodBeat.i(137256);
    this.wkh = true;
    ad.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.wjW != null)
    {
      this.wjV = 2;
      this.wjW.aP(false);
    }
    AppMethodBeat.o(137256);
  }
  
  public final boolean drK()
  {
    return true;
  }
  
  public final com.tencent.mm.az.c drL()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137267);
    int n = getDuration();
    int i1 = dsc();
    boolean bool = aJG();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.wka instanceof h))
    {
      j = n;
      if (!this.byV) {
        j = 0;
      }
    }
    com.tencent.mm.az.c localc;
    if (this.wjU != null)
    {
      localc = this.wjU;
      if (bool) {
        k = 1;
      }
      localc.t(j, i1, k, i);
    }
    for (;;)
    {
      this.wjU.dzM = true;
      this.wjU.ihb = dtt();
      localc = this.wjU;
      AppMethodBeat.o(137267);
      return localc;
      k = m;
      if (bool) {
        k = 1;
      }
      this.wjU = new com.tencent.mm.az.c(j, i1, k, i);
    }
  }
  
  public final void drX()
  {
    AppMethodBeat.i(137257);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.dtc().bpH();
    AppMethodBeat.o(137257);
  }
  
  public final void dsD()
  {
    AppMethodBeat.i(137254);
    this.wlS = ((com.tencent.mm.plugin.music.e.d)b.aQ(com.tencent.mm.plugin.music.e.d.class));
    this.wlT = k.dta().wkp;
    AppMethodBeat.o(137254);
  }
  
  final String dsE()
  {
    AppMethodBeat.i(137273);
    String str = com.tencent.mm.plugin.music.f.b.a.yl(SystemClock.elapsedRealtime() - this.startTimeMs);
    AppMethodBeat.o(137273);
    return str;
  }
  
  public final int dsc()
  {
    AppMethodBeat.i(137263);
    if (this.wjW != null)
    {
      int i = (int)this.wjW.getCurrentPosition();
      AppMethodBeat.o(137263);
      return i;
    }
    AppMethodBeat.o(137263);
    return 0;
  }
  
  final void gJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137270);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.wkf != null) {
      this.wkf.gL(paramInt1, paramInt2);
    }
    AppMethodBeat.o(137270);
  }
  
  final void gK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137271);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.wkf != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.wkf.Lj(paramInt2);
    }
    AppMethodBeat.o(137271);
  }
  
  public final int getDownloadPercent()
  {
    AppMethodBeat.i(137265);
    if (this.wjW != null)
    {
      int i = this.wjW.getBufferedPercentage();
      AppMethodBeat.o(137265);
      return i;
    }
    AppMethodBeat.o(137265);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137264);
    if (this.wjW != null)
    {
      int i = (int)this.wjW.getDuration();
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
    long l2 = l1 - this.wiC;
    if ((this.wjT != null) && (this.wjT.f(paramf)) && (l2 <= 1000L))
    {
      this.wjT = paramf;
      ad.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.dcG, Long.valueOf(l2) });
      AppMethodBeat.o(137253);
      return;
    }
    if (paramf == null)
    {
      ad.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      AppMethodBeat.o(137253);
      return;
    }
    if (this.wlS != null) {
      this.wlS.v(paramf);
    }
    this.wiC = l1;
    ad.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.ddx) });
    if ((this.wjW != null) && (aJG())) {
      this.wjW.stop();
    }
    this.bFv = 0;
    this.ddx = paramf.ddx;
    this.startTimeMs = SystemClock.elapsedRealtime();
    this.wjT = paramf;
    C(this.wjT);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.ddx) });
    aq.f(new Runnable()
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
  
  public final boolean pO(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(137266);
    int i = getDuration();
    ad.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      ad.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137266);
      return false;
    }
    if (this.wjW != null)
    {
      J(this.wjT);
      f localf = this.wkb;
      if ((this.wkb.lri[3] & 0xF0000000) != 0) {
        bool = true;
      }
      localf.q(bool, 100);
      this.wjV = 4;
      this.wjW.seekTo(paramInt);
    }
    AppMethodBeat.o(137266);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137255);
    this.wkh = false;
    ad.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.wjW != null)
    {
      this.wjV = 2;
      this.wjW.aP(false);
    }
    AppMethodBeat.o(137255);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137268);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "release");
    this.aCF.removeMessages(100);
    drI();
    if (this.wjW != null)
    {
      this.wjW.b(this.wkc);
      this.wjW.bdX.remove(this);
      this.wjW.release();
      this.wjW = null;
    }
    if (this.wka != null)
    {
      this.wka.vo();
      this.wka = null;
    }
    this.wjX = null;
    this.wjZ = null;
    AppMethodBeat.o(137268);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137258);
    this.bFv = 0;
    ad.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(cMm()), Boolean.valueOf(aJG()) });
    if (this.wjW != null)
    {
      if (!k.dtc().requestFocus()) {
        break label92;
      }
      this.wjV = 1;
      this.wjW.aP(true);
      F(this.wjT);
    }
    for (;;)
    {
      this.wiy = true;
      AppMethodBeat.o(137258);
      return;
      label92:
      ad.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137262);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
    try
    {
      if (this.wjW != null)
      {
        this.wjV = 3;
        this.wjW.aP(false);
        this.wjW.stop();
        H(this.wjT);
      }
      k.dtc().bpH();
      this.wiy = false;
      this.wkh = false;
      this.aCF.removeMessages(100);
      AppMethodBeat.o(137262);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.wjT, 504);
        b(this.wjT, -4005, -42);
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
      ad.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + a.this.dsE() + "]", new Object[0]);
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
          boolean bool = ay.isNetworkConnected(aj.getContext());
          ad.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + bool + " caused by:\n" + ((Throwable)localObject).toString());
          if (!bool)
          {
            locala.gJ(-4000, -2);
            AppMethodBeat.o(137229);
            return;
          }
          locala.gJ(-4000, -3);
          AppMethodBeat.o(137229);
          return;
        }
        if ((localObject instanceof s.e))
        {
          localObject = ((Throwable)localObject).toString();
          if (!((String)localObject).contains("403")) {
            break label210;
          }
          locala.gJ(-4000, -10);
        }
      }
      label288:
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "ExoPlaybackException", new Object[0]);
        AppMethodBeat.o(137229);
        return;
        label210:
        if (((String)localObject).contains("404"))
        {
          locala.gJ(-4000, -11);
        }
        else if (((String)localObject).contains("500"))
        {
          locala.gJ(-4000, -12);
        }
        else if (((String)localObject).contains("502"))
        {
          locala.gJ(-4000, -13);
        }
        else
        {
          locala.gJ(-4000, -30);
          continue;
          if ((localObject instanceof q))
          {
            locala.gJ(-4001, -1);
          }
          else if ((localObject instanceof IllegalStateException))
          {
            locala.gJ(-4002, -1);
          }
          else if ((localObject instanceof b.a))
          {
            locala.gJ(-4003, -1);
          }
          else
          {
            locala.gJ(-4999, -1);
            continue;
            label356:
            locala.gJ(-4999, -1);
          }
        }
      }
    }
    
    public final void aA(int paramInt) {}
    
    public final void aS(boolean paramBoolean)
    {
      AppMethodBeat.i(137227);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
      if ((!paramBoolean) && (a.this.wkg))
      {
        a.this.wkg = false;
        a.b(a.this);
      }
      AppMethodBeat.o(137227);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(137231);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.bdQ), Float.valueOf(paramp.pitch) }));
      AppMethodBeat.o(137231);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137228);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.dsE() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.f.b.a.LB(paramInt) + "]");
      a locala = a.this;
      if (locala.wjW != null)
      {
        paramBoolean = locala.wjW.te();
        paramInt = locala.wjW.td();
        if ((paramBoolean) && (paramInt == 3))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
          if (locala.wkf != null) {
            locala.wkf.dsG();
          }
        }
        for (;;)
        {
          int i = a.f.r(paramBoolean, paramInt);
          if (i == locala.wkb.lri[3]) {
            break label616;
          }
          ad.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
          locala.wkb.q(paramBoolean, paramInt);
          if (i != a.f.r(true, 4)) {
            break;
          }
          ad.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
          if (locala.wkf != null) {
            locala.wkf.dsK();
          }
          AppMethodBeat.o(137228);
          return;
          if ((!paramBoolean) && (paramInt == 3) && (locala.wjV == 2))
          {
            ad.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (locala.wkf != null) {
              locala.wkf.dsH();
            }
          }
          else if ((!paramBoolean) && (paramInt == 3) && (locala.wjV == 3))
          {
            ad.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (locala.wkf != null) {
              locala.wkf.dsI();
            }
          }
        }
        if (locala.wkb.a(new int[] { a.f.r(false, 1), a.f.r(false, 2), a.f.r(false, 3) }, false))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
          if (locala.wkf != null) {
            locala.wkf.dsF();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if ((locala.wkb.a(new int[] { 100, 2, 3 }, true) | locala.wkb.a(new int[] { 2, 100, 3 }, true) | locala.wkb.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
          if (locala.wkf != null) {
            locala.wkf.dsJ();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.wkb.a(new int[] { a.f.r(true, 3), a.f.r(true, 2) }, false))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
          locala.gK(701, locala.getDownloadPercent());
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.wkb.a(new int[] { a.f.r(true, 2), a.f.r(true, 3) }, false))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
          locala.gK(702, locala.getDownloadPercent());
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
      ad.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
      AppMethodBeat.o(137230);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Lj(int paramInt);
    
    public abstract void dsF();
    
    public abstract void dsG();
    
    public abstract void dsH();
    
    public abstract void dsI();
    
    public abstract void dsJ();
    
    public abstract void dsK();
    
    public abstract void gL(int paramInt1, int paramInt2);
  }
  
  public final class c
    implements a.b
  {
    public c() {}
    
    public final void Lj(int paramInt)
    {
      AppMethodBeat.i(137238);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137238);
    }
    
    public final void dsF()
    {
      AppMethodBeat.i(137232);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
      if (a.this.wjT != null) {
        a.this.D(a.this.wjT);
      }
      if (a.this.ddx > 0)
      {
        ad.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(a.this.ddx) });
        a.this.pO(a.this.ddx);
      }
      if ((a.this.ddx == 0) && (!a.this.wjW.te()))
      {
        ad.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
        a.this.wjW.aP(true);
      }
      AppMethodBeat.o(137232);
    }
    
    public final void dsG()
    {
      AppMethodBeat.i(137233);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
      if (a.this.wjT != null) {
        a.this.E(a.this.wjT);
      }
      AppMethodBeat.o(137233);
    }
    
    public final void dsH()
    {
      AppMethodBeat.i(137234);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
      if ((a.this.wjT != null) && (!a.this.wjW.te())) {
        a.this.G(a.this.wjT);
      }
      AppMethodBeat.o(137234);
    }
    
    public final void dsI()
    {
      AppMethodBeat.i(137235);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
      if (a.this.wjT != null) {
        a.this.H(a.this.wjT);
      }
      AppMethodBeat.o(137235);
    }
    
    public final void dsJ()
    {
      AppMethodBeat.i(137236);
      if (a.this.cMm())
      {
        a.this.wkg = true;
        AppMethodBeat.o(137236);
        return;
      }
      a.b(a.this);
      AppMethodBeat.o(137236);
    }
    
    public final void dsK()
    {
      AppMethodBeat.i(137237);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
      if (a.this.wjT != null) {
        a.this.K(a.this.wjT);
      }
      a.this.wiy = false;
      a.this.aCF.removeMessages(100);
      AppMethodBeat.o(137237);
    }
    
    public final void gL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(137239);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (a.this.wjT != null) {
        a.this.a(a.this.wjT, paramInt1, paramInt2);
      }
      if (a.this.wjW != null)
      {
        a.this.wjW.aP(false);
        a.this.wjW.stop();
      }
      a.this.wiy = false;
      a.this.aCF.removeMessages(100);
      a locala = a.this;
      locala.bFv += 1;
      if (a.this.bFv == 1) {
        a.a(a.this, a.this.wjT, paramInt1, paramInt2);
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
        ad.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      a.c(a.this);
      AppMethodBeat.o(177347);
    }
    
    public final void b(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(177348);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
      AppMethodBeat.o(177348);
    }
    
    public final void c(j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(137242);
      a.a(a.this, "loadError", paramIOException);
      ad.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", paramIOException, "onLoadError", new Object[0]);
      a.c(a.this);
      AppMethodBeat.o(137242);
    }
    
    public final void vf()
    {
      AppMethodBeat.i(137243);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
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
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.dsE() + "]");
      AppMethodBeat.o(137244);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137246);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.dsE() + ", " + paramString + "]");
      AppMethodBeat.o(137246);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(137247);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.dsE() + ", " + Format.a(paramFormat) + "]");
      AppMethodBeat.o(137247);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137248);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.dsE() + "]");
      AppMethodBeat.o(137248);
    }
    
    public final void dL(int paramInt)
    {
      AppMethodBeat.i(137245);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + paramInt + "]");
      AppMethodBeat.o(137245);
    }
  }
  
  static final class f
  {
    int[] lri;
    
    private f()
    {
      AppMethodBeat.i(137250);
      this.lri = new int[] { 1, 1, 1, 1 };
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
        int k = this.lri.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.lri.length) {
          return paramBoolean;
        }
        if ((this.lri[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
      ad.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.lri[3] + ",newState=" + i);
      if (this.lri[3] == i)
      {
        AppMethodBeat.o(137251);
        return;
      }
      this.lri[0] = this.lri[1];
      this.lri[1] = this.lri[2];
      this.lri[2] = this.lri[3];
      this.lri[3] = i;
      ad.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.lri[0] + "," + this.lri[1] + "," + this.lri[2] + "," + this.lri[3] + "]");
      AppMethodBeat.o(137251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */