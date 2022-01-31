package com.tencent.mm.plugin.music.d;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d.a;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.music.e.d;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  extends com.tencent.mm.plugin.music.f.a
  implements d.a, e.a
{
  boolean aSw;
  private long aZw;
  int aZy;
  Handler bTu;
  private String ceU;
  boolean oXo;
  private long oXt;
  e oYI;
  private com.tencent.mm.aw.c oYJ;
  int oYK;
  v oYL;
  private com.google.android.exoplayer2.g.c oYM;
  private l oYN;
  private com.google.android.exoplayer2.h.g.a oYO;
  private i oYP;
  a.f oYQ;
  a.a oYR;
  a.e oYS;
  d oYT;
  a.b oYU;
  public boolean oYV;
  int startTime;
  protected String userAgent;
  
  public a()
  {
    AppMethodBeat.i(137502);
    this.oYK = 0;
    this.ceU = "";
    this.aZy = 0;
    this.startTime = 0;
    this.oXt = 0L;
    this.aSw = false;
    this.oYQ = new a.f((byte)0);
    this.oYR = new a.a(this, (byte)0);
    this.oYS = new a.e(this, (byte)0);
    this.oYT = new d((byte)0);
    this.oYU = new a.c(this);
    this.bTu = new a.1(this, Looper.myLooper());
    this.oYV = false;
    com.tencent.mm.plugin.music.f.b.a.bWk();
    AppMethodBeat.o(137502);
  }
  
  private void b(e parame, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137524);
    if (this.paA != null) {
      this.paA.d(parame, paramInt1, paramInt2);
    }
    AppMethodBeat.o(137524);
  }
  
  private boolean bUB()
  {
    AppMethodBeat.i(137510);
    if (this.oYL != null)
    {
      boolean bool = this.oYL.isLoading();
      AppMethodBeat.o(137510);
      return bool;
    }
    AppMethodBeat.o(137510);
    return false;
  }
  
  public final void a(e parame, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(137519);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.paz = "error";
    ki localki = new ki();
    localki.cAc.action = 4;
    localki.cAc.czW = parame;
    localki.cAc.state = "error";
    localki.cAc.duration = getDuration();
    localki.cAc.cAe = true;
    parame = localki.cAc;
    ab.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", new Object[] { Integer.valueOf(paramInt1) });
    StringBuilder localStringBuilder;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
      parame.errCode = paramInt1;
      parame = localki.cAc;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errCode:" + paramInt2 + ", err:");
      switch (paramInt2)
      {
      }
      break;
    }
    for (;;)
    {
      parame.errMsg = localStringBuilder.toString();
      com.tencent.mm.sdk.b.a.ymk.a(localki, Looper.getMainLooper());
      AppMethodBeat.o(137519);
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
  
  public final boolean aiw()
  {
    AppMethodBeat.i(137509);
    if (this.oYL == null)
    {
      AppMethodBeat.o(137509);
      return false;
    }
    switch (this.oYL.mJ())
    {
    case 2: 
    default: 
      AppMethodBeat.o(137509);
      return false;
    }
    boolean bool = this.oYL.mK();
    AppMethodBeat.o(137509);
    return bool;
  }
  
  public final boolean aix()
  {
    return (this.oXo) && (this.oYV);
  }
  
  public final boolean aiy()
  {
    AppMethodBeat.i(137511);
    if ((this.oXo) && (!bUB()))
    {
      AppMethodBeat.o(137511);
      return true;
    }
    AppMethodBeat.o(137511);
    return false;
  }
  
  public final void b(Metadata paramMetadata)
  {
    AppMethodBeat.i(137522);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
    com.tencent.mm.plugin.music.f.b.a.a(paramMetadata, "  ");
    ab.i("MicroMsg.Music.ExoMusicPlayer", "]");
    AppMethodBeat.o(137522);
  }
  
  public final void bUA()
  {
    AppMethodBeat.i(137507);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.bVJ().bUj();
    AppMethodBeat.o(137507);
  }
  
  public final int bUH()
  {
    AppMethodBeat.i(137513);
    if (this.oYL != null)
    {
      int i = (int)this.oYL.getCurrentPosition();
      AppMethodBeat.o(137513);
      return i;
    }
    AppMethodBeat.o(137513);
    return 0;
  }
  
  public final void bUm()
  {
    AppMethodBeat.i(137506);
    this.oYV = true;
    ab.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    if (this.oYL != null)
    {
      this.oYK = 2;
      this.oYL.aC(false);
    }
    AppMethodBeat.o(137506);
  }
  
  public final boolean bUn()
  {
    return true;
  }
  
  public final com.tencent.mm.aw.c bUo()
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(137517);
    int n = getDuration();
    int i1 = bUH();
    boolean bool = aiw();
    int j = getDownloadPercent();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = n;
    if ((this.oYP instanceof h))
    {
      j = n;
      if (!this.aSw) {
        j = 0;
      }
    }
    com.tencent.mm.aw.c localc;
    if (this.oYJ != null)
    {
      localc = this.oYJ;
      if (bool) {
        k = 1;
      }
      localc.t(j, i1, k, i);
    }
    for (;;)
    {
      this.oYJ.cAe = true;
      this.oYJ.fKg = bWa();
      localc = this.oYJ;
      AppMethodBeat.o(137517);
      return localc;
      k = m;
      if (bool) {
        k = 1;
      }
      this.oYJ = new com.tencent.mm.aw.c(j, i1, k, i);
    }
  }
  
  public final void bVk()
  {
    AppMethodBeat.i(137504);
    this.paA = ((d)b.am(d.class));
    this.paB = k.bVH().oZe;
    AppMethodBeat.o(137504);
  }
  
  final String bVl()
  {
    AppMethodBeat.i(137523);
    String str = com.tencent.mm.plugin.music.f.b.a.kK(SystemClock.elapsedRealtime() - this.aZw);
    AppMethodBeat.o(137523);
    return str;
  }
  
  final void eO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137520);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.oYU != null) {
      this.oYU.eQ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(137520);
  }
  
  final void eP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137521);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    if ((this.oYU != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.oYU.Ae(paramInt2);
    }
    AppMethodBeat.o(137521);
  }
  
  public final void f(e parame)
  {
    AppMethodBeat.i(137503);
    super.f(parame);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.oXt;
    if ((this.oYI != null) && (this.oYI.e(parame)) && (l2 <= 1000L))
    {
      this.oYI = parame;
      ab.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.ceU, Long.valueOf(l2) });
      AppMethodBeat.o(137503);
      return;
    }
    if (parame == null)
    {
      ab.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
      AppMethodBeat.o(137503);
      return;
    }
    if (this.paA != null) {
      this.paA.s(parame);
    }
    this.oXt = l1;
    ab.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(parame.startTime) });
    if ((this.oYL != null) && (aiw())) {
      this.oYL.stop();
    }
    this.aZy = 0;
    this.startTime = parame.startTime;
    this.aZw = SystemClock.elapsedRealtime();
    this.oYI = parame;
    y(this.oYI);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.startTime) });
    al.d(new a.2(this));
    AppMethodBeat.o(137503);
  }
  
  public final int getDownloadPercent()
  {
    AppMethodBeat.i(137515);
    if (this.oYL != null)
    {
      int i = this.oYL.getBufferedPercentage();
      AppMethodBeat.o(137515);
      return i;
    }
    AppMethodBeat.o(137515);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137514);
    if (this.oYL != null)
    {
      int i = (int)this.oYL.getDuration();
      AppMethodBeat.o(137514);
      return i;
    }
    AppMethodBeat.o(137514);
    return 0;
  }
  
  public final boolean lN(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(137516);
    int i = getDuration();
    ab.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i < 0) || (paramInt > i))
    {
      ab.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(137516);
      return false;
    }
    if (this.oYL != null)
    {
      F(this.oYI);
      a.f localf = this.oYQ;
      if ((this.oYQ.bIR[3] & 0xF0000000) != 0) {
        bool = true;
      }
      localf.d(bool, 100);
      this.oYK = 4;
      this.oYL.seekTo(paramInt);
    }
    AppMethodBeat.o(137516);
    return true;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137505);
    this.oYV = false;
    ab.i("MicroMsg.Music.ExoMusicPlayer", "pause");
    if (this.oYL != null)
    {
      this.oYK = 2;
      this.oYL.aC(false);
    }
    AppMethodBeat.o(137505);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137518);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "release");
    this.bTu.removeMessages(100);
    bUl();
    if (this.oYL != null)
    {
      this.oYL.b(this.oYR);
      this.oYL.axr.remove(this);
      this.oYL.release();
      this.oYL = null;
    }
    if (this.oYP != null)
    {
      this.oYP.oZ();
      this.oYP = null;
    }
    this.oYM = null;
    this.oYO = null;
    AppMethodBeat.o(137518);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137508);
    this.aZy = 0;
    ab.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bUB()), Boolean.valueOf(aiw()) });
    if (this.oYL != null)
    {
      if (!k.bVJ().requestFocus()) {
        break label92;
      }
      this.oYK = 1;
      this.oYL.aC(true);
      B(this.oYI);
    }
    for (;;)
    {
      this.oXo = true;
      AppMethodBeat.o(137508);
      return;
      label92:
      ab.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
    }
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137512);
    ab.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
    try
    {
      if (this.oYL != null)
      {
        this.oYK = 3;
        this.oYL.aC(false);
        this.oYL.stop();
        D(this.oYI);
      }
      k.bVJ().bUj();
      this.oXo = false;
      this.oYV = false;
      this.bTu.removeMessages(100);
      AppMethodBeat.o(137512);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
        d(this.oYI, 504);
        b(this.oYI, -4005, -42);
      }
    }
  }
  
  final class d
    implements com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.g.a
  {
    private d() {}
    
    public final void a(j paramj, Format paramFormat, IOException paramIOException)
    {
      AppMethodBeat.i(137490);
      a.a(a.this, "loadError", paramIOException);
      if ((paramj != null) && (paramFormat != null)) {
        ab.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", new Object[] { paramj.uri, paramFormat.toString() });
      }
      a.b(a.this);
      AppMethodBeat.o(137490);
    }
    
    public final void oM() {}
    
    public final void oN()
    {
      AppMethodBeat.i(137491);
      ab.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
      AppMethodBeat.o(137491);
    }
    
    public final void oO() {}
    
    public final void oP() {}
    
    public final void oQ()
    {
      AppMethodBeat.i(137493);
      ab.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
      a.this.aSw = true;
      AppMethodBeat.o(137493);
    }
    
    public final void onLoadError(IOException paramIOException)
    {
      AppMethodBeat.i(137492);
      a.a(a.this, "loadError", paramIOException);
      ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", paramIOException, "onLoadError", new Object[0]);
      a.b(a.this);
      AppMethodBeat.o(137492);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.d.a
 * JD-Core Version:    0.7.0.1
 */