package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.h.f.a;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.v;
import com.tencent.mm.av.c;
import com.tencent.mm.av.e;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class a
  extends com.tencent.mm.plugin.music.f.a
  implements d.a, e.a
{
  boolean aLc = false;
  protected String aRC;
  private long aRW;
  int aRY = 0;
  public Handler gmh = new a.1(this, Looper.myLooper());
  boolean mxr;
  private String mxv = "";
  private long mxx = 0L;
  e myB;
  private c myC;
  int myD = 0;
  public v myE;
  public com.google.android.exoplayer2.g.b myF;
  private com.google.android.exoplayer2.h.k myG;
  public f.a myH;
  public f myI;
  a.f myJ = new a.f((byte)0);
  public a.a myK = new a.a(this, (byte)0);
  a.e myL = new a.e(this, (byte)0);
  d myM = new d((byte)0);
  a.b myN = new a.c(this);
  public boolean myO = false;
  int startTime = 0;
  
  public a()
  {
    com.tencent.mm.plugin.music.f.b.a.bnN();
  }
  
  private boolean bmy()
  {
    if (this.myE != null) {
      return this.myE.isLoading();
    }
    return false;
  }
  
  public final boolean Pu()
  {
    if (this.myE == null) {
      return false;
    }
    switch (this.myE.kD())
    {
    case 2: 
    default: 
      return false;
    }
    return this.myE.kE();
  }
  
  public final boolean Pv()
  {
    return (this.mxr) && (!bmy());
  }
  
  public final void a(Metadata paramMetadata)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
    com.tencent.mm.plugin.music.f.b.a.a(paramMetadata, "  ");
    y.i("MicroMsg.Music.ExoMusicPlayer", "]");
  }
  
  final void a(e parame, int paramInt1, int paramInt2)
  {
    if (this.mAu != null) {
      this.mAu.c(parame, paramInt1, paramInt2);
    }
  }
  
  public final int bmA()
  {
    if (this.myE != null) {
      return (int)this.myE.getCurrentPosition();
    }
    return 0;
  }
  
  protected final void bmO()
  {
    this.mAu = ((d)com.tencent.mm.plugin.music.f.c.b.Q(d.class));
    this.mAv = com.tencent.mm.plugin.music.e.k.bnl().myY;
  }
  
  final String bmP()
  {
    return com.tencent.mm.plugin.music.f.b.a.fm(SystemClock.elapsedRealtime() - this.aRW);
  }
  
  public final void bmi()
  {
    this.myO = true;
    y.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.myE != null)
    {
      this.myD = 2;
      this.myE.at(false);
    }
  }
  
  public final boolean bmj()
  {
    return (this.mxr) && (this.myO);
  }
  
  public final boolean bmk()
  {
    return true;
  }
  
  public final c bml()
  {
    int m = 0;
    int k = 0;
    int n = getDuration();
    int i1 = bmA();
    boolean bool = Pu();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.myI instanceof h))
    {
      j = n;
      if (!this.aLc) {
        j = 0;
      }
    }
    if (this.myC != null)
    {
      c localc = this.myC;
      if (bool) {
        k = 1;
      }
      localc.l(j, i1, k, i);
    }
    for (;;)
    {
      this.myC.bSC = true;
      this.myC.euu = this.mAt;
      return this.myC;
      k = m;
      if (bool) {
        k = 1;
      }
      this.myC = new c(j, i1, k, i);
    }
  }
  
  public final void bmw()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    com.tencent.mm.plugin.music.e.k.bnn().bmh();
  }
  
  final void jdMethod_do(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.myN != null) {
      this.myN.dq(paramInt1, paramInt2);
    }
  }
  
  final void dp(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.myN != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.myN.uI(paramInt2);
    }
  }
  
  public final void f(e parame)
  {
    super.f(parame);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.mxx;
    if ((this.myB != null) && (this.myB.e(parame)) && (l2 <= 1000L))
    {
      this.myB = parame;
      y.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.mxv, Long.valueOf(l2) });
      return;
    }
    if (parame == null)
    {
      y.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      return;
    }
    if (this.mAu != null) {
      this.mAu.s(parame);
    }
    this.mxx = l1;
    y.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(parame.startTime) });
    if ((this.myE != null) && (Pu())) {
      this.myE.stop();
    }
    this.aRY = 0;
    this.startTime = parame.startTime;
    this.aRW = SystemClock.elapsedRealtime();
    this.myB = parame;
    y(this.myB);
    y.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.startTime) });
    ai.d(new a.2(this));
  }
  
  public final int getDownloadPercent()
  {
    if (this.myE != null) {
      return this.myE.getBufferedPercentage();
    }
    return 0;
  }
  
  public final int getDuration()
  {
    if (this.myE != null) {
      return (int)this.myE.getDuration();
    }
    return 0;
  }
  
  public final boolean iV(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i = getDuration();
    y.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      y.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      bool1 = false;
    }
    while (this.myE == null) {
      return bool1;
    }
    F(this.myB);
    a.f localf = this.myJ;
    bool1 = bool2;
    if ((this.myJ.myQ[3] & 0xF0000000) != 0) {
      bool1 = true;
    }
    localf.s(bool1, 100);
    this.myD = 4;
    this.myE.seekTo(paramInt);
    return true;
  }
  
  public final void pause()
  {
    this.myO = false;
    y.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.myE != null)
    {
      this.myD = 2;
      this.myE.at(false);
    }
  }
  
  public final void resume()
  {
    this.aRY = 0;
    y.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bmy()), Boolean.valueOf(Pu()) });
    if (this.myE != null)
    {
      if (!com.tencent.mm.plugin.music.e.k.bnn().requestFocus()) {
        break label80;
      }
      this.myD = 1;
      this.myE.at(true);
      B(this.myB);
    }
    for (;;)
    {
      this.mxr = true;
      return;
      label80:
      y.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    y.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
    try
    {
      if (this.myE != null)
      {
        this.myD = 3;
        this.myE.at(false);
        this.myE.stop();
        D(this.myB);
      }
      com.tencent.mm.plugin.music.e.k.bnn().bmh();
      this.mxr = false;
      this.myO = false;
      this.gmh.removeMessages(100);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.myB, 504);
        a(this.myB, -4005, -42);
      }
    }
  }
  
  private final class d
    implements com.google.android.exoplayer2.source.a
  {
    private d() {}
    
    public final void a(i parami, Format paramFormat, IOException paramIOException)
    {
      a.a(a.this, "loadError", paramIOException);
      if ((parami != null) && (paramFormat != null)) {
        y.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { parami.uri, paramFormat.toString() });
      }
      a.this.jdMethod_do(-4004, -40);
    }
    
    public final void mv()
    {
      y.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
    }
    
    public final void mw()
    {
      y.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
      a.this.aLc = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */