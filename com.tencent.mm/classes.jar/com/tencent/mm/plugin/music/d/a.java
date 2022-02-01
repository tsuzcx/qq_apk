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
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.h.s.c;
import com.google.android.exoplayer2.h.s.e;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.ln;
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
  Handler azU;
  boolean bpZ;
  private long bxw;
  int bxy;
  private String cTT;
  int cUL;
  private l rdP;
  boolean rdQ;
  private long tUy;
  f tVP;
  private com.tencent.mm.az.c tVQ;
  int tVR;
  v tVS;
  private com.google.android.exoplayer2.g.c tVT;
  private g.a tVU;
  private com.google.android.exoplayer2.source.j tVV;
  f tVW;
  a tVX;
  e tVY;
  d tVZ;
  b tWa;
  boolean tWb;
  public boolean tWc;
  protected String userAgent;
  
  public a()
  {
    AppMethodBeat.i(137252);
    this.tVR = 0;
    this.cTT = "";
    this.bxy = 0;
    this.cUL = 0;
    this.tUy = 0L;
    this.bpZ = false;
    this.tVW = new f((byte)0);
    this.tVX = new a((byte)0);
    this.tVY = new e((byte)0);
    this.tVZ = new d((byte)0);
    this.tWa = new c();
    this.azU = new Handler(Looper.myLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(137225);
        if (100 == paramAnonymousMessage.what)
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", new Object[] { Long.valueOf(a.this.tVS.getDuration()), Long.valueOf(a.this.tVS.getCurrentPosition()), Long.valueOf(a.this.tVS.getBufferedPosition()), Long.valueOf(a.this.tVS.getBufferedPercentage()) });
          a.this.azU.removeMessages(100);
          if (a.this.rdQ) {
            a.this.azU.sendEmptyMessageDelayed(100, 5000L);
          }
        }
        AppMethodBeat.o(137225);
      }
    };
    this.tWb = false;
    this.tWc = false;
    com.tencent.mm.plugin.music.f.b.a.cVM();
    AppMethodBeat.o(137252);
  }
  
  private void b(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137274);
    if (this.tXL != null) {
      this.tXL.d(paramf, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137274);
  }
  
  public final void a(f paramf, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(137269);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.tXK = "error";
    ln localln = new ln();
    localln.dql.action = 4;
    localln.dql.dqf = paramf;
    localln.dql.state = "error";
    localln.dql.duration = getDuration();
    localln.dql.dqn = true;
    paramf = localln.dql;
    ad.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
    StringBuilder localStringBuilder;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
      paramf.errCode = paramInt1;
      paramf = localln.dql;
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
      com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
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
  
  public final boolean azF()
  {
    AppMethodBeat.i(137259);
    if (this.tVS == null)
    {
      AppMethodBeat.o(137259);
      return false;
    }
    switch (this.tVS.rt())
    {
    case 2: 
    default: 
      AppMethodBeat.o(137259);
      return false;
    }
    boolean bool = this.tVS.ru();
    AppMethodBeat.o(137259);
    return bool;
  }
  
  public final boolean azG()
  {
    return (this.rdQ) && (this.tWc);
  }
  
  public final boolean azH()
  {
    AppMethodBeat.i(137261);
    if ((this.rdQ) && (!cUd()))
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
  
  public final void cTO()
  {
    AppMethodBeat.i(137256);
    this.tWc = true;
    ad.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.tVS != null)
    {
      this.tVR = 2;
      this.tVS.aO(false);
    }
    AppMethodBeat.o(137256);
  }
  
  public final boolean cTP()
  {
    return true;
  }
  
  public final com.tencent.mm.az.c cTQ()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137267);
    int n = getDuration();
    int i1 = cUi();
    boolean bool = azF();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.tVV instanceof h))
    {
      j = n;
      if (!this.bpZ) {
        j = 0;
      }
    }
    com.tencent.mm.az.c localc;
    if (this.tVQ != null)
    {
      localc = this.tVQ;
      if (bool) {
        k = 1;
      }
      localc.t(j, i1, k, i);
    }
    for (;;)
    {
      this.tVQ.dqn = true;
      this.tVQ.hnk = cVB();
      localc = this.tVQ;
      AppMethodBeat.o(137267);
      return localc;
      k = m;
      if (bool) {
        k = 1;
      }
      this.tVQ = new com.tencent.mm.az.c(j, i1, k, i);
    }
  }
  
  public final void cUL()
  {
    AppMethodBeat.i(137254);
    this.tXL = ((com.tencent.mm.plugin.music.e.d)b.aP(com.tencent.mm.plugin.music.e.d.class));
    this.tXM = k.cVi().tWk;
    AppMethodBeat.o(137254);
  }
  
  final String cUM()
  {
    AppMethodBeat.i(137273);
    String str = com.tencent.mm.plugin.music.f.b.a.rz(SystemClock.elapsedRealtime() - this.bxw);
    AppMethodBeat.o(137273);
    return str;
  }
  
  public final void cUc()
  {
    AppMethodBeat.i(137257);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.cVk().bfc();
    AppMethodBeat.o(137257);
  }
  
  final boolean cUd()
  {
    AppMethodBeat.i(137260);
    if (this.tVS != null)
    {
      boolean bool = this.tVS.isLoading();
      AppMethodBeat.o(137260);
      return bool;
    }
    AppMethodBeat.o(137260);
    return false;
  }
  
  public final int cUi()
  {
    AppMethodBeat.i(137263);
    if (this.tVS != null)
    {
      int i = (int)this.tVS.getCurrentPosition();
      AppMethodBeat.o(137263);
      return i;
    }
    AppMethodBeat.o(137263);
    return 0;
  }
  
  public final int getDownloadPercent()
  {
    AppMethodBeat.i(137265);
    if (this.tVS != null)
    {
      int i = this.tVS.getBufferedPercentage();
      AppMethodBeat.o(137265);
      return i;
    }
    AppMethodBeat.o(137265);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137264);
    if (this.tVS != null)
    {
      int i = (int)this.tVS.getDuration();
      AppMethodBeat.o(137264);
      return i;
    }
    AppMethodBeat.o(137264);
    return 0;
  }
  
  final void gk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137270);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.tWa != null) {
      this.tWa.gm(paramInt1, paramInt2);
    }
    AppMethodBeat.o(137270);
  }
  
  final void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137271);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.tWa != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.tWa.HI(paramInt2);
    }
    AppMethodBeat.o(137271);
  }
  
  public final void h(f paramf)
  {
    AppMethodBeat.i(137253);
    super.h(paramf);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.tUy;
    if ((this.tVP != null) && (this.tVP.f(paramf)) && (l2 <= 1000L))
    {
      this.tVP = paramf;
      ad.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.cTT, Long.valueOf(l2) });
      AppMethodBeat.o(137253);
      return;
    }
    if (paramf == null)
    {
      ad.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      AppMethodBeat.o(137253);
      return;
    }
    if (this.tXL != null) {
      this.tXL.v(paramf);
    }
    this.tUy = l1;
    ad.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramf.cUL) });
    if ((this.tVS != null) && (azF())) {
      this.tVS.stop();
    }
    this.bxy = 0;
    this.cUL = paramf.cUL;
    this.bxw = SystemClock.elapsedRealtime();
    this.tVP = paramf;
    B(this.tVP);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.cUL) });
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
  
  public final boolean ox(int paramInt)
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
    if (this.tVS != null)
    {
      I(this.tVP);
      f localf = this.tVW;
      if ((this.tVW.ksV[3] & 0xF0000000) != 0) {
        bool = true;
      }
      localf.q(bool, 100);
      this.tVR = 4;
      this.tVS.seekTo(paramInt);
    }
    AppMethodBeat.o(137266);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137255);
    this.tWc = false;
    ad.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.tVS != null)
    {
      this.tVR = 2;
      this.tVS.aO(false);
    }
    AppMethodBeat.o(137255);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137268);
    ad.i("MicroMsg.Music.ExoMusicPlayer", "release");
    this.azU.removeMessages(100);
    cTN();
    if (this.tVS != null)
    {
      this.tVS.b(this.tVX);
      this.tVS.aSK.remove(this);
      this.tVS.release();
      this.tVS = null;
    }
    if (this.tVV != null)
    {
      this.tVV.tH();
      this.tVV = null;
    }
    this.tVT = null;
    this.tVU = null;
    AppMethodBeat.o(137268);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137258);
    this.bxy = 0;
    ad.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(cUd()), Boolean.valueOf(azF()) });
    if (this.tVS != null)
    {
      if (!k.cVk().requestFocus()) {
        break label92;
      }
      this.tVR = 1;
      this.tVS.aO(true);
      E(this.tVP);
    }
    for (;;)
    {
      this.rdQ = true;
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
      if (this.tVS != null)
      {
        this.tVR = 3;
        this.tVS.aO(false);
        this.tVS.stop();
        G(this.tVP);
      }
      k.cVk().bfc();
      this.rdQ = false;
      this.tWc = false;
      this.azU.removeMessages(100);
      AppMethodBeat.o(137262);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.tVP, 504);
        b(this.tVP, -4005, -42);
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
      ad.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", parame, "playerFailed [" + a.this.cUM() + "]", new Object[0]);
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
            locala.gk(-4000, -2);
            AppMethodBeat.o(137229);
            return;
          }
          locala.gk(-4000, -3);
          AppMethodBeat.o(137229);
          return;
        }
        if ((localObject instanceof s.e))
        {
          localObject = ((Throwable)localObject).toString();
          if (!((String)localObject).contains("403")) {
            break label210;
          }
          locala.gk(-4000, -10);
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
          locala.gk(-4000, -11);
        }
        else if (((String)localObject).contains("500"))
        {
          locala.gk(-4000, -12);
        }
        else if (((String)localObject).contains("502"))
        {
          locala.gk(-4000, -13);
        }
        else
        {
          locala.gk(-4000, -30);
          continue;
          if ((localObject instanceof r))
          {
            locala.gk(-4001, -1);
          }
          else if ((localObject instanceof IllegalStateException))
          {
            locala.gk(-4002, -1);
          }
          else if ((localObject instanceof b.a))
          {
            locala.gk(-4003, -1);
          }
          else
          {
            locala.gk(-4999, -1);
            continue;
            label356:
            locala.gk(-4999, -1);
          }
        }
      }
    }
    
    public final void aA(int paramInt) {}
    
    public final void aR(boolean paramBoolean)
    {
      AppMethodBeat.i(137227);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + paramBoolean + "]");
      if ((!paramBoolean) && (a.this.tWb))
      {
        a.this.tWb = false;
        a.b(a.this);
      }
      AppMethodBeat.o(137227);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(137231);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[] { Float.valueOf(paramp.aSD), Float.valueOf(paramp.pitch) }));
      AppMethodBeat.o(137231);
    }
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(137228);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.cUM() + ", " + paramBoolean + ", " + com.tencent.mm.plugin.music.f.b.a.Ia(paramInt) + "]");
      a locala = a.this;
      if (locala.tVS != null)
      {
        paramBoolean = locala.tVS.ru();
        paramInt = locala.tVS.rt();
        if ((paramBoolean) && (paramInt == 3))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
          if (locala.tWa != null) {
            locala.tWa.cUO();
          }
        }
        for (;;)
        {
          int i = a.f.r(paramBoolean, paramInt);
          if (i == locala.tVW.ksV[3]) {
            break label616;
          }
          ad.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + paramBoolean + "," + paramInt + "]");
          locala.tVW.q(paramBoolean, paramInt);
          if (i != a.f.r(true, 4)) {
            break;
          }
          ad.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
          if (locala.tWa != null) {
            locala.tWa.cUS();
          }
          AppMethodBeat.o(137228);
          return;
          if ((!paramBoolean) && (paramInt == 3) && (locala.tVR == 2))
          {
            ad.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (locala.tWa != null) {
              locala.tWa.cUP();
            }
          }
          else if ((!paramBoolean) && (paramInt == 3) && (locala.tVR == 3))
          {
            ad.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (locala.tWa != null) {
              locala.tWa.cUQ();
            }
          }
        }
        if (locala.tVW.a(new int[] { a.f.r(false, 1), a.f.r(false, 2), a.f.r(false, 3) }, false))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
          if (locala.tWa != null) {
            locala.tWa.cUN();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if ((locala.tVW.a(new int[] { 100, 2, 3 }, true) | locala.tVW.a(new int[] { 2, 100, 3 }, true) | locala.tVW.a(new int[] { 100, 3, 2, 3 }, true)))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
          if (locala.tWa != null) {
            locala.tWa.cUR();
          }
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.tVW.a(new int[] { a.f.r(true, 3), a.f.r(true, 2) }, false))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
          locala.gl(701, locala.getDownloadPercent());
          AppMethodBeat.o(137228);
          return;
        }
        if (locala.tVW.a(new int[] { a.f.r(true, 2), a.f.r(true, 3) }, false))
        {
          ad.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
          locala.gl(702, locala.getDownloadPercent());
        }
      }
      label616:
      AppMethodBeat.o(137228);
    }
    
    public final void rJ() {}
    
    public final void rK() {}
    
    public final void rL()
    {
      AppMethodBeat.i(137230);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
      AppMethodBeat.o(137230);
    }
  }
  
  public static abstract interface b
  {
    public abstract void HI(int paramInt);
    
    public abstract void cUN();
    
    public abstract void cUO();
    
    public abstract void cUP();
    
    public abstract void cUQ();
    
    public abstract void cUR();
    
    public abstract void cUS();
    
    public abstract void gm(int paramInt1, int paramInt2);
  }
  
  public final class c
    implements a.b
  {
    public c() {}
    
    public final void HI(int paramInt)
    {
      AppMethodBeat.i(137238);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137238);
    }
    
    public final void cUN()
    {
      AppMethodBeat.i(137232);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
      if (a.this.tVP != null) {
        a.this.C(a.this.tVP);
      }
      if (a.this.cUL > 0)
      {
        ad.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", new Object[] { Integer.valueOf(a.this.cUL) });
        a.this.ox(a.this.cUL);
      }
      if ((a.this.cUL == 0) && (!a.this.tVS.ru()))
      {
        ad.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
        a.this.tVS.aO(true);
      }
      AppMethodBeat.o(137232);
    }
    
    public final void cUO()
    {
      AppMethodBeat.i(137233);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
      if (a.this.tVP != null) {
        a.this.D(a.this.tVP);
      }
      AppMethodBeat.o(137233);
    }
    
    public final void cUP()
    {
      AppMethodBeat.i(137234);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
      if ((a.this.tVP != null) && (!a.this.tVS.ru())) {
        a.this.F(a.this.tVP);
      }
      AppMethodBeat.o(137234);
    }
    
    public final void cUQ()
    {
      AppMethodBeat.i(137235);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
      if (a.this.tVP != null) {
        a.this.G(a.this.tVP);
      }
      AppMethodBeat.o(137235);
    }
    
    public final void cUR()
    {
      AppMethodBeat.i(137236);
      if (a.this.cUd())
      {
        a.this.tWb = true;
        AppMethodBeat.o(137236);
        return;
      }
      a.b(a.this);
      AppMethodBeat.o(137236);
    }
    
    public final void cUS()
    {
      AppMethodBeat.i(137237);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
      if (a.this.tVP != null) {
        a.this.J(a.this.tVP);
      }
      a.this.rdQ = false;
      a.this.azU.removeMessages(100);
      AppMethodBeat.o(137237);
    }
    
    public final void gm(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(137239);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (a.this.tVP != null) {
        a.this.a(a.this.tVP, paramInt1, paramInt2);
      }
      if (a.this.tVS != null)
      {
        a.this.tVS.aO(false);
        a.this.tVS.stop();
      }
      a.this.rdQ = false;
      a.this.azU.removeMessages(100);
      a locala = a.this;
      locala.bxy += 1;
      if (a.this.bxy == 1) {
        a.a(a.this, a.this.tVP, paramInt1, paramInt2);
      }
      AppMethodBeat.o(137239);
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.source.a, h.a
  {
    private d() {}
    
    public final void a(int paramInt, Format paramFormat, long paramLong) {}
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void a(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, IOException paramIOException, boolean paramBoolean)
    {
      AppMethodBeat.i(177347);
      a.a(a.this, "loadError", paramIOException);
      if ((paramj != null) && (paramFormat != null)) {
        ad.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      a.c(a.this);
      AppMethodBeat.o(177347);
    }
    
    public final void b(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(177348);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
      AppMethodBeat.o(177348);
    }
    
    public final void c(com.google.android.exoplayer2.h.j paramj, int paramInt, Format paramFormat, long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(137242);
      a.a(a.this, "loadError", paramIOException);
      ad.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", paramIOException, "onLoadError", new Object[0]);
      a.c(a.this);
      AppMethodBeat.o(137242);
    }
    
    public final void ty()
    {
      AppMethodBeat.i(137243);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
      a.this.bpZ = true;
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
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.cUM() + "]");
      AppMethodBeat.o(137244);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(137246);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.cUM() + ", " + paramString + "]");
      AppMethodBeat.o(137246);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(137247);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.cUM() + ", " + Format.a(paramFormat) + "]");
      AppMethodBeat.o(137247);
    }
    
    public final void d(com.google.android.exoplayer2.b.d paramd)
    {
      AppMethodBeat.i(137248);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.cUM() + "]");
      AppMethodBeat.o(137248);
    }
    
    public final void dI(int paramInt)
    {
      AppMethodBeat.i(137245);
      ad.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + paramInt + "]");
      AppMethodBeat.o(137245);
    }
  }
  
  static final class f
  {
    int[] ksV;
    
    private f()
    {
      AppMethodBeat.i(137250);
      this.ksV = new int[] { 1, 1, 1, 1 };
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
        int k = this.ksV.length - paramArrayOfInt.length;
        j = k;
        paramBoolean = true;
        label23:
        if (j >= this.ksV.length) {
          return paramBoolean;
        }
        if ((this.ksV[j] & i) != (paramArrayOfInt[(j - k)] & i)) {
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
      ad.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + paramBoolean + "," + paramInt + "], lastState=" + this.ksV[3] + ",newState=" + i);
      if (this.ksV[3] == i)
      {
        AppMethodBeat.o(137251);
        return;
      }
      this.ksV[0] = this.ksV[1];
      this.ksV[1] = this.ksV[2];
      this.ksV[2] = this.ksV[3];
      this.ksV[3] = i;
      ad.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.ksV[0] + "," + this.ksV[1] + "," + this.ksV[2] + "," + this.ksV[3] + "]");
      AppMethodBeat.o(137251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */